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
    
               private static ViewCatalogosClientes viewCatalogosClientes;
    private static ModelCatalogosClientes modelCatalogosClientes;
    private static ControllerCatalogosClientes controllerCatalogosClientes;
    
     private static ViewCatalogosProductos viewCatalogosProductos;
    private static ModelCatalogosProductos  modelCatalogosProductos ;
    private static ControllerCatalogosProductos  controllerCatalogosProductos ;
    
     private static ViewCatalogosProveedores viewCatalogosProveedores;
    private static ModelCatalogosProveedores  modelCatalogosProveedores ;
    private static ControllerCatalogosProveedores  controllerCatalogosProveedores ;
    
    private static ViewAcercaDe viewAcercaDe;
    private static ModelAcercaDe  modelAcercaDe ;
    private static ControllerAcercaDe  controllerAcercaDe ;
    
    private static ViewOperacionesCompras viewOperacionesCompras;
    private static ModelOperacionesCompras  modelOperacionesCompras;
    private static ControllerOperacionesCompras  controllerOperacionesCompras ;
    
    private static ViewOperacionesVentas viewOperacionesVentas;
    private static ModelOperacionesVentas  modelOperacionesVentas;
    private static ControllerOperacionesVentas  controllerOperacionesVentas ;
    
    private static ViewReportesClientes viewReportesClientes;
    private static ModelReportesClientes modelReportesClientes;
    private static ControllerReportesClientes  controllerReportesClientes ;
    
     private static ViewReportesProductos viewReportesProductos;
    private static ModelReportesProductos modelReportesProductos;
    private static ControllerReportesProductos  controllerReportesProductos ;
    
     private static ViewReportesProveedores viewReportesProveedores;
    private static ModelReportesProveedores modelReportesProveedores;
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

  viewCatalogosClientes=new  ViewCatalogosClientes();
        modelCatalogosClientes=new ModelCatalogosClientes();
  controllerCatalogosClientes=new ControllerCatalogosClientes(viewCatalogosClientes,modelCatalogosClientes);////////////////////////
  
  viewCatalogosProductos=new  ViewCatalogosProductos();
        modelCatalogosProductos=new ModelCatalogosProductos();
  controllerCatalogosProductos=new ControllerCatalogosProductos(viewCatalogosProductos,modelCatalogosProductos);////////////////////////
   
  viewCatalogosProveedores=new  ViewCatalogosProveedores();
        modelCatalogosProveedores=new ModelCatalogosProveedores();
  controllerCatalogosProveedores=new ControllerCatalogosProveedores(viewCatalogosProveedores,modelCatalogosProveedores);////////////////////////
    
   viewAcercaDe=new  ViewAcercaDe();
        modelAcercaDe=new ModelAcercaDe();
  controllerAcercaDe=new ControllerAcercaDe(viewAcercaDe,modelAcercaDe);////////////////////////
  
  viewOperacionesCompras=new  ViewOperacionesCompras();
        modelOperacionesCompras=new ModelOperacionesCompras();
  controllerOperacionesCompras=new ControllerOperacionesCompras(viewOperacionesCompras,modelOperacionesCompras);////////////////////////
    
  viewOperacionesVentas=new  ViewOperacionesVentas();
        modelOperacionesVentas=new ModelOperacionesVentas();
  controllerOperacionesVentas=new ControllerOperacionesVentas(viewOperacionesVentas,modelOperacionesVentas);////////////////////////
  
  viewReportesClientes=new  ViewReportesClientes();
        modelReportesClientes=new ModelReportesClientes();
  controllerReportesClientes=new ControllerReportesClientes(viewReportesClientes,modelReportesClientes);////////////////////////
  
     viewReportesProductos=new  ViewReportesProductos();
        modelReportesProductos=new ModelReportesProductos();
  controllerReportesProductos=new ControllerReportesProductos(viewReportesProductos,modelReportesProductos);////////////////////////
  
  viewReportesProveedores=new  ViewReportesProveedores();
        modelReportesProveedores=new ModelReportesProveedores();
  controllerReportesProveedores=new ControllerReportesProveedores(viewReportesProveedores,modelReportesProveedores);////////////////////////
  
  viewReportesCompras=new  ViewReportesCompras();
        modelReportesCompras=new ModelReportesCompras();
  controllerReportesCompras=new ControllerReportesCompras(viewReportesCompras,modelReportesCompras);////////////////////////
  
    viewReportesVentas=new  ViewReportesVentas();
        modelReportesVentas=new ModelReportesVentas();
  controllerReportesVentas=new ControllerReportesVentas(viewReportesVentas,modelReportesVentas);////////////////////////
  
  JPanel views[]=new JPanel[14];  
  views[0]=viewProductosModificacion;   
  views[1]=viewProveedores;
  views[2]=viewCliente;   
  views[3]=viewAcercaDe;
  views[4]=viewCatalogosClientes;   
  views[5]=viewCatalogosProductos;
  views[6]=viewCatalogosProveedores;   
  views[7]=viewOperacionesVentas;
  views[8]=viewOperacionesCompras;   
  views[9]=viewReportesClientes;
  views[10]=viewReportesCompras;   
  views[11]=viewReportesProductos;
  views[12]=viewReportesProveedores;   
  views[13]=viewReportesVentas;


  
   // declarar
 viewMain =new ViewMain();   
    modelMain=new ModelMain();
    controllerMain=new ControllerMain(viewMain,modelMain,views);
 
controllerMain.initView();
    }
     
   
}
