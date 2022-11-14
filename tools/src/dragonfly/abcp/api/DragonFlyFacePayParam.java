package dragonfly.abcp.api;

/**
 * </br>
 * Created by yangxiaohua on 2022/10/9.
 */
public class DragonFlyFacePayParam {

  //待支付的金额，注意是string类型，如显示"1"元，则入参为"1.00"
  private String amount;
  //只支持updateAmount，用于更新待支付金额
  private String cashierType;
  //刷脸界面在用户无操作情况下的超时时间的秒数，注意是string类型。缺省值为"60"，单位秒
  private String expireTime;
  //是否需要在刷脸界面支持扫码并返回结果，false为不支持扫码，true为支持扫码，这里场景需要设置为：true
  private boolean enableScan;

  public String getAmount() {
    return amount;
  }

  public void setAmount(String amount) {
    this.amount = amount;
  }

  public String getCashierType() {
    return cashierType;
  }

  public void setCashierType(String cashierType) {
    this.cashierType = cashierType;
  }

  public String getExpireTime() {
    return expireTime;
  }

  public void setExpireTime(String expireTime) {
    this.expireTime = expireTime;
  }

  public boolean isEnableScan() {
    return enableScan;
  }

  public void setEnableScan(boolean enableScan) {
    this.enableScan = enableScan;
  }

  public static final class DragonFlyFacePayParamBuilder {
    private String amount;
    private String cashierType;
    private String expireTime;
    private boolean enableScan;

    private DragonFlyFacePayParamBuilder() {
    }

    public static DragonFlyFacePayParamBuilder aDragonFlyFacePayParam() {
      return new DragonFlyFacePayParamBuilder();
    }

    public DragonFlyFacePayParamBuilder withAmount(String amount) {
      this.amount = amount;
      return this;
    }

    public DragonFlyFacePayParamBuilder withCashierType(String cashierType) {
      this.cashierType = cashierType;
      return this;
    }

    public DragonFlyFacePayParamBuilder withExpireTime(String expireTime) {
      this.expireTime = expireTime;
      return this;
    }

    public DragonFlyFacePayParamBuilder withEnableScan(boolean enableScan) {
      this.enableScan = enableScan;
      return this;
    }

    public DragonFlyFacePayParam build() {
      DragonFlyFacePayParam dragonFlyFacePayParam = new DragonFlyFacePayParam();
      dragonFlyFacePayParam.setAmount(amount);
      dragonFlyFacePayParam.setCashierType(cashierType);
      dragonFlyFacePayParam.setExpireTime(expireTime);
      dragonFlyFacePayParam.setEnableScan(enableScan);
      return dragonFlyFacePayParam;
    }
  }
}
