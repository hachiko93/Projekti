/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komunikacija;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import logic.Kontroler;
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
    private String rec;

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
                switch (toZahtev.getOperacija()) {
                    case Konstante.ULOGUJ_SE:
                        
                        break;
                    case Konstante.VRATI_GRADOVE:
                        List<String> lg = Kontroler.getInstance().getGradovi();
                        rec = izaberiJedan(lg).toUpperCase();
                        toOdgovor.setRezultat(zameniRec(rec));
                        break;
                    case Konstante.VRATI_PREDMETE:
                        List<String> lp = Kontroler.getInstance().getPredmeti();
                        rec = izaberiJedan(lp).toUpperCase();
                        toOdgovor.setRezultat(zameniRec(rec));
                        break;
                    case Konstante.VRATI_TIMOVE:
                        List<String> lt = Kontroler.getInstance().getTimovi();
                        rec = izaberiJedan(lt).toUpperCase();
                        toOdgovor.setRezultat(zameniRec(rec));
                        break;
                    case Konstante.PROBAJ_SLOVO:
                        char slovo = toZahtev.getParametar().toString().toUpperCase().toCharArray()[0];
                        char[] recNiz = rec.toCharArray();
                        List<Integer> mesta = new LinkedList<>();
                        boolean nadjeno = false;
                        for (int i = 0; i < rec.length(); i++) {
                            if (recNiz[i] == slovo) {
                                mesta.add(i);
                                nadjeno = true;
                            }
                        }
                        if (!nadjeno) {
                            toOdgovor.setRezultat(null);
                            toOdgovor.setPoruka("Slovo ne postoji");
                        } else {
                            toOdgovor.setRezultat(mesta);
                            toOdgovor.setPoruka("Slovo je tacno");
                        }
                        break;
                        case Konstante.KRAJ_IGRE:
                        toOdgovor.setRezultat(rec);
                        break;
                    case Konstante.KRAJ_RADA:
                        
                        aktivna = false;
                        break;
                }
            } catch (Exception ex) {
                toOdgovor.setPoruka(ex.getMessage());
                toOdgovor.setIzuzetak(ex);
            }
            posaljiOdgovor(toOdgovor);
        }
    }

    private void posaljiOdgovor(TransferObjekatOdgovor toOdgovor) throws IOException {
        ObjectOutputStream outSocket = new ObjectOutputStream(socket.getOutputStream());
        outSocket.writeObject(toOdgovor);
    }

    private String izaberiJedan(List<String> lm) {
        Random random = new Random();
        int index = random.nextInt(lm.size());
        return lm.get(index);
    }

    private String zameniRec(String rec) {
        char[] recNiz = rec.toCharArray();
        for (int i = 0; i < rec.length(); i++) {
            if (!Character.isWhitespace(recNiz[i])) {
                recNiz[i] = '*';
            }
        }
        return new String(recNiz);
    }

}
