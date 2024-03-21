package test.recover.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import org.apache.tapestry.json.JSONObject;

import utils.Converter;

public class TradePaymentLine implements Serializable {
  private static final long serialVersionUID = 1L;
  private String uuid;
  private Trade owner;
  private int line; // Integer 行号
  private String payterm; // String(20) 付款方式，取值：现金、储值卡、鼎付通
  private BigDecimal amount; // BigDecimal 支付金额
  private String cardNum; // String(30) 支付卡号
  private String payResponse;

  public JSONObject toJson() {
    JSONObject jo = new JSONObject();
    jo.put("uuid", uuid);
    jo.put("line", line);
    jo.put("payterm", payterm);
    jo.put("amount", Converter.toMoneyString(amount));
    jo.put("cardNum", cardNum);
    jo.put("payResponse", payResponse);
    return jo;
  }

  public TradePaymentLine() {

  }

  public TradePaymentLine(Trade owner) {
    this.owner = owner;
  }

  public TradePaymentLine(Trade owner, JSONObject jo) {
    this.owner = owner;
    uuid = jo.optString("uuid", null);
    line = jo.optInt("line");
    payterm = jo.optString("productUuid", null);
    cardNum = jo.optString("productName", null);
    payResponse = jo.optString("payResponse", null);
    amount = Converter.toBigDecimal(jo.optString("amount"));
  }

  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  public Trade getOwner() {
    return owner;
  }

  public void setOwner(Trade owner) {
    this.owner = owner;
  }

  public int getLine() {
    return line;
  }

  public void setLine(int line) {
    this.line = line;
  }

  public String getPayterm() {
    return payterm;
  }

  public void setPayterm(String payterm) {
    this.payterm = payterm;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  public String getCardNum() {
    return cardNum;
  }

  public void setCardNum(String cardNum) {
    this.cardNum = cardNum;
  }

  public String getPayResponse() {
    return payResponse;
  }

  public void setPayResponse(String payResponse) {
    this.payResponse = payResponse;
  }

  public TradePaymentLine replicate(Trade trade) {
    TradePaymentLine line = new TradePaymentLine();
    line.setOwner(owner);
    line.setUuid(getUuid());
    line.setOwner(getOwner());
    line.setLine(getLine());
    line.setPayterm(getPayterm());
    line.setAmount(getAmount());
    line.setCardNum(getCardNum());
    line.setPayResponse(getPayResponse());
    return line;
  }
}
