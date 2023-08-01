package messagequeue;

import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import utils.MyConverter;

/**
 * </br>
 * Created by yangxiaohua on 2023/4/14.
 */
public class DragonFlymsgCollection {

  private final List<DragonFlyMessage> collection;

  public DragonFlymsgCollection() {
    collection = Collections.synchronizedList(new LinkedList<DragonFlyMessage>());
  }

  public void add(DragonFlyMessage object) {
    synchronized (collection) {
      if (collection.size() >= 500) {
        collection.remove(0);
      }
      collection.add(object);
    }
  }

  public DragonFlyMessage getLatest() {
    synchronized (collection) {
      return collection.get(collection.size() - 1);
    }
  }

  public void clear() {
    synchronized (collection) {
      collection.clear();
    }
  }

  public boolean isEmpty() {
    synchronized (collection) {
      return collection.isEmpty();
    }
  }

  public int size() {
    return collection.size();
  }

  public boolean hasSame(DragonFlyMessage msg) {
    synchronized (collection) {
      if (collection.isEmpty()) {
        return false;
      } else {
        return getLatest().equals(msg);
      }

    }
  }

  //  public static void main(String[] args) {
  //    DragonFlymsgCollection oc = new DragonFlymsgCollection();
  //
  //    // 需要验证场景
  //    //1. 连续发送大量SKU ，是否是0.5s内只传2个
  //    //2. 连续发送几个SKU后，发送pay ，是否是立刻发送
  //
  //    // Add objects
  //    long startCreate = System.currentTimeMillis();
  //    //    for (int i = 1; i <= 100; i++) {
  //    //      int finalI = i;
  //    //      new Thread(() -> {
  //    //        try {
  //    //          if (finalI % 3 == 0) {
  //    //            Thread.sleep(1000);
  //    //          } else if (finalI % 5 == 0) {
  //    //            Thread.sleep(5000);
  //    //          } else if (finalI % 7 == 0) {
  //    //            Thread.sleep(8000);
  //    //          } else if (finalI % 13 == 0) {
  //    //            Thread.sleep(4000);
  //    //          } else {
  //    //            Thread.sleep(100);
  //    //          }
  //    //        } catch (InterruptedException e) {
  //    //          e.printStackTrace();
  //    //        }
  //    //        oc.add("Object " + finalI);
  //    //      }).start();
  //    //    }
  //
  //    for (int i = 1; i <= 100; i++) {
  //      int finalI = i;
  //      new Thread(() -> {
  //        DragonFlyMessage msg = null;
  //        try {
  //          if (finalI == 1 || finalI == 3 || finalI == 5 || finalI == 7 || finalI == 9) {
  //            Thread.sleep(160);
  //            msg = DragonFlyMessage.skuPopMessage("msg:" + finalI);
  //            //          } else if (finalI == 2 || finalI == 4 || finalI == 6 || finalI == 8) {
  //            //            Thread.sleep((80 + finalI) * 10);
  //            //            msg = DragonFlyMessage.operMessage("msg:" + finalI);
  //            //                      } else if (finalI % 7 == 0) {
  //            //                        Thread.sleep(8000);
  //            //                      } else if (finalI % 13 == 0) {
  //            //                        Thread.sleep(4000);
  //          } else {
  //            Thread.sleep(100 + finalI * 20);
  //            msg = DragonFlyMessage.skuShowMessage("msg:" + finalI);
  //          }
  //        } catch (InterruptedException e) {
  //          e.printStackTrace();
  //          return;
  //        }
  //        if (msg.needSigleSend()) {
  //          oc.add(msg);
  //        } else {
  //          System.out.println("特殊指令，等待OC清空后直接发送");
  //          while (!oc.isEmpty()) {  //todo 等待
  //            try {
  //              System.out.println("等待清空");
  //              Thread.sleep(50);
  //            } catch (InterruptedException e) {
  //              e.printStackTrace();
  //            }
  //          }
  //          sendCommandSync(msg);
  //        }
  //      }).start();
  //    }
  //
  //    System.out.println("创建线程共耗时：" + (System.currentTimeMillis() - startCreate));
  //
  //    // Process objects every 0.5 seconds
  //    while (true) {
  //      try {
  //        Thread.sleep(500);
  //        System.out.println("oc.size=" + oc.collection.size());
  //        System.out.println(Arrays.toString(oc.collection.toArray()));
  //        if (!oc.isEmpty()) {
  //          DragonFlyMessage object = oc.getLatest();
  //          if (object != null) {
  //            System.out.println(MyConverter.toString_yMdHmsS(new Date()) + "   content:" + object.toString());
  //            oc.clear();
  //          }
  //        }
  //      } catch (InterruptedException e) {
  //        e.printStackTrace();
  //      }
  //    }
  //  }

  private static synchronized void sendCommandSync(DragonFlyMessage msg) {
    System.out.println("sendCommandSync:" + MyConverter.toString_yMdHmsS(new Date()) + "   msg:" + msg.toString());
  }
}