package regular;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * </br>
 * Created by yangxiaohua on 2023/3/27.
 */
public class NormalRegularTest {

  public static void main(String[] args) {
    //    String data = "ABCD111 printQRcode(qwerqwer,2,3,4,5,6,7) ccc";
    //
    //    String PRINTQRCODE_FUNCTION = "printQRcode\\(([\\s\\S]*?),([\\s\\S]*?),([\\s\\S]*?),([\\s\\S]*?),([\\s\\S]*?),(.*?),([\\s\\S]*?)\\)";
    //    Pattern p = Pattern.compile(PRINTQRCODE_FUNCTION);
    //    Matcher m = p.matcher(data);
    //    while (m.find()) {
    //      String function = m.group(0);
    //      System.out.println(function);
    //      String text = m.group(1);
    //      System.out.println(text);
    //    }

    String s = "      if (ckdir == null) {\n"
      + "        throw new Exception(getErrorMsg(JposErrorCode.STOREPACKCKDIRORDER_1, \"notFoundCkdir\"));\n"
      + "      }";

    String prefix = "prefix555.";
    Pattern p = Pattern.compile("getErrorMsg\\(JposErrorCode.*, +\".*\"\\)");
    Matcher m = p.matcher(s);
    while (m.find()) {
      StringTokenizer st = new StringTokenizer(m.group(), "\n");
      while (st.hasMoreTokens()) {
        System.out.println((prefix + st.nextToken().split("\"")[1]));
      }
    }

    Map<String, BigDecimal> map = new HashMap<>();
    map.put("123", BigDecimal.TEN);
    map.put("223", BigDecimal.ONE);
    System.out.println(map);

    //    String s = "      if (ckdir == null) {\n"
    //      + "        throw new Exception(getMessageBase(\"notFoundCkdir\"));\n"
    //      + "      }";
    //    String prefix = "prefix555.";
    //    Pattern p = Pattern.compile("getMessageBase\\(\".*\"\\)");
    //    Matcher m = p.matcher(s);
    //    while (m.find()) {
    //      StringTokenizer st = new StringTokenizer(m.group());
    //      while (st.hasMoreTokens()) {
    //        System.out.println(st.nextToken());
    //        //        System.out.println((prefix + st.nextToken().split("\"")[1]));
    //      }
    //    }
    //    int i = 0;
    //    while (m.find()) {
    //      System.out.println(m.group(i++));
    //      System.out.println("Index: " + m.start(0));
    //    }
    //
    //    String regex = "(G*G)";  //正则的G* 代表这个G可有可无，不要和idea的搞混,idea中的查询是表示以G开头的
    //
    //    Pattern pattern
    //      = Pattern.compile(regex);
    //
    //    String stringToBeMatched = "GFG";
    //
    //    Matcher matcher
    //      = pattern
    //      .matcher(stringToBeMatched);
    //
    //    MatchResult result
    //      = matcher.toMatchResult();
    //    System.out.println("当前的匹配器: "
    //      + result);
    //
    //    i = 0;
    //    while (matcher.find()) {
    //      System.out.println(matcher.group(i++));
    //      System.out.println(matcher.start());
    //    }
  }
}
