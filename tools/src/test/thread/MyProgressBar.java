package test.thread;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;
import javax.swing.Timer;

public class MyProgressBar extends JDialog {
  private static MyProgressBar dialog = null;
  private static boolean useOneDialog = false;

  public synchronized static void show(Component parent, String title, String message, Runnable aRunnable) {
    if (!ProgressDlgSettings.useProgress) {
      aRunnable.run();
    } else {
      if (useOneDialog) {
        if (dialog == null) {
          dialog = new MyProgressBar(parent, title, message, aRunnable);
          dialog.createDialog();
        } else {
          dialog.init(parent, title, message, aRunnable);
        }
        dialog.execute2();
      } else {
        MyProgressBar dialog = new MyProgressBar(parent, title, message, aRunnable);
        dialog.execute();
      }
    }
  }

  public synchronized static void exit() {
    if (useOneDialog && dialog != null) {
      dialog.dispose();
    }
  }

  private static final long serialVersionUID = 1L;
  private long startTime;
  private static SimpleDateFormat sdf = new SimpleDateFormat("mm:ss");
  private Timer timer;
  private JProgressBar progressBar;
  private ProgressBarTask task;
  private JLabel timerLabel;
  private String message;
  private Component parent;

  public MyProgressBar(Component parent, String title, String message, Runnable aRunnable) {
    super(JOptionPane.getFrameForComponent(parent), title, true);
    setName(title);
    this.parent = parent;
    this.message = message;
    task = new ProgressBarTask(aRunnable);
  }

  private JLabel messageLabel;

  private void createDialog() {
    setLayout(new BorderLayout());
    messageLabel = new JLabel(message);
    add(messageLabel, BorderLayout.NORTH);

    GridBagLayout layout = new GridBagLayout();
    layout.columnWidths = new int[] { 1, 1, 1 };
    layout.columnWeights = new double[] { 1, 1, 1 };
    JPanel centerPane = new JPanel(layout);

    GridBagConstraints constrsints = new GridBagConstraints();
    constrsints.fill = GridBagConstraints.HORIZONTAL;
    constrsints.insets = new Insets(10, 10, 10, 10);
    constrsints.gridx = 1;
    constrsints.gridy = 0;
    progressBar = new JProgressBar();
    progressBar.setBackground(Color.WHITE);
    progressBar.setForeground(new Color(95, 158, 160));
    progressBar.setPreferredSize(new Dimension(200, 20));
    progressBar.setIndeterminate(true);
    centerPane.add(progressBar, constrsints);
    add(centerPane, BorderLayout.CENTER);

    timerLabel = new JLabel("00:00");
    JPanel panel = new JPanel(new BorderLayout());

    panel.add(timerLabel, BorderLayout.EAST);
    add(panel, BorderLayout.SOUTH);
    timer = new Timer(1000, new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        timerLabel.setText(MyProgressBar.sdf.format(new Date(System.currentTimeMillis() - startTime)));
      }
    });
    setResizable(false);
    pack();
    setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
    setLocationRelativeTo(parent);
  }

  private void init(Component parent, String title, String message, Runnable aRunnable) {
    this.message = message;
    this.parent = parent;
    setTitle(title);
    timerLabel.setText("00:00");
    messageLabel.setText(message);
    task = new ProgressBarTask(aRunnable);
    timer.stop();
  }

  private void execute() {
    createDialog();
    task.execute();
    showDialog();
  }

  private void execute2() {
    task.execute();
    showDialog();
  }

  private volatile boolean dialogShowing = false;

  public void setVisible(boolean b) {
    dialogShowing = b;
    System.out.println("setVisible:" + b);
    super.setVisible(b);
  }

  private void showDialog() {
    startTime = System.currentTimeMillis();
    timer.start();
    setVisible(true);
  }

  private void hideDialog() {
    try {
      while (!dialogShowing) {
        try {
          System.out.println("wait for dialog showing");
          Thread.sleep(300);
        } catch (InterruptedException e) {
        }
      }
      timer.stop();
      setVisible(false);
    } finally {
      System.out.println("dispose this dialog");
      if (!useOneDialog) {
        dispose();
      }
    }
  }

  private class ProgressBarTask extends SwingWorker<Boolean, Void> {
    private Runnable aRunnable;

    public ProgressBarTask(Runnable aRunnable) {
      this.aRunnable = aRunnable;
    }

    @Override
    protected Boolean doInBackground() throws Exception {
      try {
        System.out.println("strat");
        aRunnable.run();
        System.out.println("end");
        return Boolean.TRUE;
      } catch (Exception e) {
        return Boolean.FALSE;
      }
    }

    @Override
    protected void done() {
      hideDialog();
    }
  }

  public MyProgressBar() {
  }

  public void setUseOneDialog(boolean useOneDialog) {
    MyProgressBar.useOneDialog = useOneDialog;
  }

}
