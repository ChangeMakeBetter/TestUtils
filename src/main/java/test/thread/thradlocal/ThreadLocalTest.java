package test.thread.thradlocal;

/**
 * </br>
 * Created by yangxiaohua on 2024/7/31.
 */
public class ThreadLocalTest {

  public static void main(String[] args) {

    for (int i = 0; i < 10; i++) {
      int finalI = i;
      System.out.println("index:" + finalI);
      Thread thread = new Thread(() -> {
        try {
          //          ThreadSession.threadLocal.set("threadLocal" + Thread.currentThread().getName());
          System.out.println(ThreadSession.threadLocal.get());
        } finally {
          ThreadSession.threadLocal.remove();
        }
      });
      thread.start();
    }
  }
}
