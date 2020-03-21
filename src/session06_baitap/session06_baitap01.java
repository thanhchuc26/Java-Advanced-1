/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session06_baitap;

import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author June
 */
public class session06_baitap01 extends JFrame {

    JPanel mainPanel;
    Vector vectorHeaderTable, vectorDataTable;
    JTable studentTable;

    void create_JFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Show student information");
        setSize(500, 295);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    void create_mainPanel() {
        mainPanel = new JPanel(new GridLayout(1,0));
    }

    void create_and_add_studentTable_to_mainPanel() throws ClassNotFoundException, SQLException {
        createVectorHeaderTable();
        createVectorDataTable();
        DefaultTableModel model = new DefaultTableModel(vectorDataTable, vectorHeaderTable);
        studentTable=new JTable();
        studentTable.setModel(model);
        JScrollPane scrollTable=new JScrollPane(studentTable);
        mainPanel.add(scrollTable);
    }

    void createVectorHeaderTable() {
        vectorHeaderTable = new Vector();
        vectorHeaderTable.add("Student ID");
        vectorHeaderTable.add("Batch");
        vectorHeaderTable.add("Name");
    }

    void createVectorDataTable() throws ClassNotFoundException, SQLException {
        vectorDataTable = new Vector();
        Connection conn;
        Statement stmt;
        Class.forName(database.JDBC_DRIVER);
        conn = DriverManager.getConnection(database.DB_URL + database.DATABASENAME + database.USER + database.PASS);
        stmt = conn.createStatement();
        String sql = "SELECT studentid,batch,name FROM student";
        try (ResultSet rs = stmt.executeQuery(sql)) {
            ResultSetMetaData rsmt = rs.getMetaData();
            while (rs.next()) {
                Vector vectorTemp = new Vector();
                for (int i = 1; i <= rsmt.getColumnCount(); i++) {
                    vectorTemp.add(rs.getString(i));
                }
                vectorDataTable.add(vectorTemp);
            }
        }
        stmt.close();
        conn.close();
    }

    void addMainPanel_to_JFrame() {
        add(this.mainPanel);
    }

    void displayJFrame() {
        setVisible(true);
    }

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        session06_baitap01 showTable = new session06_baitap01();
        showTable.create_JFrame();
        showTable.create_mainPanel();
        showTable.create_and_add_studentTable_to_mainPanel();
        showTable.addMainPanel_to_JFrame();
        showTable.displayJFrame();
    }
}
