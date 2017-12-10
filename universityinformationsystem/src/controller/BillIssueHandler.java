package controller;

import Model.BillIssueSystem;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;

public class BillIssueHandler {
private BillIssueSystem bs;
    public BillIssueHandler() {
        bs = new BillIssueSystem();
    }

  public boolean billIssue(String stud_id) {
      return bs.billIssue(stud_id);
  }
  public ArrayList getNoBillIssueStudent(){
      return bs.getNoBillIssueStudent();
  }

}
