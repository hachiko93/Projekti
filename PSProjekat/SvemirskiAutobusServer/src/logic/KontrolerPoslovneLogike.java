    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import domen.OpstiDomenskiObjekat;
import domen.Planeta;
import domen.Porudzbenica;
import domen.Profaktura;
import domen.Putnik;
import domen.Svemirskiautobus;
import domen.Zalihe;
import java.util.List;
import so.OpstaSO;
import so.autobus.UcitajListuAutobusaSO;
import so.planeta.PretraziPlaneteSO;
import so.planeta.ZapamtiPlanetuSO;
import so.planeta.UcitajListuPlanetaSO;
import so.porudzbenica.ZapamtiPorudzbenicuSO;
import so.profaktura.ZapamtiProfakturuSO;
import so.putnik.IzmeniPutnikaSO;
import so.putnik.PretraziPutnikeSO;
import so.putnik.ZapamtiPutnikaSO;
import so.putnik.UcitajListuPutnikaSO;
import so.zalihe.UcitajListuZalihaSO;

/**
 *
 * @author Licina
 */
public class KontrolerPoslovneLogike {

    public static List<OpstiDomenskiObjekat> vratiListuPlaneta() throws Exception {
        OpstaSO vratiPlaneteSO = new UcitajListuPlanetaSO();
        vratiPlaneteSO.izvrsenjeSO(new Planeta());
        return ((UcitajListuPlanetaSO) vratiPlaneteSO).getLd();
    }

    public static List<OpstiDomenskiObjekat> vratiListuPutnika() throws Exception {
        OpstaSO vratiPutnikeSO = new UcitajListuPutnikaSO();
        vratiPutnikeSO.izvrsenjeSO(new Putnik());
        return ((UcitajListuPutnikaSO) vratiPutnikeSO).getLd();
    }

    public static List<OpstiDomenskiObjekat> vratiListuZaliha() throws Exception {
        OpstaSO vratiZaliheSO = new UcitajListuZalihaSO();
        vratiZaliheSO.izvrsenjeSO(new Zalihe());
        return ((UcitajListuZalihaSO) vratiZaliheSO).getLd();
    }

    public static List<OpstiDomenskiObjekat> vratiListuAutobusa() throws Exception {
        OpstaSO vratiAutobuseSO = new UcitajListuAutobusaSO();
        vratiAutobuseSO.izvrsenjeSO(new Svemirskiautobus());
        return ((UcitajListuAutobusaSO) vratiAutobuseSO).getLd();
    }

    public static void sacuvajPutnika(Putnik p) throws Exception {
        OpstaSO sacuvajPutnikaSO = new ZapamtiPutnikaSO();
        sacuvajPutnikaSO.izvrsenjeSO(p);
    }

    public static void sacuvajPlanetu(Planeta p) throws Exception {
        OpstaSO sacuvajPlanetuSO = new ZapamtiPlanetuSO();
        sacuvajPlanetuSO.izvrsenjeSO(p);
    }

    public static void sacuvajProfakturu(Profaktura p) throws Exception {
        OpstaSO sacuvajProfakturuSO = new ZapamtiProfakturuSO();
        sacuvajProfakturuSO.izvrsenjeSO(p);
    }

    public static void sacuvajPorudzbenicu(Porudzbenica p) throws Exception {
        OpstaSO sacuvajPorudzbenicuSO = new ZapamtiPorudzbenicuSO();
        sacuvajPorudzbenicuSO.izvrsenjeSO(p);
    }

    public static void izmeniPutnika(Putnik p) throws Exception {
        OpstaSO izmeniPutnikaSO = new IzmeniPutnikaSO();
        izmeniPutnikaSO.izvrsenjeSO(p);
    }

    public static List<OpstiDomenskiObjekat> nadjiPutnike(String imeprezime) throws Exception {
        OpstaSO nadjiPutnikeSO = new PretraziPutnikeSO();
        ((PretraziPutnikeSO)nadjiPutnikeSO).setKriterijum(imeprezime);
        nadjiPutnikeSO.izvrsenjeSO(new Putnik());
        return ((PretraziPutnikeSO) nadjiPutnikeSO).getLd();
    }

    public static List<OpstiDomenskiObjekat> nadjiPlanete(String naziv) throws Exception {
        OpstaSO nadjiPlaneteSO = new PretraziPlaneteSO();
        ((PretraziPlaneteSO)nadjiPlaneteSO).setKriterijum(naziv);
        nadjiPlaneteSO.izvrsenjeSO(new Planeta());
        return ((PretraziPlaneteSO) nadjiPlaneteSO).getLd();
    }
}

