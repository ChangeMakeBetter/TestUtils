package utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.swing.ImageIcon;

import org.apache.commons.codec.binary.Base64;

import sun.awt.image.URLImageSource;

/**
 * 图片处理工具
 * 
 */
public class ImageUtils {

  /**
   * 生成图片
   * 
   * @param imgData
   *          Base64编码的图片数据
   * @param imageFile
   *          生成的图片文件
   * @return
   */
  public static boolean generateImage(String imgData, File loacalFile) throws Exception { // 对字节数组字符串进行Base64解码并生成图片
    if (imgData == null) { // 图像数据为空
      return false;
    }
    if (loacalFile.exists()) {
      loacalFile.delete();
    }
    if (!loacalFile.getParentFile().exists()) {
      loacalFile.getParentFile().mkdirs();
    }

    try {
      byte[] b = getImageBytes(imgData);

      // 生成图片
      OutputStream out = new FileOutputStream(loacalFile);
      out.write(b);
      out.flush();
      out.close();
      BufferedImage srcImg = ImageIO.read(new FileInputStream(loacalFile));
      int toWidth = srcImg.getWidth(null);
      int toHeight = srcImg.getHeight(null);

      if (toWidth < 120) {
        // 太小的多放大一点
        toWidth = (int) (toWidth * 3);
        toHeight = (int) (toHeight * 3);
      } else if (toWidth < 190) {
        toWidth = (int) (toWidth * 2);
        toHeight = (int) (toHeight * 2);
      } else {
        return true;
      }
      BufferedImage result = new BufferedImage(toWidth, toHeight, srcImg.getType());
      result.getGraphics().drawImage(srcImg.getScaledInstance(toWidth, toHeight, Image.SCALE_SMOOTH), 0, 0, null);

      ImageIO.write(result, "jpg", loacalFile);
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  /**
   * 获取图片的Base64编码字节数组
   * 
   * @param imgData
   *          Base64编码的图片数据
   * @return
   */
  public static byte[] getImageBytes(String imgData) throws Exception {
    if (imgData == null) { // 图像数据为空
      return null;
    }

    // Base64解码
    byte[] b = new Base64().decode(imgData);
    for (int i = 0; i < b.length; ++i) {
      if (b[i] < 0) {// 调整异常数据
        b[i] += 256;
      }
    }

    return b;
  }

  /**
   * 获取图片的ImageIcon
   * 
   * @param imgData
   *          Base64编码的图片数据
   * @return
   */
  public static ImageIcon getImageIcon(String imgData) throws Exception {
    return new ImageIcon(getImageBytes(imgData));
  }

  /**
   * 获得图片的Base64编码
   * 
   * @param path
   *          图片文件地址
   * @return
   */
  public static String getImageStr(String imageFilePath) throws Exception {
    if (imageFilePath == null) {
      return null;
    }

    InputStream in = null;
    byte[] data = null;
    // 读取图片字节数组
    try {
      in = new FileInputStream(imageFilePath);
      data = new byte[in.available()];
      in.read(data);

      // 对字节数组Base64编码
      return new String(new Base64().encode(data));
    } finally {
      if (in != null) {
        in.close();
      }
    }
  }

  /**
   * 获得TXT文件中内容的宽带与高度
   * 
   * @param txtFile
   * @param font
   * @return
   */
  private static Map<String, Integer> getTxtFileWidthAndHeight(File txtFile, Font font) {
    Map<String, Integer> result = new HashMap<String, Integer>();
    try {
      BufferedReader reader = null;
      try {
        reader = new BufferedReader(new FileReader(txtFile));
        String line = "";
        int lineNum = 1;
        int maxWidth = 0;
        while ((line = reader.readLine()) != null) {
          maxWidth = maxWidth < line.length() ? line.length() : maxWidth;
          lineNum++;
        }
        // 加1是为了防止估算大小不够
        result.put("Width", Integer.valueOf(maxWidth * (font.getSize() + 1)));
        result.put("Height", Integer.valueOf(lineNum * (font.getSize() + 1)));
      } catch (FileNotFoundException e) {
      } finally {
        if (reader != null) {
          reader.close();
        }
      }
    } catch (IOException e) {
      Logger.getLogger(ImageUtils.class.getName()).log(Level.SEVERE, null, e);
    }
    return result;
  }

  /**
   * 获取到图像上下文
   * 
   * @param image
   *          图片
   * @return Graphics
   */
  private static Graphics createGraphics(BufferedImage image, int width, int height, Font font) {
    Graphics g = image.createGraphics();
    g.setColor(Color.WHITE); // 设置背景色
    g.fillRect(0, 0, width, height);// 绘制背景
    g.setColor(Color.BLACK); // 设置前景色
    g.setFont(font); // 设置字体
    return g;
  }

  /**
   * 保存图片到指定路径
   * 
   * @param image
   * @param imageFileName
   *          生成的图片文件全路劲，例：C:/test.png
   * @throws Exception
   */
  public static void saveImageFile(BufferedImage image, String imageFileName) throws Exception {
    if (image == null) {
      return;
    }

    File file = new File(imageFileName);
    if (!(file.getParentFile().exists())) {
      file.mkdirs();
    }

    FileUtils.deleteFile(file);
    ImageIO.write(image, getImageFormat(imageFileName), file);
  }

  /**
   * 获取图片文件的类型
   * 
   * @param imageFileName
   *          图片文件全路劲，例：C:/test.png
   * @return
   */
  public static String getImageFormat(String imageFileName) {
    if (imageFileName == null) {
      return null;
    }

    String[] split = imageFileName.split("\\.");
    if (split == null) {
      return null;
    }

    return split[split.length - 1];
  }

  /**
   * 纵向连接图片合并为一个图片
   * <p>
   * 注意：宽度必须相同
   * 
   * @param imageList
   *          图片集
   * @return
   */
  public static BufferedImage verticalConnectionImages(List<BufferedImage> imageList) {
    if (imageList == null || imageList.size() <= 0) {
      return null;
    }
    BufferedImage imageResult = null;
    try {
      int height = 0, width = 0; // 总高度、总宽度
      int _height = 0; // 临时的高度 , 或保存偏移高度
      int __height = 0; // 临时的高度，主要保存每个高度
      int imageNum = imageList.size();// 图片的数量
      int[] heightArray = new int[imageNum]; // 保存每个文件的高度
      BufferedImage buffer = null; // 保存图片
      List<int[]> imgRGB = new ArrayList<int[]>(); // 保存所有的图片的RGB
      int[] _imgRGB; // 保存一张图片中的RGB数据

      for (int i = 0; i < imageNum; i++) {
        buffer = imageList.get(i);
        heightArray[i] = _height = buffer.getHeight();// 图片高度
        if (i == 0) {
          width = buffer.getWidth();// 图片宽度
        }
        height += _height; // 获取总高度
        _imgRGB = new int[width * _height];// 从图片中读取RGB
        _imgRGB = buffer.getRGB(0, 0, width, _height, _imgRGB, 0, width);
        imgRGB.add(_imgRGB);
      }
      _height = 0; // 设置偏移高度为0
      // 生成新图片
      imageResult = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
      for (int i = 0; i < imageNum; i++) {
        __height = heightArray[i];
        if (i != 0) {
          _height += __height; // 计算偏移高度
        }
        imageResult.setRGB(0, _height, width, __height, imgRGB.get(i), 0, width); // 写入流中
      }

    } catch (Exception e) {
      Logger.getLogger(ImageUtils.class.getName()).log(Level.SEVERE, null, e);
    }
    return imageResult;
  }

  /**
   * 通过一个URL构建Image(支持HTTPS-单向)
   * 
   * @param url
   * @return
   * @throws Exception
   */
  public static Image buildImage(URL url) throws Exception {
    if (url == null) {
      return null;
    }

    URLConnection conn = url.openConnection();
    if (conn instanceof HttpsURLConnection) {
      try {
        TrustManager tm = new X509TrustManager() {
          public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String input) {
          }

          public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String input) {
          }

          public java.security.cert.X509Certificate[] getAcceptedIssuers() {
            return null;
          }

          @SuppressWarnings("unused")
          public boolean isClientTrusted(java.security.cert.X509Certificate[] chain) {
            return true;
          }

          @SuppressWarnings("unused")
          public boolean isServerTrusted(java.security.cert.X509Certificate[] chain) {
            return true;
          }
        };

        HostnameVerifier hostnameVerifier = new HostnameVerifier() {
          public boolean verify(String arg0, SSLSession arg1) {
            return true;
          }
        };

        TrustManager[] tms = { tm };
        SSLContext sslContext = SSLContext.getInstance("SSL");
        sslContext.init(null, tms, new java.security.SecureRandom());
        SSLSocketFactory sf = sslContext.getSocketFactory();
        ((HttpsURLConnection) conn).setSSLSocketFactory(sf);
        ((HttpsURLConnection) conn).setHostnameVerifier(hostnameVerifier);
      } catch (java.security.GeneralSecurityException e) {
        throw new IOException(e.getMessage());
      }
    }

    return Toolkit.getDefaultToolkit().createImage(new URLImageSource(conn));
  }

  public static BufferedImage toBufferedImage(Image image) {
    if (image instanceof BufferedImage) {
      return (BufferedImage) image;
    }
    // 加载所有像素
    image = new ImageIcon(image).getImage();
    BufferedImage bimage = null;
    Graphics g = null;
    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    try {
      int transparency = Transparency.OPAQUE;
      // 创建buffer图像
      GraphicsDevice gs = ge.getDefaultScreenDevice();
      GraphicsConfiguration gc = gs.getDefaultConfiguration();
      bimage = gc.createCompatibleImage(image.getWidth(null), image.getHeight(null), transparency);

      if (bimage == null) {
        int type = BufferedImage.TYPE_INT_RGB;
        bimage = new BufferedImage(image.getWidth(null), image.getHeight(null), type);
      }
      // 复制
      g = bimage.createGraphics();
      // 赋值
      g.drawImage(image, 0, 0, null);
    } catch (HeadlessException e) {
      e.printStackTrace();
    } finally {
      if (g != null) {
        g.dispose();
      }
    }
    return bimage;
  }

  /**
   * 裁剪图片
   * 
   * @param bufferedImage
   *          图像源
   * @param startX
   *          裁剪开始x坐标
   * @param startY
   *          裁剪开始y坐标
   * @param endX
   *          裁剪结束x坐标
   * @param endY
   *          裁剪结束y坐标
   * @return
   */
  public static BufferedImage cropImage(BufferedImage bufferedImage, int startX, int startY, int endX, int endY) {
    int width = bufferedImage.getWidth();
    int height = bufferedImage.getHeight();
    if (startX == -1) {
      startX = 0;
    }
    if (startY == -1) {
      startY = 0;
    }
    if (endX == -1) {
      endX = width - 1;
    }
    if (endY == -1) {
      endY = height - 1;
    }
    BufferedImage result = new BufferedImage(endX - startX, endY - startY, 4);
    for (int x = startX; x < endX; ++x) {
      for (int y = startY; y < endY; ++y) {
        int rgb = bufferedImage.getRGB(x, y);
        result.setRGB(x - startX, y - startY, rgb);
      }
    }
    return result;
  }

  public static BufferedImage drawStringToImage(String displayMsg, Color displayMsgColor, Font displayMsgFont,
      BufferedImage backgroundImage) throws Exception {
    if (backgroundImage == null) {
      return null;
    }
    Graphics g = null;
    try {
      if (displayMsg != null && displayMsg.length() > 0) {
        g = backgroundImage.getGraphics();
        // 设置颜色
        g.setColor(displayMsgColor);
        // 设置字体
        g.setFont(displayMsgFont);

        int width = backgroundImage.getWidth();
        int height = backgroundImage.getHeight();

        FontMetrics fm = g.getFontMetrics();
        int fontWidth = fm.stringWidth(displayMsg);

        int x = 0;
        int y = height / 2;
        if (fontWidth <= width) {
          x = (width - fontWidth) / 2;
          y = height / 2;
        } else {
          x = 0;
          y = height / 2;
        }
        // 输出文字
        g.drawString(displayMsg, x, y);
        return backgroundImage;
      }
    } finally {
      if (g != null) {
        g.dispose();
      }
    }
    return backgroundImage;
  }
}
