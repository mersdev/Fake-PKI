package com.sbodtest.pkitest.controller;

import com.sbodtest.pkitest.model.certificate.CreateNewCertificateRequest;
import com.sbodtest.pkitest.model.certificate.SbodCertificate;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/v1/cert")
public interface CertAPI {
    @GetMapping
    void getCertificate();

    @PostMapping
    SbodCertificate generateCertificate(@RequestBody CreateNewCertificateRequest createNewCertificateRequest);

    @DeleteMapping("/revoke")
    void revokeCertificate();

    @GetMapping("/validate")
    void validateCertificate();

}
