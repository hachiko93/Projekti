/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler.putnik;

import domen.Putnik;
import forme.putnik.FMUnosPutnika;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
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
public class KontrolerUnosPutnika {

    private Putnik putnik;

    public KontrolerUnosPutnika() {
        putnik = null;
    }

    public void srediFormu(FMUnosPutnika fm) {
        popuniComboBox(fm.getJcbTelefon());
        if (putnik == null) {
            fm.getJbtnIzmeni().setVisible(false);
            fm.getJbtnSacuvaj().setVisible(true);
            fm.getJtxtAdresa().setText(null);
            fm.getJtxtImePrezime().setText(null);
            fm.getJtxtJMBG().setText(null);
            fm.getJtxtTelefon().setText(null);
            fm.getJcbTelefon().setSelectedItem("011");
            fm.setTitle("Unos novog putnika");
            
            fm.getJtxtJMBG().setEditable(true);
        } else {
            fm.getJbtnIzmeni().setVisible(true);
            fm.getJbtnSacuvaj().setVisible(false);
            fm.setTitle("Izmena putnika");

            fm.getJtxtImePrezime().setText(putnik.getImeprezime());
            fm.getJtxtJMBG().setText(putnik.getJmbg());
            fm.getJtxtAdresa().setText(putnik.getAdresa());
            fm.getJtxtTelefon().setText(putnik.getKontaktTelefon().substring(3));
            fm.getJcbTelefon().setSelectedItem(putnik.getKontaktTelefon().substring(0, 3));
            
            fm.getJtxtJMBG().setEditable(false);
        }
    }

    public void kreirajPutnika(FMUnosPutnika fm) throws Exception {
        validiraj(fm);
        if (putnik == null) {
            putnik = new Putnik();
        }
        putnik.setImeprezime(fm.getJtxtImePrezime().getText().trim());
        putnik.setAdresa(fm.getJtxtAdresa().getText().trim());
        putnik.setJmbg(fm.getJtxtJMBG().getText().trim());
        putnik.setKontaktTelefon(fm.getJcbTelefon().getSelectedItem().toString() + fm.getJtxtTelefon().getText().trim());
    }

    public void setPutnik(Putnik p) {
        putnik = p;
    }

    private void popuniComboBox(JComboBox jcb) {
        jcb.setModel(new DefaultComboBoxModel(new String[]{"011", "060", "061", "062", "063", "064", "065", "066", "069"})); //dodaj

    }

    public void sacuvajPutnika(FMUnosPutnika fm) {
        try {
            kreirajPutnika(fm);

            TransferObjekatZahtev toZahtev = new TransferObjekatZahtev();
            toZahtev.setOperacija(Konstante.SACUVAJ_PUTNIKA);
            toZahtev.setParametar(putnik);
            Komunikacija.getInstance().posaljiZahtev(toZahtev);
            TransferObjekatOdgovor toOdgovor = Komunikacija.getInstance().primiOdgovor();
            if (toOdgovor.getIzuzetak() == null) {
                JOptionPane.showMessageDialog(fm, "Putnik je sacuvan!");
            } else {
                throw new Exception(toOdgovor.getPoruka());
            }
            putnik = null;
            srediFormu(fm);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(fm, ex.getMessage());
            ex.printStackTrace();
        }
    }

    public void odustani(FMUnosPutnika fm) {
        fm.dispose();
        putnik = null;
    }

    public void izmeniPutnika(FMUnosPutnika fm) {
        try {
            kreirajPutnika(fm);

            TransferObjekatZahtev toZahtev = new TransferObjekatZahtev();
            toZahtev.setOperacija(Konstante.IZMENI_PUTNIKA);
            toZahtev.setParametar(putnik);
            Komunikacija.getInstance().posaljiZahtev(toZahtev);
            TransferObjekatOdgovor toOdgovor = Komunikacija.getInstance().primiOdgovor();
            if (toOdgovor.getIzuzetak() == null) {
                JOptionPane.showMessageDialog(fm, "Putnik je izmenjen!");
            } else {
                throw new Exception(toOdgovor.getPoruka());
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(fm, ex.getMessage());
            ex.printStackTrace();
        }
    }

    private void postojeciJMBG(JTextField jtxtJMBG) throws Exception {
        String jmbg = jtxtJMBG.getText().trim();
        proveriDaLiSuSveBrojevi(jmbg, "JMBG");
        if (jmbg.length() != 13) {
            throw new Exception("JMBG mora imati 13 cifara");
        }
        proveriDatum(jmbg);
    }

    private void proveriDaLiSuSveBrojevi(String s, String polje) throws Exception {
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (!Character.isDigit(c)) {
                throw new Exception(polje + " moze imati samo cifre");
            }
        }
    }

    private void proveriDatum(String jmbg) throws Exception {
        String sub = jmbg.substring(0, 7);
        try {
            DateFormat df = new SimpleDateFormat("ddMMyyy");
            df.setLenient(false);
            Date datum = df.parse(sub);
        } catch (ParseException parseException) {
            throw new Exception("JMBG nije validan");
        }
    }

    private void proveriTelefon(JTextField jtxtTelefon) throws Exception {
        proveriDaLiSuSveBrojevi(jtxtTelefon.getText().trim(), "Kontakt telefon");
        if (jtxtTelefon.getText().trim().length() != 6 && jtxtTelefon.getText().trim().length() != 7) {
            throw new Exception("Kontakt telefon nije validan");
        }
    }

    private void validiraj(FMUnosPutnika fm) throws Exception {
        proveriDaLiJePrazno(fm.getJtxtImePrezime(), "Ime i prezime putnika");
        proveriDaLiJePrazno(fm.getJtxtJMBG(), "JMBG putnika");
        proveriDaLiJePrazno(fm.getJtxtAdresa(), "Adresa");
        proveriDaLiJePrazno(fm.getJtxtTelefon(), "Kontakt telefon");
        postojeciJMBG(fm.getJtxtJMBG());
        proveriTelefon(fm.getJtxtTelefon());
    }

    private void proveriDaLiJePrazno(JTextField jtxt, String polje) throws Exception {
        if (jtxt.getText().trim().isEmpty()) {
            throw new Exception(polje + " ne sme biti prazno");
        }
    }

}
