package test;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapSortByKeyExample {
  public static void main(String[] args) {
    // 创建一个未排序的 HashMap
    Map<String, Integer> unsortedMap = new HashMap<>();
    unsortedMap.put("1024_768", 10);
    unsortedMap.put("1920_1024", 5);
    unsortedMap.put("800_600", 8);
    unsortedMap.put("1366_768", 15);

    // 使用 TreeMap 对键进行排序
    Map<String, Integer> sortedMap = new TreeMap<>(unsortedMap);

    // 遍历并打印排序后的结果
    System.out.println("按键排序后的结果：");
    for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
      System.out.println(entry.getKey() + ": " + entry.getValue());
    }
  }
}

