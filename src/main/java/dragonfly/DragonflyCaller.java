package dragonfly;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

import org.apache.tapestry.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import dragonfly.abcp.api.AbcpInvoke;
import dragonfly.abcp.api.BpaasApiDLL.OnAbcpFinish;
import dragonfly.abcp.api.BpaasApiDLL.OnAbcpProcess;
import dragonfly.abcp.api.DragonFlyConsts;
import dragonfly.abcp.api.DragonFlyGoods;
import dragonfly.abcp.api.DragonFlyMember;
import dragonfly.abcp.api.DragonFlyShowInfoParam;
import dragonfly.abcp.api.DragonFlyTrade;
import dragonfly.abcp.api.IDragonFlyCallBack;
import dragonfly.abcp.api.builder.DragonFlyMemberBuilder;
import dragonfly.abcp.api.builder.DragonFlyTradeBuilder;
import dragonfly.abcp.demo.AbcpTaskTemplatePos;

/**
 * </br>
 * Created by yangxiaohua on 2024/8/19.
 */
public class DragonflyCaller {
  private static volatile boolean running = true;
  private static final int HEARTBEAT_PORT = 9999;
  private static final int BUSINESS_PORT = 8888;
  private static final int TIMEOUT_MS = 5000; // 10 seconds timeout for heartbeat

  public static void main(String[] args) {

    Thread heartbeatListener = new Thread(() -> listenForHeartbeats());
    Thread businessListener = new Thread(() -> listenForBusinessCommands());

    heartbeatListener.start();
    businessListener.start();

    init();

    try {
      heartbeatListener.join();
      businessListener.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  private static void listenForHeartbeats() {
    try (ServerSocket serverSocket = new ServerSocket(HEARTBEAT_PORT)) {
      serverSocket.setSoTimeout(TIMEOUT_MS);
      System.out.println("Listening for heartbeat signals on port " + HEARTBEAT_PORT + "...");

      while (running) {
        try (Socket clientSocket = serverSocket.accept();
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

          String command = in.readLine();
          if ("heartbeat".equalsIgnoreCase(command)) {
            System.out.println("Heartbeat received.");
          } else {
            System.out.println("Unknown heartbeat command.");
          }
        } catch (java.net.SocketTimeoutException e) {
          System.out.println("No heartbeat received within timeout. Exiting.");
          running = false;
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private static void listenForBusinessCommands() {
    try (ServerSocket serverSocket = new ServerSocket(BUSINESS_PORT)) {
      System.out.println("Listening for business commands on port " + BUSINESS_PORT + "...");

      while (running) {
        try (Socket clientSocket = serverSocket.accept();
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             OutputStreamWriter out = new OutputStreamWriter(clientSocket.getOutputStream())) {

          String command = in.readLine();
          if ("startService".equalsIgnoreCase(command)) {
            System.out.println("startService command received.");
            // Handle startService command
          } else if ("stopService".equalsIgnoreCase(command)) {
            running = false;
          } else if ("showProductInfo".equalsIgnoreCase(command)) {
            System.out.println("showProductInfo command received.");
            showProductInfo();
          } else {
            out.write("Unknown command\n");
            out.flush();
          }
        } catch (SocketException se) {
          // This exception will be thrown if serverSocket is closed
          if (running) {
            se.printStackTrace();
          }
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private static final String appId = "2021003145690928"; // pelase fetch this from abcp server platform!
  private static final String opendCardAppId = "2019051564537988"; // pelase fetch this from abcp server platform!

  private static final String appVersion = "*"; // pelase fetch this from abcp server platform!
  private static final String secret = "f59779e5-909e-425b-9f6e-1c4be44b39cc";

  private static void init() {
    try {
      System.out.println("start init ");

      objectMapper = new ObjectMapper();
      objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
      objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

      AbcpInvoke.getInstance().init();
      JSONObject jsonInit = new JSONObject();
      jsonInit.put("bpaasSign", secret);
      jsonInit.put("encode_sys_ansi", 1);
      String jsonStr = jsonInit.toString();
      System.out.println("jsonStr:" + jsonStr);
      Thread.sleep(5000);

      AbcpInvoke.getInstance().abcpInit(appId, appVersion, jsonStr, new OnAbcpFinish() {
        @Override
        public void on_finish(int p_arg, int code, String subCode, String subMsg, String result) {
          System.out.printf("abcp_init finish: [%d:%s] %s %n", code, subCode, result);
          if (code == 1000 && "E00000".equals(subCode)) {
            System.out.println("init 完成");
          }
        }
      }, new OnAbcpProcess() {
        @Override
        public void on_process(int p_arg, int code, String subCode, String subMsg, String result) {
          System.out.printf("abcp_init process: [%d:%s] %n", code, subCode);
        }
      });

    } catch (Throwable e) {
      e.printStackTrace();
    }
  }

  public static void startService(String serviceCode, String requestJson, OnAbcpFinish callbackOnFinish,
    OnAbcpProcess callbackOnProcess) {
    // 服务启动的逻辑
    System.out.println("startService called with serviceCode: " + serviceCode + ", requestJson: " + requestJson);
    callbackOnProcess.on_process(1, 1000, "E00000", "成功", "6");
    // 模拟处理完成
    callbackOnFinish.on_finish(1, 1000, "E00000", "成功", "6");
  }

  private static JSONObject buildCommonParam(String page, String operateType) {
    JSONObject object = new JSONObject();
    object.put("page", page);
    object.put("operateType", operateType);
    object.put("bpaasExecutor", DragonFlyConsts.BPAASEXECUTOR);
    object.put("bpaasSign", secret);
    return object;
  }

  private static ObjectMapper objectMapper;

  public static void showProductInfo() {
    try {
      JSONObject object = buildCommonParam("sku", "show");

      DragonFlyShowInfoParam param = new DragonFlyShowInfoParam();
      DragonFlyGoods goods = new DragonFlyGoods();
      goods.setName("酸奶");
      //      goods.setPrice("￥4.00");
      goods.setActualPrice("￥3.00");
      //      goods.setFinPrice("￥4.00");
      goods.setFinActualPrice("￥3.00");
      goods.setNumber("x3");
      goods.setProductCode("1102002322");
      goods.setAttribute("一个东西");
      goods.setUnit("件");
      param.getGoods().add(goods);

      DragonFlyTrade trade =
        DragonFlyTradeBuilder.aDragonFlyTrade().withTradeNo("202210090001").withChange("0.00").withTotalAmount("￥12"
            + ".00")
          .withActualAmount("￥9.00").withActualReceipts("￥9.00").build();
      param.setTrade(trade);

      DragonFlyMember member =
        DragonFlyMemberBuilder.aDragonFlyMember().withName("yang").withPhoneNo("17625649535").withNo("176")
          .withPoint("50000").withBalance("300.00").build();
      param.setMember(member);

      object.put("params", objectMapper.writeValueAsString(param));
      String serviceParams = object.toString();

      AbcpTaskTemplatePos.Instance(appId).start(serviceParams, new IDragonFlyCallBack() {
        @Override
        public void onFinish(int code, String subCode, String subMsg, String result) {
          System.out.printf("sku_show finish: [%d:%s] %s %n", code, subCode, result);
        }
      });
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void stopService() {
    System.out.println("stopService called.");
  }
}
