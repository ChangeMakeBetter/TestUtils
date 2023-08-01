package file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * </br>
 * Created by yangxiaohua on 2023/4/11.
 */
public class FileReadTest {
  //  public static void main(String[] args) {
  //
  //    try {
  //      // 下面是先写文件, 向文件尾追加, 若文件不存在则自动创建文件
  //      //      FileWriter fw = new FileWriter("D:/jpos-ui.xml", true); // 用FileWriter打开文件
  //      //      PrintWriter pw = new PrintWriter(fw); // 用写指针加载文件
  //      //      String[] str = { "" }; // 要写入的字符串
  //      //      for (String index : str) {
  //      //        pw.println(index); // 每次都向文件尾追加
  //      //      }
  //      //      pw.close(); // 关闭
  //      //      fw.close(); // 关闭
  //
  //      // 下面定位文件末行, 一行一行向上读取
  //      RandomAccessFile raf = new RandomAccessFile("D:/jpos-ui.xml", "rw"); // 该类可以定位文件,
  //      // 是java
  //      // IO类中唯一可以用来定位的
  //      long len = raf.length(); // 获得文件的长度,以便定位末尾
  //      if (len <= 3) { // 判断文件是否为空
  //        System.out.println("the flie is NULL!");
  //        return;
  //      }
  //      long pos = len - 1; // 定位文件尾
  //      while (pos > 0) { // 判断文件是否到达头
  //        --pos; // 一个字符一个字符的向前移动指针
  //        raf.seek(pos); // 定位文件指针所指的位置
  //        if (raf.readByte() == '\n') { // 如果是换行符,就可以读取该行了
  //          System.out.println(raf.readLine());
  //        }
  //      }
  //      raf.seek(pos); // 最后还需要读取第一行
  //      System.out.println(raf.readLine());
  //      raf.close(); // 关闭
  //
  //    } catch (FileNotFoundException e) {
  //      e.printStackTrace();
  //    } catch (IOException e) {
  //      e.printStackTrace();
  //    }
  //    System.exit(0);
  //    return;
  //  }

  public static void insert(String fileName, long pos, String insertContent) throws IOException {
    File file = File.createTempFile("tmp", null);
    file.deleteOnExit();
    RandomAccessFile raf = new RandomAccessFile(fileName, "rw");
    FileInputStream fileInputStream = new FileInputStream(file);
    FileOutputStream fileOutputStream = new FileOutputStream(file);
    raf.seek(pos);
    byte[] buff = new byte[64];
    int hasRead = 0;
    while ((hasRead = raf.read(buff)) > 0) {
      fileOutputStream.write(buff);
    }
    raf.seek(pos);
    raf.write(insertContent.getBytes());
    //追加文件插入点之后的内容
    while ((hasRead = fileInputStream.read(buff)) > 0) {
      raf.write(buff, 0, hasRead);
    }
    raf.close();
    fileInputStream.close();
    fileOutputStream.close();
  }

  public static void main(String[] args) throws IOException {
    String insertContent = "test Write";
    insert("D:/jpos-ui.xml", 1555, insertContent);
  }
}