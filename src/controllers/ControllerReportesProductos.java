/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import models.ModelReportesProductos;
import views.ViewReportesProductos;
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
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class ControllerReportesProductos implements ActionListener{
        DBConnection connection = new DBConnection(3306,"localhost", "acme_shop", "root", "7890");
    ViewReportesProductos view;
    ModelReportesProductos model;
    String nl= System.getProperty("line.separator");
    ModelReportesProductos conn = new ModelReportesProductos();
    Map parametro = new HashMap();
    public ControllerReportesProductos(ViewReportesProductos viewReportesProductos, ModelReportesProductos modelReportesProductos) 
    {
        this.view = viewReportesProductos;
        
        this.model = modelReportesProductos;
        view.jBtodo.addActionListener(this);
        //view.jBproductos.addActionListener(this);
        view.jBuscaC.addActionListener(this);
        clientes();
    }
    
         public void clientes() 
    {
        view.jCcliente.removeAllItems();
        connection.executeQuery("SELECT producto FROM productos;");
        String obtenido;
        while(connection.moveNext())
        {
            obtenido=connection.getString("producto");
            view.jCcliente.addItem(obtenido);
        }
    }
    
     public void todos_productos()
    {
        try 
        {
            conn.conectar();
            String di = "C:\\Users\\Azael\\Desktop\\Acme_Shop-new\\src\\reportes\\todosproductos.jrxml";
            JasperReport reportJasper =JasperCompileManager.compileReport(di);
            JasperPrint mostrarReporte = JasperFillManager.fillReport(reportJasper, null, conn.getConn());
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
           //por_provedores();
        }
    }

}
