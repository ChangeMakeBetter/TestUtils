package test.swing;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class LayeredPaneExample {
  public static void main(String[] args) {
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // 创建 JLayeredPane
    JLayeredPane layeredPane = new JLayeredPane();
    layeredPane.setPreferredSize(new Dimension(400, 300)); // 设置 JLayeredPane 的大小

    // 创建父 JPanel，不设置位置
    JPanel parentPanel = new JPanel();
    parentPanel.setBackground(Color.BLUE);
    parentPanel.add(new JLabel("Parent Panel")); // 添加一些内容以显示
    parentPanel.setBounds(50, 50, 300, 200); // 设置 child JPanel 的位置和尺寸

    // 创建 child JPanel，设置位置
    JPanel childPanel = new JPanel();
    childPanel.setBackground(Color.RED);
    childPanel.add(new JLabel("Child Panel")); // 添加一些内容以显示
    childPanel.setBounds(100, 100, 200, 100); // 设置 child JPanel 的位置和尺寸

    // 将父 JPanel 和 child JPanel 添加到 JLayeredPane 中
    layeredPane.add(parentPanel, JLayeredPane.DEFAULT_LAYER); // 添加到默认层级
    layeredPane.add(childPanel, JLayeredPane.PALETTE_LAYER); // 添加到最顶层

    frame.add(layeredPane);
    frame.pack();
    frame.setVisible(true);
  }
}
