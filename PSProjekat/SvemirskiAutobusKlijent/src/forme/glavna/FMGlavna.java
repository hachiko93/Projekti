/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.glavna;

import forme.planeta.FMPorudzbenica;
import forme.planeta.FMPretragaPlaneta;
import forme.planeta.FMUnosPlanete;
import forme.putnik.FMPretragaPutnika;
import forme.putnik.FMProfaktura;
import forme.putnik.FMUnosPutnika;

/**
 *
 * @author Licina
 */
public class FMGlavna extends javax.swing.JFrame {

    /**
     * Creates new form FMGlavna
     */
    public FMGlavna() {
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

        jmbGlavni = new javax.swing.JMenuBar();
        jmPutnik = new javax.swing.JMenu();
        jmiUnosPutnika = new javax.swing.JMenuItem();
        jmiPretragaPutnika = new javax.swing.JMenuItem();
        jmiKreiranjeProfakture = new javax.swing.JMenuItem();
        jmPlaneta = new javax.swing.JMenu();
        jmiUnosPlanete = new javax.swing.JMenuItem();
        jmiPretragaPlaneta = new javax.swing.JMenuItem();
        jmiKreiranjePorudzbenice = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Softverski sistem za pracenje rada Svemirskog autobusa");

        jmPutnik.setText("Putnik");

        jmiUnosPutnika.setText(" Unos novog putnika");
        jmiUnosPutnika.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiUnosPutnikaActionPerformed(evt);
            }
        });
        jmPutnik.add(jmiUnosPutnika);

        jmiPretragaPutnika.setText("Pretraga putnika");
        jmiPretragaPutnika.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiPretragaPutnikaActionPerformed(evt);
            }
        });
        jmPutnik.add(jmiPretragaPutnika);

        jmiKreiranjeProfakture.setText("Kreiranje profakture za putnika");
        jmiKreiranjeProfakture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiKreiranjeProfaktureActionPerformed(evt);
            }
        });
        jmPutnik.add(jmiKreiranjeProfakture);

        jmbGlavni.add(jmPutnik);

        jmPlaneta.setText("Planeta");

        jmiUnosPlanete.setText("Unos nove planete");
        jmiUnosPlanete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiUnosPlaneteActionPerformed(evt);
            }
        });
        jmPlaneta.add(jmiUnosPlanete);

        jmiPretragaPlaneta.setText("Pretraga planeta");
        jmiPretragaPlaneta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiPretragaPlanetaActionPerformed(evt);
            }
        });
        jmPlaneta.add(jmiPretragaPlaneta);

        jmiKreiranjePorudzbenice.setText("Kreiranje porudzbenice za planetu");
        jmiKreiranjePorudzbenice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiKreiranjePorudzbeniceActionPerformed(evt);
            }
        });
        jmPlaneta.add(jmiKreiranjePorudzbenice);

        jmbGlavni.add(jmPlaneta);

        setJMenuBar(jmbGlavni);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmiUnosPutnikaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiUnosPutnikaActionPerformed
        FMUnosPutnika fmUnosPutnika = new FMUnosPutnika(this, false, null);
        fmUnosPutnika.setVisible(true);
    }//GEN-LAST:event_jmiUnosPutnikaActionPerformed

    private void jmiPretragaPutnikaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiPretragaPutnikaActionPerformed
        FMPretragaPutnika fmPretragaPutnika = new FMPretragaPutnika(this, false);
        fmPretragaPutnika.setVisible(true);
    }//GEN-LAST:event_jmiPretragaPutnikaActionPerformed

    private void jmiUnosPlaneteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiUnosPlaneteActionPerformed
        FMUnosPlanete fmUnosPlanete = new FMUnosPlanete(this, false, null);
        fmUnosPlanete.setVisible(true);
    }//GEN-LAST:event_jmiUnosPlaneteActionPerformed

    private void jmiKreiranjeProfaktureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiKreiranjeProfaktureActionPerformed
        FMProfaktura fMProfaktura = new FMProfaktura(this, false);
        fMProfaktura.setVisible(true);
    }//GEN-LAST:event_jmiKreiranjeProfaktureActionPerformed

    private void jmiPretragaPlanetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiPretragaPlanetaActionPerformed
        FMPretragaPlaneta fMPretragaPlaneta = new FMPretragaPlaneta(this, false);
        fMPretragaPlaneta.setVisible(true);
    }//GEN-LAST:event_jmiPretragaPlanetaActionPerformed

    private void jmiKreiranjePorudzbeniceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiKreiranjePorudzbeniceActionPerformed
        FMPorudzbenica fMPorudzbenica = new FMPorudzbenica(this, false);
        fMPorudzbenica.setVisible(true);
    }//GEN-LAST:event_jmiKreiranjePorudzbeniceActionPerformed

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
            java.util.logging.Logger.getLogger(FMGlavna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FMGlavna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FMGlavna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FMGlavna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FMGlavna().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jmPlaneta;
    private javax.swing.JMenu jmPutnik;
    private javax.swing.JMenuBar jmbGlavni;
    private javax.swing.JMenuItem jmiKreiranjePorudzbenice;
    private javax.swing.JMenuItem jmiKreiranjeProfakture;
    private javax.swing.JMenuItem jmiPretragaPlaneta;
    private javax.swing.JMenuItem jmiPretragaPutnika;
    private javax.swing.JMenuItem jmiUnosPlanete;
    private javax.swing.JMenuItem jmiUnosPutnika;
    // End of variables declaration//GEN-END:variables
}
