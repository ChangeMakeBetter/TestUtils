package test.webservice.pay;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>ZSPAY_COUPON_IMPORT complex type的 Java 类。
 *
 * <p>以下模式片段指定包含在此类中的预期内容。
 *
 * <pre>
 * &lt;complexType name="ZSPAY_COUPON_IMPORT"&gt;
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
 *         &lt;element name="ZZDKPRICE" minOccurs="0"&gt;
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
@XmlType(name = "ZSPAY_COUPON_IMPORT", propOrder = {
  "zzcpido",
  "zzdkprice"
})
public class ZSPAYCOUPONIMPORT {

    @XmlElement(name = "ZZCPIDO")
    protected String zzcpido;
    @XmlElement(name = "ZZDKPRICE")
    protected BigDecimal zzdkprice;

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
     * 获取zzdkprice属性的值。
     *
     * @return possible object is {@link BigDecimal }
     */
    public BigDecimal getZZDKPRICE() {
        return zzdkprice;
    }

    /**
     * 设置zzdkprice属性的值。
     *
     * @param value allowed object is {@link BigDecimal }
     */
    public void setZZDKPRICE(BigDecimal value) {
        this.zzdkprice = value;
    }

}
