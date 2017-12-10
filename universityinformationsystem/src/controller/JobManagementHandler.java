package controller;


import java.util.Map;
import universityinformationsystem.DBSystem;
import Model.*;
import java.util.ArrayList;

public class JobManagementHandler {
     private StudentDB sd;
     private ProfessorDB pd;
  public JobManagementHandler() {
      sd = new StudentDB();
      pd = new ProfessorDB();
  }

  public String[] addStduent(String name, String residentno1, String residentno2, String dept) {
      return sd.addStudent(name, residentno1, residentno2, dept);
  }

  public String[] addProfessor(String name, String residentno1, String residentno2, String dept) {
      return pd.addProfessor(name, residentno1, residentno2, dept);
  }

  public boolean deleteStudent(String no) {
      return sd.deleteStudent(no);
  }

  public boolean deleteProfessor(String no) {
      return pd.deleteProfessor(no);
  }

  public boolean updateStudent(String no, String name, String residentno1,String residentno2, String dept) {
      if(sd.updateStudent(no, name, residentno1, residentno2, dept))
        return true;
      else return false;
  }

  public boolean updateProfessor(String no, String name, String residentno1, String residentno2, String dept) {
       if(pd.updateProfessor(no, name, residentno1, residentno2, dept))
        return true;
      else return false;
  }

  public ArrayList inquiryStudent(String no, String name) {
     ArrayList<String[]> infoArray = sd.inquiryStudent(no, name);
     return infoArray;
  }

  public ArrayList inquiryProfessor(String no, String name) {
       ArrayList<String[]> infoArray = pd.inquiryProfessor(no, name);
      return infoArray;
  }
}
