/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class RoomTable extends AbstractTableModel{
    List<RoomModel> dr;
    public RoomTable(List<RoomModel>dr){
        this.dr = dr;
    }
    @Override
    public int getRowCount() {
        return dr.size();
    }

    @Override
    public int getColumnCount() {
       return 4;
    }
    
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0:
                return "Name";
            case 1:
                return "Size";
            case 2:
                return "Price";
            case 3:
                return "Status";
            default:
                return null;
        }
    }
    @Override
    public Object getValueAt(int row, int column) {
        switch(column){
            case 0:
                return dr.get(row).getName();
            case 1:
                return dr.get(row).getSize();
            case 2:
                return dr.get(row).getPrice();
            case 3:
                return dr.get(row).getStatus();
            default:
                return null;
        }
    }
    
}
