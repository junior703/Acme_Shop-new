
package models;

import java.util.Collections;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import sax.DBConnection;

public class ModelOperacionesCompras {
    public DBConnection connection = new DBConnection(3306,"localhost", "acme_shop", "root", "7890");
    
    public  DefaultTableModel modelDefault = new DefaultTableModel(new String [] {"id_compra","id_Producto", "Producto", "Precio", "Precio IVA", "Cantidad", "Subtotal"}, 0);
    public  DefaultTableModel modelCompras = new DefaultTableModel(new String [] {"id_Compra", "Fecha", "Proveedor", "Contacto", "Producto", "Precio","Cantidad","+IVA","Subtotal"}, 0);
    public  DefaultTableModel modelProve = new DefaultTableModel(new String [] {"id_Compra", "Producto", "Precio","Cantidad","+IVA","Subtotal"}, 0);
    
    private int id_compra;
    private int id_proveedor;
    private int id_producto;
    private int id_det_compra;
    private String nombre;
    private String contacto;
    private String producto;
    private String fecha;
    private double precio;
    private int cantidad;
    private double iva;
    private double subtotal;
    private double total;
    private int existencias;

    /**
     * @return the id_compra
     */
    public int getId_compra() {
        return id_compra;
    }

    /**
     * @param id_compra the id_compra to set
     */
    public void setId_compra(int id_compra) {
        this.id_compra = id_compra;
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

    /**
     * @return the id_producto
     */
    public int getId_producto() {
        return id_producto;
    }

    /**
     * @param id_producto the id_producto to set
     */
    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    /**
     * @return the id_det_compra
     */
    public int getId_det_compra() {
        return id_det_compra;
    }

    /**
     * @param id_det_compra the id_det_compra to set
     */
    public void setId_det_compra(int id_det_compra) {
        this.id_det_compra = id_det_compra;
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
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
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
    public int getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the iva
     */
    public double getIva() {
        return iva;
    }

    /**
     * @param iva the iva to set
     */
    public void setIva(double iva) {
        this.iva = iva;
    }

    /**
     * @return the total
     */
    public double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(double total) {
        this.total = total;
    }

    /**
     * @return the subtotal
     */
    public double getSubtotal() {
        return subtotal;
    }

    /**
     * @param subtotal the subtotal to set
     */
    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
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
    public String obtenCompras(){
        String sql = "SELECT id_compra FROM compras;";
        connection.executeQuery(sql);
        Vector<String> id = new Vector<>(); 
        while(connection.moveNext()){
             id.add(String.valueOf(connection.getInteger("id_compra")));
        }
        String ids="";
        for(int x=0;x<id.size();x++){
            ids=ids+id.elementAt(x);
        }
        return ids;
    }
    public int obtenidProd(String prod){
        String sql = "SELECT id_producto FROM productos WHERE producto='"+prod+"';";
        connection.executeQuery(sql);
        connection.moveNext();
        return id_producto=connection.getInteger("id_producto");
    }
    public int obtenidProv(String prov){
        String sql = "SELECT id_proveedor FROM proveedor WHERE nombre='"+prov+"';";
        connection.executeQuery(sql);
        connection.moveNext();
        return id_proveedor=connection.getInteger("id_proveedor");
    }
    public double obtenidPrecio(int idP){
        String sql = "SELECT pro FROM productos WHERE id_producto='"+idP+"';";
        connection.executeQuery(sql);
        connection.moveNext();
        return precio=connection.getDouble("pro");
    }
    public int hayCompraProveedor(String prov){
        String sql ="SELECT c.id_compra, pr.producto, pr.pro as precio, dc.cantidad, dc.iva , dc.total\n" +
                        "FROM compras c, proveedor p, productos pr, detalle_compra dc\n" +
                        "where p.id_proveedor=c.id_proveedor and c.id_compra = dc.id_compra and pr.id_producto=dc.id_producto\n" +
                        "AND p.nombre='"+prov+"';";
        connection.executeQuery(sql);
        connection.moveNext();
        int v=-1;
        
        if(connection.moveNext()){
            v=1;
        }else {
            v=0;
        }
        return v;
    }
    public void initCompras(){
        String sql ="SELECT c.id_compra,dc.fecha, p.nombre as proveedor, p.nombre_contacto as contacto, pr.producto, pr.pro as precio, dc.cantidad, dc.iva , dc.total\n" +
                        "FROM compras c, proveedor p, productos pr, detalle_compra dc\n" +
                        "where p.id_proveedor=c.id_proveedor and c.id_compra = dc.id_compra and pr.id_producto=dc.id_producto;";
        connection.executeQuery(sql);
        setValuesCompras();
    }
    public void initPorProveedores(String prov){
        String sql ="SELECT c.id_compra, pr.producto, pr.pro as precio, dc.cantidad, dc.iva , dc.total\n" +
                        "FROM compras c, proveedor p, productos pr, detalle_compra dc\n" +
                        "where p.id_proveedor=c.id_proveedor and c.id_compra = dc.id_compra and pr.id_producto=dc.id_producto\n" +
                        "AND p.nombre='"+prov+"';";
        connection.executeQuery(sql);
        setValuesProv();
    }
    public void buscaCompra(int id){
        String sql ="SELECT c.id_compra,dc.fecha, p.nombre as proveedor, p.nombre_contacto as contacto, pr.producto, pr.pro as precio, dc.cantidad, dc.iva , dc.total\n" +
                        "FROM compras c, proveedor p, productos pr, detalle_compra dc\n" +
                        "where p.id_proveedor=c.id_proveedor and c.id_compra = dc.id_compra and pr.id_producto=dc.id_producto\n" +
                        "AND c.id_compra='"+id+"';";
        connection.executeQuery(sql);
        setValuesCompras();
    }
    public void addcompra(int idPro, double total){
        String sql="Insert into compras(id_proveedor, total) values ('"+idPro+"', '"+total+"');";
        connection.executeUpdate(sql);
    }
    public void addDetalle(int idC, int idP, String fecha, int cantidad, double precio, double iva, double total){
        String sql="Insert into detalle_compra(id_compra, id_producto, fecha, cantidad, precio, iva, total) "
                + "values ('"+idC+"', '"+idP+"', '"+fecha+"','"+cantidad+"', '"+precio+"', '"+iva+"', '"+total+"');";
        connection.executeUpdate(sql);
    }
    public void updateStock(int produ, int cant){
        String sql= "UPDATE productos set existencias = existencias+"+cant+" WHERE id_producto='"+produ+"';";
        connection.executeUpdate(sql);
    }
    public void setValuesCompras(){
        id_compra=connection.getInteger("id_compra");
        fecha=connection.getString("fecha");
        nombre=connection.getString("proveedor");
        contacto=connection.getString("contacto");
        producto=connection.getString("producto");
        precio=connection.getDouble("precio");
        cantidad=connection.getInteger("cantidad");
        iva=connection.getDouble("iva");
        subtotal=connection.getDouble("total");
    }
    public void setValuesProv(){
        id_compra=connection.getInteger("id_compra");
        producto=connection.getString("producto");
        precio=connection.getDouble("precio");
        cantidad=connection.getInteger("cantidad");
        iva=connection.getDouble("iva");
        subtotal=connection.getDouble("total");
    }
    
    public void tableCompras(){
        while(connection.moveNext()){
            setValuesCompras();
            modelCompras.addRow(new Object[]{id_compra,fecha,nombre,contacto,producto,precio,cantidad,iva,subtotal});
        }
    }
    public void tableProv(){
        while(connection.moveNext()){
            setValuesCompras();
            modelProve.addRow(new Object[]{id_compra,producto,precio,cantidad,iva,subtotal});
        }
    }
    public void tableAdd(int id_c, int id_producto, String producto, int cantidad, double precio ,double iva,double subTotal){
        modelDefault.addRow(new Object[]{id_c, id_producto, producto, precio, iva, cantidad, subTotal});
    }
    
    public int getLastC(){
        String sql = "SELECT id_compra FROM compras;";
        connection.executeQuery(sql);
        Vector<Integer> id = new Vector<>(); 
        while(connection.moveNext()){
             id.add(connection.getInteger("id_compra"));
        }
        Collections.sort(id);
        int last = id.lastElement();
        return last;
    }
    
    public void transaccion(int v){
        String begin = "BEGIN";
        String commit = "COMMIT";
        String rBack = "ROLLBACK";
        switch(v){
            case 1:
                connection.executeQuery(begin);
            case 2:
                connection.executeQuery(commit);
            case 3:
                connection.executeQuery(rBack);
        }
    }
}
