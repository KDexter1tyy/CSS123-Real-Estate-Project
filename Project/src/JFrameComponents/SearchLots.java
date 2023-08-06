/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JFrameComponents;

import DBComponents.DBComponents;

/**
 *
 * @author Kyle
 */
public interface SearchLots {
    public void ReserveLot(DBComponents db, int lotID);//both yes and no
    public void showTableData(DBComponents db);//both yes and no
    public void resetTable();//both yes and no
    
    
}
