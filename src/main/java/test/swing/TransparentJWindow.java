package test.swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class TransparentJWindow extends JWindow {
  private TransparentPanel panel;

  public TransparentJWindow() {
    setSize(300, 200);
    setLocationRelativeTo(null);
    setBackground(new Color(0, 0, 0, 0)); // 设置窗口背景透明

    // 创建透明面板
    panel = new TransparentPanel();
    panel.setPreferredSize(new Dimension(300, 200));
    add(panel);

    pack();
  }

  // 方法来更新文本内容
  public void setText(String text, int x, int y) {
    panel.setText(text, x, y);
  }

  // 自定义的透明面板
  class TransparentPanel extends JPanel {
    private String text = "这是一个弹框"; // 默认文本
    private int x = 50, y = 100;

    public TransparentPanel() {
      setOpaque(false); // 设置面板为透明
    }

    // 更新文本内容的方法
    public void setText(String text, int x, int y) {
      this.text = text;
      this.x = x;
      this.y = y;
      repaint(); // 重新绘制面板
    }

    @Override
    protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      // 在这里绘制不透明的文本
      g.setColor(Color.WHITE); // 设置文本颜色
      g.setFont(new Font("宋体", Font.PLAIN, 24)); // 使用支持中文的字体
      g.drawString(text, x, y); // 绘制文本
    }
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(
      () -> {
        TransparentJWindow window = new TransparentJWindow();
        window.setVisible(true);

        // 示例：在窗口显示后更新文本
        window.setText("一个文本内容", 50, 100);
        Timer timer = new Timer(5000, e -> window.setText("新的文本内容", 100, 150));
        timer.setRepeats(false);
        timer.start();
      });
  }
}
