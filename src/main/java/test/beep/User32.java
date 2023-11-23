package test.beep;

import com.sun.jna.Library;
import com.sun.jna.Native;

/**
 * </br>
 * Created by yangxiaohua on 2023/11/7.
 */
public interface User32 extends Library {
  User32 INSTANCE = (User32) Native.loadLibrary("user32", User32.class);

  void MessageBeep(int uType);
}
