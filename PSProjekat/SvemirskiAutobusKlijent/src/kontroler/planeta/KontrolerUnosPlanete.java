/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler.planeta;

import domen.Planeta;
import forme.planeta.FMUnosPlanete;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import komunikacija.Komunikacija;
import transfer.TransferObjekatOdgovor;
import transfer.TransferObjekatZahtev;
import util.Konstante;

/**
 *
 * @author Licina
 */
public class KontrolerUnosPlanete {

    private Planeta planeta;

    public KontrolerUnosPlanete() {
        planeta = null;
    }

    public void srediFormu(FMUnosPlanete fm) {
        if (planeta == null) {
            fm.getJtxtNaziv().setText(null);
            fm.getJtxtKoordinate().setText(null);
            fm.getJsUdaljenost().setValue(0);
            fm.setTitle("Unos nove planete");

            fm.getJtxtNaziv().setEditable(true);
            fm.getJtxtKoordinate().setEditable(true);
            fm.getJsUdaljenost().setEnabled(true);
            fm.getJbtnSacuvaj().setVisible(true);

        } else {
            fm.setTitle("Pregled planete");

            fm.getJtxtNaziv().setText(planeta.getNaziv());
            fm.getJtxtKoordinate().setText(planeta.getKoordinate());
            fm.getJsUdaljenost().setValue(planeta.getUdaljenostOdZemlje());

            fm.getJtxtNaziv().setEditable(false);
            fm.getJtxtKoordinate().setEditable(false);
            fm.getJsUdaljenost().setEnabled(false);
            fm.getJbtnSacuvaj().setVisible(false);
        }
    }

    public void kreirajPlanetu(FMUnosPlanete fm) throws Exception {
        validiraj(fm);
        if (planeta == null) {
            planeta = new Planeta();
        }
        planeta.setNaziv(fm.getJtxtNaziv().getText().trim());
        planeta.setKoordinate(fm.getJtxtKoordinate().getText().trim());
        planeta.setUdaljenostOdZemlje(Double.parseDouble(fm.getJsUdaljenost().getValue().toString()));

    }

    public void sacuvajPlanetu(FMUnosPlanete fm) {
        try {
            kreirajPlanetu(fm);

            TransferObjekatZahtev toZahtev = new TransferObjekatZahtev();
            toZahtev.setOperacija(Konstante.SACUVAJ_PLANETU);
            toZahtev.setParametar(planeta);
            Komunikacija.getInstance().posaljiZahtev(toZahtev);
            TransferObjekatOdgovor toOdgovor = Komunikacija.getInstance().primiOdgovor();
            if (toOdgovor.getIzuzetak() == null) {
                JOptionPane.showMessageDialog(fm, "Planeta je sacuvana!");
            } else {
                throw new Exception(toOdgovor.getPoruka());
            }
            planeta = null;
            srediFormu(fm);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(fm, ex.getMessage());
            ex.printStackTrace();
        }
    }

    public void setPlaneta(Planeta p) {
        planeta = p;
    }

    public void odustani(FMUnosPlanete fm) {
        fm.dispose();
        planeta = null;
    }

    private void validiraj(FMUnosPlanete fm) throws Exception {
        proveriDaLiJePrazno(fm.getJtxtNaziv(), "Naziv");
        proveriDaLiJePrazno(fm.getJtxtKoordinate(), "Koordinate");
        try {
            Double.parseDouble(fm.getJtxtKoordinate().getText().trim());
        } catch (NumberFormatException numberFormatException) {
            throw new Exception("Koordinate planete moraju biti decimalni broj");
        }
        if (Double.parseDouble(fm.getJsUdaljenost().getValue().toString()) == 0) {
            throw new Exception("Udaljenost mora biti veca od 0");
        }
    }

    private void proveriDaLiJePrazno(JTextField jtxt, String polje) throws Exception {
        if (jtxt.getText().trim().isEmpty()) {
            throw new Exception(polje + " ne sme biti prazno");
        }
    }

}
