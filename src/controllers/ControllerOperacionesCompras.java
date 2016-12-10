/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import models.ModelOperacionesCompras;
import sax.DBConnection;
import views.ViewOperacionesCompras;
import java.util.Calendar;
import java.util.Date;
import javax.swing.event.ListSelectionEvent;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class ControllerOperacionesCompras implements ActionListener{
    ViewOperacionesCompras viewOperacionesCompras;
    ModelOperacionesCompras modelOperacionesCompras;

    public ControllerOperacionesCompras(ViewOperacionesCompras viewOperacionesCompras, ModelOperacionesCompras modelOperacionesCompras) {
        this.viewOperacionesCompras = viewOperacionesCompras;
        this.modelOperacionesCompras = modelOperacionesCompras;
        this.viewOperacionesCompras.jbtn_agregar.addActionListener(this);
        this.viewOperacionesCompras.jbtn_buscar.addActionListener(this);
        this.viewOperacionesCompras.jbtn_cancelar.addActionListener(this);
        this.viewOperacionesCompras.jbtn_consultar.addActionListener(this);
        this.viewOperacionesCompras.jbtn_nvaCompra.addActionListener(this);
        this.viewOperacionesCompras.jtf_iva.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e){
                char c = e.getKeyChar();
                if(!Character.isDigit(c) && e.getKeyChar()!=8 && e.getKeyChar()!=127){
                    e.consume();
                    JOptionPane.showMessageDialog(null, "Por Favor Solo Ingrese Numeros", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                }else if(viewOperacionesCompras.jtf_iva.getText().length()==2){
                    e.consume();
                    JOptionPane.showMessageDialog(null, "No Introduzca Mas De 10 Carateres", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        
        
    }
    public void initViews(){
        llenaProveedores();
        llenaProductos();
    }
    
    DBConnection connection = new DBConnection(3306,"localhost", "acme_shop", "root", "7890");
    public void llenaProveedores(){
        
        String sql = "SELECT nombre FROM proveedor where nombre<>'General' GROUP BY nombre;";
        connection.executeQuery(sql);
        String cliente = connection.getString("nombre");
        while(connection.moveNext()){
            cliente = connection.getString("nombre");
            viewOperacionesCompras.jcbx_proveedor.addItem(cliente);
            viewOperacionesCompras.jcbx_consultar.addItem(cliente);
        }
    }
    
    public void llenaProductos(){
        String proveedor=""+viewOperacionesCompras.jcbx_proveedor.getSelectedItem();
        String sql = "SELECT producto FROM productos where producto<>'';";
        connection.executeQuery(sql);
        String producto = connection.getString("producto");
        while(connection.moveNext()){
            producto = connection.getString("producto");
            viewOperacionesCompras.jcbx_producto.addItem(producto);
        }
    }
        
    public void clear(){
        while(modelOperacionesCompras.modelDefault.getRowCount()>0){
            modelOperacionesCompras.modelDefault.removeRow(0);
        }
        while(modelOperacionesCompras.modelCompras.getRowCount()>0){
            modelOperacionesCompras.modelCompras.removeRow(0);
        }
        while(modelOperacionesCompras.modelProve.getRowCount()>0){
            modelOperacionesCompras.modelProve.removeRow(0);
        }
    }

    public void todas(){
        clear();
        modelOperacionesCompras.initCompras();
        viewOperacionesCompras.jtb_detalle.setModel(modelOperacionesCompras.modelCompras);
        modelOperacionesCompras.tableCompras();
        double sbtot=0;
        double total=0;
        if(modelOperacionesCompras.modelCompras.getRowCount()>0){
            int ro = modelOperacionesCompras.modelCompras.getRowCount();
            for(int j=0; j<ro;j++){
            sbtot=Double.parseDouble(viewOperacionesCompras.jtb_detalle.getValueAt(j, 8).toString());

            total +=  sbtot;
            viewOperacionesCompras.jtf_total.setText(""+total);}
        }
    }
    public void porProveedor(){
        clear();
        modelOperacionesCompras.initPorProveedores(""+viewOperacionesCompras.jcbx_consultar.getSelectedItem());
        viewOperacionesCompras.jtb_detalle.setModel(modelOperacionesCompras.modelProve);
        modelOperacionesCompras.tableProv();
        double sbtot=0;
        double total=0;
        if(modelOperacionesCompras.modelProve.getRowCount()>0){
            int ro = modelOperacionesCompras.modelProve.getRowCount();
            for(int j=0; j<ro;j++){
            sbtot=Double.parseDouble(viewOperacionesCompras.jtb_detalle.getValueAt(j, 5).toString());

            total +=  sbtot;
            viewOperacionesCompras.jtf_total.setText(""+total);}
        }
    }
    public void buscaCompra(){
        String c =""+modelOperacionesCompras.obtenCompras(),d=""+viewOperacionesCompras.jtf_idCompra.getText();
        System.out.println(""+c +"  "+d);
        if(viewOperacionesCompras.jtf_idCompra.getText().equals("")){
            JOptionPane.showMessageDialog(null, "por favor ingrese un valor", "ATENCION", JOptionPane.WARNING_MESSAGE);
        }else if(c.contains(d)){
            clear();
            modelOperacionesCompras.buscaCompra(Integer.parseInt(viewOperacionesCompras.jtf_idCompra.getText()));
            viewOperacionesCompras.jtb_detalle.setModel(modelOperacionesCompras.modelCompras);
            modelOperacionesCompras.tableCompras();
            double sbtot=0;
            double total=0;
            if(modelOperacionesCompras.modelCompras.getRowCount()>0){
                int ro = modelOperacionesCompras.modelCompras.getRowCount();
                for(int j=0; j<ro;j++){
                sbtot=Double.parseDouble(viewOperacionesCompras.jtb_detalle.getValueAt(j, 8).toString());
                
                total +=  sbtot;
                viewOperacionesCompras.jtf_total.setText(""+total);}
            }
        } else{
            JOptionPane.showMessageDialog(null, "No existe esa compra", "ATENCION", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void agregar(){
        if(viewOperacionesCompras.jsp_cantidad.getValue().equals(0) || viewOperacionesCompras.jdc_fecha.getCalendar()==null || viewOperacionesCompras.jtf_iva.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Por favor llene todos los campos", "ATENCION", JOptionPane.WARNING_MESSAGE);
        }else{
            Date jdate = new Date();
            double ivaV = Double.parseDouble("."+viewOperacionesCompras.jtf_iva.getText());
            double total=0;
            String producto=viewOperacionesCompras.jcbx_producto.getSelectedItem().toString();
            viewOperacionesCompras.jtb_detalle.setModel(modelOperacionesCompras.modelDefault);
            noRow();
            int id_c= modelOperacionesCompras.getLastC()+1;
            int id_producto=modelOperacionesCompras.obtenidProd(viewOperacionesCompras.jcbx_producto.getSelectedItem().toString());
            int cantidad=(int) viewOperacionesCompras.jsp_cantidad.getValue();
            double precio=(modelOperacionesCompras.obtenidPrecio(id_producto));
            double iva=(precio*ivaV)+precio;
            double subTotal=iva*cantidad;
            double sbtot=0;
            modelOperacionesCompras.tableAdd(id_c,id_producto, producto, cantidad, precio, iva, subTotal);
            
           if(modelOperacionesCompras.modelDefault.getRowCount()>0){
                int ro = modelOperacionesCompras.modelDefault.getRowCount();
                for(int j=0; j<ro;j++){
                sbtot=Double.parseDouble(viewOperacionesCompras.jtb_detalle.getValueAt(j, 6).toString());
                
                total +=  sbtot;
            viewOperacionesCompras.jtf_total.setText(""+total);}
            }
            
        }
        
    }
    public void nuevaCompra(){
        if(viewOperacionesCompras.jbtn_nvaCompra.getText().equals("Nueva Compra")){
            viewOperacionesCompras.jtb_detalle.setModel(modelOperacionesCompras.modelDefault);
            viewOperacionesCompras.jbtn_nvaCompra.setText("TERMINAR");
            viewOperacionesCompras.jcbx_producto.setEnabled(true);
            viewOperacionesCompras.jcbx_proveedor.setEnabled(true);
            viewOperacionesCompras.jdc_fecha.setEnabled(true);
            viewOperacionesCompras.jsp_cantidad.setEnabled(true);
            viewOperacionesCompras.jtf_iva.setEnabled(true);
            viewOperacionesCompras.jbtn_agregar.setEnabled(true);
            viewOperacionesCompras.jbtn_cancelar.setEnabled(true);
            viewOperacionesCompras.jbtn_buscar.setEnabled(false);
            viewOperacionesCompras.jbtn_consultar.setEnabled(false);
            modelOperacionesCompras.transaccion(1);
        }else if(viewOperacionesCompras.jbtn_nvaCompra.getText().equals("TERMINAR")){
            int idPro=modelOperacionesCompras.obtenidProv(viewOperacionesCompras.jcbx_proveedor.getSelectedItem().toString());
            double total= Double.parseDouble(viewOperacionesCompras.jtf_total.getText().toString());
            modelOperacionesCompras.addcompra(idPro, total);
            while(modelOperacionesCompras.modelDefault.getRowCount()>0){
                int idC=Integer.parseInt(viewOperacionesCompras.jtb_detalle.getValueAt(0, 0).toString());
                int idP=Integer.parseInt(viewOperacionesCompras.jtb_detalle.getValueAt(0, 1).toString());
                String fecha= ""+viewOperacionesCompras.jdc_fecha.getCalendar().get(Calendar.YEAR)+"-"+viewOperacionesCompras.jdc_fecha.getCalendar().get(Calendar.MONTH)+"-"+viewOperacionesCompras.jdc_fecha.getCalendar().get(Calendar.DAY_OF_MONTH);
                int cantidad=Integer.parseInt(viewOperacionesCompras.jtb_detalle.getValueAt(0, 5).toString());
                double precio=Double.parseDouble(viewOperacionesCompras.jtb_detalle.getValueAt(0, 3).toString());
                double iva=Double.parseDouble(viewOperacionesCompras.jtb_detalle.getValueAt(0, 4).toString());
                double subTotal=Double.parseDouble(viewOperacionesCompras.jtb_detalle.getValueAt(0, 6).toString());
                modelOperacionesCompras.addDetalle(idC, idP, fecha, cantidad, precio, iva, subTotal);
                modelOperacionesCompras.updateStock(idP, cantidad);
            modelOperacionesCompras.modelDefault.removeRow(0);
            }
            modelOperacionesCompras.transaccion(2);
            rstart();
        }
    }
    public void cancel(){
        modelOperacionesCompras.transaccion(3);
        rstart();
        
    }
    
    public void rstart(){
        viewOperacionesCompras.jbtn_nvaCompra.setText("Nueva Compra");
        viewOperacionesCompras.jcbx_producto.setEnabled(false);
        viewOperacionesCompras.jcbx_proveedor.setEnabled(false);
        viewOperacionesCompras.jdc_fecha.setEnabled(false);
        viewOperacionesCompras.jsp_cantidad.setEnabled(false);
        viewOperacionesCompras.jtf_iva.setEnabled(false);
        viewOperacionesCompras.jbtn_agregar.setEnabled(false);
        viewOperacionesCompras.jbtn_cancelar.setEnabled(false);
        boRowOff();
        viewOperacionesCompras.jbtn_buscar.setEnabled(true);
        viewOperacionesCompras.jbtn_consultar.setEnabled(true);
        clear();
        viewOperacionesCompras.jdc_fecha.setDate(null);
        viewOperacionesCompras.jsp_cantidad.setValue(0);
        viewOperacionesCompras.jtf_iva.setText(null);
        viewOperacionesCompras.jtf_total.setText(null);
        initViews();
    }   
    
    public void  noRow(){
        try {
            viewOperacionesCompras.jtb_detalle.getSelectionModel().addListSelectionListener((ListSelectionEvent g) -> {
            if(viewOperacionesCompras.jtb_detalle.getSelectedRow() != -1){
                int fila=viewOperacionesCompras.jtb_detalle.getSelectedRow() ;
                modelOperacionesCompras.modelDefault.removeRow(fila);
                double sbtot=0;
                double total=0;
                if(modelOperacionesCompras.modelDefault.getRowCount()>0){
                    int ro = modelOperacionesCompras.modelDefault.getRowCount();
                    for(int j=0; j<ro;j++){
                    sbtot=Double.parseDouble(viewOperacionesCompras.jtb_detalle.getValueAt(j, 6).toString());

                    total +=  sbtot;
                    viewOperacionesCompras.jtf_total.setText(""+total);}
                }
            }
        });
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("no se puede eliminar: "+e);
        }
    }
    
    public void boRowOff(){
        viewOperacionesCompras.jtb_detalle.getSelectionModel().removeListSelectionListener(viewOperacionesCompras.jtb_detalle);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==viewOperacionesCompras.jbtn_nvaCompra){
            nuevaCompra();
        }
        if(e.getSource()==viewOperacionesCompras.jbtn_cancelar){
            cancel();
        }
        if(e.getSource()==viewOperacionesCompras.jbtn_buscar){
            buscaCompra();
        }
        if (e.getSource()==viewOperacionesCompras.jbtn_agregar){
            agregar();
        }
        if(e.getSource()==viewOperacionesCompras.jbtn_consultar){
            if(viewOperacionesCompras.jcbx_consultar.getSelectedItem()=="TODAS"){
                todas();
            }else if(viewOperacionesCompras.jcbx_consultar.getSelectedItem()=="-----------------"){
                JOptionPane.showMessageDialog(null, "Elija 'TODAS' para mostrar todas las compras realizadas \nElija un proveedor para ver las compras realizadas al mismo", "ATENCION", JOptionPane.WARNING_MESSAGE);
            }else{
                porProveedor();
            }
        }
    }

}
