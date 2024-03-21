package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
  public static void main(String[] args) {
    final int PORT = 12345; // 服务器端口号
    try {
      ServerSocket serverSocket = new ServerSocket(PORT); // 创建服务器套接字
      System.out.println("服务器已启动，等待客户端连接...");

      // 等待客户端连接
      Socket clientSocket = serverSocket.accept();
      System.out.println("客户端已连接：" + clientSocket.getInetAddress().getHostAddress());

      // 获取输入流和输出流
      BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
      PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

      // 读取客户端发送的消息，并发送响应消息
      String message;
      while ((message = in.readLine()) != null) {
        System.out.println("客户端发送消息：" + message);
        out.println("已收到消息：" + message);
      }

      // 关闭流和套接字
      in.close();
      out.close();
      clientSocket.close();
      serverSocket.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
