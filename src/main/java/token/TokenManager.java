package token;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicReference;

public class TokenManager {
  private static final long TOKEN_EXPIRY_TIME = 15 * 60 * 1000; // 15分钟过期
  private AtomicReference<String> token = new AtomicReference<>(""); // 线程安全的Token存储
  private long lastTokenTime = 0; // 上次Token获取的时间

  // 1. 私有构造函数，防止外部直接实例化
  private TokenManager() {
    // 定时任务每10分钟刷新一次Token
    Timer timer = new Timer(true);
    timer.scheduleAtFixedRate(new TimerTask() {
      @Override
      public void run() {
        refreshToken();
      }
    }, 0, 10 * 60 * 1000); // 10分钟刷新一次Token
  }

  // 2. 使用内部类实现单例模式
  private static class SingletonHolder {
    private static final TokenManager INSTANCE = new TokenManager();
  }

  // 3. 提供获取单例实例的方法
  public static TokenManager getInstance() {
    return SingletonHolder.INSTANCE;
  }

  // 模拟从服务器获取Token的函数
  private void refreshToken() {
    String newToken = getTokenFromServer(); // 假设这是一个API调用来获取Token
    token.set(newToken);
    lastTokenTime = System.currentTimeMillis();
    System.out.println("Token refreshed: " + newToken);
  }

  // 获取Token的方法，判断Token是否过期，过期则重新获取
  public String getToken() {
    if (System.currentTimeMillis() - lastTokenTime > TOKEN_EXPIRY_TIME) {
      // 如果Token过期，重新获取
      refreshToken();
    }
    return token.get();
  }

  // 模拟API调用
  public void callApi() {
    String token = getToken();
    System.out.println("Calling API with token: " + token);
    // 你的API调用逻辑
  }

  // 假设这个方法是从服务器获取Token的接口
  private String getTokenFromServer() {
    // 模拟从服务端获取token
    return "newToken_" + System.currentTimeMillis();
  }

  public static void main(String[] args) {
    TokenManager tokenManager = TokenManager.getInstance();

    // 模拟调用API
    tokenManager.callApi();

    // 稍后再次调用API
    try {
      Thread.sleep(5000); // 睡眠5秒模拟等待
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    tokenManager.callApi();
  }
}
