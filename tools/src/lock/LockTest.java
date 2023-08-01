package lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * </br>
 * Created by yangxiaohua on 2023/4/14.
 */
public class LockTest {

  public static void main(String[] args) {
    MyConditionService service = new MyConditionService();
    new Thread(service::testMethod).start();
    new Thread(service::testMethod).start();
    new Thread(service::testMethod).start();
    new Thread(service::testMethod).start();
    new Thread(service::testMethod).start();

    try {
      Thread.sleep(1000 * 5);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public static class MyConditionService {

    private Lock lock = new ReentrantLock();

    public void testMethod() {
      lock.lock();
      for (int i = 0; i < 5; i++) {
        System.out.println("ThreadName = " + Thread.currentThread().getName() + (" " + (i + 1)));
      }
      lock.unlock();
    }
  }
}

