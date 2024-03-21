package test.swing;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRootPane;

/**
 * </br>
 * Created by yangxiaohua on 2024/2/19.
 */
public class DoubleFrameTest {
  public static void main(String[] args) {
    JFrame frame1 = new JFrame("Frame1");
    frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame1.setUndecorated(true);
    frame1.getRootPane().setWindowDecorationStyle(JRootPane.NONE);

    frame1.setLocation(100, 100);
    frame1.setPreferredSize(new Dimension(600, 400));

    Dimension size = frame1.getSize();
    JLabel label1 = new JLabel();
    label1.setBackground(Color.RED);
    label1.setBorder(BorderFactory.createEtchedBorder());
    label1.setText("Test");
    label1.setSize(size);
    label1.setPreferredSize(size);
    label1.setMaximumSize(size);
    label1.setMinimumSize(size);

    frame1.add(label1);

    frame1.pack();
    frame1.setVisible(true);

    //    JFrame f2 = new JFrame("Frame2");
    //    f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //
    //    f2.setLocation(150, 150);
    //    f2.setVisible(true);
    //    f2.setPreferredSize(new Dimension(300, 200));
    //    f2.pack();
    //    f2.setVisible(true);
  }
}
