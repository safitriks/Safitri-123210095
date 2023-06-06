/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.util.List;
import DAO.DAORoom;
import DAOImplement.RoomInterface;
import model.*;
import viewresponsi.*;

public class RoomController {
    RoomListView frameroom;
    RoomInterface roomimplement;
    List<RoomModel> dr;
    
    public RoomController(RoomListView frameroom){
        this.frameroom = frameroom;
        roomimplement =  new DAORoom();
        dr = roomimplement.getAll();
    }
    
    public void showtabel(){
        dr = roomimplement.getAll();
        RoomTable rm = new RoomTable(dr);
        frameroom.getTabel().setModel(rm);
    }
    
    
}
