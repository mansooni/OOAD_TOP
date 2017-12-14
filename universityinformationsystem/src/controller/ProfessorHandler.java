/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Model.LoginSystem;
import Model.ProfessorManager;
import java.util.ArrayList;
import universityinformationsystem.LoginInfo;
/**
 *
 * @author gawon
 */
public class ProfessorHandler {
    String id;
    private ProfessorManager pm;

    
    public ProfessorHandler(String id) {
        this.id = id;
        this.pm = new ProfessorManager(id);
    }


    public ArrayList getAttendance(){
        return pm.getAttendance(id);
    }
    
    public ArrayList getnamelist(String class_id){
        return pm.getnamelist(class_id);
    }
    
    public boolean inputscore(String class_id, ArrayList stud_id, ArrayList grade, int row){
        return pm.inputscore(class_id, stud_id, grade, row);
    }
}
