/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DesignPatterns;

import OtherComponents.User;

/**
 *
 * @author Kyle
 */
public interface UserAction {
    public void UserActionNow(DBComponents db, String username, String password, User user);
}
