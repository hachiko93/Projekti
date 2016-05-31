/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.planeta;

import javax.swing.JTable;
import javax.swing.JTextField;
import kontroler.planeta.KontrolerPretragePlaneta;

/**
 *
 * @author Licina
 */
public class FMPretragaPlaneta extends javax.swing.JDialog {

    /**
     * Creates new form FMPretragaPlanete
     */
    KontrolerPretragePlaneta kontrolerPP;
    public FMPretragaPlaneta(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        kontrolerPP = new KontrolerPretragePlaneta();
        kontrolerPP.srediFormu(this);
    }

    public JTable getJtblPlanete() {
        return jtblPlanete;
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
        jtblPlanete = new javax.swing.JTable();
        jbtnOdustani = new javax.swing.JButton();
        jbtnIzaberi = new javax.swing.JButton();
        jbtnPretrazi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pretraga planeta");

        jlKriterijum.setText("Kriterijum pretrage:");

        jtxtKriterijum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtKriterijumActionPerformed(evt);
            }
        });

        jtblPlanete.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtblPlanete);

        jbtnOdustani.setText("Odustani");
        jbtnOdustani.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnOdustaniActionPerformed(evt);
            }
        });

        jbtnIzaberi.setText("Izaberi");
        jbtnIzaberi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnIzaberiActionPerformed(evt);
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
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlKriterijum)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtxtKriterijum)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtnPretrazi))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 5, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jbtnIzaberi)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbtnOdustani)))))
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnOdustani)
                    .addComponent(jbtnIzaberi))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnPretraziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnPretraziActionPerformed
            kontrolerPP.nadjiPlanetePoKriterijumu(this);
    }//GEN-LAST:event_jbtnPretraziActionPerformed

    private void jbtnOdustaniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnOdustaniActionPerformed
        dispose();
    }//GEN-LAST:event_jbtnOdustaniActionPerformed

    private void jbtnIzaberiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnIzaberiActionPerformed
        kontrolerPP.pogledajPlanetu(this);
    }//GEN-LAST:event_jbtnIzaberiActionPerformed

    private void jtxtKriterijumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtKriterijumActionPerformed
        kontrolerPP.nadjiPlanetePoKriterijumu(this);
    }//GEN-LAST:event_jtxtKriterijumActionPerformed

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnIzaberi;
    private javax.swing.JButton jbtnOdustani;
    private javax.swing.JButton jbtnPretrazi;
    private javax.swing.JLabel jlKriterijum;
    private javax.swing.JTable jtblPlanete;
    private javax.swing.JTextField jtxtKriterijum;
    // End of variables declaration//GEN-END:variables

}
