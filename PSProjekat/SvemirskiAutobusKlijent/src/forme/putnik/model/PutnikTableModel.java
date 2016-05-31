/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.putnik.model;

import domen.Putnik;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Licina
 */
public class PutnikTableModel extends AbstractTableModel{

    private List<Putnik> lp;
    private String [] kolone = new String[]{"Ime i prezime", "JMBG", "Adresa", "Kontakt telefon"};

    public PutnikTableModel(List<Putnik> lp) {
        this.lp = lp;
    }
    
    @Override
    public int getRowCount() {
        if(lp == null) return 0;
        return lp.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Putnik p = lp.get(rowIndex);
        switch (columnIndex){
            case 0: return p.getImeprezime();
            case 1: return p.getJmbg();
            case 2: return p.getAdresa();
            case 3: return p.getKontaktTelefon();
            default: return "N/A";
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Putnik p = lp.get(rowIndex);
        switch (columnIndex){
            case 0: 
                p.setImeprezime(aValue.toString());
                break;
            case 1: 
                p.setJmbg(aValue.toString());
                break;
            case 2: 
                p.setAdresa(aValue.toString());
                break;
            case 3: 
                p.setKontaktTelefon(aValue.toString());
                break;
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    
    
    
}
