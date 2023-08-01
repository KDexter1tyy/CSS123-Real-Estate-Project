/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DesignPatterns;
import OtherComponents.User;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kyle
 */
public class ShowBoughtLotSubClass extends DecisionNoStrategy {
    @Override
    public void showTable(DBComponents db, User user, JTable jTable1){
        try {
        String sql = "SELECT * FROM realestate.lottable WHERE UserID = ? AND lotStatus = ?";
        db.getCon();
        db.setPst(db.getCon().prepareStatement(sql));
        db.getPst().setInt(1, user.getUserid()); // Set the UserID parameter
        db.getPst().setString(2, "Sold"); // Set the lotStatus parameter to "Reserved"
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
        Logger.getLogger(ShowBoughtLotSubClass.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
}
