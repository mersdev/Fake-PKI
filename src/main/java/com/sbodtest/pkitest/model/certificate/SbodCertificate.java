package com.sbodtest.pkitest.model.certificate;

public class SbodCertificate {
    private String certificate;
    private Long serialNumber;

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public Long getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Long serialNumber) {
        this.serialNumber = serialNumber;
    }
}
