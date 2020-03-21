/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session03_LayoutManagers;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author June
 */
public class create_JFrame_with_BorderLayout extends JFrame {

    public create_JFrame_with_BorderLayout() {
        createJFrame();
    }

    // create JFrame
    private void createJFrame() {
        setTitle("JFrame with BorderLayout");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(330, 165);
        // add main panel
        add(createMainPanel());
        // display
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // create main panel
    private JPanel createMainPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.add(createTitlePanel(), BorderLayout.NORTH);
        panel.add(createNamePanel(), BorderLayout.WEST);
        panel.add(createInputPanel(), BorderLayout.CENTER);
        panel.add(createStatusPanel(), BorderLayout.EAST);
        panel.add(createLoginButtonPanel(), BorderLayout.SOUTH);
        return panel;
    }

    // create title panel
    private JPanel createTitlePanel() {
        JPanel panel = new JPanel();
        panel.add(new JLabel("Login to my App"));
        return panel;
    }

    // create name item
    private JPanel createNamePanel() {
        JPanel panel = new JPanel(new GridLayout(2, 1, 5, 5));
        panel.add(new JLabel("User name:"));
        panel.add(new JLabel("Password:"));
        return panel;
    }

    // create input panel
    private JPanel createInputPanel() {
        JPanel panel = new JPanel(new GridLayout(2, 1, 5, 5));
        panel.add(new JTextField(20));
        panel.add(new JPasswordField(20));
        return panel;
    }

    // create status panel
    private JPanel createStatusPanel() {
        JPanel panel = new JPanel(new GridLayout(2, 1, 5, 5));
        panel.add(new JLabel("Wrong"));
        panel.add(new JLabel("Wrong"));
        return panel;
    }

    // create login button panel
    private JPanel createLoginButtonPanel() {
        JPanel panel = new JPanel();
        panel.add(new JButton("Login"));
        return panel;
    }

    public static void main(String[] args) {
        create_JFrame_with_BorderLayout myBorderLayout = new create_JFrame_with_BorderLayout();
    }
}

/*
Lớp BorderLayout sắp xếp các thành phần để phù hợp với 5 miền: đông, tây, nam, bắc và trung tâm. 
Nó là layout mặc định của Frame hoặc Window. 
Mỗi khu vực (miền) chỉ có thể chứa một thành phần và mỗi thành phần trong mỗi khu vực được nhận diện 
bởi các hằng tương ứng là:
public static final int NORTH
public static final int SOUTH
public static final int EAST
public static final int WEST
public static final int CENTER

Lớp BorderLayout bao gồm các trường sau:
static String AFTER_LAST_LINE: Giống PAGE_END.
static String AFTER_LINE_ENDS: Giống LINE_END.
static String BEFORE_FIRST_LINE: Giống PAGE_START.
static String BEFORE_LINE_BEGINS: Giống LINE_START.
static String CENTER: Đây là ràng buộc bố trí trung tâm (ở giữa container).
static String EAST: Ràng buộc bố trí theo hướng đông (cạnh phải của container).
static String LINE_END: Thành phần tới phần cuối của line direction cho layout
static String LINE_START: Thành phần tới phần bắt đầu của line direction cho layout
static String NORTH: Đây là ràng buộc bố trí theo hướng bắc (phần trên của container).
static String PAGE_END: Thành phần đến sau dòng cuối cùng (last line) của nội dung layout
static String PAGE_START: Thành phần tới trước dòng đầu tiên (first line) của nội dung layout.
static String SOUTH: Ràng buộc bố trí hướng nam (phần dưới của container)
static String WEST: Ràng buộc bố trí hướng tây (cạnh trái của container)

Lớp BorderLayout bao gồm các constructor sau:
BorderLayout(): Xây dựng một Border Layout mới, ở đó giữa các thành phần là không có khoảng cách.
BorderLayout(int hgap, int vgap): Xây dụng một Border Layout với các khoảng cách gap theo chiều dọc 
và ngang đã xác định giữa các thành phần.

Các phương thức của lớp BorderLayout
STT	Phương thức & Miêu tả
1	void addLayoutComponent(Component comp, Object constraints)
        Thêm thành phần comp đã cho tới layout, bởi sử dụng đối tượng Constraint đã xác định.
2	void addLayoutComponent(String name, Component comp)
        Nếu Layout Manager sử dụng một chuỗi mỗi thành phần, thêm thành phần comp tới layout, 
        liên kết nó với chuỗi đã được xác định bởi tên
3	int getHgap()
        Trả về khoảng cách theo chiều ngang giữa các thành phần
4	float getLayoutAlignmentX(Container parent)
        Trả về căn chỉnh theo trục x
5	float getLayoutAlignmentY(Container parent)
        Trả về căn chỉnh theo trục y
6	int getVgap()
        Trả về khoảng cách theo chiều dọc giữa các thành phần
7	void invalidateLayout(Container target)
        Vô hiệu hóa layout, chỉ rằng nếu Layout Manager đã lưu thông tin thì nó nên loại bỏ
8	void layoutContainer(Container target)
        Bố trí tham số container bởi sử dụng Border Layout này
9	Dimension maximumLayoutSize(Container target)
        Trả về kích cỡ các chiều tối đa cho layout này, đã cung cấp các thành phần trong target đã cho.
10	Dimension minimumLayoutSize(Container target)
        Xác định kích cỡ tối thiểu cho target bởi sử dụng layout manager
11	Dimension preferredLayoutSize(Container target)
        Xác định kích cỡ được ưu tiên cho target bởi sử dụng layout manager, 
        dựa trên các thành phần của container.
12	void removeLayoutComponent(Component comp)
        Xóa thành phần comp đã cho từ Border Layout này
13	void setHgap(int hgap)
        Thiết lập khoảng cách theo chiều ngang giữa các thành phần
14	void setVgap(int vgap)
        Thiết lập khoảng cách theo chiều dọc giữa các thành phần
15	String toString()
        Trả về một biểu diễn chuỗi của trạng thái Border Layout này
*/