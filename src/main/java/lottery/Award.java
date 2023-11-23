package lottery;

/**
 * </br>
 * Created by yangxiaohua on 2022/6/23.
 */

/**
 * 奖品实现类
 */
public class Award extends BaseAward {
  private Integer id;
  private String name;
  private Double price;
  private Integer stock;
  private Integer defalutStock;

  public Award(Integer id, String name, Double price, Double probability, Integer stock) {
    super();
    this.id = id;
    this.name = name;
    this.price = price;
    this.stock = stock;
    this.defalutStock = stock;
    setProbability(probability);
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public Integer getStock() {
    return stock;
  }

  public void setStock(Integer stock) {
    this.stock = stock;
  }

  public void resetStock() {
    this.stock = defalutStock;
  }

  @Override
  public String toString() {
    return "Award{" +
      "id=" + id +
      ", name='" + name + '\'' +
      ", price=" + price +
      ", stock=" + stock +
      '}';
  }
}