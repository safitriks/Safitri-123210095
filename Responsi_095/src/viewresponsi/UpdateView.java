/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewresponsi;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controller.RenterDataController;
import controller.UpdateController;
import controller.AdminController;
import javax.swing.*;

public class UpdateView extends JFrame{
    AdminPageView admin;
    JFrame window = new JFrame("Renter Data");
   
    JLabel lName = new JLabel("Name ");
    JTextField tfName = new JTextField();
    JLabel lContact= new JLabel("Contact ");
    JTextField tfContact = new JTextField();

    public JButton btnAddPanel = new JButton("Submit");
    public JButton btnLogout = new JButton("Logout");
    
    
    public UpdateView() {
        window.setLayout(null);
        window.setSize(550,200);
        // window.setDefaultCloseOperation(3);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        
        window.add(lName);
        window.add(tfName);
        window.add(lContact);
        window.add(tfContact);
        window.add(btnAddPanel);
        window.add(btnLogout);
        
        //LABEL
        lName.setBounds(5, 30, 120, 20);
        lContact.setBounds(5,80,120,20);

//TEXTFIELD
        tfName.setBounds(110, 35, 120, 20);
        tfContact.setBounds(110, 85, 120, 20);


//BUTTON PANEL
        btnAddPanel.setBounds(250, 35, 90, 20);
        btnLogout.setBounds(250, 65, 90, 20);
        
    }

    public JTextField getTfName() {
        return tfName;
    }

    public void setTfName(JTextField tfName) {
        this.tfName = tfName;
    }

    public JTextField getTfContact() {
        return tfContact;
    }

    public void setTfContact(JTextField tfContact) {
        this.tfContact = tfContact;
    }
    
     public static void main(String[] args) {
        UpdateView view = new UpdateView();
    }
     
     
}
