package config;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * </br>
 * Created by yangxiaohua on 2021/5/18.
 */
public class WriteIni {
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

  public static void main(String[] args) {
    String filePath = "D:\\tinycommand.ini";
    try {
      writeCfgValue(filePath, "tinycommand", "baudrate", "115200");
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }
}

