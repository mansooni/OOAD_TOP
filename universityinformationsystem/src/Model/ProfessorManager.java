/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import universityinformationsystem.DBSystem;

/**
 *
 * @author gawon
 */
public class ProfessorManager extends DBSystem {

    ResultSet rs = null;
    String id;

    public ProfessorManager(String id) {
        this.id = id;
    }
   
    public ArrayList getAttendance(String prof_id){
        ArrayList<String[]> infoArray = new ArrayList<>();
        try {

            rs = st.executeQuery("select * from CLASS CL LEFT OUTER JOIN COURSE CO ON CL.COURSE_ID = CO.COURSE_ID where prof_id='" + id + "'");

            while (rs.next()) {
                String classid = rs.getNString("class_id");
                String classlist = rs.getNString("COURSE_NAME");
                String temp[] = {classid,classlist};
                infoArray.add(temp);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProfessorManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return infoArray;
    }

    public ArrayList getnamelist(String class_id) {
        ArrayList<String[]> infoArray = new ArrayList<>();
        try {
            String sql = "SELECT D.DEPT_NAME, T.STUD_ID, ST.STUD_NAME,T.GRADE "
                    + "FROM CLASS CL right OUTER JOIN TAKES T ON CL.CLASS_ID = T.CLASS_ID "
                    + "left outer join STUDENT ST ON T.STUD_ID = ST.STUD_ID "
                    + "left outer join DEPT D ON D.DEPT_ID = ST.DEPT_ID "
                    + "where T.class_id = '" + class_id + "'";
            rs = st.executeQuery(sql);

            while (rs.next()) {
                String dname = rs.getString("DEPT_NAME");
                String sid = rs.getString("STUD_ID");
                String sname = rs.getString("STUD_NAME");
                String grade = rs.getNString("GRADE");
                String temp[] = {dname, sid, sname, grade};
                infoArray.add(temp);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProfessorManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return infoArray;
    }

    public boolean inputscore(String class_id, ArrayList stud_id, ArrayList grade, int row) {

        for (int count = 0; count < row; count++) {
            if (grade.get(count) != "N") {
                String inputdata = "update TAKES set GRADE='" + grade.get(count) + "' where STUD_ID='" + stud_id.get(count) + "'and CLASS_ID='" + class_id + "'";
                try {
                    st.executeUpdate(inputdata);
                } catch (SQLException ex) {
                    Logger.getLogger(ProfessorManager.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
        return true;
    }
}
