/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.putnik;

import db.DatabaseBroker;
import domen.Putnik;
import so.OpstaSO;

/**
 *
 * @author Hachiko
 */
public class ZapamtiPutnikaSO extends OpstaSO{

    @Override
    protected void proveriPreduslov(Object obj) throws Exception {
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object obj) throws Exception {
        DatabaseBroker.getInstanca().sacuvaj((Putnik)obj);
    }
    
}
