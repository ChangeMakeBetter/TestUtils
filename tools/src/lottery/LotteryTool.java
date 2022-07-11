package lottery;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.collections.CollectionUtils;

/**
 * </br>
 * Created by yangxiaohua on 2022/6/23.
 */
public class LotteryTool {

  /**
   * 抽奖方法
   *
   * @param awardList 奖品列表，这些是备选的奖品（一定有库存的）
   * @param <T>       具体奖品类型
   * @return 返回一个抽中的奖品
   */
  public static <T extends BaseAward> T draw(List<T> awardList) {
    if (CollectionUtils.isEmpty(awardList)) {
      return null;
    }

    // 获取总概率，当奖品总概率正好为1时，奖品的 probability 就是真实的概率，否则会按新的比例作为概率
    double sumProbability = awardList.stream()
      .map(BaseAward::getProbability)
      .reduce(0.0, Double::sum);

    // 一共会尝试 awardList.size() 次，确保能返回一个奖品
    for (T t : awardList) {
      // 使用随机值，左闭右开（包含0，不包含1）
      if (t.getProbability() > Math.random() * sumProbability) {
        return t;
      }
      // 本次没有命中此奖品，将总概率扣减当前没命中的奖品中奖概率，进入下一奖品中奖命中计算
      sumProbability = sumProbability - t.getProbability();
    }

    // 其它情况，会到这里（理论上，一定到不了这里的。）
    return null;
  }

  // 另一种算法，不适用
  public static <T extends BaseAward> T doLottery(List<T> awardList) {
    if (CollectionUtils.isEmpty(awardList)) {
      return null;
    }
    double lotteryDouble = Math.random();
    //    System.out.println("中奖 double：" + lotteryDouble);

    double[] distributed = new double[awardList.size()];
    int i = 0;
    double temp = 0;
    for (T o : awardList) {
      temp += o.getProbability();
      distributed[i] = temp;
      i++;
    }

    for (int j = 0; j < distributed.length; j++) {
      if (lotteryDouble <= distributed[j]) {
        return awardList.get(j);
      }
    }
    return null;
  }

  private static void refreshAwardList(List<Award> awardList) {
    awardList.add(new Award(1, "89折", 89.0, 0.45, 45));
    awardList.add(new Award(2, "79折", 79.0, 0.41, 41));
    awardList.add(new Award(3, "69折", 69.0, 0.06, 6));
    awardList.add(new Award(4, "59折", 59.0, 0.04, 4));
    awardList.add(new Award(5, "49折", 49.0, 0.03, 3));
    awardList.add(new Award(6, "1元", 1.0, 0.01, 1));
  }

  public static void main(String[] args) {
    // 奖品列表，库存一共100
    final List<Award> awardList = new ArrayList<>(6);
    refreshAwardList(awardList);
    System.out.println("开始抽奖:");
    int count = 100; // 抽奖总次数

    Map<String, Integer> awardMap = new HashMap<>();

    for (int i = 0; i < count; i++) {
      if (i % 100 == 0) {
        refreshAwardList(awardList);
      }
      String msg;
      Award draw = LotteryTool.draw(awardList);
      if (draw == null) {
        msg = "奖品抽完了，下次早点来吧~";
      } else {
        msg = String.format("抽到了价值[%s]的奖品[%s]", draw.getPrice(), draw.getName());

        if (awardMap.containsKey(draw.getName())) {
          Integer integer = awardMap.get(draw.getName());
          awardMap.put(draw.getName(), ++integer);
        } else {
          awardMap.put(draw.getName(), 1);
        }

        // 抽到奖品了，需要减库存，库存不足了，要从列表中剔除
        draw.setStock(draw.getStock() - 1);
        if (draw.getStock() <= 0) {
          //          awardList.remove(draw);
        }
      }

      System.out.println(String.format("第[%s]次抽奖，结果为：[%s]", i + 1, msg));
    }

    for (Entry<String, Integer> entry : awardMap.entrySet()) {
      System.out.println(String.format("奖品{%s}，中奖概率：[%s]", entry.getKey(),
        BigDecimal.valueOf(entry.getValue()).divide(BigDecimal.valueOf(count), 2, RoundingMode.HALF_UP)));
    }

    System.out.println("抽奖结束.");
  }
}
