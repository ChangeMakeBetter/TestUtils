/**
 * 版权所有(C)，上海海鼎信息工程股份有限公司，2017，所有权利保留。
 * 
 * 项目名：	pay-core
 * 文件名：	AES.java
 * 模块说明：	
 * 修改历史：
 * 2017-11-9 - qinliming - 创建。
 */
package aes;

import java.net.URLEncoder;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;

/**
 * @author qinliming
 * 
 */
public class AES {

  public static byte[] encode(String encodeKey, byte[] content) throws Exception {
    IvParameterSpec zeroIv = new IvParameterSpec(encodeKey.getBytes());
    SecretKeySpec seKey = new SecretKeySpec(encodeKey.getBytes(), "AES");
    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    cipher.init(Cipher.ENCRYPT_MODE, seKey, zeroIv);
    return cipher.doFinal(content);
  }

  public static byte[] decode(String encodeKey, byte[] content) throws Exception {
    IvParameterSpec zeroIv = new IvParameterSpec(encodeKey.getBytes());
    SecretKeySpec key = new SecretKeySpec(encodeKey.getBytes(), "AES");
    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    cipher.init(Cipher.DECRYPT_MODE, key, zeroIv);

    return cipher.doFinal(content);

  }

  public static byte[] encode_AES_ECB_PKCS5Padding(String encodeKey, byte[] content, String iv)
      throws Exception {
    Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
    SecretKeySpec secretKey = new SecretKeySpec(encodeKey.getBytes(), "AES");
    if (StringUtils.trimToNull(iv) != null) {
      IvParameterSpec ivspec = new IvParameterSpec(iv.getBytes());
      cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivspec);
    } else {
      cipher.init(Cipher.ENCRYPT_MODE, secretKey);
    }

    return cipher.doFinal(content);
  }

  public static byte[] decode_AES_ECB_PKCS5Padding(String encodeKey, byte[] content, String iv)
      throws Exception {
    Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
    SecretKeySpec secretKey = new SecretKeySpec(encodeKey.getBytes(), "AES");
    if (iv != null && StringUtils.trimToNull(iv) != null) {
      IvParameterSpec ivspec = new IvParameterSpec(iv.getBytes());
      cipher.init(Cipher.DECRYPT_MODE, secretKey, ivspec);
    } else {
      cipher.init(Cipher.DECRYPT_MODE, secretKey);
    }
    return cipher.doFinal(content);
  }

  @SuppressWarnings("deprecation")
  public static void main(String[] args) throws Exception {

//    String key = "www.hd123.com.cn";
    String key = "12345678901234567890123456789012";
//    String key = "1234567890123456";

    String tenantId = "wrtjadsk";
    String tenantName = URLEncoder.encode("拾惠惠");
    String apiUsername = "shshh";
    String apiPassword = "y9wmfycevwfcekftIarhvttxpPlo0tng";
    String apiAddress = URLEncoder.encode("https://api.u.hd123.com/" + tenantId + "/pay");

    System.out.println("==================================");
    
    String content = "ti=" + tenantId + "&tn=" + tenantName + "&au=" + apiUsername + "&ap="
        + apiPassword + "&ad=" + apiAddress + "";

    String sign = new String(Base64.encodeBase64String(AES.encode(key, content.getBytes())));
    System.out.println("商户【" + tenantId + tenantName + "】的二维码:" + sign);
    System.out.println("==================================");

    System.out
        .println("LEGFal8UMKCQtlKpP7w5Khy/AqSq5yclWOFj0Va9K2PWvgIlTX3U4+1aeg4upOqlJwTSG6Y50iwmRsebXeMNFA==");
    System.out.println("根据输入的规则" + key + "加密后的密文是:" + sign);

    System.out.println("根据输入的规则" + key + "解密后的明文是:"
        + new String(AES.decode(key, Base64.decodeBase64(sign))));
  }
}
