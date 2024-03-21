package test.recover.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.tapestry.json.JSONArray;
import org.apache.tapestry.json.JSONObject;

import utils.Converter;

public class Trade implements Serializable {
  private static final long serialVersionUID = 1L;
  private String uuid;// String(32) 销售单uuid
  private String posNo;// String(10) POS机号
  private String flowNo;// String(12) 销售单流水号
  private Date filldate;// Date 填单时间，取第一条明细的开始时间
  private UCN filler = new UCN();// String(32) 填单人uuid
  private String vendorUuid;// String(32) 供应商uuid
  private String vendorCode;// String(32) 供应商uuid
  private String vendorName;// String(32) 供应商uuid
  private String batchNum;// String(20) 批次号

  /**
   * 追溯码
   */
  private String traceCode;
  private BigDecimal goodsTotal;// BigDecimal 商品总金额
  private BigDecimal serviceCharge;// BigDecimal 买方服务费
  private BigDecimal shouldPay;// BigDecimal 应付金额
  private BigDecimal actualPay;// BigDecimal 实付金额。如果是现金结算，取值为零。
  private Date boReceivedTime;
  private BigDecimal cardBalance;
  private String memberCode; // JPOS-2579
  private String memberName;
  private BigDecimal deposit = BigDecimal.ZERO;
  private UCN store = new UCN();
  private BigDecimal weightAmount = BigDecimal.ZERO;// BigDecimal 地磅使用费用

  // 以下为溯源字段
  /**
   * 经营主体代码（溯源）
   */
  private String bizEntityCode;
  /**
   * 经营主体名称 （溯源）
   */
  private String bizEntityName;
  /**
   * 批次码（溯源）
   */
  private String patchno;

  private String multiTradeId;

  List<TradeProductLine> products = new ArrayList<TradeProductLine>();// 商品明细列表
  List<TradePaymentLine> payments = new ArrayList<TradePaymentLine>();// 付款明细列表。如果是现金结算为null。

  public Trade() {
  }

  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  public String getVendorUuid() {
    return vendorUuid;
  }

  public void setVendorUuid(String vendorUuid) {
    this.vendorUuid = vendorUuid;
  }

  public String getBatchNum() {
    return batchNum;
  }

  public void setBatchNum(String batchNum) {
    this.batchNum = batchNum;
  }

  public String getTraceCode() {
    return traceCode;
  }

  public void setTraceCode(String traceCode) {
    this.traceCode = traceCode;
  }

  public List<TradeProductLine> getProducts() {
    return products;
  }

  public void setProducts(List<TradeProductLine> products) {
    this.products = products;
  }

  public BigDecimal getGoodsTotal() {
    return goodsTotal;
  }

  public void setGoodsTotal(BigDecimal goodsTotal) {
    this.goodsTotal = goodsTotal;
  }

  public BigDecimal getServiceCharge() {
    return serviceCharge;
  }

  public void setServiceCharge(BigDecimal serviceCharge) {
    this.serviceCharge = serviceCharge;
  }

  public BigDecimal getShouldPay() {
    return shouldPay;
  }

  public void setShouldPay(BigDecimal shouldPay) {
    this.shouldPay = shouldPay;
  }

  public BigDecimal getActualPay() {
    return actualPay;
  }

  public void setActualPay(BigDecimal actualPay) {
    this.actualPay = actualPay;
  }

  public List<TradePaymentLine> getPayments() {
    return payments;
  }

  public void setPayments(List<TradePaymentLine> payments) {
    this.payments = payments;
  }

  public String getPosNo() {
    return posNo;
  }

  public void setPosNo(String posNo) {
    this.posNo = posNo;
  }

  public String getFlowNo() {
    return flowNo;
  }

  public void setFlowNo(String flowNo) {
    this.flowNo = flowNo;
  }

  public String getMultiTradeId() {
    return multiTradeId;
  }

  public void setMultiTradeId(String multiTradeId) {
    this.multiTradeId = multiTradeId;
  }

  public JSONObject toJson() {
    JSONObject jo = new JSONObject();
    jo.put("uuid", uuid);
    jo.put("posNo", posNo);
    jo.put("flowNo", flowNo);
    jo.put("filldate_yMd", Converter.toString_yMd(filldate));
    jo.put("filldate", Converter.toString(filldate));
    jo.put("vendorUuid", vendorUuid);
    jo.put("vendorCode", vendorCode);
    jo.put("vendorName", vendorName);
    jo.put("batchNum", batchNum);
    jo.put("traceCode", traceCode);
    jo.put("memberCode", memberCode); // JPOS-2579
    jo.put("memberName", memberName);
    jo.put("goodsTotal", Converter.toMoneyString(goodsTotal));
    jo.put("serviceCharge", Converter.toMoneyString(serviceCharge));
    jo.put("shouldPay", Converter.toMoneyString(shouldPay));
    jo.put("actualPay", Converter.toMoneyString(actualPay));
    jo.put("deposit", Converter.toMoneyString(deposit));
    jo.put("cardBalance", Converter.toMoneyString(cardBalance));
    jo.put("boReceivedTime", Converter.toString_yMd(boReceivedTime));
    jo.put("weightAmount", Converter.toMoneyString(weightAmount));
    jo.put("multiTradeId", multiTradeId);
    JSONObject fillerJO = new JSONObject();
    fillerJO.put("uuid", filler == null ? "" : filler.getUuid());
    fillerJO.put("code", filler == null ? "" : filler.getCode());
    fillerJO.put("name", filler == null ? "" : filler.getName());
    jo.put("filler", fillerJO);

    JSONObject storeJO = new JSONObject();
    storeJO.put("uuid", store == null ? "" : store.getUuid());
    storeJO.put("code", store == null ? "" : store.getCode());
    storeJO.put("name", filler == null ? "" : store.getName());
    jo.put("store", storeJO);
    for (TradeProductLine line : products) {
      jo.accumulate("products", line.toJson());
    }

    for (TradePaymentLine line : payments) {
      jo.accumulate("payments", line.toJson());
    }
    return jo;
  }

  public Trade(JSONObject jo) {
    uuid = jo.optString("uuid", null);
    posNo = jo.optString("posNo", null);
    flowNo = jo.optString("flowNo", null);
    filldate = Converter.toDate(jo.optString("filldate"));
    vendorUuid = jo.optString("vendorUuid", null);
    vendorCode = jo.optString("vendorCode", null);
    vendorName = jo.optString("vendorName", null);
    memberCode = jo.optString("memberCode", null); // JPOS-2579
    memberName = jo.optString("memberName", null);
    batchNum = jo.optString("batchNum", null);
    traceCode = jo.optString("traceCode", null);
    goodsTotal = Converter.toBigDecimal(jo.optString("goodsTotal"));
    serviceCharge = Converter.toBigDecimal(jo.optString("serviceCharge"));
    shouldPay = Converter.toBigDecimal(jo.optString("shouldPay"));
    actualPay = Converter.toBigDecimal(jo.optString("actualPay"));
    cardBalance = Converter.toBigDecimal(jo.optString("cardBalance"));
    deposit = Converter.toBigDecimal(jo.optString("deposit"));
    weightAmount = Converter.toBigDecimal(jo.optString("weightAmount"));
    boReceivedTime = Converter.toDate(jo.optString("boReceivedTime"));
    multiTradeId = jo.optString("multiTradeId", null);
    JSONObject fillerJO = jo.optJSONObject("filler");
    if (fillerJO != null) {
      filler = new UCN();
      filler.setUuid(fillerJO.optString("uuid", null));
      filler.setCode(fillerJO.optString("code", null));
      filler.setName(fillerJO.optString("name", null));
    }

    JSONObject storeJO = jo.optJSONObject("store");
    if (storeJO != null) {
      store = new UCN();
      store.setUuid(storeJO.optString("uuid", null));
      store.setCode(storeJO.optString("code", null));
      store.setName(storeJO.optString("name", null));
    }

    JSONArray jaProducts = jo.optJSONArray("products");
    for (int i = 0; jaProducts != null && i < jaProducts.length(); ++i) {
      products.add(new TradeProductLine(this, jaProducts.getJSONObject(i)));
    }

    JSONArray jaPayments = jo.optJSONArray("payments");
    for (int i = 0; jaPayments != null && i < jaPayments.length(); ++i) {
      payments.add(new TradePaymentLine(this, jaPayments.getJSONObject(i)));
    }
  }

  public Trade replicate() {
    Trade trade = new Trade();
    trade.setFilldate(getFilldate());
    trade.setStore(getStore());
    trade.setPosNo(getPosNo());
    trade.setFiller(getFiller());
    trade.setVendorUuid(getVendorUuid());
    trade.setBatchNum(getBatchNum());
    trade.setTraceCode(getTraceCode());
    trade.setGoodsTotal(getGoodsTotal());
    trade.setServiceCharge(getServiceCharge());
    trade.setShouldPay(getShouldPay());
    trade.setActualPay(getActualPay());
    trade.setFlowNo(getFlowNo());
    trade.setVendorCode(getVendorCode());
    trade.setVendorName(getVendorName());
    trade.setBoReceivedTime(getBoReceivedTime());
    trade.setCardBalance(getCardBalance());
    trade.setMemberCode(getMemberCode());
    trade.setMemberName(getMemberName());
    trade.setDeposit(getDeposit());
    trade.setBizEntityCode(getBizEntityCode());
    trade.setBizEntityName(getBizEntityName());
    trade.setPatchno(getPatchno());
    trade.setWeightAmount(getWeightAmount());
    trade.setMultiTradeId(getMultiTradeId());

    for (TradeProductLine line : getProducts()) {
      trade.getProducts().add(line.replicate(trade));
    }
    for (TradePaymentLine payment : getPayments()) {
      trade.getPayments().add(payment.replicate(trade));
    }
    return trade;
  }

  @Override
  public String toString() {
    return toJson().toString();
  }

  public String getVendorCode() {
    return vendorCode;
  }

  public void setVendorCode(String vendorCode) {
    this.vendorCode = vendorCode;
  }

  public String getVendorName() {
    return vendorName;
  }

  public void setVendorName(String vendorName) {
    this.vendorName = vendorName;
  }

  public Date getBoReceivedTime() {
    return boReceivedTime;
  }

  public void setBoReceivedTime(Date boReceivedTime) {
    this.boReceivedTime = boReceivedTime;
  }

  public UCN getFiller() {
    return filler;
  }

  public void setFiller(UCN filler) {
    this.filler = filler;
  }

  public UCN getStore() {
    return store;
  }

  public void setStore(UCN store) {
    this.store = store;
  }

  public Date getFilldate() {
    return filldate;
  }

  public void setFilldate(Date filldate) {
    this.filldate = filldate;
  }

  public BigDecimal getCardBalance() {
    return cardBalance;
  }

  public void setCardBalance(BigDecimal cardBalance) {
    this.cardBalance = cardBalance;
  }

  public String getMemberCode() {
    return memberCode;
  }

  public void setMemberCode(String memberCode) {
    this.memberCode = memberCode;
  }

  public String getMemberName() {
    return memberName;
  }

  public void setMemberName(String memberName) {
    this.memberName = memberName;
  }

  public BigDecimal getDeposit() {
    return deposit;
  }

  public void setDeposit(BigDecimal deposit) {
    this.deposit = deposit;
  }

  public String getBizEntityCode() {
    return bizEntityCode;
  }

  public void setBizEntityCode(String bizEntityCode) {
    this.bizEntityCode = bizEntityCode;
  }

  public String getBizEntityName() {
    return bizEntityName;
  }

  public void setBizEntityName(String bizEntityName) {
    this.bizEntityName = bizEntityName;
  }

  public String getPatchno() {
    return patchno;
  }

  public void setPatchno(String patchno) {
    this.patchno = patchno;
  }

  public BigDecimal getWeightAmount() {
    return weightAmount;
  }

  public void setWeightAmount(BigDecimal weightAmount) {
    this.weightAmount = weightAmount;
  }

  public boolean hasData() {
    if (getProducts() == null || getProducts().size() <= 0) {
      return false;
    }
    if (getProducts().size() > 1) {
      return true;
    } else if (getProducts().size() == 1 && getProducts().get(0).getProductUuid() != null) {
      return true;
    } else {
      return false;
    }
  }

  public TradeProductLine getFirstProduct() {
    if (getProducts() == null || getProducts().size() <= 0) {
      return null;
    }
    return getProducts().get(0);
  }

  public void aggregate() {
    BigDecimal goodsAmount = BigDecimal.ZERO;
    for (TradeProductLine productLine : products) {
      if (productLine.getProductUuid() == null) {
        continue;
      }
      goodsAmount = goodsAmount.add(productLine.getAmount() == null ? BigDecimal.ZERO : productLine.getAmount());
    }
    setGoodsTotal(goodsAmount);
  }

}
