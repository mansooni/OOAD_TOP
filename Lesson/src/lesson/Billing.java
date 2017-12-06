/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

/**
 *
 * @author gawon
 */
public class Billing {

    ResultSet rs = null;
    Statement stmt = null;
    Connection conn = null;

    String url = "jdbc:mysql://113.198.235.232:23306/UIS_TOP";
    String id = "admin";
    String password = "123";

    public void issued(JList list) {

        DefaultListModel Model = new DefaultListModel();
        String name = (String) list.getSelectedValue();
        int index = list.getSelectedIndex();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, id, password);
            stmt = conn.createStatement();

            String change = "update STUDENT set chk = 'Y' where stud_name=\"" + name + "\"";
            stmt.executeUpdate(change);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Billing.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Billing.class.getName()).log(Level.SEVERE, null, ex);
        }

        list.remove(index);
        list.setModel(Model);

        JOptionPane.showMessageDialog(null, "청구서발급이완료되었습니다");

    }

    void studentTable(JList list) {
        try {
            DefaultListModel nModel = new DefaultListModel();

            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, id, password);
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select stud_name from STUDENT where chk='N'");

            while (rs.next()) {
                String name = rs.getString(1);
                nModel.addElement(name);
            }

            list.setModel(nModel);

        } catch (SQLException e) {
            System.err.println("error");
            System.err.println(e.getErrorCode());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LessonFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
