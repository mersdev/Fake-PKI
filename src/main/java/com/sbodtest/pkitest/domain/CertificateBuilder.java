package com.sbodtest.pkitest.domain;

import java.util.Date;

public class CertificateBuilder {
    private String certificateName;
    private Date createdDate;
    private Date lastUpdatedDate;
    private Date expiredDate;
    private String status;
    private String encodedCertificate;
    private String requester;
    private Long serialNumber;

    public CertificateBuilder setCertificateName(String certificateName) {
        this.certificateName = certificateName;
        return this;
    }

    public CertificateBuilder setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public CertificateBuilder setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
        return this;
    }

    public CertificateBuilder setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
        return this;
    }

    public CertificateBuilder setStatus(String status) {
        this.status = status;
        return this;
    }

    public CertificateBuilder setEncodedCertificate(String encodedCertificate) {
        this.encodedCertificate = encodedCertificate;
        return this;
    }

    public CertificateBuilder setRequester(String requester) {
        this.requester = requester;
        return this;
    }

    public CertificateBuilder setSerialNumber(Long serialNumber) {
        this.serialNumber = serialNumber;
        return this;
    }

    public Certificate createCertificate() {
        return new Certificate(certificateName, createdDate, lastUpdatedDate, expiredDate, status, encodedCertificate, requester, serialNumber);
    }
}