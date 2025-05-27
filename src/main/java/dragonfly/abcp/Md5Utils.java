package dragonfly.abcp;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * </br>
 * Created by yangxiaohua on 2024/11/28.
 */
public class Md5Utils {

  public static void main(String[] args) {
    try {
      System.out.println(echoMd5("D:\\temp\\abcp-6.4.182.8.exe"));
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

  }

  private static String echoMd5(String filePath)
    throws IOException, NoSuchAlgorithmException {
    MessageDigest md = MessageDigest.getInstance("MD5");
    FileInputStream fis = new FileInputStream(filePath);
    byte[] dataBytes = new byte[1024];
    int nread;
    while ((nread = fis.read(dataBytes)) != -1) {
      md.update(dataBytes, 0, nread);
    }
    fis.close();
    byte[] mdBytes = md.digest();
    StringBuilder hexString = new StringBuilder();
    for (byte mdByte : mdBytes) {
      hexString.append(Integer.toHexString((mdByte & 0xff) | 0x100).substring(1, 3));
    }
    return hexString.toString();
  }

}
