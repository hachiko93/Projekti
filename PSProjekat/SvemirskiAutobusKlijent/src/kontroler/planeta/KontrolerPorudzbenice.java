/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler.planeta;

import domen.Planeta;
import domen.Porudzbenica;
import domen.Stavkaporudzbenice;
import domen.Svemirskiautobus;
import domen.Zalihe;
import forme.planeta.FMPorudzbenica;
import forme.planeta.model.StavkaPorudzbeniceTableModel;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import komunikacija.Komunikacija;
import transfer.TransferObjekatOdgovor;
import transfer.TransferObjekatZahtev;
import util.Konstante;

/**
 *
 * @author Licina
 */
public class KontrolerPorudzbenice {

    private Porudzbenica porudzbenica;

    public KontrolerPorudzbenice() {
        porudzbenica = new Porudzbenica();
        porudzbenica.setStavkaporudzbeniceList(new LinkedList<Stavkaporudzbenice>());
    }

    public void srediFormu(FMPorudzbenica fm) {
        try {
            popuniComboBoxAutobus(fm.getJcbAutobus());
            popuniComboBoxPlaneta(fm.getJcbPlaneta());
            popuniComboBoxZalihe(fm.getJcbZalihe());
            popuniTabelu(fm.getJtblStavke());
            fm.getJdpDatePicker().setFormats(new SimpleDateFormat("dd.MM.yyyy"));
            fm.getJtxtJedinicaMere().setText(null);
            fm.getJdpDatePicker().setDate(null);
            fm.getJsKolicina().setValue(0);
            azurirajSifru(fm);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(fm, e.getMessage());
            e.printStackTrace();
        }
    }

    private void popuniComboBoxAutobus(JComboBox jcbAutobus) throws Exception {
        TransferObjekatZahtev toZahtev = new TransferObjekatZahtev();
        toZahtev.setOperacija(Konstante.VRATI_AUTOBUSE);
        Komunikacija.getInstance().posaljiZahtev(toZahtev);
        TransferObjekatOdgovor toOdgovor = Komunikacija.getInstance().primiOdgovor();
        if (toOdgovor.getIzuzetak() != null) {
            throw new Exception(toOdgovor.getPoruka());
        }

        jcbAutobus.setModel(new DefaultComboBoxModel(((List<Svemirskiautobus>) toOdgovor.getRezultat()).toArray()));
    }

    private void popuniComboBoxPlaneta(JComboBox jcbPlaneta) throws Exception {
        TransferObjekatZahtev toZahtev = new TransferObjekatZahtev();
        toZahtev.setOperacija(Konstante.VRATI_PLANETE);
        Komunikacija.getInstance().posaljiZahtev(toZahtev);
        TransferObjekatOdgovor toOdgovor = Komunikacija.getInstance().primiOdgovor();
        if (toOdgovor.getIzuzetak() != null) {
            throw new Exception(toOdgovor.getPoruka());
        }

        jcbPlaneta.setModel(new DefaultComboBoxModel(((List<Planeta>) toOdgovor.getRezultat()).toArray()));
    }

    private void popuniComboBoxZalihe(JComboBox jcbZalihe) throws Exception {
        TransferObjekatZahtev toZahtev = new TransferObjekatZahtev();
        toZahtev.setOperacija(Konstante.VRATI_ZALIHE);
        Komunikacija.getInstance().posaljiZahtev(toZahtev);
        TransferObjekatOdgovor toOdgovor = Komunikacija.getInstance().primiOdgovor();
        if (toOdgovor.getIzuzetak() != null) {
            throw new Exception(toOdgovor.getPoruka());
        }

        jcbZalihe.setModel(new DefaultComboBoxModel(((List<Zalihe>) toOdgovor.getRezultat()).toArray()));
    }

    private void popuniTabelu(JTable jtblStavke) {
        StavkaPorudzbeniceTableModel sptm;
        if (porudzbenica == null) {
            sptm = new StavkaPorudzbeniceTableModel(null);
        } else {
            sptm = new StavkaPorudzbeniceTableModel(porudzbenica.getStavkaporudzbeniceList());
        }
        jtblStavke.setModel(sptm);
        sptm.fireTableDataChanged();

    }

    public void dodajStavku(FMPorudzbenica fm) {
        try {
            Stavkaporudzbenice sp = kreirajStavku(fm);
            List<Stavkaporudzbenice> stavke = porudzbenica.getStavkaporudzbeniceList();
            for (Stavkaporudzbenice s : stavke) {
                if (s.getZalihe().equals(sp.getZalihe())) {
                    s.setKolicina(s.getKolicina() + sp.getKolicina());
                    popuniTabelu(fm.getJtblStavke());
                    return;
                }
            }
            stavke.add(sp);
            dodeliRedniBrojStavkama();
            popuniTabelu(fm.getJtblStavke());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(fm, e.getMessage());
            e.printStackTrace();
        }
    }

    private Stavkaporudzbenice kreirajStavku(FMPorudzbenica fm) throws Exception {
        validirajStavku(fm);

        double kolicina = Double.parseDouble(fm.getJsKolicina().getValue().toString());
        String jedinica = fm.getJtxtJedinicaMere().getText().trim();
        Zalihe zalihe = (Zalihe) fm.getJcbZalihe().getSelectedItem();

        Stavkaporudzbenice s = new Stavkaporudzbenice();
        s.setKolicina(kolicina);
        s.setZalihe(zalihe);
        s.setJedinicaMere(jedinica);

        return s;

    }

    public void azurirajSifru(FMPorudzbenica fm) {
        Svemirskiautobus autobus = (Svemirskiautobus) fm.getJcbAutobus().getSelectedItem();
        Planeta planeta = (Planeta) fm.getJcbPlaneta().getSelectedItem();
        String porudzbenicaID = "SIF-" + autobus.getAutobusID() + "-" + planeta.getPlanetaID();
        Date datum = fm.getJdpDatePicker().getDate();
        if (datum != null) {
            DateFormat df = new SimpleDateFormat("dd-MM-yy");
            porudzbenicaID += "-" + df.format(datum);
        }
        if (porudzbenica != null) {
            porudzbenica.setPorudzbenicaID(porudzbenicaID);
        }
        fm.getJtxtBrojPorudzbenice().setText(porudzbenicaID);
    }

    public void obrisiStavku(FMPorudzbenica fm) {
        try {
            int red = fm.getJtblStavke().getSelectedRow();
            if (red == -1) {
                throw new Exception("Morate izabrati stavku iz tabele");
            }
            porudzbenica.getStavkaporudzbeniceList().remove(red);
            dodeliRedniBrojStavkama();
            popuniTabelu(fm.getJtblStavke());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(fm, e.getMessage());
            e.printStackTrace();
        }
    }

    private void dodeliRedniBrojStavkama() {
        List<Stavkaporudzbenice> ls = porudzbenica.getStavkaporudzbeniceList();
        int i = 1;
        for (Stavkaporudzbenice s : ls) {
            s.setRb(i);
            i++;
        }
    }

    public void sacuvajPorudzbenicu(FMPorudzbenica fm) {
        try {
            kreirajPorudzbenicu(fm);

            TransferObjekatZahtev toZahtev = new TransferObjekatZahtev();
            toZahtev.setOperacija(Konstante.SACUVAJ_PORUDZBENICU);
            toZahtev.setParametar(porudzbenica);
            Komunikacija.getInstance().posaljiZahtev(toZahtev);
            TransferObjekatOdgovor toOdgovor = Komunikacija.getInstance().primiOdgovor();
            if (toOdgovor.getIzuzetak() == null) {
                JOptionPane.showMessageDialog(fm, "Porudzbenica je sacuvana!");
            } else {
                throw new Exception(toOdgovor.getPoruka());
            }

            porudzbenica = new Porudzbenica();
            porudzbenica.setStavkaporudzbeniceList(new LinkedList<Stavkaporudzbenice>());
            srediFormu(fm);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(fm, ex.getMessage());
            ex.printStackTrace();
        }
    }

    private void kreirajPorudzbenicu(FMPorudzbenica fm) throws Exception {
        validirajPorudzbenicu(fm);
        try {
            porudzbenica.setPorudzbenicaID(fm.getJtxtBrojPorudzbenice().getText().trim());
            porudzbenica.setAutobus((Svemirskiautobus) fm.getJcbAutobus().getSelectedItem());
            porudzbenica.setPlaneta((Planeta) fm.getJcbPlaneta().getSelectedItem());
            porudzbenica.setDatum(fm.getJdpDatePicker().getDate());
            List<Stavkaporudzbenice> ls = porudzbenica.getStavkaporudzbeniceList();
            for (Stavkaporudzbenice s : ls) {
                s.setPorudzbenica(porudzbenica);
            }
        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
            throw new Exception("Broj porudzbenice mora biti ceo broj");
        }

    }

    private void validirajStavku(FMPorudzbenica fm) throws Exception {
        if (Double.parseDouble(fm.getJsKolicina().getValue().toString()) == 0) {
            throw new Exception("Kolicina mora biti veca od 0");
        }
        proveriDaLiJePrazno(fm.getJtxtJedinicaMere(), "Jedinica mere");
    }

    private void proveriDaLiJePrazno(JTextField jtxt, String polje) throws Exception {
        if (jtxt.getText().trim().isEmpty()) {
            throw new Exception(polje + " ne sme biti prazno");
        }
    }

    private void validirajPorudzbenicu(FMPorudzbenica fm) throws Exception {
        if (porudzbenica.getStavkaporudzbeniceList().isEmpty()) {
            throw new Exception("Porudzbenica mora imati bar jednu stavku");
        }
        if (fm.getJdpDatePicker().getDate() == null) {
            throw new Exception("Morate izabrati datum");
        }
    }

}
