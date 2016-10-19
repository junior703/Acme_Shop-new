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
    
           private static ViewProveedores viewProveedores;
    private static ModelProveedores modelProveedores;
    private static ControllerProveedores controllerProveedores;
    
    
     public static void main(String [] jr){
        
         viewProductosModificacion=new  ViewProductosModificacion();
      modelProductosModificacion=new ModelProductosModificacion();
    controllerProductosModificacion=new ControllerProductosModificacion(viewProductosModificacion,modelProductosModificacion);
    
    
         viewProveedores=new  ViewProveedores();
        modelProveedores=new ModelProveedores();
  controllerProveedores=new ControllerProveedores(viewProveedores,modelProveedores);////////////////////////
    
    JPanel views[]=new JPanel[2];  
  views[0]=viewProductosModificacion;   
  views[1]=viewProveedores;
  
   // declarar
    
    viewMain=new ViewMain();
    modelMain=new ModelMain();
    controllerMain=new ControllerMain(viewMain,modelMain,views);
 
controllerMain.initView();
    }
     
   
}
