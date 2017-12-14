/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Model.StudentManager;
import java.util.ArrayList;
import universityinformationsystem.ErrorCode;
import universityinformationsystem.Scoreinfo;

/**
 *
 * @author pk-dohyeon
 */
public class StudentHandler{
    String id;
    StudentManager sm;
    public StudentHandler(String id) {
        this.id = id;
        sm = new StudentManager(id);
    }
    
    public ArrayList getOpenClass(){
        return sm.getOpenClass();
    }
    public ArrayList getMyClass(){
        return sm.getMyClass();
    }
     public ErrorCode myClassEnrollment(String class_id){
         return sm.myClassEnrollment(class_id);
     }
     public double getStduentCredit(){
        return sm.getStduentCredit();
    }
        public Scoreinfo inquiryScore() {
         return sm.inquiryScore();
        }
     public ErrorCode cancle(String class_id){
         return sm.cancel(class_id);
     }
}
