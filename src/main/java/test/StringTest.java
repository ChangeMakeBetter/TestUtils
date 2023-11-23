package test;

/**
 * </br>
 * Created by yangxiaohua on 2023/10/18.
 */
public class StringTest {
  private static String getCommonFileName() {
    // String storeNo = request.getParameter("storeNo");
    // String fileName = request.getParameter("fileName");
    String storeNo = "999";
    String fileName = "data/printer/file/999/1.png";
    int storeNoLength = storeNo.length();

    String commonFileName = fileName.substring(0, fileName.indexOf(storeNo) - 1)
      + fileName.substring(fileName.indexOf(storeNo) + storeNoLength);
    System.out.println(commonFileName);
    return commonFileName;
  }

  public static void main(String[] args) {
    getCommonFileName();
  }
}
