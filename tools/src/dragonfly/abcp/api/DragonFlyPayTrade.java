package dragonfly.abcp.api;

/**
 * </br>
 * Created by yangxiaohua on 2022/10/9.
 */
public class DragonFlyPayTrade {

  // 支付状态
  //1：发起支付（查询中）
  //2：支付失败
  private int payStatus;
  //支付失败code
  private String subCode;
  //支付失败原因, payStatus=2时传入
  private String subMsg;
  //固定值 "outer_pay"
  private String dynamicIdType;
  //发起这次订单的唯一ID（和订单上报中out_biz_id保持一致）
  private String tradeNo;

  public int getPayStatus() {
    return payStatus;
  }

  public void setPayStatus(int payStatus) {
    this.payStatus = payStatus;
  }

  public String getSubCode() {
    return subCode;
  }

  public void setSubCode(String subCode) {
    this.subCode = subCode;
  }

  public String getSubMsg() {
    return subMsg;
  }

  public void setSubMsg(String subMsg) {
    this.subMsg = subMsg;
  }

  public String getDynamicIdType() {
    return dynamicIdType;
  }

  public void setDynamicIdType(String dynamicIdType) {
    this.dynamicIdType = dynamicIdType;
  }

  public String getTradeNo() {
    return tradeNo;
  }

  public void setTradeNo(String tradeNo) {
    this.tradeNo = tradeNo;
  }

  public static final class DragonFlyPayTradeBuilder {
    private int payStatus;
    private String subCode;
    private String subMsg;
    private String dynamicIdType;
    private String tradeNo;

    private DragonFlyPayTradeBuilder() {
    }

    public static DragonFlyPayTradeBuilder aDragonFlyPayTrade() {
      return new DragonFlyPayTradeBuilder();
    }

    public DragonFlyPayTradeBuilder withPayStatus(int payStatus) {
      this.payStatus = payStatus;
      return this;
    }

    public DragonFlyPayTradeBuilder withSubCode(String subCode) {
      this.subCode = subCode;
      return this;
    }

    public DragonFlyPayTradeBuilder withSubMsg(String subMsg) {
      this.subMsg = subMsg;
      return this;
    }

    public DragonFlyPayTradeBuilder withDynamicIdType(String dynamicIdType) {
      this.dynamicIdType = dynamicIdType;
      return this;
    }

    public DragonFlyPayTradeBuilder withTradeNo(String tradeNo) {
      this.tradeNo = tradeNo;
      return this;
    }

    public DragonFlyPayTrade build() {
      DragonFlyPayTrade dragonFlyPayTrade = new DragonFlyPayTrade();
      dragonFlyPayTrade.setPayStatus(payStatus);
      dragonFlyPayTrade.setSubCode(subCode);
      dragonFlyPayTrade.setSubMsg(subMsg);
      dragonFlyPayTrade.setDynamicIdType(dynamicIdType);
      dragonFlyPayTrade.setTradeNo(tradeNo);
      return dragonFlyPayTrade;
    }
  }
}
