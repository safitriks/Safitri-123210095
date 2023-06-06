/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import java.sql.*;
import java.util.*;
import koneksi.connector;
import model.*;
import DAOImplement.RoomInterface;
import java.util.logging.Level;
import java.util.logging.Logger;
public class DAORoom implements RoomInterface{
    Connection connection;
    
    final String select = "SELECT * FROM rooms";
    
    
    public DAORoom(){
        connection = connector.getConnection();
    }
    
    @Override
    public List<RoomModel> getAll(){
        List<RoomModel> dr = null;
        try{
            dr = new ArrayList<RoomModel>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while(rs.next()){
                RoomModel room = new RoomModel();
                room.setName(rs.getString("Name"));
                room.setSize(rs.getString("Size"));
                room.setPrice(rs.getInt("Price"));
                room.setStatus(rs.getString("Status"));
                dr.add(room);
            }
        }catch(SQLException ex){
            Logger.getLogger(DAORoom.class.getName()).log(Level.SEVERE,null,ex);
        }
        return dr;
    }
    
}
