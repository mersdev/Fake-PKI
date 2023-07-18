package com.sbodtest.pkitest.service;

import com.sbodtest.pkitest.domain.Certificate;
import com.sbodtest.pkitest.model.certificate.CreateNewCertificateRequest;
import com.sbodtest.pkitest.model.certificate.SbodCertificate;
import com.sbodtest.pkitest.repository.CertificateRepository;
import com.sbodtest.pkitest.util.CertificateUtil;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CertificateService {
    private CertificateRepository certificateRepository;
    private Logger logger;

    @Autowired
    public CertificateService(CertificateRepository certificateRepository, Logger logger) {
        this.certificateRepository = certificateRepository;
        this.logger = logger;
    }

    public SbodCertificate generateCertificate(CreateNewCertificateRequest createNewCertificateRequest){
        SbodCertificate sbodCertificate = CertificateUtil.generateBase64EncodedCertificate(createNewCertificateRequest);
        return sbodCertificate;
    }
}
