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

  private static final String template2 = "  private className fieldName() {\n"
    + "    return fieldBeanKit.getBean(\"beanName\", className.class);\n"
    + "  }";

  private static Map<String, String> fieldNameMap = new HashMap<>();

  static {
    fieldNameMap.put("ControlSettings", "controlSettings");
    fieldNameMap.put("ClientMgr", "clientMgr");
    fieldNameMap.put("QueryDialogSettings", "dialogSettings");
    fieldNameMap.put("MgrJDBC", "orderMgr");
    fieldNameMap.put("OrderMgr", "orderMgr");
    fieldNameMap.put("Processor", "processor");
    fieldNameMap.put("Service", "service");
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

    String result1 = template;
    if (isInterfaceMode(fieldName)) {
      className = "I" + className;
    }
    result1 = result1.replaceAll("beanName", beanName);
    result1 = result1.replaceAll("className", className);
    result1 = result1.replaceAll("fieldName", fieldName);
    System.out.println(result1);

    String result2 = template2;
    result2 = result2.replaceAll("beanName", beanName);
    result2 = result2.replaceAll("className", className);
    result2 = result2.replaceAll("fieldName", fieldName);
    System.out.println(result2);

    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    clipboard.setContents(new StringSelection(result1 + "\n\n" + result2), null);
  }

  private static boolean isInterfaceMode(String fieldName) {
    return "orderMgr".equals(fieldName) || "processor".equals(fieldName) || "service".equals(fieldName);
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
