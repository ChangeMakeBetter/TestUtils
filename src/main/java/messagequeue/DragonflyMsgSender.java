package messagequeue;

import java.util.Date;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import utils.MyConverter;

/**
 * </br>
 * Created by yangxiaohua on 2023/4/15.
 */
public class DragonflyMsgSender {

  private static DragonFlymsgCollection oc = new DragonFlymsgCollection();
  private ReentrantLock lock = new ReentrantLock();
  private Condition condition = lock.newCondition();

  public void start() {
    new Thread(new DragflyMsgWorker(500)).start();

  }

  public synchronized void sendMessage(DragonFlyMessage msg) {
    if (oc.isEmpty() || oc.hasSame(msg)) {
      //相同MSG加入，0.33S内只发送一次
      oc.add(msg);
    } else {
      synchronized (this) {
        while (!flag) {
          try {
            wait(); // 等待标记量被更新
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
      //不同的command等待前面的的执行完成后再add
      oc.add(msg);
    }
  }

  private boolean flag = false;

  public synchronized void setFlag(boolean value) {
    this.flag = value;
    notify(); // 通知其他线程
  }

  private static synchronized void sendCommand(DragonFlyMessage msg) {
    System.out.println("sendCommand:" + MyConverter.toString_yMdHmsS(new Date()) + "   msg:" + msg.toString());
  }

  private synchronized void sendCommandSync(DragonFlyMessage msg) {
    await();
    System.out.println("sendCommandSync:" + MyConverter.toString_yMdHmsS(new Date()) + "   msg:" + msg.toString());
  }

  private void signal() {
    lock.lock();
    try {
      condition.signal();
    } finally {
      lock.unlock();
    }
  }

  private void await() {
    lock.lock();
    try {
      condition.await();
    } catch (InterruptedException e) {
      //TODO
      e.printStackTrace();
    } finally {
      lock.unlock();
    }
  }

  public class DragflyMsgWorker implements Runnable {

    private final int sendDelay;

    String THREAD_EXIT_LOG = "停止线程";

    private volatile boolean terminated = false;

    /**
     * @param sendDelay - 发送间隔
     */
    public DragflyMsgWorker(int sendDelay) {
      this.sendDelay = sendDelay;
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
          Thread.sleep(sendDelay);
        } catch (InterruptedException e) {
          System.out.println("线程从休眠中被中断，terminated=" + terminated);
          if (terminated) {
            System.out.println(THREAD_EXIT_LOG);
            return;
          }
        }

        System.out.println("oc.size=" + oc.size());
        if (!oc.isEmpty()) {
          DragonFlyMessage msg = oc.getLatest();
          if (msg != null) {
            sendCommand(msg);
            oc.clear();
            setFlag(true);
          }
        }
      }
    }
  }

  public static void main(String[] args) throws InterruptedException {
    DragonflyMsgSender sender = new DragonflyMsgSender();
    sender.start();

    for (int i = 0; i < 100; i++) {
      Thread.sleep(50);
      DragonFlyMessage msg = DragonFlyMessage.skuShowMessage("msg:" + i);
      DragonFlyMessage msg2 = DragonFlyMessage.operMessage("msg:" + i * 2);
      if (i == 12) {
        sender.sendMessage(msg);
      } else {
        sender.sendMessage(msg2);
      }

    }
  }

}
