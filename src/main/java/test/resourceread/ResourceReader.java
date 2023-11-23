package test.resourceread;

/**
 * </br>
 * Created by yangxiaohua on 2023/11/7.
 */

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.net.URL;

public class ResourceReader {
  public static void main(String[] args) throws IOException, URISyntaxException {
    // 获取资源的URL
    URL resourceURL = ResourceReader.class.getResource("/123.txt");

    if (resourceURL != null) {
      // 创建临时文件
      File tempFile = File.createTempFile("123", ".txt");

      try (InputStream inputStream = resourceURL.openStream();
           OutputStream outputStream = new FileOutputStream(tempFile)) {
        // 将资源数据写入临时文件
        byte[] buffer = new byte[1024];
        int length;
        while ((length = inputStream.read(buffer)) != -1) {
          outputStream.write(buffer, 0, length);
        }

        // 刷新和关闭输出流
        outputStream.flush();
      }

      // 使用 tempFile 对象来操作临时文件
      System.out.println("临时文件路径: " + tempFile.getAbsolutePath());
    } else {
      System.err.println("资源文件 123.txt 未找到。");
    }
  }
}
