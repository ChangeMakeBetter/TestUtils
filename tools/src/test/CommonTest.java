package test;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.swing.ImageIcon;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

/**
 * TestUtils<br> Created by yangxiaohua on 2019/11/15.
 */
public class CommonTest {
    /**
     * jpg图片的缩放
     * @param originalFile	原图片路径
     * @param resizedFile	缩放后图片的路径
     * @param newWidth	缩放后图片的宽度
     * @param newHeight	缩放后图片的高度【当isScale为false时newHeight不起作用】
     * @param isScale	是否按比例缩放
     * @param quality	缩放质量
     * @throws IOException
     */
    public static void jpgScalePicture(File originalFile, File resizedFile,
      int newWidth, int newHeight, Boolean isScale,
      float quality) throws IOException {
      if (quality > 1) {
        throw new IllegalArgumentException("图片质量是0和1之间");
      }

      ImageIcon ii = new ImageIcon(originalFile.getCanonicalPath());
      Image i = ii.getImage();
      Image resizedImage = null;

      int iWidth = i.getWidth(null);
      int iHeight = i.getHeight(null);

      if(isScale){
        if (iWidth > iHeight) {
          resizedImage = i.getScaledInstance(newWidth, (newWidth * iHeight)/ iWidth, Image.SCALE_SMOOTH);
        } else {
          resizedImage = i.getScaledInstance((newWidth * iWidth) / iHeight, newWidth, Image.SCALE_SMOOTH);
        }
      } else {
        resizedImage = i.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
      }

      // 1这个代码确保图像中的所有像素的加载。
      Image temp = new ImageIcon(resizedImage).getImage();

      // 2创建缓冲的图像。
      BufferedImage bufferedImage = new BufferedImage(temp.getWidth(null), temp.getHeight(null), BufferedImage.TYPE_INT_RGB);

      // 3将图像复制到缓冲的图像。
      Graphics g = bufferedImage.createGraphics();

      // 4背景清晰的图像和画。
      g.setColor(Color.white);
      g.fillRect(0, 0, temp.getWidth(null), temp.getHeight(null));
      g.drawImage(temp, 0, 0, null);
      g.dispose();

      // 4软化。
      float softenFactor = 0.05f;
      float[] softenArray = { 0, softenFactor, 0, softenFactor, 1 - (softenFactor * 4), softenFactor, 0, softenFactor, 0 };
      Kernel kernel = new Kernel(3, 3, softenArray);
      ConvolveOp cOp = new ConvolveOp(kernel, ConvolveOp.EDGE_NO_OP, null);
      bufferedImage = cOp.filter(bufferedImage, null);

      // 6写的JPEG文件。
      FileOutputStream out = new FileOutputStream(resizedFile);

      // 7作为一个JPEG编码图像数据流
      @SuppressWarnings("restriction")
      JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);

      @SuppressWarnings("restriction")
      JPEGEncodeParam param = encoder.getDefaultJPEGEncodeParam(bufferedImage);

      param.setQuality(quality, true);

      encoder.setJPEGEncodeParam(param);
      encoder.encode(bufferedImage);

    }

  public static void main(String[] args) throws IOException {
//    File originalImage = new File("E://imageTest.jpg");
//    File resizedFile = new File("E://aaaaaa.jpg");
//    jpgScalePicture(originalImage, resizedFile, 125, 30, true, 1f);

//    BigDecimal amount = new BigDecimal(299.00);
//    BigDecimal qty = new BigDecimal(1.0);
//    for (int i = 0; i < 2000; i++) {
//      BigDecimal price = amount.divide(qty, 2, RoundingMode.HALF_UP);
//      if (price.compareTo(new BigDecimal(299))!=0) {
//        System.out.println(price);
//      }
//    }

    String platfromFlagStr = "";
    List<String> platfromFlag = Arrays.asList(platfromFlagStr.split(";"));


    System.err.println(platfromFlag.size());
  }
}
