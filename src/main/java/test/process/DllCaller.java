package test.process;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

import dragonfly.abcp.api.BpaasApiDLL.OnAbcpFinish;
import dragonfly.abcp.api.BpaasApiDLL.OnAbcpProcess;

public class DllCaller {
  private static boolean running = true;

  public static void main(String[] args) {
    init();

    try (ServerSocket serverSocket = new ServerSocket(9999)) {
      System.out.println("DllCaller is waiting for commands...");

      while (running) {
        try (Socket clientSocket = serverSocket.accept();
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             OutputStreamWriter out = new OutputStreamWriter(clientSocket.getOutputStream())) {

          String command = in.readLine();
          if ("startService".equalsIgnoreCase(command)) {
            // 读取参数
            String serviceCode = in.readLine();
            String requestJson = in.readLine();

            // 调用startService
            startService(serviceCode, requestJson, new OnAbcpFinish() {
              @Override
              public void on_finish(int p_arg, int code, String sub_code, String sub_msg, String result) {
                try {
                  out.write("onFinish: " + result + "\n");
                  out.flush();
                } catch (Exception e) {
                  e.printStackTrace();
                }
              }
            }, new OnAbcpProcess() {
              @Override
              public void on_process(int p_arg, int code, String sub_code, String sub_msg, String result) {
                try {
                  out.write("onProcess: " + result + "\n");
                  out.flush();
                } catch (Exception e) {
                  e.printStackTrace();
                }
              }
            });
          } else if ("stopService".equalsIgnoreCase(command)) {
            stopService();
            out.write("stopService executed\n");
            running = false;
          } else {
            out.write("Unknown command\n");
          }
          out.flush();
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void init() {
    System.out.println("DllCaller initialized.");
  }

  public static void startService(String serviceCode, String requestJson, OnAbcpFinish callbackOnFinish,
    OnAbcpProcess callbackOnProcess) {
    // 服务启动的逻辑
    System.out.println("startService called with serviceCode: " + serviceCode + ", requestJson: " + requestJson);
    callbackOnProcess.on_process(1, 1000, "E00000", "成功", "6");
    // 模拟处理完成
    callbackOnFinish.on_finish(1, 1000, "E00000", "成功", "6");
  }

  public static void stopService() {
    System.out.println("stopService called.");
  }
}


