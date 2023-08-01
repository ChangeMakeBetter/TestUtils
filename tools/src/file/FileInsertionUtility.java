package file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class FileInsertionUtility {

  /**
   * 在指定文件的最后一行上面插入
   *
   * @param filePath  文件路径
   * @param insertion 插入的内容
   * @throws IOException 如果文件读写失败，抛出IOException
   */
  public static void insertIntoFileLastLine(String filePath, String insertion) throws IOException {
    File file = new File(filePath);

    BufferedReader reader = null;
    BufferedWriter writer = null;
    try {
      // 读取文件内容
      StringBuilder fileContent = new StringBuilder();
      reader = new BufferedReader(new FileReader(file));
      String line;
      int lineCount = 0;
      while ((line = reader.readLine()) != null) {
        if (lineCount == 0) {
          fileContent.append(line);
        } else {
          fileContent.append(System.lineSeparator()).append(line);
        }
        lineCount++;
      }

      // 插入内容
      StringBuilder newContent = new StringBuilder(fileContent);
      int lastLineBreakIndex = newContent.lastIndexOf(System.lineSeparator());
      newContent.insert(lastLineBreakIndex + 1, insertion);

      // 将新内容写回文件
      writer = new BufferedWriter(new FileWriter(file));
      writer.write(newContent.toString());
    } finally {
      // 关闭资源
      if (reader != null) {
        try {
          reader.close();
        } catch (IOException e) {
          // 忽略关闭异常
        }
      }
      if (writer != null) {
        try {
          writer.close();
        } catch (IOException e) {
          // 忽略关闭异常
        }
      }
    }
  }

  public static void main(String[] args) {
    String filePath = "D:/pms.xml";
    String insertion = "插入的内容";
    //
    //    try {
    //      FileInsertionUtility.insertIntoFileLastLine(filePath, insertion);
    //    } catch (Exception e) {
    //      System.out.println(e.getMessage());
    //    }

    Date d = new Date(1680000001650L);
    System.out.println("lstUpdte=" + d);
    System.out.println("filltime=" + new Date(1679999980000L));

  }
}
