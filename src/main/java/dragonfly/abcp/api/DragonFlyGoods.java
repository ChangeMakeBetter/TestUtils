package dragonfly.abcp.api;

/**
 * </br>
 * Created by yangxiaohua on 2022/10/9.
 */
public class DragonFlyGoods {
  // 名称
  private String name;
  // 单价
  private String price;
  // 单品实际价格
  private String actualPrice;
  // 小计原价
  private String finPrice;
  // 小计实际价
  private String finActualPrice;
  // 单品数量/重量 示例：x3
  private String number;
  // 商品数量/重量单位
  private String unit;
  // 属性 ，示例：常温、无糖
  private String type;
  // 名称
  private String attribute;
  // 商品编码
  private String productCode;
  // 条码
  private String barCode;
  // 商品图片地址
  private String image;
  // 订单商品总数量
  private String totalNumber;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPrice() {
    return price;
  }

  public void setPrice(String price) {
    this.price = price;
  }

  public String getActualPrice() {
    return actualPrice;
  }

  public void setActualPrice(String actualPrice) {
    this.actualPrice = actualPrice;
  }

  public String getFinPrice() {
    return finPrice;
  }

  public void setFinPrice(String finPrice) {
    this.finPrice = finPrice;
  }

  public String getFinActualPrice() {
    return finActualPrice;
  }

  public void setFinActualPrice(String finActualPrice) {
    this.finActualPrice = finActualPrice;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public String getUnit() {
    return unit;
  }

  public void setUnit(String unit) {
    this.unit = unit;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getAttribute() {
    return attribute;
  }

  public void setAttribute(String attribute) {
    this.attribute = attribute;
  }

  public String getProductCode() {
    return productCode;
  }

  public void setProductCode(String productCode) {
    this.productCode = productCode;
  }

  public String getBarCode() {
    return barCode;
  }

  public void setBarCode(String barCode) {
    this.barCode = barCode;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public String getTotalNumber() {
    return totalNumber;
  }

  public void setTotalNumber(String totalNumber) {
    this.totalNumber = totalNumber;
  }
}
