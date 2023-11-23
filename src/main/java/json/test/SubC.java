package json.test;

import java.io.Serializable;

import org.apache.tapestry.json.JSONObject;

/**
 * </br>
 * Created by yangxiaohua on 2023/2/8.
 */
public class SubC implements Serializable {
  private static final long serialVersionUID = -4377927204147018167L;

  private String name;

  private String xss;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getXss() {
    return xss;
  }

  public void setXss(String xss) {
    this.xss = xss;
  }

  // create by build json plugin
  public JSONObject toJson() {
    JSONObject jo = new JSONObject();
    jo.put("name", name);
    jo.put("xss", xss);
    return jo;
  }

  @Override
  public String toString() {
    return toJson().toString();
  }
}
