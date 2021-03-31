package test.thread;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class ProgressDlg implements ActionListener {
  private static boolean useNewProgress = false;
  private Component parent;
  private String title;

  public ProgressDlg() {
  }

  public ProgressDlg(final Component parent, final String title) {
    this.parent = parent;
    this.title = title;
  }

  // /////////////////////////////////////////
  // properties
  // /////////////////////////////////////////
  private String message;
  private String breakButtonText;
  private boolean breakable = true;
  private boolean progressBarVisible = true;
  private boolean timeVisible = true;
  private int result = 0;

  public boolean isProgressBarVisible() {
    return progressBarVisible;
  }

  public void setProgressBarVisible(boolean progressBarVisible) {
    this.progressBarVisible = progressBarVisible;
  }

  public boolean isTimeVisible() {
    return timeVisible;
  }

  public void setTimeVisible(boolean timeVisible) {
    this.timeVisible = timeVisible;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getBreakButtonText() {
    return breakButtonText;
  }

  public void setBreakButtonText(String buttonText) {
    this.breakButtonText = buttonText;
  }

  public boolean isBreakable() {
    return breakable;
  }

  public void setBreakable(boolean breakable) {
    this.breakable = breakable;
  }

  /**
   * @return 0=程序结束, 1=用户中断
   */
  public int getResult() {
    return result;
  }

  // /////////////////////////////////////////
  // methods
  // /////////////////////////////////////////

  // 简单用法
  public static void showUnbreakable(Component parent, String title, String message, final Runnable aRunnable) {
    if (!ProgressDlgSettings.useProgress) {
      aRunnable.run();
    } else {
      if (useNewProgress) {
        MyProgressBar.show(parent, title, message, aRunnable);
      } else {
        show(parent, title, message, null, false, aRunnable);
      }
    }
  }

  public static void showUnbreakable(Component parent, String title, String message, RunEntity run) throws Exception {
    if (!ProgressDlgSettings.useProgress) {
      run.run();
    } else {
      ProgressThread thread = new ProgressThread(run);
      if (useNewProgress) {
        MyProgressBar.show(parent, title, message, thread);
        if (thread.getException() != null) {
          throw thread.getException();
        }
      } else {
        show(parent, title, message, null, false, thread);
        if (thread.getException() != null) {
          throw thread.getException();
        }
      }
    }
  }

  public interface RunEntity {
    void run() throws Exception;
  }

  public static class ProgressThread implements Runnable {
    private RunEntity runEntity;
    private Exception exception;

    public ProgressThread(RunEntity runEntity) {
      this.runEntity = runEntity;
    }

    @Override
    public void run() {
      try {
        runEntity.run();
      } catch (Exception e) {
        exception = e;
      }
    }

    public Exception getException() {
      return exception;
    }
  }

  /**
   * @param parent
   * @param title
   * @param message
   * @param breakButtonText
   * @param aRunnable
   * @return 0=aRunnable结束, 1=用户中断
   */
  public static int showBreakable(Component parent, String title, String message, String breakButtonText,
    final Runnable aRunnable) {
    return show(parent, title, message, breakButtonText, true, aRunnable);
  }

  public void run(Runnable aRunnable) {
    RunWithDialog r = new RunWithDialog(aRunnable);
    if (SwingUtilities.isEventDispatchThread()) {
      r.run();
    } else {
      SwingUtilities.invokeLater(r);
    }
  }

  class RunWithDialog implements Runnable {
    Runnable aRunnable;

    public RunWithDialog(Runnable aRunnable) {
      super();
      this.aRunnable = aRunnable;
    }

    public void run() {
      if (dlg == null) {
        createDialog();
      }
      startTime = System.currentTimeMillis();
      timer.start();
      new Thread(new Runnable() {
        public void run() {
          while (true) {
            if (dlg.isVisible() && Toolkit.getDefaultToolkit().getSystemEventQueue().peekEvent() == null) {
              break;
            }
          }
          aRunnable.run();
        }
      }).start();
      dlg.setVisible(true);
      timer.stop();
      unregisterKeyActions();
      dlg.dispose();
    }
  }

  public void hide() {
    dlg.setVisible(false);
  }

  public void changeMessage(final String text) {
    if (dlg != null) {
      messageLabel.setText(text);
      dlg.pack();
      dlg.setLocationRelativeTo(parent);
    }
  }

  // 简单用法的实现

  private static int show(Component parent, String title, String message, String breakButtonText, boolean breakable,
    final Runnable aRunnable) {

    ProgressDlg dlg = new ProgressDlg(parent, title);
    dlg.setMessage(message);
    dlg.setBreakButtonText(breakButtonText);
    dlg.setBreakable(breakable);

    ProgressNotifier notifier = new ProgressNotifier();
    new MyObserver(notifier, dlg);
    MyProgram program = new MyProgram(notifier, aRunnable);

    dlg.run(program);
    return dlg.getResult();
  }

  public static class ProgressNotifier extends Observable {
    @Override
    public void notifyObservers(Object arg) {
      setChanged();
      super.notifyObservers(arg);
    }
  }

  private static class MyProgram implements Runnable {
    private ProgressNotifier notifier;
    private Runnable runnable;

    public MyProgram(ProgressNotifier notifier, Runnable runnable) {
      super();
      this.notifier = notifier;
      this.runnable = runnable;
    }

    public void run() {
      try {
        System.out.println("start");
        runnable.run();
        System.out.println("end");
      } finally {
        notifier.notifyObservers(null);
      }
    }
  }

  private static class MyObserver implements Observer {
    private ProgressNotifier notifier;
    private ProgressDlg dlg;

    public MyObserver(ProgressNotifier notifier, ProgressDlg dlg) {
      super();
      this.notifier = notifier;
      this.dlg = dlg;
      notifier.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
      notifier.deleteObserver(this);
      SwingUtilities.invokeLater(new Runnable() {

        @Override
        public void run() {
          dlg.hide();
        }
      });
    }
  }

  // ////////////////////////////////////////
  // 内部实现
  // ////////////////////////////////////////

  private JDialog dlg;
  private JOptionPane pane;

  private JLabel messageLabel;
  private JLabel timerLabel;

  private static SimpleDateFormat sdf = new SimpleDateFormat("mm:ss");
  private Timer timer;
  private long startTime;

  public void createDialog() {
    pane = new JOptionPane();
    pane.setMessageType(JOptionPane.INFORMATION_MESSAGE);

    timer = new Timer(1000, this);
    timer.setActionCommand("timer");

    messageLabel = new JLabel(message);

    //    ImageIcon imageIcon = new ImageIcon(ProgressDialog.class.getResource("resources/icons/progress.gif"));
    JLabel imageLabel = new JLabel("imageIcon");
    timerLabel = new JLabel("00:00");

    JPanel p = new JPanel(new GridBagLayout());
    GridBagConstraints c = new GridBagConstraints();
    c.fill = GridBagConstraints.HORIZONTAL;
    c.gridx = 0;
    c.gridy = 0;
    c.insets.bottom = 5;
    p.add(messageLabel, c);

    if (isProgressBarVisible()) {
      c.gridx = 0;
      c.gridy++;
      c.fill = GridBagConstraints.EAST;
      p.add(imageLabel, c);
    }

    if (isTimeVisible()) {
      c.gridx = 0;
      c.gridy++;
      c.fill = GridBagConstraints.EAST;
      c.anchor = GridBagConstraints.EAST;
      p.add(timerLabel, c);
    }

    JButton button = null;
    pane.setMessage(p);
    if (isBreakable()) {
      button = new JButton("0." + breakButtonText);
      button.setActionCommand("userBreak");
      button.addActionListener(this);
      pane.setOptions(new Object[] { button });

      button.registerKeyboardAction(this, "esc", KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),
        JPanel.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);// suspicious
      button.registerKeyboardAction(this, "userBreak", KeyStroke.getKeyStroke(KeyEvent.VK_0, 0),
        JPanel.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    } else {
      pane.setOptions(new Object[] {});

      pane.registerKeyboardAction(this, "esc", KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),
        JPanel.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    dlg = pane.createDialog(parent, title);
    dlg.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
    dlg.setModal(true);

    if (isBreakable()) {
      button.requestFocusInWindow();
    } else {
      p.requestFocusInWindow();
    }
  }

  private void unregisterKeyActions() {
    pane.unregisterKeyboardAction(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0));
  }

  public void actionPerformed(ActionEvent e) {
    if ("timer".equals(e.getActionCommand())) {
      timerLabel.setText(sdf.format(new Date(System.currentTimeMillis() - startTime)));
    } else if ("userBreak".equals(e.getActionCommand())) {
      result = 1;
      hide();
    }
  }

  public void setUseNewProgress(boolean useNewProgress) {
    ProgressDlg.useNewProgress = useNewProgress;
  }

}
