package test.webservice.pay;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>ZSPAY_IMPORT complex type的 Java 类。
 *
 * <p>以下模式片段指定包含在此类中的预期内容。
 *
 * <pre>
 * &lt;complexType name="ZSPAY_IMPORT"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ZZCHANNEL" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="10"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="PARTNER_ID" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="10"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="ZZTPRICE" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *               &lt;totalDigits value="15"/&gt;
 *               &lt;fractionDigits value="2"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="ZZAUART" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="4"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="ZZVBELN" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="40"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="ZZCPSYDAT" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *               &lt;totalDigits value="15"/&gt;
 *               &lt;fractionDigits value="0"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="ZZCPSTORE" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="20"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="ZZPOINT_ADD" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *               &lt;totalDigits value="10"/&gt;
 *               &lt;fractionDigits value="2"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="ZZPOINT_RED" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *               &lt;totalDigits value="10"/&gt;
 *               &lt;fractionDigits value="2"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="ZZPTIMES" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *               &lt;totalDigits value="4"/&gt;
 *               &lt;fractionDigits value="2"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="ZZZACTCODE" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="30"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="ZCNO_IN" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="20"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="ZZCONSUM_CARD" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *               &lt;totalDigits value="15"/&gt;
 *               &lt;fractionDigits value="2"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="ZZPAY" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="30"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="ZZVBELN_LS" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="40"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="ZZORDER_ID" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="40"/&gt;
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
 *         &lt;element name="ZZCPYL3" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="80"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="ZZCPYL4" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="80"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="ZZCPYL5" minOccurs="0"&gt;
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
@XmlType(name = "ZSPAY_IMPORT", propOrder = {
  "zzchannel",
  "partnerid",
  "zztprice",
  "zzauart",
  "zzvbeln",
  "zzcpsydat",
  "zzcpstore",
  "zzpointadd",
  "zzpointred",
  "zzptimes",
  "zzzactcode",
  "zcnoin",
  "zzconsumcard",
  "zzpay",
  "zzvbelnls",
  "zzorderid",
  "zzcpyl1",
  "zzcpyl2",
  "zzcpyl3",
  "zzcpyl4",
  "zzcpyl5"
})
public class ZSPAYIMPORT {

    @XmlElement(name = "ZZCHANNEL")
    protected String zzchannel;
    @XmlElement(name = "PARTNER_ID")
    protected String partnerid;
    @XmlElement(name = "ZZTPRICE")
    protected BigDecimal zztprice;
    @XmlElement(name = "ZZAUART")
    protected String zzauart;
    @XmlElement(name = "ZZVBELN")
    protected String zzvbeln;
    @XmlElement(name = "ZZCPSYDAT")
    protected BigDecimal zzcpsydat;
    @XmlElement(name = "ZZCPSTORE")
    protected String zzcpstore;
    @XmlElement(name = "ZZPOINT_ADD")
    protected BigDecimal zzpointadd;
    @XmlElement(name = "ZZPOINT_RED")
    protected BigDecimal zzpointred;
    @XmlElement(name = "ZZPTIMES")
    protected BigDecimal zzptimes;
    @XmlElement(name = "ZZZACTCODE")
    protected String zzzactcode;
    @XmlElement(name = "ZCNO_IN")
    protected String zcnoin;
    @XmlElement(name = "ZZCONSUM_CARD")
    protected BigDecimal zzconsumcard;
    @XmlElement(name = "ZZPAY")
    protected String zzpay;
    @XmlElement(name = "ZZVBELN_LS")
    protected String zzvbelnls;
    @XmlElement(name = "ZZORDER_ID")
    protected String zzorderid;
    @XmlElement(name = "ZZCPYL1")
    protected String zzcpyl1;
    @XmlElement(name = "ZZCPYL2")
    protected String zzcpyl2;
    @XmlElement(name = "ZZCPYL3")
    protected String zzcpyl3;
    @XmlElement(name = "ZZCPYL4")
    protected String zzcpyl4;
    @XmlElement(name = "ZZCPYL5")
    protected String zzcpyl5;

    /**
     * 获取zzchannel属性的值。
     *
     * @return possible object is {@link String }
     */
    public String getZZCHANNEL() {
        return zzchannel;
    }

    /**
     * 设置zzchannel属性的值。
     *
     * @param value allowed object is {@link String }
     */
    public void setZZCHANNEL(String value) {
        this.zzchannel = value;
    }

    /**
     * 获取partnerid属性的值。
     *
     * @return possible object is {@link String }
     */
    public String getPARTNERID() {
        return partnerid;
    }

    /**
     * 设置partnerid属性的值。
     *
     * @param value allowed object is {@link String }
     */
    public void setPARTNERID(String value) {
        this.partnerid = value;
    }

    /**
     * 获取zztprice属性的值。
     *
     * @return possible object is {@link BigDecimal }
     */
    public BigDecimal getZZTPRICE() {
        return zztprice;
    }

    /**
     * 设置zztprice属性的值。
     *
     * @param value allowed object is {@link BigDecimal }
     */
    public void setZZTPRICE(BigDecimal value) {
        this.zztprice = value;
    }

    /**
     * 获取zzauart属性的值。
     *
     * @return possible object is {@link String }
     */
    public String getZZAUART() {
        return zzauart;
    }

    /**
     * 设置zzauart属性的值。
     *
     * @param value allowed object is {@link String }
     */
    public void setZZAUART(String value) {
        this.zzauart = value;
    }

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
     * 获取zzcpsydat属性的值。
     *
     * @return possible object is {@link BigDecimal }
     */
    public BigDecimal getZZCPSYDAT() {
        return zzcpsydat;
    }

    /**
     * 设置zzcpsydat属性的值。
     *
     * @param value allowed object is {@link BigDecimal }
     */
    public void setZZCPSYDAT(BigDecimal value) {
        this.zzcpsydat = value;
    }

    /**
     * 获取zzcpstore属性的值。
     *
     * @return possible object is {@link String }
     */
    public String getZZCPSTORE() {
        return zzcpstore;
    }

    /**
     * 设置zzcpstore属性的值。
     *
     * @param value allowed object is {@link String }
     */
    public void setZZCPSTORE(String value) {
        this.zzcpstore = value;
    }

    /**
     * 获取zzpointadd属性的值。
     *
     * @return possible object is {@link BigDecimal }
     */
    public BigDecimal getZZPOINTADD() {
        return zzpointadd;
    }

    /**
     * 设置zzpointadd属性的值。
     *
     * @param value allowed object is {@link BigDecimal }
     */
    public void setZZPOINTADD(BigDecimal value) {
        this.zzpointadd = value;
    }

    /**
     * 获取zzpointred属性的值。
     *
     * @return possible object is {@link BigDecimal }
     */
    public BigDecimal getZZPOINTRED() {
        return zzpointred;
    }

    /**
     * 设置zzpointred属性的值。
     *
     * @param value allowed object is {@link BigDecimal }
     */
    public void setZZPOINTRED(BigDecimal value) {
        this.zzpointred = value;
    }

    /**
     * 获取zzptimes属性的值。
     *
     * @return possible object is {@link BigDecimal }
     */
    public BigDecimal getZZPTIMES() {
        return zzptimes;
    }

    /**
     * 设置zzptimes属性的值。
     *
     * @param value allowed object is {@link BigDecimal }
     */
    public void setZZPTIMES(BigDecimal value) {
        this.zzptimes = value;
    }

    /**
     * 获取zzzactcode属性的值。
     *
     * @return possible object is {@link String }
     */
    public String getZZZACTCODE() {
        return zzzactcode;
    }

    /**
     * 设置zzzactcode属性的值。
     *
     * @param value allowed object is {@link String }
     */
    public void setZZZACTCODE(String value) {
        this.zzzactcode = value;
    }

    /**
     * 获取zcnoin属性的值。
     *
     * @return possible object is {@link String }
     */
    public String getZCNOIN() {
        return zcnoin;
    }

    /**
     * 设置zcnoin属性的值。
     *
     * @param value allowed object is {@link String }
     */
    public void setZCNOIN(String value) {
        this.zcnoin = value;
    }

    /**
     * 获取zzconsumcard属性的值。
     *
     * @return possible object is {@link BigDecimal }
     */
    public BigDecimal getZZCONSUMCARD() {
        return zzconsumcard;
    }

    /**
     * 设置zzconsumcard属性的值。
     *
     * @param value allowed object is {@link BigDecimal }
     */
    public void setZZCONSUMCARD(BigDecimal value) {
        this.zzconsumcard = value;
    }

    /**
     * 获取zzpay属性的值。
     *
     * @return possible object is {@link String }
     */
    public String getZZPAY() {
        return zzpay;
    }

    /**
     * 设置zzpay属性的值。
     *
     * @param value allowed object is {@link String }
     */
    public void setZZPAY(String value) {
        this.zzpay = value;
    }

    /**
     * 获取zzvbelnls属性的值。
     *
     * @return possible object is {@link String }
     */
    public String getZZVBELNLS() {
        return zzvbelnls;
    }

    /**
     * 设置zzvbelnls属性的值。
     *
     * @param value allowed object is {@link String }
     */
    public void setZZVBELNLS(String value) {
        this.zzvbelnls = value;
    }

    /**
     * 获取zzorderid属性的值。
     *
     * @return possible object is {@link String }
     */
    public String getZZORDERID() {
        return zzorderid;
    }

    /**
     * 设置zzorderid属性的值。
     *
     * @param value allowed object is {@link String }
     */
    public void setZZORDERID(String value) {
        this.zzorderid = value;
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

    /**
     * 获取zzcpyl3属性的值。
     *
     * @return possible object is {@link String }
     */
    public String getZZCPYL3() {
        return zzcpyl3;
    }

    /**
     * 设置zzcpyl3属性的值。
     *
     * @param value allowed object is {@link String }
     */
    public void setZZCPYL3(String value) {
        this.zzcpyl3 = value;
    }

    /**
     * 获取zzcpyl4属性的值。
     *
     * @return possible object is {@link String }
     */
    public String getZZCPYL4() {
        return zzcpyl4;
    }

    /**
     * 设置zzcpyl4属性的值。
     *
     * @param value allowed object is {@link String }
     */
    public void setZZCPYL4(String value) {
        this.zzcpyl4 = value;
    }

    /**
     * 获取zzcpyl5属性的值。
     *
     * @return possible object is {@link String }
     */
    public String getZZCPYL5() {
        return zzcpyl5;
    }

    /**
     * 设置zzcpyl5属性的值。
     *
     * @param value allowed object is {@link String }
     */
    public void setZZCPYL5(String value) {
        this.zzcpyl5 = value;
    }

}
