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
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Licina
 */
public class Zalihe implements OpstiDomenskiObjekat {
    private Integer zaliheID;
    private String tip;
    private String naziv;
    private double stanje;
    private List<Stavkaporudzbenice> stavkaporudzbeniceList;

    public Zalihe() {
    }

    public Zalihe(Integer zaliheID) {
        this.zaliheID = zaliheID;
    }

    public Zalihe(Integer zaliheID, String tip, String naziv, double stanje) {
        this.zaliheID = zaliheID;
        this.tip = tip;
        this.naziv = naziv;
        this.stanje = stanje;
    }

    public Integer getZaliheID() {
        return zaliheID;
    }

    public void setZaliheID(Integer zaliheID) {
        this.zaliheID = zaliheID;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public double getStanje() {
        return stanje;
    }

    public void setStanje(double stanje) {
        this.stanje = stanje;
    }

    @XmlTransient
    public List<Stavkaporudzbenice> getStavkaporudzbeniceList() {
        return stavkaporudzbeniceList;
    }

    public void setStavkaporudzbeniceList(List<Stavkaporudzbenice> stavkaporudzbeniceList) {
        this.stavkaporudzbeniceList = stavkaporudzbeniceList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (zaliheID != null ? zaliheID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Zalihe)) {
            return false;
        }
        Zalihe other = (Zalihe) object;
        if ((this.zaliheID == null && other.zaliheID != null) || (this.zaliheID != null && !this.zaliheID.equals(other.zaliheID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return naziv;
    }

    @Override
    public String vratiNazivTabele() {
        return "Zalihe";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return "'"+tip+"', '"+naziv+"', "+stanje;
    }

    @Override
    public List<OpstiDomenskiObjekat> ucitaj(ResultSet rs) throws Exception {
        try {
            List<OpstiDomenskiObjekat> lz = new LinkedList<>();
            while (rs.next()) {
            Zalihe z = new Zalihe();
            z.setZaliheID(rs.getInt(1));
            z.setTip(rs.getString(2));
            z.setNaziv(rs.getString(3));
            z.setStanje(rs.getDouble(4));
            lz.add(z);
        }
            return lz;
        } catch (Exception e) {
            throw e;
        }
    }

    
    @Override
    public String[] vratiID() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResultSet daLiPostoji(PreparedStatement st) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiKriterijum() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiAtributeZaInsert() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
