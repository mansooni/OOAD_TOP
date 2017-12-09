/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package professor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author gawon
 */
public class professorManager {
    
    String classnumm[] = {};
    
    ResultSet rs = null;
    Statement stmt = null;
    Connection conn = null;
    
    String url = "jdbc:mysql://113.198.235.232:23306/UIS_TOP";
    String id = "admin";
    String password = "123";

    public void getAttendance(JList list) {
            
        try {
            DefaultListModel classlistModel = new DefaultListModel();

            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, id, password);
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select classnumm from open where prof_id='P001'");

            while (rs.next()) {
                String classlist= rs.getNString("classnumm");
                classlistModel.addElement(classlist);
            }

            list.setModel(classlistModel);

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(professorManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void getnamelist(JList list, JTable table){
        
        DefaultTableModel model = (DefaultTableModel) table.getModel();
                
        String getclassnum = (String) list.getSelectedValue();

        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            conn = DriverManager.getConnection(url, id, password);
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select stu_name, score ,classnumb from enrollment where classnum='"+getclassnum+"'");
            
            while(rs.next()){
                String stu_name = rs.getString("stu_name");
                String score = rs.getString("score");
                String classnumb = rs.getString("classnumb");
                System.out.println(stu_name+","+score+","+classnumb);
                
                model.addRow(new Object[]{stu_name,score,classnumb});
            }
            
            table.setModel(model);
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(professorManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
