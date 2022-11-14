package dragonfly.abcp.api;

/**
 * </br>
 * Created by yangxiaohua on 2022/10/9.
 */
public class DragonFlyResultMap {

  private BaseDragonFlyResult result;

  public BaseDragonFlyResult getResult() {
    return result;
  }

  public void setResult(BaseDragonFlyResult result) {
    this.result = result;
  }

  @Override
  public String toString() {
    return "DragonFlyResultMap{" +
      "result=" + result +
      '}';
  }
}
