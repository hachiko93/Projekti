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
public class Svemirskiautobus implements OpstiDomenskiObjekat {
    private Integer autobusID;
    private String naziv;
    private int maksimalanbrojsedista;

    public Svemirskiautobus() {
    }

    public Svemirskiautobus(Integer autobusID) {
        this.autobusID = autobusID;
    }

    public Svemirskiautobus(Integer autobusID, String naziv, int maksimalanbrojsedista) {
        this.autobusID = autobusID;
        this.naziv = naziv;
        this.maksimalanbrojsedista = maksimalanbrojsedista;
    }

    public Integer getAutobusID() {
        return autobusID;
    }

    public void setAutobusID(Integer autobusID) {
        this.autobusID = autobusID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getMaksimalanbrojsedista() {
        return maksimalanbrojsedista;
    }

    public void setMaksimalanbrojsedista(int maksimalanbrojsedista) {
        this.maksimalanbrojsedista = maksimalanbrojsedista;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (autobusID != null ? autobusID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Svemirskiautobus)) {
            return false;
        }
        Svemirskiautobus other = (Svemirskiautobus) object;
        if ((this.autobusID == null && other.autobusID != null) || (this.autobusID != null && !this.autobusID.equals(other.autobusID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return naziv+", "+autobusID;
    }

    @Override
    public String vratiNazivTabele() {
        return "SvemirskiAutobus";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return "'"+naziv+"', "+maksimalanbrojsedista;
    }

    @Override
    public List<OpstiDomenskiObjekat> ucitaj(ResultSet rs) throws Exception {
        try {
            List<OpstiDomenskiObjekat> la = new LinkedList<>();
            while (rs.next()) {
            Svemirskiautobus sa = new Svemirskiautobus();
            sa.setAutobusID(rs.getInt(1));
            sa.setNaziv(rs.getString(2));
            sa.setMaksimalanbrojsedista(rs.getInt(3));
            la.add(sa);
        }
            return la;
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
        return "naziv, maximalanbrojsedista";
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
