package Model;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import universityinformationsystem.DBSystem;
import universityinformationsystem.ProjectHelper;

public class BillIssueSystem extends DBSystem{
  public boolean billIssue(String stud_id) {
        try {
            String sql = "update STUDENT set chk = 'Y' where stud_id=" + ProjectHelper.addQuotationStr(stud_id);
            st.executeUpdate(sql );

        } catch (SQLException ex) { 
          Logger.getLogger(BillIssueSystem.class.getName()).log(Level.SEVERE, null, ex);
          return false;
        }
      return true;
  }
  
    public ArrayList  getNoBillIssueStudent(){
        String no, name;
        ArrayList <String[]> infoarray = new ArrayList<>();
       try {
           ResultSet rs = st.executeQuery("select stud_id, stud_name from STUDENT where chk='N'");

            while (rs.next()) {
                no = rs.getString("stud_id");
                name = rs.getString("stud_name");
                String[] info = {no,name};
                infoarray.add(info);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } 
       return infoarray;
    }

}
