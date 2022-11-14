package move;

import java.awt.Desktop;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Properties;

/**
 * </br>
 * Created by yangxiaohua on 2022/11/14.
 */
public class MoveData {

  public static void main(String[] args) {
    FileInputStream inStream = null;
    try {
      String property = System.getProperty("user.home");
      File hdInstall = new File(property, "/hd.install");
      if (hdInstall.exists()) {
        Properties properties = new Properties();
        inStream = new FileInputStream(hdInstall);
        properties.load(inStream);
        String hd_home = properties.getProperty("HD_HOME");

        File[] files = orderByDate("");
        File sourceFile = files[0];
        System.out.println("sourceFile" + sourceFile.getName());
        File targetFile = new File(hd_home + "/jpos/init/data/" + sourceFile.getName());
        copyFile(sourceFile, targetFile);

        Desktop.getDesktop().open(targetFile.getParentFile());
      }
    } catch (Exception e) {
      System.out.println("error:" + e.getMessage());
    } finally {
      try {
        if (inStream != null) {
          inStream.close();
        }
      } catch (IOException e) {
      }
    }
  }

  public static File[] orderByDate(String filePath) {
    File file = new File(filePath);
    System.out.println("file:" + file.getAbsolutePath());
    File[] files = file.listFiles(file1 -> {
        String fileName = file1.getName();
        return !fileName.endsWith("bat") && !fileName.endsWith("jar");
      }
    );
    assert files != null;
    Arrays.sort(files, new Comparator<File>() {
      @Override
      public int compare(File f1, File f2) {
        long diff = f1.lastModified() - f2.lastModified();
        if (diff > 0) {
          return -1;
        } else if (diff == 0) {
          return 0;
        } else {
          return 1;//如果 if 中修改为 返回-1 同时此处修改为返回 1  排序就会是递减,如果 if 中修改为 返回1 同时此处修改为返回 -1  排序就会是递增,
        }
      }

      @Override
      public boolean equals(Object obj) {
        return true;
      }

    });
    return files;

  }

  public static void copyFile(File sourceFile, File targetFile) throws IOException {
    FileInputStream input = new FileInputStream(sourceFile);
    BufferedInputStream inBuff = new BufferedInputStream(input);

    FileOutputStream output = new FileOutputStream(targetFile);
    BufferedOutputStream outBuff = new BufferedOutputStream(output);

    // 缓冲数组
    byte[] b = new byte[1024 * 5];
    int len;
    while ((len = inBuff.read(b)) != -1) {
      outBuff.write(b, 0, len);
    }
    outBuff.flush();

    // 关闭流
    inBuff.close();
    outBuff.close();
    output.close();
    input.close();
  }

}
