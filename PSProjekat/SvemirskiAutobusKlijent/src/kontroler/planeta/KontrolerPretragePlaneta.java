/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler.planeta;

import domen.Planeta;
import forme.planeta.FMPretragaPlaneta;
import forme.planeta.FMUnosPlanete;
import forme.planeta.model.PlanetaTableModel;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import komunikacija.Komunikacija;
import transfer.TransferObjekatOdgovor;
import transfer.TransferObjekatZahtev;
import util.Konstante;

/**
 *
 * @author Licina
 */
public class KontrolerPretragePlaneta {

    List<Planeta> lp;

    public KontrolerPretragePlaneta() {
        lp = null;
    }

    public void srediFormu(FMPretragaPlaneta fm) {
        popuniTabelu(fm.getJtblPlanete());
    }

    private void popuniTabelu(JTable jtbl) {
        PlanetaTableModel ptm = new PlanetaTableModel(lp);
        jtbl.setModel(ptm);
        ptm.fireTableDataChanged();
    }

    public void nadjiPlanetePoKriterijumu(FMPretragaPlaneta fm) {
        try {
            String kriterijum = fm.getJtxtKriterijum().getText().trim();
            if (kriterijum.isEmpty()) {
                throw new Exception("Morate uneti kriterijum pretrage");
            }

            TransferObjekatZahtev toZahtev = new TransferObjekatZahtev();
            toZahtev.setOperacija(Konstante.NADJI_PLANETE);
            toZahtev.setParametar(kriterijum);
            Komunikacija.getInstance().posaljiZahtev(toZahtev);
            TransferObjekatOdgovor toOdgovor = Komunikacija.getInstance().primiOdgovor();
            if (toOdgovor.getIzuzetak() != null) {
                throw new Exception(toOdgovor.getPoruka());
            }
            lp = (List<Planeta>)toOdgovor.getRezultat();
            if (lp.isEmpty()) {
                srediFormu(fm);
                throw new Exception("Ni jedna planeta nije nadjena");
            }
            srediFormu(fm);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(fm, e.getMessage());
            e.printStackTrace();
        }
    }

    public Planeta izabranaPlanetaUTabeli(JTable t) throws Exception {
        int red = t.getSelectedRow();
        if (red == -1) {
            throw new Exception("Morate izabrati planetu");
        }
        return lp.get(red);

    }

    public void pogledajPlanetu(FMPretragaPlaneta fm) {
        try {
            FMUnosPlanete fmp = new FMUnosPlanete(null, false, izabranaPlanetaUTabeli(fm.getJtblPlanete()));
            fmp.setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(fm, ex.getMessage());
        }
    }

}
