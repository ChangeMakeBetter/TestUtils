package test.swing;

import javax.swing.JFrame;

public class LayeredFramesExample {
  public static void main(String[] args) {
    JFrame frame1 = new JFrame("Frame 1");
    frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame1.setSize(300, 200);

    JFrame frame2 = new JFrame("Frame 2");
    frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame2.setSize(300, 200);

    frame1.setLocationRelativeTo(null);
    frame2.setLocationRelativeTo(frame1);

    // 显示 frame2，将其置于 frame1 的后面
    frame2.setVisible(true);

    // 显示 frame1，将其置于 frame2 的前面
    frame1.setVisible(true);
    frame2.toFront();
  }
}
