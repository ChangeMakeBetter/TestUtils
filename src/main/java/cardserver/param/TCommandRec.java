package cardserver.param;

import java.text.ParseException;

import org.apache.tapestry.json.JSONObject;

public class TCommandRec {
  public static String FNCommandUuid = "commandUuid";
  public static String FNCommandType = "commandType";
  public static String FNCommandContent = "commandContent";

  public static String FNReportToUrl = "reportToUrl";
  public static String RNCookie = "cookie";
  public static String FNHomeDir = "homeDir";
  public static String FNTerminalId = "terminalId";

  private String commandUuid;
  private String commandType;
  private String commandContent;

  // 仅Spos使用
  private String reportToUrl;
  private String cookie;
  private String homeDir;
  private String terminalId;

  public TCommandRec() {
  }

  public static TCommandRec parse(String command) throws ParseException {
    return parse(new JSONObject(command));
  }

  public static TCommandRec parse(JSONObject jo) {
    if (jo == null) {
      return null;
    }
    TCommandRec rec = new TCommandRec();
    rec.commandUuid = jo.optString(FNCommandUuid, null);
    rec.commandType = jo.optString(FNCommandType);
    rec.commandContent = jo.optString(FNCommandContent);
    rec.reportToUrl = jo.optString(FNReportToUrl);
    rec.cookie = jo.optString(RNCookie);
    rec.homeDir = jo.optString(FNHomeDir);
    rec.terminalId = jo.optString(FNTerminalId, null);
    return rec;
  }

  public JSONObject toJson() {
    JSONObject jo = new JSONObject();
    jo.put(FNCommandUuid, commandUuid);
    jo.put(FNCommandType, commandType);
    jo.put(FNCommandContent, commandContent);
    jo.put(FNReportToUrl, reportToUrl);
    jo.put(RNCookie, cookie);
    jo.put(FNHomeDir, homeDir);
    jo.put(FNTerminalId, terminalId);
    return jo;
  }

  @Override
  public String toString() {
    return toJson().toString();
  }

  public String getCommandUuid() {
    return commandUuid;
  }

  public void setCommandUuid(String commandUuid) {
    this.commandUuid = commandUuid;
  }

  public String getCommandType() {
    return commandType;
  }

  public void setCommandType(String commandType) {
    this.commandType = commandType;
  }

  public String getCommandContent() {
    return commandContent;
  }

  public void setCommandContent(String commandContent) {
    this.commandContent = commandContent;
  }

  public String getReportToUrl() {
    return reportToUrl;
  }

  public void setReportToUrl(String reportToUrl) {
    this.reportToUrl = reportToUrl;
  }

  public String getCookie() {
    return cookie;
  }

  public void setCookie(String cookie) {
    this.cookie = cookie;
  }

  public String getHomeDir() {
    return homeDir;
  }

  public void setHomeDir(String homeDir) {
    this.homeDir = homeDir;
  }

  public String getTerminalId() {
    return terminalId;
  }

  public void setTerminalId(String terminalId) {
    this.terminalId = terminalId;
  }

}
