package com.chehejia.ota.controller;

import com.alibaba.fastjson.JSONArray;
import com.chehejia.ota.model.EcuData;
import com.chehejia.ota.model.GetEcuInfoResponse;
import com.chehejia.ota.model.OtaEcuRequest;
import com.chehejia.ota.model.OtaEcuResult;
import com.chehejia.ota.util.FileUtils;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.io.File;
import java.nio.file.Paths;
import java.util.List;

/**
 * @Description
 * @Author quwenzhe
 * @Date 2018/10/9 4:34 PM
 */
@Endpoint
public class WebServiceEndPoint {

    private static final String NAMESPACE_URI = "http://controllers.integration.jiangda.com/";

    private static String filePath = "/data/otaupload/file";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
    @ResponsePayload
    public GetEcuInfoResponse getCountry(@RequestPayload OtaEcuRequest request) {
        GetEcuInfoResponse response = new GetEcuInfoResponse();
        OtaEcuResult result = new OtaEcuResult();

        String fileName = request.getVehSeriesNo() + "_" + request.getVehModelNo() + "_" + request.getTotalVersion() + ".json";
        fileName = Paths.get(filePath, fileName).toString();

        File ecuInfoFile = new File(fileName);
        if (!ecuInfoFile.exists()) {
            result.setCode(-1);
            result.setSuccess(false);
            result.setMsg("ecuInfo not exist");
            response.setResponse(result);
            return response;
        }

        String ecuInfoString = FileUtils.ReadFile(fileName);
        List<EcuData> ecuInfoList = JSONArray.parseArray(ecuInfoString, EcuData.class);

        result.setCode(0);
        result.setSuccess(true);
        result.setData(ecuInfoList);
        response.setResponse(result);

        return response;
    }
}
