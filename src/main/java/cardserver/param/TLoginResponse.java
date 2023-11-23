package cardserver.param;

import java.text.ParseException;

public class TLoginResponse extends TResponseData {
  public static final String FNSessionId = "sessionId";
  public static final String FNEnterpriseUserId = "entUserId";

  public String sessionId;
  public String enterpriseUserId;

  public TLoginResponse() {
    super();
  }

  public TLoginResponse(String aString) throws ParseException {
    super(aString);
    sessionId = jo.optString(FNSessionId);
    enterpriseUserId = jo.optString(FNEnterpriseUserId);
  }

  @Override
  public String toString() {
    super.toString();
    jo.put(FNSessionId, sessionId);
    jo.put(FNEnterpriseUserId, enterpriseUserId);
    return jo.toString();
  }
}
