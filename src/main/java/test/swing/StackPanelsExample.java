package test.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class StackPanelsExample {
  public static void main(String[] args) {
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // 创建父面板并使用 BorderLayout
    JPanel parentPanel = new JPanel(new BorderLayout());
    parentPanel.setBackground(Color.blue);
    parentPanel.setPreferredSize(new Dimension(400, 300));

    // 创建一个透明的占位符面板
    JPanel placeholderPanel = new JPanel();
    placeholderPanel.setOpaque(false);
    parentPanel.add(placeholderPanel, BorderLayout.WEST); // 将占位符面板添加到 WEST 区域

    // 创建子面板
    JPanel childPanel = new JPanel();
    childPanel.setBackground(Color.RED);
    childPanel.setPreferredSize(new Dimension(200, 200));
    parentPanel.add(childPanel, BorderLayout.CENTER); // 将子面板添加到 CENTER 区域

    frame.add(parentPanel);
    frame.pack();
    frame.setVisible(true);
  }
}
