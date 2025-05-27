package test.webservice.pay;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>anonymous complex type的 Java 类。
 *
 * <p>以下模式片段指定包含在此类中的预期内容。
 *
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="T_COUPON" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="item" type="{urn:sap-com:document:sap:rfc:functions}ZSPAY_COUPON_IMPORT" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="T_COUPON_E" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="item" type="{urn:sap-com:document:sap:rfc:functions}ZSPAY_COUPON_EXPORT" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="T_RETURN" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="item" type="{urn:sap-com:document:sap:rfc:functions}ZSPAY_RETURN" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="T_VBELN" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="item" type="{urn:sap-com:document:sap:rfc:functions}ZSPAY_VBELN_IMPORT" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {

})
@XmlRootElement(name = "ZRFC_COMMON_PAY.Response")
public class ZRFCCOMMONPAYResponse {

    @XmlElement(name = "T_COUPON")
    protected TCOUPON tcoupon;
    @XmlElement(name = "T_COUPON_E")
    protected TCOUPONE tcoupone;
    @XmlElement(name = "T_RETURN")
    protected TRETURN treturn;
    @XmlElement(name = "T_VBELN")
    protected TVBELN tvbeln;

    /**
     * 获取tcoupon属性的值。
     *
     * @return possible object is {@link TCOUPON }
     */
    public TCOUPON getTCOUPON() {
        return tcoupon;
    }

    /**
     * 设置tcoupon属性的值。
     *
     * @param value allowed object is {@link TCOUPON }
     */
    public void setTCOUPON(TCOUPON value) {
        this.tcoupon = value;
    }

    /**
     * 获取tcoupone属性的值。
     *
     * @return possible object is {@link TCOUPONE }
     */
    public TCOUPONE getTCOUPONE() {
        return tcoupone;
    }

    /**
     * 设置tcoupone属性的值。
     *
     * @param value allowed object is {@link TCOUPONE }
     */
    public void setTCOUPONE(TCOUPONE value) {
        this.tcoupone = value;
    }

    /**
     * 获取treturn属性的值。
     *
     * @return possible object is {@link TRETURN }
     */
    public TRETURN getTRETURN() {
        return treturn;
    }

    /**
     * 设置treturn属性的值。
     *
     * @param value allowed object is {@link TRETURN }
     */
    public void setTRETURN(TRETURN value) {
        this.treturn = value;
    }

    /**
     * 获取tvbeln属性的值。
     *
     * @return possible object is {@link TVBELN }
     */
    public TVBELN getTVBELN() {
        return tvbeln;
    }

    /**
     * 设置tvbeln属性的值。
     *
     * @param value allowed object is {@link TVBELN }
     */
    public void setTVBELN(TVBELN value) {
        this.tvbeln = value;
    }

    /**
     * <p>anonymous complex type的 Java 类。
     *
     * <p>以下模式片段指定包含在此类中的预期内容。
     *
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="item" type="{urn:sap-com:document:sap:rfc:functions}ZSPAY_COUPON_IMPORT" maxOccurs="unbounded" minOccurs="0"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
      "item"
    })
    public static class TCOUPON {

        protected List<ZSPAYCOUPONIMPORT> item;

        /**
         * Gets the value of the item property.
         *
         * <p>
         * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to
         * the returned list will be present inside the JAXB object. This is why there is not a <CODE>set</CODE> method for
         * the item property.
         *
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getItem().add(newItem);
         * </pre>
         *
         *
         * <p>
         * Objects of the following type(s) are allowed in the list {@link ZSPAYCOUPONIMPORT }
         */
        public List<ZSPAYCOUPONIMPORT> getItem() {
            if (item == null) {
                item = new ArrayList<ZSPAYCOUPONIMPORT>();
            }
            return this.item;
        }

    }

    /**
     * <p>anonymous complex type的 Java 类。
     *
     * <p>以下模式片段指定包含在此类中的预期内容。
     *
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="item" type="{urn:sap-com:document:sap:rfc:functions}ZSPAY_COUPON_EXPORT" maxOccurs="unbounded" minOccurs="0"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
      "item"
    })
    public static class TCOUPONE {

        protected List<ZSPAYCOUPONEXPORT> item;

        /**
         * Gets the value of the item property.
         *
         * <p>
         * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to
         * the returned list will be present inside the JAXB object. This is why there is not a <CODE>set</CODE> method for
         * the item property.
         *
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getItem().add(newItem);
         * </pre>
         *
         *
         * <p>
         * Objects of the following type(s) are allowed in the list {@link ZSPAYCOUPONEXPORT }
         */
        public List<ZSPAYCOUPONEXPORT> getItem() {
            if (item == null) {
                item = new ArrayList<ZSPAYCOUPONEXPORT>();
            }
            return this.item;
        }

    }

    /**
     * <p>anonymous complex type的 Java 类。
     *
     * <p>以下模式片段指定包含在此类中的预期内容。
     *
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="item" type="{urn:sap-com:document:sap:rfc:functions}ZSPAY_RETURN" maxOccurs="unbounded" minOccurs="0"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
      "item"
    })
    public static class TRETURN {

        protected List<ZSPAYRETURN> item;

        /**
         * Gets the value of the item property.
         *
         * <p>
         * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to
         * the returned list will be present inside the JAXB object. This is why there is not a <CODE>set</CODE> method for
         * the item property.
         *
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getItem().add(newItem);
         * </pre>
         *
         *
         * <p>
         * Objects of the following type(s) are allowed in the list {@link ZSPAYRETURN }
         */
        public List<ZSPAYRETURN> getItem() {
            if (item == null) {
                item = new ArrayList<ZSPAYRETURN>();
            }
            return this.item;
        }

    }

    /**
     * <p>anonymous complex type的 Java 类。
     *
     * <p>以下模式片段指定包含在此类中的预期内容。
     *
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="item" type="{urn:sap-com:document:sap:rfc:functions}ZSPAY_VBELN_IMPORT" maxOccurs="unbounded" minOccurs="0"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
      "item"
    })
    public static class TVBELN {

        protected List<ZSPAYVBELNIMPORT> item;

        /**
         * Gets the value of the item property.
         *
         * <p>
         * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to
         * the returned list will be present inside the JAXB object. This is why there is not a <CODE>set</CODE> method for
         * the item property.
         *
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getItem().add(newItem);
         * </pre>
         *
         *
         * <p>
         * Objects of the following type(s) are allowed in the list {@link ZSPAYVBELNIMPORT }
         */
        public List<ZSPAYVBELNIMPORT> getItem() {
            if (item == null) {
                item = new ArrayList<ZSPAYVBELNIMPORT>();
            }
            return this.item;
        }

    }

}
