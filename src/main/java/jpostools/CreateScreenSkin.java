package jpostools;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

/**
 * </br>
 * Created by yangxiaohua on 2023/8/1.
 */
public class CreateScreenSkin {

  private static Set<String> skinScreenSize = new HashSet<>();

  static {
    skinScreenSize.add("1920_1080");
    skinScreenSize.add("1366_768");
    skinScreenSize.add("1024_768");
    skinScreenSize.add("800_600");
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter skin: \n");

    try {
      Map<String, StringBuilder> map = new HashMap<>();
      String prefix, suffix;
      String input;
      while (!(input = scanner.nextLine()).isEmpty()) {
        for (String s : skinScreenSize) {
          if (input.contains(s)) {
            prefix = input.substring(0, input.indexOf(s));
            suffix = input.substring(input.indexOf(s) + s.length());
            addToMap(map, prefix, suffix);
          }
        }
      }

      StringBuilder result = new StringBuilder();

      Map<String, StringBuilder> sortedMap = new TreeMap<>(map);
      for (StringBuilder value : sortedMap.values()) {
        result.append(value).append("\n");
      }
      System.out.println(result.toString());

      Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
      clipboard.setContents(new StringSelection(result.toString()), null);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  private static void addToMap(Map<String, StringBuilder> map, String prefix, String suffix) {
    for (String screen : skinScreenSize) {
      if (map.containsKey(screen)) {
        StringBuilder sb = map.get(screen);
        sb.append(prefix).append(screen).append(suffix).append("\n");
      } else {
        StringBuilder sb = new StringBuilder();
        sb.append(prefix).append(screen).append(suffix).append("\n");
        map.put(screen, sb);
      }
    }
  }

}
