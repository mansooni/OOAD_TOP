/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import controller.*;
import static java.lang.System.exit;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import universityinformationsystem.ErrorState;

/**
 *
 * @author pk-dohyeon
 */
public class JobManagementFrame extends javax.swing.JFrame {
    JobManagementHandler jh;
    private String stud_colNames[]={"학번","이름","주민번호","학과"};
    private String prof_colNames[]={"교수번호","이름","주민번호","학과"};
    private DefaultTableModel studModel, profModel;
    private String no=null,name;
    private int row;
    private String residentno[];
    String id;
    /**
     * Creates new form BachelorManageementHandler
     * @throws java.sql.SQLException
     */
    public JobManagementFrame(String id) throws SQLException {
        this.id = id;
        studModel = new DefaultTableModel(stud_colNames,0){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        profModel = new DefaultTableModel(prof_colNames,0){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        initComponents();
            jh = new JobManagementHandler();
            ArrayList <String[]> infoArray;
        infoArray = jh.inquiryStudent("","");
        for(String[] s: infoArray)
            studModel.addRow(s);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tap_Bachelor = new javax.swing.JTabbedPane();
        studentPanel = new javax.swing.JPanel();
        jLabel_no = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable_Student = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jTextField_Sname = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField_Sresidentno1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField_Sresidentno2 = new javax.swing.JTextField();
        jComboBox_Sdept = new javax.swing.JComboBox<>();
        jButton_Sremove = new javax.swing.JButton();
        jButton_Sadd = new javax.swing.JButton();
        jButton_Supdate = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField_Sino = new javax.swing.JTextField();
        jButton_Sinquiry = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextField_Siname = new javax.swing.JTextField();
        jButton_close = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        ProfessorPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_Professor = new javax.swing.JTable();
        jLabel_ = new javax.swing.JLabel();
        jTextField_Pname = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField_Presidentno1 = new javax.swing.JTextField();
        jComboBox_Pdept = new javax.swing.JComboBox<>();
        jButton_Pdelete = new javax.swing.JButton();
        jButton_Padd = new javax.swing.JButton();
        jButton_Pupdate = new javax.swing.JButton();
        jButton_Pclose = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jTextField_Presidentno2 = new javax.swing.JTextField();
        jButton_Pinquiry = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jTextField_Pino = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextField_Piname = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tap_Bachelor.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tap_BachelorStateChanged(evt);
            }
        });

        jTable_Student.setModel(studModel);
        jTable_Student.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_StudentMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable_Student);
        jTable_Student.getAccessibleContext().setAccessibleName("");

        jLabel4.setText("이름");

        jLabel5.setText("주민번호");

        jLabel3.setText("-");

        jComboBox_Sdept.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "전산학과", "전자공학과", "화학공학과", "기계공학과", "항공우주공학과" }));

        jButton_Sremove.setText("삭제");
        jButton_Sremove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SremoveActionPerformed(evt);
            }
        });

        jButton_Sadd.setText("등록");
        jButton_Sadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SaddActionPerformed(evt);
            }
        });

        jButton_Supdate.setText("수정");
        jButton_Supdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SupdateActionPerformed(evt);
            }
        });

        jLabel1.setText("번호");

        jButton_Sinquiry.setText("조회");
        jButton_Sinquiry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SinquiryActionPerformed(evt);
            }
        });

        jLabel2.setText("이름");

        jButton_close.setText("닫기");
        jButton_close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_closeActionPerformed(evt);
            }
        });

        jButton1.setText("암호변경");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout studentPanelLayout = new javax.swing.GroupLayout(studentPanel);
        studentPanel.setLayout(studentPanelLayout);
        studentPanelLayout.setHorizontalGroup(
            studentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(studentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(studentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, studentPanelLayout.createSequentialGroup()
                        .addComponent(jLabel_no)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3)
                        .addGap(5, 5, 5))
                    .addGroup(studentPanelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_Sino, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_Siname, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton_Sinquiry))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, studentPanelLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_Sname, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_Sresidentno1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_Sresidentno2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                        .addComponent(jComboBox_Sdept, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton_Sremove)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_Sadd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_Supdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_close))
                    .addGroup(studentPanelLayout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        studentPanelLayout.setVerticalGroup(
            studentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(studentPanelLayout.createSequentialGroup()
                .addGroup(studentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField_Sino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField_Siname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Sinquiry))
                .addGap(22, 22, 22)
                .addGroup(studentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_no)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(25, 25, 25)
                .addGroup(studentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, studentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jTextField_Sresidentno1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField_Sresidentno2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4)
                        .addComponent(jTextField_Sname))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, studentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton_close)
                        .addComponent(jButton_Supdate)
                        .addComponent(jButton_Sadd)
                        .addComponent(jButton_Sremove)
                        .addComponent(jComboBox_Sdept, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        tap_Bachelor.addTab("학생", studentPanel);

        jTable_Professor.setModel(profModel);
        jTable_Professor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_ProfessorMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable_Professor);

        jLabel_.setText("이름");

        jLabel7.setText("주민번호");

        jComboBox_Pdept.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "전산학과", "전자공학과", "화학공학과", "기계공학과", "항공우주공학과" }));

        jButton_Pdelete.setText("삭제");
        jButton_Pdelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_PdeleteActionPerformed(evt);
            }
        });

        jButton_Padd.setText("등록");
        jButton_Padd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_PaddActionPerformed(evt);
            }
        });

        jButton_Pupdate.setText("수정");
        jButton_Pupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_PupdateActionPerformed(evt);
            }
        });

        jButton_Pclose.setText("닫기");
        jButton_Pclose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_PcloseActionPerformed(evt);
            }
        });

        jLabel8.setText("-");

        jButton_Pinquiry.setText("조회");
        jButton_Pinquiry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_PinquiryActionPerformed(evt);
            }
        });

        jLabel9.setText("번호");

        jLabel10.setText("이름");

        javax.swing.GroupLayout ProfessorPanelLayout = new javax.swing.GroupLayout(ProfessorPanel);
        ProfessorPanel.setLayout(ProfessorPanelLayout);
        ProfessorPanelLayout.setHorizontalGroup(
            ProfessorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProfessorPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ProfessorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ProfessorPanelLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_Pino, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_Piname, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton_Pinquiry))
                    .addGroup(ProfessorPanelLayout.createSequentialGroup()
                        .addComponent(jLabel_)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_Pname, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_Presidentno1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_Presidentno2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                        .addComponent(jComboBox_Pdept, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton_Pdelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_Padd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_Pupdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_Pclose))
                    .addComponent(jScrollPane2)))
        );
        ProfessorPanelLayout.setVerticalGroup(
            ProfessorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProfessorPanelLayout.createSequentialGroup()
                .addGroup(ProfessorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTextField_Pino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jTextField_Piname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Pinquiry))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(ProfessorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(ProfessorPanelLayout.createSequentialGroup()
                        .addGroup(ProfessorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton_Pclose)
                            .addComponent(jButton_Pupdate)
                            .addComponent(jButton_Padd)
                            .addComponent(jButton_Pdelete)
                            .addComponent(jComboBox_Pdept, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1))
                    .addGroup(ProfessorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField_Pname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel_)
                        .addComponent(jLabel7)
                        .addComponent(jTextField_Presidentno1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)
                        .addComponent(jTextField_Presidentno2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        tap_Bachelor.addTab("교수", ProfessorPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tap_Bachelor)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tap_Bachelor))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tap_BachelorStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tap_BachelorStateChanged
        // TODO add your handling code here:
        if(tap_Bachelor.getSelectedIndex() == 1){
            profModel = new DefaultTableModel(prof_colNames,0){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        ArrayList <String[]> infoArray;
        infoArray = jh.inquiryProfessor("","");
        for(String[] s: infoArray)
            profModel.addRow(s);
        jTable_Professor.setModel(profModel);
        }
    }//GEN-LAST:event_tap_BachelorStateChanged

    private void jButton_PinquiryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_PinquiryActionPerformed
        // TODO add your handling code here:
        profModel = new DefaultTableModel(prof_colNames,0){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        ArrayList <String[]> infoArray;
        infoArray = jh.inquiryProfessor(jTextField_Pino.getText(),jTextField_Piname.getText());
        for(String[] s: infoArray)
            profModel.addRow(s);
        jTable_Professor.setModel(profModel);
    }//GEN-LAST:event_jButton_PinquiryActionPerformed

    private void jButton_PcloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_PcloseActionPerformed
        // TODO add your handling code here:
        exit(1);
    }//GEN-LAST:event_jButton_PcloseActionPerformed

    private void jTable_ProfessorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_ProfessorMouseClicked
        // TODO add your handling code here:
        row = jTable_Professor.getSelectedRow();
        no = (String)jTable_Professor.getValueAt(row, 0);
        name = (String)jTable_Professor.getValueAt(row, 1);
        String temp = (String)jTable_Professor.getValueAt(row, 2);
        residentno = temp.split("-");

        jTextField_Pname.setText(name);
        jTextField_Presidentno1.setText(residentno[0]);
        jTextField_Presidentno2.setText(residentno[1]);
    }//GEN-LAST:event_jTable_ProfessorMouseClicked

    private void jButton_closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_closeActionPerformed
        // TODO add your handling code here:
        exit(1);
    }//GEN-LAST:event_jButton_closeActionPerformed

    private void jButton_SinquiryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SinquiryActionPerformed
        studModel = new DefaultTableModel(stud_colNames,0){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        ArrayList <String[]> infoArray;
        infoArray = jh.inquiryStudent(jTextField_Sino.getText(),jTextField_Siname.getText());
        for(String[] s: infoArray)
            studModel.addRow(s);
        jTable_Student.setModel(studModel);

    }//GEN-LAST:event_jButton_SinquiryActionPerformed

    private void jButton_SupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SupdateActionPerformed

    ErrorState e =jh.updateStudent(no, jTextField_Sname.getText(),jTextField_Sresidentno1.getText(),jTextField_Sresidentno2.getText(),(String)jComboBox_Sdept.getSelectedItem());
   if(e == ErrorState.NOMAL) {
        String temp = jTextField_Sresidentno1.getText() + "-" + jTextField_Sresidentno2.getText();
        studModel.setValueAt(no, row, 0);
        studModel.setValueAt(name, row, 1);
        studModel.setValueAt(temp, row, 2);
        studModel.setValueAt((String)jComboBox_Sdept.getSelectedItem(), row, 3);
    }
   else JOptionPane.showMessageDialog(null, e.getDesc());
    }//GEN-LAST:event_jButton_SupdateActionPerformed

    private void jButton_SaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SaddActionPerformed

        String info[] = jh.addStduent(jTextField_Sname.getText(),jTextField_Sresidentno1.getText(),jTextField_Sresidentno2.getText(),(String)jComboBox_Sdept.getSelectedItem());
        if(info != null){
            studModel.addRow(info);
        }
        else JOptionPane.showMessageDialog(null, "등록오류");
        
    }//GEN-LAST:event_jButton_SaddActionPerformed

    private void jButton_SremoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SremoveActionPerformed

            ErrorState e = jh.deleteStudent(no);
            if(e == ErrorState.NOMAL) 
                studModel.removeRow(row);
            else JOptionPane.showMessageDialog(null, e.getDesc());
    }//GEN-LAST:event_jButton_SremoveActionPerformed

    private void jTable_StudentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_StudentMouseClicked
        // TODO add your handling code here:
        //jTable_Student.get
        row = jTable_Student.getSelectedRow();
        int col = jTable_Student.getSelectedColumn();
        no = (String)jTable_Student.getValueAt(row, 0);
        name = (String)jTable_Student.getValueAt(row, 1);
        String temp = (String)jTable_Student.getValueAt(row, 2);
        residentno = temp.split("-");

        jTextField_Sname.setText(name);
        jTextField_Sresidentno1.setText(residentno[0]);
        jTextField_Sresidentno2.setText(residentno[1]);
    }//GEN-LAST:event_jTable_StudentMouseClicked

    private void jButton_PdeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_PdeleteActionPerformed
                    
        ErrorState e = jh.deleteProfessor(no);
            if(e == ErrorState.NOMAL) 
                profModel.removeRow(row);
            else JOptionPane.showMessageDialog(null, e.getDesc());
    }//GEN-LAST:event_jButton_PdeleteActionPerformed

    private void jButton_PaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_PaddActionPerformed
        // TODO add your handling code here:
                String info[] = jh.addProfessor(jTextField_Pname.getText(),jTextField_Presidentno1.getText(),jTextField_Presidentno2.getText(),(String)jComboBox_Pdept.getSelectedItem());
        if(info != null){
            profModel.addRow(info);
        }
        else JOptionPane.showMessageDialog(null, "등록오류");
    }//GEN-LAST:event_jButton_PaddActionPerformed

    private void jButton_PupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_PupdateActionPerformed
        // TODO add your handling code here:
        ErrorState e = jh.updateProfessor(no, jTextField_Pname.getText(),jTextField_Presidentno1.getText(),jTextField_Presidentno2.getText(),(String)jComboBox_Pdept.getSelectedItem());
        if(e == ErrorState.NOMAL){
        String temp = jTextField_Presidentno1.getText() + "-" + jTextField_Presidentno2.getText();
        profModel.setValueAt(no, row, 0);
        profModel.setValueAt(jTextField_Pname.getText(), row, 1);
        profModel.setValueAt(temp, row, 2);
        profModel.setValueAt((String)jComboBox_Pdept.getSelectedItem(), row, 3);
       }
        else JOptionPane.showMessageDialog(null, e.getDesc());
    }//GEN-LAST:event_jButton_PupdateActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new UpdatePwFrame(id);
    }//GEN-LAST:event_jButton1ActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ProfessorPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton_Padd;
    private javax.swing.JButton jButton_Pclose;
    private javax.swing.JButton jButton_Pdelete;
    private javax.swing.JButton jButton_Pinquiry;
    private javax.swing.JButton jButton_Pupdate;
    private javax.swing.JButton jButton_Sadd;
    private javax.swing.JButton jButton_Sinquiry;
    private javax.swing.JButton jButton_Sremove;
    private javax.swing.JButton jButton_Supdate;
    private javax.swing.JButton jButton_close;
    private javax.swing.JComboBox<String> jComboBox_Pdept;
    private javax.swing.JComboBox<String> jComboBox_Sdept;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_;
    private javax.swing.JLabel jLabel_no;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    public javax.swing.JTable jTable_Professor;
    public javax.swing.JTable jTable_Student;
    private javax.swing.JTextField jTextField_Piname;
    private javax.swing.JTextField jTextField_Pino;
    private javax.swing.JTextField jTextField_Pname;
    private javax.swing.JTextField jTextField_Presidentno1;
    private javax.swing.JTextField jTextField_Presidentno2;
    private javax.swing.JTextField jTextField_Siname;
    private javax.swing.JTextField jTextField_Sino;
    private javax.swing.JTextField jTextField_Sname;
    private javax.swing.JTextField jTextField_Sresidentno1;
    private javax.swing.JTextField jTextField_Sresidentno2;
    private javax.swing.JPanel studentPanel;
    private javax.swing.JTabbedPane tap_Bachelor;
    // End of variables declaration//GEN-END:variables
}
