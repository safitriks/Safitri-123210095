/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewresponsi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controller.RenterDataController;
import javax.swing.*;

public class RenterDataView extends JFrame{
    String name;
    Integer price;
    JFrame window = new JFrame("Renter Data");
   
    JLabel lName = new JLabel("Name ");
    JTextField tfName = new JTextField();
    JLabel lid = new JLabel("id ");
    JTextField tfid = new JTextField();
    JLabel lContact= new JLabel("Contact ");
    JTextField tfContact = new JTextField();
    JLabel lRentTime = new JLabel("RentTime ");
    JTextField tfRentTime = new JTextField();

    public JButton btnAddPanel = new JButton("Submit");
    public JButton btnLogout = new JButton("Logout");

    public JTextField getTfName() {
        return tfName;
    }

    public void setTfName(JTextField tfName) {
        this.tfName = tfName;
    }

    public JTextField getTfid() {
        return tfid;
    }

    public void setTfid(JTextField tfid) {
        this.tfid = tfid;
    }

    public JTextField getTfContact() {
        return tfContact;
    }

    public void setTfContact(JTextField tfContact) {
        this.tfContact = tfContact;
    }

    public JTextField getTfRentTime() {
        return tfRentTime;
    }

    public void setTfRentTime(JTextField tfRentTime) {
        this.tfRentTime = tfRentTime;
    }
    
    
    public RenterDataView(String Name, Integer Price) {
        this.name = Name;
        this.price = Price;
        window.setLayout(null);
        window.setSize(550,200);
        // window.setDefaultCloseOperation(3);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        
        window.add(lName);
        window.add(tfName);
        window.add(lid);
        window.add(tfid);
        window.add(lContact);
        window.add(tfContact);
        window.add(lRentTime);
        window.add(tfRentTime);
        window.add(btnAddPanel);
        window.add(btnLogout);
        
        //LABEL
        lName.setBounds(5, 30, 120, 20);
        lid.setBounds(5, 55, 120, 20);
        lContact.setBounds(5,80,120,20);
        lRentTime.setBounds(5,110,120,20);

//TEXTFIELD
        tfName.setBounds(110, 35, 120, 20);
        tfid.setBounds(110, 60, 120, 20);
        tfContact.setBounds(110, 85, 120, 20);
        tfRentTime.setBounds(110, 115, 120, 20);


//BUTTON PANEL
        btnAddPanel.setBounds(250, 35, 90, 20);
        btnLogout.setBounds(250, 65, 90, 20);
        RenterDataController rdc = new RenterDataController(this);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
    
    

}

