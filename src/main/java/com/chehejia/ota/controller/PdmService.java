package com.chehejia.ota.controller;

import com.chehejia.boot.starter.cache.CacheManager;
import com.chehejia.boot.starter.ois.model.response.OisUploadRes;
import com.chehejia.boot.starter.ois.service.OisClient;
import com.chehejia.ota.cache.SoftwarePartNumberCacheKey;
import com.chehejia.ota.model.DownloadInfo;
import com.chehejia.ota.response.Response;
import com.google.common.collect.Maps;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Objects;

/**
 * @Description
 * @Author quwenzhe
 * @Date 2018/10/8 2:57 PM
 */
@RestController
@RequestMapping(value = "pdm/v1-0/ota")
public class PdmService {

    private static String filePath = "/data/otaupload/file";

    private static final int taskNum = 5;

    private static final Long partSize = 50 * 1024 * 1024L;

    private static final int durationSeconds = 60 * 60;

    @Autowired
    private OisClient oisClient;

    @Autowired
    private CacheManager cacheManager;

    @ApiOperation(value = "上传ECU文件")
    @RequestMapping(value = "/ecu/upload", method = RequestMethod.POST)
    @ResponseBody
    public Response uploadEcuFile(@RequestParam String softwarePartNumber,
                                  @RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return Response.createFailure("file is empty");
        }

        String orgFileName = file.getOriginalFilename();
        if (StringUtils.isEmpty(orgFileName)) {
            return Response.createFailure("filename is empty");
        }

        String suffix = orgFileName.lastIndexOf(".") > 0 ? orgFileName.substring(orgFileName.lastIndexOf(".")) : "";
        if (StringUtils.isEmpty(suffix)) {
            return Response.createFailure("filename suffix is empty");
        }

        String localFilePath = Paths.get(filePath, softwarePartNumber).toString() + suffix;
        File localFile = new File(localFilePath);
        if (!localFile.getParentFile().exists()) {
            localFile.getParentFile().mkdirs();
        }

        try {
            file.transferTo(localFile);
        } catch (IllegalStateException e) {
            return Response.createFailure(e.getMessage());
        } catch (IOException e) {
            return Response.createFailure(e.getMessage());
        }

        String fineName = softwarePartNumber + suffix;
        com.chehejia.framework.beans.model.Response<OisUploadRes> response = oisClient.upload(
                taskNum,
                partSize,
                localFilePath,
                fineName,
                "ecu",
                2,
                false,
                durationSeconds
        );
        if (Boolean.FALSE.equals(response.isSuccess() || Objects.isNull(response.getData()))) {
            return Response.createFailure("上传升级包失败");
        }

        String fileKey = response.getData().getFileKey();

        cacheManager.set(SoftwarePartNumberCacheKey.PREFIX, softwarePartNumber, fileKey, SoftwarePartNumberCacheKey.EXPIRE_SECONDS);

        return Response.createSucceed();
    }

    @ApiOperation(value = "下载ECU文件")
    @RequestMapping(value = "/ecu/download", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "softwarePartNumber", value = "软件零件号", required = true, paramType = "query", dataType = "String")
    })
    public Response downloadEcuFile(String softwarePartNumber) {
        DownloadInfo downloadInfo = new DownloadInfo();
        String fileKey = cacheManager.get(SoftwarePartNumberCacheKey.PREFIX, softwarePartNumber);
        downloadInfo.setFileKey(fileKey);

        return Response.createSucceed(downloadInfo);
    }

}
