package cardserver.param.addterminal;

import java.text.ParseException;
import java.util.Date;

import cardserver.param.CardConverter;
import cardserver.param.TResponseData;

public class TTerminalAddResponse extends TResponseData {
  public static final String FNTerminalId = "termId";
  public static final String FNTerminalExpireDay = "expireDay";
  public static final String FNActive = "active";
  public static final String FNEnterpriseId = "entId";

  public String terminalId;
  public Date terminalExpireDay;
  public boolean active;
  public String enterpriseId;

  public TTerminalAddResponse() {
    super();
  }

  public TTerminalAddResponse(String aString) throws ParseException {
    super(aString);
    terminalId = jo.optString(FNTerminalId);
    terminalExpireDay = CardConverter.toDate(jo.optString(FNTerminalExpireDay));
    active = jo.optBoolean(FNActive);
    enterpriseId = jo.optString(FNEnterpriseId);
  }

  @Override
  public String toString() {
    super.toString();
    jo.put(FNTerminalId, terminalId);
    jo.put(FNTerminalExpireDay, CardConverter.toString(terminalExpireDay));
    jo.put(FNActive, active);
    jo.put(FNEnterpriseId, enterpriseId);
    return jo.toString();
  }
}
