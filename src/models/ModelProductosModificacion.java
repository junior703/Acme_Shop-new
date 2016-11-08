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
public class ModelProductosModificacion {
 
  
    //public DBConnection connection = new DBConnection(3306,"sql9.freemysqlhosting.net", "sql9141835", "sql9141835", "MwVLnwnFfK");
            public DBConnection connection = new DBConnection(3306,"localhost", "acme_shop", "root", "7890");

    private int idproductos;
    private int existencias;
    private String productos;
    private String Descripcion;
    private double precioventa;
      private double preciocompra;
       
       public  DefaultTableModel tableModel = new DefaultTableModel(new String [] {"id_producto", "producto", "descripcion", "pro","precio_venta","existencias"}, 0);

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
                  String sql = "SELECT * FROM productos";

    //    String sql = "SELECT id_producto, producto, descripcion, precio_compra, precio_venta, existencias FROM productos";
       //  connection.executeQuery("SELECT id_producto,  producto,  descripcion,  precio_compra,  precio_venta,  existencias FROM productos;");
       //   String sql = "SELECT id_producto, producto, descripcion, precio_compra, precio_venta, existencias FROM productos";
         connection.executeQuery(sql);
        connection.moveNext();
        setValues();
    }
    
    public void setValues() {//this
        idproductos = connection.getInteger("id_producto");
       productos= connection.getString("producto");
        Descripcion = connection.getString("descripcion");
        preciocompra=connection.getDouble("pro");
       precioventa=connection.getDouble("precio_venta");
       existencias = connection.getInteger("existencias");
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
// String add = "INSERT INTO contactos (`nombre`, `telefono`, `email`)"+ "VALUES ('"+name+"', '"+phone+"', '"+mail+"');";

    
 public void guardarregistro(String productos, String Descripcion, double preciocompra, double precioventa, int existencias) {
    String add = "INSERT INTO productos (`producto`,`descripcion`,`pro`,`precio_venta`,`existencias`)"+ " VALUES ('" +productos+
            "' , '"+Descripcion+ "' ,  '"+preciocompra+"' ,  '"+precioventa+"' , '"+existencias+"');";
     connection.executeUpdate(add);
     initValues();
    }


    public void alterRecord(int idproductos, String productos, String Descripcion, double preciocompra, double precioventa, int existencias) {
        String alter = "UPDATE productos SET producto ='"+productos+"', descripcion ='"+Descripcion+"', pro ='"+preciocompra+"' , precio_venta='" +precioventa+"' , existencias='" +existencias+"'  " + "WHERE id_producto =" +idproductos;
        connection.executeUpdate(alter);
        initValues();
    }
    
    public void deleteRecord(int idproductos) {
        String delete = "DELETE FROM productos WHERE id_producto=" +idproductos;
        connection.executeUpdate(delete);
        initValues();
    }
    public void populateTable() {
   while (connection.moveNext()) {
            setValues();
            tableModel.addRow(new Object []{idproductos, productos, Descripcion, preciocompra,precioventa,existencias});
      
        }
    }
    public void busqueda(String productos) {
        String query =   ("Select * from productos  WHERE producto = '"+productos+"'"); 
    
        //String query = "SELECT * FROM productos WHERE producto LIKE "+productos+"%;";
        connection.executeQuery(query);
        connection.moveNext();
        populateTable();
    }   
   
   
}