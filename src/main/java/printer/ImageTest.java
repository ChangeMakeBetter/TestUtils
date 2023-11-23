package printer;

/**
 * TestUtils<br> Created by yangxiaohua on 2019/12/5.
 */
public class ImageTest {

  public static void main(String[] args) {
    int width = 800;
    int nl = width % 256;
    int nh = width / 256;
    System.out.println("nl:" + nl + ",nh:" + nh);
    System.out.println(nl + (nh * 256));
  }

}
