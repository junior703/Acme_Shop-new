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
public class ModelProductosModificacion {
 
  
      private DBConnection connection = new DBConnection(3306,"localhost", "acme_shop", "root", "7890");
    private int idproductos;
  private int existencias;
    private String productos;
    private String Descripcion;
  //   private String precioventa;
    //  private String preciocompra;
    private double precioventa;
      private double preciocompra;
       
  // conexion=DriverManager.getConnection("jdbc:mysql://localhost/prueba1","root","");  

    /**
     * @return the idproductos
     */
    public int getIdproductos() {
        return idproductos;
    }

    /**
     * @param idproductos the idproductos to set
     */
    public void setIdproductos(int idproductos) {
        this.idproductos = idproductos;
    }

    /**
     * @return the existencias
     */
    public int getExistencias() {
        return existencias;
    }

    /**
     * @param existencias the existencias to set
     */
    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }

    /**
     * @return the productos
     */
    public String getProductos() {
        return productos;
    }

    /**
     * @param productos the productos to set
     */
    public void setProductos(String productos) {
        this.productos = productos;
    }

    /**
     * @return the Descripcion
     */
    public String getDescripcion() {
        return Descripcion;
    }

    /**
     * @param Descripcion the Descripcion to set
     */
    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }
    /**
     * @return the precioventa
     */
    public double getPrecioventa() {
        return precioventa;
    }

    /**
     * @param precioventa the precioventa to set
     */
   public void setPrecioventa(double precioventa) {
        this.precioventa = precioventa;
    }

    /**
     * @return the preciocompra
     */
   public double getPreciocompra() {
        return preciocompra;
    }

    /**
     * @param preciocompra the preciocompra to set
     */
    public void setPreciocompra(double preciocompra) {
        this.preciocompra = preciocompra;
    }
    
      public void initValues() {
        String sql = "SELECT id_producto, producto, descripcion, precio_compra, precio_venta, existencias FROM productos";
        connection.executeQuery(sql);
        connection.moveNext();
    }
    
    public void setValues() {
        idproductos = connection.getInteger("id_producto");
        productos= connection.getString("producto");
        Descripcion = connection.getString("descripcion");
        preciocompra=(connection.getDouble("precio_compra"));
          precioventa=(connection.getDouble("precio_venta"));
         existencias = connection.getInteger("existencias");
    }
    
    public void moveFirst() {
        connection.moveFirst();
    }
    
    public void movePrevious() {
        connection.movePrevious();
    }
    
    public void moveNext() {
        connection.moveNext();
    }
    
    public void moveLast() {
        connection.moveLast();
    }

    /**
     * @return the precioventa
     */
   
}
