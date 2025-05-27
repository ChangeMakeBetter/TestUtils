package test.swing;

import java.awt.BorderLayout;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class ImageAdDisplay extends JFrame {

  private static final long serialVersionUID = -8099497572970652637L;
  private JLabel imageLabel;

  private static ImageAdDisplay instance = null;

  public synchronized static ImageAdDisplay getInstance() {
    if (instance == null) {
      instance = new ImageAdDisplay();
    }
    return instance;
  }

  public ImageAdDisplay() {
    //全屏
    GraphicsDevice screenDevice = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
    setSize(screenDevice.getDefaultConfiguration().getBounds().width,
      screenDevice.getDefaultConfiguration().getBounds().height);
    setLocationRelativeTo(null);
    setUndecorated(true); // Remove decorations
    getContentPane().add(createCenterPanel());
  }

  private JPanel createCenterPanel() {
    imageLabel = new JLabel();
    imageLabel.setHorizontalAlignment(JLabel.CENTER);
    imageLabel.setVerticalAlignment(JLabel.CENTER);

    JPanel centerPanel = new JPanel(new BorderLayout());
    centerPanel.add(imageLabel, BorderLayout.CENTER);
    return centerPanel;
  }

  private Timer hideTimer;

  // 显示图片
  public void showImage(String imagePath, int displayTimeInSeconds) {
    ImageIcon icon = new ImageIcon(imagePath);
    imageLabel.setIcon(icon);

    // 创建一个定时器，在10秒后隐藏整个JFrame
    if (hideTimer == null) {
      hideTimer = new Timer();
    }
    // 定义要执行的任务
    TimerTask task = new TimerTask() {
      @Override
      public void run() {
        setVisible(false); // 隐藏JFrame
      }
    };
    hideTimer.schedule(task, displayTimeInSeconds * 1000L);
    setVisible(true);
  }

  public static void main(String[] args) {
    String[] imagePaths = { "D:\\pic\\lg.png", "D:\\pic\\qwe.jpg" }; // 图片路径数组
    SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
        ImageAdDisplay imageAdDisplay = ImageAdDisplay.getInstance();
        imageAdDisplay.showImage(imagePaths[0], 10);
      }
    });
  }
}
