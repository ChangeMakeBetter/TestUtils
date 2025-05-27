package test.webservice.pay;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>ZSPAY_COUPON_EXPORT complex type的 Java 类。
 *
 * <p>以下模式片段指定包含在此类中的预期内容。
 *
 * <pre>
 * &lt;complexType name="ZSPAY_COUPON_EXPORT"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ZZCPIDO" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="30"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="ZZPRODUCTS_ID" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="40"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="TYPE_PRO" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="1"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="ZZCPYL1" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="80"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="ZZCPYL2" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="80"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ZSPAY_COUPON_EXPORT", propOrder = {
  "zzcpido",
  "zzproductsid",
  "typepro",
  "zzcpyl1",
  "zzcpyl2"
})
public class ZSPAYCOUPONEXPORT {

    @XmlElement(name = "ZZCPIDO")
    protected String zzcpido;
    @XmlElement(name = "ZZPRODUCTS_ID")
    protected String zzproductsid;
    @XmlElement(name = "TYPE_PRO")
    protected String typepro;
    @XmlElement(name = "ZZCPYL1")
    protected String zzcpyl1;
    @XmlElement(name = "ZZCPYL2")
    protected String zzcpyl2;

    /**
     * 获取zzcpido属性的值。
     *
     * @return possible object is {@link String }
     */
    public String getZZCPIDO() {
        return zzcpido;
    }

    /**
     * 设置zzcpido属性的值。
     *
     * @param value allowed object is {@link String }
     */
    public void setZZCPIDO(String value) {
        this.zzcpido = value;
    }

    /**
     * 获取zzproductsid属性的值。
     *
     * @return possible object is {@link String }
     */
    public String getZZPRODUCTSID() {
        return zzproductsid;
    }

    /**
     * 设置zzproductsid属性的值。
     *
     * @param value allowed object is {@link String }
     */
    public void setZZPRODUCTSID(String value) {
        this.zzproductsid = value;
    }

    /**
     * 获取typepro属性的值。
     *
     * @return possible object is {@link String }
     */
    public String getTYPEPRO() {
        return typepro;
    }

    /**
     * 设置typepro属性的值。
     *
     * @param value allowed object is {@link String }
     */
    public void setTYPEPRO(String value) {
        this.typepro = value;
    }

    /**
     * 获取zzcpyl1属性的值。
     *
     * @return possible object is {@link String }
     */
    public String getZZCPYL1() {
        return zzcpyl1;
    }

    /**
     * 设置zzcpyl1属性的值。
     *
     * @param value allowed object is {@link String }
     */
    public void setZZCPYL1(String value) {
        this.zzcpyl1 = value;
    }

    /**
     * 获取zzcpyl2属性的值。
     *
     * @return possible object is {@link String }
     */
    public String getZZCPYL2() {
        return zzcpyl2;
    }

    /**
     * 设置zzcpyl2属性的值。
     *
     * @param value allowed object is {@link String }
     */
    public void setZZCPYL2(String value) {
        this.zzcpyl2 = value;
    }

}
