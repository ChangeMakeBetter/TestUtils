package test.webservice;

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
 *         &lt;element name="I_ZSZTRECHARGE_TXN" type="{urn:sap-com:document:sap:rfc:functions}ZSZTRECHARGE_TXN"/&gt;
 *         &lt;element name="ET_COUNP_OUT" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="item" type="{urn:sap-com:document:sap:rfc:functions}ZSUNDO_COUNP_OUT" maxOccurs="unbounded" minOccurs="0"/&gt;
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
 *                   &lt;element name="item" type="{urn:sap-com:document:sap:rfc:functions}ZSRETRUN" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlRootElement(name = "ZRFC_TXN_RECHARGE_UNDO")
public class ZRFCTXNRECHARGEUNDO {

    @XmlElement(name = "I_ZSZTRECHARGE_TXN", required = true)
    protected ZSZTRECHARGETXN izsztrechargetxn;
    @XmlElement(name = "ET_COUNP_OUT")
    protected ETCOUNPOUT etcounpout;
    @XmlElement(name = "T_RETURN")
    protected TRETURN treturn;

    /**
     * 获取izsztrechargetxn属性的值。
     *
     * @return possible object is {@link ZSZTRECHARGETXN }
     */
    public ZSZTRECHARGETXN getIZSZTRECHARGETXN() {
        return izsztrechargetxn;
    }

    /**
     * 设置izsztrechargetxn属性的值。
     *
     * @param value allowed object is {@link ZSZTRECHARGETXN }
     */
    public void setIZSZTRECHARGETXN(ZSZTRECHARGETXN value) {
        this.izsztrechargetxn = value;
    }

    /**
     * 获取etcounpout属性的值。
     *
     * @return possible object is {@link ETCOUNPOUT }
     */
    public ETCOUNPOUT getETCOUNPOUT() {
        return etcounpout;
    }

    /**
     * 设置etcounpout属性的值。
     *
     * @param value allowed object is {@link ETCOUNPOUT }
     */
    public void setETCOUNPOUT(ETCOUNPOUT value) {
        this.etcounpout = value;
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
     * <p>anonymous complex type的 Java 类。
     *
     * <p>以下模式片段指定包含在此类中的预期内容。
     *
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="item" type="{urn:sap-com:document:sap:rfc:functions}ZSUNDO_COUNP_OUT" maxOccurs="unbounded" minOccurs="0"/&gt;
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
    public static class ETCOUNPOUT {

        protected List<ZSUNDOCOUNPOUT> item;

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
         * Objects of the following type(s) are allowed in the list {@link ZSUNDOCOUNPOUT }
         */
        public List<ZSUNDOCOUNPOUT> getItem() {
            if (item == null) {
                item = new ArrayList<ZSUNDOCOUNPOUT>();
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
     *         &lt;element name="item" type="{urn:sap-com:document:sap:rfc:functions}ZSRETRUN" maxOccurs="unbounded" minOccurs="0"/&gt;
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

        protected List<ZSRETRUN> item;

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
         * Objects of the following type(s) are allowed in the list {@link ZSRETRUN }
         */
        public List<ZSRETRUN> getItem() {
            if (item == null) {
                item = new ArrayList<ZSRETRUN>();
            }
            return this.item;
        }

    }

}
