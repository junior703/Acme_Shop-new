/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

import javax.swing.table.DefaultTableModel;
import sax.DBConnection;
import views.ViewUsuarios;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class ModelUsuarios {
    private int idusername ;
  private String username;                
    private String password;
    private int status;
    private String level;
    private String nombre;
    ViewUsuarios viewUsuarios;
    
         public DBConnection connection = new DBConnection(3306,"localhost", "acme_shop", "root", "7890");
         
            // public  DefaultTableModel tableModel =(DefaultTableModel) viewUsuarios.jtbledetalle.getModel() ;   
              public  DefaultTableModel tableModel= new DefaultTableModel(new String [] {"Id_usuario", "Usuario","Nivel", "Estado","nombre","Contrasena"}, 0);


    /**
     * @return the idusername
     */
    public int getIdusername() {
        return idusername;
    }

    /**
     * @param idusername the idusername to set
     */
    public void setIdusername(int idusername) {
        this.idusername = idusername;
    }

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
    public int getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(int status) {
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
      /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void initValues() {
        String sql = "SELECT * FROM usuarios";
        connection.executeQuery(sql);
        connection.moveNext();
    }
    
    public void setValues() {
         idusername = connection.getInteger("id_usuario");
        username = connection.getString("usuario");
        password = connection.getString("password");
        status = connection.getInteger("estado");
        level = connection.getString("tipo");
         nombre = connection.getString("nombre");
    }
    
     public void moveFirst() {
        connection.moveFirst();
         setValues();
    }
    
    public void movePrevious() {
        connection.movePrevious();
         setValues();
    }
    
    public void moveNext() {
        connection.moveNext();
         setValues();
    }
    
    public void moveLast() {
        connection.moveLast();
         setValues();
    }



    

    public void guadarRegistro(String username, String password, int status, String level,String nombre) {
        String add = "INSERT INTO usuarios (`usuario`, `password`, `estado`, `tipo`,`nombre`)" + "VALUES ('"+username+"', '"+password+"', '"+status+"', '"+level+"', '"+nombre+"');";
        connection.executeUpdate(add);
        initValues();
    }
    
    public void alterRecord(int idusername,String username, String password, int status, String level,String nombre) {
          String alter = "UPDATE usuarios SET usuario ='"+username+"', password='"+password+"', estado ='"+status+"' , tipo='" +level+"' , nombre='" +nombre+"'  " + "WHERE id_usuario =" +idusername;
        connection.executeUpdate(alter);
        initValues();
    }
    
    public void deleteUser(int user) {
        String delete = "DELETE FROM usuarios WHERE id_usuario=" +idusername;
        connection.executeUpdate(delete);
        initValues();
    }
      public void populateTable() {
   while (connection.moveNext()) {
            setValues();
            tableModel.addRow(new Object []{idusername, username,level,status,nombre,password});
             
        }
    }
 public void busqueda(int idusername) {
        String query =   "Select * from usuarios  WHERE id_usuario = "+idusername; 
        connection.executeQuery(query);
                connection.moveNext();
          setValues();
     //   populateTable();
    }   
  

}
