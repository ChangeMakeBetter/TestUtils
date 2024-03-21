package test.swing;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Label;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class RoundedPanel extends JPanel {
  private static final long serialVersionUID = 7637118834869732508L;
  private int cornerRadius;
  //  private CardLayout cardLayout;

  public RoundedPanel(int cornerRadius) {
    this.cornerRadius = cornerRadius;
    //    cardLayout = new CardLayout();
    //    setLayout(cardLayout);
    setOpaque(false); // 设置为透明，以便显示圆角
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D graphics = (Graphics2D) g.create();
    graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    int width = getWidth();
    int height = getHeight();
    RoundRectangle2D.Float roundRect = new RoundRectangle2D.Float(0, 0, width - 1, height - 1, cornerRadius,
      cornerRadius);
    graphics.setColor(getBackground());
    graphics.fill(roundRect);
    graphics.setColor(getForeground());
    graphics.draw(roundRect);
    graphics.dispose();
  }

  // 添加一个 card
  public void addCard(String name, Component component) {
    add(component, name);
  }

  // 显示指定的 card
  public void showCard(String name) {
    //    cardLayout.show(this, name);
  }

  // 设置圆角半径
  public void setCornerRadius(int radius) {
    this.cornerRadius = radius;
  }

  // 获取圆角半径
  public int getCornerRadius() {
    return cornerRadius;
  }

  private static final String RIGHT_WEICHOME_PANEL = "welcomePanel";
  private static final String RIGHT_PRODUCT_INFO_PANEL = "productInfoPanel";

  // Main method for testing
  public static void main(String[] args) {
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    RoundedPanel roundedPanel = new RoundedPanel(20);
    roundedPanel.setPreferredSize(new Dimension(300, 200));
    roundedPanel.setBackground(Color.red);
    roundedPanel.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));

    JButton button1 = new JButton("Card 1");
    JButton button2 = new JButton("Card 2");

    JPanel panel1 = new JPanel(new BorderLayout());
    panel1.add(new Label("title1"), BorderLayout.NORTH);
    panel1.add(button1, BorderLayout.CENTER);
    JPanel panel2 = new JPanel(new BorderLayout());
    panel2.add(new Label("title2"), BorderLayout.NORTH);
    panel2.add(button2);

    CardLayout cardLayout;
    roundedPanel.setLayout(cardLayout = new CardLayout());
    // TODO
    JPanel welcomePanel = new JPanel();
    JLabel welComeTextLabel = new JLabel("<html>欢<br>迎<br>光<br>临<br></html>");
    welcomePanel.add(welComeTextLabel);
    welcomePanel.add(button1, BorderLayout.CENTER);

    roundedPanel.add(welcomePanel, RIGHT_WEICHOME_PANEL);
    roundedPanel.add(panel2, RIGHT_PRODUCT_INFO_PANEL);

    button1.addActionListener(e -> {
      cardLayout.show(roundedPanel, RIGHT_PRODUCT_INFO_PANEL);
    });
    button2.addActionListener(e -> {
      cardLayout.show(roundedPanel, RIGHT_WEICHOME_PANEL);
    });

    //    roundedPanel.addCard("card1", panel1);
    //    roundedPanel.addCard("card2", panel2);

    cardLayout.show(roundedPanel, RIGHT_PRODUCT_INFO_PANEL);

    JPanel jPanel = new JPanel(new BorderLayout());
    jPanel.add(roundedPanel, BorderLayout.CENTER);
    jPanel.setOpaque(false);
    jPanel.setBorder(BorderFactory.createEmptyBorder(0, 8, 8, 8));

    frame.add(jPanel);
    frame.pack();
    frame.setVisible(true);
  }
}
