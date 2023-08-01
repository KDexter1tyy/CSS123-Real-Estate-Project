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
public class DecisionYesStrategy extends DecisionAbstract{

    public int getComboBoxLotSize() {
        return comboBoxLotSize;
    }

    public void setComboBoxLotSize(int comboBoxLotSize) {
        this.comboBoxLotSize = comboBoxLotSize;
    }

    public int getComboBoxLotPrice() {
        return comboBoxLotPrice;
    }

    public void setComboBoxLotPrice(int comboBoxLotPrice) {
        this.comboBoxLotPrice = comboBoxLotPrice;
    }

    @Override
    public void ReserveLot(DBComponents db, User user, JTable jtable1) {
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
        Logger.getLogger(DecisionYesStrategy.class.getName()).log(Level.SEVERE, null, ex);
    }
        

}

    @Override
    public void showTable(DBComponents db, User user, JTable jTable1) {
        if(!(user.getLot().getSize()>=50&&user.getLot().getSize()<=255)){
            JFrame frame = new JFrame();
            JOptionPane.showMessageDialog(frame, "Lot size must only be in the range of 50-255!");
        }
        
        if(!(user.getLot().getBlock()>=1&&user.getLot().getBlock()<=5)){
            JFrame frame = new JFrame();
            JOptionPane.showMessageDialog(frame, "Lot block number must only be in the range of 50-255!");
        }
        
        if(!((int) user.getLot().getPrice()>=100000&&(int) user.getLot().getPrice()<=4500000)){
            JFrame frame = new JFrame();
            JOptionPane.showMessageDialog(frame, "Lot size must only be in the range of 50-255!");
            return;
        }
              
        try {
            String LotSizeComp, LotPriceComp;
            if (comboBoxLotSize == 0) {
                LotSizeComp = ">=";
            } else {
                LotSizeComp = "<=";
            }

            if (comboBoxLotPrice == 0) {
                LotPriceComp = ">=";
            } else {
                LotPriceComp = "<=";
            }

            String sql = "SELECT * FROM realestate.lottable WHERE LotSize " + LotSizeComp + " ? AND LotBlock = ? AND LotPrice " + LotPriceComp + " ?;";
            db.setPst(db.getCon().prepareStatement(sql));
            db.getPst().setInt(1, user.getLot().getSize());
            db.getPst().setInt(2, user.getLot().getBlock());
            db.getPst().setInt(3, (int) user.getLot().getPrice());

            db.setRs(db.getPst().executeQuery());

            resetTable(jTable1);

            while (db.getRs().next()) {
                String LotID = String.valueOf(db.getRs().getInt("lotid"));//int
                String LotSize = String.valueOf(db.getRs().getInt("LotSize"));//int
                String LotBlock = String.valueOf(db.getRs().getInt("LotBlock"));//int
                String LotNum = String.valueOf(db.getRs().getInt("LotNum"));//int

                String LotPrice = String.valueOf(db.getRs().getInt("LotPrice"));//int
                String LotStatus = db.getRs().getString("LotStatus");

                String tbData[] = {LotID, LotSize, LotBlock, LotNum, LotPrice, LotStatus};
                DefaultTableModel tb1Model = (DefaultTableModel) jTable1.getModel();

                tb1Model.addRow(tbData);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DecisionYesStrategy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
