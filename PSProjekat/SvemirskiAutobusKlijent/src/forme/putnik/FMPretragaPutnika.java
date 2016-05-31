/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.putnik;

import javax.swing.JTable;
import javax.swing.JTextField;
import kontroler.putnik.KontrolerPretragaPutnika;

/**
 *
 * @author Licina
 */
public class FMPretragaPutnika extends javax.swing.JDialog {

    /**
     * Creates new form FMPretragaPutnika
     */
    KontrolerPretragaPutnika kontrolerIP;
    public FMPretragaPutnika(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        kontrolerIP = new KontrolerPretragaPutnika();
            kontrolerIP.srediFormu(this);
    }

    public JTable getJtblPutnici() {
        return jtblPutnici;
    }

    public JTextField getJtxtKriterijum() {
        return jtxtKriterijum;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlKriterijum = new javax.swing.JLabel();
        jtxtKriterijum = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblPutnici = new javax.swing.JTable();
        jbtnOdustani = new javax.swing.JButton();
        jbtnIzmeni = new javax.swing.JButton();
        jbtnPretrazi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pretraga putnika");

        jlKriterijum.setText("Kriterijum pretrage:");

        jtxtKriterijum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtKriterijumActionPerformed(evt);
            }
        });

        jtblPutnici.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtblPutnici);

        jbtnOdustani.setText("Odustani");
        jbtnOdustani.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnOdustaniActionPerformed(evt);
            }
        });

        jbtnIzmeni.setText("Izmeni");
        jbtnIzmeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnIzmeniActionPerformed(evt);
            }
        });

        jbtnPretrazi.setText("Pretrazi");
        jbtnPretrazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnPretraziActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlKriterijum)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtxtKriterijum, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbtnPretrazi)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbtnIzmeni)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtnOdustani)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlKriterijum)
                    .addComponent(jtxtKriterijum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnPretrazi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnOdustani)
                    .addComponent(jbtnIzmeni))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnPretraziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnPretraziActionPerformed
            kontrolerIP.nadjiPutnikePoKriterijumu(this);
    }//GEN-LAST:event_jbtnPretraziActionPerformed

    private void jbtnOdustaniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnOdustaniActionPerformed
        dispose();
    }//GEN-LAST:event_jbtnOdustaniActionPerformed

    private void jbtnIzmeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnIzmeniActionPerformed
        kontrolerIP.izmeniPutnika(this);
    }//GEN-LAST:event_jbtnIzmeniActionPerformed

    private void jtxtKriterijumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtKriterijumActionPerformed
        kontrolerIP.nadjiPutnikePoKriterijumu(this);
    }//GEN-LAST:event_jtxtKriterijumActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnIzmeni;
    private javax.swing.JButton jbtnOdustani;
    private javax.swing.JButton jbtnPretrazi;
    private javax.swing.JLabel jlKriterijum;
    private javax.swing.JTable jtblPutnici;
    private javax.swing.JTextField jtxtKriterijum;
    // End of variables declaration//GEN-END:variables

}