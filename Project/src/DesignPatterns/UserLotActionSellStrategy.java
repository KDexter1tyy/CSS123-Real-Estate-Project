/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DesignPatterns;

import OtherComponents.MainMenu;
import OtherComponents.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kyle
 */
public class UserLotActionSellStrategy implements UserLotAction {
    
    private DecisionNoStrategy reserved;

    public UserLotActionSellStrategy(DecisionNoStrategy reserved) {
        this.reserved = reserved;
    }
    
    @Override
    public void LotAction(DBComponents db, User user, JTable jtable1) {
        try {
        String res = "Sold";
        String selectSql = "SELECT * FROM realestate.lottable WHERE UserID = ? AND LotStatus = ?";
        String updateSql = "UPDATE realestate.lottable SET LotStatus = ?, UserID = NULL WHERE LotID = ? AND UserID = ? AND LotStatus = ? LIMIT 1";

        // Use try-with-resources to automatically close the PreparedStatement and ResultSet
        try (PreparedStatement selectPst = db.getCon().prepareStatement(selectSql)) {
            selectPst.setInt(1, user.getUserid());
            selectPst.setString(2, res);
            try (ResultSet rs = selectPst.executeQuery()) {
                if (rs.next()) {
                    int lotID = rs.getInt("LotID");
                    // Use another try-with-resources for the update PreparedStatement
                    try (PreparedStatement updatePst = db.getCon().prepareStatement(updateSql)) {
                        updatePst.setString(1, "Available");
                        updatePst.setInt(2, user.getLot().getId());
                        updatePst.setInt(3, user.getUserid());
                        updatePst.setString(4, res);
                        updatePst.executeUpdate();
                    }
                    JFrame frame = new JFrame();
                    JOptionPane.showMessageDialog(frame, "Successfully Sold Lot ID: " + user.getLot().getId());
                } else {
                    JFrame frame = new JFrame();
                    JOptionPane.showMessageDialog(frame, "No reserved lots found for the user.");
                }
            }
        }

        resetTable(jtable1);
        reserved.showTable(db,user, jtable1);//show bought lots by user
    } catch (SQLException ex) {
        JFrame frame = new JFrame();
        JOptionPane.showMessageDialog(frame, "Failed");
        Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    @Override
    public void resetTable(JTable jtable1) {
        DefaultTableModel tb1Model = (DefaultTableModel)jtable1.getModel();
        tb1Model.setRowCount(0);   
    }
    
}
