package test.log;

import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DynamicLoggingExample {

  private static final Logger logger = Logger.getLogger(DynamicLoggingExample.class.getName());

  public static void main(String[] args) {
    // 执行一些操作...

    // 开启日志记录
    enableLogging();

    // 执行一些操作...

    // 关闭日志记录
    disableLogging();

    // 执行一些操作...
  }

  private static void enableLogging() {
    // 获取根日志记录器
    Logger rootLogger = Logger.getLogger("");

    // 添加一个控制台处理器
    Handler consoleHandler = new ConsoleHandler();
    consoleHandler.setLevel(Level.ALL);
    rootLogger.addHandler(consoleHandler);

    // 设置日志级别
    rootLogger.setLevel(Level.ALL);

    logger.info("日志记录已开启");
  }

  private static void disableLogging() {
    // 获取根日志记录器
    Logger rootLogger = Logger.getLogger("");

    // 移除所有处理器
    Handler[] handlers = rootLogger.getHandlers();
    for (Handler handler : handlers) {
      rootLogger.removeHandler(handler);
    }

    logger.info("日志记录已关闭");
  }
}
