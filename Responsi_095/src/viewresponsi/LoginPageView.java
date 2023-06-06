    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewresponsi;

import java.awt.event.*;
import javax.swing.*;
import DAO.DAOLogin;
import controller.LoginController;

public class LoginPageView extends JFrame{
 
    public JLabel ltitle = new JLabel("Login");
    
    public JLabel lusername = new JLabel("Username");
    public JTextField fusername = new JTextField();
    
    public JLabel lpassword = new JLabel("Password");
    public JPasswordField fpassword = new JPasswordField();
    
    public JButton blogin = new JButton("Login");
    
    public LoginPageView(){
        setSize(800, 600);
        setTitle("Login Page");
        setVisible(true);
        setLayout(null);
        
        setLocationRelativeTo(null);
        
        add(ltitle);
        add(lusername);
        add(lpassword);
        add(fusername);
        add(fpassword);
        add(blogin);
        
        ltitle.setBounds(365, 50, 75, 50);
        
        lusername.setBounds(275, 120, 100, 30);
        fusername.setBounds(275, 150, 250, 30);
        
        lpassword.setBounds(275, 180, 100, 30);
        fpassword.setBounds(275, 210, 250, 30);
        
        blogin.setBounds(350, 260, 100, 30);
        
        DAOLogin userDao = new DAOLogin();
        LoginController controller = new LoginController(this, userDao);
    }


}
