/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DesignPatterns;


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
public class DecisionNoStrategy extends DecisionAbstract{

    @Override
    public void ReserveLot(DBComponents db,User user, JTable jtable1) {
        try {
        
        String res = "Reserved";
        String selectSql = "SELECT * FROM realestate.lottable WHERE LotID = ?";
        String updateSql = "UPDATE realestate.lottable SET LotStatus = ?, UserID=? WHERE LotID = ? AND LotStatus = ?";
        
        // Use try-with-resources to automatically close the PreparedStatement and ResultSet
        try (PreparedStatement selectPst = db.getCon().prepareStatement(selectSql)) {
            selectPst.setInt(1, user.getLot().getId());
            try (ResultSet rs = selectPst.executeQuery()) {
                if (rs.next()) {
                    String lotStatus = rs.getString("LotStatus");
                    
                    if ("Available".equals(lotStatus)) {
                        // Use another try-with-resources for the update PreparedStatement
                        try (PreparedStatement updatePst = db.getCon().prepareStatement(updateSql)) {
                            updatePst.setString(1, res);
                            updatePst.setInt(2, user.getUserid());
                            updatePst.setInt(3, user.getLot().getId());
                            updatePst.setString(4, "Available");
                            updatePst.executeUpdate();
                        }
                        
                        JFrame frame = new JFrame();
                        JOptionPane.showMessageDialog(frame, "Successfully Reserved");
                    } else {
                        JFrame frame = new JFrame();
                        JOptionPane.showMessageDialog(frame, "This lot is Already Reserved");
                    }
                } else {
                    JFrame frame = new JFrame();
                    JOptionPane.showMessageDialog(frame, "Lot ID not found");
                }
            }
        }

        resetTable(jtable1);
        showTable(db,user,jtable1);
    } catch (SQLException ex) {
        Logger.getLogger(DecisionNoStrategy.class.getName()).log(Level.SEVERE, null, ex);
    }
        
}

    @Override
    public void showTable(DBComponents db, User user, JTable jTable1) {

        try {
            db.getCon();
            String sql = "SELECT * FROM realestate.lottable;";
            db.setPst(db.getCon().prepareStatement(sql));
            db.setRs(db.getPst().executeQuery());

            resetTable(jTable1);

            while (db.getRs().next()) {
                user.getLot().setId(db.getRs().getInt("lotid"));
                user.getLot().setSize(db.getRs().getInt("lotSize"));
                user.getLot().setBlock(db.getRs().getInt("lotBlock"));
                user.getLot().setNum(db.getRs().getInt("lotNum"));
                user.getLot().setPrice(db.getRs().getInt("lotPrice"));
                user.getLot().setStatus(db.getRs().getString("lotStatus"));
                

                String LotID = String.valueOf(user.getLot().getId());//int
                String LotSize = String.valueOf(user.getLot().getSize());//int
                String LotBlock = String.valueOf(user.getLot().getBlock());//int
                String LotNum = String.valueOf(user.getLot().getNum());//int
                String LotPrice = String.valueOf(user.getLot().getPrice());//int

                String tbData[] = {LotID, LotSize, LotBlock, LotNum, LotPrice, user.getLot().getStatus()};
                DefaultTableModel tb1Model = (DefaultTableModel) jTable1.getModel();

                tb1Model.addRow(tbData);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DecisionNoStrategy.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
