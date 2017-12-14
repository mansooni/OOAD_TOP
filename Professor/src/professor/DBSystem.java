/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package professor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pk-dohyeon
 */
public class DBSystem {
    String url = "jdbc:mysql://113.198.235.232:23306/UIS_TOP";
    String id = "admin";
    String password = "123";
    public Statement st=null;
    Connection conn = null; 
    public DBSystem() {
        try {
            Class.forName("com.mysql.jdbc.Driver");   
            conn = DriverManager.getConnection(url, id, password);
            st = conn.createStatement();
        }catch (ClassNotFoundException ex) {
            Logger.getLogger(DBSystem.class.getName()).log(Level.SEVERE, null, ex);
        }catch (SQLException ex) {
            Logger.getLogger(DBSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("드라이버 연결 성공");
    }
    public void disconnectDB(){
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
