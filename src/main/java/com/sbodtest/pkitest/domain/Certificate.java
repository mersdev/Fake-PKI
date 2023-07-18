package com.sbodtest.pkitest.domain;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity(name = "certificate")
@Table(name = "certificate")
public class Certificate {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_SEQUENCE")
    @SequenceGenerator(name = "ID_SEQUENCE", sequenceName = "CERTIFICATE_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "certificate_name")
    private String certificateName;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "last_updated_date")
    private Date lastUpdatedDate;

    @Column(name = "expired_date")
    private Date expiredDate;

    @Column(name = "status")
    private String status;
    @Column(name = "requester")
    private String requester;

    @Column(name = "serial_number")
    private Long serialNumber;

    @Column(name = "encoded_certificate")
    private String encodedCertificate;

    public Certificate(String certificateName, Date createdDate, Date lastUpdatedDate, Date expiredDate, String status, String encodedCertificate, String requester, Long serialNumber) {
        this.certificateName = certificateName;
        this.createdDate = createdDate;
        this.lastUpdatedDate = lastUpdatedDate;
        this.expiredDate = expiredDate;
        this.status = status;
        this.encodedCertificate = encodedCertificate;
        this.requester = requester;
        this.serialNumber = serialNumber;
    }

    public Certificate() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Certificate that = (Certificate) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCertificateName() {
        return certificateName;
    }

    public void setCertificateName(String certificateName) {
        this.certificateName = certificateName;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEncodedCertificate() {
        return encodedCertificate;
    }

    public void setEncodedCertificate(String encodedCertificate) {
        this.encodedCertificate = encodedCertificate;
    }

    public String getRequester() {
        return requester;
    }

    public void setRequester(String requester) {
        this.requester = requester;
    }

    public Long getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Long serialNumber) {
        this.serialNumber = serialNumber;
    }
}
