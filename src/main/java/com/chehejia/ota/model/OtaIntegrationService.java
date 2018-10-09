
package com.chehejia.ota.model;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.10
 * Generated source version: 2.2
 * 
 */
@WebService(name = "OtaIntegrationService", targetNamespace = "http://controllers.integration.jiangda.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface OtaIntegrationService {


    /**
     * 
     * @param request
     * @return
     *     returns com.jiangda.integration.controllers.OtaEcuResult
     */
    @WebMethod
    @WebResult(name = "response", targetNamespace = "")
    @RequestWrapper(localName = "getEcuInfo", targetNamespace = "http://controllers.integration.jiangda.com/", className = "com.jiangda.integration.controllers.GetEcuInfo")
    @ResponseWrapper(localName = "getEcuInfoResponse", targetNamespace = "http://controllers.integration.jiangda.com/", className = "com.jiangda.integration.controllers.GetEcuInfoResponse")
    public OtaEcuResult getEcuInfo(
            @WebParam(name = "request", targetNamespace = "")
                    OtaEcuRequest request);

}