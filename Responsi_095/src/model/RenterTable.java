/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class RenterTable extends AbstractTableModel{
    
    List<RenterModel> datarenter;
    public RenterTable(List<RenterModel>datarenter){
        this.datarenter = datarenter;
    }
    @Override
    public int getRowCount() {
        return datarenter.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }
    
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0:
                return "Nama";
            case 1:
                return "Id";
            case 2:
                return "Contact";
            case 3:
                return "Duration";
            case 4:
                return "Bill";
            case 5:
                return "Status";
            case 6:
                return "Room";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch(column){
            case 0:
                return datarenter.get(row).getRenterName();
            case 1:
                return datarenter.get(row).getId();
            case 2:
                return datarenter.get(row).getContact();
            case 3:
                return datarenter.get(row).getDuration();
            case 4:
                return datarenter.get(row).getBill();
            case 5:
                return datarenter.get(row).getStatus();
            case 6:
                return datarenter.get(row).getRoom();
            default:
                return null;
        }
    }
    
}
