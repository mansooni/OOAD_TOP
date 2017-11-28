/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author hak
 * 2017.11.27
 * 강좌 검색 기능 
 */
public class SearchClass {
        String url = "jdbc:mysql://113.198.235.232:23306/UIS_TOP";
        String id = "admin";
        String password = "123";
        
        String classnum = null;
        String classname = null;
        String classstu = null;
        String classpre = null;
        String classnumb = null;
        String classopen = null;
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        //초기화 
        public SearchClass(String classnum,String classname, String classstu, String classpre, String classnumb, String classopen){
            this.classnum = classnum;
            this.classname = classname;
            this.classstu = classstu;
            this.classpre = classpre;
            this.classnumb = classnumb;
            this.classopen = classopen;
        }
        
        public String getclassnum(){
            return classnum;
        }
        
        public String getclassname(){
            return classname;
        }
        
        public String getclassstu(){
            return classstu;
        }
        
        public String getclasspre(){
            return classpre;
        }
        
        public String getclassnumb(){
            return classnumb;
        }
        
        public String getclassopen(){
            return classopen;
        }
      /*  
        public SearchClass(String classnum){
            this.classnum = classnum;
            try{
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(url, id, password);
                System.out.println("드라이버 연결 성공");
                JOptionPane.showMessageDialog(null, "드라이버 연결 성공");
            }catch(Exception e10){
                JOptionPane.showMessageDialog(null, "드라이버 연결 실패");
            }
        }
        
          //강좌 검색
        public void ClassSearch(){
            try{
                String sql = "select * from classuser where classnum=?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, classnum);
                rs = pstmt.executeQuery();
                if(rs == null){
                    JOptionPane.showMessageDialog(null, "검색 내용이 없습니다.");
                    System.out.println("검색 내용을 찾을 수 없습니다");
                }
                while(rs.next()){
                    classnum = rs.getString("classnum");
                    System.out.println("");
                }
                JOptionPane.showMessageDialog(null, "강좌 검색 성공");
            }catch(Exception e5){
                JOptionPane.showMessageDialog(null, "강좌 검색 실패");
            }finally{
                try{
                    pstmt.close();
                    conn.close();
                    JOptionPane.showMessageDialog(null, "드라이버 연결 해제");
                }catch(SQLException ex4){
                    JOptionPane.showMessageDialog(null, "드라이버 연결 해제 실패");
                }
            }   
        }*/
    
}
