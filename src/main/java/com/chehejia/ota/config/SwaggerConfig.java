package com.chehejia.ota.config;

import com.chehejia.ota.controller.StatusCode;
import com.google.common.base.Charsets;
import org.apache.commons.io.IOUtils;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.AlternateTypeRule;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description
 * @Author quwenzhe
 * @Date 2018/10/8 11:26 AM
 */
@EnableSwagger2
@Configuration
public class SwaggerConfig {

    private static final String DESCRIPTION;

    public SwaggerConfig() {
    }

    public ApiInfo apiInfo() {
        String desc = DESCRIPTION == null ? "模拟BOM&PDM的API文档" : DESCRIPTION;
        return (new ApiInfoBuilder())
                .title("模拟BOM&PDM的API文档")
                .description(desc)
                .termsOfServiceUrl("http://www.chehejia.com/")
                .license("Apache License Version 2.0")
                .licenseUrl("http://wiki.it.chehejia.com//pages/viewpage.action?pageId=14058173")
                .version("v1-0")
                .build();
    }

    @Bean
    @ConditionalOnMissingBean
    public Docket init() {
        return (new Docket(DocumentationType.SWAGGER_2))
                .apiInfo(this.apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.chehejia"))
                .paths(PathSelectors.any())
                .build()
                .pathMapping("/")
                .useDefaultResponseMessages(false)
                .globalResponseMessage(RequestMethod.OPTIONS, this.extractStatusCodes())
                .alternateTypeRules(new AlternateTypeRule[0])
                .forCodeGeneration(false);
    }

    public List<ResponseMessage> extractStatusCodes() {
        LinkedList<ResponseMessage> list = new LinkedList();
        StatusCode[] statusCodesArray = StatusCode.values();
        int length = statusCodesArray.length;

        for (int i = 0; i < length; ++i) {
            StatusCode statusCodes = statusCodesArray[i];
            ResponseMessage message = new ResponseMessageBuilder()
                    .code(statusCodes.code())
                    .message(statusCodes.message())
                    .build();
            list.add(message);
        }

        return list;
    }

    static {
        try {
            ClassPathResource resource = new ClassPathResource("SWAGGER.md");
            if (resource.exists()) {
                InputStream inputStream = resource.getInputStream();
                List<String> lines = IOUtils.readLines(inputStream, Charsets.UTF_8);
                DESCRIPTION = lines.stream().collect(Collectors.joining("\n"));
            } else {
                DESCRIPTION = null;
            }

        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
