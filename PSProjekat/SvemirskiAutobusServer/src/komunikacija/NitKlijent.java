/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komunikacija;

import domen.OpstiDomenskiObjekat;
import domen.Planeta;
import domen.Porudzbenica;
import domen.Profaktura;
import domen.Putnik;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import logic.KontrolerPoslovneLogike;
import transfer.TransferObjekatOdgovor;
import transfer.TransferObjekatZahtev;
import util.Konstante;

/**
 *
 * @author student1
 */
public class NitKlijent extends Thread {

    private Socket socket;
    private boolean aktivna;

    public NitKlijent(Socket socket) {
        this.socket = socket;
        this.aktivna = true;
    }

    @Override
    public void run() {
        try {
            izvrsenjeOperacija();
        } catch (Exception ex) {
            ex.printStackTrace();
            aktivna = false;
        }
        System.out.println("Nit je regularno zavrsila rad.");
    }

    private void izvrsenjeOperacija() throws IOException, ClassNotFoundException {
        while (aktivna) {
            ObjectInputStream inSocket = new ObjectInputStream(socket.getInputStream());
            TransferObjekatZahtev toZahtev = (TransferObjekatZahtev) inSocket.readObject();
            TransferObjekatOdgovor toOdgovor = new TransferObjekatOdgovor();
            try {
                System.out.println("O: " + toZahtev.getOperacija());
                switch (toZahtev.getOperacija()) {
                    case Konstante.VRATI_PLANETE:
                        List<OpstiDomenskiObjekat> lp = KontrolerPoslovneLogike.vratiListuPlaneta();
                        toOdgovor.setRezultat(lp);
                        toOdgovor.setPoruka("Planete su ucitane.");
                        break;
                    case Konstante.VRATI_ZALIHE:
                        List<OpstiDomenskiObjekat> lz = KontrolerPoslovneLogike.vratiListuZaliha();
                        toOdgovor.setRezultat(lz);
                        toOdgovor.setPoruka("Zalihe su ucitane.");
                        break;
                    case Konstante.VRATI_PUTNIKE:
                        List<OpstiDomenskiObjekat> lpu = KontrolerPoslovneLogike.vratiListuPutnika();
                        toOdgovor.setRezultat(lpu);
                        toOdgovor.setPoruka("Putnici su ucitani.");
                        break;
                    case Konstante.VRATI_AUTOBUSE:
                        List<OpstiDomenskiObjekat> la = KontrolerPoslovneLogike.vratiListuAutobusa();
                        toOdgovor.setRezultat(la);
                        toOdgovor.setPoruka("Autobusi su ucitani.");
                        break;
                    case Konstante.SACUVAJ_PUTNIKA:
                        Putnik p = (Putnik) toZahtev.getParametar();
                        KontrolerPoslovneLogike.sacuvajPutnika(p);
                        toOdgovor.setPoruka("Putnik je uspesno sacuvan");
                        break;
                    case Konstante.NADJI_PUTNIKE:
                        List<OpstiDomenskiObjekat> putnici = KontrolerPoslovneLogike.nadjiPutnike(toZahtev.getParametar().toString());
                        toOdgovor.setRezultat(putnici);
                        toOdgovor.setPoruka("Putnici nadjeni");
                        break;
                    case Konstante.NADJI_PLANETE:
                        List<OpstiDomenskiObjekat> planete = KontrolerPoslovneLogike.nadjiPlanete(toZahtev.getParametar().toString());
                        toOdgovor.setRezultat(planete);
                        toOdgovor.setPoruka("Planete nadjene");
                        break;
                    case Konstante.SACUVAJ_PLANETU:
                        Planeta pl = (Planeta) toZahtev.getParametar();
                        KontrolerPoslovneLogike.sacuvajPlanetu(pl);
                        toOdgovor.setPoruka("Planeta je uspesno sacuvana");
                        break;
                    case Konstante.SACUVAJ_PROFAKTURU:
                        Profaktura pr = (Profaktura) toZahtev.getParametar();
                        KontrolerPoslovneLogike.sacuvajProfakturu(pr);
                        toOdgovor.setPoruka("Profaktura je uspesno sacuvana");
                        break;
                    case Konstante.SACUVAJ_PORUDZBENICU:
                        Porudzbenica po = (Porudzbenica) toZahtev.getParametar();
                        KontrolerPoslovneLogike.sacuvajPorudzbenicu(po);
                        toOdgovor.setPoruka("Porudzbenica je uspesno sacuvana");
                        break;
                    case Konstante.IZMENI_PUTNIKA:
                        Putnik pu = (Putnik) toZahtev.getParametar();
                        KontrolerPoslovneLogike.izmeniPutnika(pu);
                        toOdgovor.setPoruka("Putnik je uspesno izmenjen");
                        break;
                }
            } catch (Exception ex) {
                toOdgovor.setPoruka(ex.getMessage());
                toOdgovor.setIzuzetak(ex);
                ex.printStackTrace();
            }
            posaljiOdgovor(toOdgovor);
        }
    }

    private void posaljiOdgovor(TransferObjekatOdgovor toOdgovor) throws IOException {
        ObjectOutputStream outSocket = new ObjectOutputStream(socket.getOutputStream());
        outSocket.writeObject(toOdgovor);
    }

}
