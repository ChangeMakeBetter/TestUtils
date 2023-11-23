package test.beep;

/**
 * </br>
 * Created by yangxiaohua on 2023/11/7.
 */
public class BeepExample {

  public static void main(String[] args) {
    User32 user32 = User32.INSTANCE;
    int MB_ICONASTERISK = 0x00000040;
    user32.MessageBeep(MB_ICONASTERISK);

    user32.MessageBeep(0);

    //    Toolkit.getDefaultToolkit().beep();
  }
}

