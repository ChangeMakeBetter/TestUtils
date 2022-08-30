package cardserver.param;

import java.text.ParseException;
import java.util.Date;

import org.apache.tapestry.json.JSONObject;

public class TWireData {
  private static final long serialVersionUID = 1L;

  public static final String FNTime = "time";

  public Date time;// 请求响应时间

  protected JSONObject jo;

  public TWireData() {
    super();
    time = new Date();
  }

  public TWireData(String aString) throws ParseException {
    this();
    jo = new JSONObject(aString);
  }

  public JSONObject toJson() {
    jo = new JSONObject();
    jo.put(FNTime, CardConverter.toString(time));
    return jo;
  }

  @Override
  public String toString() {
    jo = new JSONObject();
    jo.put(FNTime, CardConverter.toString(time));
    return jo.toString();
  }

}
