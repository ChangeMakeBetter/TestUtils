package messagequeue;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.apache.tapestry.json.JSONObject;

import utils.MyConverter;

/**
 * </br>
 * Created by yangxiaohua on 2023/4/14.
 */
public class DragonFlyMessage implements Serializable {
  public static final int PRIORITY_SKU = 0, priority_OPERATION = 100;
  private static final long serialVersionUID = 1192937769699298084L;

  private int priority = 0;

  private String page;

  private String operateType;

  private String content;

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    DragonFlyMessage other = (DragonFlyMessage) obj;
    if (MyConverter.equals(page, other.getPage()) && MyConverter.equals(operateType, other.getOperateType())) {
      return true;
    }
    return false;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public int getPriority() {
    return priority;
  }

  public void setPriority(int priority) {
    this.priority = priority;
  }

  public String getPage() {
    return page;
  }

  public void setPage(String page) {
    this.page = page;
  }

  public String getOperateType() {
    return operateType;
  }

  public void setOperateType(String operateType) {
    this.operateType = operateType;
  }

  // create by build json plugin
  public JSONObject toJson() {
    JSONObject jo = new JSONObject();
    jo.put("priority", priority);
    jo.put("page", page);
    jo.put("operateType", operateType);
    jo.put("content", content);
    return jo;
  }

  @Override
  public String toString() {
    return toJson().toString();
  }

  private static final String skuPage = "sku";
  private static final String showOper = "show";
  private static final String payPage = "pay";
  private static final String payOper = "faceVerify";
  private static final String exitOper = "pop";

  public static DragonFlyMessage skuShowMessage(String content) {
    DragonFlyMessage msg = new DragonFlyMessage();
    msg.setPriority(PRIORITY_SKU);
    msg.setPage(skuPage);
    msg.setOperateType(showOper);
    msg.setContent(content);
    return msg;
  }

  public static DragonFlyMessage skuPopMessage(String content) {
    DragonFlyMessage msg = new DragonFlyMessage();
    msg.setPriority(PRIORITY_SKU);
    msg.setPage(skuPage);
    msg.setOperateType(exitOper);
    msg.setContent(content);
    return msg;
  }

  public static DragonFlyMessage operMessage(String content) {
    DragonFlyMessage msg = new DragonFlyMessage();
    msg.setPriority(priority_OPERATION);
    msg.setPage(payPage);
    msg.setOperateType(payOper);
    msg.setContent(content);
    return msg;
  }

  public static void main(String[] args) {
    List<Integer> list = new ArrayList<>();
    for (int i = 1000000; i >= 1; i--) {
      list.add(0);
    }
    System.out.println("源集合数量：" + list.size());

    List<Integer> newCollList = new ArrayList<>();
    long start = System.currentTimeMillis();
    ExecutorService executor = Executors.newFixedThreadPool(100);
    for (Integer integer : list) {
      executor.submit(() -> {
        newCollList.add(integer + 1);
      });
    }
    executor.shutdown();
    try {
      executor.awaitTermination(6, TimeUnit.MINUTES);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    long end = System.currentTimeMillis();
    System.out.println("时间:" + (end - start) + "ms");
    System.out.println("newCollList新集合数量:" + newCollList.size());

  }

}
