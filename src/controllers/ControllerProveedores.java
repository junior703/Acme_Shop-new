/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
//import sax.DBConnection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import views.ViewProveedores;
import models.ModelProveedores;
import views.ViewProductosModificacion;
/**
 *
 * @author DRAGKOZ
 */
public class ControllerProveedores implements ActionListener{
    private final ViewProveedores viewProveedores;
    private final ModelProveedores modelProveedores;
   
     //  private DBConnection connection = new DBConnection(3306,"localhost", "acme_shop", "root", "7890");
       
    public ControllerProveedores(ViewProveedores viewProveedores, ModelProveedores modelProveedores){
        this.modelProveedores = modelProveedores;
        this.viewProveedores = viewProveedores;
        this.viewProveedores.jbtn_agregar.addActionListener(this);
        this.viewProveedores.jbtn_borrar.addActionListener(this);
        this.viewProveedores.jbtn_guardar.addActionListener(this);
        this.viewProveedores.jbtn_editar.addActionListener(this);
        this.viewProveedores.jbtn_Fist.addActionListener(this);
        this.viewProveedores.jbtn_previus.addActionListener(this);
        this.viewProveedores.jbtn_next.addActionListener(this);
        this.viewProveedores.jbtn_last.addActionListener(this);
        this.viewProveedores.jbtn_buscar.addActionListener(this);
        //showRecords();
    }
    
    /*private void showRecords() {
        viewProveedores.jtbledetalle.setModel(modelProductosModificacion.tableModel);
        modelProductosModificacion.populateTable();
    }*/
    
    private void firstButton() {
        modelProveedores.moveFirst();
        modelProveedores.setValues();
        showValues();
    }
    
    private void previousButton() {
        modelProveedores.movePrevious();
        modelProveedores.setValues();
        showValues();
    }
    
    private void nextButton() {
        modelProveedores.moveNext();
        modelProveedores.setValues();
        showValues();
    }
    
    private void lastButton() {
        modelProveedores.moveLast();
        modelProveedores.setValues();
        showValues();
    }
      
    private void aggregar() {       
        viewProveedores.jtf_id.setText("");
        viewProveedores.jtf_Nombre.setText("");
        viewProveedores.jtf_RFC.setText("");
        viewProveedores.jtf_Calle.setText("");
        viewProveedores.jtf_No.setText("");
        viewProveedores.jtf_Colonia.setText("");
        viewProveedores.jtf_Ciudad.setText("");
        viewProveedores.jtf_Estado.setText("");
        viewProveedores.jtf_Contacto.setText("");
        viewProveedores.jtf_Telefono.setText("");
        viewProveedores.jtf_EMail.setText("");
    }
    
    public void guardar(){
        int dialog = JOptionPane.showConfirmDialog(null, "¿Quieres guardar el nuevo registro?");
        if (dialog == 0){
            String nombre = viewProveedores.jtf_Nombre.getText();
            String rfc = viewProveedores.jtf_RFC.getText();
            String calle = viewProveedores.jtf_Calle.getText();
            int no = (int) viewProveedores.jtf_No.getValue();
            String colonia = viewProveedores.jtf_Colonia.getText();
            String ciudad = viewProveedores.jtf_Calle.getText();
            String estado = viewProveedores.jtf_Estado.getText();
            String contacto = viewProveedores.jtf_Contacto.getText();
            int telefono = Integer.parseInt(viewProveedores.jtf_Telefono.getText());
            String email = viewProveedores.jtf_EMail.getText();
            if (viewProveedores.jtf_Nombre.getText().isEmpty() || viewProveedores.jtf_RFC.getText().isEmpty() || viewProveedores.jtf_Calle.getText().isEmpty()
                || viewProveedores.jtf_No.getText().isEmpty() || viewProveedores.jtf_Colonia.getText().isEmpty() || viewProveedores.jtf_Ciudad.getText().isEmpty()
                || viewProveedores.jtf_Estado.getText().isEmpty() || viewProveedores.jtf_Contacto.getText().isEmpty() || viewProveedores.jtf_Telefono.getText().isEmpty() 
                || viewProveedores.jtf_EMail.getText().isEmpty()){
            }else{
            modelProveedores.saveR(nombre, rfc, calle, no, colonia, ciudad, estado, contacto, telefono, email);
            modelProveedores.setValues();
            showValues();
            firstButton();
            }
        }
    }
    
    private void deleteRecordButton(){
        this.modelProveedores.deleteR(Integer.parseInt(viewProveedores.jtf_id.getText()));
        modelProveedores.setValues();
        showValues();
    }
        
    private void alterRecordButton() {
        int dialog = JOptionPane.showConfirmDialog(null, "¿Desea modificar este registro?");
    }
        
    private void guardarcambios() {
        int dialog = JOptionPane.showConfirmDialog(null, "¿Desea guardar los cambios?");
        int id =Integer.parseInt( viewProveedores.jtf_id.getText());
        String nombre = viewProveedores.jtf_Nombre.getText();
        String rfc = viewProveedores.jtf_RFC.getText();
        String calle = viewProveedores.jtf_Calle.getText(); 
        int no = (int) viewProveedores.jtf_No.getValue(); 
        String colonia = viewProveedores.jtf_Colonia.getText();
        String ciudad = viewProveedores.jtf_Calle.getText();
        String estado = viewProveedores.jtf_Estado.getText();
        String contacto = viewProveedores.jtf_Contacto.getText();
        int telefono = Integer.parseInt(viewProveedores.jtf_Telefono.getText());
        String email = viewProveedores.jtf_EMail.getText();
        modelProveedores.updateD(id, nombre, rfc, calle, no, colonia, ciudad, estado, contacto, telefono, email);
        JOptionPane.showMessageDialog(null, "Se han guardado los cambios con éxito");
        modelProveedores.setValues();
        showValues();
        firstButton();
    }
    
    
    private void showValues() {
        viewProveedores.jtf_id.setText("" + modelProveedores.getId_proveedor());
        viewProveedores.jtf_Nombre.setText(modelProveedores.getNombre());
        viewProveedores.jtf_RFC.setText(modelProveedores.getRfc());
        viewProveedores.jtf_Calle.setText(""+modelProveedores.getCalle());    
        viewProveedores.jtf_No.setText(""+modelProveedores.getNo());
        viewProveedores.jtf_Colonia.setText(""+modelProveedores.getColonia());
        viewProveedores.jtf_Ciudad.setText(""+modelProveedores.getCiudad());
        viewProveedores.jtf_Estado.setText(""+modelProveedores.getEstado());
        viewProveedores.jtf_Contacto.setText(""+modelProveedores.getContacto());
        viewProveedores.jtf_Telefono.setText(""+modelProveedores.getTelefono());
        viewProveedores.jtf_EMail.setText(""+modelProveedores.getEmail());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewProveedores.jbtn_Fist){
            firstButton();
        }
        else if (e.getSource() == viewProveedores.jbtn_previus){
            previousButton();
        }
        else if (e.getSource() == viewProveedores.jbtn_next){
            nextButton();
        }
        else if (e.getSource() == viewProveedores.jbtn_last){
            lastButton();
        }
        else if (e.getSource() == viewProveedores.jbtn_agregar){
            aggregar();
        }else if (e.getSource() == viewProveedores.jbtn_guardar){
            guardar();
        }else if (e.getSource() == viewProveedores.jbtn_borrar){
            deleteRecordButton();
        }  else if (e.getSource() == viewProveedores.jbtn_agregar){
          guardarcambios();//alterRecordButton();
        } else if (e.getSource() == viewProveedores.jbtn_editar){
          alterRecordButton();
        } 
    }
    
    
}
