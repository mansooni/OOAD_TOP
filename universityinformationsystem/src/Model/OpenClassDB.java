package Model;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import universityinformationsystem.DBSystem;
import universityinformationsystem.ProjectHelper;

public class OpenClassDB extends DBSystem{
    
  public boolean openClass(String courseno, String profno, String minenroll, String maxenroll) {
      if(minenroll.isEmpty()){
           System.out.println("최소인원을 입력해주세요");
           return false;
       }
      if(maxenroll.isEmpty()){
           System.out.println("최대인원을 입력해주세요");
           return false;
       }
        String deptno,id="";
        String sql;
        try {
            int count=1;
                        while(id.equals("")){
                            boolean chk=true;
                            ResultSet rs = st.executeQuery("select class_id from CLASS");
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
                    sql ="insert into CLASS values("
                                     + ProjectHelper.addQuotationStr(id)+",  "
                                     + ProjectHelper.addQuotationStr(courseno)+", "
                                     + ProjectHelper.addQuotationStr(profno)+", "
                                     +ProjectHelper.addQuotationStr(minenroll)+","
                                       +ProjectHelper.addQuotationStr(maxenroll)+")";
                            

                  st.executeUpdate(sql);
                  sql = "update COURSE "
                          + "set chk = 'Y' "
                          + "where course_id = " + ProjectHelper.addQuotationStr(courseno);
                  st.executeUpdate(sql);
                  System.out.println("개설완료");
      } catch (Exception e) {
          e.printStackTrace(); return false;
          
      }
      return true;
  }
  public ArrayList getClassData(String no){
      ArrayList<String[]> infoarray = new ArrayList<>();
      try{
                 ResultSet rs = st.executeQuery("select class_id, course_name, prof_name, minenroll, maxenroll "
                          + "from CLASS JOIN PROFESSOR USING(prof_id) JOIN COURSE USING(course_id)"
                          + "where class_id like "
                          + ProjectHelper.addLikeStr(no));
                  while(rs.next()){
                      String class_id = rs.getString("class_id");
                      String course_name = rs.getString("course_name");
                      String prof_id = rs.getString("prof_name");
                      String minenroll = rs.getString("minenroll");
                      String maxenroll = rs.getString("maxenroll");
                      String temp [] = {class_id, course_name,prof_id,minenroll,maxenroll};
                      infoarray.add(temp);
                  }
      }catch(Exception e){e.printStackTrace(); disconnectDB();return null;}
       return infoarray;
}
}
