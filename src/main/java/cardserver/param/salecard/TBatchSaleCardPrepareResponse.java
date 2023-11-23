package cardserver.param.salecard;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.apache.tapestry.json.JSONArray;

import cardserver.param.CardConverter;
import cardserver.param.TCardInfoRec;
import cardserver.param.TResponseData;

/**
 * 卡发售prepare | 响应
 */
public final class TBatchSaleCardPrepareResponse extends TResponseData {

  private static final long serialVersionUID = 1L;

  public static final String FNCardInfo = "cardInfo";
  public static final String FNXid = "xid";
  public static final String FNPayTotal = "payTotal";
  public static final String FNFeeTotal = "feeTotal";
  public static final String FNPayCards = "payCards";

  /**
   * 卡信息
   */
  public List<TCardInfoRec> cardInfo = new ArrayList<TCardInfoRec>();
  public String xid;
  /**
   * 总付款金额
   */
  public BigDecimal payTotal = BigDecimal.ZERO;
  /**
   * 总费用
   */
  public BigDecimal feeTotal = BigDecimal.ZERO;
  /**
   * 卡付款信息
   */
  public List<TPayCardRec> payCards = new ArrayList<TPayCardRec>();

  public TBatchSaleCardPrepareResponse() {
  }

  public TBatchSaleCardPrepareResponse(String aString) throws ParseException {
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
    if (jo.has(FNPayTotal)) {
      payTotal = CardConverter.strToBigDecimal(jo.optString(FNPayTotal));
    }
    if (jo.has(FNFeeTotal)) {
      feeTotal = CardConverter.strToBigDecimal(jo.optString(FNFeeTotal));
    }
    if (jo.has(FNPayCards)) {
      JSONArray a = jo.optJSONArray(FNPayCards);
      if (a != null) {
        for (int i = 0; i < a.length(); ++i) {
          payCards.add(new TPayCardRec(a.getJSONObject(i)));
        }
      }
    }
  }

  @Override
  public String toString() {
    super.toString();
    for (int i = 0; i < cardInfo.size(); ++i) {
      jo.accumulate(FNCardInfo, cardInfo.get(i).toJson());
    }
    jo.put(FNXid, xid);
    jo.put(FNPayTotal, CardConverter.bigDecimalToStr(payTotal));
    jo.put(FNFeeTotal, CardConverter.bigDecimalToStr(feeTotal));
    for (int i = 0; i < payCards.size(); ++i) {
      jo.accumulate(FNPayCards, payCards.get(i).toJson());
    }
    return jo.toString();
  }

}
