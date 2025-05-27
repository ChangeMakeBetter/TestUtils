package test;

import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * TestUtils<br> Created by yangxiaohua on 2019/11/15.
 */
public class CommonTest {

  public static List<String> generateCardNumbers(String start, String end) {
    List<String> cardNumbers = new ArrayList<>();

    // 确保 start 和 end 都是有效的数字字符串
    if (!start.matches("\\d+") || !end.matches("\\d+")) {
      throw new IllegalArgumentException("Start and end must be valid digit strings.");
    }

    // 确定最长卡号的长度
    int maxLength = Math.max(start.length(), end.length());

    // 将字符串转换为整数
    long startLong = Long.parseLong(start);
    long endLong = Long.parseLong(end);

    // 生成卡号并添加到列表中
    for (long i = startLong; i <= endLong; i++) {
      String formattedNumber = String.format("%0" + maxLength + "d", i);
      cardNumbers.add(formattedNumber);
    }

    return cardNumbers;
  }

  public static void main(String[] args) {

    List<String> list = new ArrayList<>();
    for (int i = 1; i <= 500000; i++) {
      String formattedNumber = String.format("%06d", i);
      list.add(formattedNumber);
    }
    String s = String.join(";", list);

    //计算从list中判断是否存在2600耗时
    long startTime = System.currentTimeMillis();
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).equals("242600")) {
        System.out.println("存在242600");
      }
    }
    long endTime = System.currentTimeMillis();
    System.out.println("耗时：" + (endTime - startTime) + "ms");

    // 判断IndexOf(',2600')耗时
    long startTime2 = System.currentTimeMillis();
    if (s.contains("242600")) {
      System.out.println("存在242600");
    }
    long endTime2 = System.currentTimeMillis();
    System.out.println("耗时：" + (endTime2 - startTime2) + "ms");

  }

  public static String stringToAscii(String value) {
    StringBuffer sbu = new StringBuffer();
    char[] chars = value.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      int c = (int) chars[i];
      if (c > 64) {
        sbu.append(c - 64);
      } else {
        sbu.append(chars[i]);
      }
      //      if (i != chars.length - 1) {
      //        sum += (int) chars[i];
      //        sbu.append((int) chars[i]).append(",");
      //      } else {
      //        sum += (int) chars[i];
      //        sbu.append((int) chars[i]);
      //      }
    }

    return sbu.toString();
  }

  private static void screenTest() {
    int screenW = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    System.out.println(screenW);
  }

  private static String rebuildPrintInfo(String message) {
    String PRINTBARCODE_FUNCTION = "printBarCode/([\\s\\S]*?)/";
    String prefix, barcode, suffix;
    Pattern p = Pattern.compile(PRINTBARCODE_FUNCTION);
    String printInfo = null;
    Matcher m = p.matcher(message);
    int length = 20;
    if (m.find()) {
      String function = m.group(0);
      if (function.matches(PRINTBARCODE_FUNCTION)) {
        barcode = m.group(1);

        prefix = message.substring(0, message.indexOf(barcode));
        suffix = message.substring(message.indexOf(barcode) + barcode.length());

        barcode = barcode.trim() + ",\n" + length;
        System.out.println("prefix=" + prefix);
        System.out.println("barcode=" + barcode);
        System.out.println("suffix=" + suffix);

        printInfo = prefix + barcode + suffix;
      }
    }
    return printInfo;
  }
}
