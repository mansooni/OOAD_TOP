/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pk-dohyeon
 */
public class NewClass {
    public static void main(String args[]) {
     new LoginMainFrame().setVisible(true);
 /*        JobManagementFrame bf;/////////////////////////////////학사관리
         try {
             bf = new JobManagementFrame();
             bf.setVisible(true);
         } catch (SQLException ex) {
             Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
         }*/
       
 /* ClassManagerFrame cf = new ClassManagerFrame();///////////////////////////수업관리
       cf.setVisible(true);*/
     }
       
}
