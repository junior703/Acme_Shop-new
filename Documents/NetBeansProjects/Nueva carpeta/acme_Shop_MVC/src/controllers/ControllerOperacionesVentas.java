/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.ModelOperacionesVentas;
import views.ViewAcercaDe;
import views.ViewOperacionesVentas;
import models.ModelIniciarSeccion;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class ControllerOperacionesVentas  implements ActionListener {
ViewOperacionesVentas viewOperacionesVentas;
   ModelOperacionesVentas modelOperacionesVentas;
   ModelIniciarSeccion modelIniciarSeccion;

    public ControllerOperacionesVentas(ViewOperacionesVentas viewOperacionesVentas, ModelOperacionesVentas modelOperacionesVentas,ModelIniciarSeccion modelIniciarSeccion) {
        this.viewOperacionesVentas = viewOperacionesVentas;
        this.modelOperacionesVentas = modelOperacionesVentas;
        this.modelIniciarSeccion=modelIniciarSeccion;
        
        this.viewOperacionesVentas.jBuscarrfc.addActionListener(this);
                this.viewOperacionesVentas.jBidbuscar.addActionListener(this);

        initView();
    
    }
    
     private void initView() {
        viewOperacionesVentas.setVisible(true);
            modelOperacionesVentas.initValues();
   modelOperacionesVentas.setValues();
           modelOperacionesVentas.initValues1();
   modelOperacionesVentas.setValues1();
      this.viewOperacionesVentas.jTfecha.setText(""+this.modelOperacionesVentas.FechaActual());

    }
     
      private void showValues() {
        
     viewOperacionesVentas.jTid.setText("" + modelOperacionesVentas.getIdcliente());
        viewOperacionesVentas.jTcliente.setText(modelOperacionesVentas.getCliente());
        viewOperacionesVentas.jTrfc.setText(modelOperacionesVentas.getRfc());
        viewOperacionesVentas.jTdireccion.setText(modelOperacionesVentas.getEstado());    
         viewOperacionesVentas.jTtelefono.setText(""+modelOperacionesVentas.getTelefono());  
      }
      
      private void show(){
       viewOperacionesVentas.jTproductos.setText(modelOperacionesVentas.getProducto());  
        viewOperacionesVentas.jTprecio.setText(""+modelOperacionesVentas.getPrecio());  
        viewOperacionesVentas.jTidproductos.setText(""+modelOperacionesVentas.getIdproducto());  

      
    }

     public void actionPerformed(ActionEvent g) {
        if (g.getSource() == viewOperacionesVentas.jBuscarrfc){
       buscarRFC();
              viewOperacionesVentas.jTvendedor.setText(modelIniciarSeccion.getUsername());

        } else if (g.getSource() == viewOperacionesVentas.jBidbuscar){
            buscarid();
            subtotal();
        }

}   
      public void buscarRFC(){
    modelOperacionesVentas.buscar(Integer.parseInt(viewOperacionesVentas.jTrfcbuscar.getText()));
    showValues();   
}
    
      public void buscarid(){
    modelOperacionesVentas.busqueda(Integer.parseInt(viewOperacionesVentas.jTidproductos.getText()));
    show();   
}
      
      public void  subtotal(){

      
    this.modelOperacionesVentas.setCantidad(Double.parseDouble(viewOperacionesVentas.jTcantidad.getText()));
      this.modelOperacionesVentas.setPrecio(Double.parseDouble(viewOperacionesVentas.jTprecio.getText()));
        
         this.viewOperacionesVentas.jTtotal.setText(""+this.modelOperacionesVentas.subtotal());
    

}
}
