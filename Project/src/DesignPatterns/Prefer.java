/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DesignPatterns;

import OtherComponents.User;
import javax.swing.JTable;

/**
 *
 * @author Kyle
 */
public interface Prefer {
    public abstract void ReserveLot(DBComponents db, User user, JTable jtable1);
    public void showTable(DBComponents db, User user, JTable jTable1);
    public abstract void resetTable(JTable jtable1);
    
}
