/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session08_Networking;

/**
 *
 * @author June
 */
import java.io.*; 
import java.net.*;
public class Server_Multi_Thread {
    public static void main(String args[])
    {
         try {
            ServerSocket ss = new ServerSocket(999);// Tao cong 9999 de server lang nghe
            while (true)// Cho client ket noi
            {              
                // Su dung multithread
                // Khi co 1 client gui yeu cau toi thi se tao ra 1 thread phuc vu client do
                new ThreadSocket(ss.accept()).start();
            }
        } catch (IOException e) {
            System.out.println("Exception: " + e.getMessage());
        }
         //catch (InterruptedException ie)
        {
        }
    }
}
