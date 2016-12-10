/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main;
import  views.*;
import models.*;
import controllers.*;
import javax.swing.JPanel;
/**
 * 
 * @author Karla
 */
public class Main {

    private static ViewMain viewMain;
    private static ModelMain modelMain;
    private static ControllerMain controllerMain;
 
    private static ViewProductosModificacion viewProductosModificacion;
    private static  ModelProductosModificacion modelProductosModificacion;
    private static  ControllerProductosModificacion controllerProductosModificacion;
           
    private static ViewCliente viewCliente ;
    private static  ModelCliente  modelCliente;
    private static  ControllerCliente controllerCliente;

    private static ViewProveedores viewProveedores;
    private static ModelProveedores modelProveedores;
    private static ControllerProveedores controllerProveedores;
    ///********************************************************************//
    
    private static ViewIniciarSeccion viewIniciarSeccion;
    private static ModelIniciarSeccion modelIniciarSeccion;
    private static ControllerIniciarSeccion controllerIniciarSeccion;
    
    private static ViewUsuarios viewUsuarios;
    private static ModelUsuarios  modelUsuarios ;
    private static ControllerUsuarios  controllerUsuarios ;
      ///********************************************************************//
    
    private static ViewAcercaDe viewAcercaDe;
    private static ModelAcercaDe  modelAcercaDe ;
    private static ControllerAcercaDe  controllerAcercaDe ;
      ///********************************************************************//
    
    private static ViewOperacionesCompras viewOperacionesCompras;
    private static ModelOperacionesCompras  modelOperacionesCompras;
    private static ControllerOperacionesCompras  controllerOperacionesCompras ;
    
    private static ViewOperacionesVentas viewOperacionesVentas;
    private static ModelOperacionesVentas  modelOperacionesVentas;
    private static ControllerOperacionesVentas  controllerOperacionesVentas ;
      ///********************************************************************//
    
    private static ViewReportesClientes viewReportesClientes;
    private static ModelReportesClientes modelmainClientes;
    private static ControllerReportesClientes  controllerReportesClientes ;
    
     private static ViewReportesProductos viewReportesProductos;
    private static ModelMain modelmainProductos;
    private static ControllerReportesProductos  controllerReportesProductos ;
    
     private static ViewReportesProveedores viewReportesProveedores;
    private static ModelReportesCompras modelReportesProveedores;
    private static ControllerReportesProveedores  controllerReportesProveedores ;
    
     private static ViewReportesVentas viewReportesVentas;
    private static ModelReportesVentas modelReportesVentas;
   private static ControllerReportesVentas  controllerReportesVentas ;
    
     private static ViewReportesCompras viewReportesCompras;
    private static ModelReportesCompras modelReportesCompras;
    private static ControllerReportesCompras  controllerReportesCompras ;
    
    
    
     public static void main(String [] jr){
        
         viewProductosModificacion=new  ViewProductosModificacion();
      modelProductosModificacion=new ModelProductosModificacion();
    controllerProductosModificacion=new ControllerProductosModificacion(viewProductosModificacion,modelProductosModificacion);////////////////////////////
    
  
         viewCliente=new  ViewCliente();
               modelCliente=new ModelCliente();
         controllerCliente=new ControllerCliente(viewCliente,modelCliente);////////////////////////
    
                viewProveedores=new  ViewProveedores();
               modelProveedores=new ModelProveedores();
         controllerProveedores=new ControllerProveedores(viewProveedores,modelProveedores);////////////////////////

         
         viewMain=new ViewMain();
  viewIniciarSeccion=new  ViewIniciarSeccion();
       modelIniciarSeccion=new ModelIniciarSeccion();
  controllerIniciarSeccion=new ControllerIniciarSeccion(viewIniciarSeccion,modelIniciarSeccion,viewMain,viewUsuarios);////////////////////////
  
   
  viewUsuarios=new  ViewUsuarios();
        modelUsuarios=new ModelUsuarios();
  controllerUsuarios=new ControllerUsuarios(viewUsuarios,modelUsuarios);////////////////////////
    
   viewAcercaDe=new  ViewAcercaDe();
        modelAcercaDe=new ModelAcercaDe();
  controllerAcercaDe=new ControllerAcercaDe(viewAcercaDe,modelAcercaDe);////////////////////////
  
  viewOperacionesCompras=new  ViewOperacionesCompras();
        modelOperacionesCompras=new ModelOperacionesCompras();
  controllerOperacionesCompras=new ControllerOperacionesCompras(viewOperacionesCompras,modelOperacionesCompras);////////////////////////
    
        modelIniciarSeccion=new ModelIniciarSeccion();
        viewOperacionesVentas=new  ViewOperacionesVentas();
        modelOperacionesVentas=new ModelOperacionesVentas();
        controllerOperacionesVentas=new ControllerOperacionesVentas(viewOperacionesVentas,modelOperacionesVentas,modelIniciarSeccion);////////////////////////
  
        viewReportesClientes=new  ViewReportesClientes();
        //modelReportesClientes=new ModelReporteClientes();
        //controllerReportesClientes=new ControllerReportesClientes(viewReportesClientes,modelReportesClientes);////////////////////////
  
        viewReportesProductos=new  ViewReportesProductos();
        //modelReportesProductos=new ModelReporteProductos();
       // controllerReportesProductos=new ControllerReportesProductos(viewReportesProductos,modelReportesProductos);////////////////////////
  
        viewReportesProveedores=new  ViewReportesProveedores();
       // modelReportesProveedores=new ModelReportesProveedores();
       // controllerReportesProveedores=new ControllerReportesProveedores(viewReportesProveedores,modelReportesProveedores);////////////////////////
  
        viewReportesCompras=new  ViewReportesCompras();
       // modelReportesCompras=new ModelReportesCompras();
     //   controllerReportesCompras=new ControllerReportesCompras(viewReportesCompras,modelReportesCompras);////////////////////////
  
        viewReportesVentas=new  ViewReportesVentas();
        //modelReportesVentas=new ModelReportesVentas();
       // controllerReportesVentas=new ControllerReportesVentas(viewReportesVentas,modelReportesVentas);////////////////////////
  
  
  JPanel views[]=new JPanel[13];  
  views[0]=viewProductosModificacion;   
  views[1]=viewProveedores;
  views[2]=viewCliente;   
  views[3]=viewAcercaDe;
  views[4]=viewIniciarSeccion;   
  views[5]=viewUsuarios; 
  views[6]=viewOperacionesVentas;
  views[7]=viewOperacionesCompras;   
  views[8]=viewReportesClientes;
  views[9]=viewReportesCompras;   
  views[10]=viewReportesProductos;
  views[11]=viewReportesProveedores;   
  views[12]=viewReportesVentas;
  //en desarrollo-----------------------------------start
int widht[]= new int[13];
  widht[0]=viewProductosModificacion.getWidth();   
  widht[1]=viewProveedores.proveedores.getWidth();
  widht[2]=viewCliente.getWidth();   
  widht[3]=viewAcercaDe.getWidth();
  widht[4]=viewIniciarSeccion.iniSecion.getWidth();   
  widht[5]=viewUsuarios.getWidth(); 
  widht[6]=viewOperacionesVentas.getWidth();
  widht[7]=viewOperacionesCompras.getWidth();   
  widht[8]=viewReportesClientes.getWidth();
  widht[9]=viewReportesCompras.getWidth();   
  widht[10]=viewReportesProductos.getWidth();
  widht[11]=viewReportesProveedores.getWidth();   
  widht[12]=viewReportesVentas.getWidth();
int height[]= new int[13];
height[0]=viewProductosModificacion.getHeight();   
  height[1]=viewProveedores.proveedores.getHeight();
  height[2]=viewCliente.getHeight();   
  height[3]=viewAcercaDe.getHeight();
  height[4]=viewIniciarSeccion.iniSecion.getHeight();   
  height[5]=viewUsuarios.getHeight(); 
  height[6]=viewOperacionesVentas.getHeight();
  height[7]=viewOperacionesCompras.getHeight();   
  height[8]=viewReportesClientes.getHeight();
  height[9]=viewReportesCompras.getHeight();   
  height[10]=viewReportesProductos.getHeight();
  height[11]=viewReportesProveedores.getHeight();   
  height[12]=viewReportesVentas.getHeight();
  //-----------------------------------------------end
   // declarar
 //viewMain =new ViewMain();   
    modelMain=new ModelMain();
    controllerMain=new ControllerMain(viewMain, modelMain, views, widht, height);
    
controllerMain.initView();
    }
     
   
}
