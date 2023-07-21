package com.sbodtest.pkitest.util;

import com.sbodtest.pkitest.model.certificate.CreateNewCertificateRequest;
import com.sbodtest.pkitest.model.certificate.SbodCertificate;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cert.X509v1CertificateBuilder;
import org.bouncycastle.cert.X509v3CertificateBuilder;
import org.bouncycastle.cert.jcajce.JcaX509CertificateConverter;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;

import java.math.BigInteger;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.Security;
import java.security.cert.X509Certificate;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;

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
        SbodCertificate sbodCertificate = new SbodCertificate();
        try {
            Security.addProvider(new BouncyCastleProvider());

            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA", "BC");
            keyPairGenerator.initialize(2048, new SecureRandom());
            KeyPair rootKeyPair = keyPairGenerator.generateKeyPair();

            // Build the Root CA's distinguished name
            X500Name rootDn = new X500Name("CN=RootCA");

            // Create a self-signed Root CA certificate
            BigInteger serialNumber = BigInteger.valueOf(System.currentTimeMillis());
            Date startDate = new Date();
            Date endDate = new Date(startDate.getTime() + 365 * 24 * 60 * 60 * 1000); // 1 year validity

            X509v1CertificateBuilder certBuilder = new X509v1CertificateBuilder(
                    rootDn,
                    serialNumber,
                    startDate,
                    endDate,
                    rootDn,
                    (SubjectPublicKeyInfo) rootKeyPair.getPublic()
            );

            // Use the "SHA256WithRSA" algorithm to sign the certificate
            JcaContentSignerBuilder contentSignerBuilder = new JcaContentSignerBuilder("SHA256WithRSA");
            ContentSigner contentSigner = contentSignerBuilder.build(rootKeyPair.getPrivate());
            X509Certificate rootCertificate = new JcaX509CertificateConverter().getCertificate(certBuilder.build(contentSigner));

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return sbodCertificate;
    }

    private static String encodeBase64(byte[] encodedCert){
        return java.util.Base64.getEncoder().encodeToString(encodedCert);
    }

}
