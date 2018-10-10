package com.chehejia.ota.controller;

import com.chehejia.ota.response.Response;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

/**
 * @Description
 * @Author quwenzhe
 * @Date 2018/10/8 2:57 PM
 */
@RestController
@RequestMapping(value = "pdm/v1-0/ota")
public class PdmService {

    private static String filePath = "/data/otaupload/file";

    private static final String zipPackageSuffix = ".zip";

    private static final String datPackageSuffix = ".dat";

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

        String fileName = Paths.get(filePath, softwarePartNumber).toString() + suffix;

        File destFile = new File(fileName);

        if (!destFile.getParentFile().exists()) {
            destFile.getParentFile().mkdirs();
        }

        try {
            file.transferTo(destFile);
        } catch (IllegalStateException e) {
            return Response.createFailure(e.getMessage());
        } catch (IOException e) {
            return Response.createFailure(e.getMessage());
        }

        return Response.createSucceed();
    }

    @ApiOperation(value = "下载ECU文件")
    @RequestMapping(value = "/ecu/download", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "softwarePartNumber", value = "软件零件号", required = true, paramType = "query", dataType = "String")
    })
    public ResponseEntity<InputStreamResource> downloadEcuFile(String softwarePartNumber) throws IOException {

        String fileName = Paths.get(filePath, softwarePartNumber).toString() + zipPackageSuffix;

        if (!new File(fileName).exists()) {
            fileName = Paths.get(filePath, softwarePartNumber).toString() + datPackageSuffix;
            if (!new File(fileName).exists()) {
                return ResponseEntity.ok(null);
            }
        }

        FileSystemResource file = new FileSystemResource(fileName);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getFilename()));
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");

        return ResponseEntity.ok()
                .headers(headers).contentLength(file.contentLength())
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(new InputStreamResource(file.getInputStream()));
    }

}
