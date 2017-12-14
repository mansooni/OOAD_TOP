package controller;

import Model.*;
import java.util.ArrayList;
import universityinformationsystem.ErrorState;


public class ClassManagerHandler {
    private CourseDB co;
    private OpenClassDB cl;
    private ProfessorDB p;

    public ClassManagerHandler() {
        co = new CourseDB();
        cl =  new OpenClassDB();
        p  = new ProfessorDB();
    }
  public ArrayList getCourse(String courseno, String coursename) {
      
      ArrayList infoarray = co.getCourse(courseno,coursename);
      return infoarray;
  }

  public String[] addCourse(String coursename, String description, String credit, String dept) {
      return co.addCourse(coursename, description, credit, dept);

  }

  public ErrorState deleteCourse(String no) {
      return co.deleteCourse(no);
  }

  public ErrorState updateClass(String courseno, String coursename, String description, String credit, String dept) {
      return co.updatecourse(courseno, coursename, description, credit, dept);
  }
public ArrayList inquiryProfessor_dept(String dept){
    return p.inquiryProfessor_dept(dept);
}

  public ArrayList getClassData(String no) {
      return cl.getClassData(no);
  }
  public ErrorState openClass(String courseno, String profno, String minenroll, String maxenroll) {
    return cl.openClass(courseno, profno, minenroll, maxenroll);
  }

}
