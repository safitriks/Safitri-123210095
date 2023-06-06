/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewresponsi;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import controller.*;

public class RoomListView extends JFrame{ 
    JFrame window = new JFrame("Renter Data");
    Object columnName [];
    RoomListController rl = new RoomListController(this);

    String data[][] = new String [100][4];
    DefaultTableModel tableModel = new DefaultTableModel(columnName,0);
    JTable tabel = new JTable(tableModel);
    JScrollPane scrollPane = new JScrollPane(tabel);
    
    public JButton bcancel = new JButton("Logout");

    public JTable getTabel() {
        return tabel;
    }

    public void setTabel(JTable tabel) {
        this.tabel = tabel;
    }
    
    public RoomListView(){
        window.setLayout(null);
        window.setSize(550,600);
       
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        
        window.add(scrollPane);
        window.add(bcancel);
        scrollPane.setBounds(20, 35, 500, 300);
        bcancel.setBounds(20, 350, 100,50);
        tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = tabel.getSelectedRow();
                    String selectedStatus = tabel.getValueAt(row, 3).toString();
                    String selectedName = tabel.getValueAt(row, 0).toString();
                    Integer selectedPrice = Integer.parseInt(tabel.getValueAt(row, 2).toString()) ;
                    if(selectedStatus.equals("empty")){
                        BukaRenterDataView(selectedName,selectedPrice);   
                    }else{
                        JOptionPane.showMessageDialog(window, "Kamar sudah diisi");
                    }
            }
        });
        showData();
        
    }
    
    private void showData(){
        rl.showtabel();
    }
     private void BukaRenterDataView(String selectedName, Integer selectedPrice) {
        RenterDataView renterDataView = new RenterDataView(selectedName,selectedPrice);
        renterDataView.setVisible(true);
    }
}
