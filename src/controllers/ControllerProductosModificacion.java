/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import views.ViewProductosModificacion;
import models.ModelProductosModificacion;
/**
 * 
 * @author Bnc
 */
public class ControllerProductosModificacion  implements ActionListener{
   ViewProductosModificacion viewProductosModificacion;
    ModelProductosModificacion modelProductosModificacion;
    
    
    public ControllerProductosModificacion(ViewProductosModificacion viewProductosModificacion, ModelProductosModificacion modelProductosModificacion) {
        this.viewProductosModificacion = viewProductosModificacion;
        this.modelProductosModificacion = modelProductosModificacion;
        
            this.viewProductosModificacion.jbprimero.addActionListener(this);  
          this.viewProductosModificacion.jbanterior.addActionListener(this);
          this.viewProductosModificacion.jbsiguiente.addActionListener(this); 
              this.viewProductosModificacion.jbultimo.addActionListener(this); 
    }

     public void actionPerformed(ActionEvent g) {
        if (g.getSource() == viewProductosModificacion.jbprimero){
            firstButton();
        }
        else if (g.getSource() == viewProductosModificacion.jbanterior){
            previousButton();
        }
        else if (g.getSource() == viewProductosModificacion.jbsiguiente){
            nextButton();
        }
        else if (g.getSource() == viewProductosModificacion.jbultimo){
            lastButton();
        }
    }
    
    private void firstButton() {
        modelProductosModificacion.moveFirst();
        modelProductosModificacion.setValues();
        showValues();
    }
    
    private void previousButton() {
        modelProductosModificacion.movePrevious();
        modelProductosModificacion.setValues();
        showValues();
    }
    
    private void nextButton() {
        modelProductosModificacion.moveNext();
        modelProductosModificacion.setValues();
        showValues();
    }
    
    private void lastButton() {
        modelProductosModificacion.moveLast();
        modelProductosModificacion.setValues();
        showValues();
    }
    
    private void showValues() {
        
     //   this.modelProductosModificacion.setIdproductos(Interger.parseInteger(viewProductosModificacion.jTidproducto.getText() ));
        viewProductosModificacion.jTidproducto.setText("" + modelProductosModificacion.getIdproductos());
        viewProductosModificacion.jtdescricion.setText(modelProductosModificacion.getDescripcion());
        viewProductosModificacion.jtproducto.setText(modelProductosModificacion.getProductos());
        viewProductosModificacion.jtpreciocompra.setText(""+modelProductosModificacion.getPreciocompra());    
      //    this.modelarea.setLargo(Double.parseDouble(viewarea.jTlargo.getText()));
          viewProductosModificacion.jtprecioventa.setText(""+modelProductosModificacion.getPrecioventa());
        viewProductosModificacion.jtexistencias.setText(""+modelProductosModificacion.getExistencias());  
    }
    
    private void initView() {
        viewProductosModificacion.setVisible(true);
        modelProductosModificacion.initValues();
        modelProductosModificacion.setValues();
    }
 
   

}
    

