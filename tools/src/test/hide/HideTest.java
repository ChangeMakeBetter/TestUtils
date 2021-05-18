package test.hide;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 脱敏</br> Created by yangxiaohua on 2021/4/21.
 */
public class HideTest {

  public static void main(String[] args) {
    String mobile = "17611111111";
    String regex = "(\\d{3})(\\d*)(\\d{4})";

    //    String str = mobile.replaceAll(regex,"$1****$3");

    //      System.out.println(str);

    Matcher m = Pattern.compile(regex).matcher(mobile);
    if (m.find()) {
      String rep = m.group(2);
      String head = m.group(1);
      String tail = "";
      if (m.groupCount() > 2) {
        tail = mobile.substring(m.group(1).length() + m.group(2).length());
      }
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < rep.length(); i++) {
        sb.append("*");
      }
      System.out.println(head + sb + tail);
    }

    String name = "张安军哈哈哈";
    String nameRegex = "([\\s\\S]{4})([\\s\\S]*)";

    Matcher m2 = Pattern.compile(nameRegex).matcher(name);
    if (m2.find()) {
      String rep = m2.group(2);
      String head = m2.group(1);
      String tail = "";
      if (m2.groupCount() > 2) {
        tail = name.substring(m2.group(1).length() + m2.group(2).length());
      }
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < rep.length(); i++) {
        sb.append("*");
      }
      //      System.out.println(name.replaceFirst(rep, sb.toString()));

      System.out.println(head + sb + tail);
    }
  }
}
