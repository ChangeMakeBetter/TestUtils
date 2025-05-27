
package test.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ZSZTRECHARGE_TXN complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ZSZTRECHARGE_TXN"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ZZTRADE_ID" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="40"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="ZZMEMBER_ID" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="10"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="ZZRCH_TYPE" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="10"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="ZZCHANNEL" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="10"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="ZZPRINCIPAL" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="15"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="ZZFREE" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="15"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="ZZTPRICE" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="15"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="ZZSTORE_ID" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="10"/&gt;
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
 *         &lt;element name="ZZCPYL1" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="20"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="ZZCPYL2" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="40"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="ZZCPYL3" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="40"/&gt;
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
@XmlType(name = "ZSZTRECHARGE_TXN", propOrder = {
    "zztradeid",
    "zzmemberid",
    "zzrchtype",
    "zzchannel",
    "zzprincipal",
    "zzfree",
    "zztprice",
    "zzstoreid",
    "zzpay",
    "zzcpyl1",
    "zzcpyl2",
    "zzcpyl3"
})
public class ZSZTRECHARGETXN {

    @XmlElement(name = "ZZTRADE_ID")
    protected String zztradeid;
    @XmlElement(name = "ZZMEMBER_ID")
    protected String zzmemberid;
    @XmlElement(name = "ZZRCH_TYPE")
    protected String zzrchtype;
    @XmlElement(name = "ZZCHANNEL")
    protected String zzchannel;
    @XmlElement(name = "ZZPRINCIPAL")
    protected String zzprincipal;
    @XmlElement(name = "ZZFREE")
    protected String zzfree;
    @XmlElement(name = "ZZTPRICE")
    protected String zztprice;
    @XmlElement(name = "ZZSTORE_ID")
    protected String zzstoreid;
    @XmlElement(name = "ZZPAY")
    protected String zzpay;
    @XmlElement(name = "ZZCPYL1")
    protected String zzcpyl1;
    @XmlElement(name = "ZZCPYL2")
    protected String zzcpyl2;
    @XmlElement(name = "ZZCPYL3")
    protected String zzcpyl3;

    /**
     * 获取zztradeid属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZZTRADEID() {
        return zztradeid;
    }

    /**
     * 设置zztradeid属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZZTRADEID(String value) {
        this.zztradeid = value;
    }

    /**
     * 获取zzmemberid属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZZMEMBERID() {
        return zzmemberid;
    }

    /**
     * 设置zzmemberid属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZZMEMBERID(String value) {
        this.zzmemberid = value;
    }

    /**
     * 获取zzrchtype属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZZRCHTYPE() {
        return zzrchtype;
    }

    /**
     * 设置zzrchtype属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZZRCHTYPE(String value) {
        this.zzrchtype = value;
    }

    /**
     * 获取zzchannel属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZZCHANNEL() {
        return zzchannel;
    }

    /**
     * 设置zzchannel属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZZCHANNEL(String value) {
        this.zzchannel = value;
    }

    /**
     * 获取zzprincipal属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZZPRINCIPAL() {
        return zzprincipal;
    }

    /**
     * 设置zzprincipal属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZZPRINCIPAL(String value) {
        this.zzprincipal = value;
    }

    /**
     * 获取zzfree属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZZFREE() {
        return zzfree;
    }

    /**
     * 设置zzfree属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZZFREE(String value) {
        this.zzfree = value;
    }

    /**
     * 获取zztprice属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZZTPRICE() {
        return zztprice;
    }

    /**
     * 设置zztprice属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZZTPRICE(String value) {
        this.zztprice = value;
    }

    /**
     * 获取zzstoreid属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZZSTOREID() {
        return zzstoreid;
    }

    /**
     * 设置zzstoreid属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZZSTOREID(String value) {
        this.zzstoreid = value;
    }

    /**
     * 获取zzpay属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZZPAY() {
        return zzpay;
    }

    /**
     * 设置zzpay属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZZPAY(String value) {
        this.zzpay = value;
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

    /**
     * 获取zzcpyl3属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZZCPYL3() {
        return zzcpyl3;
    }

    /**
     * 设置zzcpyl3属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZZCPYL3(String value) {
        this.zzcpyl3 = value;
    }

}
