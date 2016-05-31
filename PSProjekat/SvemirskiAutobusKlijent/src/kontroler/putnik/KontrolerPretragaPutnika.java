/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler.putnik;

import domen.Putnik;
import forme.putnik.FMPretragaPutnika;
import forme.putnik.FMUnosPutnika;
import forme.putnik.model.PutnikTableModel;
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
public class KontrolerPretragaPutnika {

    private List<Putnik> lp;

    public KontrolerPretragaPutnika() {
        lp = null;
    }

    public void srediFormu(FMPretragaPutnika fm) {
        PutnikTableModel ptm = new PutnikTableModel(lp);
        fm.getJtblPutnici().setModel(ptm);
        ptm.fireTableDataChanged();

    }

    public void nadjiPutnikePoKriterijumu(FMPretragaPutnika fm) {
        try {
            String kriterijum = fm.getJtxtKriterijum().getText().trim();
            if (kriterijum.isEmpty()) {
                throw new Exception("Morate uneti kriterijum pretrage");
            }
            TransferObjekatZahtev toZahtev = new TransferObjekatZahtev();
            toZahtev.setOperacija(Konstante.NADJI_PUTNIKE);
            toZahtev.setParametar(kriterijum);
            Komunikacija.getInstance().posaljiZahtev(toZahtev);
            TransferObjekatOdgovor toOdgovor = Komunikacija.getInstance().primiOdgovor();
            if (toOdgovor.getIzuzetak() != null) {
                throw new Exception(toOdgovor.getPoruka());
            }
            lp = (List<Putnik>) toOdgovor.getRezultat();
            if (lp.isEmpty()) {
                srediFormu(fm);
                throw new Exception("Ni jedan putnik nije nadjen");
            }
            srediFormu(fm);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(fm, e.getMessage());
            e.printStackTrace();
        }
    }

    public void izmeniPutnika(FMPretragaPutnika fm) {
        try {
            FMUnosPutnika fmp = new FMUnosPutnika(null, false, izabranPutnikUTabeli(fm.getJtblPutnici()));
            fmp.setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(fm, ex.getMessage());
        }
    }

    public Putnik izabranPutnikUTabeli(JTable t) throws Exception {
        int red = t.getSelectedRow();
        if (red == -1) {
            throw new Exception("Morate izabrati putnika");
        }
        return lp.get(red);

    }
}
