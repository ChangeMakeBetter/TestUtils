package cardserver;

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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import cardserver.param.MemberInfo;
import cardserver.param.TResponseData;
import cardserver.param.UCN;

public class TestCardServer extends JFrame {
  private static final long serialVersionUID = -663749975493575404L;

  //以下参数需要自行调整
  private String serverUrl = "http://localhost:8080/cardserver/service";
  private String terminalId = "mj";
  private String terminalFeature = "255350018048BFEBFBFF000A0653";
  private String regNum = "111";
  // end

  public static void main(String[] args) throws Exception {
    SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
        TestCardServer f = new TestCardServer();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
      }
    });

  }

  JTextArea ta = new JTextArea();

  public TestCardServer() {
    super("TestCardServerDemo");
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

    init();

  }

  private CardServerDemo cardServer;

  private void init() {
    cardServer = new CardServerDemo(serverUrl, terminalId, terminalFeature);
    cardServer.start();
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

    DevicePanel() {
      super(new BorderLayout());
      text.append("请输入");

      JPanel p1 = new JPanel(new BorderLayout());
      JScrollPane sp = new JScrollPane(text);
      p1.add(sp, BorderLayout.CENTER);
      add(p1, BorderLayout.CENTER);

      JPanel p = new JPanel(new GridLayout(0, 1));
      JButton button;

      button = new JButton("卡查询");
      button.setActionCommand("queryCard");
      button.addActionListener(this);
      p.add(button);

      button = new JButton("终端注册");
      button.setActionCommand("addTerminal");
      button.addActionListener(this);
      p.add(button);

      add(p, BorderLayout.EAST);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      try {
        if ("queryCard".equals(e.getActionCommand())) {
          doQueryCard(text.getText());
        } else if ("addTerminal".equals(e.getActionCommand())) {
          addTerminal(text.getText());
        }
      } catch (Exception ex) {
        ta.append("\nerror:" + ex.getMessage());
      }
    }

  }

  private void addTerminal(String regNum) {
    ta.setText("addTerminal\n");
    try {
      cardServer.registerServer(regNum);
    } catch (Exception e) {
      ta.append(e.getMessage());
    }

  }

  private void doQueryCard(String cardNo) {
    ta.setText("doQueryCard");
    MemberInfo mi = new MemberInfo();
    mi.setCode(cardNo);
    mi.setStore(new UCN("1000330", "999", "JPOS测试9号"));
    String res = cardServer.queryMemberInfo(mi);
    try {
      TResponseData responseData = new TResponseData(res);
      if (!responseData.retCode.IsOK()) {
        ta.append(responseData.retCode.getMessage());
      } else {
        ta.append("查询成功");
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

  }

}
