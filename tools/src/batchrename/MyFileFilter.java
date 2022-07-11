package batchrename;

import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

public class MyFileFilter implements FileFilter {
  private String matchRegEx, extName;

  public MyFileFilter(String matchRegEx, String extName) {//参数用于accept方法
    this.matchRegEx = matchRegEx;
    this.extName = extName;
  }

  @Override
  public boolean accept(File file) {//符合matchRegEx且以extName结尾时返回true
    return Pattern.matches(matchRegEx, file.getName()) && file.getName().endsWith(extName);
  }
}