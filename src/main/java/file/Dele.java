package file;

import java.io.File;
import java.io.IOException;

/**
 * </br>
 * Created by yangxiaohua on 2020/9/15.
 */
public class Dele {
  //文件夹所嵌套的层数
  public static int totalSize;
  //计数器
  public static int count;
  //每次删除的数量  是100
  public static int num = 0;
  //每次删除的数量  是100
  public static boolean first = true;

  public static void main(String[] args) {
    File file = new File("C:\\Users\\yangxiaohua\\Desktop\\电子发票\\djbl\\fpkj_sdk\\KpTest\\KpTest");
    try {
      long firstTime = System.currentTimeMillis();
      while (true) {
        //初始化计数器
        count = 0;
        totalSize = totalSize - 199;

        //开始执行删除操作
        delAll(file);
        if (totalSize < 1) {
          break;
        }
      }
      long okTime = System.currentTimeMillis();
      System.out.println("总共耗时:" + ((okTime - firstTime) / 1000) + "秒");
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  /**
   * 删除文件夹下所有内容，包括此文件夹删除文件夹下所有内容，包括此文件夹
   *
   * @param f
   * @throws IOException
   */
  public static void delAll(File f) throws IOException {
    //    System.out.println("count=" + count);
    //    File[] sub = f.listFiles((dir, name) -> {
    //      //String的 endsWith(String str)方法  筛选出以str结尾的字符串
    //      if (name.endsWith("KpTest"))
    //        return true;
    //      return false;
    //    });
    //    //如果是第一次进来
    //    if (first) {
    //      if (sub != null && sub.length > 0) {
    //        count++;
    //        delAll(sub[0]);
    //      } else {
    //        totalSize = count;
    //        first = false;
    //        System.out.println("===总共有" + totalSize + "层文件夹===");
    //      }
    //      //及时清空,否则会出现栈内存溢出StackOverflowError
    //      sub = null;
    //    } else {
    //      if (sub.length > 0) {
    //        count++;
    //        if (totalSize - count < 100) {
    //          FileUtils.deleteFile(f);
    //          System.out.println(">>>还有" + (count - 1) + "层文件夹没有删除");
    //        }
    //        delAll(sub[0]);
    //      }
    //
    //    }
    //    //及时清空,否则会出现堆内存溢出
    //    sub = null;
  }

}