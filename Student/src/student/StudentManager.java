/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author gawon
 */
public class StudentManager {

    double pnum = 18.0, nnum = 0;
    ResultSet rs = null, rs1 = null, rs2 = null;
    Statement stmt = null;
    Connection conn = null;

    String url = "jdbc:mysql://113.198.235.232:23306/UIS_TOP";
    String id = "admin";
    String password = "123";

    public void getclass(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, id, password);
            stmt = conn.createStatement();

            // 최대 수강 인원 체크
            rs1 = stmt.executeQuery("select * from classuser");

            while (rs1.next()) {
                String classnum = rs1.getString("classnum");
                String chknum = rs1.getString("chknum");

                rs2 = conn.createStatement().executeQuery("select maxpeople from open where classnumm='" + classnum + "'");
                while (rs2.next()) {
                    String max = rs2.getNString("maxpeople");
                    if (chknum.equals(max)) {
                        conn.createStatement().executeUpdate("update classuser set classopen='C' where classnum='" + classnum + "'");
                    }
                }
            }

            // 개설 강좌 가져오기 
            rs = stmt.executeQuery("select classnum, classname, classnumb, classstu, classpre from classuser where classopen='Y'");

            while (rs.next()) {
                String classnum = rs.getString("classnum");
                String classname = rs.getString("classname");
                String classnumb = rs.getString("classnumb");
                String classstu = rs.getString("classstu");
                String classpre = rs.getString("classpre");
                model.addRow(new Object[]{classnum, classname, classnumb, classstu, classpre});

            }

            table.setModel(model);

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(StudentManager.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void checkScore(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, id, password);
            stmt = conn.createStatement();
            
            rs = stmt.executeQuery("select classname,classnumb,score from enrollment where stu_id='S001'");
            
            while(rs.next()){
                String classname = rs.getNString("classname");
                String classnumb = rs.getNString("classnumb");
                String score = rs.getNString("score");
                
                model.addRow(new Object[]{classname, classnumb, score});
            }
            
            table.setModel(model);
           
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(StudentManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void enrollment(JTable table1, JTable table2, JLabel label1, JLabel label2) {

        String stu_id = null, classnum = null, classname = null, classnumb = null, classstu = null, classpre = null;
        DefaultTableModel model1 = (DefaultTableModel) table1.getModel();
        DefaultTableModel model2 = (DefaultTableModel) table2.getModel();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, id, password);
            stmt = conn.createStatement();

            // 선택된 행의 데이터 가져오기 
            int row = table1.getSelectedRow();
            String value = (String) table1.getValueAt(row, 0);

            rs = stmt.executeQuery("select classnum, classname, classnumb, classstu, classpre from classuser where classnum=\"" + value + "\"");

            while (rs.next()) {
                classnum = rs.getString("classnum");
                classname = rs.getString("classname");
                classnumb = rs.getString("classnumb");
                classstu = rs.getString("classstu");
                classpre = rs.getString("classpre");
            }

            // 현재 신청 학점 체크 
            nnum = nnum + Double.parseDouble(classnumb);
            pnum = pnum - Double.parseDouble(classnumb);

            if (pnum < 0) { // 수강 학점 초과 
                nnum = nnum - Double.parseDouble(classnumb);
                pnum = pnum + Double.parseDouble(classnumb);
                JOptionPane.showMessageDialog(null, "최대 수강 학점을 초과하셨습니다 ");
            } else {
                model2.addRow(new Object[]{classnum, classname, classnumb, classstu, classpre});
                model1.removeRow(row);

                String add = "insert into enrollment values ('"+classnum+"','"+classname+"','"+classnumb+"',default,'S001','유가원')";
                stmt.executeUpdate(add);

                String add_chknum = "update classuser set chknum = chknum + 1 where classnum ='" + classnum + "'";
                stmt.executeUpdate(add_chknum);

                label1.setText(Double.toString(nnum));
                label2.setText(Double.toString(pnum));

                System.out.println(nnum);
                System.out.println(pnum);

                table1.setModel(model1);
                table2.setModel(model2);

            }

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(StudentManager.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void cancel(JTable table1, JTable table2, JLabel label1, JLabel label2) {
        String stu_id = "S001";
        String classnum = null, classname = null, classnumb = null, classstu = null, classpre = null;
        DefaultTableModel model1 = (DefaultTableModel) table1.getModel();
        DefaultTableModel model2 = (DefaultTableModel) table2.getModel();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, id, password);
            stmt = conn.createStatement();

            int row = table2.getSelectedRow();
            String value = (String) table2.getValueAt(row, 0);

            rs = stmt.executeQuery("select classnum, classname, classnumb, classstu, classpre from classuser where classnum=\"" + value + "\"");

            while (rs.next()) {
                classnum = rs.getString("classnum");
                classname = rs.getString("classname");
                classnumb = rs.getString("classnumb");
                classstu = rs.getString("classstu");
                classpre = rs.getString("classpre");

            }

            model1.addRow(new Object[]{classnum, classname, classnumb, classstu, classpre});
            model2.removeRow(row);

            nnum = nnum - Double.parseDouble(classnumb);
            pnum = pnum + Double.parseDouble(classnumb);

            System.out.println(nnum);
            System.out.println(pnum);
            String delete = "delete from enrollment where classnum='" + classnum+ "," + stu_id + "'";
            //System.out.println(delete);
            stmt.executeUpdate(delete);

            String sub_chknum = "update classuser set chknum = chknum - 1 where classnum ='" + classnum + "'";
            stmt.executeUpdate(sub_chknum);

            label1.setText(Double.toString(nnum));
            label2.setText(Double.toString(pnum));

            table1.setModel(model1);
            table2.setModel(model2);

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(StudentManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
