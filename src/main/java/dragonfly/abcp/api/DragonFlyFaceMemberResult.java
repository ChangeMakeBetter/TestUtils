package dragonfly.abcp.api;

/**
 * </br>
 * Created by yangxiaohua on 2022/10/9.
 */
public class DragonFlyFaceMemberResult {

  // 刷脸结果码，"OK_SUCCESS"或"000"表示成功
  private String subCode;
  // 刷脸结果码对应文案
  private String subMessage;
  // 刷脸结果ftoken
  private String ftoken;
  // 会员登录/开卡成功情况下，返回用户的支付宝UID
  private String alipayUid;
  // 开卡结果 0：未知  1：会员登录成功  2：会员登录失败
  private int openResult;
  // 登录类型 MEMBER_OPEN_CARD：表示是开卡  MEMBER_LOGIN：表示是登录
  private String loginType;

  public String getSubCode() {
    return subCode;
  }

  public void setSubCode(String subCode) {
    this.subCode = subCode;
  }

  public String getSubMessage() {
    return subMessage;
  }

  public void setSubMessage(String subMessage) {
    this.subMessage = subMessage;
  }

  public String getFtoken() {
    return ftoken;
  }

  public void setFtoken(String ftoken) {
    this.ftoken = ftoken;
  }

  public String getAlipayUid() {
    return alipayUid;
  }

  public void setAlipayUid(String alipayUid) {
    this.alipayUid = alipayUid;
  }

  public int getOpenResult() {
    return openResult;
  }

  public void setOpenResult(int openResult) {
    this.openResult = openResult;
  }

  public String getLoginType() {
    return loginType;
  }

  public void setLoginType(String loginType) {
    this.loginType = loginType;
  }

  @Override
  public String toString() {
    return "DragonFlyFaceMemberResult{" +
      "subCode='" + subCode + '\'' +
      ", subMessage='" + subMessage + '\'' +
      ", ftoken='" + ftoken + '\'' +
      ", alipayUid='" + alipayUid + '\'' +
      ", openResult=" + openResult +
      ", loginType='" + loginType + '\'' +
      '}';
  }
}
