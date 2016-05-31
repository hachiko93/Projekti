/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.planeta.model;

import domen.Stavkaporudzbenice;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Licina
 */
public class StavkaPorudzbeniceTableModel extends AbstractTableModel {

    private List<Stavkaporudzbenice> ls;
    private String[] kolone = new String[]{"RB", "Zalihe", "Kolicina", "Jedinica mere"};

    public StavkaPorudzbeniceTableModel(List<Stavkaporudzbenice> ls) {
        this.ls = ls;
    }

    @Override
    public int getRowCount() {
        if (ls == null) {
            return 0;
        }
        return ls.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Stavkaporudzbenice sp = ls.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return sp.getRb();
            case 1:
                return sp.getZalihe().getNaziv();
            case 2:
                return sp.getKolicina();
            case 3:
                return sp.getJedinicaMere();
            default:
                return "N/A";
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Stavkaporudzbenice sp = ls.get(rowIndex);
        switch (columnIndex) {
            case 0:
                sp.setRb(Integer.parseInt(aValue.toString()));
                break;
            case 1:
                sp.getZalihe().setNaziv(aValue.toString());
                break;
            case 2:
                sp.setKolicina(Double.parseDouble(aValue.toString()));
                break;
            case 3:
                sp.setJedinicaMere(aValue.toString());
                break;
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return !(columnIndex == 0 || columnIndex == 1);
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

}
