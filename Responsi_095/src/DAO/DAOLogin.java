/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import java.sql.*;
import java.util.*;
import koneksi.connector;
import model.*;
import DAOImplement.LoginInterface;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOLogin implements LoginInterface {
    Connection connection;
     
    public DAOLogin(){
        connection = connector.getConnection();
    }

    @Override
    public String Login(String username, String password) {
        String query = "SELECT role FROM accounts WHERE username = ? AND password = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getString("role");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
