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
public class Putnik implements OpstiDomenskiObjekat {
    private Integer putnikID;
    private String jmbg;
    private String imeprezime;
    private String adresa;
    private String kontaktTelefon;

    public Putnik() {
    }

    public Putnik(Integer putnikID) {
        this.putnikID = putnikID;
    }

    public Putnik(Integer putnikID, String jmbg, String imeprezime, String adresa, String kontaktTelefon) {
        this.putnikID = putnikID;
        this.jmbg = jmbg;
        this.imeprezime = imeprezime;
        this.adresa = adresa;
        this.kontaktTelefon = kontaktTelefon;
    }

    public Integer getPutnikID() {
        return putnikID;
    }

    public void setPutnikID(Integer putnikID) {
        this.putnikID = putnikID;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getImeprezime() {
        return imeprezime;
    }

    public void setImeprezime(String imeprezime) {
        this.imeprezime = imeprezime;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getKontaktTelefon() {
        return kontaktTelefon;
    }

    public void setKontaktTelefon(String kontaktTelefon) {
        this.kontaktTelefon = kontaktTelefon;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (putnikID != null ? putnikID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Putnik)) {
            return false;
        }
        Putnik other = (Putnik) object;
        if ((this.putnikID == null && other.putnikID != null) || (this.putnikID != null && !this.putnikID.equals(other.putnikID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return imeprezime+", "+jmbg;
    }

    @Override
    public String vratiNazivTabele() {
        return "Putnik";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return "'"+jmbg+"', '"+imeprezime+"', '"+adresa+"', '"+kontaktTelefon+"'";
    }

    @Override
    public List<OpstiDomenskiObjekat> ucitaj(ResultSet rs) throws Exception {
        try {
            List<OpstiDomenskiObjekat> lp = new LinkedList<>();
            while (rs.next()) {
                Putnik p = new Putnik();
                p.setPutnikID(rs.getInt(1));
                p.setJmbg(rs.getString(2));
                p.setImeprezime(rs.getString(3));
                p.setAdresa(rs.getString(4));
                p.setKontaktTelefon(rs.getString(5));
                lp.add(p);
            }
            return lp;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public String[] vratiID() {
        return new String[]{"jmbg", "imeprezime"};
    }

    @Override
    public ResultSet daLiPostoji(PreparedStatement st) throws Exception {
        st.setString(1, jmbg);
        st.setString(2, imeprezime);
        return st.executeQuery();
    }

    @Override
    public String vratiKriterijum() {
        return "imeprezime";
    }

    @Override
    public String vratiAtributeZaInsert() {
        return "jmbg, imeprezime, adresa, kontaktTelefon";
    }

    @Override
    public String vratiAtributeZaUpdate() {
        return "jmbg = ?, imeprezime = ?, adresa = ?, kontaktTelefon = ?";
    }

    @Override
    public void dodeliVrednosti(PreparedStatement st) throws SQLException{
        st.setString(2, imeprezime);
        st.setString(1, jmbg);
        st.setString(3, adresa);
        st.setString(4, kontaktTelefon);
        st.setString(5, jmbg);
        st.setString(6, imeprezime);
    }

    @Override
    public String vratiIDUBazi() {
        return "putnikID";
    }

    @Override
    public void dodeliVrednostiZaUpdate(PreparedStatement st) throws SQLException{
        st.setString(2, imeprezime);
        st.setString(1, jmbg);
        st.setString(3, adresa);
        st.setString(4, kontaktTelefon);
        st.setInt(5, putnikID);
    }
    
}
