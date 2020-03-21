/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session01_IntroductionToSwing;

/**
 *
 * @author June
 */
import javax.swing.*;
class JFrame1 extends JFrame{
    String tile="Create an JFrame by extend JFrame class 1";
    public  JFrame1(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle(tile);
        setSize(500,200);
        setLocationRelativeTo(null);
        setVisible(true);
        
    }
}
public class create_JFrame {
    String title;
    static void JFrame2(){
        JFrame myFrame=new JFrame("Create a JFrame by using JFrame class 2");
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        myFrame.setTitle(tile);
        myFrame.setSize(500,200);
        myFrame.setLocationRelativeTo(null);
        myFrame.setVisible(true);
        
    }
    public static void main(String[] args) {
//        create a JFrame by extend JFrame class
        JFrame1 jFrame1 = new JFrame1();
//        create a JFrame by using JFrame class
        JFrame2();
    }
}

/*
JFrame – là khung của ứng dụng. Có thể hiểu JFrame là một cửa sổ trên windows

Đặc điểm cơ bản của JFrame :
– Là một cửa sổ có tiêu đề, viền, thanh menu (tùy chọn) và các thành phần được chỉ định khác
– Nó có thể di chuyển, thay đổi kích thước và có icon đại diện
– Nó không phải là một subclass của JComponent
– Nó thường được dùng để chứa các thành phần giao diện khác (Button, Label,…)

Một số phương thức cơ bản của JFrame :
– setSize(int width,int height) : Đặt kích thước cho JFrame
– setLocation(int x,int y) : Đặt vị trí cho JFrame.(Mặc định thì một JFrame sẽ hiển thị ở vị trí góc trên – trái của màn hình.)
– setVisible(boolean b) : Đặt JFrame ẩn/hiện
– setDefaultCloseOperation(int operation): Đặt hành động mặc định sẽ xảy ra khi người dùng “close” Frame. 
Mặc định là HIDE_ON_CLOSE, các lựa chọn khác gồm DO_NOTHING_ON_CLOSE, DISPOSE_ON_CLOSE, EXIT_ON_CLOSE
– setTitle(String title) : Đặt tiêu đề cho JFrame
– setResizable(boolean b): Đặt JFrame có được thay đổi kích thước hay không

Các bước cơ bản tạo một cửa sổ JFrame :
B1 : Khởi tạo một đối tượng của lớp JFrame
B2 : Đặt kích thước cho JFrame
B3: Đặt tiêu đề cho JFrame ( Nếu không đặt thì thanh tiêu đề sẽ trắng )
B4: Đặt hành động mặc định cho việc “close” JFrame
B5: Đặt JFrame hiển thị

Các hàm tạo của JFrame: 
– JFrame() : Khởi tạo một frame mới invisible
– JFrame(String title) : Tạo một frame mới invisibile với tiêu đề được chỉ định

*/