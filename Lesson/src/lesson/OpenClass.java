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
 * 2017.11.16
 * 강좌 개설 기능
 */
public class OpenClass {
        String url = "jdbc:mysql://113.198.235.232:23306/UIS_TOP";
        String id = "admin";
        String password = "123";
        
        String classnum = null; //강좌 번호
        String professor = null; //담당 교수
        String maxPeople = null; //최대 인원
        String minPeople = null; //최소 인원        
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        int number = 0;
        
          
        //변수 초기화 및 DB랑 연동        
         public OpenClass(String classnum,String professor,String maxPeople, String minPeople){
            this.classnum = classnum;
            this.professor = professor;
            this.maxPeople = maxPeople;
            this.minPeople = minPeople;
            try{
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(url, id, password);
                System.out.println("드라이버 연결 성공");
                JOptionPane.showMessageDialog(null, "드라이버 연결 성공");
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "드라이버 연결 실패");
            }
        }
        
        //강좌 개설
        public void ClassOpen(){
            try{
                String sql1 = "insert into open values(?,?,?,?)";
                String sql = "update classuser set classopen=? where classnum=?";
                //classopen table에 데이터 넣기
                pstmt = conn.prepareStatement(sql1);
                pstmt.setString(1,classnum);
                pstmt.setString(2,professor);
                pstmt.setString(3,maxPeople);
                pstmt.setString(4,minPeople);                
                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "개설 정보 등록 성공");                
                
                //classuser table column(classopen)에 Y값으로 변경하기.
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, "Y");
                pstmt.setString(2, classnum);
                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "개설 정보 수정 성공");
                JOptionPane.showMessageDialog(null, "강좌 개설 성공");
            }catch(Exception e6){
               // JOptionPane.showMessageDialog(null, "드라이버 연결 실패");
               e6.getMessage();
            }finally{
                try{
                    pstmt.close();
                    conn.close();
                    JOptionPane.showMessageDialog(null, "드라이버 연결 해제");
                }catch(SQLException ex){
                    JOptionPane.showMessageDialog(null, "드라이버 연결 해제 실패");
                }
            }   
        }
}
