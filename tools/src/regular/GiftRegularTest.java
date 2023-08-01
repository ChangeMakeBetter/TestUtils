package regular;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JTextPane;
import javax.swing.text.Style;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

/**
 * </br>
 * Created by yangxiaohua on 2023/3/27.
 */
public class GiftRegularTest {

  //  private static String content = "可赠商品0100029001(1*1,两用螺丝刀)或商品0100039081(1*1,咱们裸熊-白熊tritan杯540ml)或商品0100039091(1*1,咱们裸熊-棕熊tritan杯540ml)，最多3个。";
  private static String content = "可赠商品0100029001(1*1,两用螺丝刀)";

  public static void main(String[] args) {
    JTextPane jtp = new JTextPane();
    StyledDocument doc = jtp.getStyledDocument();
    try {
      doc.remove(0, doc.getLength());
      content = processingContent(content);
      String goods = "(商品"
        + "([\\s]?)([0-9a-zA-Z]*?)\\()|(([0-9]+(.[0-9]{2})?)"
        + "个" + "([0-9a-zA-Z]+)(,\\s)*)";
      System.out.println("reg:" + goods);
      Pattern pattern = Pattern.compile(goods);
      System.out.println("gift content:" + content);
      Matcher matcher = pattern.matcher(content);

      int start = 0, end = 0;
      while (matcher.find()) {
        // 条码([0-9a-zA-Z]*?)的匹配组坐标,3(3是普通商品条码)或7(7是换购组合商品促销提示匹配)
        int index = 3;
        end = matcher.start(index);
        System.out.println("content:" + content.substring(start, end));
        doc.insertString(doc.getLength(), content.substring(start, end),
          getNormalStyle(doc, content.substring(start, end)));
        System.out.println("group:" + matcher.group(index));
        doc.insertString(doc.getLength(), matcher.group(index),
          getButtonStyle(doc, matcher.group(index), doc.getLength()));
        start = matcher.end(index);
        end = matcher.end();
        System.out.println("content:" + content.substring(start, end));
        doc.insertString(doc.getLength(), content.substring(start, end),
          getNormalStyle(doc, content.substring(start, end)));
        start = end;
      }

      doc.insertString(doc.getLength(), content.substring(start), getNormalStyle(doc, content.substring(start)));

      System.out.println(doc.getText(0, doc.getLength()));
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

  }

  private static String processingContent(String content) {
    String orTag = "或";
    String wrap = orTag.substring(0, 1) + "\n" + orTag.substring(1);
    // 关键符号：'或'换行
    content = content.replaceAll(orTag, wrap);
    // 关键符号：'。'换行
    content = content.replaceAll("。", "。\n");
    // 针对换购组合商品的促销提示进行换行处理(促销提示无。结尾，上述步骤无法处理，另外处理)
    Pattern pattern = Pattern.compile("个([0-9a-zA-Z]+)(,\\s)*");
    Matcher matcher = pattern.matcher(content);

    StringBuffer sb = new StringBuffer();
    int start = 0, end = 0;

    while (matcher.find()) {
      end = matcher.start();
      String subStr = content.substring(start, end);
      if (subStr.startsWith("\n")) {
        sb.append("。\n");
      }

      sb.append(subStr);
      sb.append(matcher.group());

      start = matcher.end();
      end = matcher.end();
    }

    if (sb.length() > 0) {
      sb.append("。\n");
    }
    return sb + content.substring(start);
  }

  private static Style getNormalStyle(StyledDocument doc, String name) {
    Style def = StyleContext.getDefaultStyleContext().getStyle(StyleContext.DEFAULT_STYLE);
    return doc.addStyle("regular", def);
  }

  private static Style getButtonStyle(StyledDocument doc, String name, int position) {
    Style buttonStyle = StyleContext.getDefaultStyleContext().getStyle(StyleContext.DEFAULT_STYLE);
    return buttonStyle;
  }
}
