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
public class UserLotActionBuyStrategy implements UserLotAction {
    private DecisionNoStrategy bought;

    public UserLotActionBuyStrategy(DecisionNoStrategy bought) {
        this.bought = bought;
    }

    @Override
        public void LotAction(DBComponents db, User user, JTable jtable1) {
        try {
        String res = "Sold";
        String selectSql = "SELECT * FROM realestate.lottable WHERE UserID = ? AND LotStatus = ?";
        String updateSql = "UPDATE realestate.lottable SET LotStatus = ? WHERE UserID = ? AND LotStatus = ?";
        
        // Use try-with-resources to automatically close the PreparedStatement and ResultSet
        try (PreparedStatement selectPst = db.getCon().prepareStatement(selectSql)) {
            selectPst.setInt(1, user.getUserid());
            selectPst.setString(2, "Reserved");
            try (ResultSet rs = selectPst.executeQuery()) {

                while (rs.next()) {
                    int lotID = rs.getInt("LotID");
                    // Use another try-with-resources for the update PreparedStatement
                    try (PreparedStatement updatePst = db.getCon().prepareStatement(updateSql)) {
                        updatePst.setString(1, res);
                        updatePst.setInt(2, user.getUserid());
                        updatePst.setString(3, "Reserved");
                        updatePst.executeUpdate();
                    }
                    JFrame frame = new JFrame();
                    JOptionPane.showMessageDialog(frame, "Successfully Bought Lot ID: " + lotID);
                }
            }
        }
        
        resetTable(jtable1);
        bought.showTable(db, user, jtable1);
    } catch (SQLException ex) {
        Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    @Override
    public void resetTable(JTable jtable1) {
        DefaultTableModel tb1Model = (DefaultTableModel)jtable1.getModel();
        tb1Model.setRowCount(0);
    }
    
}
