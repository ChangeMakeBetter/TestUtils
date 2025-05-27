package test.swing;

/**
 * </br>
 * Created by yangxiaohua on 2024/10/31.
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ImageTextPanel extends JPanel {
  private Image backgroundImage;
  private String fixedText;
  private String hintText;
  private Font fixedTextFont;
  private Font hintTextFont;
  private Color fixedTextColor;
  private Color hintTextColor;
  private int fixedTextX;
  private int fixedTextY;
  private int hintTextX;
  private int hintTextY;

  public ImageTextPanel(Image backgroundImage) {
    this.backgroundImage = backgroundImage;
    this.fixedText = "";
    this.hintText = "";
    this.fixedTextFont = new Font("微软雅黑", Font.BOLD, 30);
    this.hintTextFont = new Font("微软雅黑", Font.PLAIN, 20);
    this.fixedTextColor = Color.BLACK;
    this.hintTextColor = Color.GRAY;
    this.fixedTextX = 50;
    this.fixedTextY = 50;
    this.hintTextX = 50;
    this.hintTextY = 100;
  }

  public void setFixedText(String text, Font font, Color color, int x, int y) {
    this.fixedText = text;
    this.fixedTextFont = font;
    this.fixedTextColor = color;
    this.fixedTextX = x;
    this.fixedTextY = y;
    repaint();
  }

  public void setHintText(String text, Font font, Color color, int x, int y) {
    this.hintText = text;
    this.hintTextFont = font;
    this.hintTextColor = color;
    this.hintTextX = x;
    this.hintTextY = y;
    repaint();
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    // 绘制背景图
    if (backgroundImage != null) {
      g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }

    // 绘制固定文本
    drawMultilineText(g, fixedText, fixedTextFont, fixedTextColor, fixedTextX, fixedTextY);

    // 绘制提示文本
    drawMultilineText(g, hintText, hintTextFont, hintTextColor, hintTextX, hintTextY);

  }

  private void drawMultilineText(Graphics g, String text, Font font, Color color, int x, int y) {
    g.setFont(font);
    g.setColor(color);

    // 按照换行符拆分文本
    String[] lines = text.split("\n");

    // 逐行绘制文本，每行向下移动行高
    FontMetrics fm = g.getFontMetrics(font);
    int lineHeight = fm.getHeight();

    for (int i = 0; i < lines.length; i++) {
      g.drawString(lines[i], x, y + (i * lineHeight));
    }
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame("Image Text Example");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(800, 600);

    // 从外部指定背景图片
    Image backgroundImage = new ImageIcon(
      "D:\\hdhome\\miniso_intl_sap\\jpos\\data\\resource\\ads\\jpos_simpleAds.jpg").getImage();

    ImageTextPanel panel = new ImageTextPanel(backgroundImage);
    frame.add(panel);
    frame.setVisible(true);

    // 设置固定文本和提示文本
    Font fixedFont = new Font("微软雅黑", Font.BOLD, 30);
    Font hintFont = new Font("微软雅黑", Font.PLAIN, 30);
    panel.setFixedText("固定文本示例\n 积分：500", fixedFont, Color.RED, 100, 100);
    panel.setHintText("提示文本示例\n 当前提示", hintFont, Color.CYAN, 100, 200);
  }
}
