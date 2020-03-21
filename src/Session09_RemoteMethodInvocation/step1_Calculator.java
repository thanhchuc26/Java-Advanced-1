/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session09_RemoteMethodInvocation;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author June
 */
/*
Bước 1: Định nghĩa một Interface dùng chung.
Interface này như là một tờ giao kèo của Server và Client. 
Cả Client và Server phải tuân thủ nó, chỉ được triển khai và gọi các phương thức nó cho phép. 
Các phương thức đều kèm theo throws RemoteException. 
Với ví dụ này, chúng ta sẽ tạo một Interface Class với tên là Calculator. 
Nó chỉ bao gồm một phương thức addNum() dùng để cộng 2 số nguyên mà thôi. 
Bạn có thể phát triển thêm các phương thức khác. 
*/
public interface step1_Calculator  extends Remote{
    public int addNum(int x,int y) throws RemoteException;
}
/*
Các bước phát triển ứng dụng RMI đó nhứ sau:
1. Định nghĩa một Interface dùng chung.
2. Tạo lớp thực thi Implements cho Interface trên.
3. Cài đặt cho đối tượng trên Server.
4. Cài đặt cho Client.
5. Biên dịch và thực thi ứng dụng.
*/