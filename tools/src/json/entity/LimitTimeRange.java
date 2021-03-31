package json.entity;

import java.util.ArrayList;
import java.util.List;

import org.apache.tapestry.json.JSONObject;

public class LimitTimeRange {
  // 限制天（每月时为第几日，每周时为星期几）
  private List<Integer> days = new ArrayList<Integer>();
  // 是否为限制可用日期
  private boolean useLimit = false;
  // 时间段范围
  private List<Range> ranges = new ArrayList<Range>();
  // 周期类型，Daily——每天，month——每月，week——每周
  private String cycleType;

  public List<Integer> getDays() {
    return days;
  }

  public void setDays(List<Integer> days) {
    this.days = days;
  }

  public boolean isUseLimit() {
    return useLimit;
  }

  public void setUseLimit(boolean useLimit) {
    this.useLimit = useLimit;
  }

  public List<Range> getRanges() {
    return ranges;
  }

  public void setRanges(List<Range> ranges) {
    this.ranges = ranges;
  }

  public String getCycleType() {
    return cycleType;
  }

  public void setCycleType(String cycleType) {
    this.cycleType = cycleType;
  }

  // create by build json plugin
  public JSONObject toJson() {
    JSONObject jo = new JSONObject();
    for (Integer d : days) {
      jo.accumulate("days", d);
    }
    jo.put("useLimit", useLimit);
    for (Range r : ranges) {
      jo.accumulate("ranges", r.toJson());
    }
    jo.put("cycleType", cycleType);
    return jo;
  }

  @Override
  public String toString() {
    return toJson().toString();
  }

}
