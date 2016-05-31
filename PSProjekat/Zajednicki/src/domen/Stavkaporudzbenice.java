/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Licina
 */
public class Stavkaporudzbenice implements OpstiDomenskiObjekat {

    protected Integer rb;
    private double kolicina;
    private String jedinicaMere;
    private Zalihe zalihe;
    private Porudzbenica porudzbenica;

    public Stavkaporudzbenice() {
    }

    public Stavkaporudzbenice(Integer rb, Porudzbenica porudzbenica) {
        this.rb = rb;
        this.porudzbenica = porudzbenica;
    }

    public Stavkaporudzbenice(Integer rb, Porudzbenica porudzbenica, double kolicina, String jedinicaMere) {
        this.rb = rb;
        this.porudzbenica = porudzbenica;
        this.kolicina = kolicina;
        this.jedinicaMere = jedinicaMere;
    }

    public Integer getRb() {
        return rb;
    }

    public void setRb(Integer rb) {
        this.rb = rb;
    }

    public double getKolicina() {
        return kolicina;
    }

    public void setKolicina(double kolicina) {
        this.kolicina = kolicina;
    }

    public String getJedinicaMere() {
        return jedinicaMere;
    }

    public void setJedinicaMere(String jedinicaMere) {
        this.jedinicaMere = jedinicaMere;
    }

    public Zalihe getZalihe() {
        return zalihe;
    }

    public void setZalihe(Zalihe zalihe) {
        this.zalihe = zalihe;
    }

    public Porudzbenica getPorudzbenica() {
        return porudzbenica;
    }

    public void setPorudzbenica(Porudzbenica porudzbenica) {
        this.porudzbenica = porudzbenica;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.rb);
        hash = 53 * hash + Objects.hashCode(this.porudzbenica);
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
        final Stavkaporudzbenice other = (Stavkaporudzbenice) obj;
        if (!Objects.equals(this.rb, other.rb)) {
            return false;
        }
        if (!Objects.equals(this.porudzbenica, other.porudzbenica)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domen.Stavkaporudzbenice[ stavkaporudzbenicePK=" + rb + " ]";
    }

    @Override
    public String vratiNazivTabele() {
        return "stavkaPorudzbenice";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return rb + ", '" + porudzbenica.getPorudzbenicaID() + "', " + zalihe.getZaliheID() + ", " + kolicina + ", '" + jedinicaMere + "'";
    }

    @Override
    public List<OpstiDomenskiObjekat> ucitaj(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String[] vratiID() {
        return new String[]{"rb", "porudzbenicaID"};
    }

    @Override
    public ResultSet daLiPostoji(PreparedStatement st) throws Exception {
        st.setInt(1, rb);
        st.setString(2, porudzbenica.getPorudzbenicaID());
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
