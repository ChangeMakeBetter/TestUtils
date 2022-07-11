package file.fileFilter;

import java.io.File;
import java.io.FileFilter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * </br>
 * Created by yangxiaohua on 2022/7/11.
 */
public class MyFileFilterTest {

  public static void main(String[] args) {

    File parentDir = new File("D:\\upgradeSchema\\v30r02\\r40msg");

    File[] matchedFiles = parentDir.listFiles(new FileFilter() {
      @Override
      public boolean accept(File pathname) {
        String pattern = "^[\\s\\S]+.(oracle|Oracle).sql$";
        String fileName = pathname.getName();

        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(pathname.getName());
        if (m.find()) {
          String prefix = fileName.substring(0, fileName.indexOf(m.group(1)));
          String suffix = fileName.substring(fileName.indexOf(m.group(1)) + m.group(1).length());
          System.out.println("prefix:" + prefix);
          System.out.println("suffix:" + suffix);
        }

        return Pattern.matches(pattern, fileName);
      }
    });

    for (File matchedFile : matchedFiles) {
      System.out.println("匹配到:" + matchedFile.getName());
    }

  }
}
