/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import javax.swing.table.DefaultTableModel;
import sax.DBConnection;

/**
 *
 * @author DRAGKOZ
 */
public class ModelProveedores {
   // public DBConnection connection = new DBConnection(3306,"sql9.freemysqlhosting.net", "sql9142826", "sql9142826", 
           // "qAQ4xdtaec");
                public DBConnection connection = new DBConnection(3306,"localhost", "acme_shop", "root", "7890");

    private int id_proveedor;
    private String nombre;
    private String rfc;
    private String calle;
    private int no;
    private String colonia;
    private String ciudad;
    private String estado;
    private String contacto;
    private int telefono;
    private String email;
    
    public  DefaultTableModel tableModel = new DefaultTableModel(new String [] {"id_proveedor", "nombre", "rfc", 
        "calle", "no", "colonia", "ciudad", "estado", "nombre_contacto", "telefono", "email"}, 0);

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

    /**
     * @return the rfc
     */
    public String getRfc() {
        return rfc;
    }

    /**
     * @param rfc the rfc to set
     */
    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    /**
     * @return the calle
     */
    public String getCalle() {
        return calle;
    }

    /**
     * @param calle the calle to set
     */
    public void setCalle(String calle) {
        this.calle = calle;
    }

    /**
     * @return the no
     */
    public int getNo() {
        return no;
    }

    /**
     * @param no the no to set
     */
    public void setNo(int no) {
        this.no = no;
    }

    /**
     * @return the colonia
     */
    public String getColonia() {
        return colonia;
    }

    /**
     * @param colonia the colonia to set
     */
    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    /**
     * @return the ciudad
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * @param ciudad the ciudad to set
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the contacto
     */
    public String getContacto() {
        return contacto;
    }

    /**
     * @param contacto the contacto to set
     */
    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    /**
     * @return the telefono
     */
    public int getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    /**
     * @return the id_proveedor
     */
    public int getId_proveedor() {
        return id_proveedor;
    }

    /**
     * @param id_proveedor the id_proveedor to set
     */
    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }
    
    public void initValues() {
        String sql = "SELECT * FROM proveedor";
        connection.executeQuery(sql);
        connection.moveNext();
        setValues();
    }
    public void setValues() {
        id_proveedor = connection.getInteger("id_proveedor");
        nombre = connection.getString("nombre");
        rfc = connection.getString("rfc");
        calle=connection.getString("calle");
        no=connection.getInteger("no");
        colonia = connection.getString("colonia");
        ciudad = connection.getString("ciudad");
        estado = connection.getString("estado");
        contacto=connection.getString("nombre_contacto");
        telefono=connection.getInteger("telefono");
        email = connection.getString("email");
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
    public void search(int id){
        String sql = "SELECT * FROM proveedor WHERE id_proveedor ="+id;
        connection.executeQuery(sql);
        connection.moveNext();
        setValues();
    }
            
    public void saveR(String nombre, String rfc, String calle, int no, String colonia, String ciudad, String estado, String contacto, int telefono, String email){
        String add = "INSERT INTO proveedor (`nombre`,`rfc`,`calle`,`no`,`colonia`,`ciudad`,`estado`,`nombre_contacto`,`telefono`,`email`)"
                + " VALUES ('"+nombre+"', '"+rfc+ "', '"+calle+"', '"+no+"', '"+colonia+"', '"+ciudad+"', '"+estado+"', '"+contacto+"', '"+telefono+"', '"+email+"');";
     connection.executeUpdate(add);
     initValues();
    }
    
    public void updateD(int id, String nombre, String rfc, String calle, int no, String colonia, String ciudad, String estado, String contacto, int telefono, String email) {
        String alter = "UPDATE proveedor SET nombre ='"+nombre+"', rfc ='"+rfc+"', calle ='"+calle+"' , no='" +no+"' , colonia='" +ciudad+"', estado ='"+estado+"', nombre_contacto ='"+contacto+"', telefono ='"+telefono+"', email ='"+email+"'  " + "WHERE id_proveedor =" +id;
        connection.executeUpdate(alter);
        initValues();
    }
    
    public void deleteR(int id) {
        String delete = "DELETE FROM proveedor WHERE id_proveedor=" +id;
        connection.executeUpdate(delete);
        initValues();
    }
    
    public void populateTable() {
        while (connection.moveNext()) {
            setValues();
            tableModel.addRow(new Object []{id_proveedor, nombre, rfc, calle, no, colonia, ciudad, estado, contacto, telefono, email});
        }
    }
}
