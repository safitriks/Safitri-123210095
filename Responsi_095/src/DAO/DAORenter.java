/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import java.sql.*;
import java.util.*;
import koneksi.connector;
import model.*;
import DAOImplement.RenterInterface;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAORenter implements RenterInterface{
    Connection connection;
    final String select = "SELECT * FROM renter";
    final String insert = "INSERT INTO renter (name, id, contact, duration, bill, status, room) VALUES (?,?,?,?,?,?,?)";
    final String update = "UPDATE renter set name=?,contact=? where id=?";
    final String updateStatus = "UPDATE rooms set status=? where name=?";
    final String updatepayment = "UPDATE renter set status=? where id=?";
    final String delete = "DELETE FROM renter where id=?";
    public DAORenter(){
        connection = connector.getConnection();
    }
    
    public void editstatusroom(RenterModel rt){
        PreparedStatement statement = null;
        try{
            statement= connection.prepareStatement(updateStatus);
            statement.setString(1, rt.getRenterName());
            statement.setString(2, rt.getRoom());
            statement.executeUpdate();

        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }
    @Override
    public void insert(RenterModel rt) {
        PreparedStatement statement = null;
        try{
            statement= connection.prepareStatement(insert);
            statement.setString(1, rt.getRenterName());
            statement.setString(2, rt.getId());
            statement.setString(3, rt.getContact());
            statement.setInt(4, rt.getDuration());
            statement.setInt(5, rt.getBill());
            statement.setString(6, rt.getStatus());
            statement.setString(7, rt.getRoom());
            statement.executeUpdate();  
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public List<RenterModel> getAll() {
        List<RenterModel> datarenter = null;
        try{
            datarenter = new ArrayList<RenterModel>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while(rs.next()){
                RenterModel renter = new RenterModel();
                renter.setRenterName(rs.getString("Name"));
                renter.setId(rs.getString("Id"));
                renter.setContact(rs.getString("Contact"));
                renter.setDuration(rs.getInt("Duration"));
                renter.setBill(rs.getInt("Bill"));
                renter.setStatus(rs.getString("Status"));
                renter.setRoom(rs.getString("Room"));
                datarenter.add(renter);
            }
        }catch(SQLException ex){
            Logger.getLogger(DAORoom.class.getName()).log(Level.SEVERE,null,ex);
        }
        return datarenter;
    }

    @Override
    public void updatePayment(RenterModel rt) {
        PreparedStatement statement = null;
        try{
            statement= connection.prepareStatement(updatepayment);
            statement.setString(1, "Paid");
            statement.setString(2, rt.getId());
            statement.executeUpdate();

        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void update(String nama, String contact, String Id) {
        PreparedStatement statement = null;
        try{
            statement= connection.prepareStatement(update);
            statement.setString(1, nama);
            statement.setString(2, contact);
            statement.setString(3, Id);
            statement.executeUpdate();

        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void delete(String id) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(delete);
            statement.setString(1, id);
            statement.executeUpdate();  
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }
    
}
