package com.chehejia.ota.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;

/**
 * @Description
 * @Author quwenzhe
 * @Date 2018/10/8 2:57 PM
 */
@RestController
@RequestMapping(value = "pdm/v1-0/ota")
public class PdmService {

    @ApiOperation(value = "获取ECU文件")
    @RequestMapping(value = "/ecu/file", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "softwarePartNumber", value = "软件零件号", required = true, paramType = "query", dataType = "String")
    })
    public Response<Object> getEcuFile(@RequestParam String softwarePartNumber) {
        return null;
    }
}
