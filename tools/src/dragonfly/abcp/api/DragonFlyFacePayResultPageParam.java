package dragonfly.abcp.api;

/**
 * </br>
 * Created by yangxiaohua on 2022/10/9.
 */
public class DragonFlyFacePayResultPageParam {

  private DragonFlyPayTrade payTrade;

  public DragonFlyPayTrade getPayTrade() {
    return payTrade;
  }

  public void setPayTrade(DragonFlyPayTrade payTrade) {
    this.payTrade = payTrade;
  }

  public static final class DragonFlyFacePayResultPageParamBuilder {
    private DragonFlyPayTrade payTrade;

    private DragonFlyFacePayResultPageParamBuilder() {
    }

    public static DragonFlyFacePayResultPageParamBuilder aDragonFlyFacePayResultPageParam() {
      return new DragonFlyFacePayResultPageParamBuilder();
    }

    public DragonFlyFacePayResultPageParamBuilder withPayTrade(DragonFlyPayTrade payTrade) {
      this.payTrade = payTrade;
      return this;
    }

    public DragonFlyFacePayResultPageParam build() {
      DragonFlyFacePayResultPageParam dragonFlyFacePayResultPageParam = new DragonFlyFacePayResultPageParam();
      dragonFlyFacePayResultPageParam.setPayTrade(payTrade);
      return dragonFlyFacePayResultPageParam;
    }
  }
}
