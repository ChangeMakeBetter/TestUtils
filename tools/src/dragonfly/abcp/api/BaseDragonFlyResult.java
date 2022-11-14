package dragonfly.abcp.api;

/**
 * </br>
 * Created by yangxiaohua on 2022/10/9.
 */
public class BaseDragonFlyResult {

  private int code;

  private String extInfo;

  private String subCode;
  private String subMessage;

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getExtInfo() {
    return extInfo;
  }

  public void setExtInfo(String extInfo) {
    this.extInfo = extInfo;
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

  @Override
  public String toString() {
    return "BaseDragonFlyResult{" +
      "code=" + code +
      ", extInfo='" + extInfo + '\'' +
      ", subCode='" + subCode + '\'' +
      ", subMessage='" + subMessage + '\'' +
      '}';
  }
}
