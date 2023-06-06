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
import model.*;
import viewresponsi.*;


public class RenterDataController implements ActionListener{
    RenterDataView frame;
    RenterInterface renterimplement;
    List<RenterModel> dr;

    public RenterDataController(RenterDataView frame) {
        this.frame = frame;
        renterimplement = new DAORenter();
        dr = renterimplement.getAll();
        
        frame.btnAddPanel.addActionListener(this);
        frame.btnLogout.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frame.btnAddPanel) {
           insert(frame.getName(),frame.getPrice());
           updatestatus(frame.getName(),frame.getPrice());
           JFrame RoomList = new RoomListView();
           RoomList.setVisible(true);
           frame.dispose();
        }
    }
    
    public void insert(String SelectedRoom, Integer SelectedBill){
        String Room = SelectedRoom;
        Integer Bill = SelectedBill;
        RenterModel dr = new RenterModel();
        dr.setRenterName(frame.getTfName().getText());
        dr.setId(frame.getTfid().getText());
        dr.setContact(frame.getTfContact().getText());
        dr.setDuration(Integer.parseInt(frame.getTfRentTime().getText()));
        dr.setBill(dr.getDuration()*Bill);
        dr.setStatus("notPaid");
        dr.setRoom(Room);
        renterimplement.insert(dr);
    }
    
    public void updatestatus(String SelectedRoom, Integer SelectedBill){
        String Room = SelectedRoom;
        Integer Bill = SelectedBill;
        RenterModel dr = new RenterModel();
        dr.setRenterName(frame.getTfName().getText());
        dr.setId(frame.getTfid().getText());
        dr.setContact(frame.getTfContact().getText());
        dr.setDuration(Integer.parseInt(frame.getTfRentTime().getText()));
        dr.setBill(dr.getDuration()*Bill);
        dr.setStatus("notPaid");
        dr.setRoom(Room);
        renterimplement.editstatusroom(dr);
    }
    
    
}
