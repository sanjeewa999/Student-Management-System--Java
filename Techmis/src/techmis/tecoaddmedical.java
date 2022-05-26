/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package techmis;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import javax.swing.table.DefaultTableModel;


public class tecoaddmedical extends javax.swing.JFrame {

    /**
     * Creates new form tecoaddmedical
     */
    
            Connection con1;
            PreparedStatement insert;
            
      private void table_update(){
          
              int c,a;
              
              try{ 
           
               Class.forName("com.mysql.jdbc.Driver");
               
               con1 = DriverManager.getConnection("jdbc:mysql://localhost/mis","root","");
               insert = con1.prepareStatement("select * from medical");
               
               ResultSet rs = insert.executeQuery();
               
               ResultSetMetaData Rss = rs.getMetaData();
               
               c = Rss.getColumnCount();
               
               DefaultTableModel Df =(DefaultTableModel)jTable4.getModel();
               
               Df.setRowCount(0);
               
               
               while(rs.next()){
               
                   Vector v2 =new Vector();
                   for(a=1;a<=c;a++){
                   
                   v2.add(rs.getString("stu_id"));
                   v2.add(rs.getString("course_id"));
                   v2.add(rs.getString("start_date"));
                   v2.add(rs.getString("end_date"));
                   String medical_type=rs.getString("medical_type");
                   
                   if (medical_type.equals("T")) {
                           v2.add("Theory");
                       }
                       else if (medical_type.equals("P")) {
                            v2.add("Practicle");
                       }
                   
                   
                   }
                   Df.addRow(v2);
               }
               
           
               
           }
           
           catch (ClassNotFoundException ex){
           
           Logger.getLogger(tecoaddmedical.class.getName()).log(Level.SEVERE,null, ex);
           
           }
            catch (SQLException ex){
           
           Logger.getLogger(tecoaddmedical.class.getName()).log(Level.SEVERE,null, ex);
           
           }
            
              
          
          }  
            
                  
            
            
            
    
    
    
    public tecoaddmedical() {
        initComponents();
        table_update();
        
        jTextField1.setVisible(false);
        jTextField2.setVisible(false);
        jTextField3.setVisible(false);
        jTextField4.setVisible(false);
    }
    
    
    
    
    
    
    

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        txtcourse = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtstart = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtend = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txttype = new javax.swing.JTextField();
        deletebtn = new javax.swing.JButton();
        updatebtn = new javax.swing.JButton();
        addbtn = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        btn_back = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();

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
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable2);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(jTable3);

        jScrollPane5.setViewportView(jTextPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(750, 550));

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setPreferredSize(new java.awt.Dimension(750, 550));

        jLabel2.setBackground(new java.awt.Color(204, 0, 51));
        jLabel2.setFont(new java.awt.Font("Rockwell", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 204));
        jLabel2.setText("ADD MEDICAL");

        jLabel1.setIcon(new javax.swing.ImageIcon("D:\\Java_Project\\Images\\medical.png")); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 255, 204));
        jLabel5.setText("Student Id :");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 255, 204));
        jLabel4.setText("Course ID :");

        txtid.setBackground(new java.awt.Color(0, 102, 102));
        txtid.setForeground(new java.awt.Color(255, 255, 204));

        txtcourse.setBackground(new java.awt.Color(0, 102, 102));
        txtcourse.setForeground(new java.awt.Color(255, 255, 204));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 255, 204));
        jLabel6.setText("END Date :");

        txtstart.setBackground(new java.awt.Color(0, 102, 102));
        txtstart.setForeground(new java.awt.Color(255, 255, 204));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 255, 204));
        jLabel7.setText("Start Dtae :");

        txtend.setBackground(new java.awt.Color(0, 102, 102));
        txtend.setForeground(new java.awt.Color(255, 255, 204));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 255, 204));
        jLabel8.setText("Medical Type :");

        txttype.setBackground(new java.awt.Color(0, 102, 102));
        txttype.setForeground(new java.awt.Color(255, 255, 204));

        deletebtn.setText("DELETE");
        deletebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletebtnActionPerformed(evt);
            }
        });

        updatebtn.setText("UPDATE");
        updatebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatebtnActionPerformed(evt);
            }
        });

        addbtn.setText("ADD");
        addbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addbtnActionPerformed(evt);
            }
        });

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "stu_id", "course_id", "start_date", "end_date", "medical_type"
            }
        ));
        jTable4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable4MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTable4);

        btn_back.setBackground(new java.awt.Color(0, 102, 102));
        btn_back.setForeground(new java.awt.Color(204, 255, 255));
        btn_back.setText("<-- Back ");
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });

        jLabel11.setForeground(new java.awt.Color(204, 204, 204));
        jLabel11.setText("Faculty of Technology - University of Ruhuna");

        jTextField1.setText("jTextField1");

        jTextField2.setText("jTextField2");

        jTextField3.setText("jTextField3");

        jTextField4.setText("jTextField4");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtcourse, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtstart, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                                .addComponent(txtid)
                                .addComponent(txttype)
                                .addComponent(txtend))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_back))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(214, 214, 214)
                        .addComponent(jLabel11))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(391, 391, 391))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(addbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(updatebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(32, 32, 32)
                                        .addComponent(deletebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(btn_back)))
                .addGap(57, 57, 57)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deletebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcourse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtstart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(updatebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtend, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txttype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(addbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)))
                .addGap(36, 36, 36)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void deletebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletebtnActionPerformed
       
         DefaultTableModel Df = (DefaultTableModel)jTable4.getModel();
           int selectedIndex = jTable4.getSelectedRow();
        
         try{ 
           
                String idd = (Df.getValueAt(selectedIndex,0).toString());
                
                int dialogresult =JOptionPane.showConfirmDialog(null,"Do you want to delete the record", "Warning", YES_NO_OPTION);
                
                    
                if(dialogresult == JOptionPane.YES_OPTION){
                
                             Class.forName("com.mysql.jdbc.Driver");
               
               con1 = DriverManager.getConnection("jdbc:mysql://localhost/mis","root","");
               insert = con1.prepareStatement("delete from medical where stu_id=?");
               
            
               insert.setString(1,idd);
                 
               insert.executeUpdate();
               
               JOptionPane.showMessageDialog(this, "Record  Succesfully Deleted!!");
                table_update();
               
               txtid.setText("");
               txtcourse.setText("");
               txtstart.setText("");
               txtend.setText("");
               txttype.setText("");
               
               txtid.requestFocus();
                
        
                }
                
             }
           
           catch (ClassNotFoundException ex){
           
           Logger.getLogger(tecoaddattendence.class.getName()).log(Level.SEVERE,null, ex);
           
           }
            catch (SQLException ex){
           
           Logger.getLogger(tecoaddattendence.class.getName()).log(Level.SEVERE,null, ex);
           
           }
        
        
        
        
        
    }//GEN-LAST:event_deletebtnActionPerformed

    private void updatebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatebtnActionPerformed
             DefaultTableModel Df = (DefaultTableModel)jTable4.getModel();
           int selectedIndex = jTable4.getSelectedRow();
                       
         try{ 
           
               String idd = (Df.getValueAt(selectedIndex,0).toString());
                
                  String id = txtid.getText();
                  String courseid = txtcourse.getText();
                  String daystart = txtstart.getText();
                  String dayend=txtend.getText();
                  String type = txttype.getText();
                  
                 
                  String idval=jTextField1.getText();
                  String courseval=jTextField2.getText();
                  String dayvalstart=jTextField3.getText();
                  String typeval=jTextField4.getText();
                  
                  
               Class.forName("com.mysql.jdbc.Driver");
               
               con1 = DriverManager.getConnection("jdbc:mysql://localhost/mis","root","");
               insert = con1.prepareStatement("update medical set stu_id=?, course_id=?,start_date=?,end_date=?,medical_type=? where stu_id=? and course_id=? and start_date=? and medical_type=?");
               
               
               insert.setString(1, id);
               insert.setString(2, courseid);
               insert.setString(3,daystart);
               insert.setString(4, dayend);
               insert.setString(5,type);
               
               insert.setString(6,idval);
               insert.setString(7, courseval);
               insert.setString(8, dayvalstart);
               insert.setString(9, typeval);
                 
               insert.executeUpdate();
               
               JOptionPane.showMessageDialog(this, "Record Updated Succesfully!!");
                table_update();
               
               txtid.setText("");
               txtcourse.setText("");
               txtstart.setText("");
               txtend.setText("");
               txttype.setText("");
              
               txtid.requestFocus();
               
               
           }
           
           catch (ClassNotFoundException ex){
           
           JOptionPane.showMessageDialog(null, ex);
           
           }
            catch (SQLException ex){
           
           JOptionPane.showMessageDialog(null, ex);
           
           }
         
    }//GEN-LAST:event_updatebtnActionPerformed

    private void addbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addbtnActionPerformed
      
          String id = txtid.getText();
         String courseid = txtcourse.getText();
          String start = txtstart.getText();
           String end = txtend.getText();
            String type = txttype.getText();
            
            
            
            try{ 
           
               Class.forName("com.mysql.jdbc.Driver");
               
               con1 = DriverManager.getConnection("jdbc:mysql://localhost/mis","root","");
               insert = con1.prepareStatement("insert into medical(stu_id,course_id,start_date,end_date,medical_type) values(?,?,?,?,?)");
               
               insert.setString(1,id);
               insert.setString(2, courseid);
               insert.setString(3,start);
               insert.setString(4, end);
               insert.setString(5,type);
               insert.executeUpdate();
               
               JOptionPane.showMessageDialog(this, "record Added Succesfully!!");
                table_update();
               
               txtid.setText("");
               txtcourse.setText("");
               txtstart.setText("");
               txtend.setText("");
               txttype.setText("");
               
               txtid.requestFocus();
               
               
           }
           
           catch (ClassNotFoundException ex){
           
           Logger.getLogger(tecoaddmedical.class.getName()).log(Level.SEVERE,null, ex);
           
           }
            catch (SQLException ex){
           
           Logger.getLogger(tecoaddmedical.class.getName()).log(Level.SEVERE,null, ex);
           
           }
            
            
        
        
        
        
        
        
        
        
        
    }//GEN-LAST:event_addbtnActionPerformed

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        setVisible(false);
        tecodashboard object = new tecodashboard();
        object.setVisible(true);
    }//GEN-LAST:event_btn_backActionPerformed

    private void jTable4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable4MouseClicked
        DefaultTableModel Df = (DefaultTableModel)jTable4.getModel();
         int selectedIndex = jTable4.getSelectedRow();
           
        txtid.setText(Df.getValueAt(selectedIndex,0).toString());
        txtcourse.setText(Df.getValueAt(selectedIndex,1).toString());
        txtstart.setText(Df.getValueAt(selectedIndex,2).toString());
        txtend.setText(Df.getValueAt(selectedIndex,3).toString());
        txttype.setText(Df.getValueAt(selectedIndex,4).toString());
        
        
        jTextField1.setText(Df.getValueAt(selectedIndex,0).toString());
        jTextField2.setText(Df.getValueAt(selectedIndex,1).toString());
        jTextField3.setText(Df.getValueAt(selectedIndex,2).toString());
        jTextField4.setText(Df.getValueAt(selectedIndex, 4).toString());
        
        
    }//GEN-LAST:event_jTable4MouseClicked

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(tecoaddmedical.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tecoaddmedical.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tecoaddmedical.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tecoaddmedical.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tecoaddmedical().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addbtn;
    private javax.swing.JButton btn_back;
    private javax.swing.JButton deletebtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextField txtcourse;
    private javax.swing.JTextField txtend;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtstart;
    private javax.swing.JTextField txttype;
    private javax.swing.JButton updatebtn;
    // End of variables declaration//GEN-END:variables
}
