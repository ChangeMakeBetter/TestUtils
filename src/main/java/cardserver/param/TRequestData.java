package cardserver.param;

import java.text.ParseException;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.tapestry.json.JSONObject;

public class TRequestData extends TWireData {

  private static final long serialVersionUID = 300100L;

  /** 终端类型:SPOS或LDPOS */
  public static final String FNTerminalType = "terminalType";
  public static final String TerminalType_LDPOS = "LDPOS";
  public static final String TerminalType_SPOS = "SPOS";
  public static final String TerminalType_ONLINESHOPPING = "ONLINESHOPPING";
  public static final String TerminalType_PS = "PS";
  public static final String TerminalType_NSPOS = "NSPOS";

  public static final String FNCommand = "command";
  public static final String FNSessionId = "sessionId";
  public static final String FNOperator = "operator";
  public static final String FNTerminalId = "terminalId";

  /** 服务端ID(或商户号) */
  public static final String FNServerId = "serverId";
  public static final String FNTranId = "tranId";
  public static final String FNTranTime = "tranTime";
  public static final String FNPosNo = "posNo";
  public static final String STORE_KEY = "store";

  public String terminalType;// 终端类型
  public String command; // 命令
  public String sessionId;// 会话ID
  public String operator;// 操作员
  public String terminalId;// 终端ID
  public String serverId;// 服务端ID
  public String tranId;// 交易流水号
  public Date tranTime = new Date();// 交易时间
  /** pos机号 */
  public String posNo;
  /** 门店 */
  public TUCN store = new TUCN();

  public TRequestData() {
    super();
  }

  public TRequestData(String aString) throws ParseException {
    super(aString);
    if (jo.has(FNTerminalType)) {
      terminalType = jo.optString(FNTerminalType);
    }
    if (jo.has(FNCommand)) {
      command = jo.optString(FNCommand);
    }
    if (jo.has(FNSessionId)) {
      sessionId = jo.optString(FNSessionId);
    }
    if (jo.has(FNOperator)) {
      operator = jo.optString(FNOperator);
    }
    if (jo.has(FNTerminalId)) {
      terminalId = jo.optString(FNTerminalId);
    }
    if (jo.has(FNPosNo)) {
      posNo = jo.optString(FNPosNo);
    }
    if (jo.has(FNServerId)) {
      serverId = jo.optString(FNServerId);
    }
    if (jo.has(FNTranId)) {
      tranId = jo.optString(FNTranId);
    }
    if (jo.has(FNTranTime)) {
      tranTime = CardConverter.toDate(jo.optString(FNTranTime));
    }

    // 历史代码中传入了storeCode，storeName两个key，要兼容处理
    if (jo.has(FNStoreCode)) {
      store.code = jo.optString(FNStoreCode);
    }
    if (jo.has(FNStoreName)) {
      store.name = jo.optString(FNStoreName);
    }
    try {
      if (jo.has(STORE_KEY)) {
        TUCN temp = new TUCN(jo.optJSONObject(STORE_KEY));
        store.uuid = temp.uuid;
        if (StringUtils.isNotEmpty(temp.code)) {
          store.code = temp.code;
        }
        if (StringUtils.isNotEmpty(temp.name)) {
          store.name = temp.name;
        }
      }
    } catch (Exception e) {
    }
  }

  public static final String FNStoreCode = "storeCode";
  public static final String FNStoreName = "storeName";

  @Override
  public String toString() {
    super.toString();
    jo.put(FNTerminalType, terminalType);
    jo.put(FNCommand, command);
    jo.put(FNSessionId, sessionId);
    jo.put(FNOperator, operator);
    jo.put(FNTerminalId, terminalId);
    jo.put(FNPosNo, posNo);
    jo.put(FNServerId, serverId);
    jo.put(FNTranId, tranId);
    jo.put(FNTranTime, CardConverter.toString(tranTime));
    jo.put(STORE_KEY, store.toJson());

    // 历史代码中传入了storeCode，storeName两个key，要兼容处理
    jo.put(FNStoreCode, store.code);
    jo.put(FNStoreName, store.name);
    return jo.toString();
  }

  public TRequestData(JSONObject jo) {
    if (jo == null) {
      return;
    }

    if (jo.has(FNTime)) {
      time = CardConverter.toDate(jo.optString(FNTime));
    }
    if (jo.has(FNTerminalType)) {
      terminalType = jo.optString(FNTerminalType);
    }
    if (jo.has(FNCommand)) {
      command = jo.optString(FNCommand);
    }
    if (jo.has(FNSessionId)) {
      sessionId = jo.optString(FNSessionId);
    }
    if (jo.has(FNOperator)) {
      operator = jo.optString(FNOperator);
    }
    if (jo.has(FNTerminalId)) {
      terminalId = jo.optString(FNTerminalId);
    }
    if (jo.has(FNPosNo)) {
      posNo = jo.optString(FNPosNo);
    }
    if (jo.has(FNServerId)) {
      serverId = jo.optString(FNServerId);
    }
    if (jo.has(FNTranId)) {
      tranId = jo.optString(FNTranId);
    }
    if (jo.has(FNTranTime)) {
      tranTime = CardConverter.toDate(jo.optString(FNTranTime));
    }
  }

  @Override
  public JSONObject toJson() {
    JSONObject jo = new JSONObject();
    jo.put(FNTime, CardConverter.toString(time));
    jo.put(FNTerminalType, terminalType);
    jo.put(FNCommand, command);
    jo.put(FNSessionId, sessionId);
    jo.put(FNOperator, operator);
    jo.put(FNTerminalId, terminalId);
    jo.put(FNPosNo, posNo);
    jo.put(FNServerId, serverId);
    jo.put(FNTranId, tranId);
    jo.put(FNTranTime, CardConverter.toString(tranTime));
    return jo;
  }

}
