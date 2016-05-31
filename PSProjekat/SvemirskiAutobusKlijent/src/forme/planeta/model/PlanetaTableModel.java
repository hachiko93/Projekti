/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.planeta.model;

import domen.Planeta;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Licina
 */
public class PlanetaTableModel extends AbstractTableModel{

    private List<Planeta> lp;
    private String [] kolone = new String []{"Naziv", "Koordinate", "Udaljenost od zemlje"};

    public PlanetaTableModel(List<Planeta> lp) {
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
        Planeta p = lp.get(rowIndex);
        switch (columnIndex){
            case 0: return p.getNaziv();
            case 1: return p.getKoordinate();
            case 2: return p.getUdaljenostOdZemlje();
            default: return "N/A";
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Planeta p = lp.get(rowIndex);
        switch (columnIndex){
            case 0: 
                p.setNaziv(aValue.toString());
                break;
            case 1: 
                p.setKoordinate(aValue.toString());
                break;
            case 2: 
                p.setUdaljenostOdZemlje(Double.parseDouble(aValue.toString()));
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
