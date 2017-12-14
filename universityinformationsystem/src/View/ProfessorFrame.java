/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.*;
import controller.ProfessorHandler;
import java.awt.List;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author gawon
 */
public class ProfessorFrame extends javax.swing.JFrame {

    
    String cid;
    String id;
ProfessorHandler pH;
    /**
     * Creates new form professorFrame
     */
    public ProfessorFrame(String id) {
        this.id = id;
        pH = new ProfessorHandler(id);
        initComponents();
        getAttendance();
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
        classlist = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        scoretable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        classlist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                classlistMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(classlist);

        JComboBox jcb = new JComboBox();
        jcb.addItem("A");
        jcb.addItem("B");
        jcb.addItem("C");
        jcb.addItem("D");
        jcb.addItem("F");
        scoretable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "학과", "학번", "이름", "성적"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(scoretable);
        if (scoretable.getColumnModel().getColumnCount() > 0) {
            scoretable.getColumnModel().getColumn(3).setCellEditor(new DefaultCellEditor(jcb)
            );
        }

        jButton1.setText("성적 입력");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("굴림", 1, 14)); // NOI18N
        jLabel1.setText("[ 담당 과목 ]");

        jLabel2.setFont(new java.awt.Font("굴림", 1, 14)); // NOI18N
        jLabel2.setText("[ 출  석  부 ]");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(261, 261, 261))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("출석부 조회 및 성적 입력", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void getAttendance() {
        ArrayList<String[]> info;

        DefaultListModel lModel = new DefaultListModel();
        info = pH.getAttendance();

        for (String[] s : info) {
            lModel.addElement(s[1]);
        }
        classlist.setModel(lModel);
    }

    private void classlistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_classlistMouseClicked
        // TODO add your handling code here:
        DefaultTableModel tModel = (DefaultTableModel) scoretable.getModel();
        String cid = null;
        String name = classlist.getSelectedValue();
        
        
       tModel.setNumRows(0);
        
        ArrayList <String[]> classid = pH.getAttendance();
        
        for (String[] s : classid) {
           
            if (s[1].equals(name)) {
                cid = s[0];
            }
        }

        ArrayList <String[]> namelist = pH.getnamelist(cid);

        for (String[] s : namelist) {
            tModel.addRow(s);
        }
        scoretable.setModel(tModel);
    }//GEN-LAST:event_classlistMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        DefaultTableModel tModel = (DefaultTableModel) scoretable.getModel();
        ArrayList<String> stud_id =new ArrayList<String>();
        ArrayList<String> grade= new ArrayList<String>();
        String cid = null;
        String name = classlist.getSelectedValue();
        
       
        ArrayList <String[]> classid = pH.getAttendance();
        
        for (String[] s : classid) {
           
            if (s[1].equals(name)) {
                cid = s[0];
            }
        }
        System.out.println(cid);
        
        
        
        for (int i = 0; i <tModel.getRowCount(); i++) {
            stud_id.add(tModel.getValueAt(i, 1).toString());
            grade.add(tModel.getValueAt(i, 3).toString());
            System.out.println(stud_id.get(i)+" : "+grade.get(i));
        }
        
        pH.inputscore(cid, stud_id, grade, tModel.getRowCount());
         tModel.setNumRows(0);
         ArrayList <String[]> namelist = pH.getnamelist(cid);

        for (String[] s : namelist) {
            tModel.addRow(s);
        }
        scoretable.setModel(tModel);
    }//GEN-LAST:event_jButton1MouseClicked

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> classlist;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable scoretable;
    // End of variables declaration//GEN-END:variables

    private void changeCellEditor(JTable scoretable, TableColumn column) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
