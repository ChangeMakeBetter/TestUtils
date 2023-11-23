package cardserver.param.salecard;

import java.io.Serializable;
import java.math.BigDecimal;

import org.apache.tapestry.json.JSONObject;

import cardserver.param.CardConverter;

/**
 * 售卡实付明细
 */
public class TPayCardRec implements Serializable {
  private static final long serialVersionUID = 1L;

  public static final String FNCardNumber = "cardNumber";
  public static final String FNPayAmount = "payAmount";

  public String cardNumber;// 卡号
  public BigDecimal payAmount;// 实付

  public TPayCardRec() {
  }

  public TPayCardRec(JSONObject jo) {
    if (jo == null) {
      return;
    }
    if (jo.has(FNCardNumber)) {
      cardNumber = jo.optString(FNCardNumber);
    }
    if (jo.has(FNPayAmount)) {
      payAmount = CardConverter.strToBigDecimal(jo.optString(FNPayAmount));
    }
  }

  public JSONObject toJson() {
    JSONObject jo = new JSONObject();
    jo.put(FNCardNumber, cardNumber);
    jo.put(FNPayAmount, CardConverter.bigDecimalToStr(payAmount));
    return jo;
  }

  @Override
  public TPayCardRec clone() {
    TPayCardRec r = new TPayCardRec();
    r.cardNumber = cardNumber;
    r.payAmount = payAmount;
    return r;
  }

}
