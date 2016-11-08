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
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class ModelCliente {

          public DBConnection connection = new DBConnection(3306,"localhost", "acme_shop", "root", "7890");

    private int idcliente;
    private String nombre;
    private String ap_paterno;
    private String ap_materno;
    private long telefono;//long
    private String email;
    private String rfc;
    private String calle;
    private int numero;
    private String colonia;
    private String ciudad;
    private String estado;

             public  DefaultTableModel tableModel = new DefaultTableModel(new String [] {"ID", "nombre","telefono","RFC","telefono","estado","ciudad","colonia","no","calle"}, 0);

    /**
     * @return the idcliente
     */
    public int getIdcliente() {
        return idcliente;
    }

    /**
     * @param idcliente the idcliente to set
     */
    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
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

    /**
     * @return the ap_paterno
     */
    public String getAp_paterno() {
        return ap_paterno;
    }

    /**
     * @param ap_paterno the ap_paterno to set
     */
    public void setAp_paterno(String ap_paterno) {
        this.ap_paterno = ap_paterno;
    }

    /**
     * @return the ap_materno
     */
    public String getAp_materno() {
        return ap_materno;
    }

    /**
     * @param ap_materno the ap_materno to set
     */
    public void setAp_materno(String ap_materno) {
        this.ap_materno = ap_materno;
    }

    /**
     * @return the telefono
     */
    public long getTelefono() {
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
     * @return the numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(int numero) {
        this.numero = numero;
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
    
       public void initValues() {
                  String sql = "SELECT * FROM clientes";
         connection.executeQuery(sql);
        connection.moveNext();
        setValues();
    }
       public void setValues(){
        this.idcliente = connection.getInteger("id_cliente");
        this.nombre = connection.getString("nombre");
        this.ap_paterno = connection.getString("ap_paterno");
        this.ap_materno = connection.getString("ap_materno");
        this.telefono = connection.getInteger("telefono");
        this.email = connection.getString("email");
        this.rfc = connection.getString("rfc");
        this.calle = connection.getString("calle");
        this.numero = connection.getInteger("no");
        this.colonia = connection.getString("colonia");
        this.ciudad = connection.getString("ciudad");
        this.estado = connection.getString("estado");
                       
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
    
        
 public void guardarregistro(String nombre,String ap_paterno,String ap_materno,int telefono,String email,  String rfc, String calle,int numero,String colonia,String ciudad, String estado) {
    String add = "INSERT INTO clientes (`nombre`,`ap_paterno`,`ap_materno`,`telefono`,`email` ,`rfc`,`calle`,`no`,`colonia`,`ciudad`,`estado`)"+ " VALUES ('" +nombre+
            "' , '"+ap_paterno+ "' ,  '"+ap_materno+"' ,  '"+telefono+"' , '"+email+"', '"+rfc+"', '"+calle+"', '"+numero+"', '"+colonia+"', '"+ciudad+"', '"+estado+"' );";
     connection.executeUpdate(add);
     initValues();
    }


    public void alterRecord(int idcliente, String nombre,String ap_paterno,String ap_materno,int telefono,String email,  String rfc, String calle,int numero,String colonia,String ciudad, String estado) {
        String alter = "UPDATE clientes SET nombre ='"+nombre+"', ap_paterno ='"+ap_paterno+"', ap_materno ='"+ap_materno+"', telefono ='"+telefono+"' , email='" +email+"' , rfc='" +rfc+"' , calle='" +calle+"'  , no='" +numero+"'  , colonia='" +colonia+"' , ciudad='" +ciudad+"' , estado='" +estado+"'   " + "WHERE id_cliente =" +idcliente;
        connection.executeUpdate(alter);
        initValues();
    }
    
    public void deleteRecord(int idproductos) {
        String delete = "DELETE FROM clientes WHERE id_cliente=" +idcliente;
        connection.executeUpdate(delete);
        initValues();
    }
    
       public void Tabla() {
        while (connection.moveNext()) {
            setValues();
               tableModel.addRow(new Object []{idcliente, nombre,ap_paterno,ap_materno,telefono,email,rfc,calle,numero,colonia,ciudad,estado});
        }
    }
}
