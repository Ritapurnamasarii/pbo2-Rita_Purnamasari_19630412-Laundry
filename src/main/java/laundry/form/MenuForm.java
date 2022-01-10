/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laundry.form;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import laundry.libs.Pref;
import laundry.model.Login;

/**
 *
 * @author fahmi
 */
public class MenuForm extends javax.swing.JFrame {
//    KODING KU
    Login login =  new Login();
    private String level;
    private String user;
    

//    SEETER

    public void setLevel(String level) {
        this.level = level;
    }

    public void setUser(String user) {
        this.user = user;
    }
    
    
    
    public void tampil_bt_user(){
//        System.out.println(level);
        if(level.equals("Admin")){
            userBT.setVisible(true);
        }else{
            userBT.setVisible(false);
        }
        
    }

    /**
     * Creates new form MenuForm
     */
    public MenuForm() {
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

        parfumBT = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        userBT = new javax.swing.JButton();
        BTkeluar = new javax.swing.JButton();
        pelangganBT = new javax.swing.JButton();
        userL = new javax.swing.JLabel();
        namaL = new javax.swing.JLabel();
        BTkeluar1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        parfumBT.setText("Parfum");
        parfumBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                parfumBTActionPerformed(evt);
            }
        });

        jButton1.setText("Laundry");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        userBT.setText("User");
        userBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userBTActionPerformed(evt);
            }
        });

        BTkeluar.setText("Keluar");
        BTkeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTkeluarActionPerformed(evt);
            }
        });

        pelangganBT.setText("Pelanggan");
        pelangganBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pelangganBTActionPerformed(evt);
            }
        });

        userL.setText("User");

        namaL.setText("Nama");

        BTkeluar1.setText("Log Out");
        BTkeluar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTkeluar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(userL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(namaL))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(BTkeluar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(parfumBT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(userBT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pelangganBT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BTkeluar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userL)
                    .addComponent(namaL))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(pelangganBT)
                .addGap(18, 18, 18)
                .addComponent(parfumBT)
                .addGap(18, 18, 18)
                .addComponent(userBT)
                .addGap(18, 18, 18)
                .addComponent(BTkeluar1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BTkeluar)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void parfumBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_parfumBTActionPerformed
        new ParfumForm().setVisible(true);
    }//GEN-LAST:event_parfumBTActionPerformed

    private void userBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userBTActionPerformed
        new UserForm().setVisible(true);
    }//GEN-LAST:event_userBTActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        tampil_bt_user();
        userL.setText(level+" :");
        namaL.setText(user);
    }//GEN-LAST:event_formWindowActivated

    private void BTkeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTkeluarActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this,
            "Konfirmasi Keluar Aplikasi",
            "Yakin untuk keluar dari program",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE);
        if (confirm == JOptionPane.YES_OPTION) {
            Pref pref = new Pref();
            pref.reset();
            System.exit(0);
        }
    }//GEN-LAST:event_BTkeluarActionPerformed

    private void pelangganBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pelangganBTActionPerformed
        new PelangganForm().setVisible(true);
    }//GEN-LAST:event_pelangganBTActionPerformed

    private void BTkeluar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTkeluar1ActionPerformed
//        System.exit(0);
        Pref pref = new Pref();
        pref.reset();

        new LoginForm().setVisible(true);
        dispose();
    }//GEN-LAST:event_BTkeluar1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        LaundryForm laundryform =  new LaundryForm();
            laundryform.setLevel(level);
            laundryform.setUser(user);
            laundryform.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(MenuForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTkeluar;
    private javax.swing.JButton BTkeluar1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel namaL;
    private javax.swing.JButton parfumBT;
    private javax.swing.JButton pelangganBT;
    private javax.swing.JButton userBT;
    private javax.swing.JLabel userL;
    // End of variables declaration//GEN-END:variables
}
