package dragonfly.abcp.api;

/**
 * </br>
 * Created by yangxiaohua on 2022/10/9.
 */
public class DragonFlyMember {

  // 会员电话（支付宝会在显示时，会对手机号第4-7位进行脱敏处理）
  private String phoneNo;
  // 会员卡号（如取不到电话时，会取卡号在会员信息区显示）
  private String no;
  // 会员余额
  private String balance;
  // 会员积分
  private String point;
  // 会员姓名
  private String name;
  // 是否隐藏会员,false不隐藏（默认），true隐藏
  private boolean hide;

  public String getPhoneNo() {
    return phoneNo;
  }

  public void setPhoneNo(String phoneNo) {
    this.phoneNo = phoneNo;
  }

  public String getNo() {
    return no;
  }

  public void setNo(String no) {
    this.no = no;
  }

  public String getBalance() {
    return balance;
  }

  public void setBalance(String balance) {
    this.balance = balance;
  }

  public String getPoint() {
    return point;
  }

  public void setPoint(String point) {
    this.point = point;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public boolean isHide() {
    return hide;
  }

  public void setHide(boolean hide) {
    this.hide = hide;
  }
}
