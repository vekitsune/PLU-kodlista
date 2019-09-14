/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plukodgyakorlo2;

/**
 *
 * @author Verosffy
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    public Menu() {
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

        jMenuBar1 = new javax.swing.JMenuBar();
        tesztMenu = new javax.swing.JMenu();
        tesztbeallitasMenuPont = new javax.swing.JMenuItem();
        tesztInditasmenu = new javax.swing.JMenuItem();
        Kikerdezo = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        termekHozzaadasmenu = new javax.swing.JMenuItem();
        termekszerkesztesemenu = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFont(new java.awt.Font("Alef", 0, 36)); // NOI18N
        setSize(new java.awt.Dimension(400, 250));

        tesztMenu.setText("Tesztvariációk |");
        tesztMenu.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N

        tesztbeallitasMenuPont.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        tesztbeallitasMenuPont.setText("Tizes-vizsga");
        tesztbeallitasMenuPont.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tesztbeallitasMenuPontActionPerformed(evt);
            }
        });
        tesztMenu.add(tesztbeallitasMenuPont);

        tesztInditasmenu.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        tesztInditasmenu.setText("Gyakorlás");
        tesztInditasmenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tesztInditasmenuActionPerformed(evt);
            }
        });
        tesztMenu.add(tesztInditasmenu);

        Kikerdezo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        Kikerdezo.setText("Kikérdező");
        Kikerdezo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KikerdezoActionPerformed(evt);
            }
        });
        tesztMenu.add(Kikerdezo);

        jMenuBar1.add(tesztMenu);

        jMenu2.setText("|Szerkesztési lehetőségek");
        jMenu2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N

        termekHozzaadasmenu.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        termekHozzaadasmenu.setText("Termék hozzáadása");
        termekHozzaadasmenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                termekHozzaadasmenuActionPerformed(evt);
            }
        });
        jMenu2.add(termekHozzaadasmenu);

        termekszerkesztesemenu.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        termekszerkesztesemenu.setText("Termék szerkesztése");
        termekszerkesztesemenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                termekszerkesztesemenuActionPerformed(evt);
            }
        });
        jMenu2.add(termekszerkesztesemenu);

        jMenuItem1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jMenuItem1.setText("Termék törlése");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 892, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 260, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tesztbeallitasMenuPontActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tesztbeallitasMenuPontActionPerformed
       new Vizsga().setVisible(true);
    }//GEN-LAST:event_tesztbeallitasMenuPontActionPerformed

    private void tesztInditasmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tesztInditasmenuActionPerformed
       new TesztInditas().setVisible(true);
    }//GEN-LAST:event_tesztInditasmenuActionPerformed

    private void termekHozzaadasmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_termekHozzaadasmenuActionPerformed
       new TermekHOzzaadasa().setVisible(true);
    }//GEN-LAST:event_termekHozzaadasmenuActionPerformed

    private void termekszerkesztesemenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_termekszerkesztesemenuActionPerformed
        new TermekSzerkesztese().setVisible(true);
    }//GEN-LAST:event_termekszerkesztesemenuActionPerformed

    private void KikerdezoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KikerdezoActionPerformed
        new Adatkikerdezo().setVisible(true);
    }//GEN-LAST:event_KikerdezoActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        new TermekTorlese().setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Kikerdezo;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem termekHozzaadasmenu;
    private javax.swing.JMenuItem termekszerkesztesemenu;
    private javax.swing.JMenuItem tesztInditasmenu;
    private javax.swing.JMenu tesztMenu;
    private javax.swing.JMenuItem tesztbeallitasMenuPont;
    // End of variables declaration//GEN-END:variables
}
