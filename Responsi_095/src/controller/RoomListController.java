/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.util.List;
import DAO.DAORoom;
import DAOImplement.RoomInterface;
import model.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import viewresponsi.*;

public class RoomListController implements ActionListener{
    RoomListView frameroom;
    RoomInterface roomimplement;
    List<RoomModel> dr;
    
    public RoomListController(RoomListView renterView) {
        this.frameroom = renterView;
        roomimplement =  new DAORoom();
        dr = roomimplement.getAll();
        if(frameroom.bcancel != null){
        frameroom.bcancel.addActionListener(this); } 
    }
    
    
    public void showtabel(){
        dr = roomimplement.getAll();
        RoomTable rm = new RoomTable(dr);
        frameroom.getTabel().setModel(rm);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == frameroom.bcancel){
           JFrame Login = new LoginPageView();
           Login.setVisible(true);
           frameroom.dispose();
        }
    }
    
}
