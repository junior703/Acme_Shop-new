/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import models.ModelCliente;
import views.ViewCliente;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class ControllerCliente   implements ActionListener{
 private final ViewCliente viewCliente;
    private final ModelCliente modelCliente;
    
    public ControllerCliente(ViewCliente viewCliente, ModelCliente modelCliente) {
        this.viewCliente = viewCliente;
        this.modelCliente = modelCliente;
        
        this.viewCliente.jbprimero.addActionListener(this);  
          this.viewCliente.jbanterior.addActionListener(this);
          this.viewCliente.jbsiguiente.addActionListener(this); 
              this.viewCliente.jbultimo.addActionListener(this); 
               this.viewCliente.jbagregar.addActionListener(this);  
          this.viewCliente.jbborrar.addActionListener(this);
          this.viewCliente.jbeditar.addActionListener(this); 
              this.viewCliente.jbguadar.addActionListener(this); 
              this.viewCliente.jBsaveeditar.addActionListener(this); 
              initView();
              showRecords();
    }

         public void actionPerformed(ActionEvent g) {
        if (g.getSource() == viewCliente.jbprimero){
            firstButton();
        }
        else if (g.getSource() == viewCliente.jbanterior){
            previousButton();
        }
        else if (g.getSource() == viewCliente.jbsiguiente){
            nextButton();
        }
        else if (g.getSource() == viewCliente.jbultimo){
            lastButton();
        }
        else if (g.getSource() == viewCliente.jbagregar){
            aggregar();
        }else if (g.getSource() == viewCliente.jbguadar){
            guardar();
        }else if (g.getSource() == viewCliente.jbborrar){
            deleteRecordButton();
        }  else if (g.getSource() == viewCliente.jBsaveeditar){
          guardarcambios();//alterRecordButton();
        } else if (g.getSource() == viewCliente.jbeditar){
          alterRecordButton();
        } 
    }
    
    private void firstButton() {
        modelCliente.moveFirst();
        modelCliente.setValues();
        showValues();
    }
    
    private void previousButton() {
        modelCliente.movePrevious();
        modelCliente.setValues();
        showValues();
    }
    
    private void nextButton() {
        modelCliente.moveNext();
        modelCliente.setValues();
        showValues();
    }
    
    private void lastButton() {
        modelCliente.moveLast();
        modelCliente.setValues();
        showValues();
    }
private void showValues(){
        viewCliente.jtfidCliente.setText(""+modelCliente.getIdcliente());
        viewCliente.jtfName1.setText(modelCliente.getNombre());
        viewCliente.jtfPatLastName.setText(modelCliente.getAp_paterno());
        viewCliente.jtfMatLastName.setText(modelCliente.getAp_materno());
        viewCliente.jtfTelephone.setText(""+modelCliente.getTelefono());
        viewCliente.jtfEmail.setText(modelCliente.getEmail());
        viewCliente.jtfRFC.setText(modelCliente.getRfc());
        viewCliente.jtfCalle.setText(modelCliente.getCalle());
        viewCliente.jtfTelephone.setText(""+modelCliente.getNumero());
        viewCliente.jtfCity.setText(modelCliente.getColonia());
        viewCliente.jtfColony.setText(""+modelCliente.getCiudad());
        viewCliente.jtfState.setText(modelCliente.getEstado());
    }
    private void initView() {
        viewCliente.setVisible(true);
        modelCliente.initValues();
        modelCliente.setValues();
       
    }
    
      private void aggregar() {     
            viewCliente.jtfidCliente.setText("");
          viewCliente.jtfName1.setText("");
        viewCliente.jtfPatLastName.setText("");
        viewCliente.jtfMatLastName.setText("");
        viewCliente.jtfTelephone.setText("");
        viewCliente.jtfEmail.setText("");
          viewCliente.jtfRFC.setText("");
            viewCliente.jtfCalle.setText("");
        viewCliente.jtfTelephone.setText("");
        viewCliente.jtfCity.setText("");
        viewCliente.jtfColony.setText("");
        viewCliente.jtfState.setText("");
          
    }
     public void guardar(){
     int dialog = JOptionPane.showConfirmDialog(null, "¿Quieres guardar el nuevo registro?");
       
     
    String nombre= viewCliente.jtfName1.getText();
     String ap_paterno= viewCliente.jtfPatLastName.getText();
     String ap_materno= viewCliente.jtfMatLastName.getText();
     int telefono=Integer.parseInt( viewCliente.jtfTelephone.getText());
   String email= viewCliente.jtfEmail.getText();
   String rfc= viewCliente.jtfRFC.getText();
     String calle= viewCliente.jtfCalle.getText();
     int numero=Integer.parseInt( viewCliente.jtfTelephone.getText());
     String colonia= viewCliente.jtfCity.getText();
     String ciudad= viewCliente.jtfColony.getText();
     String estado= viewCliente.jtfState.getText();
     
             modelCliente.guardarregistro( nombre,ap_paterno,ap_materno,telefono,email,rfc,calle,numero,colonia,ciudad,estado) ;
  
               modelCliente.setValues();
                showValues();
                firstButton();
        }
     
       private void deleteRecordButton(){
        this.modelCliente.deleteRecord(Integer.parseInt(viewCliente.jtfidCliente.getText()));
           modelCliente.setValues();
           showValues();
        
    }
        private void alterRecordButton() {
        int dialog = JOptionPane.showConfirmDialog(null, "¿Desea modificar este registro?");
    }
        
            private void guardarcambios() {
        int dialog = JOptionPane.showConfirmDialog(null, "¿Desea guardar los cambios?");
                 int idcliente =Integer.parseInt( viewCliente.jtfidCliente.getText());
                String nombre= viewCliente.jtfName1.getText();
     String ap_paterno= viewCliente.jtfPatLastName.getText();
     String ap_materno= viewCliente.jtfMatLastName.getText();
     int telefono=Integer.parseInt( viewCliente.jtfTelephone.getText());
   String email= viewCliente.jtfEmail.getText();
   String rfc= viewCliente.jtfRFC.getText();
     String calle= viewCliente.jtfCalle.getText();
     int numero=Integer.parseInt( viewCliente.jtfTelephone.getText());
     String colonia= viewCliente.jtfCity.getText();
     String ciudad= viewCliente.jtfColony.getText();
     String estado= viewCliente.jtfState.getText();
         
                modelCliente.alterRecord(idcliente, nombre,ap_paterno,ap_materno,telefono,email,rfc,calle,numero,colonia,ciudad,estado);
                JOptionPane.showMessageDialog(null, "Se han guardado los cambios con éxito");
                modelCliente.setValues();
                showValues();
                firstButton();
            
        
    }
 
    private void showRecords() {
       
        viewCliente.jtbledetalle.setModel(modelCliente.tableModel);
        modelCliente.Tabla();
    }
}
 