package test.thread;

import javax.swing.JFrame;

/**
 * </br>
 * Created by yangxiaohua on 2021/1/28.
 */
public class ThreadTest {

  public static void main(String[] args) {
    MyWorker worker = new MyWorker();

    JFrame frame = new JFrame("666");
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    ProgressDialog.show(frame, "test", "message", worker);

  }

  private static class MyWorker implements Runnable {

    public MyWorker() {
    }

    @Override
    public void run() {
      System.out.println("i am running");
    }
  }
}
