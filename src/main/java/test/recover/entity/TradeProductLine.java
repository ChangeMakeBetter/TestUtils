package test.recover.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import org.apache.tapestry.json.JSONObject;

import utils.Converter;

public class TradeProductLine implements Serializable {
  private static final long serialVersionUID = 1L;
  public static final String SINGLEWEIGHT = "singleweighttype";
  public static final String TOTALWEIGHT = "totalweighttype";
  private String uuid;
  private Trade owner;
  private int line;// Integer 行号
  private String productUuid; // String(32) 商品uuid
  private String productCode;
  private String productName;
  private BigDecimal packages; // 重量
  private BigDecimal tareWeight;// 皮重
  private BigDecimal packagePrice;
  private BigDecimal packQty; // 包装数
  private BigDecimal invQty;// 库存数
  private String invBatch;// 库存批次
  private Integer quantity; // 销售数量
  private BigDecimal price; // 平均价格
  private BigDecimal inputprice; // 输入单价
  private BigDecimal amount; // 金额
  private BigDecimal deposit;// 押金
  private BigDecimal serviceCharge;
  private String weightType = SINGLEWEIGHT; // 称重方式
  /**
   * 追溯码
   */
  private String traceCode;

  // 以下为溯源字段
  /**
   * 产地 （溯源）
   */
  private String location;
  /**
   * 商品国标代码
   */
  private String scode;
  /**
   * 商品国标名称
   */
  private String sname;

  public String getWeightType() {
    return weightType;
  }

  public void setWeightType(String weightType) {
    this.weightType = weightType;
  }

  public TradeProductLine() {

  }

  public JSONObject toJson() {
    JSONObject jo = new JSONObject();
    jo.put("uuid", uuid);
    jo.put("line", line);
    jo.put("productUuid", productUuid);
    jo.put("productCode", productCode);
    jo.put("productName", productName);
    DecimalFormat fmt_weight = new DecimalFormat("0.0000");
    if (packages != null) {
      jo.put("packages", Converter.toString(fmt_weight.format(packages)));
    } else {
      jo.put("packages", null);
    }
    if (tareWeight != null) {
      jo.put("tareWeight", Converter.toString(fmt_weight.format(tareWeight)));
    } else {
      jo.put("tareWeight", null);
    }
    jo.put("quantity", Converter.toString(quantity));
    jo.put("price", Converter.toPriceString(price));
    jo.put("inputprice", Converter.toPriceString(inputprice));
    jo.put("amount", Converter.toMoneyString(amount));
    jo.put("deposit", Converter.toMoneyString(deposit));
    jo.put("packQty", Converter.toQtyString(packQty));
    jo.put("serviceCharge", Converter.toMoneyString(serviceCharge));
    jo.put("invQty", Converter.toQtyString(invQty));
    jo.put("invBatch", invBatch);
    jo.put("packagePrice", Converter.toPriceString(packagePrice));
    if (amount != null && quantity != null && packages != null) {
      jo.put("singlePrice", Converter.toPriceString(amount.divide(new BigDecimal(quantity.intValue()), amount.scale())
        .setScale(amount.scale(), RoundingMode.HALF_UP)));
      jo.put("singleWeight", Converter.toString(fmt_weight.format(packages.divide(new BigDecimal(quantity.intValue()),
        packages.scale()).setScale(packages.scale(), RoundingMode.HALF_UP))));
    }
    jo.put("weightType", weightType.equals(SINGLEWEIGHT) ? "定包装" : "散装");
    jo.put("weightPrice", weightType.equals(SINGLEWEIGHT) ? jo.optString("singlePrice") : Converter
      .toPriceString(price));
    jo.put("weight", weightType.equals(SINGLEWEIGHT) ? jo.optString("singleWeight") : Converter.toString(fmt_weight
      .format(packages)));
    jo.put("traceCode", traceCode);
    return jo;
  }

  public TradeProductLine(Trade owner, JSONObject jo) {
    this.owner = owner;
    uuid = jo.optString("uuid", null);
    line = jo.optInt("line");
    productUuid = jo.optString("productUuid", null);
    productName = jo.optString("productName", null);
    productCode = jo.optString("productCode", null);
    packages = Converter.toBigDecimal(jo.optString("packages"));
    tareWeight = Converter.toBigDecimal(jo.optString("tareWeight"));
    quantity = Converter.toInteger(jo.optString("quantity"));
    price = Converter.toBigDecimal(jo.optString("price"));
    inputprice = Converter.toBigDecimal(jo.optString("inputprice"));
    amount = Converter.toBigDecimal(jo.optString("amount"));
    deposit = Converter.toBigDecimal(jo.optString("deposit"));
    packQty = Converter.toBigDecimal(jo.optString("packQty"));
    serviceCharge = Converter.toBigDecimal(jo.optString("serviceCharge"));
    packagePrice = Converter.toBigDecimal(jo.optString("packagePrice"));
    weightType = jo.optString("weightType", null).equals("定包装") ? SINGLEWEIGHT : TOTALWEIGHT;
    traceCode = jo.optString("traceCode", null);
    invQty = Converter.toBigDecimal(jo.optString("invQty"));
    invBatch = jo.optString("invBatch", null);
  }

  public String getUuid() {
    return uuid;
  }

  public Trade getOwner() {
    return owner;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  public void setOwner(Trade owner) {
    this.owner = owner;
  }

  public int getLine() {
    return line;
  }

  public void setLine(int line) {
    this.line = line;
  }

  public String getProductUuid() {
    return productUuid;
  }

  public void setProductUuid(String productUuid) {
    this.productUuid = productUuid;
  }

  public String getProductCode() {
    return productCode;
  }

  public void setProductCode(String productCode) {
    this.productCode = productCode;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  public BigDecimal getPackages() {
    return packages;
  }

  public void setPackages(BigDecimal packages) {
    this.packages = packages;
  }

  public BigDecimal getDeposit() {
    return deposit;
  }

  public void setDeposit(BigDecimal deposit) {
    this.deposit = deposit;
  }

  public BigDecimal getServiceCharge() {
    return serviceCharge;
  }

  public void setServiceCharge(BigDecimal serviceCharge) {
    this.serviceCharge = serviceCharge;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public BigDecimal getPackagePrice() {
    return packagePrice;
  }

  public void setPackagePrice(BigDecimal packagePrice) {
    this.packagePrice = packagePrice;
  }

  public BigDecimal getPackQty() {
    return packQty;
  }

  public void setPackQty(BigDecimal packQty) {
    this.packQty = packQty;
  }

  public BigDecimal getInputprice() {
    return inputprice;
  }

  public void setInputprice(BigDecimal inputprice) {
    this.inputprice = inputprice;
  }

  public String getTraceCode() {
    return traceCode;
  }

  public void setTraceCode(String traceCode) {
    this.traceCode = traceCode;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public String getScode() {
    return scode;
  }

  public void setScode(String scode) {
    this.scode = scode;
  }

  public String getSname() {
    return sname;
  }

  public void setSname(String sname) {
    this.sname = sname;
  }

  public BigDecimal getTareWeight() {
    return tareWeight;
  }

  public void setTareWeight(BigDecimal tareWeight) {
    this.tareWeight = tareWeight;
  }

  public BigDecimal getInvQty() {
    return invQty;
  }

  public void setInvQty(BigDecimal invQty) {
    this.invQty = invQty;
  }

  public String getInvBatch() {
    return invBatch;
  }

  public void setInvBatch(String invBatch) {
    this.invBatch = invBatch;
  }

  public TradeProductLine replicate(Trade owner) {
    TradeProductLine line = new TradeProductLine();
    line.setWeightType(getWeightType());
    line.setOwner(owner);
    line.setLine(getLine());
    line.setProductUuid(getProductUuid());
    line.setProductCode(getProductCode());
    line.setProductName(getProductName());
    line.setPrice(getPrice());
    line.setAmount(getAmount());
    line.setPackages(getPackages());
    line.setDeposit(getDeposit());
    line.setServiceCharge(getServiceCharge());
    line.setQuantity(getQuantity());
    line.setPackagePrice(getPackagePrice());
    line.setPackQty(getPackQty());
    line.setInputprice(getInputprice());
    line.setTraceCode(getTraceCode());
    line.setScode(getScode());
    line.setSname(getSname());
    line.setTareWeight(getTareWeight());
    line.setLocation(getLocation());
    line.setInvQty(getInvQty());
    line.setInvBatch(getInvBatch());
    return line;
  }
}
