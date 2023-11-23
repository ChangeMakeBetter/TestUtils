package messagequeue;

import java.util.concurrent.atomic.AtomicInteger;

public class SeckKill {
  private static final int MAX_STOCK = 10;   // 最大库存量
  private static AtomicInteger stock = new AtomicInteger(MAX_STOCK);   // 库存量

  public static boolean doSecKill() {
    try {
      Thread.sleep(100);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    int currentStock = stock.get(); // 获取当前库存量
    if (currentStock <= 0) {    // 库存不足，秒杀失败
      return false;
    }
    // 使用原子操作进行库存减一
    if (stock.compareAndSet(currentStock, currentStock - 1)) {
      //      System.out.println("SecKill success, remain stock: " + stock.get());
      return true;
    } else {
      return false;
    }
  }

  public static void main(String[] args) {
    for (int i = 1; i <= 15; i++) {
      new Thread(new Runnable() {
        @Override
        public void run() {
          if (doSecKill()) {
            System.out.println("Thread " + Thread.currentThread().getName() + " 秒杀 success.");
          } else {
            System.out.println("Thread " + Thread.currentThread().getName() + " 秒杀 failed.");
          }
        }
      }).start();
    }
  }
}

