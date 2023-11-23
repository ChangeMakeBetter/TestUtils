package counter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * </br>
 * Created by yangxiaohua on 2022/7/26.
 */
public class CodeCounter {

  static int normalLine = 0; // 记录有效行

  static int blankLine = 0; // 记录空白行

  static int commentLine = 0; // 记录注释行

  static boolean i = false; // 多行注释的标志位

  public void codeCounterRun(String fileName) {

    try {
      // 用FileReader读取文件，再用BufferedReader套接，方便读取一行
      BufferedReader br = new BufferedReader(new FileReader(fileName));
      // 字符串line存储从BufferedReader读入的一行
      String line = null;

      // 当读入的一行不为空时(回车)，调用parse()方法解析此行

      while ((line = br.readLine()) != null) {

        parse(line);

      }

      // 分别输出文件中有效行、空白行和注释行的行数

      System.out.println("normalLine : " + normalLine);

      System.out.println("commentLine : " + commentLine);

      System.out.println("blankLine : " + blankLine);

      // 关闭br流，并释放与之关联的资源

      br.close();

    } catch (FileNotFoundException e) {

      e.printStackTrace();

    } catch (IOException e) {

      e.printStackTrace();

    }

  }

  private void parse(String line) {

    // 返回字符串的副本，忽略前导空白和尾部空白

    String lineBak = line.trim();

    // 记录单行注释：当前行以//开头

    if (lineBak.startsWith("//")) {

      commentLine++;

    }

    // 记录多行注释的开始：当前行以/*开头，预示着当前行为多行注释的开始，标志位i设置为true预示接下来的若干行都是注释行，直到匹配到*/

    else if (lineBak.startsWith("/*")) {

      commentLine++;

      i = true;

    }

    // 记录空行：当且仅当当前行长度为0且不在多行注释里

    else if (lineBak.length() == 0 && (false == i)) {

      blankLine++;

    }

    // 记录多行注释的结束：匹配到*/，标志位设置为false预示着多行注释的结束

    else if (lineBak.endsWith("*/")) {

      commentLine++;

      i = false;

    }

    // 记录多行注释：当且仅当标志位为true且当前行不以*/结尾

    else if ((true == i) && (!lineBak.endsWith("*/"))) {

      commentLine++;

    }

    // 记录有效行：其他情况

    else {

      normalLine++;

    }

  }

}

