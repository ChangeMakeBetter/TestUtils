package cardserver.param.addterminal;

import java.text.ParseException;

import cardserver.param.TRequestData;

public class TTerminalAddRequest extends TRequestData {
  public static final String CCommand = "addTerminal";
  public static final String CServerType = "SposServer";
  public static final String CTerminalType = "SposTerminal";
  public static final String FNTerminalId = "termId";
  public static final String FNTerminalRegisterNumber = "registerNumber";
  public static final String FNSposServer = "server";
  public static final String FNSposServerPort = "port";
  public static final String FNTerminalFeature = "feature";
  public static final String FNTerminalType = "type";

  public String terminalId;
  public String terminalRegisterNumber;
  public String sposServer, sposServerPort;
  public String terminalFeature;
  public String terminalType; // CServerType, CTerminalType

  public TTerminalAddRequest() {
    super();
    command = CCommand;
  }

  public TTerminalAddRequest(String aString) throws ParseException {
    super(aString);
    terminalId = jo.optString(FNTerminalId);
    terminalRegisterNumber = jo.optString(FNTerminalRegisterNumber);
    sposServer = jo.optString(FNSposServer);
    sposServerPort = jo.optString(FNSposServerPort);
    terminalFeature = jo.optString(FNTerminalFeature);
    terminalType = jo.optString(FNTerminalType);
  }

  @Override
  public String toString() {
    super.toString();
    jo.put(FNTerminalId, terminalId);
    jo.put(FNTerminalRegisterNumber, terminalRegisterNumber);
    jo.put(FNSposServer, sposServer);
    jo.put(FNSposServerPort, sposServerPort);
    jo.put(FNTerminalFeature, terminalFeature);
    jo.put(FNTerminalType, terminalType);
    return jo.toString();
  }

}
