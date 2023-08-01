/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DesignPatterns;

import OtherComponents.User;
import OtherComponents.UserInterface;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Kyle
 */
public class UserActionRegisterStrategy implements UserAction {
    
    private boolean isUsernameExists(DBComponents db, String username) {
        try {
            String selectSql = "SELECT COUNT(*) FROM realestate.users WHERE username = ?";
            db.getCon();
            db.setPst(db.getCon().prepareStatement(selectSql));
            db.getPst().setString(1, username);
            try (ResultSet resultSet = db.getPst().executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count > 0;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    @Override
    public void UserActionNow(DBComponents db, String username, String password, User user) {
        if (isUsernameExists(db, username)) {
            JFrame frame = new JFrame();
            JOptionPane.showMessageDialog(frame, "Username already exists. User registration failed.");
            return;
        }

        try {
            String insertSql = "INSERT INTO realestate.users (username, password) VALUES (?, ?)";
            db.getCon();
            db.setPst(db.getCon().prepareStatement(insertSql));
            db.getPst().setString(1, username);
            db.getPst().setString(2, password);
            db.getPst().executeUpdate();
            
            user.setUsername(username);
            user.setPassword(password);
            
            JFrame frame = new JFrame();
            JOptionPane.showMessageDialog(frame, "User registration successful!");
        } catch (SQLException ex) {
            Logger.getLogger(UserInterface.class.getName()).log(Level.SEVERE, null, ex);
            JFrame frame = new JFrame();
            JOptionPane.showMessageDialog(frame, "User registration failed.");
            
        }
    }
    
}
