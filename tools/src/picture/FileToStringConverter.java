package picture;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

import net.coobird.thumbnailator.Thumbnails;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * 图片与Byte数组转换，TXT文件与string转换
 */
public class FileToStringConverter {

  // 源图片路径
  private static final String sourcePicturePath = "E://pictureTest//mht.jpg";
  // 目标图片路径,由string转成的图片
  private static final String targetPicturePath = "E://pictureTest//target.jpg";
  // 压缩后图片路径
  private static final String compressPicturePath = "E://pictureTest//mht_compress.jpg";
  // 源txt文件路径，用于txt转string测试
  private static final String sourceTxtPath = "E://pictureTest//source.txt";
  // 目标txt文件路径，用于string 转txt 测试
  private static final String targetTxtPath = "E://pictureTest//target.txt";

  public static void main(String[] args) {
    try {
      System.out.println("图片压缩:");
      compress();

      File f = new File(compressPicturePath);
      byte[] result = loadImage(f);
      System.out.println("图片转byte数组：byte长度:" + result.length);

      BASE64Encoder encoder = new BASE64Encoder();
      String str = encoder.encode(result).trim();
      System.out.println("Base64转化后string,长度:" + str.length());

      stringToTxt(str);
      System.out.println("String写入到TXT文件，targetTxtPath");

      StringBuffer sb = txtToString();
      String data = new String(sb);
      System.out.println("sourceTxt文件转换成string,长度:" + data.length());

      byteToPicture(data);
      System.out.println("string 通过base64解析,转换成图片文件" + data.length());

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private static void byteToPicture(String data) throws IOException {
    BASE64Decoder decoder = new BASE64Decoder();
    byte[] imgbyte = decoder.decodeBuffer(data);
    OutputStream os = new FileOutputStream(targetPicturePath);
    os.write(imgbyte, 0, imgbyte.length);
    os.flush();
    os.close();
  }

  private static void compress() {
    System.out.println("compress start");
    try {
      Thumbnails.of(sourcePicturePath).scale(0.25f).outputQuality(0.25f).toFile(compressPicturePath);
    } catch (IOException e) {
      e.printStackTrace();
    }
    System.out.println("compress finish");
  }

  private static void stringToTxt(String content) {
    FileWriter fwriter = null;
    try {
      fwriter = new FileWriter(targetTxtPath);
      fwriter.write(content);
    } catch (IOException ex) {
      ex.printStackTrace();
    } finally {
      try {
        fwriter.flush();
        fwriter.close();
      } catch (IOException ex) {
        ex.printStackTrace();
      }
    }
  }

  private static StringBuffer txtToString() throws IOException {
    BufferedReader br = null;
    StringBuffer sb = null;
    try {
      br = new BufferedReader(new InputStreamReader(new FileInputStream(targetTxtPath), "GBK")); // 这里可以控制编码
      sb = new StringBuffer();
      String line = null;
      while ((line = br.readLine()) != null) {
        sb.append(line);
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        br.close();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

    String data = new String(sb); // StringBuffer ==> String
    System.out.println("数据为==> " + data);
    return sb;
  }

  /**
   * 将图片转换为字节数组
   *
   * @return
   */
  private static byte[] loadImage(File file) {
    // 用于返回的字节数组
    byte[] data = null;
    // 打开文件输入流
    FileInputStream fin = null;
    // 打开字节输出流
    ByteArrayOutputStream bout = null;
    try {
      // 文件输入流获取对应文件
      fin = new FileInputStream(file);
      // 输出流定义缓冲区大小
      bout = new ByteArrayOutputStream((int) file.length());
      // 定义字节数组，用于读取文件流
      byte[] buffer = new byte[1024];
      // 用于表示读取的位置
      int len = -1;
      // 开始读取文件
      while ((len = fin.read(buffer)) != -1) {
        // 从buffer的第0位置开始，读取至第len位置，结果写入bout
        bout.write(buffer, 0, len);
      }
      // 将输出流转为字节数组
      data = bout.toByteArray();
      // 关闭输入输出流
      fin.close();
      bout.close();

    } catch (Exception e) {
      e.printStackTrace();
    }
    return data;
  }
}
