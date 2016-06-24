/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.profaktura;

import db.DatabaseBroker;
import domen.Profaktura;
import so.OpstaSO;

/**
 *
 * @author Hachiko
 */
public class ZapamtiProfakturuSO extends OpstaSO{
    @Override
    protected void proveriPreduslov(Object obj) throws Exception {
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object obj) throws Exception {
        DatabaseBroker.getInstanca().sacuvaj((Profaktura)obj);
    }
}
