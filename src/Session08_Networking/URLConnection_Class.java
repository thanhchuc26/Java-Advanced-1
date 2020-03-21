/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session08_Networking;

import java.io.BufferedInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

/**
 *
 * @author June
 */
public class URLConnection_Class {

    static public void getUrlConnection() {
        URL myUrl;
        URLConnection myURLConnection;
        try {
            myUrl = new URL("https://www.aptech-danang.edu.vn");
            myURLConnection = myUrl.openConnection();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    static public void getInputStream() throws MalformedURLException, IOException {
        URL myURL = new URL("https://aptech-danang.edu.vn");
        URLConnection myURLConnection = myURL.openConnection();
        InputStream raw = myURLConnection.getInputStream();
        InputStream buffer = new BufferedInputStream(raw);

        // chain the InputStream to a Reader
        Reader r = new InputStreamReader(buffer);
        int c;
        while ((c = r.read()) != -1) {
            System.out.print((char) c);
        }
    }

    static public void getHeader() throws MalformedURLException, IOException {
        URL myURL = new URL("https://aptech-danang.edu.vn");
        URLConnection myURLConnection = myURL.openConnection();

        System.out.println("Content-type: " + myURLConnection.getContentType());
        System.out.println("Content-encoding: "
                + myURLConnection.getContentEncoding());
        System.out.println("Date: " + new Date(myURLConnection.getDate()));
        System.out.println("Last modified: "
                + new Date(myURLConnection.getLastModified()));
        System.out.println("Expiration date: "
                + new Date(myURLConnection.getExpiration()));
        System.out.println("Content-length: " + myURLConnection.getContentLength());
    }

    static public void getAllHeader() throws MalformedURLException, IOException {
        URL myURL = new URL("https://aptech-danang.edu.vn");
        URLConnection myURLConnection = myURL.openConnection();
        for (int j = 1;; j++) {
            String header = myURLConnection.getHeaderField(j);
            if (header == null) {
                break;
            }
            System.out.println(myURLConnection.getHeaderFieldKey(j) + ": " + header);
        }
    }

    public static void main(String[] args) throws IOException {
        getUrlConnection();
//        getInputStream();
//        getHeader();
        getAllHeader();
    }
}
