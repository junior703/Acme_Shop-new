/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import sax.DBConnection;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class ModelOperacionesVentas {
                public DBConnection connection = new DBConnection(3306,"localhost", "acme_shop", "root", "7890");

    private String nombrevendedor;
        private int idvendedor;
    private int fecha;
    
     private int idcliente;
    private String cliente;
    private String rfc;
    private String estado;
     private long telefono;
    
    private int idproducto;
    private String producto ;
    private double precio;
    private double cantidad;
    
     public Date date = new Date();
   // public DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");

    /**
     * @return the nombrevendedor
     */
    public String getNombrevendedor() {
        return nombrevendedor;
    }

    /**
     * @param nombrevendedor the nombrevendedor to set
     */
    public void setNombrevendedor(String nombrevendedor) {
        this.nombrevendedor = nombrevendedor;
    }

    /**
     * @return the idvendedor
     */
    public int getIdvendedor() {
        return idvendedor;
    }

    /**
     * @param idvendedor the idvendedor to set
     */
    public void setIdvendedor(int idvendedor) {
        this.idvendedor = idvendedor;
    }

    /**
     * @return the fecha
     */
    public int getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(int fecha) {
        this.fecha = fecha;
    }

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
     * @return the cliente
     */
    public String getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(String cliente) {
        this.cliente = cliente;
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
     * @return the idproducto
     */
    public int getIdproducto() {
        return idproducto;
    }

    /**
     * @param idproducto the idproducto to set
     */
    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    /**
     * @return the producto
     */
    public String getProducto() {
        return producto;
    }

    /**
     * @param producto the producto to set
     */
    public void setProducto(String producto) {
        this.producto = producto;
    }

    /**
     * @return the precio
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * @return the cantidad
     */
    public double getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
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
    
     public void initValues() {
                  String sql = "SELECT * FROM clientes";
         connection.executeQuery(sql);
        connection.moveNext();
        setValues();
    }
       
    public void setValues(){
        this.idcliente = connection.getInteger("id_cliente");
        this.rfc = connection.getString("rfc");
          this.estado= connection.getString("estado");
        this.cliente = connection.getString("nombre");
          this.telefono = connection.getInteger("telefono");

    }
      public static String FechaActual() {
        Date ahora = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
        return formateador.format(ahora);
    }
      
      public void buscar(int idcliente) {
        String query =   "Select * from clientes  WHERE id_cliente = "+idcliente; 
        connection.executeQuery(query);
                connection.moveNext();
         setValues();
    } 
      //*++++++++++++++++++++++++++++++++++++++++++++++++++++++++***********+

  /*  public static String HoraActual() {
        Date ahora = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("hh:mm:ss");
        return formateador.format(ahora);
    }*/
public void initValues1() {
                  String sql = "SELECT * FROM productos";
         connection.executeQuery(sql);
        connection.moveNext();
        setValues1();
    }
   public void setValues1() {//this
       this. idproducto = connection.getInteger("id_producto");
      this.producto= connection.getString("producto");
       this.precio=connection.getDouble("precio_venta");
      
    }
     public void busqueda(int idproducto) {
        String query =   "Select * from productos  WHERE id_producto = "+idproducto; 
        connection.executeQuery(query);
                connection.moveNext();
          setValues1();
     //   populateTable();
    }   
    
 public double  subtotal(){
    
    double sub=precio*cantidad;
                    return sub;
}

}
