package test.swing;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;

public class CapsLockChecker {
  public static void main(String[] args) {
    // 检测 Caps Lock 键是否开启
    boolean isCapsLockOn = Toolkit.getDefaultToolkit().getLockingKeyState(KeyEvent.VK_CAPS_LOCK);

    // 输出结果
    if (isCapsLockOn) {
      System.out.println("Caps Lock 是开启的");
    } else {
      System.out.println("Caps Lock 是关闭的");
    }
  }
}
