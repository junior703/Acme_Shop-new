package controllers;

import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import views.ViewCliente;
import models.ModelCliente;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JPanel;
import sax.DBConnection;

/**
 *
 * @author Azael
 */
public class ControllerCliente1 implements ActionListener 
{
    private final ViewCliente viewCliente;
    private final ModelCliente modelcliente;
    public DBConnection connection = new DBConnection(3306,"sql9.freemysqlhosting.net", "sql9141835", "sql9141835", "MwVLnwnFfK");
    private Statement s;
    private ResultSet r;
    
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
        
        Coneccion();
        
    }


    public void Coneccion()
    {
        
        s = c.createStatement();
        r = s.executeQuery("Select * from Clientes");
        r.next();
        viewCliente.jtfName1.setText(r.getString ("Nombre"));
        viewCliente.jtfPatLastName.setText(r.getString("Apellido pat"));
        viewCliente.jtfMatLastName.setText(r.getString ("Apellido mat"));
        viewCliente.jtfTelephone.setText(r.getString("Telefono"));
        viewCliente.jtfEmail.setText(r.getString("E-mail"));
        viewCliente.jtfCalle.setText(r.getString("Calle"));
        viewCliente.jtfRFC.setText(r.getString("RFC"));
        viewCliente.jtfColony.setText(r.getNString("Colonia"));
        viewCliente.jtfCity.setText(r.getString("Ciudad"));
        viewCliente.jtfState.setText(r.getString("Estado"));                
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    
}
