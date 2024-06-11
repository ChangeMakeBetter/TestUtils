package test.java8.trangoods;

import java.math.BigDecimal;

/**
 * </br>
 * Created by yangxiaohua on 2024/4/8.
 */
public class TranGoods {
  private int id;
  public BigDecimal amount;

  public TranGoods(int id, BigDecimal amount) {
    this.id = id;
    this.amount = amount;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  @Override
  public String toString() {
    return "TranGoods{" +
      "id=" + id +
      ", amount=" + amount +
      '}';
  }
}