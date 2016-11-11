/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
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
              this.viewCliente.jBuscar1.addActionListener(this);
              initView();
           //   showRecords();
              leerdatos();
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
                    showRecords();
        } else if (g.getSource() == viewCliente.jbeditar){
          alterRecordButton();
        } else if (g.getSource() == viewCliente.jBuscar1){
          buscar();
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
        viewCliente.jtfno.setText(""+modelCliente.getNumero());
        viewCliente.jtfCity.setText(modelCliente.getCiudad());
        viewCliente.jtfColony.setText(""+modelCliente.getColonia());
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
                viewCliente.jtfno.setText("");

          
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
     int numero=Integer.parseInt( viewCliente.jtfno.getText());
     String colonia= viewCliente.jtfCity.getText();
     String ciudad= viewCliente.jtfColony.getText();
     String estado= viewCliente.jtfState.getText();//jtfno
         

     
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
     int numero=Integer.parseInt( viewCliente.jtfno.getText());
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
    
   public void buscar(){
    modelCliente.busqueda(Integer.parseInt(viewCliente.jTbuscar.getText()));
    showValues();    
}


   public void  leerdatos(){
     viewCliente.jtbledetalle.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

         @Override
         
         public void valueChanged(ListSelectionEvent g) {
             
             if(viewCliente.jtbledetalle.getSelectedRow() != -1){ 
                 
             int fila=viewCliente.jtbledetalle.getSelectedRow() ;
             
             viewCliente.jtfidCliente.setText( viewCliente.jtbledetalle.getValueAt(fila, 0).toString());
              viewCliente.jtfName1.setText(viewCliente.jtbledetalle.getValueAt(fila, 1).toString());
               viewCliente.jtfPatLastName.setText(viewCliente.jtbledetalle.getValueAt(fila, 2).toString());
               viewCliente.jtfMatLastName.setText(viewCliente.jtbledetalle.getValueAt(fila, 3).toString());
                   viewCliente.jtfTelephone.setText(viewCliente.jtbledetalle.getValueAt(fila, 4).toString());
                         viewCliente.jtfEmail.setText( viewCliente.jtbledetalle.getValueAt(fila, 5).toString());
                       viewCliente.jtfRFC.setText(viewCliente.jtbledetalle.getValueAt(fila, 6).toString());
                  viewCliente.jtfState.setText(viewCliente.jtbledetalle.getValueAt(fila, 7).toString());      
                  viewCliente.jtfCity.setText(viewCliente.jtbledetalle.getValueAt(fila, 8).toString());
               viewCliente.jtfColony.setText(viewCliente.jtbledetalle.getValueAt(fila, 9).toString());
                               viewCliente.jtfno.setText(viewCliente.jtbledetalle.getValueAt(fila, 11).toString());
                viewCliente.jtfCalle.setText(viewCliente.jtbledetalle.getValueAt(fila, 10).toString());
                                //      viewProductosModificacion.jtexistencias.setText(viewProductosModificacion.jtbledetalle.getValueAt(fila, 5).toString());

             }
         }
     });
    }
}
 