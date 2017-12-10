package Model;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import universityinformationsystem.DBSystem;
import universityinformationsystem.ProjectHelper;


public class ProfessorDB extends DBSystem {

  public String[] addProfessor(String name, String residentno1, String residentno2, String dept) {
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
                            rs = st.executeQuery("select REPLACE(prof_id,'P','') from PROFESSOR");
                             ResultSetMetaData meta = rs.getMetaData();
                             while(rs.next())
                             {
                                   for(int i =1; i<=meta.getColumnCount();i++){
                                   if(count == Integer.parseInt((String)rs.getObject(i))) chk = false;
                                  }
                             }

                             if(chk) id = ProjectHelper.makeStudentId(count,1);
                             else
                             count++;
                     }
                    sql ="insert into PROFESSOR values("
                                     + ProjectHelper.addQuotationStr(id)+",  "
                                     + ProjectHelper.addQuotationStr(name)+", "
                                     + ProjectHelper.addQuotationStr(residentno)+", "
                                     +ProjectHelper.addQuotationStr(deptno)+")";
                            

                  st.executeUpdate(sql);
                  System.out.println("추가");
      } catch (Exception e) {
          e.printStackTrace();
          return null;
      }
      String[] info = {id,name,residentno,dept};
      
      return info;
  }

  public boolean deleteProfessor(String no) {
            String sql=null;
                       sql= "delete from PROFESSOR where prof_id = "+ProjectHelper.addQuotationStr(no); 
            try {
                st.executeUpdate(sql);
            } catch (SQLException ex) {
                ex.printStackTrace(); return false;
            }
      return true;
  }

  public boolean updateProfessor(String no, String name, String residentno1,String residentno2, String dept) {
        if(name.isEmpty()){
           System.out.println("이름을 입력해주세요");
           return false;
       }
       if(!residentno1.matches("[(0-9)]{6}")){
           System.out.println("앞자리 번호 6자리 입력해주세요");
           return false;
       }
       
       
       if(!residentno2.matches("[(0-9)]{7}")){
           System.out.println("뒷자리 번호 6자리 입력해주세요");
           return false;
       }
        String residentno = residentno1 + "-" + residentno2;
        String deptno;
        String sql=null;
        try{
            ResultSet rs = st.executeQuery("select dept_id from DEPT where dept_name = "+ProjectHelper.addQuotationStr(dept));
            rs.next();
            deptno = rs.getString(1);
            
                            sql ="update PROFESSOR set "
                                     + "prof_name = " + ProjectHelper.addQuotationStr(name)+","
                                     +"dept_id = " + ProjectHelper.addQuotationStr(deptno)+","
                                     +"residentno = " + ProjectHelper.addQuotationStr(residentno)+" "
                                     +"where prof_id = "+ProjectHelper.addQuotationStr(no);
            st.executeUpdate(sql);
        }catch(Exception ex){ex.printStackTrace(); return false;}
        return true;
  }

  public ArrayList inquiryProfessor(String no, String name) {
       ArrayList <String[]> infoArray = new ArrayList<>();
     try{
                 ResultSet rs = st.executeQuery("select prof_id, prof_name, residentno, dept_name from PROFESSOR join DEPT using(dept_id) where prof_id like "
                          + ProjectHelper.addLikeStr(no) +  "and prof_name like "
                          + ProjectHelper.addLikeStr(name));
                  while(rs.next()){
                      String prof_id = rs.getString("prof_id");
                      String prof_name = rs.getString("prof_name");
                      String residentno = rs.getString("residentno");
                      String dept_name = rs.getString("dept_name");
                      String temp [] = {prof_id,prof_name,residentno,dept_name};
                      infoArray.add(temp);
                  }
      }catch(Exception e){e.printStackTrace(); return null;}
      return infoArray;
  }
  
    public ArrayList inquiryProfessor_dept(String dept) {
       ArrayList<String> info = new ArrayList<>();
     try{
                 ResultSet rs = st.executeQuery("select prof_id, prof_name, residentno, dept_name from PROFESSOR join DEPT using(dept_id) where dept_name like "
                          + ProjectHelper.addLikeStr(dept));
                  while(rs.next()){
                      String prof_id = rs.getString("prof_id");
                      String prof_name = rs.getString("prof_name");
                      String temp = prof_id + ", " + prof_name;
                      info.add(temp);
                  }
      }catch(Exception e){e.printStackTrace(); return null;}
      return info;
  }
}
