package dragonfly.abcp.messagesender;

import java.io.Serializable;

import org.apache.tapestry.json.JSONObject;

/**
 * </br>
 * Created by yangxiaohua on 2023/4/14.
 */
public class DragonFlyMessage implements Serializable {
  private static final long serialVersionUID = 1192937769699298084L;

  private String page;

  private String operateType;

  private String content;

  public DragonFlyMessage() {
  }

  public DragonFlyMessage(String page, String operateType, String content) {
    this.page = page;
    this.operateType = operateType;
    this.content = content;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    DragonFlyMessage other = (DragonFlyMessage) obj;
    if (isEqual(page, other.getPage()) && isEqual(operateType, other.getOperateType())) {
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
    jo.put("page", page);
    jo.put("operateType", operateType);
    jo.put("content", content);
    return jo;
  }

  @Override
  public String toString() {
    return toJson().toString();
  }

  private boolean isEqual(String a, String b) {
    if (a == null) {
      return b == null;
    }

    return a.equals(b);
  }

}
