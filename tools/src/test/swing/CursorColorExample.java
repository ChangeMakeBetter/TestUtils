package test.swing;

/**
 * </br>
 * Created by yangxiaohua on 2023/6/28.
 */

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.plaf.basic.BasicTextUI;
import javax.swing.text.JTextComponent;

public class CursorColorExample {
  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> createAndShowGUI());
  }

  private static void createAndShowGUI() {
    JFrame frame = new JFrame("Cursor Color Example");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JTextField textField = new JTextField(20);
    customizeCursorColor(textField, Color.RED); // 设置光标颜色为红色

    frame.getContentPane().add(textField);
    frame.pack();
    frame.setVisible(true);
  }

  private static void customizeCursorColor(JTextComponent textComponent, Color color) {
    BasicTextUI textUI = (BasicTextUI) textComponent.getUI();
    //    textUI.getCaret().setSelectionVisible(true);
    //    textUI.getCaret().setBlinkRate(500); // 设置光标闪烁频率，单位为毫秒
    //    textUI.getCaret().setForeground(color);
  }
}
