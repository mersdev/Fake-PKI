package com.sbodtest.pkitest.controller;

import com.sbodtest.pkitest.model.certificate.CreateNewCertificateRequest;
import com.sbodtest.pkitest.model.certificate.SbodCertificate;
import com.sbodtest.pkitest.service.CertificateService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CertController implements CertAPI{
    private CertificateService certificateService;

    public CertController(CertificateService certificateService) {
        this.certificateService = certificateService;
    }

    @Override
    public void getCertificate() {

    }

    @Override
    public SbodCertificate generateCertificate(CreateNewCertificateRequest createNewCertificateRequest) {
        return this.certificateService.generateCertificate(createNewCertificateRequest);
    }

    @Override
    public void revokeCertificate() {

    }

    @Override
    public void validateCertificate() {

    }
}
