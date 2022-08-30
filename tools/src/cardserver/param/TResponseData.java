package cardserver.param;

import java.text.ParseException;

import org.apache.tapestry.json.JSONObject;

public class TResponseData extends TWireData {
  public static final String FNRetCode = "retCode";
  public static final String FNTerminalId = "termId";
  public static final String FNTranId = "tranId";
  public static final String FNPrintStr = "printStr";
  public static final String FNOperator = "operator";
  public static final String FNCommand = "command";

  public TRetCode retCode = TRetCode.OK.clone();
  public String termId;
  public String tranId;
  public String printStr;
  public String operator;
  public TCommandRec command = new TCommandRec();

  public TResponseData() {
    super();
  }

  public TResponseData(String aString) throws ParseException {
    super(aString);
    retCode = new TRetCode(jo.optJSONObject(FNRetCode));
    termId = jo.optString(FNTerminalId);
    tranId = jo.optString(FNTranId);
    printStr = jo.optString(FNPrintStr);
    operator = jo.optString(FNOperator);
    command = TCommandRec.parse(jo.optJSONObject(FNCommand));
  }

  @Override
  public JSONObject toJson() {
    super.toJson();
    jo.put(FNRetCode, retCode.toJson());
    jo.put(FNTerminalId, termId);
    jo.put(FNTranId, tranId);
    jo.put(FNPrintStr, printStr);
    jo.put(FNOperator, operator);
    jo.put(FNCommand, command == null ? null : command.toJson());
    return jo;
  }

  @Override
  public String toString() {
    super.toString();
    jo.put(FNRetCode, retCode.toJson());
    jo.put(FNTerminalId, termId);
    jo.put(FNTranId, tranId);
    jo.put(FNPrintStr, printStr);
    jo.put(FNOperator, operator);
    jo.put(FNCommand, command == null ? null : command.toJson());
    return jo.toString();
  }
}
