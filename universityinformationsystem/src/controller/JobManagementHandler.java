package controller;


import Model.*;
import java.util.ArrayList;
import universityinformationsystem.ErrorCode;

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

  public ErrorCode deleteStudent(String no) {
      return sd.deleteStudent(no);
  }

  public ErrorCode deleteProfessor(String no) {
      return pd.deleteProfessor(no);
  }

  public ErrorCode updateStudent(String no, String name, String residentno1,String residentno2, String dept) {
      return sd.updateStudent(no, name, residentno1, residentno2, dept);
  }

  public ErrorCode updateProfessor(String no, String name, String residentno1, String residentno2, String dept) {
       return pd.updateProfessor(no, name, residentno1, residentno2, dept);
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
