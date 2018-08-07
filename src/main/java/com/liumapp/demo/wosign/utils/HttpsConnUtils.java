package com.liumapp.demo.wosign.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyStore;
import java.security.SecureRandom;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.servlet.http.HttpServletRequest;

@Component
public class HttpsConnUtils {

    @Value("${custom.pfxPath}")
    private String pfxPath;

    public String post(String urlString,String content) throws Exception {
        TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                return new java.security.cert.X509Certificate[] {};
            }
            @Override
            public void checkClientTrusted(
                    java.security.cert.X509Certificate[] chain, String authType)
                    throws java.security.cert.CertificateException {
            }
            @Override
            public void checkServerTrusted(
                    java.security.cert.X509Certificate[] chain, String authType)
                    throws java.security.cert.CertificateException {
            }
        } };
        StringBuffer json = new StringBuffer();
        try {
            // Open a secure connection.
            URL url = new URL(urlString);
            String requestParams = content.replaceAll("\\s","").replaceAll("\\n","");
            HttpsURLConnection con = (HttpsURLConnection) url.openConnection();

            // Set up the connection properties
            con.setRequestProperty("Connection", "close");
            con.setDoInput(true);
            con.setDoOutput(true);
            con.setUseCaches(false);
            con.setConnectTimeout(30000);
            con.setReadTimeout(30000);
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type",
                    "application/x-www-form-urlencoded");
            con.setRequestProperty("Content-Length",
                    Integer.toString(requestParams.length()));

            File pKeyFile = new File(pfxPath);
            String pKeyPassword = "wosign";
            KeyManagerFactory keyManagerFactory = KeyManagerFactory
                    .getInstance("SunX509");
            KeyStore keyStore = KeyStore.getInstance("PKCS12");
            InputStream keyInput = new FileInputStream(pKeyFile);
            keyStore.load(keyInput, pKeyPassword.toCharArray());
            keyInput.close();
            keyManagerFactory.init(keyStore, pKeyPassword.toCharArray());
            SSLContext context = SSLContext.getInstance("TLS");
            context.init(keyManagerFactory.getKeyManagers(), trustAllCerts,
                    new SecureRandom());
            SSLSocketFactory sockFact = context.getSocketFactory();
            con.setSSLSocketFactory(sockFact);

            // Send the request
            OutputStream outputStream = con.getOutputStream();
            outputStream.write(requestParams.getBytes("UTF-8"));
            outputStream.close();

            // Check for errors
            int responseCode = con.getResponseCode();
            InputStream inputStream;
            if (responseCode == HttpURLConnection.HTTP_OK) {
                inputStream = con.getInputStream();
            } else {
                inputStream = con.getErrorStream();
            }

            // Process the response
            BufferedReader reader;
            String line = null;
            reader = new BufferedReader(new InputStreamReader(inputStream));
            while ((line = reader.readLine()) != null) {
//				System.out.println(line);
                json.append(line);
            }
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return json.toString();
    }


    public static String readJSONString(HttpServletRequest request){
        StringBuffer json = new StringBuffer();
        String line = null;
        try {
            BufferedReader reader = request.getReader();
            while((line = reader.readLine()) != null) {
                json.append(line);
            }
        }
        catch(Exception e) {
            System.out.println(e.toString());
        }
        return json.toString();
    }

}
