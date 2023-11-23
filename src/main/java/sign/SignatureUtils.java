package sign;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;

import static sun.security.x509.CertificateAlgorithmId.ALGORITHM;

public class SignatureUtils {
  private final static String CHARSET_UTF8 = "utf8";

  public static byte[] hmacSHA1Signature(String secret, String baseString) throws Exception {
    if (secret == null || secret.isEmpty()) {
      throw new IOException("secret can not be empty");
    }
    if (baseString == null || baseString.isEmpty()) {
      return null;
    }
    Mac mac = Mac.getInstance("HmacSHA1");
    SecretKeySpec keySpec = new SecretKeySpec(secret.getBytes(CHARSET_UTF8), ALGORITHM);
    mac.init(keySpec);
    return mac.doFinal(baseString.getBytes(CHARSET_UTF8));
  }

  /**
   * Base 64 编码。
   * 
   * @param bytes
   *          原文。
   * @return Base 64 编码。
   */
  public static String newStringByBase64(byte[] bytes) throws UnsupportedEncodingException {
    if (bytes == null || bytes.length == 0) {
      return null;
    }
    return new String(Base64.encodeBase64(bytes, false), CHARSET_UTF8);
  }

  private static final char[] KEY_CHARS = new char[] {
      '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'j', 'k', 'm', 'n', 'p', 'q',
      'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

  public static String generateKey(int length) {
    int len = KEY_CHARS.length - 1;
    char[] arr = new char[length];
    for (int i = 0; i < length; i++) {
      int pos = (int) (Math.random() * len);
      arr[i] = KEY_CHARS[pos];
    }
    return String.valueOf(arr);
  }

  public static String[] SECRET_CHARS = new String[] {
      "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W",
      "X", "Y", "Z" };

  /** 生成一个授权码，数字+字母 */
  public static String generateSecret() {
    SimpleDateFormat format = new SimpleDateFormat("YYYYMMDDhhmmssSSS");
    String prefix = format.format(new Date());
    prefix = StringUtils.reverse(prefix);

    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < 5; i++) {
      builder.append(SECRET_CHARS[Integer.valueOf(prefix.substring(i, i + 1)).intValue()]);
    }

    int len = SECRET_CHARS.length - 1;
    for (int i = 0; i < 5; i++) {
      int pos = (int) (Math.random() * len);
      builder.append(SECRET_CHARS[pos]);
    }

    return builder.toString();
  }

}
