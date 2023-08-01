/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DesignPatterns;

import java.sql.*;

public class DBComponents {
    private static DBComponents instance = null;
    private Connection con;
    private Statement myStmt = null;
    private ResultSet rs = null;
    private PreparedStatement pst = null;

    private DBComponents() throws SQLException {
        this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull", "root", "");
    }

    public static DBComponents getInstance() throws SQLException {
        synchronized (DBComponents.class) {
            if (instance == null) {
                instance = new DBComponents();
            }
        }
        return instance;
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public Statement getMyStmt() {
        return myStmt;
    }

    public void setMyStmt(Statement myStmt) {
        this.myStmt = myStmt;
    }

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }

    public PreparedStatement getPst() {
        return pst;
    }

    public void setPst(PreparedStatement pst) {
        this.pst = pst;
    }

    String user = "root";
    String pass = "";
}
