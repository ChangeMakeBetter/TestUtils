package cardserver.param;

import java.io.Serializable;

import org.apache.tapestry.json.JSONObject;

/**
 * UCN 接口对象
 * 
 * @author Way
 * 
 */
public final class TUCN implements Serializable {

  private static final long serialVersionUID = 300100L;

  private static final String CODE_KEY = "code";
  private static final String NAME_KEY = "name";
  private static final String UUID_KEY = "uuid";

  public String code;
  public String name;
  public String uuid;

  public TUCN() {
    super();
  }

  public TUCN(String code, String name, String uuid) {
    this.code = code;
    this.name = name;
    this.uuid = uuid;
  }

  public TUCN(JSONObject jo) {
    if (jo == null) {
      return;
    }
    if (jo.has(CODE_KEY)) {
      code = jo.optString(CODE_KEY);
    }
    if (jo.has(NAME_KEY)) {
      name = jo.optString(NAME_KEY);
    }
    if (jo.has(UUID_KEY)) {
      uuid = jo.optString(UUID_KEY);
    }
  }

  public JSONObject toJson() {
    JSONObject jo = new JSONObject();
    jo.put(CODE_KEY, code);
    jo.put(NAME_KEY, name);
    jo.put(UUID_KEY, uuid);
    return jo;
  }

  @Override public TUCN clone() {
    TUCN ucn = new TUCN();
    ucn.code = code;
    ucn.name = name;
    ucn.uuid = uuid;
    return ucn;
  }

  @Override public String toString() {
    return toJson().toString();
  }

}
