
package com.chehejia.ota.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OtaEcuRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OtaEcuRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="batchCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="vehSeriesNo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="vehModelNo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="totalVersion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OtaEcuRequest", propOrder = {
    "batchCode",
    "vehSeriesNo",
    "vehModelNo",
    "totalVersion"
})
public class OtaEcuRequest {

    @XmlElement(required = true)
    protected String batchCode;
    @XmlElement(required = true)
    protected String vehSeriesNo;
    @XmlElement(required = true)
    protected String vehModelNo;
    @XmlElement(required = true)
    protected String totalVersion;

    /**
     * Gets the value of the batchCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBatchCode() {
        return batchCode;
    }

    /**
     * Sets the value of the batchCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBatchCode(String value) {
        this.batchCode = value;
    }

    /**
     * Gets the value of the vehSeriesNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVehSeriesNo() {
        return vehSeriesNo;
    }

    /**
     * Sets the value of the vehSeriesNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVehSeriesNo(String value) {
        this.vehSeriesNo = value;
    }

    /**
     * Gets the value of the vehModelNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVehModelNo() {
        return vehModelNo;
    }

    /**
     * Sets the value of the vehModelNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVehModelNo(String value) {
        this.vehModelNo = value;
    }

    /**
     * Gets the value of the totalVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTotalVersion() {
        return totalVersion;
    }

    /**
     * Sets the value of the totalVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTotalVersion(String value) {
        this.totalVersion = value;
    }

}
