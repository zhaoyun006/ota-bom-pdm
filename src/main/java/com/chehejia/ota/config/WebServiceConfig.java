package com.chehejia.ota.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

/**
 * @Description
 * @Author quwenzhe
 * @Date 2018/10/9 4:37 PM
 */
//@EnableWs
//@Configuration
//public class WebServiceConfig extends WsConfigurerAdapter {
//
//    @Bean
//    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
//        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
//        servlet.setApplicationContext(applicationContext);
//        servlet.setTransformWsdlLocations(true);
//        return new ServletRegistrationBean(servlet, "/ws/*");
//    }
//
//    @Bean(name = "otaInteService")
//    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema ecuInfoSchema) {
//        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
//        wsdl11Definition.setPortTypeName("OtaIntegrationService");
//        wsdl11Definition.setSchema(ecuInfoSchema);
//        return wsdl11Definition;
//    }
//
//    @Bean
//    public XsdSchema ecuInfoSchema() {
//        return new SimpleXsdSchema(new ClassPathResource("otaInteService.wsdl"));
//    }
//}
