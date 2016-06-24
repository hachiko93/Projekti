/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.porudzbenica;

import db.DatabaseBroker;
import domen.Porudzbenica;
import domen.Stavkaporudzbenice;
import java.util.List;
import so.OpstaSO;

/**
 *
 * @author Hachiko
 */
public class ZapamtiPorudzbenicuSO extends OpstaSO{
    @Override
    protected void proveriPreduslov(Object obj) throws Exception {
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object obj) throws Exception {
        Porudzbenica p = (Porudzbenica)obj;
        List<Stavkaporudzbenice> ls = p.getStavkaporudzbeniceList();
        
        DatabaseBroker.getInstanca().sacuvaj(p);
        for (Stavkaporudzbenice s : ls) {
            DatabaseBroker.getInstanca().sacuvaj(s);
        }
        
    }
}
