/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.modelArea;
import view.viewArea;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class controlArea   implements ActionListener {
private viewArea ViewArea;
  private modelArea ModelArea;    
    public controlArea(viewArea ViewArea, modelArea ModelArea) {
        this.ViewArea = ViewArea;
        this.ModelArea = ModelArea;
        
         this.ViewArea.jBcubo.addActionListener(this);
          
          this.ViewArea.jBesfera.addActionListener(this);
          this.ViewArea.jBcylindro.addActionListener(this); 
        
    }
  
    
     public void cubo(){
        
        this.ModelArea.setCubo1(Double.parseDouble(ViewArea.jTareaCubo.getText()));
        
      this.ViewArea.jTresultCubo.setText(""+this.ModelArea.cubo());
    }
     public void esfera(){
        
        this.ModelArea.setEsfera1(Double.parseDouble(ViewArea.jTrayoesfera.getText()));
        
      this.ViewArea.jTresultadoesfera.setText(""+this.ModelArea.esfera());
    }
     public void cilindro(){
        
        this.ModelArea.setCylindro1(Double.parseDouble(ViewArea.jTracylindro.getText()));
             this.ModelArea.setCilyndro2(Double.parseDouble(ViewArea.jTalturacylindro.getText()));
             
      this.ViewArea.jTresultadocylindro.setText(""+this.ModelArea.cilindro());
    }
        public void actionPerformed(ActionEvent ae) {
             if (ae.getSource() ==ViewArea.jBcubo){
            cubo();
             }else if(ae.getSource() ==ViewArea.jBcylindro){
       cilindro();
             }else if(ae.getSource() ==ViewArea.jBesfera){
     esfera();
     
    }

}
}