package json.entity;

import java.math.BigDecimal;

/**
 * @author zhangxinkun
 */
public class YfyOilOrder {
  // int 流水单号 必需
  private int flowNo;
  // char(10) 营业日期 必需 yyyy-MM-dd
  private String saleDate;
  // varchar(8) 站点编号 必需
  private String stationNo;
  // int 营业班次 必需
  private int shiftNo;
  // char(2) 卡类型 0 无卡、 01 司机卡、04 员工卡、05 验泵卡、06 维修卡
  private String cardType;
  // varchar(20) 卡号
  private String cardNo;
  // decimal(15, 3) 卡余额
  private BigDecimal bal;
  // varchar(4) 枪号
  private String gunNo;
  // varchar(4) 油品编码
  private String oilCode;
  // nvarchar(12) 油品简称
  private String oilAbbreviate;
  // char(19) 加油时间
  private String oilTime;
  // decimal(10, 3) 单价
  private BigDecimal price;
  // varchar(2) 上班员工编号
  private String oilSupNo;
  // decimal(15, 3) 数量
  private BigDecimal qty;
  // decimal(15, 3) 金额
  private BigDecimal money;

  public int getFlowNo() {
    return flowNo;
  }

  public void setFlowNo(int flowNo) {
    this.flowNo = flowNo;
  }

  public String getSaleDate() {
    return saleDate;
  }

  public void setSaleDate(String saleDate) {
    this.saleDate = saleDate;
  }

  public String getStationNo() {
    return stationNo;
  }

  public void setStationNo(String stationNo) {
    this.stationNo = stationNo;
  }

  public int getShiftNo() {
    return shiftNo;
  }

  public void setShiftNo(int shiftNo) {
    this.shiftNo = shiftNo;
  }

  public String getCardType() {
    return cardType;
  }

  public void setCardType(String cardType) {
    this.cardType = cardType;
  }

  public String getCardNo() {
    return cardNo;
  }

  public void setCardNo(String cardNo) {
    this.cardNo = cardNo;
  }

  public BigDecimal getBal() {
    return bal;
  }

  public void setBal(BigDecimal bal) {
    this.bal = bal;
  }

  public String getGunNo() {
    return gunNo;
  }

  public void setGunNo(String gunNo) {
    this.gunNo = gunNo;
  }

  public String getOilCode() {
    return oilCode;
  }

  public void setOilCode(String oilCode) {
    this.oilCode = oilCode;
  }

  public String getOilAbbreviate() {
    return oilAbbreviate;
  }

  public void setOilAbbreviate(String oilAbbreviate) {
    this.oilAbbreviate = oilAbbreviate;
  }

  public String getOilTime() {
    return oilTime;
  }

  public void setOilTime(String oilTime) {
    this.oilTime = oilTime;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public String getOilSupNo() {
    return oilSupNo;
  }

  public void setOilSupNo(String oilSupNo) {
    this.oilSupNo = oilSupNo;
  }

  public BigDecimal getQty() {
    return qty;
  }

  public void setQty(BigDecimal qty) {
    this.qty = qty;
  }

  public BigDecimal getMoney() {
    return money;
  }

  public void setMoney(BigDecimal money) {
    this.money = money;
  }

}
