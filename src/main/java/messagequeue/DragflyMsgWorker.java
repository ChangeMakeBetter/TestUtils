package messagequeue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * </br>
 * Created by yangxiaohua on 2023/4/14.
 */
public class DragflyMsgWorker implements Runnable {

  private final int readDelay;

  private ReentrantLock lock = new ReentrantLock();
  private Condition condition = lock.newCondition();

  String THREAD_EXIT_LOG = "停止线程";

  private volatile boolean dataEnabled = true;
  private volatile boolean terminated = false;

  /**
   * @param sendDelay - 发送间隔
   */
  public DragflyMsgWorker(int sendDelay) {
    this.readDelay = sendDelay;
  }

  @Override
  public void run() {
    while (true) {
      if (Thread.currentThread().isInterrupted()) {
        if (terminated) {
          System.out.println(THREAD_EXIT_LOG);
          return;
        }
      }

      // 读到重量后休息readDelay毫秒
      try {
        Thread.sleep(readDelay);
      } catch (InterruptedException e) {
        System.out.println("线程从休眠中被中断，terminated=" + terminated);
        if (terminated) {
          System.out.println(THREAD_EXIT_LOG);
          return;
        }
      }

      //      System.out.println("oc.size=" + oc.size());
      //      if (!oc.isEmpty()) {
      //        DragonFlyMessage msg = oc.getLatest();
      //        if (msg != null) {
      //          System.out.println(MyConverter.toString(new Date()) + "   content:" + msg.toString());
      //          oc.clear();
      //          condition.signal();
      //        }
      //      }

    }
  }

  //  public void addCollection(DragonFlyMessage msg) {
  //    lock.lock();
  //    try {
  //      if (oc.hasSame(msg)) {
  //        oc.add(msg);
  //      } else {
  //        System.out.println("指令不同，等待OC清空后直接发送");
  //        if (!oc.isEmpty()) {
  //          condition.await();
  //        }
  //        sendCommand(msg);
  //      }
  //    } catch (Exception e) {
  //      //TODO
  //    } finally {
  //      lock.unlock();
  //    }
  //
  //  }

  private void sendCommand(DragonFlyMessage msg) {
    System.out.println("sendCommand:" + msg.toString());
  }

  //  public void setDataEnabled(boolean dataEnabled) {
  //    if (!this.dataEnabled && dataEnabled) {
  //      // 未启用->启用
  //      // 唤醒
  //      synchronized (this) {
  //        this.notifyAll();
  //      }
  //    }
  //    this.dataEnabled = dataEnabled;
  //  }
  //
  //  public boolean isDataEnabled() {
  //    return dataEnabled;
  //  }
}
