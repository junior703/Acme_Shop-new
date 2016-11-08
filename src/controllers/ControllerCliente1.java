package controllers;

import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import views.ViewCliente;
import models.ModelCliente;

/**
 *
 * @author Azael
 */
public class ControllerCliente1 implements ActionListener 
{
    private final ViewCliente viewCliente;
    private final ModelCliente modelcliente;

    
    public ControllerCliente1 (ViewCliente viewCliente, ModelCliente modelcliente)
    {
        this.modelcliente = modelcliente;
        this.viewCliente = viewCliente;
        this.viewCliente.jBsaveeditar.addActionListener(this);
        this.viewCliente.jBuscar1.addActionListener(this);
        this.viewCliente.jTbuscar.addActionListener(this);
        this.viewCliente.jbagregar.addActionListener(this);
        this.viewCliente.jbanterior.addActionListener(this);
        this.viewCliente.jbborrar.addActionListener(this);
        this.viewCliente.jbeditar.addActionListener(this);
        this.viewCliente.jbguadar.addActionListener(this);
        this.viewCliente.jbprimero.addActionListener(this);
        this.viewCliente.jbsiguiente.addActionListener(this);
        this.viewCliente.jbultimo.addActionListener(this);
        this.viewCliente.jtfCalle.addActionListener(this);
        this.viewCliente.jtfCity.addActionListener(this);
        this.viewCliente.jtfColony.addActionListener(this);
        this.viewCliente.jtfEmail.addActionListener(this);
        this.viewCliente.jtfMatLastName.addActionListener(this);
        this.viewCliente.jtfName1.addActionListener(this);
        this.viewCliente.jtfRFC.addActionListener(this);
        this.viewCliente.jtfPatLastName.addActionListener(this);
        this.viewCliente.jtfState.addActionListener(this);
        this.viewCliente.jtfTelephone.addActionListener(this);
        this.viewCliente.jtfidCliente.addActionListener(this);
        this.viewCliente.jtfno.addActionListener(this);
        
        initView();
        Coneccion();
        
    }
    
    private void initView()
    {
        viewCliente.setVisible(true);
        modelcliente.initValues();
        modelcliente.setValues();
       
    }

    public void Coneccion()
    {
        viewCliente.jtfidCliente.setText(""+modelcliente.getIdcliente());
        viewCliente.jtfName1.setText(modelcliente.getNombre());
        viewCliente.jtfPatLastName.setText(modelcliente.getAp_paterno());
        viewCliente.jtfMatLastName.setText(modelcliente.getAp_materno());
        viewCliente.jtfTelephone.setText(""+modelcliente.getTelefono());
        viewCliente.jtfEmail.setText(modelcliente.getEmail());
        viewCliente.jtfCalle.setText(modelcliente.getCalle());
        viewCliente.jtfRFC.setText(modelcliente.getRfc());
        viewCliente.jtfColony.setText(modelcliente.getColonia());
        viewCliente.jtfCity.setText(modelcliente.getCiudad());
        viewCliente.jtfState.setText(modelcliente.getEstado());                
    }
     
    private void primero() 
    {
        modelcliente.moveFirst();
        modelcliente.setValues();
        Coneccion();
    }
    
    private void anterior() {
        modelcliente.movePrevious();
        modelcliente.setValues();
        Coneccion();
    }
    
    private void siguiente() {
        modelcliente.moveNext();
        modelcliente.setValues();
        Coneccion();
    }
    
    private void ultimo() {
        modelcliente.moveLast();
        modelcliente.setValues();
        Coneccion();
    }
    
    private void agregar() 
    {
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
        
    public void guardar()
    {
        int dialog = JOptionPane.showConfirmDialog(null, "Guardar registro");
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
        
        modelcliente.guardarregistro( nombre,ap_paterno,ap_materno,telefono,email,rfc,calle,numero,colonia,ciudad,estado) ;
        modelcliente.setValues();
        Coneccion();
        primero();
    }
    
    private void borrar()
    {
        this.modelcliente.deleteRecord(Integer.parseInt(viewCliente.jtfidCliente.getText()));
        modelcliente.setValues();
        Coneccion();
    }
    
    private void guardarCambios() 
    {
        int dialog = JOptionPane.showConfirmDialog(null, "Guardar los cambios");
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
        
        modelcliente.alterRecord(idcliente, nombre,ap_paterno,ap_materno,telefono,email,rfc,calle,numero,colonia,ciudad,estado);
        JOptionPane.showMessageDialog(null, "Listo");
        
        modelcliente.setValues();
        Coneccion();
        primero(); 
    }
    
    private void alterRecordButton() 
    {
        int dialog = JOptionPane.showConfirmDialog(null, "¿Desea modificar este registro?");
    }
    
    public void actonPerformed (ActionEvent g)
    {
        if (g.getSource() == viewCliente.jbprimero )
            primero();
        else if (g.getSource() == viewCliente.jbanterior)
            anterior();
        else if (g.getSource() == viewCliente.jbsiguiente)
            siguiente();
        else if (g.getSource() == viewCliente.jbultimo)
            ultimo();
        else if (g.getSource() == viewCliente.jbagregar)
            agregar();
        else if (g.getSource() == viewCliente.jbguadar)
            guardar();
        else if (g.getSource() == viewCliente.jbborrar)
            borrar();
        else if (g.getSource() == viewCliente.jBsaveeditar)
            guardarCambios();
        else if (g.getSource() == viewCliente.jbeditar)
          alterRecordButton();
    }
    
    private void showRecords() 
    {   
        viewCliente.jtbledetalle.setModel(modelcliente.tableModel);
        modelcliente.Tabla();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    
}
