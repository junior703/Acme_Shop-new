

package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.modelVolumen;
import view.viewVolumen;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class controlVolumen  implements ActionListener {
private modelVolumen ModelVolumen;
    private viewVolumen ViewVolumen;    
    
    public controlVolumen(viewVolumen ViewVolumen, modelVolumen ModelVolumen) {
                this.ModelVolumen = ModelVolumen;
        this.ViewVolumen = ViewVolumen;
        
          this.ViewVolumen.jBVcubo.addActionListener(this);
          
          this.ViewVolumen.jBVcylindro.addActionListener(this);
          this.ViewVolumen.jBVesfera.addActionListener(this);
        
        
    }
     public void cubo(){
      /*     this.modelBasicos.setNum1(Double.parseDouble(viewBasicos.jTnumero1.getText()));
        this.modelBasicos.setNum2(Double.parseDouble(viewBasicos.jTnumero2.getText()));
        
         this.viewBasicos.jTresultado.setText(""+this.modelBasicos.suma());*/
        
        this.ModelVolumen.setCubo1(Double.parseDouble(ViewVolumen.jTVareacubo.getText()));
        
      this.ViewVolumen.jTVresultudacubo.setText(""+this.ModelVolumen.cubo());
    }
     public void esfera(){
                this.ModelVolumen.setEsfera1(Double.parseDouble(ViewVolumen.jTVrayoesfera.getText()));
        
      this.ViewVolumen.jTVresultadoesfera.setText(""+this.ModelVolumen.esfrera());
        
    }
     public void cilindro(){
        
        this.ModelVolumen.setCylindro1(Double.parseDouble(ViewVolumen.jTVracylindro.getText()));
             this.ModelVolumen.setCilyndro2(Double.parseDouble(ViewVolumen.jTValturacylindro.getText()));
             
      this.ViewVolumen.jTVresultadocylindro.setText(""+this.ModelVolumen.cilindro());
    }
     
     
        public void actionPerformed(ActionEvent ae) {
             if (ae.getSource() ==ViewVolumen.jBVcubo){
            cubo();
             }else if(ae.getSource() ==ViewVolumen.jBVcylindro){
       cilindro();
             }else if(ae.getSource() ==ViewVolumen.jBVesfera){
     esfera();          
}
}
}