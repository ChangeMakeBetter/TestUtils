package json.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * </br>
 * Created by yangxiaohua on 2021/8/10.
 */
public class StoreWarehouseRegBillLine implements Serializable {
  private static final long serialVersionUID = 1L;
  public static final String tableName = "JposStoreWarehouseRegBillLine";
  private String uuid;
  private String inputCode;
  private Integer lineNumber;
  private String productUuid;
  private String productCode;
  private String productBarcode;
  private String productName;
  private String productUnit;
  private String productSpec;
  private BigDecimal productQpc = BigDecimal.ONE;
  private String qpcStr;
  private BigDecimal rtlPrc;
  private BigDecimal qty;
  private BigDecimal amount;
  private String note;
  private String flowNo;
  private String tagNo = "";
  private BigDecimal invQty;

  public StoreWarehouseRegBillLine() {
  }

  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  public String getInputCode() {
    return inputCode;
  }

  public void setInputCode(String inputCode) {
    this.inputCode = inputCode;
  }

  public Integer getLineNumber() {
    return lineNumber;
  }

  public void setLineNumber(Integer lineNumber) {
    this.lineNumber = lineNumber;
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

  public String getProductBarcode() {
    return productBarcode;
  }

  public void setProductBarcode(String productBarcode) {
    this.productBarcode = productBarcode;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public String getProductUnit() {
    return productUnit;
  }

  public void setProductUnit(String productUnit) {
    this.productUnit = productUnit;
  }

  public String getProductSpec() {
    return productSpec;
  }

  public void setProductSpec(String productSpec) {
    this.productSpec = productSpec;
  }

  public BigDecimal getProductQpc() {
    return productQpc;
  }

  public void setProductQpc(BigDecimal productQpc) {
    this.productQpc = productQpc;
  }

  public String getQpcStr() {
    return qpcStr;
  }

  public void setQpcStr(String qpcStr) {
    this.qpcStr = qpcStr;
  }

  public BigDecimal getRtlPrc() {
    return rtlPrc;
  }

  public void setRtlPrc(BigDecimal rtlPrc) {
    this.rtlPrc = rtlPrc;
  }

  public BigDecimal getQty() {
    return qty;
  }

  public void setQty(BigDecimal qty) {
    this.qty = qty;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }

  public String getFlowNo() {
    return flowNo;
  }

  public void setFlowNo(String flowNo) {
    this.flowNo = flowNo;
  }

  public String getTagNo() {
    return tagNo;
  }

  public void setTagNo(String tagNo) {
    this.tagNo = tagNo;
  }

  public BigDecimal getInvQty() {
    return invQty;
  }

  public void setInvQty(BigDecimal invQty) {
    this.invQty = invQty;
  }
}
