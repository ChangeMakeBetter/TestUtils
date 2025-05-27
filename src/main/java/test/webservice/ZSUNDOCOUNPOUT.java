package test.webservice;

import java.math.BigDecimal;
import java.math.BigInteger;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>ZSUNDO_COUNP_OUT complex type的 Java 类。
 *
 * <p>以下模式片段指定包含在此类中的预期内容。
 *
 * <pre>
 * &lt;complexType name="ZSUNDO_COUNP_OUT"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ZZCOUPXH" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="40"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="ZZCOUPMC" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="60"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="ZZCPVALUE" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *               &lt;totalDigits value="11"/&gt;
 *               &lt;fractionDigits value="2"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="ZZCPANUM" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/&gt;
 *         &lt;element name="ZZCPYL1" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="100"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="ZZCPYL2" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="100"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ZSUNDO_COUNP_OUT", propOrder = {
  "zzcoupxh",
  "zzcoupmc",
  "zzcpvalue",
  "zzcpanum",
  "zzcpyl1",
  "zzcpyl2"
})
public class ZSUNDOCOUNPOUT {

  @XmlElement(name = "ZZCOUPXH")
  protected String zzcoupxh;
  @XmlElement(name = "ZZCOUPMC")
  protected String zzcoupmc;
  @XmlElement(name = "ZZCPVALUE")
  protected BigDecimal zzcpvalue;
  @XmlElement(name = "ZZCPANUM")
  protected BigInteger zzcpanum;
  @XmlElement(name = "ZZCPYL1")
  protected String zzcpyl1;
  @XmlElement(name = "ZZCPYL2")
  protected String zzcpyl2;

  /**
   * 获取zzcoupxh属性的值。
   *
   * @return
   *     possible object is
   *     {@link String }
   *
   */
  public String getZZCOUPXH() {
    return zzcoupxh;
  }

  /**
   * 设置zzcoupxh属性的值。
   *
   * @param value
   *     allowed object is
   *     {@link String }
   *
   */
  public void setZZCOUPXH(String value) {
    this.zzcoupxh = value;
  }

  /**
   * 获取zzcoupmc属性的值。
   *
   * @return
   *     possible object is
   *     {@link String }
   *
   */
  public String getZZCOUPMC() {
    return zzcoupmc;
  }

  /**
   * 设置zzcoupmc属性的值。
   *
   * @param value
   *     allowed object is
   *     {@link String }
   *
   */
  public void setZZCOUPMC(String value) {
    this.zzcoupmc = value;
  }

  /**
   * 获取zzcpvalue属性的值。
   *
   * @return
   *     possible object is
   *     {@link BigDecimal }
   *
   */
  public BigDecimal getZZCPVALUE() {
    return zzcpvalue;
  }

  /**
   * 设置zzcpvalue属性的值。
   *
   * @param value
   *     allowed object is
   *     {@link BigDecimal }
   *
   */
  public void setZZCPVALUE(BigDecimal value) {
    this.zzcpvalue = value;
  }

  /**
   * 获取zzcpanum属性的值。
   *
   * @return
   *     possible object is
   *     {@link BigInteger }
   *
   */
  public BigInteger getZZCPANUM() {
    return zzcpanum;
  }

  /**
   * 设置zzcpanum属性的值。
   *
   * @param value
   *     allowed object is
   *     {@link BigInteger }
   *
   */
  public void setZZCPANUM(BigInteger value) {
    this.zzcpanum = value;
  }

  /**
   * 获取zzcpyl1属性的值。
   *
   * @return
   *     possible object is
   *     {@link String }
   *
   */
  public String getZZCPYL1() {
    return zzcpyl1;
  }

  /**
   * 设置zzcpyl1属性的值。
   *
   * @param value
   *     allowed object is
   *     {@link String }
   *
   */
  public void setZZCPYL1(String value) {
    this.zzcpyl1 = value;
  }

  /**
   * 获取zzcpyl2属性的值。
   *
   * @return
   *     possible object is
   *     {@link String }
   *
   */
  public String getZZCPYL2() {
    return zzcpyl2;
  }

  /**
   * 设置zzcpyl2属性的值。
   *
   * @param value
   *     allowed object is
   *     {@link String }
   *
   */
  public void setZZCPYL2(String value) {
    this.zzcpyl2 = value;
  }

}
