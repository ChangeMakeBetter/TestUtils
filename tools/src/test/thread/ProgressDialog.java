package test.thread;

import java.awt.Component;

public class ProgressDialog {
  public static void show(final Component parent, final String title, final String message, final Runnable aRunnable) {
    if (!ProgressDlgSettings.useProgress) {
      aRunnable.run();
    } else {
      ProgressDlg.showUnbreakable(parent, title, message, aRunnable);
    }
  }
}
