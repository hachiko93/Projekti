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

/**
 *
 * @author Licina
 */
public class Porudzbenica implements OpstiDomenskiObjekat {
    private String porudzbenicaID;
    private Date datum;
    private List<Stavkaporudzbenice> stavkaporudzbeniceList;
    private Planeta planeta;
    private Svemirskiautobus autobus;

    public Porudzbenica() {
    }

    public Porudzbenica(String porudzbenicaID) {
        this.porudzbenicaID = porudzbenicaID;
    }

    public Porudzbenica(String porudzbenicaID, Date datum) {
        this.porudzbenicaID = porudzbenicaID;
        this.datum = datum;
    }

    public String getPorudzbenicaID() {
        return porudzbenicaID;
    }

    public void setPorudzbenicaID(String porudzbenicaID) {
        this.porudzbenicaID = porudzbenicaID;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public List<Stavkaporudzbenice> getStavkaporudzbeniceList() {
        return stavkaporudzbeniceList;
    }

    public void setStavkaporudzbeniceList(List<Stavkaporudzbenice> stavkaporudzbeniceList) {
        this.stavkaporudzbeniceList = stavkaporudzbeniceList;
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
        int hash = 0;
        hash += (porudzbenicaID != null ? porudzbenicaID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Porudzbenica)) {
            return false;
        }
        Porudzbenica other = (Porudzbenica) object;
        if ((this.porudzbenicaID == null && other.porudzbenicaID != null) || (this.porudzbenicaID != null && !this.porudzbenicaID.equals(other.porudzbenicaID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domen.Porudzbenica[ porudzbenicaID=" + porudzbenicaID + " ]";
    }

    @Override
    public String vratiNazivTabele() {
        return "Porudzbenica";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return "'"+porudzbenicaID+"', "+autobus.getAutobusID()+", "+planeta.getPlanetaID()+", '"+(new SimpleDateFormat("yyyy-MM-dd").format(datum))+"'";
    }

    @Override
    public List<OpstiDomenskiObjekat> ucitaj(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String[] vratiID() {
        return new String [] {"porudzbenicaID"};
    }

    @Override
    public ResultSet daLiPostoji(PreparedStatement st) throws Exception {
            st.setString(1, porudzbenicaID);
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
