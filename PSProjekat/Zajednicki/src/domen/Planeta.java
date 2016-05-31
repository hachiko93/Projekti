/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Licina
 */
public class Planeta implements OpstiDomenskiObjekat {
    private Integer planetaID;
    private String koordinate;
    private String naziv;
    private double udaljenostOdZemlje;

    public Planeta() {
    }

    public Planeta(Integer planetaID) {
        this.planetaID = planetaID;
    }

    public Planeta(Integer planetaID, String koordinate, String naziv, double udaljenostOdZemlje) {
        this.planetaID = planetaID;
        this.koordinate = koordinate;
        this.naziv = naziv;
        this.udaljenostOdZemlje = udaljenostOdZemlje;
    }

    public Integer getPlanetaID() {
        return planetaID;
    }

    public void setPlanetaID(Integer planetaID) {
        this.planetaID = planetaID;
    }

    public String getKoordinate() {
        return koordinate;
    }

    public void setKoordinate(String koordinate) {
        this.koordinate = koordinate;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public double getUdaljenostOdZemlje() {
        return udaljenostOdZemlje;
    }

    public void setUdaljenostOdZemlje(double udaljenostOdZemlje) {
        this.udaljenostOdZemlje = udaljenostOdZemlje;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (planetaID != null ? planetaID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Planeta)) {
            return false;
        }
        Planeta other = (Planeta) object;
        if ((this.planetaID == null && other.planetaID != null) || (this.planetaID != null && !this.planetaID.equals(other.planetaID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return naziv+", "+koordinate;
    }

    @Override
    public String vratiNazivTabele() {
        return "Planeta";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        //fali id
        return koordinate+", '"+naziv+"', "+udaljenostOdZemlje;
    }

    @Override
    public List<OpstiDomenskiObjekat> ucitaj(ResultSet rs) throws Exception {
        try {
            List<OpstiDomenskiObjekat> lp = new LinkedList<>();
            while (rs.next()) {
                Planeta p = new Planeta();
                p.setPlanetaID(rs.getInt(1));
                p.setKoordinate(rs.getString(2));
                p.setNaziv(rs.getString(3));
                p.setUdaljenostOdZemlje(rs.getDouble(4));
                lp.add(p);
            }
            return lp;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public String[] vratiID() {
        return new String []{"koordinate", "naziv"};
    }

    @Override
    public ResultSet daLiPostoji(PreparedStatement st) throws Exception {
        st.setString(1, koordinate);
        st.setString(2, naziv);
        return st.executeQuery();
    }

    @Override
    public String vratiKriterijum() {
        return "naziv";
    }

    @Override
    public String vratiAtributeZaInsert() {
        return "koordinate, naziv, udaljenostOdZemlje";
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
