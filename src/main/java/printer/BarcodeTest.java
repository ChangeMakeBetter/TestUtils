package printer;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Hashtable;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.Code128Writer;

/**
 * TestUtils<br> Created by yangxiaohua on 2019/12/24.
 */
public class BarcodeTest {
  private static final String CODE = "utf-8";

  /**
   * @param args
   */
  public static void main(String[] args) {
    BarcodeTest test = new BarcodeTest();
    test.getBarcodeImg();
    String fileName = "E:\\pic\\barcode7.jpg";
    try {
      //      ImageUtils.saveImageFile(test.getBarcodeImg(), fileName);
      //            ImageUtils.saveImageFile(test.getBarcode("1191905623290265601", 120, 50), fileName);
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  private static BufferedImage toBufferedImage(BitMatrix matrix) {
    int BLACK = 0xFF000000;
    int WHITE = 0xFFFFFFFF;
    int width = matrix.getWidth();
    int height = matrix.getHeight();
    BufferedImage image = new BufferedImage(width, height,
      BufferedImage.TYPE_INT_ARGB);
    for (int x = 0; x < width; x++) {
      for (int y = 0; y < height; y++) {
        image.setRGB(x, y, matrix.get(x, y) ? BLACK : WHITE);
      }
    }
    return image;
  }

  public static BufferedImage getBarcode(String str, int width, int height) {

    //    if (width < 200) {
    //      width = 200;
    //    }

    //    if (height < 50) {
    //      height = 50;
    //    }

    try {
      Hashtable<EncodeHintType, String> hints = new Hashtable<EncodeHintType, String>();
      hints.put(EncodeHintType.CHARACTER_SET, CODE);

      BitMatrix bitMatrix = new MultiFormatWriter().encode(str,
        BarcodeFormat.CODE_128, width, height, hints);

      return toBufferedImage(bitMatrix);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  private BufferedImage getBarcodeImg() {
    try {

      //      Map<EncodeHintType, Object> hints = new HashMap<>();
      //      hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
      // 容错级别 这里选择最高H级别
      //      hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
      //      BitMatrix bitMatrix = new MultiFormatWriter().encode("1191905623290265601",
      //        BarcodeFormat.CODE_128, 150, 30, null);
      //      return getBarcodeBufferedImage(bitMatrix,120,30);
      //      return MatrixToImageWriter.toBufferedImage(bitMatrix);
      String fileName = "E:\\pic\\barcode_100.bmp";
      BitMatrix bitMatrix = new Code128Writer().encode("1191905623290265601", BarcodeFormat.CODE_128, 100, 50, null);
      MatrixToImageWriter.writeToStream(bitMatrix, "png", new FileOutputStream(new File(fileName)));
      System.out.println("Code128 Barcode Generated.");
    } catch (Exception e) {
    }
    return null;
  }

  private BufferedImage getBarcodeBufferedImage(BitMatrix bm, int imageWidth, int imageHeight) {
    int BLACK = 0xFF000000;
    int WHITE = 0xFFFFFFFF;

    // 生成指定边距的图片
    BufferedImage img = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_BGR);
    for (int x1 = 0; x1 < imageWidth; x1++) {
      for (int y1 = 0; y1 < imageHeight; y1++) {
        img.setRGB(x1, y1, bm.get(x1, y1) ? BLACK : WHITE);
      }
    }

    return img;
  }

}
