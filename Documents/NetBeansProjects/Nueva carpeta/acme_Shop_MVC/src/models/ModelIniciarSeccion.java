/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

import sax.DBConnection;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class ModelIniciarSeccion {
     public DBConnection connection = new DBConnection(3306,"localhost", "acme_shop", "root", "7890");

        public String username;
    public String password;
    public String status;
    public String level;

       
    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the status
     */
    public String  getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String  status) {
        this.status = status;
    }

    /**
     * @return the level
     */
    public String getLevel() {
        return level;
    }

    /**
     * @param level the level to set
     */
    public void setLevel(String level) {
        this.level = level;
    }
    
    public void initValues() {
        String sql = "SELECT * FROM usuarios";
        connection.executeQuery(sql);
        connection.moveNext();
    }
    
    public boolean validateUser() {
        boolean desh = false;
       // password = encodeModel.md5(password);
        
        String query = "SELECT * FROM usuarios WHERE usuario = '"+username+"' AND password = '"+password+"';";
        connection.executeQuery(query);
        connection.moveNext();
        
        status = connection.getString("estado");
                if (username.equals(connection.getString("usuario")) && password.equals(connection.getString("password")) && status.equals("1")) {

   //     if (username.equals(connection.getString("usuario")) && password.equals(connection.getString("password")) && status.equals("1")) {   
            desh = true;
            level = connection.getString("tipo");
        }
        
        return desh;
    }

}
