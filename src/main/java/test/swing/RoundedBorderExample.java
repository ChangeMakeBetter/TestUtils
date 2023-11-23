package test.swing;

/**
 * </br>
 * Created by yangxiaohua on 2023/6/28.
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.AbstractBorder;
import javax.swing.border.Border;

public class RoundedBorderExample {
  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
        createAndShowGUI();
      }
    });
  }

  private static void createAndShowGUI() {
    JFrame frame = new JFrame("Rounded Border Example");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JPanel panel = new JPanel();
    panel.setLayout(new BorderLayout());
    panel.setBorder(createRoundedBorder(Color.BLACK, 10)); // 设置圆角半径为10像素

    JLabel label = new JLabel("Hello, World!");
    label.setHorizontalAlignment(SwingConstants.CENTER);
    panel.add(label, BorderLayout.CENTER);

    frame.getContentPane().add(panel);
    frame.pack();
    frame.setVisible(true);
    frame.setLocationRelativeTo(null);
  }

  private static Border createRoundedBorder(final Color color, final int cornerRadius) {
    return new AbstractBorder() {
      private static final long serialVersionUID = 1L;

      @Override
      public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(color);
        g2d.drawRoundRect(x, y, width - 1, height - 1, cornerRadius, cornerRadius);
      }

      @Override
      public Insets getBorderInsets(Component c) {
        return new Insets(cornerRadius, cornerRadius, cornerRadius, cornerRadius);
      }
    };
  }
}
