/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DesignPatterns;

import OtherComponents.User;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kyle
 */
abstract class DecisionAbstract implements Prefer {
    protected int comboBoxLotSize;
    protected int comboBoxLotPrice;
    
    @Override
    public abstract void ReserveLot(DBComponents db, User user, JTable jtable1);
    @Override
    public abstract void showTable(DBComponents db, User user, JTable jTable1);
    @Override
    public void resetTable(JTable jtable1){
        DefaultTableModel tb1Model = (DefaultTableModel)jtable1.getModel();
        tb1Model.setRowCount(0);
    
    }
}
