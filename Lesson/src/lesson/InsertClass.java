
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
 * 2017.11.15
 * 강좌 등록, 삭제, 수정 기능
 */
public class InsertClass {
    String url = "jdbc:mysql://113.198.235.232:23306/UIS_TOP";
    String id = "admin";
    String password = "123";
    
    String classnum=null; //강좌 번호
    String classname=null; //강좌 이름
    String classstu=null; //담당 학과
    String classpre=null; //강좌 설명
    String classnumb=null; //학점
    String classopen=null; //개설 유무
    
    Connection conn = null;
    PreparedStatement pstmt = null;
    Statement stmt = null;
    ResultSet rs = null;
    int number=0;
    
    //변수 초기화 및 DB 연동
    public InsertClass(String classnum, String classname, String classstu, String classpre, String classnumb, String classopen){
        this.classnum=classnum;
        this.classname=classname;
        this.classstu=classstu;
        this.classpre=classpre;
        this.classnumb=classnumb;
        this.classopen=classopen;
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, id, password);
            System.out.println("드라이버 연결 성공");
            JOptionPane.showMessageDialog(null, "드라이버 연결 성공");
        }catch(Exception e3){
            JOptionPane.showMessageDialog(null, "드라이버 연결 실패");
        }
    }
    
    //강좌 중복 체크 확인
    public boolean getClassNumCheck(String classNum){
        boolean check = true;
        String sql = "select * from classuser where classnum=?";
        try{
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, classNum);
            rs = pstmt.executeQuery();
            if(rs.next()){ //순차적ㅇ로 체크한다.
                check = false;
            }
        }catch(Exception e4){
            //JOptionPane.showMessageDialog(null, "체크 실패");
            System.out.println("체크 실패");
        }
        return check;
    }
    
    //강좌 등록
    public void ClassInsert(String classNum){
        try{
            if(getClassNumCheck(classNum)){//체크함수 이동 중복 확인
                String sql = "insert into classuser values(?,?,?,?,?,?)";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, classnum);
                pstmt.setString(2, classname);
                pstmt.setString(3, classstu);
                pstmt.setString(4, classpre);
                pstmt.setString(5, classnumb);
                pstmt.setString(6, classopen);
                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "강좌 등록 성공");
            }
        }catch(Exception e5){
                JOptionPane.showMessageDialog(null, "강좌 등록 실패");
        }finally{
            try{
                pstmt.close();
                conn.close();
                //JOptionPane.showMessageDialog(null, "드라이버 연결 해제");
                System.out.println("드라이버 연결 해제");
            }catch(SQLException ex){
                //JOptionPane.showMessageDialog(null, "드라이버 연결 해제 실패");
                System.out.println("드라이버 연결 해제 실패");
            }
        }
    }
    //강좌 수정
    public void ClassUpdate(){
        try{
            String sql = "update classuser set classname=?,classstu=?,classpre=?,"
                    + "classnumb=?, classopen=? where classnum=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, classname);
            pstmt.setString(2, classstu);
            pstmt.setString(3, classpre);
            pstmt.setString(4, classnumb);
            pstmt.setString(5, classopen);
            pstmt.setString(6, classnum);
            number = pstmt.executeUpdate();
            if(number == 0){ //수정된것이 있으면
                JOptionPane.showMessageDialog(null, "강좌 수정 실패");
            }else{
                JOptionPane.showMessageDialog(null, "강좌 수정 성공");
            }
        }catch(Exception e6){
            JOptionPane.showMessageDialog(null, "드라이버 연결 실패");
        }finally{
            try{
                pstmt.close();
                conn.close();
                //JOptionPane.showMessageDialog(null, "드라이버 연결 해제");
                System.out.println("드라이버 연결 해제");
            }catch(SQLException ex){
    //                JOptionPane.showMessageDialog(null, "드라이버 연결 해제 실패");
                    System.out.println("드라이버 연결 해제 실패");
            }
        }
    }
    
    //강좌 삭제 
    public void ClassDelete(){
        try{
            String sql = "delete from classuser where classnum=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, classnum);
            number = pstmt.executeUpdate();
            if(number == 0){
                JOptionPane.showMessageDialog(null, "강좌 삭제 실패");
            }else{
                JOptionPane.showMessageDialog(null, "강좌 삭제 성공");
            }
        }catch(Exception e7){
            JOptionPane.showMessageDialog(null, "드라이버 연결 실패");
        }finally{
            try{
                pstmt.close();
                conn.close();
                //JOptionPane.showMessageDialog(null, "드라이버 연결 해제");
                System.out.println("드라이버 연결 해제");
            }catch(SQLException ex){
                //JOptionPane.showMessageDialog(null, "드라이버 연결 해제 실패");
                System.out.println("드라이버 연결 해제 실패");
            }
        }
    }
}
