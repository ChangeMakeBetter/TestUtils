package dragonfly.abcp.api;

/**
 * </br>
 * Created by yangxiaohua on 2022/10/9.
 */
public class DragonFlyFacePayResult {
  // 1000情况下，说明刷脸成功，其他都为失败
  private int code;
  // 刷脸业务的结果码，如果为"SCAN_BAR_CODE"表示是扫码返回的结果，只有barCode数据
  private String subCode;
  // 刷脸业务的结果码对应文案
  private String subMessage;
  // 刷脸结果ftoken
  private String ftoken;
  // 会员登录/开卡成功情况下，返回用户的支付宝UID
  private String alipayUid;
  // 用于支付的barCode
  private String barCode;
  // 用户的可选账号列表
  private String accountList;

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

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

  public String getBarCode() {
    return barCode;
  }

  public void setBarCode(String barCode) {
    this.barCode = barCode;
  }

  public String getAccountList() {
    return accountList;
  }

  public void setAccountList(String accountList) {
    this.accountList = accountList;
  }

  public boolean isOK() {
    return code == 1000;
  }

  @Override
  public String toString() {
    return "DragonFlyFacePayResult{" +
      "code=" + code +
      ", subCode='" + subCode + '\'' +
      ", subMessage='" + subMessage + '\'' +
      ", ftoken='" + ftoken + '\'' +
      ", alipayUid='" + alipayUid + '\'' +
      ", barCode='" + barCode + '\'' +
      ", accountList='" + accountList + '\'' +
      '}';
  }
}
