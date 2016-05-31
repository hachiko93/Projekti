/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler.putnik;

import domen.Planeta;
import domen.Profaktura;
import domen.Putnik;
import domen.Svemirskiautobus;
import forme.putnik.FMProfaktura;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;
import transfer.TransferObjekatOdgovor;
import transfer.TransferObjekatZahtev;
import util.Konstante;

/**
 *
 * @author Licina
 */
public class KontrolerProfaktura {

    private Profaktura profaktura;

    public KontrolerProfaktura() {
        profaktura = new Profaktura();
    }

    public void srediFormu(FMProfaktura fm) {
        try {
            popuniComboBoxAutobus(fm.getJcbAutobus());
            popuniComboBoxPutnik(fm.getJcbPutnik());
            popuniComboBoxPlaneta(fm.getJcbPlaneta());
            popuniIznos(fm);
            fm.getJdpDatum().setFormats(new SimpleDateFormat("dd.MM.yyyy"));
            fm.getJdpDatum().setDate(null);
            azurirajProfakturaID(fm);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(fm, e.getMessage());
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

    private void popuniComboBoxPutnik(JComboBox jcbPutnik) throws Exception {
        TransferObjekatZahtev toZahtev = new TransferObjekatZahtev();
        toZahtev.setOperacija(Konstante.VRATI_PUTNIKE);
        Komunikacija.getInstance().posaljiZahtev(toZahtev);
        TransferObjekatOdgovor toOdgovor = Komunikacija.getInstance().primiOdgovor();
        if (toOdgovor.getIzuzetak() != null) {
            throw new Exception(toOdgovor.getPoruka());
        }

        jcbPutnik.setModel(new DefaultComboBoxModel(((List<Putnik>) toOdgovor.getRezultat()).toArray()));
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

    private void popuniIznos(FMProfaktura fm) {
        double udaljenost = ((Planeta) fm.getJcbPlaneta().getSelectedItem()).getUdaljenostOdZemlje() * 0.05;
        fm.getJtxtIznos().setText("" + udaljenost);
    }

    public void sacuvajProfakturu(FMProfaktura fm) {
        try {
            kreirajProfakturu(fm);

            TransferObjekatZahtev toZahtev = new TransferObjekatZahtev();
            toZahtev.setOperacija(Konstante.SACUVAJ_PROFAKTURU);
            toZahtev.setParametar(profaktura);
            Komunikacija.getInstance().posaljiZahtev(toZahtev);
            TransferObjekatOdgovor toOdgovor = Komunikacija.getInstance().primiOdgovor();
            if (toOdgovor.getIzuzetak() == null) {
                JOptionPane.showMessageDialog(fm, "Profaktura je sacuvana!");
                srediFormu(fm);
            } else {
                throw new Exception(toOdgovor.getPoruka());
            }
            profaktura = new Profaktura();
            srediFormu(fm);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(fm, ex.getMessage());
            ex.printStackTrace();
        }
    }

    private void kreirajProfakturu(FMProfaktura fm) throws Exception {
        if (fm.getJdpDatum().getDate() == null) {
            throw new Exception("Morate izabrati datum");
        }
        try {
            String profakturaID = fm.getJtxtBrojProfakture().getText().trim();
            Putnik putnik = (Putnik) fm.getJcbPutnik().getSelectedItem();
            Planeta planeta = (Planeta) fm.getJcbPlaneta().getSelectedItem();
            Svemirskiautobus autobus = (Svemirskiautobus) fm.getJcbAutobus().getSelectedItem();
            double iznos = Double.parseDouble(fm.getJtxtIznos().getText().trim());
            Date datum = fm.getJdpDatum().getDate();

            profaktura.setProfakturaID(profakturaID);
            profaktura.setPutnik(putnik);
            profaktura.setPlaneta(planeta);
            profaktura.setAutobus(autobus);
            profaktura.setIznos(iznos);
            profaktura.setDatum(datum);
        } catch (NumberFormatException nfe) {
            throw new Exception("Broj profakture mora biti ceo broj");
        }
    }

    public void azurirajProfakturaID(FMProfaktura fm) {
        Putnik putnik = (Putnik) fm.getJcbPutnik().getSelectedItem();
        Planeta planeta = (Planeta) fm.getJcbPlaneta().getSelectedItem();
        Svemirskiautobus autobus = (Svemirskiautobus) fm.getJcbAutobus().getSelectedItem();

        String profakturaID = "SIF-" + putnik.getPutnikID() + "-" + planeta.getPlanetaID() + "-" + autobus.getAutobusID();

        Date datum = fm.getJdpDatum().getDate();
        if (datum != null) {
            DateFormat df = new SimpleDateFormat("dd-MM-yy");
            profakturaID += "-" + df.format(datum);
        }
        profaktura.setProfakturaID(profakturaID);
        fm.getJtxtBrojProfakture().setText(profakturaID);

    }

}
