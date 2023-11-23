package opencv;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.VideoCapture;

/**
 * TestUtils<br> Created by yangxiaohua on 2019/7/4.
 */
public class OpenCvTest {

  private Image toBufferedImage(Mat m) {
    int type = 10;

    if (m.channels() > 1) {
      type = 5;
    }

    int bufferSize = m.channels() * m.cols() * m.rows();
    byte[] b = new byte[bufferSize];
    m.get(0, 0, b);
    BufferedImage image = new BufferedImage(m.cols(), m.rows(), type);

    byte[] targetPixels = ((DataBufferByte)image.getRaster().getDataBuffer()).getData();
    System.arraycopy(b, 0, targetPixels, 0, b.length);

    return image;
  }

  private  void run(String[] args) {
    // 索引
    String index = args.length > 0 ? args[0] : "0";
    VideoCapture capture = new VideoCapture();
    // 打开索引对应摄像头
    capture.open(Integer.valueOf(index));
    if (!capture.isOpened()) {
      System.err.println("Unable to open: " + index);
      System.exit(0);
    }
    Mat frame = new Mat();// , fgMask = new Mat();
    while (true) {
      capture.read(frame);
      if (frame.empty()) {
        // 没读到数据，退出
        break;
      }
      ImageGui ig  = new ImageGui(frame,"Test");
      ig.imshow();

//      BufferedImage image = (BufferedImage) toBufferedImage(frame);
//      File file = new File("d:\\test1.jpg");
//      try {
//        ImageIO.write(image, "jpg", file);
//      } catch (IOException e) {
//        e.printStackTrace();
//      }
      break;
    }
  }

  public static void main(String[] args) {
    System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    OpenCvTest ocv = new OpenCvTest();
    ocv.run(args);
  }
}
