/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import com.sun.prism.impl.PrismSettings;
import sax.DBConnection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import views.ViewProveedores;
import models.ModelProveedores;

/**
 *
 * @author DRAGKOZ
 */
public class ControllerProveedores implements ActionListener/*, FocusListener*/{
    private final ViewProveedores viewProveedores;
    private final ModelProveedores modelProveedores;
   
   
       
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
        this.viewProveedores.jbtn_saveEdit.addActionListener(this);
        this.viewProveedores.jtf_No.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e){
                char c = e.getKeyChar();
                if(!Character.isDigit(c) && e.getKeyChar()!=8 && e.getKeyChar()!=127){
                    e.consume();
                    JOptionPane.showMessageDialog(null, "Por Favor Solo Ingrese Numeros", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                }else if(viewProveedores.jtf_No.getText().length()==3){
                    e.consume();
                    JOptionPane.showMessageDialog(null, "No Introduzca Mas De 3 Carateres", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        this.viewProveedores.jtf_Telefono.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e){
                char c = e.getKeyChar();
                if(!Character.isDigit(c) && e.getKeyChar()!=8 && e.getKeyChar()!=127){
                    e.consume();
                    JOptionPane.showMessageDialog(null, "Por Favor Solo Ingrese Numeros", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                }else if(viewProveedores.jtf_Telefono.getText().length()==10){
                    e.consume();
                    JOptionPane.showMessageDialog(null, "No Introduzca Mas De 10 Carateres", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        this.viewProveedores.jtf_id.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e){
                char c = e.getKeyChar();
                if(!Character.isDigit(c) && e.getKeyChar()!=8 && e.getKeyChar()!=127){
                    e.consume();
                    JOptionPane.showMessageDialog(null, "Por Favor Solo Ingrese Numeros", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                }else if(viewProveedores.jtf_id.getText().length()==4){
                    e.consume();
                    JOptionPane.showMessageDialog(null, "No Introduzca Mas De 4 Carateres", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
                
        initView();
        firstButton();
        showRecords();
        leertabla();
    }
    private void initView() {
        viewProveedores.setVisible(true);
        modelProveedores.initValues();
        modelProveedores.setValues();
        leertabla();
       
    }
    private void showRecords() {
        viewProveedores.jtble_detalle.setModel(modelProveedores.tableModel);
        modelProveedores.populateTable();
    }
    
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
        viewProveedores.jbtn_guardar.setEnabled(true);
    }
    
    public void guardar(){
        int dialog = JOptionPane.showConfirmDialog(null, "¿Quieres guardar el nuevo registro?");
        if (dialog == 0){
            String nombre = viewProveedores.jtf_Nombre.getText();
            String rfc = viewProveedores.jtf_RFC.getText();
            String calle = viewProveedores.jtf_Calle.getText();
            int no = Integer.parseInt(viewProveedores.jtf_No.getText());
            String colonia = viewProveedores.jtf_Colonia.getText();
            String ciudad = viewProveedores.jtf_Calle.getText();
            String estado = viewProveedores.jtf_Estado.getText();
            String contacto = viewProveedores.jtf_Contacto.getText();
            String telefono = viewProveedores.jtf_Telefono.getText();            
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
            clear();
            viewProveedores.jbtn_guardar.setEnabled(false);
            }
            viewProveedores.jbtn_guardar.setEnabled(false);
        }else{
            viewProveedores.jbtn_guardar.setEnabled(false);
        }
    }
    
    private void deleteRecordButton(){
        int dialog = JOptionPane.showConfirmDialog(null, "¿Desea continuar con la operacion?");
        if(dialog == 0){
            this.modelProveedores.deleteR(Integer.parseInt(viewProveedores.jtf_id.getText()));
            modelProveedores.setValues();
            showValues(); 
            clear();
        }else{
            JOptionPane.showMessageDialog(null, "Ningun Cambio Realizado", "Reply", JOptionPane.PLAIN_MESSAGE);
        }
    }
        
    private void alterRecordButton() {
        int dialog = JOptionPane.showConfirmDialog(null, "¿Desea modificar este registro?");
        viewProveedores.jbtn_saveEdit.setEnabled(true);
    }
        
    private void guardarcambios() {
        int dialog = JOptionPane.showConfirmDialog(null, "¿Desea guardar los cambios?");
        if(dialog == 0){
            int id =Integer.parseInt( viewProveedores.jtf_id.getText());
            String nombre = viewProveedores.jtf_Nombre.getText();
            String rfc = viewProveedores.jtf_RFC.getText();
            String calle = viewProveedores.jtf_Calle.getText(); 
            int no = Integer.parseInt(viewProveedores.jtf_No.getText());
            String colonia = viewProveedores.jtf_Colonia.getText();
            String ciudad = viewProveedores.jtf_Calle.getText();
            String estado = viewProveedores.jtf_Estado.getText();
            String contacto = viewProveedores.jtf_Contacto.getText();
            String telefono = viewProveedores.jtf_Telefono.getText();
            String email = viewProveedores.jtf_EMail.getText();
            modelProveedores.updateD(id, nombre, rfc, calle, no, colonia, ciudad, estado, contacto, telefono, email);
            JOptionPane.showMessageDialog(null, "Se han guardado los cambios con éxito");
            modelProveedores.setValues();
            showValues();
            firstButton();
            viewProveedores.jbtn_saveEdit.setEnabled(false);
            clear();
        }else{
            JOptionPane.showMessageDialog(null, "Ningun Cambio Realizado", "Reply", JOptionPane.PLAIN_MESSAGE);
        }
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
    public void clear(){
        while(modelProveedores.tableModel.getRowCount() >0){
            modelProveedores.tableModel.removeRow(0);
        }
        showRecords();
    }

    /**
     *
     */
    public void buscar(){
        DBConnection connection1 = new DBConnection(3306,"localhost", "acme_shop", "root", "7890");
        
        String c =""+this.viewProveedores.jtf_id.getText();
        
        String sql1 = "SELECT id_proveedor FROM proveedor;";
        connection1.executeQuery(sql1);
        Vector<String> id = new Vector<>(); 
        while(connection1.moveNext()){
             id.add(String.valueOf(connection1.getInteger("id_proveedor")));
        }
        String ids="";
        for(int x=0;x<id.size();x++){
            ids=ids+id.elementAt(x);
        }
        System.out.println(""+ids);
        if(viewProveedores.jtf_id.getText().equals("")){
            JOptionPane.showMessageDialog(null, "por favor ingrese un valor", "ATENCION", JOptionPane.WARNING_MESSAGE);
        }else if(ids.contains(c)){
            DBConnection connection = new DBConnection(3306,"localhost", "acme_shop", "root", "7890");
            String sql = "SELECT * FROM proveedor WHERE id_proveedor = "+c; 
            connection.executeQuery(sql);
            connection.moveNext();
            try {
                if(connection.getString("id_proveedor").isEmpty()){
                    System.out.println("no hay valores");
                }else{
                    viewProveedores.jtf_id.setText(connection.getString("id_proveedor"));
                    viewProveedores.jtf_Nombre.setText(connection.getString("nombre"));
                    viewProveedores.jtf_RFC.setText(connection.getString("rfc"));
                    viewProveedores.jtf_Calle.setText(connection.getString("calle"));    
                    viewProveedores.jtf_No.setText(connection.getString("no"));
                    viewProveedores.jtf_Colonia.setText(connection.getString("colonia"));
                    viewProveedores.jtf_Ciudad.setText(connection.getString("ciudad"));
                    viewProveedores.jtf_Estado.setText(connection.getString("estado"));
                    viewProveedores.jtf_Contacto.setText(connection.getString("nombre_contacto"));
                    viewProveedores.jtf_Telefono.setText(connection.getString("telefono"));
                    viewProveedores.jtf_EMail.setText(connection.getString("email"));
                }
            } catch (Exception e) {

            }
        } else{
            JOptionPane.showMessageDialog(null, "No existe esa compra", "ATENCION", JOptionPane.WARNING_MESSAGE);
        }
        
        
        
        
        
        
       
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewProveedores.jbtn_Fist){
            firstButton();
        }else if (e.getSource() == viewProveedores.jbtn_previus){
            previousButton();
        }else if (e.getSource() == viewProveedores.jbtn_next){
            nextButton();
        }else if (e.getSource() == viewProveedores.jbtn_last){
            lastButton();
        }else if (e.getSource() == viewProveedores.jbtn_agregar){
            aggregar();
        }else if (e.getSource() == viewProveedores.jbtn_guardar){
            guardar();
        }else if (e.getSource() == viewProveedores.jbtn_borrar){
            deleteRecordButton();
        }else if (e.getSource() == viewProveedores.jbtn_saveEdit){
            guardarcambios();
        }else if (e.getSource() == viewProveedores.jbtn_editar){
            alterRecordButton();
        }else if (e.getSource() == viewProveedores.jbtn_buscar){
          buscar();
        } 
    }
    
    public void  leertabla(){
        viewProveedores.jtble_detalle.getSelectionModel().addListSelectionListener((ListSelectionEvent g) -> {
            if(viewProveedores.jtble_detalle.getSelectedRow() != -1){
                int fila=viewProveedores.jtble_detalle.getSelectedRow() ;
                viewProveedores.jtf_id.setText("" + viewProveedores.jtble_detalle.getValueAt(fila, 0).toString());
                viewProveedores.jtf_Nombre.setText("" + viewProveedores.jtble_detalle.getValueAt(fila, 1).toString());
                viewProveedores.jtf_RFC.setText("" + viewProveedores.jtble_detalle.getValueAt(fila, 2).toString());
                viewProveedores.jtf_Calle.setText("" + viewProveedores.jtble_detalle.getValueAt(fila, 3).toString());
                viewProveedores.jtf_No.setText("" + viewProveedores.jtble_detalle.getValueAt(fila, 4).toString());
                viewProveedores.jtf_Colonia.setText("" + viewProveedores.jtble_detalle.getValueAt(fila, 5).toString());
                viewProveedores.jtf_Ciudad.setText("" + viewProveedores.jtble_detalle.getValueAt(fila, 6).toString());
                viewProveedores.jtf_Estado.setText("" + viewProveedores.jtble_detalle.getValueAt(fila, 7).toString());
                viewProveedores.jtf_Contacto.setText("" + viewProveedores.jtble_detalle.getValueAt(fila, 8).toString());
                viewProveedores.jtf_Telefono.setText("" + viewProveedores.jtble_detalle.getValueAt(fila, 9).toString());
                viewProveedores.jtf_EMail.setText("" + viewProveedores.jtble_detalle.getValueAt(fila, 10).toString());
            }
        });
    }

    /*@Override
    public void focusGained(FocusEvent a) {
        
    }

    @Override
    public void focusLost(FocusEvent e) {
        
    }*/
    public void soloNumeros(KeyEvent e){
        char c = e.getKeyChar();
        if(Character.isLetter(c)){
            e.consume();
            JOptionPane.showMessageDialog(null, "Por Favor Solo Ingrese Numeros", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
        }
    }
    
}