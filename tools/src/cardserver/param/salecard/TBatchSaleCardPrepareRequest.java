package cardserver.param.salecard;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.apache.tapestry.json.JSONArray;

import cardserver.param.TCardInfoRec;
import cardserver.param.TRequestData;

/**
 * 卡发售prepare | 请求
 *
 * @author gcr
 */
public final class TBatchSaleCardPrepareRequest extends TRequestData {

  private static final long serialVersionUID = 1L;

  public static final String CCommand = "BatchSaleCardPrepare"; // 命令
  public static final String FNCardInfo = "cardInfo";
  public static final String FNXid = "xid";

  /**
   * 卡信息
   */
  public List<TCardInfoRec> cardInfo = new ArrayList<TCardInfoRec>();
  public String xid;

  public TBatchSaleCardPrepareRequest() {
    super();
    command = CCommand;
  }

  public TBatchSaleCardPrepareRequest(String aString) throws ParseException {
    super(aString);
    if (jo.has(FNCardInfo)) {
      JSONArray a = jo.optJSONArray(FNCardInfo);
      if (a != null) {
        for (int i = 0; i < a.length(); ++i) {
          cardInfo.add(new TCardInfoRec(a.getJSONObject(i)));
        }
      }
    }
    if (jo.has(FNXid)) {
      xid = jo.getString(FNXid);
    }
  }

  @Override
  public String toString() {
    super.toString();
    for (int i = 0; i < cardInfo.size(); ++i) {
      jo.accumulate(FNCardInfo, cardInfo.get(i).toJson());
    }
    jo.put(FNXid, xid);
    return jo.toString();
  }

}
