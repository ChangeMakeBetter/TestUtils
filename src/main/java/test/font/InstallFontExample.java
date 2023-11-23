package test.font;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class InstallFontExample {
  public static void main(String[] args) {
    System.out.print("输入类型：delete 代表删除，其他安装:");
    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine();
    System.out.println("Enter type: " + input + "\n");
    boolean delete = "delete".equals(input);
    handleFont("D:\\font\\Alibaba-PuHuiTi-Heavy.ttf", delete);
    handleFont("D:\\font\\Alibaba-PuHuiTi-Medium.ttf", delete);
    handleFont("D:\\font\\Rubik-Black.ttf", delete);
    installFont();
  }

  public static void installFont() {
    //      刷新系统字体缓存
    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    Font[] fonts = ge.getAllFonts(); // 这一步会触发字体缓存的刷新
    for (Font font : fonts) {
      if (font.getName().startsWith("Alibaba")) {
        System.out.println(font.getFontName());
      }
    }
  }

  public static void handleFont(String fontFilePath, boolean delete) {
    try {
      // 获取字体目录
      String fontDir = System.getenv("SystemRoot") + "\\Fonts";

      // 复制字体文件到字体目录
      Path source = new File(fontFilePath).toPath();
      Path target = new File(fontDir, source.getFileName().toString()).toPath();
      if (delete) {
        // 删除字体
        Files.delete(target);
      } else {
        Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
      }

    } catch (IOException e) {
      e.printStackTrace();
      System.err.println("字体安装失败：" + e.getMessage());
    }
  }

}