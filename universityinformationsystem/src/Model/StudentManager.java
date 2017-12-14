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
import universityinformationsystem.DBSystem;
import universityinformationsystem.ErrorCode;
import universityinformationsystem.ProjectHelper;
import universityinformationsystem.Scoreinfo;

/**
 *
 * @author gawon
 */
public class StudentManager  extends DBSystem {
    String id;
    public StudentManager(String id){
        super();
        this.id = id;
    }

    final double PNUM = 18.0;
    ResultSet rs = null;


    public  ArrayList getOpenClass() {
        try {
            ArrayList <String[]> infoarray = new ArrayList<>();
            rs = st.executeQuery("select dept_id from STUDENT where stud_id = " + ProjectHelper.addQuotationStr(id));
            rs.next();
            String dept_id = rs.getString("dept_id");
            rs = st.executeQuery("select class_id, course_name, credit, dept_name, course_description,prof_name  "
                    + "from CLASS join COURSE  USING(course_id) "
                    + "join DEPT USING(dept_id) "
                    + "join PROFESSOR USING (prof_id) " + "where COURSE.dept_id = " + ProjectHelper.addQuotationStr(dept_id));

            while (rs.next()) {
                String class_id = rs.getString("class_id");
                String course_name = rs.getString("course_name");
                String credit = rs.getString("credit");
                String dept_name = rs.getString("dept_name");
                String course_description = rs.getString("course_description");
                String prof_name = rs.getString("prof_name");
                String[] info = {class_id, course_name, credit, dept_name, course_description,prof_name};
                infoarray.add(info);
            }
            return infoarray;
            
            
        } catch (SQLException ex) {
            Logger.getLogger(StudentManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public ArrayList getMyClass(){
        ArrayList <String[]> infoarray = new ArrayList<>();
        try {
         rs = st.executeQuery("select class_id, course_name, credit, dept_name, course_description,prof_name  "
                    + "from CLASS join COURSE  USING(course_id) "
                    + "join DEPT USING(dept_id) "
                    + "join PROFESSOR USING (prof_id) "
                    + "join TAKES USING(class_id) where stud_id = " + ProjectHelper.addQuotationStr(id));
            while (rs.next()) {
                String class_id = rs.getString("class_id");
                String course_name = rs.getString("course_name");
                String credit = rs.getString("credit");
                String dept_name = rs.getString("dept_name");
                String course_description = rs.getString("course_description");
                String prof_name = rs.getString("prof_name");
                String[] info = {class_id, course_name, credit, dept_name, course_description,prof_name};
                infoarray.add(info);
            }
            return infoarray;
        } catch (SQLException ex) {
            Logger.getLogger(StudentManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public double getStduentCredit(){
                String sql = "select sum(credit) "
                + "FROM TAKES join CLASS USING(class_id) join COURSE USING(course_id)"
                + "WHERE stud_id = " + ProjectHelper.addQuotationStr(id);
        try {
            rs = st.executeQuery(sql);
            rs.next();
            String creditTemp = rs.getString(1);
            if(creditTemp == null) creditTemp = "0";
            return Double.parseDouble(creditTemp);
        } catch (SQLException ex) {
            Logger.getLogger(StudentManager.class.getName()).log(Level.SEVERE, null, ex);
             return 0;
        } 
    }
    public Scoreinfo inquiryScore() {
        Scoreinfo info = new Scoreinfo();
        String sql = "SELECT stud_id, course_name, credit,grade,\n" +
                            "case when grade = 'A' then '4.0'\n" +
                            "when grade = 'B' then '3.0'\n" +
                            "when grade = 'C' then '2.0'\n" +
                            "when grade = 'D' then '1.0'\n" +
                            "when grade = 'F' then '0.0'\n" +
                            "end \"grade_num\"\n" +
                            "FROM TAKES join CLASS USING(class_id) JOIN COURSE USING (course_id) "
                            +"where stud_id = " + ProjectHelper.addQuotationStr(id);
        try{
            rs = st.executeQuery(sql);
            double gradeTemp = 0;
            double Temp = 0;
            while(rs.next()){
                String course_name = rs.getString("course_name");
                String grade = rs.getString("grade");
                String credit = rs.getString("credit");
                String grade_num = rs.getString("grade_num");
                String[] strTemp = {course_name, credit,grade};
                info.infoarray.add(strTemp);
                if(grade_num != null){
                    gradeTemp += Double.parseDouble(credit);
                    Temp += Double.parseDouble(credit) * Double.parseDouble(grade_num);
                }
            }
            info.grade = Temp / gradeTemp; 
            return info;
            
        }catch(SQLException ex){}
            return null;
    }

    public ErrorCode myClassEnrollment(String class_id) {
        String sql;
        sql = "select * from TAKES where class_id = " + ProjectHelper.addQuotationStr(class_id)
                +" and stud_id = " + ProjectHelper.addQuotationStr(id);
        try {
            rs = st.executeQuery(sql);
            if(rs.next()){
                return ErrorCode.OVERLAPENROLL;
            }
            sql = "select count(stud_id),maxenroll from TAKES join CLASS USING(class_id) where class_id = " + ProjectHelper.addQuotationStr(class_id);
            rs = st.executeQuery(sql);
            if(rs.next()){
                int count = Integer.parseInt(rs.getString("count(stud_id)"));
                int maxenroll = Integer.parseInt(rs.getString("maxenroll"));
                if(count >= maxenroll){
                    return ErrorCode.MAXENROLL;
                }
            }
            
            sql = "select credit "
                + "from CLASS join COURSE USING(course_id) "
                + "WHERE class_id = " + ProjectHelper.addQuotationStr(class_id);
            rs = st.executeQuery(sql);
            rs.next();
            String credit = rs.getString(1);
            System.err.println(credit);
                
            double stduetCredit = getStduentCredit();
            double temp = stduetCredit + Double.parseDouble(credit);
            if(temp > 18.0){
                return ErrorCode.CREDITEXCESS;
            }
            sql = "insert into TAKES values("
                +ProjectHelper.addQuotationStr(id)+", "
                +ProjectHelper.addQuotationStr(class_id)+", "
                +ProjectHelper.addQuotationStr("N")+")";
             st.executeUpdate(sql);
             return ErrorCode.NOMAL;
        }  catch (SQLException ex) {
            Logger.getLogger(StudentManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ErrorCode.NORMALERROR;
    }

    public ErrorCode cancel(String class_id) {
        String sql=null;
        sql= "delete from TAKES where class_id = "+ProjectHelper.addQuotationStr(class_id); 
         try {
                st.executeUpdate(sql);
                return ErrorCode.NOMAL;
         }catch (SQLException ex) {
                        while (ex != null) {
                                System.out.println ("SQLState: " + ex.getSQLState());  //Retrieves the SQLState for thisSQLExceptionobject
                                System.out.println ("Message:  " + ex.getMessage());
                                System.out.println ("Vendor:   " + ex.getErrorCode());
                                ex = ex.getNextException();  //Adds anSQLExceptionobject to the end of the chain.
                        }
                        return ErrorCode.NORMALERROR;
            }
    }
}
