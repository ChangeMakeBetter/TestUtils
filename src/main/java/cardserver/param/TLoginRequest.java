package cardserver.param;

import java.text.ParseException;
import java.util.Date;

public class TLoginRequest extends TRequestData {
  public static final String CCommand = "login";
  public static final String FNUserId = "userId";
  public static final String FNPassword = "password";
  public static final String FNTerminalId = "terminalId";
  public static final String FNTerminalFeature = "termFeature";
  public static final String FNTranId = "tranId";
  public static final String FNTranTime = "tranTime";
  public static final String FNTrust = "trust";

  public String userId;
  public String password;
  public String terminalId;
  public String terminalFeature;
  public String tranId;
  public Date tranTime;
  public boolean trust = false;

  public TLoginRequest() {
    super();
    command = CCommand;
  }

  public TLoginRequest(String aString) throws ParseException {
    super(aString);
    userId = jo.optString(FNUserId);
    password = jo.optString(FNPassword);
    terminalId = jo.optString(FNTerminalId);
    terminalFeature = jo.optString(FNTerminalFeature);
    tranId = jo.optString(FNTranId);
    tranTime = CardConverter.toDate(jo.optString(FNTranTime));
    trust = jo.optBoolean(FNTrust);
  }

  @Override
  public String toString() {
    super.toString();
    jo.put(FNUserId, userId);
    jo.put(FNPassword, password);
    jo.put(FNTerminalId, terminalId);
    jo.put(FNTerminalFeature, terminalFeature);
    jo.put(FNTranId, tranId);
    jo.put(FNTranTime, CardConverter.toString(tranTime));
    jo.put(FNTrust, trust);
    return jo.toString();
  }
}
