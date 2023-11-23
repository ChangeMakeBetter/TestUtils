package dragonfly.abcp.api.builder;

import dragonfly.abcp.api.DragonFlyTrade;

/**
 * </br>
 * Created by yangxiaohua on 2022/10/9.
 */
public final class DragonFlyTradeBuilder {
  private String totalAmount;
  private String actualAmount;
  private String totalDiscount;
  private String actualReceipts;
  private String change;
  private String payChannel;
  private String tradeStatus;
  private String tradeNo;
  private String discountType;
  private String discountTypeAmount;

  private DragonFlyTradeBuilder() {
  }

  public static DragonFlyTradeBuilder aDragonFlyTrade() {
    return new DragonFlyTradeBuilder();
  }

  public DragonFlyTradeBuilder withTotalAmount(String totalAmount) {
    this.totalAmount = totalAmount;
    return this;
  }

  public DragonFlyTradeBuilder withActualAmount(String actualAmount) {
    this.actualAmount = actualAmount;
    return this;
  }

  public DragonFlyTradeBuilder withTotalDiscount(String totalDiscount) {
    this.totalDiscount = totalDiscount;
    return this;
  }

  public DragonFlyTradeBuilder withActualReceipts(String actualReceipts) {
    this.actualReceipts = actualReceipts;
    return this;
  }

  public DragonFlyTradeBuilder withChange(String change) {
    this.change = change;
    return this;
  }

  public DragonFlyTradeBuilder withPayChannel(String payChannel) {
    this.payChannel = payChannel;
    return this;
  }

  public DragonFlyTradeBuilder withTradeStatus(String tradeStatus) {
    this.tradeStatus = tradeStatus;
    return this;
  }

  public DragonFlyTradeBuilder withTradeNo(String tradeNo) {
    this.tradeNo = tradeNo;
    return this;
  }

  public DragonFlyTradeBuilder withDiscountType(String discountType) {
    this.discountType = discountType;
    return this;
  }

  public DragonFlyTradeBuilder withDiscountTypeAmount(String discountTypeAmount) {
    this.discountTypeAmount = discountTypeAmount;
    return this;
  }

  public DragonFlyTrade build() {
    DragonFlyTrade dragonFlyTrade = new DragonFlyTrade();
    dragonFlyTrade.setTotalAmount(totalAmount);
    dragonFlyTrade.setActualAmount(actualAmount);
    dragonFlyTrade.setTotalDiscount(totalDiscount);
    dragonFlyTrade.setActualReceipts(actualReceipts);
    dragonFlyTrade.setChange(change);
    dragonFlyTrade.setPayChannel(payChannel);
    dragonFlyTrade.setTradeStatus(tradeStatus);
    dragonFlyTrade.setTradeNo(tradeNo);
    dragonFlyTrade.setDiscountType(discountType);
    dragonFlyTrade.setDiscountTypeAmount(discountTypeAmount);
    return dragonFlyTrade;
  }
}
