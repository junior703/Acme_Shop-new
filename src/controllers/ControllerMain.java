/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import views.ViewMain;
import models.ModelMain;

/**
 * 
 * @author Bnc
 */
public class ControllerMain  implements ActionListener {
ViewMain viewmain;
ModelMain modelmain;
   JPanel views[];
   
    public ControllerMain(ViewMain viewmain, ModelMain modelmain, JPanel[] views) {
        this.viewmain = viewmain;
        this.modelmain = modelmain;
        this.views = views;
        
         this.viewmain.jMclientes.addActionListener( this);
          this.viewmain.jMprovedores.addActionListener( this);
                this.viewmain.jMproductos.addActionListener( this);
          initView();
    }
    
public void actionPerformed(ActionEvent ae) {
    
        if(ae.getSource ()==viewmain.jMprovedores){
jmiProvedores(); 
      
    }else if (ae.getSource ()==viewmain.jMproductos){
      jmiProductos();
    }
 }
       
             public void jmiProvedores(){
        this.viewmain.setContentPane(views[1]);
        this.viewmain.revalidate();
        this.viewmain.repaint();

    }
       public void jmiProductos(){
        this.viewmain.setContentPane(views[0]);
        this.viewmain.revalidate();
        this.viewmain.repaint();

    }
     public void initView(){
        this.viewmain.setTitle("Acme Shop");
        this.viewmain.setLocationRelativeTo(null);
        this.viewmain.setVisible(true);
   }

   

    
}

