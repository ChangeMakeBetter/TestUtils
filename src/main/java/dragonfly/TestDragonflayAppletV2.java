/**
 * 版权所有(C)，上海海鼎信息工程股份有限公司，2019，所有权利保留。 项目名：	jpos-test 文件名：	TestFrog.java 模块说明： 修改历史： 2019-08-20 - yangxiaohua - 创建。
 */
package dragonfly;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import org.apache.tapestry.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import dragonfly.abcp.api.AbcpInvoke;
import dragonfly.abcp.api.BpaasApiDLL.BztidCallback;
import dragonfly.abcp.api.BpaasApiDLL.OnAbcpFinish;
import dragonfly.abcp.api.BpaasApiDLL.OnAbcpProcess;
import dragonfly.abcp.api.DragonFlyConsts;
import dragonfly.abcp.api.DragonFlyFaceMemberResult;
import dragonfly.abcp.api.DragonFlyFacePayParam;
import dragonfly.abcp.api.DragonFlyFacePayParam.DragonFlyFacePayParamBuilder;
import dragonfly.abcp.api.DragonFlyFacePayResult;
import dragonfly.abcp.api.DragonFlyFacePayResultPageParam;
import dragonfly.abcp.api.DragonFlyFacePayResultPageParam.DragonFlyFacePayResultPageParamBuilder;
import dragonfly.abcp.api.DragonFlyGoods;
import dragonfly.abcp.api.DragonFlyMember;
import dragonfly.abcp.api.DragonFlyOpenCardParam;
import dragonfly.abcp.api.DragonFlyOpenCardParam.DragonFlyOpenCardParamBuilder;
import dragonfly.abcp.api.DragonFlyPayTrade.DragonFlyPayTradeBuilder;
import dragonfly.abcp.api.DragonFlyResultMap;
import dragonfly.abcp.api.DragonFlyShowInfoParam;
import dragonfly.abcp.api.DragonFlyTrade;
import dragonfly.abcp.api.IDragonFlyCallBack;
import dragonfly.abcp.api.builder.DragonFlyMemberBuilder;
import dragonfly.abcp.api.builder.DragonFlyTradeBuilder;
import dragonfly.abcp.demo.AbcpTaskTemplatePos;

public class TestDragonflayAppletV2 extends JFrame {
  private static final long serialVersionUID = -663749975493575404L;

  private ObjectMapper objectMapper;

  public static void main(String[] args) throws Exception {
    System.out.println(System.getProperty("HD_HOME"));
    // System.setProperty("HD_HOME", "D:/hdhome/hdpos46std");
    SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
        TestDragonflayAppletV2 f = new TestDragonflayAppletV2();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
      }
    });

  }

  JTextArea ta = new JTextArea();

  public TestDragonflayAppletV2() {
    super("TestDragonflayAppletV2");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    ta.setFont(new Font("宋体", 0, 12));
    ta.append("---output---\n");
    JScrollPane sp = new JScrollPane(ta);
    sp.setPreferredSize(new Dimension(400, 150));
    sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

    JPanel pd = new JPanel(new GridBagLayout());
    add(pd, new DevicePanel(), 0, 0);

    JPanel wp = new JPanel(new BorderLayout());
    wp.add(sp, BorderLayout.NORTH);
    wp.add(pd, BorderLayout.EAST);

    setContentPane(wp);
    pack();

    objectMapper = new ObjectMapper();
    objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

  }

  private void add(Container cntr, Component comp, int x, int y) {
    GridBagConstraints c = new GridBagConstraints();
    c.anchor = GridBagConstraints.NORTHWEST;
    c.gridx = x;
    c.gridy = y;
    cntr.add(comp, c);
  }

  class DevicePanel extends JPanel implements ActionListener {
    private static final long serialVersionUID = 1L;
    JTextArea text = new JTextArea(5, 40);
    JTextField printFontSizeFiled = new JTextField(10);

    DevicePanel() {
      super(new BorderLayout());
      setBorder(BorderFactory.createTitledBorder("DragonFly"));

      text.append("2");
      printFontSizeFiled.setText("8");

      JPanel p1 = new JPanel(new BorderLayout());
      JScrollPane sp = new JScrollPane(text);
      p1.add(sp, BorderLayout.CENTER);
      add(p1, BorderLayout.CENTER);

      JPanel p = new JPanel(new GridLayout(0, 1));
      JButton button;

      button = new JButton("init");
      button.setActionCommand("init");
      button.addActionListener(this);
      p.add(button);

      button = new JButton("显示商品信息");
      button.setActionCommand("显示商品信息");
      button.addActionListener(this);
      p.add(button);

      button = new JButton("会员登录");
      button.setActionCommand("会员登录");
      button.addActionListener(this);
      p.add(button);

      button = new JButton("刷脸支付");
      button.setActionCommand("刷脸支付");
      button.addActionListener(this);
      p.add(button);

      button = new JButton("修改金额");
      button.setActionCommand("修改金额");
      button.addActionListener(this);
      p.add(button);

      button = new JButton("支付结果页");
      button.setActionCommand("支付结果页");
      button.addActionListener(this);
      p.add(button);

      button = new JButton("支付结果失败页");
      button.setActionCommand("支付结果失败页");
      button.addActionListener(this);
      p.add(button);

      button = new JButton("获取biztid");
      button.setActionCommand("获取biztid");
      button.addActionListener(this);
      p.add(button);

      button = new JButton("stop");
      button.setActionCommand("stop");
      button.addActionListener(this);
      p.add(button);

      button = new JButton("stopFaceVerify");
      button.setActionCommand("stopFaceVerify");
      button.addActionListener(this);
      p.add(button);

      button = new JButton("stopOpenCard");
      button.setActionCommand("stopOpenCard");
      button.addActionListener(this);
      p.add(button);

      add(p, BorderLayout.EAST);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      try {
        if ("init".equals(e.getActionCommand())) {
          init();
        } else if ("显示商品信息".equals(e.getActionCommand())) {
          showProductInfo();
        } else if ("刷脸支付".equals(e.getActionCommand())) {
          smilePay(false, "1.00");
        } else if ("修改金额".equals(e.getActionCommand())) {
          smilePay(true, "2.00");
        } else if ("会员登录".equals(e.getActionCommand())) {
          memberLogin();
        } else if ("支付结果页".equals(e.getActionCommand())) {
          payResultPage();
        } else if ("支付结果失败页".equals(e.getActionCommand())) {
          payResultPageFail();
        } else if ("获取biztid".equals(e.getActionCommand())) {
          getBiztid();
        } else if ("stop".equals(e.getActionCommand())) {
          stop(DragonFlyConsts.PAGE_ALL);
        } else if ("stopFaceVerify".equals(e.getActionCommand())) {
          stop(DragonFlyConsts.PAGE_FACEVERIFY);
        } else if ("stopOpenCard".equals(e.getActionCommand())) {
          stop(DragonFlyConsts.PAGE_OPENCARD);
        } else {
          // doNothing
        }
      } catch (Exception ex) {
      }
    }

  }

  private final String appId = "2021003145690928"; // pelase fetch this from abcp server platform!
  private final String opendCardAppId = "2019051564537988"; // pelase fetch this from abcp server platform!

  private final String appVersion = "*"; // pelase fetch this from abcp server platform!
  private final String secret = "f59779e5-909e-425b-9f6e-1c4be44b39cc";
  private boolean initSuccessed = false;

  private void init() {
    try {
      AbcpInvoke.getInstance().init();
      JSONObject jsonInit = new JSONObject();
      jsonInit.put("bpaasSign", secret);
      String jsonStr = jsonInit.toString();
      System.out.println("jsonStr:" + jsonStr);

      System.out.println("start init ");
      AbcpInvoke.getInstance().abcpInit(appId, appVersion, jsonStr, new OnAbcpFinish() {
        @Override
        public void on_finish(int p_arg, int code, String subCode, String subMsg, String result) {
          System.out.printf("abcp_init finish: [%d:%s] %s %n", code, subCode, result);
          if (code == 1000 && "E00000".equals(subCode)) {
            initSuccessed = true;
            ta.append("init 完成");
          }
        }
      }, new OnAbcpProcess() {
        @Override
        public void on_process(int p_arg, int code, String subCode, String subMsg, String result) {
          System.out.printf("abcp_init process: [%d:%s] %n", code, subCode);
        }
      });
    } catch (Exception e) {
      ta.append(e.getMessage());
    }
  }

  private void getBiztid() {
    try {
      checkInit();
      AbcpInvoke.getInstance().getBiztid(new BztidCallback() {
        @Override
        public void callback(int p_arg, String biztid) {
          System.out.println(biztid);
          ta.append("biztid:" + biztid);
        }
      });
    } catch (Exception e) {
      ta.append(e.getMessage());
    }
  }

  private void memberLogin() {
    try {
      checkInit();
      JSONObject object = buildCommonParam("opencard", "show");

      DragonFlyOpenCardParam param =
        DragonFlyOpenCardParamBuilder.aDragonFlyOpenCardParam().withAppId(opendCardAppId)
          .withCallbackType(DragonFlyOpenCardParam.CALLBACKTYPE_SPI).withProviderId("2088202431349624")
          .withTemplateId("20210704000000002770322000300622").build();

      object.put("params", objectMapper.writeValueAsString(param));
      String serviceParams = object.toString();

      AbcpTaskTemplatePos.Instance(appId).start(serviceParams, new IDragonFlyCallBack() {
        @Override
        public void onFinish(int code, String subCode, String subMsg, String result) {
          try {
            DragonFlyFaceMemberResult r = objectMapper.readValue(result, DragonFlyFaceMemberResult.class);
            ta.append(r.toString());
          } catch (Exception e) {
            ta.append(e.getMessage());
          }
        }
      });
    } catch (Exception e) {
      ta.append(e.getMessage());
    }
  }

  private void showProductInfo() {
    try {
      checkInit();
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
          //TODO
        }
      });
    } catch (Exception e) {
      ta.append(e.getMessage());
    }
  }

  private void checkInit() throws Exception {
    if (!initSuccessed) {
      System.out.println("初始化未完成");
    }
  }

  private void smilePay(boolean changeAmt, String amt) {
    try {
      checkInit();
      // 根据changeAmt判断，传入的operateType
      JSONObject object = buildCommonParam("faceVerify", changeAmt ? "update" : "verify");
      DragonFlyFacePayParam param =
        DragonFlyFacePayParamBuilder.aDragonFlyFacePayParam().withAmount(amt).withEnableScan(true)
          .withCashierType(changeAmt ? "updateAmount" : "").build();

      object.put("params", objectMapper.writeValueAsString(param));
      AbcpTaskTemplatePos.Instance(appId).start(object.toString(), new IDragonFlyCallBack() {
        @Override
        public void onFinish(int code, String subCode, String subMsg, String result) {
          try {
            DragonFlyResultMap r = objectMapper.readValue(result, DragonFlyResultMap.class);
            DragonFlyFacePayResult facePayResult = objectMapper.readValue(r.getResult().getExtInfo(),
              DragonFlyFacePayResult.class);

            ta.append(r.toString());
          } catch (Exception e) {
            ta.append(e.getMessage());
          }
        }
      });
    } catch (Exception e) {
      ta.append(e.getMessage());
    }
  }

  private void payResultPage() {
    try {
      checkInit();
      JSONObject object = buildCommonParam(DragonFlyConsts.PAGE_PAYRESULT, DragonFlyConsts.OPER_SHOW);

      DragonFlyFacePayResultPageParam param =
        DragonFlyFacePayResultPageParamBuilder.aDragonFlyFacePayResultPageParam().withPayTrade(
          DragonFlyPayTradeBuilder.aDragonFlyPayTrade().withPayStatus(DragonFlyConsts.PAYSTATUS_PAYING)
            .withTradeNo("202210090001").build()).build();

      object.put("params", objectMapper.writeValueAsString(param));
      AbcpTaskTemplatePos.Instance(appId).start(object.toString(), new IDragonFlyCallBack() {
        @Override
        public void onFinish(int code, String subCode, String subMsg, String result) {
          try {
            DragonFlyFacePayResult r = objectMapper.readValue(result, DragonFlyFacePayResult.class);
            ta.append(r.toString());
          } catch (Exception e) {
            ta.append(e.getMessage());
          }
        }
      });
    } catch (Exception e) {
      ta.append(e.getMessage());
    }
  }

  private void payResultPageFail() {
    try {
      checkInit();
      JSONObject object = buildCommonParam(DragonFlyConsts.PAGE_PAYRESULT, DragonFlyConsts.OPER_SHOW);

      DragonFlyFacePayResultPageParam param =
        DragonFlyFacePayResultPageParamBuilder.aDragonFlyFacePayResultPageParam().withPayTrade(
          DragonFlyPayTradeBuilder.aDragonFlyPayTrade().withPayStatus(DragonFlyConsts.PAYSTATUS_FAILED)
            .withTradeNo("202210090001").withSubCode(DragonFlyConsts.PAYFAILEDCODE_OTHER).withSubMsg("测试支付失败结果")
            .build()).build();

      object.put("params", objectMapper.writeValueAsString(param));
      AbcpTaskTemplatePos.Instance(appId).start(object.toString(), new IDragonFlyCallBack() {
        @Override
        public void onFinish(int code, String subCode, String subMsg, String result) {
          try {
            DragonFlyFacePayResult r = objectMapper.readValue(result, DragonFlyFacePayResult.class);
            ta.append(r.toString());
          } catch (Exception e) {
            ta.append(e.getMessage());
          }
        }
      });
    } catch (Exception e) {
      ta.append(e.getMessage());
    }
  }

  private void stop(String page) {
    JSONObject object = buildCommonParam(page, "pop");
    AbcpTaskTemplatePos.Instance(appId).stop(object.toString(), new IDragonFlyCallBack() {
      @Override
      public void onFinish(int code, String subCode, String subMsg, String result) {
        //TODO
      }
    });
  }

  private JSONObject buildCommonParam(String page, String operateType) {
    JSONObject object = new JSONObject();
    object.put("page", page);
    object.put("operateType", operateType);
    object.put("bpaasExecutor", DragonFlyConsts.BPAASEXECUTOR);
    object.put("bpaasSign", secret);
    return object;
  }

}
