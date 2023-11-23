package dragonfly.abcp.api;

/**
 * </br>
 * Created by yangxiaohua on 2022/10/9.
 */
public class DragonFlyOpenCardParam {
  //开卡模式
  //OPENAPI：旧版开卡方式
  //SPI：新版开卡方式
  public static final String CALLBACKTYPE_OPENAPI = "OPENAPI", CALLBACKTYPE_SPI = "SPI";
  // 配置会员卡模板对应的商户PID
  private String providerId;
  // 用于配置会员卡模板的开放平台商家应用ID
  private String appId;
  // 会员卡模板ID
  private String templateId;
  // 开卡模式
  private String callbackType;
  // 以json字符串形式传入的方法调用参数
  private String extInfo;

  public String getProviderId() {
    return providerId;
  }

  public void setProviderId(String providerId) {
    this.providerId = providerId;
  }

  public String getAppId() {
    return appId;
  }

  public void setAppId(String appId) {
    this.appId = appId;
  }

  public String getTemplateId() {
    return templateId;
  }

  public void setTemplateId(String templateId) {
    this.templateId = templateId;
  }

  public String getCallbackType() {
    return callbackType;
  }

  public void setCallbackType(String callbackType) {
    this.callbackType = callbackType;
  }

  public String getExtInfo() {
    return extInfo;
  }

  public void setExtInfo(String extInfo) {
    this.extInfo = extInfo;
  }

  public static final class DragonFlyOpenCardParamBuilder {
    private String providerId;
    private String appId;
    private String templateId;
    private String callbackType;
    private String extInfo;

    private DragonFlyOpenCardParamBuilder() {
    }

    public static DragonFlyOpenCardParamBuilder aDragonFlyOpenCardParam() {
      return new DragonFlyOpenCardParamBuilder();
    }

    public DragonFlyOpenCardParamBuilder withProviderId(String providerId) {
      this.providerId = providerId;
      return this;
    }

    public DragonFlyOpenCardParamBuilder withAppId(String appId) {
      this.appId = appId;
      return this;
    }

    public DragonFlyOpenCardParamBuilder withTemplateId(String templateId) {
      this.templateId = templateId;
      return this;
    }

    public DragonFlyOpenCardParamBuilder withCallbackType(String callbackType) {
      this.callbackType = callbackType;
      return this;
    }

    public DragonFlyOpenCardParamBuilder withExtInfo(String extInfo) {
      this.extInfo = extInfo;
      return this;
    }

    public DragonFlyOpenCardParam build() {
      DragonFlyOpenCardParam dragonFlyOpenCardParam = new DragonFlyOpenCardParam();
      dragonFlyOpenCardParam.setProviderId(providerId);
      dragonFlyOpenCardParam.setAppId(appId);
      dragonFlyOpenCardParam.setTemplateId(templateId);
      dragonFlyOpenCardParam.setCallbackType(callbackType);
      dragonFlyOpenCardParam.setExtInfo(extInfo);
      return dragonFlyOpenCardParam;
    }
  }
}
