/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import views.ViewProveedores;
import models.ModelProveedores;
/**
 *
 * @author DRAGKOZ
 */
public class ControllerProveedores implements ActionListener{
    private final ViewProveedores viewProveedores;
    private final ModelProveedores modelProveedores;
    private Connection conexion;
    private Statement st;
    private ResultSet rs;
    
    public ControllerProveedores(ViewProveedores viewProveedores, ModelProveedores modelProveedores){
        this.modelProveedores = modelProveedores;
        this.viewProveedores = viewProveedores;
        this.viewProveedores.jbtn_Clean.addActionListener(this);
        this.viewProveedores.jbtn_search.addActionListener(this);
        this.viewProveedores.jbtn_Save.addActionListener(this);
        this.viewProveedores.jbtn_Delete.addActionListener(this);
        this.viewProveedores.jbtn_Fist.addActionListener(this);
        this.viewProveedores.jbtn_previus.addActionListener(this);
        this.viewProveedores.jbtn_next.addActionListener(this);
        this.viewProveedores.jbtn_last.addActionListener(this);
        Conectar();
    }

    public void Conectar() {
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/acme_shop", "root", "8875");
            st = conexion.createStatement();

            rs = st.executeQuery("Select * from proveedor");

            rs.next();
            viewProveedores.jtf_Nombre.setText(rs.getString("nombre"));
            viewProveedores.jtf_RFC.setText(rs.getString("rfc"));
            viewProveedores.jtf_Calle.setText(rs.getString("calle"));
            viewProveedores.jtf_No.setText(rs.getString("no"));
            viewProveedores.jtf_Colonia.setText(rs.getString("colonia"));
            viewProveedores.jtf_Ciudad.setText(rs.getString("ciudad"));
            viewProveedores.jtf_Estado.setText(rs.getString("estado"));
            viewProveedores.jtf_Contacto.setText(rs.getString("nombe_contacto"));
            viewProveedores.jtf_Telefono.setText(rs.getString("telefono"));
            viewProveedores.jtf_EMail.setText(rs.getString("email"));
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error" + err.getMessage());
        }
    }

    
    
    
    
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
