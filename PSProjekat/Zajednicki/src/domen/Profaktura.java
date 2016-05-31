/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Licina
 */
public class Profaktura implements OpstiDomenskiObjekat {

    private String profakturaID;
    private double iznos;
    private Date datum;
    private Putnik putnik;
    private Planeta planeta;
    private Svemirskiautobus autobus;

    public Profaktura() {
    }

    public Profaktura(String profakturaID, Putnik p) {
        this.profakturaID = profakturaID;
        this.putnik = p;
    }

    public Profaktura(String profakturaID, Putnik p, double iznos, Date datum) {
        this.profakturaID = profakturaID;
        this.putnik = p;
        this.iznos = iznos;
        this.datum = datum;
    }

    public String getProfakturaID() {
        return profakturaID;
    }

    public void setProfakturaID(String profakturaID) {
        this.profakturaID = profakturaID;
    }

    public double getIznos() {
        return iznos;
    }

    public void setIznos(double iznos) {
        this.iznos = iznos;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Putnik getPutnik() {
        return putnik;
    }

    public void setPutnik(Putnik putnik) {
        this.putnik = putnik;
    }

    public Planeta getPlaneta() {
        return planeta;
    }

    public void setPlaneta(Planeta planeta) {
        this.planeta = planeta;
    }

    public Svemirskiautobus getAutobus() {
        return autobus;
    }

    public void setAutobus(Svemirskiautobus autobus) {
        this.autobus = autobus;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + Objects.hashCode(this.profakturaID);
        hash = 19 * hash + Objects.hashCode(this.putnik);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Profaktura other = (Profaktura) obj;
        if (!Objects.equals(this.profakturaID, other.profakturaID)) {
            return false;
        }
        if (!Objects.equals(this.putnik, other.putnik)) {
            return false;
        }
        return true;
    }

   

    @Override
    public String toString() {
        return "domen.Profaktura[ profakturaPK=" + profakturaID + " ]";
    }

    @Override
    public String vratiNazivTabele() {
        return "Profaktura";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return "'"+profakturaID+"', "+putnik.getPutnikID()+", "+autobus.getAutobusID()+", "+planeta.getPlanetaID()+", "+iznos+", '"+(new SimpleDateFormat("yyyy-MM-dd").format(datum))+"'"; //sto nece
    }

    @Override
    public List<OpstiDomenskiObjekat> ucitaj(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String[] vratiID() {
        return new String[] {"profakturaID"};
    }

    @Override
    public ResultSet daLiPostoji(PreparedStatement st) throws Exception {
        st.setString(1, profakturaID);
        return st.executeQuery();
    }

    @Override
    public String vratiKriterijum() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiAtributeZaInsert() {
        return null;
    }

    @Override
    public String vratiAtributeZaUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void dodeliVrednosti(PreparedStatement st) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiIDUBazi() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void dodeliVrednostiZaUpdate(PreparedStatement st) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
