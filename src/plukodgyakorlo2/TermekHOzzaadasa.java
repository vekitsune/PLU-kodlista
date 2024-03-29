/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plukodgyakorlo2;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Verosffy
 */
public class TermekHOzzaadasa extends javax.swing.JFrame {

    Adatkezelo adatok = new Adatkezelo();

    /**
     * Creates new form TermekHOzzaadasa
     */
    public TermekHOzzaadasa() {
        initComponents();
        adatok.listafeltolto();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        termeknevField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        termekkodField = new javax.swing.JTextField();
        mentesButton = new javax.swing.JButton();
        megseButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Termék neve: ");

        termeknevField.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        termeknevField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                termeknevFieldActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("Termék kód:");

        termekkodField.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        termekkodField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                termekkodFieldActionPerformed(evt);
            }
        });

        mentesButton.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        mentesButton.setText("Mentés");
        mentesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mentesButtonActionPerformed(evt);
            }
        });

        megseButton.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        megseButton.setText("Mégse");
        megseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                megseButtonActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Ha csak entert nyomsz, folytathatod a bevitelt egy újabb tétellel");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(termeknevField, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(mentesButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(megseButton))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(termekkodField, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(termeknevField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(termekkodField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mentesButton)
                    .addComponent(megseButton))
                .addContainerGap(65, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mentesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mentesButtonActionPerformed
        if (termekkodField.getText().isEmpty() || termeknevField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Minden mezőt ki kell tölteni");
        } else {
            String termeknev = termeknevField.getText().trim();
            String termekkod = termekkodField.getText().trim();

            adatok.ujtermekletrehozo(termeknev, termekkod);
            //adatok.termeklista.add( adatok.egytermek);
            adatok.getTermeklista().add(adatok.getEgytermek());
            adatok.listaElmento();

        }
        this.dispose();
    }//GEN-LAST:event_mentesButtonActionPerformed

    private void termekkodFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_termekkodFieldActionPerformed
        if (termekkodField.getText().isEmpty() || termeknevField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Minden mezőt ki kell tölteni");
        } else {
            String termeknev = termeknevField.getText().trim();
            String termekkod = termekkodField.getText().trim();

            adatok.ujtermekletrehozo(termeknev, termekkod);
            adatok.getTermeklista().add(adatok.getEgytermek());
        }

        termekkodField.setText("");
        termeknevField.setText("");
        termeknevField.requestFocus();
    }//GEN-LAST:event_termekkodFieldActionPerformed

    private void megseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_megseButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_megseButtonActionPerformed

    private void termeknevFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_termeknevFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_termeknevFieldActionPerformed

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
            java.util.logging.Logger.getLogger(TermekHOzzaadasa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TermekHOzzaadasa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TermekHOzzaadasa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TermekHOzzaadasa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TermekHOzzaadasa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton megseButton;
    private javax.swing.JButton mentesButton;
    private javax.swing.JTextField termekkodField;
    private javax.swing.JTextField termeknevField;
    // End of variables declaration//GEN-END:variables
}
