/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
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
//variables valor de los JPane
   int width1[];
   int height1[];
   
    public ControllerMain(ViewMain viewmain, ModelMain modelmain, JPanel[] views, int widht[], int height[]) {
        this.viewmain = viewmain;
        this.modelmain = modelmain;
        this.views = views;
        this.width1 = widht;
        this.height1 = height;
        
         this.viewmain.jMclientes.addActionListener( this);
          this.viewmain.jMprovedores.addActionListener( this);
                 this.viewmain.jMproductos.addActionListener( this);
                 
                this.viewmain.jMacercade.addActionListener( this);
                
                  this.viewmain.jmusuario.addActionListener(this);
                  this.viewmain.jMiniciarsecion.addActionListener(this);
                
                this.viewmain.jMoperacionVentas.addActionListener( this);             
          this.viewmain.jMoperacionesCompras.addActionListener( this);
          
                this.viewmain.jMreportesClientes.addActionListener( this);
                   this.viewmain.jMreportesCompras.addActionListener( this);
          this.viewmain.jMreportesProductos.addActionListener( this);
                this.viewmain.jMreportesProveedores.addActionListener( this);
            this.viewmain.jMreportesVentas.addActionListener( this);
               this.viewmain.jMsalir.addActionListener( this);
                
           
          initView();
    }
    
public void actionPerformed(ActionEvent ae) {
    
        if(ae.getSource ()==viewmain.jMprovedores){
jmiProvedores(); 
      
    }else if (ae.getSource ()==viewmain.jMproductos){
      jmiProductos();
    }
      else if (ae.getSource ()==viewmain.jMclientes){
          jMclientes();
   } else if (ae.getSource ()==viewmain.jMacercade){
       jMacercade();
   } else if (ae.getSource ()==viewmain.jMiniciarsecion){
       jMiniciarsecion();
   } else if (ae.getSource ()==viewmain.jmusuario){
       jmusuario();
   }else if (ae.getSource ()==viewmain.jMoperacionVentas){
       jMoperacionVentas();
   }else if (ae.getSource ()==viewmain.jMoperacionesCompras){
       jMoperacionesCompras();
   }else if (ae.getSource ()==viewmain.jMreportesClientes){
       jMreportesClientes();
   }else if (ae.getSource ()==viewmain.jMreportesCompras){
       jMreportesCompras();
   }else if (ae.getSource ()==viewmain.jMreportesProductos){
       jMreportesProductos();
   }else if (ae.getSource ()==viewmain.jMreportesProveedores){
       jMreportesProveedores();
   }else if (ae.getSource ()==viewmain.jMreportesVentas){
       jMreportesVentas();
   }else if (ae.getSource ()==viewmain.jMsalir){
        int dialog = JOptionPane.showConfirmDialog(null, "Seguro que quiere dejar la aplicacion?");
        if (dialog == 0) {
            System.exit(dialog);
        
    }
   }
 }

       public void jmiProductos(){
        this.viewmain.setContentPane(views[0]);
        this.viewmain.revalidate();
        this.viewmain.repaint();
       }
          public void jmiProvedores(){
        this.viewmain.setContentPane(views[1]);
        this.viewmain.revalidate();
        this.viewmain.repaint();
        this.viewmain.resize(width1[1], height1[1]+50);
        this.viewmain.setLocationRelativeTo(null);
        

    }
         public void jMclientes(){
        this.viewmain.setContentPane(views[2]);
        this.viewmain.revalidate();
        this.viewmain.repaint();
    }
          public void jMacercade(){
        this.viewmain.setContentPane(views[3]);
        this.viewmain.revalidate();
        this.viewmain.repaint();
        
    }
           public void jMiniciarsecion(){
        this.viewmain.setContentPane(views[4]);
        this.viewmain.repaint();
        this.viewmain.revalidate();
        this.viewmain.resize(width1[4], height1[4]*2);
        this.viewmain.setLocationRelativeTo(null);
    }
            public void jmusuario(){
        this.viewmain.setContentPane(views[5]);
        this.viewmain.repaint();
        this.viewmain.revalidate();
        this.viewmain.setLocationRelativeTo(null);
       
    }
             
              public void jMoperacionVentas(){
        this.viewmain.setContentPane(views[6]);
        this.viewmain.revalidate();
        this.viewmain.repaint();
    }
               public void jMoperacionesCompras(){
        this.viewmain.setContentPane(views[7]);
        this.viewmain.revalidate();
        this.viewmain.repaint();
    }
                public void jMreportesClientes(){
        this.viewmain.setContentPane(views[8]);
        this.viewmain.revalidate();
        this.viewmain.repaint();
    }
                 public void jMreportesCompras(){
        this.viewmain.setContentPane(views[9]);
        this.viewmain.revalidate();
        this.viewmain.repaint();
    }
                  public void jMreportesProductos(){
        this.viewmain.setContentPane(views[10]);
        this.viewmain.revalidate();
        this.viewmain.repaint();
    }
    public void jMreportesProveedores(){
        this.viewmain.setContentPane(views[11]);
        this.viewmain.revalidate();
        this.viewmain.repaint();
        this.viewmain.setLocationRelativeTo(null);
    }
                    public void jMreportesVentas(){
        this.viewmain.setContentPane(views[12]);
        this.viewmain.revalidate();
        this.viewmain.repaint();
    }
     public void initView(){
        this.viewmain.setTitle("Acme Shop");
        this.viewmain.setLocationRelativeTo(null);
        this.viewmain.setVisible(true);
   }

   

    
}

