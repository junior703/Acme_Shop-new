
package controllers;

import models.ModelReportesCompras;
import views.ViewReportesCompras;
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
import views.ViewReportesCompras;
/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class ControllerReportesCompras implements ActionListener {
    DBConnection connection = new DBConnection(3306,"localhost", "acme_shop", "root", "7890");
    ViewReportesCompras view;
    ModelReportesCompras model;
    String nl= System.getProperty("line.separator");
    ModelReportesCompras conn = new ModelReportesCompras();
    Map parametro = new HashMap();//se puede utilizar
    public ControllerReportesCompras(ViewReportesCompras viewReportesCompras, ModelReportesCompras modelReportesCompras) 
    {
        
        this.view = viewReportesCompras;
        this.model = modelReportesCompras;
        view.jBtodo.addActionListener(this);
        view.jBproductos.addActionListener(this);
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
     
      public void solocompras()
    {
        try 
        {
            conn.conectar();
            String di = "C:\\Users\\Azael\\Desktop\\Acme_Shop-new\\src\\reportes\\compras.jrxml";
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
       public void por_provedores()
    {
        try 
        {
            conn.conectar();
            String di = "C:\\Users\\Azael\\Desktop\\Acme_Shop-new\\src\\reportes\\reporteporprovedor.jrxml";
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
          solocompras();
        }
       else if (e.getSource()== view.jBproductos)
       {
           provedor();
       }
        else if (e.getSource() == view.jBuscaC)
        {
           por_provedores();
        }
    }

}
