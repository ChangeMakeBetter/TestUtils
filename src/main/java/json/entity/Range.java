package json.entity;

import org.apache.tapestry.json.JSONObject;

public class Range {
  private String beginTime;
  private String endTime;


  public String getBeginTime() {
    return beginTime;
  }

  public void setBeginTime(String beginTime) {
    this.beginTime = beginTime;
  }

  public String getEndTime() {
    return endTime;
  }

  public void setEndTime(String endTime) {
    this.endTime = endTime;
  }

  // create by build json plugin
  public JSONObject toJson() {
    JSONObject jo = new JSONObject();
    jo.put("beginTime", beginTime);
    jo.put("endTime", endTime);
    return jo;
  }

}