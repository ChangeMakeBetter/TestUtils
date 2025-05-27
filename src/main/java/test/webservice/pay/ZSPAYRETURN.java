package test.webservice.pay;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>ZSPAY_RETURN complex type的 Java 类。
 *
 * <p>以下模式片段指定包含在此类中的预期内容。
 *
 * <pre>
 * &lt;complexType name="ZSPAY_RETURN"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="TYPE_PRO" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="1"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="ZZPOINT_ADD" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="15"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="ZZPOINT_RED" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="15"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="ZZCPIDO" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="30"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="ZZCPSTATE" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="3"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="ZZPRINCIPAL" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="20"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="ZZFREE" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="20"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="ZCTCONS" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="20"/&gt;
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
 *         &lt;element name="ZZCOUPXH" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="40"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="ZZCP_NUM" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="20"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="ZZLJJF" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="4"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="TYPE" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="1"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="MESSAGE" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="255"/&gt;
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
@XmlType(name = "ZSPAY_RETURN", propOrder = {
  "typepro",
  "zzpointadd",
  "zzpointred",
  "zzcpido",
  "zzcpstate",
  "zzprincipal",
  "zzfree",
  "zctcons",
  "zcnoin",
  "zzcoupxh",
  "zzcpnum",
  "zzljjf",
  "type",
  "message"
})
public class ZSPAYRETURN {

    @XmlElement(name = "TYPE_PRO")
    protected String typepro;
    @XmlElement(name = "ZZPOINT_ADD")
    protected String zzpointadd;
    @XmlElement(name = "ZZPOINT_RED")
    protected String zzpointred;
    @XmlElement(name = "ZZCPIDO")
    protected String zzcpido;
    @XmlElement(name = "ZZCPSTATE")
    protected String zzcpstate;
    @XmlElement(name = "ZZPRINCIPAL")
    protected String zzprincipal;
    @XmlElement(name = "ZZFREE")
    protected String zzfree;
    @XmlElement(name = "ZCTCONS")
    protected String zctcons;
    @XmlElement(name = "ZCNO_IN")
    protected String zcnoin;
    @XmlElement(name = "ZZCOUPXH")
    protected String zzcoupxh;
    @XmlElement(name = "ZZCP_NUM")
    protected String zzcpnum;
    @XmlElement(name = "ZZLJJF")
    protected String zzljjf;
    @XmlElement(name = "TYPE")
    protected String type;
    @XmlElement(name = "MESSAGE")
    protected String message;

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
     * 获取zzpointadd属性的值。
     *
     * @return possible object is {@link String }
     */
    public String getZZPOINTADD() {
        return zzpointadd;
    }

    /**
     * 设置zzpointadd属性的值。
     *
     * @param value allowed object is {@link String }
     */
    public void setZZPOINTADD(String value) {
        this.zzpointadd = value;
    }

    /**
     * 获取zzpointred属性的值。
     *
     * @return possible object is {@link String }
     */
    public String getZZPOINTRED() {
        return zzpointred;
    }

    /**
     * 设置zzpointred属性的值。
     *
     * @param value allowed object is {@link String }
     */
    public void setZZPOINTRED(String value) {
        this.zzpointred = value;
    }

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
     * 获取zzcpstate属性的值。
     *
     * @return possible object is {@link String }
     */
    public String getZZCPSTATE() {
        return zzcpstate;
    }

    /**
     * 设置zzcpstate属性的值。
     *
     * @param value allowed object is {@link String }
     */
    public void setZZCPSTATE(String value) {
        this.zzcpstate = value;
    }

    /**
     * 获取zzprincipal属性的值。
     *
     * @return possible object is {@link String }
     */
    public String getZZPRINCIPAL() {
        return zzprincipal;
    }

    /**
     * 设置zzprincipal属性的值。
     *
     * @param value allowed object is {@link String }
     */
    public void setZZPRINCIPAL(String value) {
        this.zzprincipal = value;
    }

    /**
     * 获取zzfree属性的值。
     *
     * @return possible object is {@link String }
     */
    public String getZZFREE() {
        return zzfree;
    }

    /**
     * 设置zzfree属性的值。
     *
     * @param value allowed object is {@link String }
     */
    public void setZZFREE(String value) {
        this.zzfree = value;
    }

    /**
     * 获取zctcons属性的值。
     *
     * @return possible object is {@link String }
     */
    public String getZCTCONS() {
        return zctcons;
    }

    /**
     * 设置zctcons属性的值。
     *
     * @param value allowed object is {@link String }
     */
    public void setZCTCONS(String value) {
        this.zctcons = value;
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
     * 获取zzcoupxh属性的值。
     *
     * @return possible object is {@link String }
     */
    public String getZZCOUPXH() {
        return zzcoupxh;
    }

    /**
     * 设置zzcoupxh属性的值。
     *
     * @param value allowed object is {@link String }
     */
    public void setZZCOUPXH(String value) {
        this.zzcoupxh = value;
    }

    /**
     * 获取zzcpnum属性的值。
     *
     * @return possible object is {@link String }
     */
    public String getZZCPNUM() {
        return zzcpnum;
    }

    /**
     * 设置zzcpnum属性的值。
     *
     * @param value allowed object is {@link String }
     */
    public void setZZCPNUM(String value) {
        this.zzcpnum = value;
    }

    /**
     * 获取zzljjf属性的值。
     *
     * @return possible object is {@link String }
     */
    public String getZZLJJF() {
        return zzljjf;
    }

    /**
     * 设置zzljjf属性的值。
     *
     * @param value allowed object is {@link String }
     */
    public void setZZLJJF(String value) {
        this.zzljjf = value;
    }

    /**
     * 获取type属性的值。
     *
     * @return possible object is {@link String }
     */
    public String getTYPE() {
        return type;
    }

    /**
     * 设置type属性的值。
     *
     * @param value allowed object is {@link String }
     */
    public void setTYPE(String value) {
        this.type = value;
    }

    /**
     * 获取message属性的值。
     *
     * @return possible object is {@link String }
     */
    public String getMESSAGE() {
        return message;
    }

    /**
     * 设置message属性的值。
     *
     * @param value allowed object is {@link String }
     */
    public void setMESSAGE(String value) {
        this.message = value;
    }

}
