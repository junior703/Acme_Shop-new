/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

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
import models.ModelReportesClientes;
import sax.DBConnection;
import views.ViewReportesClientes;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class ControllerReportesClientes implements ActionListener 
{
    DBConnection connection = new DBConnection(3306,"localhost", "acme_shop", "root", "7890");
    ViewReportesClientes view;
    ModelReportesClientes model;
    String nl= System.getProperty("line.separator");
    ModelReportesClientes conn = new ModelReportesClientes();
    Map parametro = new HashMap();//se puede utilizar


    public ControllerReportesClientes(ViewReportesClientes view, ModelReportesClientes modelReportesClientes) 
    {

        this.view = view;
        this.model = model;
        view.jBtodo.addActionListener(this);
       // view.jBproductos.addActionListener(this);
        view.jBuscaC.addActionListener(this);
    //    initView();
        clientes();
    }
    
        
        public void clientes() 
    {
        view.jCcliente.removeAllItems();
        connection.executeQuery("SELECT nombre FROM clientes;");
        String obtenido;
        while(connection.moveNext())
        {
            obtenido=connection.getString("nombre");
            view.jCcliente.addItem(obtenido);
        }
    }
        
         public void todo_clientes()
    {
        try 
        {
            conn.conectar();
            String di = "C:\\Users\\Azael\\Desktop\\Acme_Shop-new\\src\\reportes\\todocliente.jrxml";
            JasperReport reportJasper =JasperCompileManager.compileReport(di);
            JasperPrint mostrarReporte = JasperFillManager.fillReport(reportJasper, null, conn.getConn());
            JasperViewer.viewReport(mostrarReporte, false);
        }
        catch (Exception e) 
        {
            System.err.printf(e.getMessage());
        }
    }
         
         
  public void por_cliente()
    {
        try 
        {
            conn.conectar();
            String di = "C:\\Users\\Azael\\Desktop\\Acme_Shop-new\\src\\reportes\\cliente.jrxml";
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
          todo_clientes();
        }

        else if (e.getSource() == view.jBuscaC)
        {
           por_cliente();
        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   

  /*  public void initView()
    {
        this.view.setTitle("Juegos en Java");
        this.view.setLocationRelativeTo(null);
        this.view.setVisible(true);
    }
    */
   
    
    
   
 
    }
