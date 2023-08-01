package jpostools;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * </br>
 * Created by yangxiaohua on 2023/6/6.
 */
public class CreateBeanCode {

  private static final String template = "  @Resource(name = \"beanName\")\n"
    + "  private className fieldName;\n";

  private static Map<String, String> fieldNameMap = new HashMap<>();

  static {
    fieldNameMap.put("ControlSettings", "controlSettings");
    fieldNameMap.put("ClientMgr", "clientMgr");
    fieldNameMap.put("QueryDialogSettings", "dialogSettings");
    fieldNameMap.put("MgrJDBC", "orderMgr");
    fieldNameMap.put("OrderMgr", "orderMgr");
    fieldNameMap.put("Processor", "processor");
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter className: ");
    String input = scanner.nextLine();

    System.out.println("You entered: " + input);

    String className = upperFirstChar(input);
    String beanName = lowerFirstChar(input);
    String fieldName = beanName;
    for (String key : fieldNameMap.keySet()) {
      if (input.endsWith(key)) {
        fieldName = fieldNameMap.get(key);
        break;
      }
    }

    String result = template;
    result = result.replaceAll("beanName", beanName);
    result = result.replaceAll("className", className);
    result = result.replaceAll("fieldName", fieldName);
    System.out.println(result);

    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    clipboard.setContents(new StringSelection(result), null);
  }

  private static String upperFirstChar(String name) {
    if (name == null || "".equals(name)) {
      return name;
    }
    String firstChar = name.substring(0, 1);
    String otherChar = name.substring(1);
    return firstChar.toUpperCase() + otherChar;
  }

  private static String lowerFirstChar(String name) {
    if (name == null || "".equals(name)) {
      return name;
    }
    String firstChar = name.substring(0, 1);
    String otherChar = name.substring(1);
    return firstChar.toLowerCase() + otherChar;
  }

}
