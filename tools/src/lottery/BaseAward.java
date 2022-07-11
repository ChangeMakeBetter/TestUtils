package lottery;

/**
 * 奖品基类
 */
public class BaseAward {
  /**
   * 抽中这个奖品的概率
   */
  private Double probability;

  public Double getProbability() {
    return probability;
  }

  public void setProbability(Double probability) {
    this.probability = probability;
  }
}
