package test;

import utils.HexUtils;

/**
 * TestUtils<br> Created by yangxiaohua on 2019/11/21.
 */
public class HexTest {
  public static void main(String[]  args){
    int a = 256;
    System.out.println(Integer.toHexString(a));
    byte b[] = {(byte)a};
    System.out.println(HexUtils.bytesToHexString(b));
  }
}
