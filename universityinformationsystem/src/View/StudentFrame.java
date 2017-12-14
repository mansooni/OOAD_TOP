/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import javax.swing.JOptionPane;
import Model.StudentManager;
import controller.StudentHandler;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import universityinformationsystem.ErrorCode;
import universityinformationsystem.Scoreinfo;

/**
 *
 * @author gawon
 */
public class StudentFrame extends javax.swing.JFrame {
    StudentHandler cmh;
    String id;
    double curCredit;
    private String class_colNames[]={"강좌번호","강좌이름","학점","담당학과","과목개요","교수"};
    private String grade_colNames[] = {"과목", "학점", "성적"};
  
    public DefaultTableModel class_Model = new DefaultTableModel(class_colNames,0){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
    public DefaultTableModel myclass_Model = new DefaultTableModel(class_colNames,0){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
    
     public DefaultTableModel grade_Model = new DefaultTableModel(grade_colNames,0){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
    /**
     * Creates new form StudentFrame
     */
    public StudentFrame(String id) {
        this.id = id;
        cmh = new StudentHandler(id);
        initComponents();  
        ArrayList <String[]> infoarray = cmh.getOpenClass();
        for(String[] s:infoarray){
            class_Model.addRow(s);
        }
        infoarray = cmh.getMyClass();
        for(String[]s : infoarray){
            myclass_Model.addRow(s);
        }
        curCredit = cmh.getStduentCredit();
        now.setText(Double.toString(curCredit));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Class = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        now = new javax.swing.JLabel();
        possible = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable_MyClass = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane1StateChanged(evt);
            }
        });

        jPanel1.setMaximumSize(new java.awt.Dimension(529, 389));
        jPanel1.setPreferredSize(new java.awt.Dimension(529, 389));

        jTable_Class.setModel(class_Model);
        jTable_Class.setToolTipText("");
        jTable_Class.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable_Class.setSelectionBackground(new java.awt.Color(255, 204, 204));
        jTable_Class.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable_Class.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_ClassMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_Class);

        jLabel1.setFont(new java.awt.Font("굴림", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("현재 신청 학점");

        now.setText("0");

        possible.setText("18");

        jLabel4.setFont(new java.awt.Font("굴림", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("신청 가능 학점");

        jLabel5.setForeground(new java.awt.Color(153, 153, 153));
        jLabel5.setText("수강을 원하는 강좌를 더블클릭 하세요");

        jLabel6.setFont(new java.awt.Font("굴림", 1, 18)); // NOI18N
        jLabel6.setText("[ 수강 신청 강좌 목록 ]");

        jLabel11.setFont(new java.awt.Font("굴림", 1, 18)); // NOI18N
        jLabel11.setText("[ 내 수강 신청 강좌 목록 ]");

        jTable_MyClass.setModel(myclass_Model);
        jTable_MyClass.setSelectionBackground(new java.awt.Color(255, 153, 153));
        jTable_MyClass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_MyClassMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTable_MyClass);

        jLabel12.setForeground(new java.awt.Color(153, 153, 153));
        jLabel12.setText("수강취소를 원하는 강좌를 더블클릭 하세요");

        jButton1.setText("신청 완료");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane4)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(now)
                        .addGap(34, 34, 34)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(possible)
                        .addGap(21, 21, 21))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(294, 294, 294)
                                .addComponent(jLabel5))
                            .addComponent(jLabel12))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(now)
                    .addComponent(jLabel4)
                    .addComponent(possible))
                .addGap(9, 9, 9)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("수강신청", jPanel1);

        jTable2.setModel(grade_Model);
        jScrollPane2.setViewportView(jTable2);

        jLabel7.setFont(new java.awt.Font("굴림", 1, 14)); // NOI18N
        jLabel7.setText("평균 학점");

        jLabel8.setText("0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(jLabel7))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 658, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addContainerGap(174, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("성적조회", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable_ClassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_ClassMouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount()==2){
            ErrorCode e;
            int row = jTable_Class.getSelectedRow();
            String class_id = (String)jTable_Class.getValueAt(row, 0);
            e = cmh.myClassEnrollment(class_id);
           if(e == ErrorCode.NOMAL){
               Object[] temp = {jTable_Class.getValueAt(row, 0),jTable_Class.getValueAt(row, 1),jTable_Class.getValueAt(row, 2),jTable_Class.getValueAt(row, 3),jTable_Class.getValueAt(row, 4)
               ,jTable_Class.getValueAt(row, 5)};
              myclass_Model.addRow(temp);
                now.setText(Double.toString(cmh.getStduentCredit()));
           }
           else JOptionPane.showMessageDialog(null, e.getDesc());
        }
    }//GEN-LAST:event_jTable_ClassMouseClicked

    private void jTable_MyClassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_MyClassMouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount()==2){
            int row = jTable_MyClass.getSelectedRow();
            String class_id = (String)jTable_MyClass.getValueAt(row, 0);
           ErrorCode e = cmh.cancle(class_id);
           if( e == ErrorCode.NOMAL){
               myclass_Model.removeRow(row);
                now.setText(Double.toString(cmh.getStduentCredit()));
            }else JOptionPane.showMessageDialog(null, e.getDesc()); 
        }
    }//GEN-LAST:event_jTable_MyClassMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1MouseClicked

    private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane1StateChanged
        // TODO add your handling code here:
        if(jTabbedPane1.getSelectedIndex() == 1){
                grade_Model = new DefaultTableModel(grade_colNames,0){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
            Scoreinfo si;
            si = cmh.inquiryScore();
            for(String[] s : si.infoarray){
                grade_Model.addRow(s);
            }
           jTable2.setModel(grade_Model);
        }
    }//GEN-LAST:event_jTabbedPane1StateChanged

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable_Class;
    private javax.swing.JTable jTable_MyClass;
    private javax.swing.JLabel now;
    private javax.swing.JLabel possible;
    // End of variables declaration//GEN-END:variables
}
