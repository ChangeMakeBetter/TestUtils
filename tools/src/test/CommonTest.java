package test;

import java.awt.Toolkit;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * TestUtils<br> Created by yangxiaohua on 2019/11/15.
 */
public class CommonTest {

  public static void main(String[] args) throws IOException {

    //    BigDecimal total = new BigDecimal(10);
    //    BigDecimal result = total.divide(new BigDecimal(3), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(2));
    //    System.out.println(result);
    screenTest();
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
