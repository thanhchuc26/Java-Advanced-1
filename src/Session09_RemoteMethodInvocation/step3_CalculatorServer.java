/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session09_RemoteMethodInvocation;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 *
 * @author June
 */
/*
Bước 3: Cài đặt cho đối tượng trên Server.
*/
public class step3_CalculatorServer {
    public static void main(String[] args) {
        try {
            step1_Calculator myCalculator = new step2_CalculatorImpl();

            LocateRegistry.createRegistry(6789);

            // Đăng ký đối tượng này với rmiregistry
            Naming.bind("rmi://localhost:6789/Caculator", myCalculator);
            System.out.println(">>>>>INFO: RMI Server started!!!!!!!!");
        } catch (RemoteException | AlreadyBoundException | MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
