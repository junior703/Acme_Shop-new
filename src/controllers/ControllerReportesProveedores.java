/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import models.ModelReportesProveedores;
import views.ViewReportesProveedores;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import net.sf.jasperreports.engine.util.JRLoader;
import sax.DBConnection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import sax.DBConnection;

/**
 * 
 * @author Azael
 */
public class ControllerReportesProveedores implements ActionListener{
    DBConnection connection = new DBConnection(3306,"localhost", "acme_shop", "root", "7890");
    ViewReportesProveedores view;
    ModelReportesProveedores model;
    String nl= System.getProperty("line.separator");
    ModelReportesProveedores conn = new ModelReportesProveedores();
    Map parametro = new HashMap();//se puede utilizar
    public ControllerReportesProveedores(ViewReportesProveedores viewReportesProveedores, ModelReportesProveedores modelReportesProveedores) 
    {
        this.view = viewReportesProveedores;
        
        this.model = modelReportesProveedores;
        view.jBtodo.addActionListener(this);
        //view.jBproductos.addActionListener(this);
        view.jBuscaC.addActionListener(this);
        clientes();
    }
    public void clientes() 
    {
        view.jCcliente.removeAllItems();
        connection.executeQuery("SELECT nombre FROM proveedor;");
        String obtenido;
        while(connection.moveNext())
        {
            obtenido=connection.getString("nombre");
            view.jCcliente.addItem(obtenido);
        }
    }
    
    public void todos_productos()
    {
        try 
        {
            conn.conectar();
            String di = "C:\\Users\\Azael\\Desktop\\Acme_Shop-new\\src\\reportes\\proveedor.jrxml";
            JasperReport reportJasper =JasperCompileManager.compileReport(di);
            JasperPrint mostrarReporte = JasperFillManager.fillReport(reportJasper, null, conn.getConn());
            JasperViewer.viewReport(mostrarReporte, false);
        }
        catch (Exception e) 
        {
            System.err.printf(e.getMessage());
        }
    }
      public void provedor()
    {
        try 
        {
            conn.conectar();
            parametro.put("name", view.jCcliente.getSelectedItem());
            String di = "C:\\Users\\Azael\\Desktop\\Acme_Shop-new\\src\\reportes\\reporteporprovedor.jrxml";
            JasperReport reportJasper =JasperCompileManager.compileReport(di);
            JasperPrint mostrarReporte = JasperFillManager.fillReport(reportJasper, parametro, conn.getConn());
            JasperViewer.viewReport(mostrarReporte, false);
        }
        catch (Exception e) 
        {
            System.err.printf(e.getMessage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource() == view.jBtodo)
        {
          todos_productos();
        }
        else if (e.getSource() == view.jBuscaC)
        {
            provedor();
        }
    }
}
