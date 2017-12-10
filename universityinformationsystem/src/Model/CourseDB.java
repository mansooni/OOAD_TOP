package Model;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import universityinformationsystem.DBSystem;
import universityinformationsystem.ProjectHelper;

public class CourseDB extends DBSystem{
  public ArrayList getCourse(String courseno, String coursename) {
     ArrayList <String[]> infoArray = new ArrayList<>();
     try{
                 ResultSet rs = st.executeQuery("select course_id, course_name, course_description, credit, dept_name, chk"
                          + " from COURSE join DEPT using(dept_id)"
                          + " where course_id like "
                          + ProjectHelper.addLikeStr(courseno) +  "and course_name like "
                          + ProjectHelper.addLikeStr(coursename));
                  while(rs.next()){
                      String course_id = rs.getString("course_id");
                      String course_name = rs.getString("course_name");
                      String course_description = rs.getString("course_description");
                      String credit = rs.getString("credit");
                      String dept_name = rs.getString("dept_name");
                      String chk = rs.getString("chk");
                      String temp [] = {course_id,course_name,course_description,credit,dept_name,chk};
                      infoArray.add(temp);
                  }
      }catch(Exception e){e.printStackTrace(); disconnectDB();return null;}
      return infoArray;
  }

  public String[] addCourse(String coursename, String description, String credit, String dept) {
      String deptno=null,id="";
      String sql=null;
      if(coursename.isEmpty()){
           System.out.println("이름을 입력해주세요");
           return null;
       }
      try{
           ResultSet rs = st.executeQuery("select dept_id from DEPT where dept_name = "+ProjectHelper.addQuotationStr(dept));
            rs.next();
            int count=1;
            deptno = (String)rs.getObject(1);
                        while(id.equals("")){
                            boolean chk=true;
                            rs = st.executeQuery("select course_id from COURSE");
                             ResultSetMetaData meta = rs.getMetaData();
                             while(rs.next())
                             {
                                   for(int i =1; i<=meta.getColumnCount();i++){
                                   if(count == Integer.parseInt((String)rs.getObject(i))) chk = false;
                                  }
                             }

                             if(chk) id = Integer.toString(count);
                             else
                             count++;
                     }
                    sql ="insert into COURSE values("
                                     + ProjectHelper.addQuotationStr(id)+",  "
                                     + ProjectHelper.addQuotationStr(coursename)+", "
                                     + ProjectHelper.addQuotationStr(description)+", "
                                     +ProjectHelper.addQuotationStr(credit)+","
                                     +ProjectHelper.addQuotationStr("N")+","
                                     +ProjectHelper.addQuotationStr(deptno)+")";
                            

                  st.executeUpdate(sql);
                  System.out.println("추가");
      } catch (Exception e) {
          e.printStackTrace();
          disconnectDB();
          return null;
      }
      String[] info = {id,coursename,description,credit,dept,"N"};
      return info;
      
  }

  public boolean deleteCourse(String no) {
      String sql=null;
                       sql= "delete from COURSE where course_id = "+ProjectHelper.addQuotationStr(no); 
            try {
                st.executeUpdate(sql);
            } catch (SQLException ex) {
                ex.printStackTrace();disconnectDB(); return false;
            }
       return true;
  }

  public boolean updatecourse(String courseno, String coursename, String description, String credit, String dept) {
      if(coursename.isEmpty()){
           System.out.println("이름을 입력해주세요");
           return false;
       }
        String deptno;
        String sql=null;
        try{
            ResultSet rs = st.executeQuery("select dept_id from DEPT where dept_name = "+ProjectHelper.addQuotationStr(dept));
            rs.next();
            deptno = rs.getString(1);
            
            sql ="update COURSE set "
                                     + "course_name = " + ProjectHelper.addQuotationStr(coursename)+","
                                     + "course_description = " + ProjectHelper.addQuotationStr(description)+","
                                     +"credit = " + ProjectHelper.addQuotationStr(credit)+", "
                                     +"dept_id = " + ProjectHelper.addQuotationStr(deptno)+" "
                                     
                                     +"where course_id = "+ProjectHelper.addQuotationStr(courseno);
            st.executeUpdate(sql);
        }catch(Exception ex){ex.printStackTrace(); return false;}
        return true;
  }
}
