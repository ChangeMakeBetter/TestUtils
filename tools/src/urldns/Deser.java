package urldns;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.net.InetAddress;
import java.util.HashMap;

import org.apache.commons.collections.CollectionUtils;

/**
 * </br>
 * Created by yangxiaohua on 2021/7/29.
 */
public class Deser {
  public static void main(String[] args) throws IOException, ClassNotFoundException {
    // 反序列化对象
    FileInputStream fileInputStream = new FileInputStream("urldns.ser");
    ObjectInputStream ois = new ObjectInputStream(fileInputStream);

    try {
      AntObjectInputStream antOis = new AntObjectInputStream(fileInputStream);
      antOis.readObject();
    } catch (Exception e) {
      System.out.println("error:" + e.getMessage());
    }

    //    HashMap map = (HashMap) ois.readObject();
    //    for (Object o : map.keySet()) {
    //      System.out.println(map.get(o));
    //    }

    //    System.out.println(InetAddress.getByName("ggrbqh.dnslog.cn"));

    //    ObjectInputStream ois = new ObjectInputStream(new FileInputStream("urldns1.ser"));
    //    ois.readObject();

  }

  public static class AntObjectInputStream extends ObjectInputStream {
    public AntObjectInputStream(InputStream inputStream) throws IOException {
      super(inputStream);
    }

    // TODO 对ObjectInputStream 再次包装,过滤未序列化的类,此方法相当于构造一个白名单，把所有可以识别的类放进来。不可取

    /**
     * 只允许反序列化SerialObject class
     */
    @Override
    protected Class<?> resolveClass(ObjectStreamClass desc) throws IOException, ClassNotFoundException {
      // if (!desc.getName().equals(SerialObject.class.getName())) {
      // throw new InvalidClassException("Unauthorized deserialization attempt",
      // desc.getName());
      // }
      System.out.println("name:" + desc.getName());
      return super.resolveClass(desc);
    }
  }
}
