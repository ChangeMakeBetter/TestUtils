package regular;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * </br>
 * Created by yangxiaohua on 2023/12/13.
 */
public class RegularTest {

  public static void main(String[] args) {
    String txt = "/*<tag>*/ //test /*</tag>*/";
    System.out.println(replaceAnotation(txt, "", "1234"));
  }

  private static String replace(String text, String tag, String replacement) {
    String regExp = "(/\\* *<tag> *\\*/[^/]+/\\* *</tag> *\\*/)";
    Pattern pattern = Pattern.compile(regExp, Pattern.DOTALL);
    Matcher matcher = pattern.matcher(text);
    return matcher.replaceAll(" " + replacement + " ");
  }

  private static String replaceAnotation(String text, String tag, String replacement) {
    String regExp = "(/\\* *<tag> *\\*/.*/\\* *</tag> *\\*/)";
    Pattern pattern = Pattern.compile(regExp, Pattern.DOTALL);
    Matcher matcher = pattern.matcher(text);
    return matcher.replaceAll(" " + replacement + " ");
  }
}
