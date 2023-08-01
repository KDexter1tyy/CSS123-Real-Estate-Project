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
public class UserActionLoginStrategy implements UserAction {

    @Override
    public void UserActionNow(DBComponents db, String username, String password, User user) {
        try {
        String selectSql = "SELECT * FROM realestate.users WHERE username = ? AND password = ?";
        db.getCon();
        db.setPst(db.getCon().prepareStatement(selectSql));
        db.getPst().setString(1, username);
        db.getPst().setString(2, password);
        ResultSet resultSet = db.getPst().executeQuery();

        if (resultSet.next()) {
            int userId = resultSet.getInt("UserID");
            // Here, you can retrieve other user information from the resultSet if needed.
            // For example: String name = resultSet.getString("name");
            // Update the User object with the user's information
            user.setUserid(userId);
            user.setUsername(username);
            user.setPassword(password);
            JFrame frame = new JFrame();
            JOptionPane.showMessageDialog(frame, "Login successful.");
        } else {
            JFrame frame = new JFrame();
            JOptionPane.showMessageDialog(frame, "Login failed! (invalid credentials)");
        }
    } catch (SQLException ex) {
        Logger.getLogger(UserInterface.class.getName()).log(Level.SEVERE, null, ex);
        JFrame frame = new JFrame();
        JOptionPane.showMessageDialog(frame, "Login failed due to an error.");
    }
    }
    
}
