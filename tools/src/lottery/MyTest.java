package lottery;

/**
 * @author zhangweigang
 * @date 2022/6/30
 */
public class MyTest {
  // 基于计数的抽奖

  /**
   * 基于固定数量奖品的基础抽奖, 比较简陋
   *
   * @param awardPool 奖池, 值为true代表该奖已经被抽走
   * @return 返回抽到的将的下标
   */
  private static int draw(boolean[] awardPool) {

    int index;
    while (true) {
      // 拿到一个[0,awardPool)的随机数(就是模拟一次抽奖)
      index = (int) (awardPool.length * Math.random());
      // System.out.println(index);
      // 如果该抽奖结果已经被抽走了, 进入下次循环继续抽奖
      if (!awardPool[index]) {
        // 抽中奖品, 将该位置设置为已被抽走, 返回下标
        awardPool[index] = true;
        return index;
      }
    }
  }

  //  public static void main(String[] args) {
  //    int total = 100;
  //    // 一等奖
  //    int first = 1;
  //    // 二等奖
  //    int second = 4;
  //    // 三等奖
  //    int third = 5;
  //    // 四等奖
  //    int fourth = 20;
  //    // 奖池, 为true代表该位置的奖已经被抽走, draw方法抽到为true的位置时会再进行一次抽奖
  //    boolean[] awardPool = new boolean[total];
  //    // 计数抽奖结果
  //    Multiset<String> wordMultiset = HashMultiset.create();
  //    // 进行循环抽奖, 抽奖次数为奖池的大小
  //    for (int i = 0; i < awardPool.length; i++) {
  //      int drawResult = draw(awardPool);
  //      if (drawResult < first) {
  //        wordMultiset.add("first");
  //        // System.out.println("first");
  //      } else if (drawResult < first + second) {
  //        wordMultiset.add("second");
  //        // System.out.println("second");
  //      } else if (drawResult < first + second + third) {
  //        wordMultiset.add("third");
  //        // System.out.println("third");
  //      } else if (drawResult < first + second + third + fourth) {
  //        wordMultiset.add("fourth");
  //        // System.out.println("fourth");
  //      } else {
  //        wordMultiset.add("rest");
  //        // System.out.println("rest");
  //      }
  //    }
  //    System.out.println(wordMultiset);
  //    System.out.println(wordMultiset.size());
  //  }
}
