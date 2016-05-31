/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.putnik;

import db.DatabaseBroker;
import domen.OpstiDomenskiObjekat;
import domen.Putnik;
import java.util.List;
import so.OpstaSO;

/**
 *
 * @author Hachiko
 */
public class NadjiPutnikeSO extends OpstaSO{

    private String kriterijum;
    List<OpstiDomenskiObjekat> ld;
    
    @Override
    protected void proveriPreduslov(Object obj) throws Exception {
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object obj) throws Exception {
       ld = DatabaseBroker.getInstanca().nadji((Putnik)obj, kriterijum);
    }

    public String getKriterijum() {
        return kriterijum;
    }

    public void setKriterijum(String kriterijum) {
        this.kriterijum = kriterijum;
    }

    public List<OpstiDomenskiObjekat> getLd() {
        return ld;
    }

    public void setLd(List<OpstiDomenskiObjekat> ld) {
        this.ld = ld;
    }
    
}
