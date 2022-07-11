package file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import org.apache.commons.lang3.StringUtils;

/**
 * @author caili
 */
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
   * @param filter    null表示不过滤
   * @param recursive 是否递归搜索
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

  public static void deleteSubFile2(File file) {
    if (!file.exists()) {
      return;
    }

    if (file.isFile()) {
      return;
    }

    File[] files = file.listFiles();
    for (int i = 0; i < files.length; ++i) {
      deleteFile2(files[i]);
    }
  }

  public static void deleteFile2(File file) {
    if (!file.exists()) {
      return;
    }

    if (file.isFile()) {
      file.delete();
    } else {
      File[] files = file.listFiles();
      for (int i = 0; i < files.length; ++i) {
        deleteFile2(files[i]);
      }
      file.delete();
    }
  }

  /**
   * 取得目录dir中最新的limit个文件.
   *
   * @param dir
   * @param limit
   * @param recursive 是否递归包含子目录
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

  public static void extract(ClassLoader cl, String resource, File diskFile) throws IOException {
    InputStream in = null;
    FileOutputStream out = null;
    try {
      in = cl.getResourceAsStream(resource);
      if (in == null) {
        throw new IOException("报错");
      }
      File dest = diskFile;
      if (!dest.getParentFile().exists()) {
        dest.getParentFile().mkdirs();
      }
      out = new FileOutputStream(dest);
      byte[] b = new byte[16 * 1024];
      for (int c = in.read(b); c != -1; c = in.read(b)) {
        out.write(b, 0, c);
      }
      out.flush();
      out.getFD().sync();
    } finally {
      if (in != null) {
        try {
          in.close();
        } catch (Exception e) {
        }
      }
      if (out != null) {
        try {
          out.close();
        } catch (Exception e) {
        }
      }
    }
  }

  public static void extract(ClassLoader cl, String fn, String home) throws IOException {
    InputStream in = null;
    FileOutputStream out = null;
    try {
      in = cl.getResourceAsStream(fn);
      if (in == null) {
        throw new IOException("报错");
      }
      File dest = new File(home, fn);
      if (!dest.getParentFile().exists()) {
        dest.getParentFile().mkdirs();
      }
      out = new FileOutputStream(new File(home, fn));
      byte[] b = new byte[16 * 1024];
      for (int c = in.read(b); c != -1; c = in.read(b)) {
        out.write(b, 0, c);
      }
      out.flush();
      out.getFD().sync();
    } finally {
      if (in != null) {
        try {
          in.close();
        } catch (Exception e) {
        }
      }
      if (out != null) {
        try {
          out.close();
        } catch (Exception e) {
        }
      }
    }
  }

  /**
   * 将file copy 到 toDir目录下
   *
   * @param cl
   * @param filePathName
   * @param fileName
   * @param toDir
   * @throws IOException
   */
  public static void extract(ClassLoader cl, String filePathName, String fileName, String toDir) throws IOException {
    InputStream in = null;
    FileOutputStream out = null;
    try {
      in = cl.getResourceAsStream(filePathName);
      if (in == null) {
        throw new IOException("报错");
      }
      File dest = new File(toDir, fileName);
      if (!dest.getParentFile().exists()) {
        dest.getParentFile().mkdirs();
      }
      out = new FileOutputStream(dest);
      byte[] b = new byte[16 * 1024];
      for (int c = in.read(b); c != -1; c = in.read(b)) {
        out.write(b, 0, c);
      }
      out.flush();
      out.getFD().sync();
    } finally {
      if (in != null) {
        try {
          in.close();
        } catch (Exception e) {
        }
      }
      if (out != null) {
        try {
          out.close();
        } catch (Exception e) {
        }
      }
    }
  }

  /**
   * zipFile必须存在. zipFile中不带子目录. toDir中如果存在同名文件则被覆盖.
   *
   * @param zipFile
   * @param toDir               解压缩到这个目录. 如果不存在则创建.
   * @param fileNamaToUpperCase 是否设置解压后zip内容文件名一个.之前的名称成大写:false=不设置大写,true=设置大写
   * @throws Exception
   */
  public static void unzip(File zipFile, File toDir, boolean fileNamaToUpperCase) throws Exception {
    if (!toDir.exists()) {
      toDir.mkdirs();
    }
    ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFile));
    FileOutputStream os = null;
    try {

      ZipFile zf = null;
      try {
        zf = new ZipFile(zipFile);
      } catch (Exception e) {
        throw new Exception("报错");
      } finally {
        if (zf != null) {
          try {
            zf.close();
          } catch (Exception e) {
          }
        }
      }

      for (ZipEntry entry = zis.getNextEntry(); entry != null; entry = zis.getNextEntry()) {
        if (entry.isDirectory()) {
          throw new Exception("报错");
        }

        StringBuffer entryFileNameSb = new StringBuffer("");
        if (fileNamaToUpperCase) {
          int index = entry.getName().indexOf('.');
          if (index > 0) {
            entryFileNameSb.append(entry.getName().substring(0, index).toUpperCase());
            entryFileNameSb.append(entry.getName().substring(index));
          } else {
            entryFileNameSb.append(entry.getName());
          }
        } else {
          entryFileNameSb.append(entry.getName());
        }

        String entryFileName = entryFileNameSb.toString();
        File toFile = new File(toDir, entryFileName);
        if (toFile.getParentFile() == null || !toFile.getParentFile().exists()) {
          toFile.getParentFile().mkdirs();
        }

        try {
          os = new FileOutputStream(toFile);
          byte[] buffer = new byte[8192];
          int bytesRead;
          while ((bytesRead = zis.read(buffer)) != -1) {
            os.write(buffer, 0, bytesRead);
          }
          os.flush();
          os.getFD().sync();
        } finally {
          if (os != null) {
            try {
              os.close();
            } catch (Exception e) {
            }
          }
          os = null;
        }
        toFile.setLastModified(entry.getTime());
      }
    } catch (Exception e) {
      throw e;
    } finally {
      if (zis != null) {
        try {
          zis.close();
        } catch (Exception e) {
        }
      }
    }
  }

  /**
   * zipFile必须存在. zipFile中不带子目录. toDir中如果存在同名文件则被覆盖.
   *
   * @param zipFile
   * @param toDir   解压缩到这个目录. 如果不存在则创建.
   * @throws Exception
   */
  public static void unzip(File zipFile, File toDir) throws Exception {
    unzip(zipFile, toDir, false);
  }

  public static String readFileContent(File file, String charsetName) throws Exception {
    if (!file.exists()) {
      return null;
    }
    FileInputStream fis = null;
    InputStreamReader isr = null;
    BufferedReader reader = null;
    try {
      fis = new FileInputStream(file);
      isr = new InputStreamReader(fis, charsetName == null ? "UTF-8" : charsetName);
      reader = new BufferedReader(isr);
      StringBuffer result = new StringBuffer();
      String line = reader.readLine();
      while (line != null) {
        result.append(line);
        result.append("\n");
        line = reader.readLine();
      }
      return result.toString();
    } catch (Exception e) {
      throw e;
    } finally {
      try {
        if (reader != null) {
          reader.close();
        }
        if (isr != null) {
          isr.close();
        }
        if (fis != null) {
          fis.close();
        }
      } catch (IOException e) {
      }
    }
  }

  /**
   * 读取文件内容, 文件不存在则返回null.
   *
   * @param file
   * @return
   * @throws Exception
   */
  public static String readFileContent(File file) throws Exception {
    return readFileContent(file, null);
  }

  public static List<String> readFileContentLines(File file) throws Exception {
    return readFileContentLines(file, "UTF-8");
  }

  /**
   * 读取文件内容, 文件不存在则返回null.
   *
   * @param file
   * @return
   * @throws Exception
   */
  public static List<String> readFileContentLines(File file, String charsetName) throws Exception {
    List<String> strLines = new ArrayList<String>();
    if (!file.exists()) {
      return null;
    }
    FileInputStream fis = null;
    InputStreamReader isr = null;
    BufferedReader reader = null;
    try {
      fis = new FileInputStream(file);
      if (charsetName == null) {
        isr = new InputStreamReader(fis);
      } else {
        isr = new InputStreamReader(fis, charsetName);
      }
      reader = new BufferedReader(isr);
      String line = reader.readLine();
      while (line != null) {
        strLines.add(line);
        line = reader.readLine();
      }
      return strLines;
    } finally {
      try {
        if (reader != null) {
          reader.close();
        }
        if (isr != null) {
          isr.close();
        }
        if (fis != null) {
          fis.close();
        }
      } catch (IOException e) {
      }
    }
  }

  // public static int getFileContentLinesNum(File file, String charsetName)
  // throws Exception {
  // Logger logger = Logger.getLogger(FileUtils.class);
  // int lineCount = 0;
  // if (!file.exists()) {
  // return lineCount;
  // }
  // FileInputStream fis = null;
  // InputStreamReader isr = null;
  // BufferedReader reader = null;
  // try {
  // fis = new FileInputStream(file);
  // isr = new InputStreamReader(fis, charsetName);
  // reader = new BufferedReader(isr);
  // String line = reader.readLine();
  // while (line != null) {
  // lineCount++;
  // line = reader.readLine();
  // }
  // return lineCount;
  // } catch (Exception e) {
  // logger.error("read file exception.", e);
  // throw e;
  // } finally {
  // try {
  // if (reader != null) {
  // reader.close();
  // }
  // if (isr != null) {
  // isr.close();
  // }
  // if (fis != null) {
  // fis.close();
  // }
  // } catch (IOException e) {
  // logger.error("close file exception.", e);
  // }
  // }
  // }

  // /**
  // * 读取文件内容, 文件不存在则返回null.
  // *
  // * @param file
  // * @return
  // * @throws Exception
  // */
  // public static String readFileContentLine(File file, String charsetName, int
  // lineIndex) throws Exception {
  // Logger logger = Logger.getLogger(FileUtils.class);
  // List<String> strLines = new ArrayList<String>();
  // if (!file.exists()) {
  // return null;
  // }
  // FileInputStream fis = null;
  // InputStreamReader isr = null;
  // BufferedReader reader = null;
  // try {
  // fis = new FileInputStream(file);
  // isr = new InputStreamReader(fis, charsetName);
  // reader = new BufferedReader(isr);
  // String line = reader.readLine();
  // while (line != null) {
  // strLines.add(line);
  // line = reader.readLine();
  // }
  // return strLines;
  // } catch (Exception e) {
  // logger.error("read file exception.", e);
  // throw e;
  // } finally {
  // try {
  // if (reader != null) {
  // reader.close();
  // }
  // if (isr != null) {
  // isr.close();
  // }
  // if (fis != null) {
  // fis.close();
  // }
  // } catch (IOException e) {
  // logger.error("close file exception.", e);
  // }
  // }
  // }

  /**
   * 写入文件内容
   *
   * @param file
   * @param content
   * @throws Exception
   */
  public static void writeFileContent(File file, String content) throws Exception {
    FileOutputStream fos = null;
    OutputStreamWriter writer = null;
    try {
      file.getParentFile().mkdirs();
      fos = new FileOutputStream(file);
      writer = new OutputStreamWriter(fos, "UTF-8");
      writer.write(content);
      file.setLastModified(System.currentTimeMillis());
      writer.flush();
      fos.getFD().sync();
    } catch (Exception e) {
      throw e;
    } finally {
      try {
        if (writer != null) {
          writer.close();
        }
      } catch (IOException e) {
      }
    }
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

    InputStream in = new FileInputStream(file);
    byte[] b = new byte[3];
    in.read(b);
    in.close();
    if (b[0] == -17 && b[1] == -69 && b[2] == -65) {
      return true;
    } else {
      return false;
    }
  }

  public static FileOutputStream openOutputStream(final File file, final boolean append) throws IOException {
    if (file.exists()) {
      if (file.isDirectory()) {
        throw new IOException("File '" + file + "' exists but is a directory");
      }
      if (!file.canWrite()) {
        throw new IOException("File '" + file + "' cannot be written to");
      }
    } else {
      final File parent = file.getParentFile();
      if (parent != null) {
        if (!parent.mkdirs() && !parent.isDirectory()) {
          throw new IOException("Directory '" + parent + "' could not be created");
        }
      }
    }
    return new FileOutputStream(file, append);
  }

  /**
   * 修改ini配置文件中变量的值
   *
   * @param file     配置文件的路径
   * @param section  要修改的变量所在段名称
   * @param variable 要修改的变量名称
   * @param value    变量的新值
   * @throws IOException 抛出文件操作可能出现的io异常
   */
  public static boolean writeCfgValue(String file, String section, String variable, String value) throws IOException {
    String fileContent, allLine, strLine, newLine, remarkStr = "";
    String getValue = null;
    BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
    boolean isInSection = false;
    boolean canAdd = true;
    fileContent = "";
    try {

      while ((allLine = bufferedReader.readLine()) != null) {
        allLine = allLine.trim();
        strLine = allLine.split(";")[0];
        Pattern p;
        Matcher m;
        p = Pattern.compile("\\[\\w+]");
        m = p.matcher((strLine));
        if (m.matches()) {
          p = Pattern.compile("\\[" + section + "\\]");
          m = p.matcher(strLine);
          if (m.matches()) {
            isInSection = true;
          } else {
            isInSection = false;
          }
        }
        if (isInSection == true) {
          strLine = strLine.trim();
          String[] strArray = strLine.split("=");
          getValue = strArray[0].trim();
          if (getValue.equalsIgnoreCase(variable)) {
            newLine = getValue + "=" + value;
            fileContent += newLine;
            while ((allLine = bufferedReader.readLine()) != null) {
              fileContent += "\r\n" + allLine;
            }
            bufferedReader.close();
            canAdd = false;
            System.out.println(fileContent);
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, false));
            bufferedWriter.write(fileContent);
            bufferedWriter.flush();
            bufferedWriter.close();

            return true;
          }

        }
        fileContent += allLine + "\r\n";
      }
      if (canAdd) {
        String str = variable + "=" + value;
        fileContent += str + "\r\n";
        System.out.println(fileContent);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, false));
        bufferedWriter.write(fileContent);
        bufferedWriter.flush();
        bufferedWriter.close();
      }
    } catch (IOException ex) {
      throw ex;
    } finally {
      bufferedReader.close();
    }
    return false;
  }

  public static final String lineSeparator = System.getProperty("line.separator");

  public static String replaceSystemLineSeparator(String text) {
    if (StringUtils.isEmpty(text)) {
      return text;
    }

    return text.replaceAll("\r", "").replaceAll("\n", lineSeparator);
  }
}