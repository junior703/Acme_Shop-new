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
import javax.swing.table.DefaultTableModel;
import models.ModelUsuarios;
import views.ViewUsuarios;




/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class ControllerUsuarios implements ActionListener{
    ViewUsuarios viewUsuarios;
    ModelUsuarios modelUsuarios;
    
    public ControllerUsuarios(ViewUsuarios viewUsuarios, ModelUsuarios modelUsuarios) {
        this.viewUsuarios = viewUsuarios;
        this.modelUsuarios = modelUsuarios;
        
           this.viewUsuarios.jbprimero.addActionListener(this);  
          this.viewUsuarios.jbanterior.addActionListener(this);
          this.viewUsuarios.jbsiguiente.addActionListener(this); 
              this.viewUsuarios.jbultimo.addActionListener(this); 
               this.viewUsuarios.jbagregar.addActionListener(this);  
          this.viewUsuarios.jbborrar.addActionListener(this);
          this.viewUsuarios.jbeditar.addActionListener(this); 
              this.viewUsuarios.jBsaveeditar.addActionListener(this); 
              this.viewUsuarios.jBsaveeditar1.addActionListener(this); 
                            this.viewUsuarios.jBuscar.addActionListener(this); 
              initView();
              //showRecords();
              leerdatos();
    }
 public void actionPerformed(ActionEvent g) {
        if (g.getSource() == viewUsuarios.jbprimero){
            firstButton();
        }
        else if (g.getSource() == viewUsuarios.jbanterior){
            previousButton();
        }
        else if (g.getSource() == viewUsuarios.jbsiguiente){
            nextButton();
        }
        else if (g.getSource() == viewUsuarios.jbultimo){
            lastButton();
        }
        else if (g.getSource() == viewUsuarios.jbagregar){
           aggregar();
        }else if (g.getSource() == viewUsuarios.jBsaveeditar){
       saveButton();
       showRecords();
        }else if (g.getSource() == viewUsuarios.jbborrar){
      deleteButton();
        }  else if (g.getSource() == viewUsuarios.jBsaveeditar1){
         guardarcambios();//alterRecordButton();
                  showRecords();
        } else if (g.getSource() == viewUsuarios.jbeditar){
          alterRecordButton();
        } else if (g.getSource() == viewUsuarios.jBuscar){
        buscar();
    }
     }
    
    private void firstButton() {
        modelUsuarios.moveFirst();
        modelUsuarios.setValues();
        showValues();
    }
    
    private void previousButton() {
        modelUsuarios.movePrevious();
        modelUsuarios.setValues();
        showValues();
    }
    
    private void nextButton() {
        modelUsuarios.moveNext();
        modelUsuarios.setValues();
        showValues();
    }
    
    private void lastButton() {
        modelUsuarios.moveLast();
        modelUsuarios.setValues();
        showValues();
    }

  private void showValues() {
        viewUsuarios.jTidusername.setText(""+modelUsuarios.getIdusername());
        viewUsuarios.jPassword.setText(modelUsuarios.getPassword());
        viewUsuarios.jtnombre.setText(modelUsuarios.getNombre());
        viewUsuarios.jtusuario.setText(modelUsuarios.getUsername());
        
        int status = modelUsuarios.getStatus();
        if (status == 1){
            viewUsuarios.jComboestado.setSelectedItem("Activo");
        }
        else {
            viewUsuarios.jComboestado.setSelectedItem("inactivo");
        }
        
        String level = modelUsuarios.getLevel();
        if (level.equals("")){
            viewUsuarios.jCombonivel.setSelectedItem("gerente");
        }
        else {
            viewUsuarios.jCombonivel.setSelectedItem("caja");
        }
    }
    
    private void initView() {     
        viewUsuarios.setVisible(true);
        modelUsuarios.initValues();
        modelUsuarios.setValues();
       
    }

     private void showRecords() {
        viewUsuarios.jtbledetalle.setModel(modelUsuarios.tableModel);
        modelUsuarios.populateTable();
    }
     
     private void alterRecordButton() {
        int dialog = JOptionPane.showConfirmDialog(null, "¿Desea modificar este registro?");
    }
     
       private void aggregar() {       
          viewUsuarios.jTidusername.setText("");
        viewUsuarios.jtnombre.setText("");
        viewUsuarios.jtusuario.setText("");
        viewUsuarios.jPassword.setText("");
       
    }
     
       private void saveButton() {
               int dialog = JOptionPane.showConfirmDialog(null, "¿Quieres guardar el nuevo registro?");
        String username = viewUsuarios.jtusuario.getText();
        String password = viewUsuarios.jPassword.getText();
        String nombre = viewUsuarios.jtnombre.getText();
    
        int status;
        int statusIndex = viewUsuarios.jComboestado.getSelectedIndex();
        if (statusIndex == 0) {
            status = 1;
        }
        else {
            status = 0;
        }
        
        String level;
        int levelIndex = viewUsuarios.jCombonivel.getSelectedIndex();
        if (levelIndex == 0) {
            level = "gerente";
        }
        else {
            level = "caja";
        }
        
        modelUsuarios.guadarRegistro(username, password, status, level,nombre);
        modelUsuarios.initValues();
        modelUsuarios.moveFirst();
    }
    
    private void deleteButton() {
        int dialog = JOptionPane.showConfirmDialog(null, "¿seguro, que quiere borrar este registro? ");
        if (dialog == 0) {
            modelUsuarios.deleteUser(Integer.parseInt(viewUsuarios.jTidusername.getText()));
            JOptionPane.showMessageDialog(null, "este registra ha sido borrado");
            modelUsuarios.setValues();
            showValues();
        }
    }
    private void guardarcambios() {
        int dialog = JOptionPane.showConfirmDialog(null, "¿Desea guardar los cambios?");
                     String username = viewUsuarios.jtusuario.getText();
        String password = viewUsuarios.jPassword.getText();
        String nombre = viewUsuarios.jtnombre.getText();
          int idusername = Integer.parseInt(viewUsuarios.jTidusername.getText());
    
        int status;
        int statusIndex = viewUsuarios.jComboestado.getSelectedIndex();
        if (statusIndex == 0) {
            status = 1;
        }
        else {
            status = 0;
        }
        
        String level;
        int levelIndex = viewUsuarios.jCombonivel.getSelectedIndex();
        if (levelIndex == 0) {
            level = "gerente";
        }
        else {
            level = "caja";
        }
         
                modelUsuarios.alterRecord(idusername, username, password, status,level,nombre);
                JOptionPane.showMessageDialog(null, "Se han guardado los cambios con éxito");
                modelUsuarios.setValues();
                showValues();
                firstButton();
            
       
    }
    
     public void  leerdatos(){
     viewUsuarios.jtbledetalle.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

         @Override
         
         public void valueChanged(ListSelectionEvent g) {
             
             if(viewUsuarios.jtbledetalle.getSelectedRow() != -1){ 
                 
             int fila=viewUsuarios.jtbledetalle.getSelectedRow() ;
             
             viewUsuarios.jTidusername.setText( viewUsuarios.jtbledetalle.getValueAt(fila, 0).toString());
              viewUsuarios.jtnombre.setText(viewUsuarios.jtbledetalle.getValueAt(fila, 1).toString());
               viewUsuarios.jtusuario.setText(viewUsuarios.jtbledetalle.getValueAt(fila, 2).toString());
               viewUsuarios.jPassword.setText(viewUsuarios.jtbledetalle.getValueAt(fila, 3).toString());
           viewUsuarios.jComboestado.setSelectedItem(viewUsuarios.jtbledetalle.getValueAt(fila, 4));
                viewUsuarios.jCombonivel.setSelectedItem(viewUsuarios.jtbledetalle.getValueAt(fila, 5));
             }
         }
     });
    }
public void buscar(){
    modelUsuarios.busqueda(Integer.parseInt(viewUsuarios.jTbuscar.getText()));
    showValues();    
}
    }


