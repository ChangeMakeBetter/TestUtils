package test.basejava;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * TestUtils<br> Created by yangxiaohua on 2020/4/20.
 */
public class BaseTest {

  public static void main(String[] args) {
    //
    //    ([\s\S]*?)
    String PRINTBARCODE_FUNCTION = "printBarCode/([\\s\\S]*?),([\\s\\S]*?)/";
    Pattern p = Pattern.compile(PRINTBARCODE_FUNCTION);
    Matcher m = p.matcher("printBarCode/\n123123123/");
    while (m.find()) {
      System.out.println("match");
    }
  }
}

//      try {
//        System.out.println("m.groupCount()=" + m.groupCount());
//        String function = m.group(0);
//        System.out.println("function:" + function);
//        if (function.matches(PRINTBARCODE_FUNCTION)) {
//          String barcode = m.group(1);
//          System.out.println("barcode:" + barcode);
//          String dot = m.group(2);
//          System.out.println("dot:" + dot);
//          String dpi = m.group(3);
//          System.out.println("dpi:" + dpi);
//        }
//      } catch (Exception e) {
//        System.out.println(e.getMessage());
//        throw e;
//      }