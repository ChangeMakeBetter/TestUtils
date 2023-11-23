package test;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.lang3.StringUtils;

/**
 * @author guiziwen
 * @date 2023/10/25 10:45
 */
public class ZhiJianCBCUtil {

  /**
   * 加密模式之 CBC，算法/模式/补码方式
   */
  private static final String AES_CBC = "AES/CFB/NoPadding";
  private static final String AES_CFB_NO = "AES/CFB/NoPadding";
  private static final String IV = "2110l802X081123!";
  private static final Integer IV_LENGTH = 16;

  /***
   * <h2>初始化向量（IV），它是一个随机生成的字节数组，用于增加加密和解密的安全性</h2>
   */
  public static String getIV() {
    String str = "2110l802X081123!";
    Random random = new Random();
    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < IV_LENGTH; i++) {
      int number = random.nextInt(str.length());
      sb.append(str.charAt(number));
    }
    return sb.toString();
  }

  /***
   * <h2>获取一个 AES 密钥规范</h2>
   */
  public static SecretKeySpec getSecretKeySpec(String key) {
    SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "AES");
    return secretKeySpec;
  }

  /**
   * <h2>解密 - 自定义加密模式</h2>
   *
   * @param text 需要解密的文本内容
   * @param key  解密的密钥 key
   * @param iv   初始化向量
   * @param mode 加密模式
   */
  public static String decrypt(String text, String key, String iv, String mode) {
    if (StringUtils.isEmpty(text) || StringUtils.isEmpty(key) || StringUtils.isEmpty(iv)) {
      return null;
    }

    // 将密文转换为16字节的字节数组
    byte[] textBytes = Base64.getDecoder().decode(text);

    try {
      // 创建AES加密器
      Cipher cipher = Cipher.getInstance(mode);

      SecretKeySpec secretKeySpec = getSecretKeySpec(key);

      cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, new IvParameterSpec(iv.getBytes(StandardCharsets.UTF_8)));

      // 解密字节数组
      byte[] decryptedBytes = cipher.doFinal(textBytes);

      // 将明文转换为字符串
      return new String(decryptedBytes, StandardCharsets.UTF_8);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public static String decrypt(String text, String key) throws Exception {

    try {
      return decrypt(text, key, IV, AES_CBC);
    } catch (Exception e) {
      throw new Exception("解码失败！");
    }
  }

  /**
   * <h2>加密 - 自定义加密模式</h2>
   *
   * @param text 需要加密的文本内容
   * @param key  加密的密钥 key
   * @param iv   初始化向量
   * @param mode 加密模式
   */
  public static String encrypt(String text, String key, String iv, String mode) {
    if (StringUtils.isEmpty(text) || StringUtils.isEmpty(key) || StringUtils.isEmpty(iv)) {
      return null;
    }

    try {
      // 创建AES加密器
      Cipher cipher = Cipher.getInstance(mode);

      SecretKeySpec secretKeySpec = getSecretKeySpec(key);

      cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, new IvParameterSpec(iv.getBytes(StandardCharsets.UTF_8)));

      // 加密字节数组
      byte[] encryptedBytes = cipher.doFinal(text.getBytes(StandardCharsets.UTF_8));

      // 将密文转换为 Base64 编码字符串
      return Base64.getEncoder().encodeToString(encryptedBytes);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public static void main(String[] args) {
    Date currentTime = new Date();
    long milliseconds = currentTime.getTime();
    long timestamp = milliseconds / 1000;

    List<String> coupons = new ArrayList<>();
    coupons.add("0550094525402507173");
    coupons.add("0559661134998391322");
    coupons.add("0557303621204999805");

    for (String coupon : coupons) {
      String encryptTextCBC = encrypt("2" + timestamp + coupon, "18596328l1X8!150", IV, AES_CFB_NO);
      System.out.println(encryptTextCBC);
    }

    //    System.out.println(decrypt("ZazYPTS5JNCu4YpMHG1/SFBC6HDBE/mZ1Cn", "18596328l1X8!150"));
  }

}
