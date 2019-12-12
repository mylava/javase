package cn.mylava.Tmp;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.security.cert.CertPath;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class Test1 {
    public static void main(String args[]) throws Exception {
        HostnameVerifier hv = new HostnameVerifier() {
            public boolean verify(String urlHostName, SSLSession session) {
                System.out.println("Warning: URL Host: " + urlHostName
                        + " vs. " + session.getPeerHost());
                return true;
            }
        };
        trustAllHttpsCertificates();
        HttpsURLConnection.setDefaultHostnameVerifier(hv);
        SSLSocketFactory factory = HttpsURLConnection.getDefaultSSLSocketFactory();
        SSLSocket socket = (SSLSocket) factory.createSocket("portal.xxxxx.com", 9443);// portal.xxxxx.com 192.168.1.15
        socket.startHandshake();
        SSLSession session = socket.getSession();
        // String sslHost = session.getPeerHost();
        // String host = "portal.xxxxx.com";
        // System.out.println("Host=" + host);
        // System.out.println("SSL Host=" + sslHost);
        // if (host.equals(sslHost)) {
        // System.out.println("good");
        // } else {
        // System.out.println("bad");
        // }
        java.security.cert.Certificate[] servercerts = session.getPeerCertificates();
        for (int i = 0; i < servercerts.length; i++) {
            X509Certificate c = (X509Certificate) servercerts[i];
            System.out.println(getValByAttributeTypeFromIssuerDN(c.getSubjectDN().toString(), "CN="));
        }
    }

    private static String getValByAttributeTypeFromIssuerDN(String dn, String attributeType) {
        String[] dnSplits = dn.split(",");
        for (String dnSplit : dnSplits) {
            if (dnSplit.contains(attributeType)) {
                String[] cnSplits = dnSplit.trim().split("=");
                if (cnSplits[1] != null) {
                    return cnSplits[1].trim();
                }
            }
        }
        return "";
    }

    private static void trustAllHttpsCertificates() throws Exception {
        javax.net.ssl.TrustManager[] trustAllCerts = new javax.net.ssl.TrustManager[1];
        javax.net.ssl.TrustManager tm = new miTM();
        trustAllCerts[0] = tm;
        javax.net.ssl.SSLContext sc = javax.net.ssl.SSLContext.getInstance("SSL");
        sc.init(null, trustAllCerts, null);
        javax.net.ssl.HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
    }

    static class miTM implements javax.net.ssl.TrustManager, javax.net.ssl.X509TrustManager {
        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
            return null;
        }

        public boolean isServerTrusted(
                java.security.cert.X509Certificate[] certs) {
            return true;
        }

        public boolean isClientTrusted(
                java.security.cert.X509Certificate[] certs) {
            return true;
        }

        public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType) throws java.security.cert.CertificateException {
            return;
        }

        public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType) throws java.security.cert.CertificateException {
            return;
        }
    }
}