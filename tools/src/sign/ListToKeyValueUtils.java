package sign;

/**
 * </br>
 * Created by yangxiaohua on 2023/5/31.
 */

import java.util.ArrayList;
import java.util.List;

public class ListToKeyValueUtils {

  public static String convertListToKeyValue(List<?> list, String prefix) {
    StringBuilder stringBuilder = new StringBuilder();
    convertListToKeyValue(stringBuilder, list, prefix);
    return stringBuilder.toString();
  }

  private static void convertListToKeyValue(StringBuilder stringBuilder, List<?> list, String prefix) {
    if (list != null && !list.isEmpty()) {
      for (int i = 0; i < list.size(); i++) {
        String elementPrefix = prefix + "[" + i + "]";
        Object element = list.get(i);

        if (element instanceof List) {
          convertListToKeyValue(stringBuilder, (List<?>) element, elementPrefix);
        } else {
          //          BeanMap beanMap = new BeanMap(element);
          //          List<String> keyValuePairs = beanMap.entrySet().stream()
          //            .map(entry -> elementPrefix + "." + entry.getKey() + "=" + entry.getValue())
          //            .collect(Collectors.toList());
          //          stringBuilder.append(String.join("&", keyValuePairs)).append("&");
        }
      }
    }
  }

  public static void main(String[] args) {
    ComplexObject object1 = new ComplexObject("Alice", 25);
    ComplexObject object2 = new ComplexObject("Bob", 30);
    List<Object> list = new ArrayList<>();
    list.add(object1);
    list.add(object2);

    String result = convertListToKeyValue(list, "persons");
    System.out.println(result);
  }
}
