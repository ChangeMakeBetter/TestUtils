package lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * </br>
 * Created by yangxiaohua on 2023/4/15.
 */
public class MyRunAndLock {

  public static void main(String[] args) {
    MyRunAndLock myRunAndLock = new MyRunAndLock();
    myRunAndLock.start();

    try {
      //      myRunAndLock.await();
      System.out.println("轮到我咯");
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  public void start() {
    new Thread(new MyWorker()).start();
  }

  private ReentrantLock lock = new ReentrantLock();
  private Condition condition = lock.newCondition();

  private class MyWorker implements Runnable {
    @Override
    public void run() {
      try {
        System.out.println("等待执行");
        Thread.sleep(8000);
        System.out.println("我执行啦");
        signal();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  private void signal() {
    lock.lock();
    try {
      condition.signal();
    } finally {
      lock.unlock();
    }
  }

  private void await() throws InterruptedException {
    lock.lock();
    try {
      condition.await();
    } finally {
      lock.unlock();
    }
  }

}
