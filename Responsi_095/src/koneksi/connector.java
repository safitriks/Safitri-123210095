/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package koneksi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connector {
    private static final String URL = "jdbc:mysql://localhost:3306/almaul_db";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                System.out.println("Berhasil terhubung ke database!");
            } catch (SQLException e) {
                System.out.println("Gagal terhubung ke database: " + e.getMessage());
            }
        }
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Koneksi database ditutup.");
            } catch (SQLException e) {
                System.out.println("Gagal menutup koneksi database: " + e.getMessage());
            }
        }
    }
}
