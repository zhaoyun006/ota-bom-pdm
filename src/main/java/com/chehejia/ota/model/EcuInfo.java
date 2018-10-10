package com.chehejia.ota.model;

/**
 * @Description
 * @Author quwenzhe
 * @Date 2018/10/10 10:56 AM
 */
public class EcuInfo {

    private String hardwarePartNumber;

    private String softwarePartNumber;

    private String ecuName;

    private String supplierId;

    private String ecuVersion;

    private String ecuFileMD5;

    public String getHardwarePartNumber() {
        return hardwarePartNumber;
    }

    public void setHardwarePartNumber(String hardwarePartNumber) {
        this.hardwarePartNumber = hardwarePartNumber;
    }

    public String getSoftwarePartNumber() {
        return softwarePartNumber;
    }

    public void setSoftwarePartNumber(String softwarePartNumber) {
        this.softwarePartNumber = softwarePartNumber;
    }

    public String getEcuName() {
        return ecuName;
    }

    public void setEcuName(String ecuName) {
        this.ecuName = ecuName;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public String getEcuVersion() {
        return ecuVersion;
    }

    public void setEcuVersion(String ecuVersion) {
        this.ecuVersion = ecuVersion;
    }

    public String getEcuFileMD5() {
        return ecuFileMD5;
    }

    public void setEcuFileMD5(String ecuFileMD5) {
        this.ecuFileMD5 = ecuFileMD5;
    }
}
