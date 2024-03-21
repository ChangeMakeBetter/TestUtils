package lock;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * </br>
 * Created by yangxiaohua on 2024/1/26.
 */
public class ValueTest {

  public static void main(String[] args) {
    ClassOne one = new ClassOne();
    Map<String, String> m = new HashMap<>();
    Set<String> s = new HashSet<>();
    try {
      m.put("1", "2");
      m.remove("3");

      s.add("1");
      s.add("1");
      s.remove("6");

    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

    //    check(one);
  }

  private static <T> void check(T obj) {
    System.out.println(obj.getClass().getName());
  }
}
