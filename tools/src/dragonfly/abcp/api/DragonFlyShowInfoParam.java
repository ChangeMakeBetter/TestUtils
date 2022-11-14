package dragonfly.abcp.api;

import java.util.ArrayList;
import java.util.List;

/**
 * </br>
 * Created by yangxiaohua on 2022/10/9.
 */
public class DragonFlyShowInfoParam {

  private List<DragonFlyGoods> goods = new ArrayList<>();

  private DragonFlyTrade trade;

  private DragonFlyMember member;

  public List<DragonFlyGoods> getGoods() {
    return goods;
  }

  public void setGoods(List<DragonFlyGoods> goods) {
    this.goods = goods;
  }

  public DragonFlyTrade getTrade() {
    return trade;
  }

  public void setTrade(DragonFlyTrade trade) {
    this.trade = trade;
  }

  public DragonFlyMember getMember() {
    return member;
  }

  public void setMember(DragonFlyMember member) {
    this.member = member;
  }
}
