/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.autobus;

import db.DatabaseBroker;
import domen.OpstiDomenskiObjekat;
import domen.Svemirskiautobus;
import java.util.List;
import so.OpstaSO;

/**
 *
 * @author Hachiko
 */
public class UcitajListuAutobusaSO extends OpstaSO{
    List<OpstiDomenskiObjekat> ld;
    
    @Override
    protected void proveriPreduslov(Object obj) throws Exception {
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object obj) throws Exception {
       ld = DatabaseBroker.getInstanca().vratiListu((Svemirskiautobus)obj);
    }

    public List<OpstiDomenskiObjekat> getLd() {
        return ld;
    }

    public void setLd(List<OpstiDomenskiObjekat> ld) {
        this.ld = ld;
    }
}
