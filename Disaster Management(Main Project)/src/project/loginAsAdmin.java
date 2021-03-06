/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Hasnath Jami
 */
public class loginAsAdmin extends javax.swing.JFrame {

    /**
     * Creates new form loginRegister
     */
    public loginAsAdmin() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        username_textField = new javax.swing.JTextField();
        loginForAdmin = new javax.swing.JButton();
        resetButtonForLoginAdmin = new javax.swing.JButton();
        password_textField = new javax.swing.JPasswordField();
        returnHomeFromLoginAsAdmin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("User Name");

        jLabel2.setText("Password");

        username_textField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                username_textFieldActionPerformed(evt);
            }
        });

        loginForAdmin.setText("Login");
        loginForAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginForAdminActionPerformed(evt);
            }
        });

        resetButtonForLoginAdmin.setText("Reset");
        resetButtonForLoginAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonForLoginAdminActionPerformed(evt);
            }
        });

        returnHomeFromLoginAsAdmin.setText("Home");
        returnHomeFromLoginAsAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnHomeFromLoginAsAdminActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(113, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(51, 51, 51))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(loginForAdmin)
                        .addGap(38, 38, 38)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(resetButtonForLoginAdmin)
                    .addComponent(password_textField, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(username_textField, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(82, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(returnHomeFromLoginAsAdmin)
                .addGap(153, 153, 153))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(username_textField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(password_textField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(resetButtonForLoginAdmin)
                    .addComponent(loginForAdmin))
                .addGap(18, 18, 18)
                .addComponent(returnHomeFromLoginAsAdmin)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void username_textFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_username_textFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_username_textFieldActionPerformed

    private void loginForAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginForAdminActionPerformed
         try {

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:sqlserver://localhost:1433;databaseName=DisasterManagement;selectMethod=cursor", "TestingUser", "jishan");
            
            String query="SELECT * from loginAsAdmin where username=? and password=?";
            PreparedStatement pst =connection.prepareStatement(query);
            pst.setString(1,username_textField.getText());
            pst.setString(2,password_textField.getText());
            ResultSet rs=pst.executeQuery();
            
            if(rs.next())
            {
                JOptionPane.showMessageDialog(null,"Success");
                username_textField.setText("");
                 password_textField.setText("");
                 
                 mainAdminPage mp=new mainAdminPage();
                 mp.setVisible(true);
                 setVisible(false);
                 
                 
            }
            else{
            
            JOptionPane.showMessageDialog(null,"Invalid User Name OR Password");
            username_textField.setText("");
               password_textField.setText("");
            
            }
            
            connection.close();
            
        
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_loginForAdminActionPerformed

    private void resetButtonForLoginAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonForLoginAdminActionPerformed
        // TODO add your handling code here:
        username_textField.setText("");
               password_textField.setText("");
    }//GEN-LAST:event_resetButtonForLoginAdminActionPerformed

    private void returnHomeFromLoginAsAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnHomeFromLoginAsAdminActionPerformed
        // TODO add your handling code here:
        FrontPage fp =new FrontPage();
        fp.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_returnHomeFromLoginAsAdminActionPerformed

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
            java.util.logging.Logger.getLogger(loginAsAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(loginAsAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(loginAsAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(loginAsAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new loginAsAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton loginForAdmin;
    private javax.swing.JPasswordField password_textField;
    private javax.swing.JButton resetButtonForLoginAdmin;
    private javax.swing.JButton returnHomeFromLoginAsAdmin;
    private javax.swing.JTextField username_textField;
    // End of variables declaration//GEN-END:variables
}
