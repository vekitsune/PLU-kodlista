/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plukodgyakorlo2;

import javax.swing.*;
import java.util.*;
import java.io.*;
import java.text.*;

/**
 *
 * @author Verosffy
 */
public class TermekSzerkesztese extends javax.swing.JFrame {

    ArrayList<TermekKodParos> termekek = new ArrayList<TermekKodParos>();
    ;
    int kiválasztottIndex = 0;
    TermekKodParos[] termekektomb;
    String[] termeknevek;
    String[] termekkodok;
    TermekKodParos javitottTermek;

    /**
     * Creates new form TermekSzerkesztese
     */
    public TermekSzerkesztese() {
        initComponents();

        populateArrayList();
        System.out.println("termékek arrayList mérete:" + termekek.size());

        termeknevek = new String[termekek.size()];
        termeknevekTombFeltolto();
        eredetiTermeknevekComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(termeknevek));

        termekkodok = new String[termekek.size()];
        termekKodokFeltolto();
        eredetTermekkodokComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(termekkodok));

    }

    public void termekadatcsere() {
        termekek.remove(termekek.get(kiválasztottIndex));
        termekek.add(javitottTermek);
        saveTermekeToFile();
        termekek.removeAll(termekek);
        populateArrayList();
        termeknevek = new String[termekek.size()];
        termeknevekTombFeltolto();
        eredetiTermeknevekComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(termeknevek));

        termekkodok = new String[termekek.size()];
        termekKodokFeltolto();
        eredetTermekkodokComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(termekkodok));
    }

    public void termekKodokFeltolto() {
        for (int i = 0; i < termekek.size(); i++) {
            termekkodok[i] = termekek.get(i).getTermekkod();
        }
    }

    public void termeknevekTombFeltolto() {
        for (int i = 0; i < termekek.size(); i++) {
            termeknevek[i] = termekek.get(i).getTermeknev();

        }
    }

    public void populateArrayList() {
        try {
            FileInputStream file = new FileInputStream("src\\segedlet\\TermekKodparos.dat");
            ObjectInputStream inputObject = new ObjectInputStream(file);

            boolean endOfFile = false;
            while (!endOfFile) {
                try {
                    termekek.add((TermekKodParos) inputObject.readObject());
                } catch (EOFException e) {
                    endOfFile = true;
                } catch (Exception f) {
                    JOptionPane.showMessageDialog(null, f.getMessage());
                }
            }
            inputObject.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }

    public void saveTermekeToFile() {
        try {
            FileOutputStream file = new FileOutputStream("src\\segedlet\\TermekKodparos.dat");
            ObjectOutputStream outputObject = new ObjectOutputStream(file);
            for (int i = 0; i < termekek.size(); i++) {
                outputObject.writeObject(termekek.get(i));
            }
            outputObject.close();
            JOptionPane.showMessageDialog(null, "A változtatásokat sikeresen elmentette.");
            // this.dispose();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        }
    }

    public void deleteTermekFromArray(TermekKodParos kivalasztott) {
        termekek.remove(kivalasztott);
        saveTermekeToFile();
    }

    public void editTermek(TermekKodParos eredeti, TermekKodParos szerkesztett) {
        termekek.remove(eredeti);
        termekek.add(szerkesztett);
        saveTermekeToFile();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mentesButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        eredetiTermeknevekComboBox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        eredetTermekkodokComboBox = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        szerkesztettTermeknevField = new javax.swing.JTextField();
        szerkesztettTermekkodField = new javax.swing.JTextField();
        VisszaButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        mentesButton.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        mentesButton.setText("Mentés");
        mentesButton.setEnabled(false);
        mentesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mentesButtonActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Termék kiválasztása név alapján:");

        eredetiTermeknevekComboBox.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        eredetiTermeknevekComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        eredetiTermeknevekComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eredetiTermeknevekComboBoxActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Termék kiválasztása kód alapján:");

        eredetTermekkodokComboBox.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        eredetTermekkodokComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        eredetTermekkodokComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eredetTermekkodokComboBoxActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Átírható terméknév:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Átírható termékkód:");

        szerkesztettTermeknevField.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        szerkesztettTermeknevField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                szerkesztettTermeknevFieldActionPerformed(evt);
            }
        });

        szerkesztettTermekkodField.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        szerkesztettTermekkodField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                szerkesztettTermekkodFieldActionPerformed(evt);
            }
        });

        VisszaButton.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        VisszaButton.setText("Vissza");
        VisszaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VisszaButtonActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Nyomj entert a mentés élestéséhez!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(eredetiTermeknevekComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(eredetTermekkodokComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(szerkesztettTermeknevField, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(mentesButton)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(szerkesztettTermekkodField, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55)
                                .addComponent(jLabel5))
                            .addComponent(VisszaButton))))
                .addContainerGap(166, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(eredetiTermeknevekComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(eredetTermekkodokComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(szerkesztettTermeknevField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(szerkesztettTermekkodField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(mentesButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addComponent(VisszaButton)
                .addGap(55, 55, 55))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void eredetiTermeknevekComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eredetiTermeknevekComboBoxActionPerformed

        kiválasztottIndex = eredetiTermeknevekComboBox.getSelectedIndex();
        szerkesztettTermeknevField.setText(termekek.get(kiválasztottIndex).getTermeknev());
        szerkesztettTermekkodField.setText(termekek.get(kiválasztottIndex).getTermekkod());

    }//GEN-LAST:event_eredetiTermeknevekComboBoxActionPerformed

    private void szerkesztettTermeknevFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_szerkesztettTermeknevFieldActionPerformed
        mentesButton.setEnabled(true);
    }//GEN-LAST:event_szerkesztettTermeknevFieldActionPerformed

    private void eredetTermekkodokComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eredetTermekkodokComboBoxActionPerformed

        kiválasztottIndex = eredetTermekkodokComboBox.getSelectedIndex();
        szerkesztettTermeknevField.setText(termekek.get(kiválasztottIndex).getTermeknev());
        szerkesztettTermekkodField.setText(termekek.get(kiválasztottIndex).getTermekkod());
    }//GEN-LAST:event_eredetTermekkodokComboBoxActionPerformed

    private void mentesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mentesButtonActionPerformed
        String termeknev = szerkesztettTermeknevField.getText();
        String termekkod = szerkesztettTermekkodField.getText();
        javitottTermek = new TermekKodParos(termeknev, termekkod);

        termekadatcsere();
        mentesButton.setEnabled(false);
    }//GEN-LAST:event_mentesButtonActionPerformed

    private void szerkesztettTermekkodFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_szerkesztettTermekkodFieldActionPerformed
        mentesButton.setEnabled(true);
    }//GEN-LAST:event_szerkesztettTermekkodFieldActionPerformed

    private void VisszaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VisszaButtonActionPerformed
        dispose();
    }//GEN-LAST:event_VisszaButtonActionPerformed

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
            java.util.logging.Logger.getLogger(TermekSzerkesztese.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TermekSzerkesztese.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TermekSzerkesztese.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TermekSzerkesztese.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TermekSzerkesztese().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton VisszaButton;
    private javax.swing.JComboBox<String> eredetTermekkodokComboBox;
    private javax.swing.JComboBox<String> eredetiTermeknevekComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton mentesButton;
    private javax.swing.JTextField szerkesztettTermekkodField;
    private javax.swing.JTextField szerkesztettTermeknevField;
    // End of variables declaration//GEN-END:variables
}
