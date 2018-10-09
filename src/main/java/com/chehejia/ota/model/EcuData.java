
package com.chehejia.ota.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EcuData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EcuData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="hardwarePartNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="softwarePartNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ecuName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="supplierId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ecuVersion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ecuFileMD5" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EcuData", propOrder = {
    "hardwarePartNumber",
    "softwarePartNumber",
    "ecuName",
    "supplierId",
    "ecuVersion",
    "ecuFileMD5"
})
public class EcuData {

    @XmlElement(required = true)
    protected String hardwarePartNumber;
    @XmlElement(required = true)
    protected String softwarePartNumber;
    @XmlElement(required = true)
    protected String ecuName;
    @XmlElement(required = true)
    protected String supplierId;
    @XmlElement(required = true)
    protected String ecuVersion;
    @XmlElement(required = true)
    protected String ecuFileMD5;

    /**
     * Gets the value of the hardwarePartNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHardwarePartNumber() {
        return hardwarePartNumber;
    }

    /**
     * Sets the value of the hardwarePartNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHardwarePartNumber(String value) {
        this.hardwarePartNumber = value;
    }

    /**
     * Gets the value of the softwarePartNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSoftwarePartNumber() {
        return softwarePartNumber;
    }

    /**
     * Sets the value of the softwarePartNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSoftwarePartNumber(String value) {
        this.softwarePartNumber = value;
    }

    /**
     * Gets the value of the ecuName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEcuName() {
        return ecuName;
    }

    /**
     * Sets the value of the ecuName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEcuName(String value) {
        this.ecuName = value;
    }

    /**
     * Gets the value of the supplierId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSupplierId() {
        return supplierId;
    }

    /**
     * Sets the value of the supplierId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSupplierId(String value) {
        this.supplierId = value;
    }

    /**
     * Gets the value of the ecuVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEcuVersion() {
        return ecuVersion;
    }

    /**
     * Sets the value of the ecuVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEcuVersion(String value) {
        this.ecuVersion = value;
    }

    /**
     * Gets the value of the ecuFileMD5 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEcuFileMD5() {
        return ecuFileMD5;
    }

    /**
     * Sets the value of the ecuFileMD5 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEcuFileMD5(String value) {
        this.ecuFileMD5 = value;
    }

}
