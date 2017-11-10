/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;
import java.sql.*;
import java.util.Scanner;

/**
 *
 * @author pk-dohyeon
 */
public class Sample {
            static Statement st;
    /**
     * @param args the command line arguments
     */
    public Sample() throws SQLException, ClassNotFoundException{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/universityinformationsystem?zeroDateTimeBehavior=convertToNull","root","1234");
            System.out.println("Connection");   
            st = conn.createStatement();
    }
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // TODO code application logic here
        Sample sample = new Sample();
        try
        {
            while(true){
                System.out.printf("(1.조회\t2.삭제\t3.수정\t4.등록\t5.나가기)\n");
                Scanner sr = new Scanner(System.in);
                int n = sr.nextInt();
                switch(n){
                    case 1:
                        sample.selectTest("select s.stud_id, s.name, s.resident_number, d.name "
                                + "from student s join dept d using(dept_id)");
                        break;
                    case 2:
                        sample.deleteTest("S007");
                        
                        break;
                    case 3:
                        sample.updateTest("S001","김광현","기계공학과","921212-1521513");
                        break;
                    case 4:
                        sample.registration("김광현","기계공학과","921212-1521513");
                        break;
                    case 5:
                        System.exit(1);
                        break;
                }
                        
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public void registration( String name, String dept, String residentno) throws SQLException{
        String deptno,stud_id="";
        ResultSet rs = st.executeQuery("select dept_id from dept where name = '"+dept+"'");
        rs.next();
        int count=1;
        deptno = (String)rs.getObject(1);
            
            while(stud_id.equals("")){
           boolean chk=true;
           rs = st.executeQuery("select REPLACE(STUD_ID,'S','') from student");
            ResultSetMetaData meta = rs.getMetaData();
            while(rs.next())
            {
                 for(int i =1; i<=meta.getColumnCount();i++){
                     if(count == Integer.parseInt((String)rs.getObject(i))) chk = false;
                 }
            }
            
            if(chk) stud_id = makeStudentId(count);
            else
            count++;
         }
        String sql ="insert into student values("
                         + addQuotationStr(stud_id)+",  "
                         + addQuotationStr(name)+", "
                         + addQuotationStr(residentno)+", "
                         +addQuotationStr(deptno)+")";
        
        System.out.println(sql);
        
        System.out.println("변경 전");
        selectTest("select s.stud_id, s.name, s.resident_number, d.name "
                                + "from student s join dept d using(dept_id)");
      
       st.executeUpdate(sql);
        System.out.println("변경 후");
        selectTest("select s.stud_id, s.name, s.resident_number, d.name "
                                + "from student s join dept d using(dept_id)");
        
    }
    public void selectTest (String temp){
        
        try{
            ResultSet rs = st.executeQuery(temp);
            
            ResultSetMetaData meta = rs.getMetaData();
            while(rs.next())
            {
                 for(int i =1; i<=meta.getColumnCount(); i++)
                    System.out.printf("%10s\t",rs.getObject(i));
                System.out.println();
            }
        }catch(Exception ex){}
    }
    public void updateTest(String studno, String name, String dept, String residentno) throws SQLException{
        
        String deptno;
        ResultSet rs = st.executeQuery("select dept_id from dept where name = '"+dept+"'");
        rs.next();
        deptno = (String)rs.getObject(1);
        String sql ="update student set "
                         + "name = " + addQuotationStr(name)+","
                         +"dept_id = " + addQuotationStr(deptno)+","
                         +"resident_number = " + addQuotationStr(residentno)+" "
                         +"where stud_id = "+addQuotationStr(studno);
        System.out.println(sql);
        System.out.println("select dept_id from dept where name = '"+dept+" :  " + deptno);
        
        System.out.println("변경 전");
        selectTest("select s.stud_id, s.name, s.resident_number, d.name "
                                + "from student s join dept d using(dept_id)");
      
        st.executeUpdate(sql);
        System.out.println("변경 후");
        selectTest("select s.stud_id, s.name, s.resident_number, d.name "
                                + "from student s join dept d using(dept_id)");
    }
    
    public void deleteTest(String studno) throws SQLException{
      
        String sql = "delete from student where student.stud_id = '"+studno+"'";
        System.out.println(studno);
        selectTest("select * from student where student.stud_id = "+addQuotationStr(studno));
      
        System.out.println("삭제 전");
        selectTest("select * from student");
        System.out.println(studno + "삭제");
        st.executeUpdate(sql);
        System.out.println("삭제 후");
        selectTest("select * from student");
    }
    public String addQuotationStr(String temp){ //문자열에 ''붙임
        String tempStr = "'"+temp+"'";
        return tempStr;
    }
    public String makeStudentId(int i){ //숫자를 아이디 형식으로 변환 ex) 4->S004
        String temp="S";
      if(i < 10){
        temp = temp + "00" + i; 
      }else if(i < 100){
        temp = temp + "0" + i;
      }else{
        temp = temp + i;
      }
        return temp;
    }
}
