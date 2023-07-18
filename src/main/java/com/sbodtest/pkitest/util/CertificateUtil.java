package com.sbodtest.pkitest.util;

import com.sbodtest.pkitest.model.certificate.CreateNewCertificateRequest;
import com.sbodtest.pkitest.model.certificate.SbodCertificate;

public class CertificateUtil {
    private static final String DEFAULT_KEY_PAIR_ALGORITHM = "RSA";
    private static final Integer DEFAULT_KEY_SIZE = 2048;
    private static final String DEFAULT_SIGNATURE_ALGORITHM = "SHA256WithRSA";
    private static final Integer DEFAULT_CERT_VALID_DAYS = 365;

    public static SbodCertificate generateBase64EncodedCertificate(CreateNewCertificateRequest createNewCertificateRequest){
        return generateBase64EncodedCertificate(createNewCertificateRequest.getCertificateName());
    }

    public static SbodCertificate generateBase64EncodedCertificate(String certificateName){
        return generateBase64EncodedCertificate(certificateName, DEFAULT_KEY_PAIR_ALGORITHM, DEFAULT_KEY_SIZE, DEFAULT_SIGNATURE_ALGORITHM, DEFAULT_CERT_VALID_DAYS);
    }

    public static SbodCertificate generateBase64EncodedCertificate(String certificateName, String keyPairAlgorithm, Integer keySize, String signatureAlgorithm, Integer certValidDays){
        return generateCertificate(certificateName, keyPairAlgorithm,keySize,signatureAlgorithm,certValidDays);
    }

    private static SbodCertificate generateCertificate(String certificateName, String keyPairAlgorithm, Integer keySize, String signatureAlgorithm, Integer certValidDays) {
        return new SbodCertificate();
    }

    private static String encodeBase64(byte[] encodedCert){
        return java.util.Base64.getEncoder().encodeToString(encodedCert);
    }

}
