/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 * @author Azael
 */
public class ModelReportesProductos 
{
    
    private Connection conn;
    private Statement stm;
    private ResultSet res;
    
    public Connection getConn() {
        return conn;
    }
    public void setConn(Connection conn) {
        this.conn = conn;
    }
    public Statement getStm() {
        return stm;
    }
    public void setStm(Statement stm) {
        this.stm = stm;
    }
    public ResultSet getRes() {
        return res;
    }
    public void setRes(ResultSet res) {
        this.res = res;
    }
        public void conectar() throws ClassNotFoundException, SQLException
    {
    try
    {
        Class.forName("com.mysql.jdbc.Driver");
            setConn(DriverManager.getConnection("jdbc:mysql://localhost/acme_shop", "root", "7890"));
    }finally{
        
    }
    }

}
