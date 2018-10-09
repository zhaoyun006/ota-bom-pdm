
package com.chehejia.ota.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getEcuInfoResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getEcuInfoResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="response" type="{http://controllers.integration.jiangda.com/}OtaEcuResult" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getEcuInfoResponse", propOrder = {
    "response"
})
public class GetEcuInfoResponse {

    protected OtaEcuResult response;

    /**
     * Gets the value of the response property.
     * 
     * @return
     *     possible object is
     *     {@link OtaEcuResult }
     *     
     */
    public OtaEcuResult getResponse() {
        return response;
    }

    /**
     * Sets the value of the response property.
     * 
     * @param value
     *     allowed object is
     *     {@link OtaEcuResult }
     *     
     */
    public void setResponse(OtaEcuResult value) {
        this.response = value;
    }

}
