package aes;

/**
 * TestUtils<br> Created by yangxiaohua on 2019/7/9.
 */

import java.io.IOException;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

  public class AesTest2 {

//    private final static String ORIGIN_KEY = "12jgUQFppppuwkkj";
    private final static String ORIGIN_KEY = "12345678901234567890123456789012";

    private final static SecretKey SECRET_KEY = initSecretKey();

    private static SecretKey initSecretKey() {
      SecretKeySpec aes = new SecretKeySpec(ORIGIN_KEY.getBytes(), "AES");
      return aes;
    }

    /**
     * 加密
     * @param source 一般字符串
     * @return base64Str base64字符串
     * @throws Exception
     */
    public static String encryptAES(String source,String key) throws Exception {
      if (source==null){
        return null;
      }
//      byte[] bytes1 = base642Byte(new Base64().encode(source));
      byte[] byteContent = source.getBytes("utf-8");
      SecretKeySpec aes = new SecretKeySpec(key.getBytes(), "AES");
      Cipher cipher = Cipher.getInstance("AES");
      cipher.init(Cipher.ENCRYPT_MODE, aes);
      byte[] bytes2 = cipher.doFinal(byteContent);
      return byte2Base64(bytes2);
    }

    /**
     * 解密
     * @param base64Code 一般字符串base64
     * @return base64Str
     * @throws Exception
     */
    public static String decryptAES(String base64Code,String key) throws Exception {
      if (base64Code==null){
        return null;
      }
      byte[] bytes1 = base642Byte(base64Code);
      String s2 = new String(bytes1);
      Cipher cipher = Cipher.getInstance("AES");
      SecretKeySpec aes = new SecretKeySpec(key.getBytes(), "AES");
      cipher.init(Cipher.DECRYPT_MODE, aes);
      byte[] bytes2 = cipher.doFinal(bytes1);
      String s = new String(bytes2);
      return s;
    }

    /**
     * 字节数组转Base64编码
     */
    public static String byte2Base64(byte[] bytes) {
      BASE64Encoder encoder = new BASE64Encoder();
      return encoder.encode(bytes);
    }

    /**
     * Base64编码转字节数组
     */
    public static byte[] base642Byte(String base64Key) throws IOException {
      BASE64Decoder decoder = new BASE64Decoder();
      return decoder.decodeBuffer(base64Key);
    }


    public static void main(String[] args) throws Exception {
      String content = "{\n"
        + "  \"Code\": \"0\",\n"
        + "  \"CodeDesc\": \"somethings\",\n"
        + "  \"CardInfo\": {\n"
        + "    \"CardName\": \"东北国际医院会员卡\",\n"
        + "    \"CardNum\": \"100000000920\",\n"
        + "    \"MemberName\": \"张三\",\n"
        + "    \"RemainderMoney\": \"10000\",\n"
        + "    \"TotalIntegral\": \"1008\",\n"
        + "    \"DiscountAmount\": \"10\"\n"
        + "  }\n"
        + "}";
      String password = "12345678901234567890123456789012";
////      String password = "1234567890123456";
//      System.out.println("加密之前：" + content);
//      // 加密
//      String encrypt = AesTest2.encryptAES(content, password);
//      System.out.println("加密后的内容：" + encrypt);

      String res="s731wiLyD1BVDEgaM+q5pXz11YcTWJ+wc+yUbY9519/U2igO4R3prSoDiIH/IKWqdNkoEIYgaYpaXhKl1tavTQ==";
      // 解密
      String decrypt = AesTest2.decryptAES(res, password);
      System.out.println("解密后的内容：" + decrypt);
    }
  }

