package dragonfly.abcp.messagesender;

import dragonfly.DragonFlyLibV2;

/**
 * 蜻蜓消息发送者</br> Created by yangxiaohua on 2023/4/15.
 */
public class MyDragonflyMsgSender {
  private DragonFlyMsgCollection oc;
  private DragonFlyLibV2 lib;
  private DragflyMsgWorker worker;
  private Thread backgroundThread;

  public void init(DragonFlyLibV2 lib) {
    this.lib = lib;
    oc = new DragonFlyMsgCollection();
    worker = new DragflyMsgWorker(500);
    backgroundThread = new Thread(worker);
    backgroundThread.setName("DragflyMsgWorker");
    backgroundThread.setDaemon(true);
    backgroundThread.start();

  }

  // 相同的page 以及相同的operateType 判断为同一指令，放入集合
  // 不同的指令进来时，需要等待队列调用完成，并清空后，再放入集合。SKU放入集合，其余直接发送
  public synchronized void receiveMessage(DragonFlyMessage msg) {
    if (msg == null) {
      System.out.println("sendMessage,发送内容为空。忽略");
      return;
    }
    System.out.println("receiveMessage:" + msg.getContent());
    if (oc.isEmpty() || oc.hasSame(msg)) {
      // 相同MSG加入，0.5S内只发送一次
      setFlag(false);
      oc.add(msg);
    } else {
      // 不同的command等待前面的的执行完成后再add
      synchronized (this) {
        while (!flag) {
          try {
            System.out.println(" wait()");
            wait(); // 等待标记量被更新
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
      setFlag(false);
      System.out.println("add diff");
      oc.add(msg);
    }
  }

  private boolean flag = false;

  public synchronized void setFlag(boolean value) {
    this.flag = value;
    if (value) {
      notify(); // 通知其他线程
    }
  }

  private void sendCommand(DragonFlyMessage msg) {
    lib.abcpStartService("1", "1", msg.getContent(), null, null);
  }

  public void close() {
    if (backgroundThread != null) {
      worker.setTerminated(true);
      backgroundThread.interrupt();
      System.out.println("已请求监听线程中断！");
    } else {
      System.out.println("关闭]监听线程为空！");
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

        // 读到后休息sendDelay毫秒
        try {
          Thread.sleep(sendDelay);
        } catch (InterruptedException e) {
          System.out.println("线程从休眠中被中断，terminated=" + terminated);
          if (terminated) {
            System.out.println(THREAD_EXIT_LOG);
            return;
          }
        }

        if (!oc.isEmpty()) {
          if (oc.size() > 1) {
            System.out.println("oc.size=" + oc.size());
          }
          DragonFlyMessage msg = oc.getLatest();
          if (msg != null) {
            sendCommand(msg);
            oc.clear();
            setFlag(true);
          }
        }
      }
    }

    public void setTerminated(boolean terminated) {
      this.terminated = terminated;
    }
  }

}
