/**
 * 版权所有(C)，上海海鼎信息工程股份有限公司，2019，所有权利保留。
 * 项目名：	jpos
 * 文件名：	DigestUtils.java
 * 模块说明：
 * 修改历史：
 * 2019-09-18 - yangxiaohua - 创建。
 */
package sign;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class DigestUtils {
  private static final String MD5_ALGORITHM_NAME = "MD5";
  private static final char[] HEX_CHARS = new char[] {
      '0',
      '1',
      '2',
      '3',
      '4',
      '5',
      '6',
      '7',
      '8',
      '9',
      'a',
      'b',
      'c',
      'd',
      'e',
      'f' };

  public DigestUtils() {
  }

  public static String md5DigestAsHex(byte[] bytes) {
    return digestAsHexString("MD5", bytes);
  }

  private static MessageDigest getDigest(String algorithm) {
    try {
      return MessageDigest.getInstance(algorithm);
    } catch (NoSuchAlgorithmException var2) {
      throw new IllegalStateException("Could not find MessageDigest with algorithm \"" + algorithm + "\"", var2);
    }
  }

  private static byte[] digest(String algorithm, byte[] bytes) {
    return getDigest(algorithm).digest(bytes);
  }

  private static String digestAsHexString(String algorithm, byte[] bytes) {
    char[] hexDigest = digestAsHexChars(algorithm, bytes);
    return new String(hexDigest);
  }

  private static char[] digestAsHexChars(String algorithm, byte[] bytes) {
    byte[] digest = digest(algorithm, bytes);
    return encodeHex(digest);
  }

  private static char[] encodeHex(byte[] bytes) {
    char[] chars = new char[32];

    for (int i = 0; i < chars.length; i += 2) {
      byte b = bytes[i / 2];
      chars[i] = HEX_CHARS[b >>> 4 & 15];
      chars[i + 1] = HEX_CHARS[b & 15];
    }

    return chars;
  }
}
