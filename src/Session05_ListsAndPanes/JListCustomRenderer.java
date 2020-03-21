/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session05_ListsAndPanes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author June
 */
class Book {
	private String name;
	private String author;
	private String iconName;

	public Book(String name, String author, String iconName) {
		super();
		this.name = name;
		this.author = author;
		this.iconName = iconName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIconName() {
		return iconName;
	}

	public void setIconName(String iconName) {
		this.iconName = iconName;
	}

	@Override
	public String toString() {
		return name + " - " + author;
	}
}
class BookRenderer extends JPanel implements ListCellRenderer<Book> {

	private JLabel lbIcon = new JLabel();
	private JLabel lbName = new JLabel();
	private JLabel lbAuthor = new JLabel();
	private JPanel panelText;
	private JPanel panelIcon;

	public BookRenderer() {
		setLayout(new BorderLayout(5, 5));

		panelText = new JPanel(new GridLayout(0, 1));
		panelText.add(lbName);
		panelText.add(lbAuthor);

		panelIcon = new JPanel();
		panelIcon.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelIcon.add(lbIcon);

		add(panelIcon, BorderLayout.WEST);
		add(panelText, BorderLayout.CENTER);
	}

	@Override
	public Component getListCellRendererComponent(JList<? extends Book> list,
			Book book, int index, boolean isSelected, boolean cellHasFocus) {

		lbIcon.setIcon(new ImageIcon(getClass().getResource("img_JList/" + book.getIconName() + ".jpg")));
		lbName.setText(book.getName());
		lbAuthor.setText(book.getAuthor());
		lbAuthor.setForeground(Color.blue);

		// set Opaque to change background color of JLabel
		lbName.setOpaque(true);
		lbAuthor.setOpaque(true);
		lbIcon.setOpaque(true);

		// when select item
		if (isSelected) {
			lbName.setBackground(list.getSelectionBackground());
			lbAuthor.setBackground(list.getSelectionBackground());
			lbIcon.setBackground(list.getSelectionBackground());
			setBackground(list.getSelectionBackground());
			panelIcon.setBackground(list.getSelectionBackground());
		} else { // when don't select
			lbName.setBackground(list.getBackground());
			lbAuthor.setBackground(list.getBackground());
			lbIcon.setBackground(list.getBackground());
			setBackground(list.getBackground());
			panelIcon.setBackground(list.getBackground());
		}
		return this;
	}
}

public class JListCustomRenderer  extends JFrame{
    private int width = 350;
	private int height = 200;
	private JList<Book> listBook;

	public JListCustomRenderer() {
		// add main panel
		add(createMainPanel());
		// set display
		setTitle("JLIstCustomRenderer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(width, height);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private JPanel createMainPanel() {
		JPanel panel = new JPanel(new BorderLayout());
		panel.setBorder(new EmptyBorder(10, 10, 10, 10));
		// create list book and set to scrollpane and add to panel
		panel.add(new JScrollPane(listBook = createListBooks()),
				BorderLayout.CENTER);
		return panel;
	}

	private JList<Book> createListBooks() {
		// create List model
		DefaultListModel<Book> model = new DefaultListModel<>();
		// add item to model
		model.addElement(new Book("C/C++ Programming", "A", "cpp"));
		model.addElement(new Book("Java Programming", "B", "java"));
		model.addElement(new Book("C# Programming", "C", "cs"));
		model.addElement(new Book("IOS Programming", "D", "ios"));
		model.addElement(new Book("Windows Phone Programming", "E", "wp"));
		model.addElement(new Book("Android Programming", "F", "android"));
		// create JList with model
		JList<Book> list = new JList<Book>(model);
		// set cell renderer
		list.setCellRenderer(new BookRenderer());
		return list;
	}
    public static void main(String[] args) {
        JListCustomRenderer myJList=new JListCustomRenderer();
    }
}
