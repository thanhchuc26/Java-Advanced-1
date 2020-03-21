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
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.*;

public class create_JLabel {

    public void create_Simple_JLabel() {
        //create simple JLabels 

        // create frame
        JFrame myJFrame = new JFrame("JLabel Example");
        myJFrame.setLayout(new GridLayout(1, 3, 5, 5));
        myJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // create image
        ImageIcon icon = new ImageIcon(getClass().getResource("image01.jpg"));
        // create three JLabel
        JLabel myJLabel1 = new JLabel("label text only");
        JLabel myJLabel2 = new JLabel(icon);
        JLabel myJLabel3 = new JLabel("icon and text", icon, JLabel.CENTER);
        myJLabel3.setVerticalTextPosition(JLabel.BOTTOM);
        myJLabel3.setHorizontalTextPosition(JLabel.CENTER);
        // add three label to frame
        myJFrame.add(myJLabel1);
        myJFrame.add(myJLabel2);
        myJFrame.add(myJLabel3);
        // display frame
        myJFrame.pack();
        myJFrame.setLocationRelativeTo(null);
        myJFrame.setVisible(true);

/*
Trong ví dụ trên chúng ta chú ý một số lệnh sau:
– setLayout(new GridLayout(1, 3, 5, 5)); Lệnh đặt GridLayout cho JFrame với 1 hàng, 3 cột, 
        các cột và hàng cách nhau là 5px. Layout tạm thời hiểu như cách bố trí các đối tượng cho Jframe, 
        nếu không có Layout thì các đối tượng sẽ bị đè lên nhau.
– Icon icon = new ImageIcon(); Lệnh đọc file ảnh tạo ảnh cho JLabel.
– Tiếp theo là 3 lệnh tạo 3 dạng JLabel. JLabel có tất cả 6 dạng khởi tạo:
+/ JLabel(): Tạo một thể hiện JLabel không có hình ảnh và một chuỗi rỗng
+/ JLabel(Icon image): Tạo một thể hiện JLabel chỉ định một hình ảnh
+/ JLabel(Icon image, int horizontalAlignment): Tạo một thể hiện JLabel chỉ định một hình ảnh 
        và horizontal alignment
+/ JLabel(String text): Tạo một thể hiện JLabel chỉ định text
+/ JLabel(String text, Icon icon, int horizontalAlignment): Tạo một thể hiện JLabel chỉ định text, image 
        và horizontal alignment
+/ JLabel(String text, int horizontalAlignment): Tạo một thể hiện JLabel chỉ định text, và horizontal alignment.

Trong lb3 chúng ta có 2 hàm setVerticalTextPosition và setHorizontalTextPosition để đặt vị trí của text 
        theo chiều dọc (BOTTOM) và theo chiều ngang (CENTER). Đối với JLabel chỉ chứa text giống lb1 
        nếu muốn căn lề (trái, phải, giữa, …) ta dùng phương thức setHorizontalAlignment(int alignment).
         */
    }

    public void create_Color_JLabel() {
        //create JLabel with color and background color
        // create frame
        JFrame myJFrame = new JFrame("JLabel Example");
        myJFrame.setLayout(new GridLayout(1, 3, 5, 5));
        myJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myJFrame.setSize(400, 200);
        // create JLabel have text color red and background color green
        JLabel myJLabel1 = new JLabel("JLabel 1");
        // set align
        myJLabel1.setHorizontalAlignment(JLabel.CENTER);
        // set color
        myJLabel1.setForeground(Color.red);
        // set background color
        myJLabel1.setOpaque(true);
        myJLabel1.setBackground(Color.green);
        myJFrame.add(myJLabel1);
        // create JLabel have text color blue and background color yellow
//        myJLabel = createJLabel("JLabel 2", Color.blue, Color.yellow);
//        myJFrame.add(myJLabel);
        JLabel myJLabel2 = new JLabel("JLabel 2");
        // set align
        myJLabel2.setHorizontalAlignment(JLabel.CENTER);
        // set color
        myJLabel2.setForeground(Color.blue);
        // set background color
        myJLabel2.setOpaque(true);
        myJLabel2.setBackground(Color.yellow);
        myJFrame.add(myJLabel2);
        // display frame
        myJFrame.setLocationRelativeTo(null);
        myJFrame.setVisible(true);
        /*
        Trong ví dụ này ta tạo hàm createJLabel trả về 1 JLabel với các đối số truyền vào lần lượt là text, 
        color và brackground color của nó. Đáng lưu ý là để đặt được màu nền thì chúng ta cần đặt Opaque của 
        JLabel là true (mặc định là false).
        */
    }

    public static void main(String[] args) {
        create_JLabel myJLabel1 = new create_JLabel();
        myJLabel1.create_Simple_JLabel();
        create_JLabel myJLabel2 = new create_JLabel();
        myJLabel2.create_Color_JLabel();
    }
}

/*
Lớp JLabel có thể hiển thị hoặc text, hoặc hình ảnh hoặc cả hai. 
Các nội dung của Label được gán bởi thiết lập căn chỉnh ngang và dọc trong khu vực hiển thị của nó. 
Theo mặc định, các label được căn chỉnh theo chiều dọc trong khu vực hiển thị. 
Theo mặc định, text-only label là căn chỉnh theo cạnh, image-only label là căn chỉnh theo chiều ngang.
*/