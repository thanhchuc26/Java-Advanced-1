/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session09_RemoteMethodInvocation;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

/**
 *
 * @author June
 */
/*
Để xây dựng được một chương trình trên Client để gọi hàm, 
đầu tiên chúng ta phải xác định được vị trí của đối tượng bên phía máy chủ 
Naming.lookup("rmi://localhost/MyCalculator"). 
Khi đã tìm thấy đối tượng cho phép truy xuất từ xa trong RMI Registry, 
Client sẽ gọi hàm như trên local: c.addNum(a, b).
 */
public class step4_CalculatorClient {

    public static void main(String[] args) {
        try {
            //Xác định RMI máy chủ.
            step1_Calculator myCalculator = (step1_Calculator) Naming.lookup("rmi://localhost:6789/Caculator");
            Scanner nhapvao = new Scanner(System.in);
            System.out.print("a= ");
            int a = nhapvao.nextInt();
            System.out.print("b= ");
            int b = nhapvao.nextInt();
            System.out.println("Ket qua: " + myCalculator.addNum(a, b));
        } catch (NotBoundException | MalformedURLException | RemoteException e) {
            e.printStackTrace();
        }
    }
}
