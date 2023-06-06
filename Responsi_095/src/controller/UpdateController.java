/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.util.List;
import DAO.DAORenter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import DAOImplement.RenterInterface;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import controller.AdminController;
import model.*;
import viewresponsi.*;


public class UpdateController implements ActionListener{
    UpdateView frameupdate;
    AdminPageView frame;
    RenterInterface renterimplement;
    List<RenterModel> dr;

    public UpdateController(UpdateView frameUpdate, AdminPageView frameadmin) {
        this.frameupdate = frameUpdate;
        this.frame = frameadmin;
        renterimplement = new DAORenter();
        dr = renterimplement.getAll();
        if(frameupdate.btnAddPanel != null){
        frameupdate.btnAddPanel.addActionListener(this);
        }
        frameupdate.btnLogout.addActionListener(this);
    } 
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frameupdate.btnAddPanel) {
           update();
           JFrame AdminPageView = new AdminPageView();
           AdminPageView.setVisible(true);
           frameupdate.dispose();
        }
    } 
    public void update(){
        String nama = frameupdate.getTfName().getText();
        String contact = frameupdate.getTfContact().getText();
        String selectedID = frame.getSelectedID();
        System.out.println(selectedID);
        if (selectedID != null) {
            String Id = selectedID;
            renterimplement.update(nama,contact,Id);
        } else {
            System.out.println("Tidak Ada ID");
        }
    }   
}
