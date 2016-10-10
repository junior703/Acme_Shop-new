/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import  view.*;
import models.*;
import control.*;
import javax.swing.JPanel;
//import jpanel************
/**
 * 
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Main {
    
    private static ViewMain viewMain;
    private static modelMain ModelMain;
    private static controlMain ControlMain;
 
   private static viewArea  ViewArea;
   private static modelArea ModelArea;
   private static controlArea ControlArea;
 
       private static viewVolumen ViewVolumen;
    private static modelVolumen ModelVolumen;
    private static controlVolumen ControlVolumen;
    
    
    public static void main(String [] jr){
        
        ViewArea=new viewArea();
        ModelArea=new modelArea();
        ControlArea=new controlArea(ViewArea,ModelArea);
        
        ViewVolumen=new  viewVolumen();
        ModelVolumen=new modelVolumen();
    ControlVolumen=new controlVolumen(ViewVolumen,ModelVolumen);
   
   
            
    JPanel views[]=new JPanel[2];  
  views[0]=ViewVolumen;   
  views[1]=ViewArea;
  
   // declarar
    
    viewMain=new ViewMain();
    ModelMain=new modelMain();
    ControlMain=new controlMain(viewMain,ModelMain,views);
 
ControlMain.initView();
    }

    }
