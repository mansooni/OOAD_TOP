package lesson;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hak
 * 2017.11.26
 * ui 생성
 */
public class ClassMana extends javax.swing.JFrame {
    ResultSet rs = null;
    Statement stmt = null;
    Connection conn = null;
    
    String url = "jdbc:mysql://113.198.235.232:23306/UIS_TOP";
    String id = "admin";
    String password = "123";
    public ClassMana() {
        initComponents();
        insetTable(); //등록 정보 테이블로 가져오기 
        openTable(); //개설 정보 테이블로 가져오기
    }
    void insetTable(){//테이블에 값 나타내기
        try{
            DefaultTableModel model = (DefaultTableModel) insertTable.getModel();
            String sql = null;
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, id, password);
            stmt = conn.createStatement();
            sql = "select * from classuser";
            rs = stmt.executeQuery(sql);
            
            while(rs.next()){
                String classnum = rs.getString("classnum");
                String classname = rs.getString("classname");
                String classstu = rs.getString("classstu");
                String classpre = rs.getString("classpre");
                String classnumb = rs.getString("classnumb");
                String classopen = rs.getString("classopen");
                model.addRow(new Object[]{classnum,classname,classstu,classpre,classnumb,classopen});
            }
            insertTable.setModel(model);
        }catch(Exception e7){
            JOptionPane.showMessageDialog(null, "드라이버 연결 실패");
        }finally {
            try {
                /* 자원 반납 */
                rs.close();
                stmt.close();
                conn.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "드라이버 연결 해제 성공");
            }
        }
    }
    //개설 테이블에 데이터 가져오기
    void openTable(){
        try {
            DefaultTableModel model1 = (DefaultTableModel) openTable.getModel();            
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, id, password);
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from open");
            
            while(rs.next()){ // 레코드를 읽어서 테이블에 addRow
                String classnum = rs.getString("classnumm");
                String professor = rs.getString("professor");
                String maxpeople = rs.getString("maxpeople");
                String minpeople = rs.getString("minpeople");
                model1.addRow(new Object[]{classnum,professor,maxpeople,minpeople});
            }
            openTable.setModel(model1);
        } catch (Exception ex4) {
            JOptionPane.showMessageDialog(null, "드라이버 연결 실패");
        } finally {
            try {
                /* 자원 반납 */
                rs.close();
                stmt.close();
                conn.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "드라이버 연결 해제 성공");
            }
        }
    }
    
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        insertTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        numText = new javax.swing.JTextField();
        preText = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        nameText = new javax.swing.JTextField();
        stuText = new javax.swing.JTextField();
        numbText = new javax.swing.JTextField();
        openText = new javax.swing.JTextField();
        insertButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        openButton = new javax.swing.JButton();
        searchButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        openTable = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        proText = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        maxText = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        minText = new javax.swing.JTextField();
        clearButton = new javax.swing.JButton();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        insertTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "강좌 번호", "강좌 이름", "담당 학과", "설명", "학점 ", "개설 유무"
            }
        ));
        insertTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                insertTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(insertTable);

        jLabel1.setText("강좌 번호 :");

        jLabel2.setText("강좌 설명 :");

        jLabel3.setText("강좌 이름 :");

        jLabel4.setText("담당 학과 :");

        jLabel5.setText("학점 :");

        jLabel6.setText("개설 유무 : ");

        insertButton.setText("등록");
        insertButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("삭제");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        updateButton.setText("수정");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        openButton.setText("개설");
        openButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openButtonActionPerformed(evt);
            }
        });

        searchButton.setText("검색");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(preText, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel5))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(numText, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nameText, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(numbText, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(openText, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(stuText, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(searchButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(insertButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(updateButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(openButton)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(numText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(nameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stuText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(preText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(numbText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(openText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(insertButton)
                    .addComponent(deleteButton)
                    .addComponent(updateButton)
                    .addComponent(openButton)
                    .addComponent(searchButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("등록", jPanel1);

        openTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "강좌 번호", "담당 교수", "최대 인원", "최소 인원"
            }
        ));
        jScrollPane2.setViewportView(openTable);

        jLabel7.setText("담당 교수 :");

        jLabel8.setText("최대 인원 :");

        jLabel9.setText("최소 인원 :");

        clearButton.setText("개설 완료");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(clearButton))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 559, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(proText)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(maxText, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(minText, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(proText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(maxText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(minText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(clearButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("개설", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
//강좌 등록 버튼 생성
    private void insertButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertButtonActionPerformed
        DefaultTableModel model = (DefaultTableModel) insertTable.getModel();
        //TextField에 값이 입력되지 않았을 경우
        if(!numText.getText().equals("") && !nameText.getText().equals("")&& !stuText.getText().equals("") && !preText.getText().equals("")){
            InsertClass insert = new InsertClass(numText.getText(), nameText.getText(), stuText.getText(),preText.getText(), numbText.getText(), openText.getText()); //디비 연동시키기.
            if(insert.getclassnumcheck(numText.getText().toString())){ //중복된 값이 입력되었는지 체크
                insert.ClassInsert(numText.getText().toString()); //강좌 등록
                model.addRow(new Object[]{numText.getText(), nameText.getText(), stuText.getText(),preText.getText(), numbText.getText(), openText.getText()}); //테이블 row에 데이터 넣기
        }else{ //중복된 강좌번호가 입력되었을시
            JOptionPane.showMessageDialog(null, "중복된 강좌 번호를 입력했습니다");
        }
        }else{ //텍스트 필드에 값이 입력되지 않았을 경우
            JOptionPane.showMessageDialog(null, "공백이 될 수 없습니다. 다시 입력하시오");
        }
        //등록 후 텍스트 필드 초기화 
        numText.setText("");
        nameText.setText("");
        stuText.setText("");
        preText.setText("");
        numbText.setText("");
        openText.setText("");
    }//GEN-LAST:event_insertButtonActionPerformed
//강좌 삭제 버튼
    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        DefaultTableModel model = (DefaultTableModel) insertTable.getModel();
        if(insertTable.getSelectedRow() == -1){// 테이블 선택시 강좌에 데이터가 있을 경우!
            if(insertTable.getRowCount() == 0){       // 테이블 선택시 강좌에 데이터가 없을 경우
                JOptionPane.showMessageDialog(null, "데이터가 없습니다");
            } else {
                // 삭제할 강좌를 선택하지 않은 경우
                JOptionPane.showMessageDialog(null, "삭제할 강좌를 선택하세요");
            }
        } 
        else { 
            // 한 번도 개설되지 않은 강좌일 경우
            if(model.getValueAt(insertTable.getSelectedRow(), 5).toString().equals("N")){ //개설되지 않은 강좌 선택시
                InsertClass insert = new InsertClass(numText.getText(), nameText.getText(), stuText.getText(),preText.getText(), numbText.getText(), openText.getText()); //DB 연동
                insert.ClassDelete(); //삭제
                model.removeRow(insertTable.getSelectedRow()); //테이블에 값 삭제
            } else { //개설된 강좌는 삭제 못한다.
                JOptionPane.showMessageDialog(null,"한 번 개설된 강좌는 삭제 할 수 없습니다.");
            }
        }        
        //등록 후 텍스트 필드 초기화 
        numText.setText("");
        nameText.setText("");
        stuText.setText("");
        preText.setText("");
        numbText.setText("");
        openText.setText("");
    }//GEN-LAST:event_deleteButtonActionPerformed
//강좌 수정 버튼 
    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        DefaultTableModel model = (DefaultTableModel) insertTable.getModel();
        String classNum = numText.getText().toString(); //입력된 강좌 변수에 저장

        if(model.getValueAt(insertTable.getSelectedRow(), 5).toString().equals("N")){ // 강좌가 한 번도 개설이 안된 경우
            if(classNum.equals(model.getValueAt(insertTable.getSelectedRow(), 0).toString())){ //강좌번호랑 일치하지 않을 경우 수정된다. 일치하면 else문으로 넘어간다.
                model.setValueAt(nameText.getText(), insertTable.getSelectedRow(), 1); //강좌 이름
                model.setValueAt(stuText.getText(), insertTable.getSelectedRow(), 2); //담당 학과
                model.setValueAt(preText.getText(), insertTable.getSelectedRow(), 3); //설명
                model.setValueAt(numbText.getText(), insertTable.getSelectedRow(), 4); //학점
                model.setValueAt(openText.getText(), insertTable.getSelectedRow(), 5);  //개설유무 
                InsertClass insert = new InsertClass(numText.getText(), nameText.getText(), stuText.getText(),preText.getText(), numbText.getText(), openText.getText()); //DB연동
                //수정
                insert.ClassUpdate();

            } else {
                JOptionPane.showMessageDialog(null,"강좌 번호는 변경할 수 없습니다.");
            }
            //수정 후 텍스트 필드 값 초기화 
            numText.setText("");
            nameText.setText("");
            stuText.setText("");
            preText.setText("");
            numbText.setText("");
            openText.setText("");
        } else { // 강좌가 한 번이라도 개설된 경우
            JOptionPane.showMessageDialog(null,"한 번 개설된 강좌는 수정할 수 없습니다.");
        }
    }//GEN-LAST:event_updateButtonActionPerformed
//테이블 클릭시 열정보를 텍스트필드에 표시
    private void insertTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_insertTableMouseClicked
        DefaultTableModel model = (DefaultTableModel) insertTable.getModel();
        // tbRegisteredCourse의 값을 TextField에 setText
        //선택된 테이블 열의 값들이 각 텍스트 필드에 나타나게 한다.
        numText.setText(model.getValueAt(insertTable.getSelectedRow(), 0).toString());
        nameText.setText(model.getValueAt(insertTable.getSelectedRow(), 1).toString());
        stuText.setText(model.getValueAt(insertTable.getSelectedRow(), 2).toString());
        preText.setText(model.getValueAt(insertTable.getSelectedRow(), 3).toString());
        numbText.setText(model.getValueAt(insertTable.getSelectedRow(), 4).toString());
        openText.setText(model.getValueAt(insertTable.getSelectedRow(), 5).toString());
    }//GEN-LAST:event_insertTableMouseClicked
//강좌 개설 버튼
    private void openButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openButtonActionPerformed
        if(insertTable.getSelectedRow() != -1){
            jTabbedPane1.setSelectedIndex(1); //개설 버튼 클릭시 탭이동
        }else{
            JOptionPane.showMessageDialog(null, "개설할 강좌를 선택하시오.");
        }
    }//GEN-LAST:event_openButtonActionPerformed
//개설완료 버튼 생성
    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        DefaultTableModel model = (DefaultTableModel) insertTable.getModel(); //등록 테이블 가져오기
        DefaultTableModel model2 = (DefaultTableModel) openTable.getModel(); //개설 테이블 
        
        //TextField 에 값이 비워져있는경우
        if(!proText.getText().equals("") && !maxText.getText().equals("") && !minText.getText().equals("")){
            OpenClass open = new OpenClass(numText.getText(),proText.getText(),maxText.getText(),minText.getText()); //DB연동
            open.ClassOpen(); //개설
            
            model.setValueAt("Y", insertTable.getSelectedRow(), 5); //개설시 insertTable classopen 값 N -> Y로 변경
            model2.addRow(new Object[]{numText.getText(),proText.getText(),maxText.getText(),minText.getText()}); //openTable에 데이터 값 등록
        }
        //개설 후 텍스트 필드 데이터 초기화
        proText.setText("");
        maxText.setText("");
        minText.setText("");
    }//GEN-LAST:event_clearButtonActionPerformed
//강좌 검색(대기)
    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed

    }//GEN-LAST:event_searchButtonActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ClassMana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClassMana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClassMana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClassMana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClassMana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clearButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton insertButton;
    private javax.swing.JTable insertTable;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField maxText;
    private javax.swing.JTextField minText;
    private javax.swing.JTextField nameText;
    private javax.swing.JTextField numText;
    private javax.swing.JTextField numbText;
    private javax.swing.JButton openButton;
    private javax.swing.JTable openTable;
    private javax.swing.JTextField openText;
    private javax.swing.JTextField preText;
    private javax.swing.JTextField proText;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField stuText;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
