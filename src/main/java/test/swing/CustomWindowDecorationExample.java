package test.swing;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRootPane;

public class CustomWindowDecorationExample {
  public static void main(String[] args) {
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // 获取JRootPane并设置窗口装饰样式
    JRootPane rootPane = frame.getRootPane();
    rootPane.setWindowDecorationStyle(JRootPane.NONE);

    // 添加其他组件等
    JButton button = new JButton("Click me");
    frame.add(button);

    frame.setSize(400, 300);
    frame.setVisible(true);
  }
}

