package test.swing;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * </br>
 * Created by yangxiaohua on 2024/2/28.
 */
public class BoxLayoutTest {
  public static void main(String[] args) {
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JLabel welcomeTextLabel = new JLabel("欢迎光临！");
    JLabel memberNameLabel = new JLabel(" ");
    JLabel memberCodeLabel = new JLabel(" ");
    JLabel memberGradeLabel = new JLabel(" "); // TODO 不知道怎么展示
    JLabel splitLabel = new JLabel("|");
    JLabel depositLabel = new JLabel("储值");
    JLabel depositValueLabel = new JLabel("-");
    JLabel scoreLabel = new JLabel("积分");
    JLabel scoreValueLabel = new JLabel("-");

    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
    panel.add(welcomeTextLabel);
    panel.add(splitLabel);
    panel.add(memberNameLabel);
    panel.add(memberCodeLabel);
    panel.add(memberGradeLabel);
    panel.add(Box.createHorizontalStrut(50)); // 这里的10是间隔的高度，可以根据需要调整
    panel.add(depositLabel);
    panel.add(depositValueLabel);
    panel.add(scoreLabel);
    panel.add(scoreValueLabel);

    frame.setSize(400, 400);
    frame.setLocationRelativeTo(null);
    frame.add(panel);
    //    frame.pack();
    frame.setVisible(true);
  }
}
