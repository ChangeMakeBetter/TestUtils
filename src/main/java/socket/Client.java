package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
  public static void main(String[] args) {
    final String SERVER_ADDRESS = "localhost"; // 服务器地址
    final int SERVER_PORT = 12345; // 服务器端口号
    try {
      // 创建客户端套接字并连接到服务器
      Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
      System.out.println("已连接到服务器：" + SERVER_ADDRESS);

      // 获取输入流和输出流
      BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

      // 向服务器发送消息，并读取服务器的响应消息
      out.println("Hello, Server!");
      String response = in.readLine();
      System.out.println("服务器响应消息：" + response);

      // 关闭流和套接字
      in.close();
      out.close();
      socket.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
