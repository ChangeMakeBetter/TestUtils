package test.process;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Timer;
import java.util.TimerTask;

public class MainApp {
  private static final int HEARTBEAT_PORT = 9999;
  private static final int BUSINESS_PORT = 8888;

  public static void main(String[] args) {
    try {
      ProcessBuilder builder = new ProcessBuilder(
        "java",
        "-cp",
        "D:\\projects\\TestUtils\\target\\classes;D:\\projects\\TestUtils\\src\\lib\\*",
        "dragonfly.DragonflyCaller"
      );
      Process process = builder.start();

      Socket businessSocket = new Socket("localhost", BUSINESS_PORT);

      final Process finalProcess = process;
      Runtime.getRuntime().addShutdownHook(new Thread(() -> {
        System.out.println("Shutdown hook is running...");
        try {
          businessSocket.close();
        } catch (IOException e) {
          System.out.println("close error:" + e.getMessage());
        }
        System.out.println("destroy");
        finalProcess.destroy();
      }));

      // 心跳timer
      createHeartBeatTimer();

      // 启动线程处理子进程的标准输出
      StreamGobbler stdoutGobbler = new StreamGobbler(process.getInputStream(), "STDOUT");
      stdoutGobbler.start();

      // 启动线程处理子进程的错误输出
      StreamGobbler stderrGobbler = new StreamGobbler(process.getErrorStream(), "STDERR");
      stderrGobbler.start();

      Thread.sleep(15000);

      //      sendBusinessCommand(businessSocket, "showProductInfo");
      // 发送startService命令和参数
      //      sendCommand("startService", "myServiceCode", "{\"key\":\"value\"}");

      //      Thread.sleep(2000);
      // 发送stopService命令
      //      sendBusinessCommand("stopService");

    } catch (Throwable e) {
      e.printStackTrace();
    }
  }

  private static void createHeartBeatTimer() {
    int executionCount = 15; // 指定执行次数
    Timer timer = new Timer(true);
    timer.scheduleAtFixedRate(new TimerTask() {
      int count = 0;

      @Override
      public void run() {
        if (count < executionCount) {
          sendHeartbeat();
          count++;
        } else {
          timer.cancel(); // 取消定时器
        }
      }
    }, 0, 2000); // Send heartbeat every 5 seconds

  }

  private static void sendHeartbeat() {
    try (Socket socket = new Socket("localhost", HEARTBEAT_PORT); BufferedWriter out =
      new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {
      out.write("heartbeat\n");
      out.flush();

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void sendBusinessCommand(Socket socket, String command, String... params) {
    try (
      OutputStreamWriter out = new OutputStreamWriter(socket.getOutputStream());
      BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

      out.write(command + "\n");
      for (String param : params) {
        out.write(param + "\n");
      }
      out.flush();

      String response;
      while ((response = in.readLine()) != null) {
        System.out.println("Response from DllCaller: " + response);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

// 辅助线程类，用于处理子进程的输出流
class StreamGobbler extends Thread {
  private BufferedReader reader;
  private String type;

  public StreamGobbler(InputStream inputStream, String type) {
    try {
      this.reader = new BufferedReader(new InputStreamReader(inputStream, "gbk"));
      this.type = type;
    } catch (Exception ignored) {
    }
  }

  @Override
  public void run() {
    try {
      String line;
      while ((line = reader.readLine()) != null) {
        System.out.println(type + ": " + line);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
