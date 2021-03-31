package test;

import java.io.IOException;

/**
 * TestUtils<br> Created by yangxiaohua on 2019/11/15.
 */
public class CommonTest {


  public static void main(String[] args) throws IOException {

    String code = "hdxs#0099XS02#202101060001;";

    String codesArr[] = code.split(";");
    for (String s : codesArr) {
      System.out.println(s);
    }
  }
}
