
package com.chehejia.ota.model;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.jiangda.integration.controllers package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetEcuInfo_QNAME = new QName("http://controllers.integration.jiangda.com/", "getEcuInfo");
    private final static QName _GetEcuInfoResponse_QNAME = new QName("http://controllers.integration.jiangda.com/", "getEcuInfoResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.jiangda.integration.controllers
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetEcuInfoResponse }
     * 
     */
    public GetEcuInfoResponse createGetEcuInfoResponse() {
        return new GetEcuInfoResponse();
    }

    /**
     * Create an instance of {@link GetEcuInfo }
     * 
     */
    public GetEcuInfo createGetEcuInfo() {
        return new GetEcuInfo();
    }

    /**
     * Create an instance of {@link OtaEcuResult }
     * 
     */
    public OtaEcuResult createOtaEcuResult() {
        return new OtaEcuResult();
    }

    /**
     * Create an instance of {@link OtaEcuRequest }
     * 
     */
    public OtaEcuRequest createOtaEcuRequest() {
        return new OtaEcuRequest();
    }

    /**
     * Create an instance of {@link EcuData }
     * 
     */
    public EcuData createEcuData() {
        return new EcuData();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEcuInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://controllers.integration.jiangda.com/", name = "getEcuInfo")
    public JAXBElement<GetEcuInfo> createGetEcuInfo(GetEcuInfo value) {
        return new JAXBElement<GetEcuInfo>(_GetEcuInfo_QNAME, GetEcuInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEcuInfoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://controllers.integration.jiangda.com/", name = "getEcuInfoResponse")
    public JAXBElement<GetEcuInfoResponse> createGetEcuInfoResponse(GetEcuInfoResponse value) {
        return new JAXBElement<GetEcuInfoResponse>(_GetEcuInfoResponse_QNAME, GetEcuInfoResponse.class, null, value);
    }

}
