package printer;

import java.awt.image.BufferedImage;

import org.krysalis.barcode4j.HumanReadablePlacement;
import org.krysalis.barcode4j.impl.code128.Code128Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;
import org.krysalis.barcode4j.tools.UnitConv;

import utils.ImageUtils;

/**
 * TestUtils<br> Created by yangxiaohua on 2019/12/24.
 */
public class Barcode4jTest {

  public static void main(String[] args) {
    Barcode4jTest test = new Barcode4jTest();

    String fileName = "E:\\pic\\barcode4jbmp.bmp";
    try {
      BufferedImage bmp = test.getBarCodeImg("1191905623290265601", 50);
      ImageUtils.saveImageFile(bmp, fileName);
      //            ImageUtils.saveImageFile(test.getBarcode("1191905623290265601", 120, 50), fileName);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private BufferedImage getBarCodeImg(String barcode, int dpi) throws Exception {
    try {
      if (barcode == null) {
        return null;
      }
      // Create the barcode bean
      Code128Bean bean = new Code128Bean();

      // Configure the barcode generator
      // makes the narrow bar width exactly one pixel
      bean.setModuleWidth(UnitConv.in2mm(1.0f / dpi));

      // 条码图片旁边是否留空白
      bean.doQuietZone(false);

      // Set up the canvas provider for monochrome JPEG output
      BitmapCanvasProvider canvas = new BitmapCanvasProvider(dpi, BufferedImage.TYPE_BYTE_BINARY, false, 0);

      // 二维码周围是否显示字符串，上下无，三种情况
      bean.setMsgPosition(HumanReadablePlacement.HRP_NONE);
      // Generate the barcode
      bean.generateBarcode(canvas, barcode);

      return canvas.getBufferedImage();
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
  }
}
