package sign;

import java.util.ArrayList;
import java.util.List;

/**
 * </br>
 * Created by yangxiaohua on 2023/5/31.
 */
public class FormUrlEncodedUtils {

  public static String convertListToFormUrlEncoded(List<?> list, String prefix) {
    StringBuilder stringBuilder = new StringBuilder();
    convertListToFormUrlEncoded(stringBuilder, list, prefix);
    return stringBuilder.toString();
  }

  private static void convertListToFormUrlEncoded(StringBuilder stringBuilder, List<?> list, String prefix) {
    if (list != null && !list.isEmpty()) {
      for (int i = 0; i < list.size(); i++) {
        String elementPrefix = prefix + "[" + i + "]";
        Object element = list.get(i);

        if (element instanceof List) {
          convertListToFormUrlEncoded(stringBuilder, (List<?>) element, elementPrefix);
        } else if (element instanceof ComplexObject) {
          convertObjectToFormUrlEncoded(stringBuilder, (ComplexObject) element, elementPrefix);
        }
      }
    }
  }

  private static void convertObjectToFormUrlEncoded(StringBuilder stringBuilder, ComplexObject object, String prefix) {
    if (object != null) {
      stringBuilder
        .append(prefix).append(".name=").append(object.getName())
        .append("&")
        .append(prefix).append(".age=").append(object.getAge())
        .append("&");
    }
  }

  public static void main(String[] args) {
    ComplexObject object1 = new ComplexObject("Alice", 25);
    ComplexObject object2 = new ComplexObject("Bob", 30);
    List<Object> list = new ArrayList<>();
    list.add(object1);
    list.add(object2);

    String result = convertListToFormUrlEncoded(list, "persons");
    System.out.println(result);
  }
}
