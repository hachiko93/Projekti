/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.putnik;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import kontroler.putnik.KontrolerProfaktura;
import org.jdesktop.swingx.JXDatePicker;

/**
 *
 * @author Licina
 */
public class FMProfaktura extends javax.swing.JDialog {

    /**
     * Creates new form FMProfaktura
     */
    KontrolerProfaktura kontrolerP;

    public FMProfaktura(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        kontrolerP = new KontrolerProfaktura();
        kontrolerP.srediFormu(this);
    }

    public JComboBox getJcbAutobus() {
        return jcbAutobus;
    }

    public JComboBox getJcbPlaneta() {
        return jcbPlaneta;
    }

    public JComboBox getJcbPutnik() {
        return jcbPutnik;
    }

    public JTextField getJtxtIznos() {
        return jtxtIznos;
    }

    public JTextField getJtxtBrojProfakture() {
        return jtxtBrojProfakture;
    }

    public JXDatePicker getJdpDatum() {
        return jdpDatum;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlPutnik = new javax.swing.JLabel();
        jcbPutnik = new javax.swing.JComboBox();
        jlAutobus = new javax.swing.JLabel();
        jcbAutobus = new javax.swing.JComboBox();
        jcbPlaneta = new javax.swing.JComboBox();
        jlPlaneta = new javax.swing.JLabel();
        jlIznos = new javax.swing.JLabel();
        jtxtIznos = new javax.swing.JTextField();
        jlMernaJedinica = new javax.swing.JLabel();
        jlDatum = new javax.swing.JLabel();
        jbtnOdustani = new javax.swing.JButton();
        jbtnSacuvaj = new javax.swing.JButton();
        jlBrojProfakture = new javax.swing.JLabel();
        jtxtBrojProfakture = new javax.swing.JTextField();
        jdpDatum = new org.jdesktop.swingx.JXDatePicker();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Kreiranje profakture");

        jlPutnik.setText("Putnik:");

        jcbPutnik.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbPutnik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbPutnikActionPerformed(evt);
            }
        });

        jlAutobus.setText("Autobus:");

        jcbAutobus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbAutobus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbAutobusActionPerformed(evt);
            }
        });

        jcbPlaneta.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbPlaneta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbPlanetaActionPerformed(evt);
            }
        });

        jlPlaneta.setText("Planeta:");

        jlIznos.setText("Iznos:");

        jtxtIznos.setEditable(false);

        jlMernaJedinica.setText("evra");

        jlDatum.setText("Datum:");

        jbtnOdustani.setText("Odustani");
        jbtnOdustani.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnOdustaniActionPerformed(evt);
            }
        });

        jbtnSacuvaj.setText("Sacuvaj profakturu");
        jbtnSacuvaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSacuvajActionPerformed(evt);
            }
        });

        jlBrojProfakture.setText("Broj profakture:");

        jtxtBrojProfakture.setEditable(false);

        jdpDatum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jdpDatumActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlPutnik)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jcbPutnik, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbtnSacuvaj)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbtnOdustani))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jlBrojProfakture)
                            .addGap(34, 34, 34)
                            .addComponent(jtxtBrojProfakture))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jlAutobus)
                                .addComponent(jlPlaneta)
                                .addComponent(jlIznos)
                                .addComponent(jlDatum))
                            .addGap(67, 67, 67)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jdpDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jcbAutobus, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jcbPlaneta, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jtxtIznos, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jlMernaJedinica)))
                            .addGap(0, 0, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlBrojProfakture)
                    .addComponent(jtxtBrojProfakture, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlPutnik)
                            .addComponent(jcbPutnik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbAutobus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jlAutobus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbPlaneta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlPlaneta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlIznos)
                    .addComponent(jtxtIznos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlMernaJedinica))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlDatum)
                    .addComponent(jdpDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 108, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnOdustani)
                    .addComponent(jbtnSacuvaj)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnOdustaniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnOdustaniActionPerformed
        dispose();
    }//GEN-LAST:event_jbtnOdustaniActionPerformed

    private void jbtnSacuvajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSacuvajActionPerformed
        kontrolerP.sacuvajProfakturu(this);
    }//GEN-LAST:event_jbtnSacuvajActionPerformed

    private void jcbPutnikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbPutnikActionPerformed
        kontrolerP.azurirajProfakturaID(this);
    }//GEN-LAST:event_jcbPutnikActionPerformed

    private void jcbAutobusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbAutobusActionPerformed
        kontrolerP.azurirajProfakturaID(this);
    }//GEN-LAST:event_jcbAutobusActionPerformed

    private void jcbPlanetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbPlanetaActionPerformed
        kontrolerP.azurirajProfakturaID(this);
    }//GEN-LAST:event_jcbPlanetaActionPerformed

    private void jdpDatumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jdpDatumActionPerformed
        kontrolerP.azurirajProfakturaID(this);
    }//GEN-LAST:event_jdpDatumActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbtnOdustani;
    private javax.swing.JButton jbtnSacuvaj;
    private javax.swing.JComboBox jcbAutobus;
    private javax.swing.JComboBox jcbPlaneta;
    private javax.swing.JComboBox jcbPutnik;
    private org.jdesktop.swingx.JXDatePicker jdpDatum;
    private javax.swing.JLabel jlAutobus;
    private javax.swing.JLabel jlBrojProfakture;
    private javax.swing.JLabel jlDatum;
    private javax.swing.JLabel jlIznos;
    private javax.swing.JLabel jlMernaJedinica;
    private javax.swing.JLabel jlPlaneta;
    private javax.swing.JLabel jlPutnik;
    private javax.swing.JTextField jtxtBrojProfakture;
    private javax.swing.JTextField jtxtIznos;
    // End of variables declaration//GEN-END:variables
}