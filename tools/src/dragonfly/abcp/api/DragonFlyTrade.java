package dragonfly.abcp.api;

/**
 * </br>
 * Created by yangxiaohua on 2022/10/9.
 */
public class DragonFlyTrade {
  // 合计金额
  private String totalAmount;
  // 应付金额
  private String actualAmount;
  // 优惠总金额
  private String totalDiscount;
  // 实收金额
  private String actualReceipts;
  // 找零金额
  private String change;
  // 支付渠道
  private String payChannel;
  // 交易状态
  private String tradeStatus;
  // 商家交易单号
  private String tradeNo;
  // 优惠类型
  private String discountType;
  // 优惠类型金额
  private String discountTypeAmount;

  public String getTotalAmount() {
    return totalAmount;
  }

  public void setTotalAmount(String totalAmount) {
    this.totalAmount = totalAmount;
  }

  public String getActualAmount() {
    return actualAmount;
  }

  public void setActualAmount(String actualAmount) {
    this.actualAmount = actualAmount;
  }

  public String getTotalDiscount() {
    return totalDiscount;
  }

  public void setTotalDiscount(String totalDiscount) {
    this.totalDiscount = totalDiscount;
  }

  public String getActualReceipts() {
    return actualReceipts;
  }

  public void setActualReceipts(String actualReceipts) {
    this.actualReceipts = actualReceipts;
  }

  public String getChange() {
    return change;
  }

  public void setChange(String change) {
    this.change = change;
  }

  public String getPayChannel() {
    return payChannel;
  }

  public void setPayChannel(String payChannel) {
    this.payChannel = payChannel;
  }

  public String getTradeStatus() {
    return tradeStatus;
  }

  public void setTradeStatus(String tradeStatus) {
    this.tradeStatus = tradeStatus;
  }

  public String getTradeNo() {
    return tradeNo;
  }

  public void setTradeNo(String tradeNo) {
    this.tradeNo = tradeNo;
  }

  public String getDiscountType() {
    return discountType;
  }

  public void setDiscountType(String discountType) {
    this.discountType = discountType;
  }

  public String getDiscountTypeAmount() {
    return discountTypeAmount;
  }

  public void setDiscountTypeAmount(String discountTypeAmount) {
    this.discountTypeAmount = discountTypeAmount;
  }
}
