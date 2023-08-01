package test;

import java.awt.Toolkit;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import utils.MyConverter;

/**
 * TestUtils<br> Created by yangxiaohua on 2019/11/15.
 */
public class CommonTest {

  public static void main(String[] args) throws IOException {
    //    00349a

    List<User> list = new ArrayList<>();
    list.add(new User("1", "10"));
    list.add(new User("2", "100"));

    BigDecimal couponAmtTotal =
      list.stream().map(e -> MyConverter.toBigDecimal(e.getBalance()))
        .reduce(BigDecimal.ZERO, BigDecimal::add);
    System.out.println("券总金额：" + couponAmtTotal);

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
