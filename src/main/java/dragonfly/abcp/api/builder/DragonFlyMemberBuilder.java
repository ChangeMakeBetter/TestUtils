package dragonfly.abcp.api.builder;

import dragonfly.abcp.api.DragonFlyMember;

/**
 * </br>
 * Created by yangxiaohua on 2022/10/9.
 */
public final class DragonFlyMemberBuilder {
  private String phoneNo;
  private String no;
  private String balance;
  private String point;
  private String name;
  private boolean hide;

  private DragonFlyMemberBuilder() {
  }

  public static DragonFlyMemberBuilder aDragonFlyMember() {
    return new DragonFlyMemberBuilder();
  }

  public DragonFlyMemberBuilder withPhoneNo(String phoneNo) {
    this.phoneNo = phoneNo;
    return this;
  }

  public DragonFlyMemberBuilder withNo(String no) {
    this.no = no;
    return this;
  }

  public DragonFlyMemberBuilder withBalance(String balance) {
    this.balance = balance;
    return this;
  }

  public DragonFlyMemberBuilder withPoint(String point) {
    this.point = point;
    return this;
  }

  public DragonFlyMemberBuilder withName(String name) {
    this.name = name;
    return this;
  }

  public DragonFlyMemberBuilder withHide(boolean hide) {
    this.hide = hide;
    return this;
  }

  public DragonFlyMember build() {
    DragonFlyMember dragonFlyMember = new DragonFlyMember();
    dragonFlyMember.setPhoneNo(phoneNo);
    dragonFlyMember.setNo(no);
    dragonFlyMember.setBalance(balance);
    dragonFlyMember.setPoint(point);
    dragonFlyMember.setName(name);
    dragonFlyMember.setHide(hide);
    return dragonFlyMember;
  }
}
