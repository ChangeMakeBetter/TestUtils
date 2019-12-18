/**
 * 版权所有(C)，上海海鼎信息工程股份有限公司，2019，所有权利保留。
 * 项目名：	jpos
 * 文件名：	HexUtils.java
 * 模块说明：
 * 修改历史：
 * 2019-08-19 - yangxiaohua - 创建。
 */
package utils;

import java.util.zip.CRC32;

/**
 * 十六进制处理工具类
 */
public class HexUtils {

  /**
   * 功能描述：将16进制的字符串转换为字节数组,例如有16进制字符串"12345678"<br/>
   * 转换后的结果为：{18, 52 ,86 ,120 };
   *
   * @param hex
   *          需要转换的16进制字符串
   * @return 以字节数组返回转换后的结果
   */
  public static byte[] hexStringToByte(String hex) {
    int len = (hex.length() / 2);
    byte[] result = new byte[len];
    char[] achar = hex.toUpperCase().toCharArray();
    for (int i = 0; i < len; i++) {
      int pos = i * 2;
      result[i] = (byte) (toByte(achar[pos]) << 4 | toByte(achar[pos + 1]));
    }
    return result;
  }

  /**
   * 功能描述：把字节数组转换为十六进制字符串，例如有字节数组<br/>
   * byte [] data = new byte[]{18, 52 ,86 ,120 };转换之后的结果为："12 34 56 78"
   *
   * @param bArray
   *          所要进行转换的数组内容
   * @return 返回转换后的结果，内容用空格隔开
   */
  public static final String bytesToHexString(byte[] bArray) {
    StringBuffer sb = new StringBuffer(bArray.length);
    String sTemp;
    int j = 0; // 此处定义的j用于控制每行输出的数据个�?
    for (int i = 0; i < bArray.length; i++) {
      sTemp = Integer.toHexString(0xFF & bArray[i]);
      if (sTemp.length() < 2) {
        sb.append(0);
      }
      sb.append(sTemp.toUpperCase());
      j++;
    }
    return sb.toString();
  }

  /**
   * 十六进制字符转换成十六进制字节
   *
   * @param c
   *          十六进制字符
   * @return 返回十六进制字节
   */
  private static byte toByte(char c) {
    byte b = (byte) "0123456789ABCDEF".indexOf(c);
    return b;
  }

  public static int hexByte2Int(byte[] hex) {
    return Integer.parseInt(HexUtils.bytesToHexString(hex), 16);
  }

  /**
   * int转换成2字节的byte数组
   *
   * @param value
   *          int值
   * @return 2字节byte数组，高位在前，低位在后
   */
  public static byte[] intToBytes(int value) {
    byte[] src = new byte[2];
    src[0] = (byte) ((value >> 8) & 0xFF);
    src[1] = (byte) (value & 0xFF);
    return src;
  }

  /**
   * 将长度为2的byte数组转换为16位int
   *
   * @param b
   *          字节数组
   * @return
   */
  public static int bytes2int(byte[] b) {
    // byte[] b=new byte[]{1,2,3,4};
    int mask = 0xff;
    int temp = 0;
    int res = 0;
    for (int i = 0; i < 4; i++) {
      res <<= 8;
      temp = b[i] & mask;
      res |= temp;
    }
    return res;
  }

  /**
   * 将长度为2的byte数组转换为16位int
   *
   * @param b
   *          byte[]
   * @return int
   */
  public static int bytes2short(byte[] b) {
    // byte[] b=new byte[]{1,2,3,4};
    int mask = 0xff;
    int temp = 0;
    int res = 0;
    for (int i = 0; i < 2; i++) {
      res <<= 8;
      temp = b[i] & mask;
      res |= temp;
    }
    return res;
  }

  /**
   * 循环冗余校验
   *
   * @param datas
   * @return
   */
  public static byte[] getCrc32(byte[] datas) {
    CRC32 crc32 = new CRC32();
    crc32.update(datas);
    String str = Long.toHexString(crc32.getValue());
    str = formatCRC32Str(str);
    byte[] bytes = HexUtils.hexStringToByte(str);
    return bytes;
  }

  /**
   * 格式化CRC32校验后的字符串
   *
   * @param str
   * @return
   */
  public static String formatCRC32Str(String str) {
    String zeros = "00000000";
    if (str == null || str.length() == 0) {
      return zeros;
    }
    int num = str.length();
    if (num >= 8) {
      return str;
    }
    return zeros.substring(0, 8 - num) + str;
  }

}
