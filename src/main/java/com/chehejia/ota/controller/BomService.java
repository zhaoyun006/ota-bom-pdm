package com.chehejia.ota.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.chehejia.ota.model.EcuData;
import com.chehejia.ota.response.Response;
import com.chehejia.ota.util.FileUtils;
import com.google.common.collect.Lists;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.file.Paths;
import java.util.List;

/**
 * @Description
 * @Author quwenzhe
 * @Date 2018/10/8 2:57 PM
 */
@RestController
@RequestMapping(value = "bom/v1-0/ota")
public class BomService {

    private static String filePath = "/data/otaupload/file";
    private static String otaServiceUrl = "http://192.168.46.123:20142/ota/package/total/version";

    @ApiOperation(value = "创建大升级包版本")
    @RequestMapping(value = "/total/version", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "vehSeriesNo", value = "车系", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "vehModelNo", value = "车型", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "totalVersion", value = "大包版本号", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "hardwarePartNumbers", value = "硬件零件号", required = true, allowMultiple = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "softwarePartNumbers", value = "软件零件号", required = true, allowMultiple = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "ecuNames", value = "ecu名称", required = true, allowMultiple = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "supplierIds", value = "供应商Id", required = true, allowMultiple = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "ecuVersions", value = "ecu版本号", required = true, allowMultiple = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "ecuFileMD5s", value = "ecu文件md5值", required = true, allowMultiple = true, paramType = "query", dataType = "String")
    })
    public Response<String> createTotalVersion(@RequestParam String vehSeriesNo,
                                               @RequestParam String vehModelNo,
                                               @RequestParam String totalVersion,
                                               @RequestParam String[] hardwarePartNumbers,
                                               @RequestParam String[] softwarePartNumbers,
                                               @RequestParam String[] ecuNames,
                                               @RequestParam String[] supplierIds,
                                               @RequestParam String[] ecuVersions,
                                               @RequestParam String[] ecuFileMD5s) {

        String fileName = vehSeriesNo + "_" + vehModelNo + "_" + totalVersion + ".json";
        fileName = Paths.get(filePath, fileName).toString();

        File ecuInfoFile = new File(fileName);
        ecuInfoFile.deleteOnExit();

        try {
            new File(filePath).mkdir();
            ecuInfoFile.createNewFile();
        } catch (IOException e) {
            return Response.createFailure("create json file error");
        }

        List<EcuData> ecuInfoList = Lists.newArrayList();
        for (int index = 0; index < hardwarePartNumbers.length; index++) {
            EcuData ecuInfo = new EcuData();
            ecuInfo.setHardwarePartNumber(hardwarePartNumbers[index]);
            ecuInfo.setSoftwarePartNumber(softwarePartNumbers[index]);
            ecuInfo.setEcuName(ecuNames[index]);
            ecuInfo.setSupplierId(supplierIds[index]);
            ecuInfo.setEcuVersion(ecuVersions[index]);
            ecuInfo.setEcuFileMD5(ecuFileMD5s[index]);

            ecuInfoList.add(ecuInfo);
        }

        String ecuInfoString = JSON.toJSONString(ecuInfoList);
        FileUtils.writeInfoToFile(fileName, ecuInfoString);

        try {
            RestTemplate restTemplate = new RestTemplate();
            String bodyValTemplate = "batchCode=" + URLEncoder.encode("2018092710abc123", "utf-8")
                    + "&vehSeriesNo=" + URLEncoder.encode("M01", "utf-8")
                    + "&vehModelNo=" + URLEncoder.encode("M01", "utf-8")
                    + "&totalVersion=" + URLEncoder.encode("1.0.0", "utf-8")
                    + "&canMatrixVersion=" + URLEncoder.encode("1.0.0", "utf-8");
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
            HttpEntity entity = new HttpEntity(bodyValTemplate, headers);
            ResponseEntity<String> responseEntity = restTemplate.exchange(otaServiceUrl, HttpMethod.POST, entity, String.class);
        } catch (UnsupportedEncodingException e) {
            return Response.createFailure("sync ecuInfo to OTA error");
        }

        return Response.createSucceed();
    }

    @ApiOperation(value = "获取ecu信息")
    @RequestMapping(value = "/ecu/info", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "vehSeriesNo", value = "车系", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "vehModelNo", value = "车型", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "totalVersion", value = "大包版本号", required = true, paramType = "query", dataType = "String")
    })
    public Response<Object> getEcuInfo(@RequestParam String vehSeriesNo,
                                       @RequestParam String vehModelNo,
                                       @RequestParam String totalVersion) {

        String fileName = vehSeriesNo + "_" + vehModelNo + "_" + totalVersion + ".json";
        fileName = Paths.get(filePath, fileName).toString();

        File ecuInfoFile = new File(fileName);
        if (!ecuInfoFile.exists()) {
            return Response.createFailure("ecuInfo not exist");
        }

        String ecuInfoString = FileUtils.ReadFile(fileName);
        List<EcuData> ecuInfoList = JSONArray.parseArray(ecuInfoString, EcuData.class);

        return Response.createSucceed(ecuInfoList);
    }


}
