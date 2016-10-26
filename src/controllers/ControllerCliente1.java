package controllers;

import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import Views.ViewCliente;
import Models.ModelCliente;
import Views.ViewClienteDetalle;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JPanel;

/**
 *
 * @author Azael
 */
public class ControllerCliente1 implements ActionListener 
{
    private final ViewCliente viewCliente;
    private final ModelCliente modelcliente;
    private Connection c;
    private Statement s;
    private ResultSet r;
    
    public ControllerCliente1 (ViewCliente viewCliente, ModelCliente modelcliente)
    {
        this.modelcliente = modelcliente;
        this.viewCliente = viewCliente;
        this.viewCliente.jB1.addActionListener(this);
        this.viewCliente.jB2.addActionListener(this);
        this.viewCliente.jB3.addActionListener(this);
        this.viewCliente.jB4.addActionListener(this);
        this.viewCliente.jBagregar.addActionListener(this);
        this.viewCliente.jBborrar.addActionListener(this);
        this.viewCliente.jBeditar.addActionListener(this);
        this.viewCliente.jBguadar.addActionListener(this);
        this.viewCliente.jTapellidomat.addActionListener(this);
        this.viewCliente.jTapellidopat.addActionListener(this);
        this.viewCliente.jTcalle.addActionListener(this);
        this.viewCliente.jTciudad.addActionListener(this);
        this.viewCliente.jTcolonia.addActionListener(this);
        this.viewCliente.jTemail.addActionListener(this);
        this.viewCliente.jTestado.addActionListener(this);
        this.viewCliente.jTnombre.addActionListener(this);
        this.viewCliente.jTnum.addActionListener(this);
        this.viewCliente.jTrfc.addActionListener(this);
        this.viewCliente.jTtelefono.addActionListener(this);
        Coneccion();
        
    }

    public ControllerCliente1() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ControllerCliente1(ViewCliente viewcliente, ViewClienteDetalle viewclientd, ModelCliente modelclient, JPanel[] Views) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void Coneccion()
    {
        //c = DriverManager.getConnection("jdbc:mysql://localhost/Store", "root", "7890");
        s = c.createStatement();
        r = s.executeQuery("Select * from Clientes");
        r.next();
        viewCliente.jTnombre.setText(r.getString ("Nombre"));
        viewCliente.jTapellidopat.setText(r.getString("Apellido pat"));
        viewCliente.jTapellidomat.setText(r.getString ("Apellido mat"));
        viewCliente.jTtelefono.setText(r.getString("Telefono"));
        viewCliente.jTemail.setText(r.getString("E-mail"));
        viewCliente.jTcalle.setText(r.getString("Calle"));
        viewCliente.jTrfc.setText(r.getString("RFC"));
        viewCliente.jTcolonia.setText(r.getNString("Colonia"));
        viewCliente.jTciudad.setText(r.getString("Ciudad"));
        viewCliente.jTestado.setText(r.getString("Estado"));                
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    
}
