/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewresponsi;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controller.AdminController;

public class AdminPageView extends JFrame{ 
    JFrame window = new JFrame("Renter Data");
    Object columnName [];
    AdminController ac = new AdminController(this);
    String data[][] = new String [100][4];
    DefaultTableModel tableModel = new DefaultTableModel(columnName,0);
    public JTable tabel = new JTable(tableModel);
    JScrollPane scrollPane = new JScrollPane(tabel);
    
    JButton blogout = new JButton("Logout");

    
    public AdminPageView() {
        window.setLayout(null);
        window.setSize(550,600);
       
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        
        window.add(scrollPane);
        window.add(blogout);
        scrollPane.setBounds(20, 35, 500, 300);
        blogout.setBounds(20, 350, 100,50);
        blogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                LoginPageView loginPage = new LoginPageView();
                loginPage.setVisible(true);
            }
        });
        tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = tabel.getSelectedRow();
                    String selectedStatus = tabel.getValueAt(row, 5).toString();
                    ac.pilihAksi();
            }
        });
        showData(); 
    }
    
    private void showData(){
        ac.showtabel();
    }

    public JTable getTabel() {
        return tabel;
    }

    public void setTabel(JTable tabel) {
        this.tabel = tabel;
    }
    
    public String getSelectedID() {
        int selectedRow = tabel.getSelectedRow();
        if (selectedRow != -1) {
            return tabel.getValueAt(selectedRow, 1).toString();
        }
        return null;
    }
    
}
