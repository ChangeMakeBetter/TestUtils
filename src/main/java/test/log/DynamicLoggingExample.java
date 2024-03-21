package test.log;

import java.util.Timer;
import java.util.TimerTask;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class DynamicLoggingExample {

  private static final Logger logger = Logger.getLogger(DynamicLoggingExample.class);

  public static void main(String[] args) {
    // 执行一些操作...

    // 开启日志记录
    enableLogging();
    // 创建一个Timer
    Timer timer = new Timer();
    // 定义要执行的任务
    TimerTask task = new TimerTask() {
      @Override
      public void run() {
        // 关闭日志记录
        disableLogging();
      }
    };

    // 在2分钟后执行任务
    timer.schedule(task, 2 * 60 * 1000);

    // 关闭Timer
    timer.cancel(); // 如果需要在执行完一次任务后关闭Timer，可以使用这个方法

    // 执行一些操作...
  }

  private static void enableLogging() {
    // 设置日志级别为 ALL
    logger.setLevel(Level.DEBUG);

    logger.debug("日志记录已开启");
  }

  private static void disableLogging() {
    // 设置日志级别为 OFF
    logger.debug("日志记录开始关闭啦");
    logger.setLevel(Level.INFO);

    logger.debug("日志记录已关闭");
  }
}
