/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session09_RemoteMethodInvocation;

import java.rmi.RemoteException;
import java.rmi.server.RemoteServer;
import java.rmi.server.ServerNotActiveException;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author June
 */
/*Bước 2:Tạo lớp thực thi Implements cho Interface.
Lớp cài đặt không những cài đặt phần thực thi cho Interface Class 
mà còn phải thừa kế từ một lớp của Java là lớp UnicastRemoteObject.
 */
public class step2_CalculatorImpl extends UnicastRemoteObject implements step1_Calculator {

    public step2_CalculatorImpl() throws RemoteException {
    }

    public int addNum(int x, int y) throws RemoteException {
        try {
            System.out.println("Client " + RemoteServer.getClientHost() + " request to Calculator!!");
        } catch (ServerNotActiveException ex) {
            Logger.getLogger(step2_CalculatorImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (x + y);
    }
}
