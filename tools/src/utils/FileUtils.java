package utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

  public static FilenameFilter javaFileFilter = new FilenameFilter() {
    @Override
    public boolean accept(File dir, String name) {
      return name.endsWith(".java");
    }
  };

  public static FilenameFilter dirFilter = new FilenameFilter() {
    @Override
    public boolean accept(File dir, String name) {
      return new File(dir, name).isDirectory();
    }
  };

  public static FilenameFilter dirHasJavaFilesFilter = new FilenameFilter() {
    @Override
    public boolean accept(File dir, String name) {
      File file = new File(dir, name);
      if (file.isDirectory()) {
        File[] files = file.listFiles(javaFileFilter);
        return files != null && files.length > 0;
      }
      return false;
    }
  };

  /**
   * 搜索file目录下的文件(包括目录), 返回满足filter的文件或目录的列表. 如果file是一个文件, 则返回此文件.
   * 
   * @param file
   * @param filter
   *          null表示不过滤
   * @param recursive
   *          是否递归搜索
   * @return List of File
   */
  public static List<File> listFiles(File file, FilenameFilter filter, boolean recursive) {
    List<File> list = new ArrayList<File>();
    if (file.isFile() && (filter == null || filter.accept(file.getParentFile(), file.getName()))) {
      list.add(file);
    } else {
      File[] files = file.listFiles();
      for (int i = 0; files != null && i < files.length; ++i) {
        if (filter == null || filter.accept(files[i].getParentFile(), files[i].getName())) {
          list.add(files[i]);
        }
        if (recursive && files[i].isDirectory()) {
          list.addAll(listFiles(files[i], filter, recursive));
        }
      }
    }
    return list;
  }

  /**
   * 删除文件或目录. 如果是目录的话, 递归删除这个目录中所有的文件和目录
   * 
   * @param file
   * @return
   */
  public static boolean deleteFile(File file) {
    if (!file.exists()) {
      return true;
    }

    if (file.isFile()) {
      return file.delete();
    } else {
      File[] files = file.listFiles();
      for (int i = 0; i < files.length; ++i) {
        if (!deleteFile(files[i])) {
          return false;
        }
      }
      return file.delete();
    }
  }

  public static boolean deleteSubFile(File file) {
    if (!file.exists()) {
      return true;
    }

    if (file.isFile()) {
      return false;
    }

    File[] files = file.listFiles();
    for (int i = 0; i < files.length; ++i) {
      if (!deleteFile(files[i])) {
        return false;
      }
    }
    return true;
  }

  /**
   * 取得目录dir中最新的limit个文件.
   * 
   * @param dir
   * @param limit
   * @param recursive
   *          是否递归包含子目录
   * @return list of File
   */
  public static List getLastestFiles(File dir, FilenameFilter filter, int limit, boolean recursive) {
    List files = listFiles(dir, filter, recursive);
    // 按时间倒序排序文件
    for (int i = 0; i < files.size() - 1; ++i) {
      for (int j = i + 1; j < files.size(); ++j) {
        File a = (File) files.get(i);
        File b = (File) files.get(j);
        if (a.lastModified() < b.lastModified()) {
          files.set(i, b);
          files.set(j, a);
        }
      }
    }
    List result = new ArrayList();
    for (int i = 0; result.size() < limit && i < files.size(); ++i) {
      if (((File) files.get(i)).isFile()) {
        result.add(files.get(i));
      }
    }
    return result;
  }

  public static List getLastestFiles(File dir, int limit, boolean recursive) {
    return getLastestFiles(dir, null, limit, recursive);
  }

  public static List getLastestFilesExclude(File dir, String[] excludeDirs, int limit, boolean recursive) {
    return getLastestFiles(dir, new ExcludeDirFilter(excludeDirs), limit, recursive);
  }

  private static class ExcludeDirFilter implements FilenameFilter {
    private String[] dirs;

    public ExcludeDirFilter(String[] dirs) {
      this.dirs = dirs;
    }

    @Override
    public boolean accept(File dir, String name) {
      if (dirs == null) {
        return true;
      }
      File file = new File(dir, name);
      for (int i = 0; i < dirs.length; ++i) {
        if (file.getAbsolutePath().startsWith(dirs[i])) {
          return false;
        }
      }
      return true;
    }
  }

  public static byte[] readStreamBytes(InputStream in) throws IOException {
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    byte[] b = new byte[1024];
    int bytesRead = -1;
    while (-1 != (bytesRead = in.read(b, 0, b.length))) {
      out.write(b, 0, bytesRead);
    }
    out.flush();
    byte[] result = out.toByteArray().clone();
    in.close();
    out.close();
    return result;
  }

  public static String readStreamString(InputStream in) throws IOException {
    return new String(readStreamBytes(in));
  }

  public static List<String> readStreamListOfString(InputStream in, String encoding) throws IOException {
    List<String> lines = new ArrayList<String>();
    LineNumberReader reader = new LineNumberReader(new InputStreamReader(in, encoding));
    String line = reader.readLine();
    while (line != null) {
      lines.add(line);
      line = reader.readLine();
    }
    return lines;
  }

  public static long getFileSize(File file) {
    if (file.isFile()) {
      return file.length();
    }
    List<File> files = listFiles(file, null, true);
    long size = 0;
    for (File f : files) {
      size += f.length();
    }
    return size;
  }



  // ////////////////////////////////////////////////////
  //
  // 文件摘要
  //
  // ////////////////////////////////////////////////////

  /**
   * 检查dataFile的MD5摘要和md5File中内容是否相等. 如果md5File==null或不存在, 认为相等.
   * 
   * @param dataFile
   * @param md5File
   * @return
   * @throws Exception
   */
  public static boolean verifyMd5(File dataFile, File md5File) throws Exception {
    if (md5File == null || !md5File.exists()) {
      return true;
    }
    String fd = "";
    FileInputStream is = new FileInputStream(md5File);
    try {
      byte[] b = new byte[32];
      is.read(b);
      fd = new String(b, "UTF-8");
    } finally {
      is.close();
    }
    String d = md5(dataFile);
    return d.equals(fd);
  }

  /**
   * 对dataFile做md5摘要存入文件md5File中.
   * 
   * @param dataFile
   * @param md5File
   * @throws Exception
   */
  public static void createMd5(File dataFile, File md5File) throws Exception {
    String d = md5(dataFile);
    if (!md5File.getParentFile().exists()) {
      md5File.getParentFile().mkdirs();
    }
    FileOutputStream os = new FileOutputStream(md5File);
    try {
      os.write(d.getBytes("UTF-8"));
      os.flush();
      os.getFD().sync();
    } finally {
      os.close();
    }
  }

  public static String md5(File file) throws Exception {
    MessageDigest md = MessageDigest.getInstance("MD5");
    int len;
    byte[] b = new byte[8 * 1024];
    FileInputStream in = new FileInputStream(file);
    try {
      while (-1 != (len = in.read(b, 0, b.length))) {
        md.update(b, 0, len);
      }
    } finally {
      in.close();
    }
    byte[] d = md.digest();
    StringBuilder sb = new StringBuilder();
    for (byte i : d) {
      String s = Integer.toHexString(i & 0x000000ff);
      if (s.length() < 2) {
        sb.append("0");
      }
      sb.append(s);
    }
    return sb.toString();
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

  public static boolean isUtf8(File file) throws IOException {
    if (file == null || !file.exists() || file.isDirectory()) {
      return false;
    }

    InputStream in = new java.io.FileInputStream(file);
    byte[] b = new byte[3];
    in.read(b);
    in.close();
    if (b[0] == -17 && b[1] == -69 && b[2] == -65) {
      return true;
    } else {
      return false;
    }
  }

}