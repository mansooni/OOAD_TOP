package lesson;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author hak
 * 2017.11.15
 * 강좌 등록,삭제,수정 기능
 */
public class InsertClass {
        String url = "jdbc:mysql://113.198.235.232:23306/UIS_TOP";
        String id = "admin";
        String password = "123";
        
        String classnum = null; //강좌 번호
        String classname = null; //강좌 이름
        String classstu = null; //담당 학과
        String classpre = null; //강좌 설명
        String classnumb = null; //학점 수
        String classopen = null; //개설 유무확인
        
        Connection conn = null; 
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        int number = 0;
       
        
        //변수 초기화 및 데이터 베이스랑 연결 성공 여부 
        public InsertClass(String classnum, String classname, String classstu, String classpre, String classnumb, String classopen){
            this.classnum = classnum;
            this.classname = classname;
            this.classstu = classstu;
            this.classpre = classpre;
            this.classnumb = classnumb;
            this.classopen = classopen;
             try{
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(url, id, password);
                System.out.println("드라이버 연결 성공");
                JOptionPane.showMessageDialog(null, "드라이버 연결 성공");
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "드라이버 연결 실패");
            }
        }
        
        //강좌 중복 체크 확인
        public boolean getclassnumcheck(String classnum){
            boolean check = true;
            String sql = "select * from classuser where classnum=?";
            try{
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1,classnum);
                rs = pstmt.executeQuery();
                if(rs.next()){ //순차적으로 체크 
                    check = false;
                }
            }catch(Exception e1){
                JOptionPane.showMessageDialog(null, "체크 실패");
            }
            return check;
        }
        //강좌 등록
        public void ClassInsert(String classNum){
            try{
                if(getclassnumcheck(classNum)){ //체크함수로 이동 해서 중복인지 아닌지 체크 
                String sql = "insert into classuser values(?,?,?,?,?,?)";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, classnum); //강좌 번호
                pstmt.setString(2, classname); //강좌 이름
                pstmt.setString(3, classstu); //담당 학과
                pstmt.setString(4, classpre); //강좌 설명
                pstmt.setString(5, classnumb); //학점 수
                pstmt.setString(6, classopen); //강좌 개설
                pstmt.executeUpdate(); 
                JOptionPane.showMessageDialog(null,"강좌 등록 성공");
            }
            }catch(Exception e2){
                //JOptionPane.showMessageDialog(null,"강좌 등록 실패");
                e2.getMessage();
            }finally{
                try{
                    pstmt.close();
                    conn.close();
                    JOptionPane.showMessageDialog(null, "드라이버 연결 해제");
                }catch(SQLException ex1){
                    JOptionPane.showMessageDialog(null, "드라이버 연결 해제 실패");
                }
            }   
        }
        //강좌 수정 
        public void ClassUpdate(){
            try{
                String sql = "update classuser set classname=?,classstu=?,classpre=?,"
                    + "classnumb=?, classopen=? WHERE classnum=? ";        
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1,classname);
                pstmt.setString(2,classstu);
                pstmt.setString(3,classpre);
                pstmt.setString(4,classnumb);
                pstmt.setString(5,classopen);
                pstmt.setString(6,classnum); //수정할 강좌번호 
                number = pstmt.executeUpdate();
                if(number == 0){ //수정이 된것이 없으면.
                    JOptionPane.showMessageDialog(null, "강좌 수정 실패");
                }else{ //있으면 
                    JOptionPane.showMessageDialog(null, "강좌 수정 성공");   
                }
            }catch(Exception e3){
                //JOptionPane.showMessageDialog(null, "드라이버 연결 실패");
                e3.getMessage();
            }finally{
                try{
                    pstmt.close();
                    conn.close();
                    JOptionPane.showMessageDialog(null, "드라이버 연결 해제");
                }catch(SQLException ex2){
                    JOptionPane.showMessageDialog(null, "드라이버 연결 해제 실패");
                }
            }   
        }
        
        //강좌 삭제 
        public void ClassDelete(){
            try{
                String sql = "delete from classuser where classnum=?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1,classnum);
                number = pstmt.executeUpdate();
                if(number == 0){
                    JOptionPane.showMessageDialog(null, "강좌 삭제 실패");
                }else{
                    JOptionPane.showMessageDialog(null, "강좌 삭제 성공");   
                }
            }catch(Exception e4){
                //JOptionPane.showMessageDialog(null, "강좌 삭제 실패");
                e4.getMessage();
            }finally{
                try{
                    pstmt.close();
                    conn.close();
                    JOptionPane.showMessageDialog(null, "드라이버 연결 해제");
                }catch(SQLException ex3){
                    JOptionPane.showMessageDialog(null, "드라이버 연결 해제 실패");
                }
            }   
        }        
}
