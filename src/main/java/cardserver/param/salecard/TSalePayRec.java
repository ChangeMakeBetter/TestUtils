package cardserver.param.salecard;

import java.io.Serializable;
import java.math.BigDecimal;

import org.apache.tapestry.json.JSONObject;

import cardserver.param.CardConverter;

/**
 * 付款方式明细
 */
public final class TSalePayRec implements Serializable {
  private static final long serialVersionUID = 1L;

  public static final String FNPayModeCode = "payModeCode";
  public static final String FNPayModeName = "payModeName";
  public static final String FNPayMoney = "payMoney";
  public static final String FNPayChannel = "payChannel";
  public static final String FNPayChannelCode = "payChannelCode";
  public static final String FNPayChannelBillNum = "payChannelBillNum";
  public static final String FNPayCardNo = "payCardNo";
  public static final String FNPayPassword = "payPassword";

  /**
   * 付款方式代码
   */
  public String payModeCode;
  /**
   * 付款方式名称
   */
  public String payModeName;
  /**
   * 付款金额
   */
  public BigDecimal payMoney;
  /**
   * 付款渠道Name
   */
  public String payChannel;
  /**
   * 付款渠道Code
   */
  public String payChannelCode;
  /**
   * 付款渠道单号
   */
  public String payChannelBillNum;
  /**
   * 支付卡号
   */
  public String payCardNo;
  /**
   * 支付密码
   */
  public String payPassword;

  public TSalePayRec() {
  }

  public TSalePayRec(JSONObject jo) {
    if (jo == null) {
      return;
    }
    if (jo.has(FNPayModeCode)) {
      payModeCode = jo.optString(FNPayModeCode);
    }
    if (jo.has(FNPayModeName)) {
      payModeName = jo.optString(FNPayModeName);
    }
    if (jo.has(FNPayMoney)) {
      payMoney = CardConverter.strToBigDecimal(jo.optString(FNPayMoney));
    }
    if (jo.has(FNPayChannel)) {
      payChannel = jo.optString(FNPayChannel);
    }
    if (jo.has(FNPayChannelCode)) {
      payChannelCode = jo.optString(FNPayChannelCode);
    }
    if (jo.has(FNPayChannelBillNum)) {
      payChannelBillNum = jo.optString(FNPayChannelBillNum);
    }
    if (jo.has(FNPayCardNo)) {
      payCardNo = jo.optString(FNPayCardNo);
    }
    if (jo.has(FNPayPassword)) {
      payPassword = jo.optString(FNPayPassword);
    }
  }

  public JSONObject toJson() {
    JSONObject jo = new JSONObject();
    jo.put(FNPayModeCode, payModeCode);
    jo.put(FNPayModeName, payModeName);
    jo.put(FNPayMoney, CardConverter.bigDecimalToStr(payMoney));
    jo.put(FNPayChannel, payChannel);
    jo.put(FNPayChannelCode, payChannelCode);
    jo.put(FNPayChannelBillNum, payChannelBillNum);
    jo.put(FNPayCardNo, payCardNo);
    jo.put(FNPayPassword, payPassword);
    return jo;
  }

  @Override
  public TSalePayRec clone() {
    TSalePayRec r = new TSalePayRec();
    r.payModeCode = payModeCode;
    r.payModeName = payModeName;
    r.payMoney = payMoney;
    r.payChannel = payChannel;
    r.payChannelCode = payChannelCode;
    r.payChannelBillNum = payChannelBillNum;
    r.payCardNo = payCardNo;
    r.payPassword = payPassword;
    return r;
  }

}
