package test.webservice.pay;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>ZSPAY_VBELN_IMPORT complex type的 Java 类。
 *
 * <p>以下模式片段指定包含在此类中的预期内容。
 *
 * <pre>
 * &lt;complexType name="ZSPAY_VBELN_IMPORT"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ZZVBELN" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="40"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="PRODUCT_ID" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="40"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="ZZPRICE_ITEM" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *               &lt;totalDigits value="15"/&gt;
 *               &lt;fractionDigits value="2"/&gt;
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
@XmlType(name = "ZSPAY_VBELN_IMPORT", propOrder = {
  "zzvbeln",
  "productid",
  "zzpriceitem"
})
public class ZSPAYVBELNIMPORT {

    @XmlElement(name = "ZZVBELN")
    protected String zzvbeln;
    @XmlElement(name = "PRODUCT_ID")
    protected String productid;
    @XmlElement(name = "ZZPRICE_ITEM")
    protected BigDecimal zzpriceitem;

    /**
     * 获取zzvbeln属性的值。
     *
     * @return possible object is {@link String }
     */
    public String getZZVBELN() {
        return zzvbeln;
    }

    /**
     * 设置zzvbeln属性的值。
     *
     * @param value allowed object is {@link String }
     */
    public void setZZVBELN(String value) {
        this.zzvbeln = value;
    }

    /**
     * 获取productid属性的值。
     *
     * @return possible object is {@link String }
     */
    public String getPRODUCTID() {
        return productid;
    }

    /**
     * 设置productid属性的值。
     *
     * @param value allowed object is {@link String }
     */
    public void setPRODUCTID(String value) {
        this.productid = value;
    }

    /**
     * 获取zzpriceitem属性的值。
     *
     * @return possible object is {@link BigDecimal }
     */
    public BigDecimal getZZPRICEITEM() {
        return zzpriceitem;
    }

    /**
     * 设置zzpriceitem属性的值。
     *
     * @param value allowed object is {@link BigDecimal }
     */
    public void setZZPRICEITEM(BigDecimal value) {
        this.zzpriceitem = value;
    }

}
