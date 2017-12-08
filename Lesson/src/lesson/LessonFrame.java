package lesson;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author hak
 */
public class LessonFrame extends javax.swing.JFrame {
    Billing billing = new Billing();
    
    ResultSet rs = null;
    Statement stmt = null;
    Connection conn = null;
    
    String url = "jdbc:mysql://113.198.235.232:23306/UIS_TOP";
    String id = "admin";
    String password="123";
    
    public LessonFrame() {
        initComponents();
        addsTable();//등록 정보 테이블로 가져오기
        openTable(); //개설 정보 테이블로 가져오기
        billing.studentTable(NotIssuedList); // 청구서 미발급 명단 가져오기 
    }
    
    //addTable에 데이터 값 넣기
    void addsTable(){
        try{
            DefaultTableModel model = (DefaultTableModel) addTable.getModel();
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, id,password);
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from classuser");
            
            while(rs.next()){
                String classnum = rs.getString("classnum");
                String classname = rs.getString("classname");
                String classstu = rs.getString("classstu");
                String classpre = rs.getString("classpre");
                String classnumb = rs.getString("classnumb");
                String classopen = rs.getString("classopen");
                model.addRow(new Object[]{classnum,classname,classstu,classpre,classnumb,classopen});
            }
            addTable.setModel(model);
        }catch(SQLException ex3){
            JOptionPane.showMessageDialog(null, "드라이버 연결 실패");
        }catch(ClassNotFoundException ex3){
            System.out.println("");
        }finally{
            try{
                //자원 반납
                rs.close();
                stmt.close();
                conn.close();
            }catch(SQLException ex3){
                JOptionPane.showMessageDialog(null, "드라이버 연결 해제");
                System.out.println("드라이버 연결 해제");
            }
        }
    }
    //개설 테이블에 데이터 가져오기
    void openTable(){
        try{
            DefaultTableModel model1 = (DefaultTableModel) openTable.getModel();
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, id, password);
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM open");
            
            while(rs.next()){
                String classnum = rs.getString("classnumm");
                String professor = rs.getString("professor");
                String maxPeople = rs.getString("maxpeople");
                String minPeople = rs.getString("minpeople");
                model1.addRow(new Object[]{classnum,professor,maxPeople,minPeople});
            }
            openTable.setModel(model1);
            JOptionPane.showMessageDialog(null, "드라이버 연결 성공");
        }catch(SQLException ex4){
            JOptionPane.showMessageDialog(null, "드라이버 연결 실패");
        }catch(ClassNotFoundException ex4){
            System.out.println("");
        }finally{
            try{
                //자원 반납
                rs.close();
                stmt.close();
                conn.close();
            }catch(SQLException ex3){
                //JOptionPane.showMessageDialog(null, "드라이버 연결 해제");
                System.out.println("드라이버 연결 해제");
            }
        }
    }
   
   

    //강좌 검색 
    private void LessonSearch(String query){
        DefaultTableModel model = (DefaultTableModel) addTable.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
        addTable.setRowSorter(tr);
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        addTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        SearchTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        numberText = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        nameText = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        studentText = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        numbTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        isOpenText = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        preTextField = new javax.swing.JTextField();
        addButton = new javax.swing.JButton();
        delButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        isOpenButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        openTable = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        openSearchText = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        professorText = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        maxText = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        minText = new javax.swing.JTextField();
        clearTextField = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        NotIssuedList = new javax.swing.JList<>();
        jLabel12 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        addTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "강좌 번호", "강좌 이름", "담당 학과", "강좌 설명", "학점", "개설 유무"
            }
        ));
        addTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(addTable);

        jLabel1.setText("강좌 검색 :");

        SearchTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SearchTextFieldKeyReleased(evt);
            }
        });

        jLabel2.setText("강좌 번호 :");

        jLabel3.setText("강좌 이름:");

        jLabel4.setText("담당 학과 :");

        jLabel5.setText("학점 :");

        jLabel6.setText("개설 유무 :");

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(studentText, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(numbTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(isOpenText))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(SearchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(numberText, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(nameText, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(preTextField)
                                        .addGap(33, 33, 33)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(addButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(delButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(isOpenButton))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(SearchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(numberText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(nameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(studentText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(numbTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(isOpenText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(preTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton)
                    .addComponent(delButton)
                    .addComponent(editButton)
                    .addComponent(isOpenButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("강좌", jPanel1);

        openTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "강좌 번호", "담당 교수", "최대 인원", "최소 인원"
            }
        ));
        jScrollPane2.setViewportView(openTable);

        jLabel8.setText("개설 정보 검색 :");

        openSearchText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                openSearchTextKeyReleased(evt);
            }
        });

        jLabel9.setText("담당 교수 :");

        jLabel10.setText("최대 인원 :");

        jLabel11.setText("최소 인원 :");

        clearTextField.setText("개설 완료");
        clearTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearTextFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(openSearchText, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(professorText)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(maxText, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(minText, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(clearTextField)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(openSearchText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(professorText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(maxText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(minText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(clearTextField)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("개설", jPanel2);

        jScrollPane5.setViewportView(NotIssuedList);

        jLabel12.setText("수강료 청구서 미발급 학생 명단");

        jButton1.setText("발급하기");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(jLabel12))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(184, 184, 184)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(212, 212, 212)
                        .addComponent(jButton1)))
                .addContainerGap(203, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jButton1)
                .addContainerGap(125, Short.MAX_VALUE))
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
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
//등록 버튼
    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        DefaultTableModel model = (DefaultTableModel) addTable.getModel();
        //TextField에 값이 입력되지 않았을 경우 
        if(!numberText.getText().trim().equals("") && !nameText.getText().trim().equals("")
            && !studentText.getText().trim().equals("") && !numbTextField.getText().trim().equals("")){        
            InsertClass add = new InsertClass(numberText.getText(),nameText.getText(),studentText.getText(),
                    preTextField.getText(),numbTextField.getText(),isOpenText.getText()); //DB 연동시키기.
            if(add.getClassNumCheck(numberText.getText().toString())){//중복체킄함수
                add.ClassInsert(numberText.getText().toString()); //강좌 등록
                model.addRow(new Object[]{numberText.getText(),nameText.getText(),studentText.getText(),
                    preTextField.getText(),numbTextField.getText(),isOpenText.getText()});// 테이블 열에 값 넣기 
            }else{ //중복된 강좌번호가 입력되었을때
                JOptionPane.showMessageDialog(null, "중복된 강좌 번호 있다.");
            }
        }else{//텍스트 필드에ㅔ 값이 입력되지 않았을 경우
            JOptionPane.showMessageDialog(null, "공백 불가");
        }
        //등록 후 텍스트 필드 초기화
        numberText.setText("");
        nameText.setText("");
        studentText.setText("");
        preTextField.setText("");
        numbTextField.setText("");
        isOpenText.setText("");
    }//GEN-LAST:event_addButtonActionPerformed
//강자 삭제
    private void delButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delButtonActionPerformed
        DefaultTableModel model = (DefaultTableModel) addTable.getModel();
        if(addTable.getSelectedRow()== -1){// 테이블 선택시 강좌에 데이터가 있을 경우!
              if(addTable.getRowCount() ==0){    // 테이블 선택시 강좌에 데이터가 없을 경우
                  JOptionPane.showMessageDialog(null, "데이터 값이 없다");
              }else{
                  // 삭제할 강좌를 선택하지 않은 경우
                  JOptionPane.showMessageDialog(null, "삭제할 테이블 선택");
              }
        }else{
            // 한 번도 개설되지 않은 강좌일 경우
            if(model.getValueAt(addTable.getSelectedRow(), 5).toString().equals("N")){
                InsertClass add = new InsertClass(numberText.getText(),nameText.getText(),studentText.getText(),
                    preTextField.getText(),numbTextField.getText(),isOpenText.getText());
                add.ClassDelete(); //삭제
                model.removeRow(addTable.getSelectedRow());
            }else{//개설된 강좌는 삭제 못한다. (Y)일 때 
                JOptionPane.showMessageDialog(null, "개설된 강좌 삭제 불가");
            }
        }
        //삭제 후 텍스트 필드 초기화 
        numberText.setText("");
        nameText.setText("");
        studentText.setText("");
        preTextField.setText("");
        numbTextField.setText("");
        isOpenText.setText("");
    }//GEN-LAST:event_delButtonActionPerformed
//테이블 클릭시 텍스트 필드에 값 나오게하기.
    private void addTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addTableMouseClicked
        DefaultTableModel model = (DefaultTableModel) addTable.getModel();
        
        numberText.setText(model.getValueAt(addTable.getSelectedRow(), 0).toString());
        nameText.setText(model.getValueAt(addTable.getSelectedRow(), 1).toString());
        studentText.setText(model.getValueAt(addTable.getSelectedRow(), 2).toString());
        preTextField.setText(model.getValueAt(addTable.getSelectedRow(), 3).toString());
        numbTextField.setText(model.getValueAt(addTable.getSelectedRow(), 4).toString());
        isOpenText.setText(model.getValueAt(addTable.getSelectedRow(), 5).toString());
    }//GEN-LAST:event_addTableMouseClicked
//강좌 수정
    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        DefaultTableModel model = (DefaultTableModel) addTable.getModel();
        String classNum = numberText.getText().toString();//입력된 강좌 변수에 저장
        if(model.getValueAt(addTable.getSelectedRow(), 5).toString().equals("N")){// 강좌가 한 번도 개설이 안된 경우
            if(classNum.equals(model.getValueAt(addTable.getSelectedRow(), 0).toString())){//강좌번호랑 일치하지 않을 경우 수정된다. 일치하면 else문으로 넘어간다.
                model.setValueAt(nameText.getText(), addTable.getSelectedRow(), 1); //강좌ㅏ 이름
                model.setValueAt(studentText.getText(), addTable.getSelectedRow(), 2); //담당 학과
                model.setValueAt(preTextField.getText(), addTable.getSelectedRow(), 3); //설명
                model.setValueAt(numbTextField.getText(), addTable.getSelectedRow(), 4); // 학점
                model.setValueAt(isOpenText.getText(), addTable.getSelectedRow(), 5); //개설 유무
                
               InsertClass add = new InsertClass(numberText.getText(),nameText.getText(),studentText.getText(),
                    preTextField.getText(),numbTextField.getText(),isOpenText.getText());
               add.ClassUpdate();//수정
            }else {
                JOptionPane.showMessageDialog(null, "강좌번호 변경 불가");
            }
        }else{
                JOptionPane.showMessageDialog(null, "개설된 강좌 수정 불가");
        }
        //수정 후 텍스트 필드 값 초기화 
        numberText.setText("");
        nameText.setText("");
        studentText.setText("");
        preTextField.setText("");
        numbTextField.setText("");
        isOpenText.setText("");
    }//GEN-LAST:event_editButtonActionPerformed
//개설 버튼
    private void isOpenButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_isOpenButtonActionPerformed
        if(addTable.getSelectedRow() != -1){
             jTabbedPane1.setSelectedIndex(1); //개설 버튼 클릭시 탭이동
            }else{
                JOptionPane.showMessageDialog(null, "개설할 강좌를 선택하시오.");
            }
    }//GEN-LAST:event_isOpenButtonActionPerformed
//개설 완료 버튼
    private void clearTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearTextFieldActionPerformed
        DefaultTableModel model = (DefaultTableModel) addTable.getModel();//등록 테이블 가져오기
        DefaultTableModel model1 = (DefaultTableModel) openTable.getModel();//개설 테이블
        
        //TextField 에 값이 비워져있는경우
        if(!professorText.getText().trim().equals("")&& !maxText.getText().trim().equals("") 
                && !minText.getText().trim().equals("")){
            OpenClass open = new OpenClass(numberText.getText(),professorText.getText(),
                    maxText.getText(), minText.getText());
            open.ClassOpen();//개설
        
            model.setValueAt("Y", addTable.getSelectedRow(), 5);//개설시 insertTable classopen 값 N -> Y로 변경
            model1.addRow(new Object[]{numberText.getText(),professorText.getText(),
                    maxText.getText(), minText.getText()});
        }
        //개설 후 텍스트 필드 데이터 초기화
        professorText.setText("");
        maxText.setText("");
        minText.setText("");
    }//GEN-LAST:event_clearTextFieldActionPerformed
//강좌 테이블 검색
    private void SearchTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchTextFieldKeyReleased
        String query = SearchTextField.getText().toLowerCase().toUpperCase();
        LessonSearch(query);
    }//GEN-LAST:event_SearchTextFieldKeyReleased
//개설 테이블 검색 
    private void openSearchTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_openSearchTextKeyReleased
        String query = openSearchText.getText().toLowerCase().toUpperCase();
        OpenSearch(query);
    }//GEN-LAST:event_openSearchTextKeyReleased

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        billing.issued(NotIssuedList);
    }//GEN-LAST:event_jButton1MouseClicked

   
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
            java.util.logging.Logger.getLogger(LessonFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LessonFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LessonFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LessonFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LessonFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> NotIssuedList;
    private javax.swing.JTextField SearchTextField;
    private javax.swing.JButton addButton;
    private javax.swing.JTable addTable;
    private javax.swing.JButton clearTextField;
    private javax.swing.JButton delButton;
    private javax.swing.JButton editButton;
    private javax.swing.JButton isOpenButton;
    private javax.swing.JTextField isOpenText;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField maxText;
    private javax.swing.JTextField minText;
    private javax.swing.JTextField nameText;
    private javax.swing.JTextField numbTextField;
    private javax.swing.JTextField numberText;
    private javax.swing.JTextField openSearchText;
    private javax.swing.JTable openTable;
    private javax.swing.JTextField preTextField;
    private javax.swing.JTextField professorText;
    private javax.swing.JTextField studentText;
    // End of variables declaration//GEN-END:variables
}
