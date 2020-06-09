/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hasnath Jami
 */
public class showUserRegisterInformation extends javax.swing.JFrame {

    /**
     * Creates new form showInformationOfUser
     */
    public showUserRegisterInformation() {
        initComponents();
        showUserNew();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    
        
     public ArrayList<Show2> showList()
            
    {
     ArrayList <Show2> showList=new ArrayList<>();
    
     try {

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:sqlserver://localhost:1433;databaseName=DisasterManagement;selectMethod=cursor", "TestingUser", "jishan");
            
            String query1="select firstname,lastname,age,gender,email,username,password,phone from registerAsUser";
            
            Statement st=connection.createStatement();
            ResultSet rs=st.executeQuery(query1);
            
            Show2 show;
            while(rs.next())
            {
              
                 show= new Show2(rs.getString("firstname"),rs.getString("lastname"),rs.getInt("age"),rs.getString("gender"),rs.getString("email"),rs.getString("username"),rs.getString("password"),rs.getInt("phone"));
                
                showList.add(show);
            }
            
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
     
     return showList;
            
     }
    
    
    
   public void showUserNew()
   {
       ArrayList<Show2> list= showList();
       DefaultTableModel model=(DefaultTableModel)Show_InformationUser_Table.getModel();
       Object [] row=new Object[11];
       
       for (int i = 0; i <list.size(); i++) {
           
         
           row[0]=list.get(i).getFirstname();
           row[1]=list.get(i).getLastname();
           row[2]=list.get(i).getAge();
           row[3]=list.get(i).getGender();
           row[4]=list.get(i).getEmail();
           row[5]=list.get(i).getUsername();
             row[6]=list.get(i).getPassword();
           row[7]=list.get(i).getPhone();
         
           
           model.addRow(row);
           
           
       }   
       
   }
    
    
    
    
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Show_InformationUser_Table = new javax.swing.JTable();
        backFromUserInfoButton = new javax.swing.JButton();
        BackToHomeFromUserInfo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Show_InformationUser_Table.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Show_InformationUser_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "First Name ", "Last Name", "Age", "Gender", "Email", "User Name", "Password", "Phone"
            }
        ));
        Show_InformationUser_Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Show_InformationUser_TableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Show_InformationUser_Table);

        backFromUserInfoButton.setText("Back");
        backFromUserInfoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backFromUserInfoButtonActionPerformed(evt);
            }
        });

        BackToHomeFromUserInfo.setText("Home");
        BackToHomeFromUserInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackToHomeFromUserInfoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(56, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(525, 525, 525)
                .addComponent(backFromUserInfoButton)
                .addGap(18, 18, 18)
                .addComponent(BackToHomeFromUserInfo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backFromUserInfoButton)
                    .addComponent(BackToHomeFromUserInfo))
                .addContainerGap(204, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Show_InformationUser_TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Show_InformationUser_TableMouseClicked

    }//GEN-LAST:event_Show_InformationUser_TableMouseClicked

    private void backFromUserInfoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backFromUserInfoButtonActionPerformed
        // TODO add your handling code here:
        mainAdminPage map =new mainAdminPage();
        map.setVisible(true);
        setVisible(false);
        
    }//GEN-LAST:event_backFromUserInfoButtonActionPerformed

    private void BackToHomeFromUserInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackToHomeFromUserInfoActionPerformed
        // TODO add your handling code here
        FrontPage fp =new FrontPage();
        fp.setVisible (true);
        setVisible(false);
    }//GEN-LAST:event_BackToHomeFromUserInfoActionPerformed

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
            java.util.logging.Logger.getLogger(showUserRegisterInformation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(showUserRegisterInformation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(showUserRegisterInformation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(showUserRegisterInformation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new showUserRegisterInformation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackToHomeFromUserInfo;
    private javax.swing.JTable Show_InformationUser_Table;
    private javax.swing.JButton backFromUserInfoButton;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}