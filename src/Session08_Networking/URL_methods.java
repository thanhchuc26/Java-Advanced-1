/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session08_Networking;

import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author June
 */
public class URL_methods {
    public static void main(String[] args) throws MalformedURLException {
        URL myUrl=new URL("https://www.google.com.vn/webhp?sourceid=chrome-instant&rlz=1C1CHZL_viVN732VN732&ion=1&espv=2&ie=UTF-8#q=aptech&*");
        System.out.println("myUrl: "+myUrl);
        System.out.println("Host: "+myUrl.getHost());
        System.out.println("File: "+myUrl.getFile());
        System.out.println("Path: "+myUrl.getPath());
        System.out.println("Query: "+myUrl.getQuery());
        System.out.println("Default port: "+myUrl.getDefaultPort());
        System.out.println("Protocol: "+myUrl.getProtocol());
    }
}
