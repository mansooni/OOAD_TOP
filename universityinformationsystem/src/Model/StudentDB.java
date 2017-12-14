package Model;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Logger;
import universityinformationsystem.DBSystem;
import universityinformationsystem.ErrorState;
import universityinformationsystem.ProjectHelper;


public class StudentDB extends DBSystem {
  public StudentDB( ) {
      super();
  }

  public String[] addStudent(String name, String residentno1, String residentno2, String dept){
      if(name.isEmpty()){
           System.out.println("이름을 입력해주세요");
           return null;
       }
       if(!residentno1.matches("[(0-9)]{6}")){
           System.out.println("앞자리 번호 6자리 입력해주세요");
           return null;
       }
       
       if(!residentno2.matches("[(0-9)]{7}")){
           System.out.println("뒷자리 번호 6자리 입력해주세요");
           return null;
       }
        String residentno = residentno1 + "-" + residentno2;
        String deptno,id="";
        String sql;
        try {
           ResultSet rs = st.executeQuery("select dept_id from DEPT where dept_name = "+ProjectHelper.addQuotationStr(dept));
            rs.next();
            int count=1;
            deptno = (String)rs.getObject(1);
                        while(id.equals("")){
                            boolean chk=true;
                            rs = st.executeQuery("select REPLACE(stud_id,'S','') from STUDENT");
                             ResultSetMetaData meta = rs.getMetaData();
                             while(rs.next())
                             {
                                   for(int i =1; i<=meta.getColumnCount();i++){
                                   if(count == Integer.parseInt((String)rs.getObject(i))) chk = false;
                                  }
                             }

                             if(chk) id = ProjectHelper.makeStudentId(count,0);
                             else
                             count++;
                     }
                    sql ="insert into STUDENT values("
                                     + ProjectHelper.addQuotationStr(id)+",  "
                                     + ProjectHelper.addQuotationStr(name)+", "
                                     + ProjectHelper.addQuotationStr(residentno)+", "
                                     +ProjectHelper.addQuotationStr(deptno)+","
                                     +ProjectHelper.addQuotationStr("N")+","
                                       +ProjectHelper.addQuotationStr("N")+")";
                            

                  st.executeUpdate(sql);
                  System.out.println("학생 추가");
                  
                  sql ="insert into USER values("
                                     + ProjectHelper.addQuotationStr(id)+",  "
                                     + ProjectHelper.addQuotationStr(residentno2)+")";
                  st.executeUpdate(sql);
                  String[] info = {id,name,residentno,dept};
      
      return info;
      } catch (SQLException ex) {
                         while (ex != null) {
                                System.out.println ("SQLState: " + ex.getSQLState());  //Retrieves the SQLState for thisSQLExceptionobject
                                System.out.println ("Message:  " + ex.getMessage());
                                System.out.println ("Vendor:   " + ex.getErrorCode());
                             if(ex.getErrorCode()  == 1062){
                                   System.err.println("중복된 주민번호가 있습니다. : " + ex.getErrorCode());
                               }
                                ex = ex.getNextException();  //Adds anSQLExceptionobject to the end of the chain.
                        }
          return null;
      }
      
  }

  public ErrorState deleteStudent(String no) {
      String sql=null;
                       sql= "delete from STUDENT where stud_id = "+ProjectHelper.addQuotationStr(no); 
            try {
                st.executeUpdate(sql);
                sql ="delete from USER where id = "
                                     + ProjectHelper.addQuotationStr(no);
                  st.executeUpdate(sql);
                  return ErrorState.NOMAL;
            } catch (SQLException ex) {
                while (ex != null) {
                                System.out.println ("SQLState: " + ex.getSQLState());  //R                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     etrieves the SQLState for thisSQLExceptionobject
                                System.out.println ("Message:  " + ex.getMessage());
                                System.out.println ("Vendor:   " + ex.getErrorCode());
                             if(ex.getErrorCode()  == 1451){
                                   return ErrorState.ENROLLCLASSSTUDENT;
                               }
                                ex = ex.getNextException();  //Adds anSQLExceptionobject to the end of the chain.
                        }
                return ErrorState.NORMALERROR;
            }
  }

  public ErrorState updateStudent(String no, String name, String residentno1,String residentno2, String dept) {
        if(name.isEmpty()){
           System.out.println("이름을 입력해주세요");
           return ErrorState.UPDATEERROR;
       }
       if(!residentno1.matches("[(0-9)]{6}")){
           System.out.println("앞자리 번호 6자리 입력해주세요");
           return ErrorState.UPDATEERROR;
       }
       
       
       if(!residentno2.matches("[(0-9)]{7}")){
           System.out.println("뒷자리 번호 6자리 입력해주세요");
           return ErrorState.UPDATEERROR;
       }
        String residentno = residentno1 + "-" + residentno2;
        String deptno;
        String sql=null;
        try{
            ResultSet rs = st.executeQuery("select dept_id from DEPT where dept_name = "+ProjectHelper.addQuotationStr(dept));
            rs.next();
            deptno = rs.getString(1);
            
            sql ="update STUDENT set "
                                     + "stud_name = " + ProjectHelper.addQuotationStr(name)+","
                                     +"dept_id = " + ProjectHelper.addQuotationStr(deptno)+","
                                     +"residentno = " + ProjectHelper.addQuotationStr(residentno)+" "
                                     +"where stud_id = "+ProjectHelper.addQuotationStr(no);
            st.executeUpdate(sql);
            return ErrorState.NOMAL;
        }catch(SQLException ex){ex.printStackTrace(); return ErrorState.UPDATEERROR;}
  }

  public ArrayList inquiryStudent(String no, String name) {       
      ArrayList <String[]> infoArray = new ArrayList<>();
     try{
                 ResultSet rs = st.executeQuery("select stud_id, stud_name, residentno, dept_name,chk from STUDENT join DEPT using(dept_id) where stud_id like "
                          + ProjectHelper.addLikeStr(no) +  "and stud_name like "
                          + ProjectHelper.addLikeStr(name));
                  while(rs.next()){
                      String stud_id = rs.getString("stud_id");
                      String stud_name = rs.getString("stud_name");
                      String residentno = rs.getString("residentno");
                      String dept_name = rs.getString("dept_name");
                      String chk = rs.getString("chk");
                      String temp [] = {stud_id,stud_name,residentno,dept_name,chk};
                      infoArray.add(temp);
                  }
      }catch(SQLException e){e.printStackTrace(); return null;}
      return infoArray;
  }

}
