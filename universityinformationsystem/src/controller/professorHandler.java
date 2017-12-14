/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Model.LoginSystem;
import Model.professorManager;
import View.LoginMainFrame;
import java.util.ArrayList;
import universityinformationsystem.LoginInfo;
/**
 *
 * @author gawon
 */
public class professorHandler {
    LoginInfo li ;
    private professorManager pm;

    
    public professorHandler() {
        this.pm = new professorManager();
    }


    public ArrayList getAttendance(){
        return pm.getAttendance(li.id);
    }
    
    public ArrayList getnamelist(String class_id){
        return pm.getnamelist(class_id);
    }
    
    public boolean inputscore(String class_id, String[] stud_id, String[] grade, int row){
        return pm.inputscore(class_id, stud_id, grade, row);
    }
}
