package dragonfly.abcp.messagesender;

/**
 * </br>
 * Created by yangxiaohua on 2023/7/26.
 */

import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;

import dragonfly.DragonFlyLibV2;

public class DragonflyMsgSender {
  private DragonFlyMsgCollection oc;
  private DragonFlyLibV2 lib;
  private DragflyMsgWorker worker;
  private Thread backgroundThread;
  private LinkedBlockingQueue<DragonFlyMessage> messageQueue;
  private Set<String> addedMessages; // 存储已添加到队列中的消息内容
  private long lastSentTime = 0;

  public void init(DragonFlyLibV2 lib) {
    this.lib = lib;
    oc = new DragonFlyMsgCollection();
    messageQueue = new LinkedBlockingQueue<>();
    worker = new DragflyMsgWorker();
    backgroundThread = new Thread(worker);
    backgroundThread.setName("DragflyMsgWorker");
    backgroundThread.setDaemon(true);
    backgroundThread.start();
  }

  public void receiveMessage(DragonFlyMessage msg) {
    if (msg == null) {
      System.out.println("receiveMessage,发送内容为空。忽略");
      return;
    }
    System.out.println("receiveMessage:" + msg.getContent());

    synchronized (this) {
      long currentTime = System.currentTimeMillis();
      // 如果当前时间与上次发送时间的差值小于 500ms，则表示在 0.5s 内，不发送该消息
      if (currentTime - lastSentTime < 500) {
        return;
      }
      lastSentTime = currentTime;
    }

    // 将新的消息添加到队列中
    messageQueue.offer(msg);
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
      System.out.println("[关闭]监听线程为空！");
    }
  }

  private class DragflyMsgWorker implements Runnable {
    private volatile boolean terminated = false;

    @Override
    public void run() {
      while (!terminated) {
        try {
          // 从队列中获取最新的消息，如果没有新的消息，则阻塞等待
          DragonFlyMessage msg = messageQueue.take();
          // 发送消息
          sendCommand(msg);
        } catch (InterruptedException e) {
          if (terminated) {
            System.out.println("DragflyMsgWorker线程退出。");
          } else {
            System.out.println("DragflyMsgWorker线程从休眠中被中断，terminated=" + terminated);
          }
        }
      }
    }

    public void setTerminated(boolean terminated) {
      this.terminated = terminated;
    }
  }
}

