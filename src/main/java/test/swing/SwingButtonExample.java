package test.swing;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

import jpostools.runtimecreate.RunTimeLoadDemo;

public class SwingButtonExample extends JFrame {

  private static final long serialVersionUID = 5047723952966307511L;

  public SwingButtonExample() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setTitle("Swing Button Example");

    JButton button = new JButton("Click Me");
    button.addActionListener((e) -> {
      // 处理按钮点击事件
      System.out.println("Button clicked!");
    });

    // 创建输入映射
    InputMap inputMap = button.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
    ActionMap actionMap = button.getActionMap();

    // 获取回车键和空格键的 KeyStroke
    KeyStroke enterKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0);
    KeyStroke spaceKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0);

    // 将回车键和空格键的输入映射设置为空，即不处理这两个键的事件
    inputMap.put(enterKeyStroke, "none");
    inputMap.put(spaceKeyStroke, "none");

    // 创建一个空的 AbstractAction 来替代回车键和空格键的默认操作
    AbstractAction emptyAction = new AbstractAction() {
      private static final long serialVersionUID = -5997953075780775942L;

      @Override
      public void actionPerformed(ActionEvent e) {
        // 不执行任何操作
      }
    };

    // 将回车键和空格键的 AbstractAction 绑定到相应的 KeyStroke
    inputMap.put(enterKeyStroke, emptyAction);
    inputMap.put(spaceKeyStroke, emptyAction);

    // 创建一个 AbstractAction 来处理特定的键盘事件
    AbstractAction specificKeyAction = new AbstractAction() {
      private static final long serialVersionUID = -2333939279390615943L;

      @Override
      public void actionPerformed(ActionEvent e) {
        // 处理特定的键盘事件
        System.out.println("Specific key pressed!");
        RunTimeLoadDemo runTimeLoadDemo = new RunTimeLoadDemo();
        runTimeLoadDemo.createLoadTest();
      }
    };

    // 将特定键的 AbstractAction 绑定到相应的 KeyStroke
    inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0), "specificKeyAction");
    actionMap.put("specificKeyAction", specificKeyAction);

    // 将按钮添加到内容面板
    getContentPane().add(button, BorderLayout.CENTER);

    pack();
    setLocationRelativeTo(null);
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      SwingButtonExample example = new SwingButtonExample();
      example.setVisible(true);
    });
  }
}
