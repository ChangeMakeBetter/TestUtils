package test.java8.trangoods;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * </br>
 * Created by yangxiaohua on 2024/4/8.
 */
public class TransactionProcessor {
  public static List<TranGoods> processTransaction(List<TranGoods> list, BigDecimal dAmount) {
    // 创建一个新的列表用于操作，保持原列表不变
    List<TranGoods> newList = new ArrayList<>(list);

    // 对新列表按照 amount 的降序进行排序
    Collections.sort(newList, (g1, g2) -> g2.getAmount().compareTo(g1.getAmount()));

    BigDecimal remainingAmount = dAmount;

    // 遍历排序后的列表，依次扣减金额
    for (TranGoods goods : newList) {
      BigDecimal currentAmount = goods.getAmount();
      if (remainingAmount.compareTo(BigDecimal.ZERO) > 0) {
        if (remainingAmount.compareTo(currentAmount) >= 0) {
          // 扣减当前商品的全部 amount
          remainingAmount = remainingAmount.subtract(currentAmount);
          goods.setAmount(BigDecimal.ZERO); // 扣减为0
        } else {
          // 扣减部分 amount
          goods.setAmount(currentAmount.subtract(remainingAmount));
          remainingAmount = BigDecimal.ZERO;
        }
      } else {
        break; // 剩余金额已经为0，不需要再扣减
      }
    }

    return list; // 返回原始列表（顺序不变）
  }

  public static void main(String[] args) {
    List<TranGoods> list = new ArrayList<>();
    list.add(new TranGoods(1, new BigDecimal("100")));
    list.add(new TranGoods(2, new BigDecimal("50")));
    list.add(new TranGoods(3, new BigDecimal("80")));

    BigDecimal dAmount = new BigDecimal("120");

    System.out.println("原始列表：");
    System.out.println(list);

    List<TranGoods> processedList = processTransaction(list, dAmount);

    System.out.println("处理后的列表：");
    System.out.println(processedList);
  }
}
