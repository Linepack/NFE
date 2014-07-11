package br.com.linepack.classes;

import java.io.File;

public class ConfiguraCertificados {

    public static void configura() {
        
        File file = new File("C:\\Users\\Franciscato\\Documents\\NetBeansProjects\\NFE\\NFeCacerts");
        if (!file.isFile()){
            GerarCacertsNfe.geraCertificadosNfe();
        }
                        
        System.clearProperty("javax.net.ssl.keyStore");
        System.clearProperty("javax.net.ssl.keyStorePassword");
        System.clearProperty("javax.net.ssl.trustStore");

        System.setProperty("javax.net.ssl.keyStoreType", "PKCS12");
        System.setProperty("javax.net.ssl.keyStore", "C:\\Users\\Franciscato\\Dropbox\\Documentos\\Outros\\CERTIFICADO DIGITAL A1.pfx");
        System.setProperty("javax.net.ssl.keyStorePassword", "F110987*");

        System.setProperty("javax.net.ssl.trustStoreType", "JKS");
        System.setProperty("javax.net.ssl.trustStore", "C:\\Users\\Franciscato\\Documents\\NetBeansProjects\\NFE\\NFeCacerts");
        System.setProperty("javax.net.ssl.trustStorePassword", "changeit");
    }

}
