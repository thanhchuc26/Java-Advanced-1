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
import java.net.Socket;
import java.io.*;

public class ThreadSocket extends Thread {

    Socket socket = null;

    public ThreadSocket(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            DataOutputStream sendToClient = new DataOutputStream(socket.getOutputStream());// Tao output stream
            BufferedReader fromClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));//Tao input stream
            while (true) {
                String sentence = fromClient.readLine();// Chuỗi nhận được từ Client
                System.out.println("FROM CLIENT: " + sentence);
                if (sentence.equalsIgnoreCase("quit")) {
                    break;
                }
                String reverseSentence = reverse(sentence);
                //Thread.sleep(10000); // Giả sử khi xử lý nó mất khoảng 5s
                sendToClient.writeBytes(reverseSentence + '\n');
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String reverse(String input) throws InterruptedException {
        String output = "";
        StringBuilder strBuilder = new StringBuilder(input);
        output = strBuilder.reverse().toString();
        return output;
    }
}
