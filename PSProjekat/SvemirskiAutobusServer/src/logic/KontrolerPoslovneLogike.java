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
import so.autobus.VratiAutobuseSO;
import so.planeta.NadjiPlaneteSO;
import so.planeta.SacuvajPlanetuSO;
import so.planeta.VratiPlaneteSO;
import so.porudzbenica.SacuvajPorudzbenicuSO;
import so.profaktura.SacuvajProfakturuSO;
import so.putnik.IzmeniPutnikaSO;
import so.putnik.NadjiPutnikeSO;
import so.putnik.SacuvajPutnikaSO;
import so.putnik.VratiPutnikeSO;
import so.zalihe.VratiZaliheSO;

/**
 *
 * @author Licina
 */
public class KontrolerPoslovneLogike {

    public static List<OpstiDomenskiObjekat> vratiListuPlaneta() throws Exception {
        OpstaSO vratiPlaneteSO = new VratiPlaneteSO();
        vratiPlaneteSO.izvrsenjeSO(new Planeta());
        return ((VratiPlaneteSO) vratiPlaneteSO).getLd();
    }

    public static List<OpstiDomenskiObjekat> vratiListuPutnika() throws Exception {
        OpstaSO vratiPutnikeSO = new VratiPutnikeSO();
        vratiPutnikeSO.izvrsenjeSO(new Putnik());
        return ((VratiPutnikeSO) vratiPutnikeSO).getLd();
    }

    public static List<OpstiDomenskiObjekat> vratiListuZaliha() throws Exception {
        OpstaSO vratiZaliheSO = new VratiZaliheSO();
        vratiZaliheSO.izvrsenjeSO(new Zalihe());
        return ((VratiZaliheSO) vratiZaliheSO).getLd();
    }

    public static List<OpstiDomenskiObjekat> vratiListuAutobusa() throws Exception {
        OpstaSO vratiAutobuseSO = new VratiAutobuseSO();
        vratiAutobuseSO.izvrsenjeSO(new Svemirskiautobus());
        return ((VratiAutobuseSO) vratiAutobuseSO).getLd();
    }

    public static void sacuvajPutnika(Putnik p) throws Exception {
        OpstaSO sacuvajPutnikaSO = new SacuvajPutnikaSO();
        sacuvajPutnikaSO.izvrsenjeSO(p);
    }

    public static void sacuvajPlanetu(Planeta p) throws Exception {
        OpstaSO sacuvajPlanetuSO = new SacuvajPlanetuSO();
        sacuvajPlanetuSO.izvrsenjeSO(p);
    }

    public static void sacuvajProfakturu(Profaktura p) throws Exception {
        OpstaSO sacuvajProfakturuSO = new SacuvajProfakturuSO();
        sacuvajProfakturuSO.izvrsenjeSO(p);
    }

    public static void sacuvajPorudzbenicu(Porudzbenica p) throws Exception {
        OpstaSO sacuvajPorudzbenicuSO = new SacuvajPorudzbenicuSO();
        sacuvajPorudzbenicuSO.izvrsenjeSO(p);
    }

    public static void izmeniPutnika(Putnik p) throws Exception {
        OpstaSO izmeniPutnikaSO = new IzmeniPutnikaSO();
        izmeniPutnikaSO.izvrsenjeSO(p);
    }

    public static List<OpstiDomenskiObjekat> nadjiPutnike(String imeprezime) throws Exception {
        OpstaSO nadjiPutnikeSO = new NadjiPutnikeSO();
        ((NadjiPutnikeSO)nadjiPutnikeSO).setKriterijum(imeprezime);
        nadjiPutnikeSO.izvrsenjeSO(new Putnik());
        return ((NadjiPutnikeSO) nadjiPutnikeSO).getLd();
    }

    public static List<OpstiDomenskiObjekat> nadjiPlanete(String naziv) throws Exception {
        OpstaSO nadjiPlaneteSO = new NadjiPlaneteSO();
        ((NadjiPlaneteSO)nadjiPlaneteSO).setKriterijum(naziv);
        nadjiPlaneteSO.izvrsenjeSO(new Planeta());
        return ((NadjiPlaneteSO) nadjiPlaneteSO).getLd();
    }
}

