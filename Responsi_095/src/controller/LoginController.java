/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import viewresponsi.*;
import DAO.DAOLogin;
import javax.swing.JOptionPane;

public class LoginController implements ActionListener{
     private LoginPageView view;
     private DAOLogin userDao;

    public LoginController(LoginPageView view, DAOLogin userDao) {
        this.view = view;
        this.userDao = userDao;

        view.blogin.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.blogin) {
            String username = view.fusername.getText();
            String password = new String(view.fpassword.getPassword());

            String role = userDao.Login(username, password);
            if (role != null) {
                openView(role);
            } else {
                JOptionPane.showMessageDialog(view, "Login failed. Invalid username or password.");
            }
        }
    }

    private void openView(String role) {
        if (role.equals("admin")) {
            AdminPageView adminView = new AdminPageView();
            AdminController adminController = new AdminController(adminView);
            view.dispose();
        } else if (role.equals("renter")) {
            RoomListView renterView = new RoomListView();
            RoomListController renterController = new RoomListController(renterView);
            view.dispose();
        } else {
            JOptionPane.showMessageDialog(view, "Invalid");
        }
    }

}
