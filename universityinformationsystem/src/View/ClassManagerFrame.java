package View;

import com.sun.java.swing.plaf.windows.resources.windows;
import controller.ClassManagerHandler;
import controller.BillIssueHandler;
import static java.lang.System.exit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import universityinformationsystem.ErrorState;

/**
 *
 * @author hak
 */
public class ClassManagerFrame extends javax.swing.JFrame {
  //  Billing billing = new Billing();
    ClassManagerHandler cmh;
    BillIssueHandler bh;
    private String course_colNames[]={"강좌번호","강좌이름","강좌설명","학점","담당학과","개설유무"};
    private String openclass_colNames[]={"개설강의번호","강좌이름","담당교수","최소인원수","최대인원수"};
    private String bill_colNames[]={"학번","이름"};
    public DefaultTableModel courseModel, openclassModel;
    private DefaultTableModel billModel;
    String no;
    String deptname;
    int row;
    String id;
    
    public ClassManagerFrame(String id) {
        this.id = id;
        courseModel = new DefaultTableModel(course_colNames,0){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        openclassModel = new DefaultTableModel(openclass_colNames,0);
        billModel = new DefaultTableModel(bill_colNames,0);
        initComponents();
     //   addsTable();//등록 정보 테이블로 가져오기
     //   billing.studentTable(NotIssuedList); // 청구서 미발급 명단 가져오기 
       cmh = new ClassManagerHandler();
       bh = new BillIssueHandler();
       ArrayList <String[]> infoarray = cmh.getCourse("", "");
        for(String[] s : infoarray){
            courseModel.addRow(s);
        }
    }
    
   
   

    //강좌 검색 
    private void LessonSearch(String query){
        DefaultTableModel model = (DefaultTableModel) jTable_Course.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
        jTable_Course.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(query));
    }
    //개설 검색
    private void OpenSearch(String query){
        DefaultTableModel model = (DefaultTableModel) openTable.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
        openTable.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(query));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Course = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jTextField_iCourseno = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField_Coursename = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField_Credit = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField_de = new javax.swing.JTextField();
        addButton = new javax.swing.JButton();
        delButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        isOpenButton = new javax.swing.JButton();
        jButton_InquiryCourse = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jTextField_iCoursename = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton_Close = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        openTable = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        openSearchText = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane1StateChanged(evt);
            }
        });

        jTable_Course.setModel(courseModel);
        jTable_Course.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTable_CourseMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_Course);

        jLabel1.setText("강좌번호 :");

        jLabel3.setText("강좌 이름:");

        jLabel4.setText("담당 학과 :");

        jLabel5.setText("학점 :");

        jLabel7.setText("강좌 설명 :");

        addButton.setText("등록");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        delButton.setText("삭제");
        delButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delButtonActionPerformed(evt);
            }
        });

        editButton.setText("수정");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        isOpenButton.setText("개설");
        isOpenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                isOpenButtonActionPerformed(evt);
            }
        });

        jButton_InquiryCourse.setText("조회");
        jButton_InquiryCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_InquiryCourseActionPerformed(evt);
            }
        });

        jLabel13.setText("강좌이름 :");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "전산학과", "전자공학과", "화학공학과", "기계공학과", "항공우주공학과" }));

        jButton_Close.setText("닫기");
        jButton_Close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CloseActionPerformed(evt);
            }
        });

        jButton3.setText("암호변경");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_iCourseno, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_iCoursename, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton_InquiryCourse))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField_Coursename, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField_Credit, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField_de, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 25, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(addButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(delButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(editButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(isOpenButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton_Close))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton3)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField_iCourseno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_InquiryCourse)
                    .addComponent(jLabel13)
                    .addComponent(jTextField_iCoursename, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField_Coursename, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField_Credit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField_de, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addButton)
                    .addComponent(delButton)
                    .addComponent(editButton)
                    .addComponent(isOpenButton)
                    .addComponent(jButton_Close))
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("강좌", jPanel1);

        openTable.setModel(openclassModel);
        jScrollPane2.setViewportView(openTable);

        jLabel8.setText("개설강의번호 :");

        jButton2.setText("조회");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 617, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(openSearchText, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(openSearchText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("개설된 강의", jPanel2);

        jLabel12.setText("수강료 청구서 미발급 학생 명단");

        jButton1.setText("발급하기");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable2.setModel(billModel);
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(271, 271, 271)
                        .addComponent(jButton1))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(225, 225, 225)
                        .addComponent(jLabel12)))
                .addContainerGap(126, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                .addGap(48, 48, 48)
                .addComponent(jButton1)
                .addGap(46, 46, 46))
        );

        jTabbedPane1.addTab("수강료청구서발급", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
     //   billing.issued(NotIssuedList);
     
    }//GEN-LAST:event_jButton1MouseClicked

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here:
        String info[] = cmh.addCourse(jTextField_Coursename.getText(),jTextField_de.getText(),jTextField_Credit.getText(),(String)jComboBox1.getSelectedItem());
        if(info != null){
            courseModel.addRow(info);
        }
    }//GEN-LAST:event_addButtonActionPerformed

    private void jButton_InquiryCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_InquiryCourseActionPerformed
        // TODO add your handling code here:
        courseModel = new DefaultTableModel(course_colNames,0);
        ArrayList <String[]> infoarray = cmh.getCourse(jTextField_iCourseno.getText(), jTextField_iCoursename.getText());
        for(String[] s : infoarray){
            courseModel.addRow(s);
        }
        jTable_Course.setModel(courseModel);
    }//GEN-LAST:event_jButton_InquiryCourseActionPerformed

    private void jButton_CloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CloseActionPerformed
        // TODO add your handling code here:
        exit(1);
    }//GEN-LAST:event_jButton_CloseActionPerformed

    private void jTable_CourseMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_CourseMousePressed
        // TODO add your handling code here:
        row = jTable_Course.getSelectedRow();
        
        no = (String) jTable_Course.getValueAt(row, 0);
        jTextField_Coursename.setText((String) jTable_Course.getValueAt(row, 1));
        jTextField_Credit.setText((String) jTable_Course.getValueAt(row, 3));
        jTextField_de.setText((String) jTable_Course.getValueAt(row, 2));
        deptname = (String) jTable_Course.getValueAt(row, 4);
    }//GEN-LAST:event_jTable_CourseMousePressed

    private void delButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delButtonActionPerformed
        // TODO add your handling code here:
        if(jTable_Course.getValueAt(row, 5).equals("Y")){
           JOptionPane.showMessageDialog(null, "개설된 강좌는 삭제할 수 없습니다.");
        }
        else{
                ErrorState e;
                e = cmh.deleteCourse(no);
                if(e == ErrorState.NOMAL)
                    courseModel.removeRow(row);
                else JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_delButtonActionPerformed

    private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane1StateChanged
        // TODO add your handling code here:
        ArrayList <String[]> infoarray;
        if(jTabbedPane1.getSelectedIndex() == 1){
            openclassModel = new DefaultTableModel(openclass_colNames,0);
            infoarray = cmh.getClassData("");
            for(String[] s : infoarray){
            openclassModel.addRow(s);
        }
            jTable1.setModel(openclassModel);
        }
        else if(jTabbedPane1.getSelectedIndex() == 2){
            billModel = new DefaultTableModel(bill_colNames,0);
            infoarray = bh.getNoBillIssueStudent();
            for(String[] s : infoarray){
                billModel.addRow(s);
            }
           jTable2.setModel(billModel);
        }
    }//GEN-LAST:event_jTabbedPane1StateChanged

    private void isOpenButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_isOpenButtonActionPerformed
        // TODO add your handling code here:
        if(jTable_Course.getValueAt(row, 5).equals("Y")){
           JOptionPane.showMessageDialog(null, "이미 개설 되었습니다.");
        }
        else if (jTable_Course.getSelectedRow() != -1) {//선택시
            OpenClassFrame ocf;
          ocf = new OpenClassFrame(no,(String) jTable_Course.getValueAt(row, 1), deptname, cmh, this);
          ocf.setTitle("강좌개설화면");
          ocf.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
          ocf.setVisible(true);
            }
    }//GEN-LAST:event_isOpenButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(bh.billIssue(no))
        JOptionPane.showMessageDialog(null, "청구서발급이완료되었습니다");
        billModel.removeRow(row);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        row = jTable2.getSelectedRow();
        no = (String) jTable2.getValueAt(row, 0);
    }//GEN-LAST:event_jTable2MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        openclassModel = new DefaultTableModel(openclass_colNames,0);
        ArrayList<String[]> infoarray = cmh.getClassData(openSearchText.getText());
        for(String[] s : infoarray){
            openclassModel.addRow(s);
        }
        openTable.setModel(openclassModel);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        // TODO add your handling code here:
        if(jTable_Course.getValueAt(row, 5).equals("Y")){
           JOptionPane.showMessageDialog(null, "개설된 강좌는 수정할 수 없습니다.");
        }
         if( jTextField_Coursename.getText().isEmpty()){
           System.out.println("이름을 입력해주세요");
           return ;
       }
        else{
              ErrorState e;
                e =cmh.updateClass(no, jTextField_Coursename.getText(), jTextField_de.getText(), jTextField_Credit.getText(), (String) jComboBox1.getSelectedItem());
                if(e == ErrorState.NOMAL){
                    courseModel.setValueAt(jTextField_Coursename.getText(),  row, 1);
                    courseModel.setValueAt(jTextField_de.getText(),  row, 2);
                    courseModel.setValueAt(jTextField_Credit.getText(),  row, 3);
                    courseModel.setValueAt( (String) jComboBox1.getSelectedItem(),  row, 4);
                }
                else JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_editButtonActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        new UpdatePwFrame(id).setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton delButton;
    private javax.swing.JButton editButton;
    private javax.swing.JButton isOpenButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton_Close;
    private javax.swing.JButton jButton_InquiryCourse;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    public javax.swing.JTable jTable_Course;
    private javax.swing.JTextField jTextField_Coursename;
    private javax.swing.JTextField jTextField_Credit;
    private javax.swing.JTextField jTextField_de;
    private javax.swing.JTextField jTextField_iCoursename;
    private javax.swing.JTextField jTextField_iCourseno;
    private javax.swing.JTextField openSearchText;
    private javax.swing.JTable openTable;
    // End of variables declaration//GEN-END:variables
}
