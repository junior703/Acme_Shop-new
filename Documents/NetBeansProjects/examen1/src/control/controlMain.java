
package control;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.ViewMain;
import models.modelMain;
import javax.swing.JPanel ;
/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class controlMain implements ActionListener{
 modelMain modelMain;
  ViewMain viewMain;
   JPanel views[];
  

    public controlMain(ViewMain viewMain, modelMain ModelMain, JPanel[] views) {
      this.modelMain = modelMain;
        this.viewMain = viewMain;
        this.views = views;
        
        this.viewMain.jMArea.addActionListener( this);
          this.viewMain.jMvolumen.addActionListener( this);
          initView();
    }
 public void actionPerformed(ActionEvent ae) {
        if(ae.getSource ()==viewMain.jMArea){
jmivolumen();
   
    }else if (ae.getSource ()==viewMain.jMvolumen){
      jmiArea();
    }
 }
    public void jmivolumen(){
        this.viewMain.setContentPane(views[0]);
        this.viewMain.revalidate();
        this.viewMain.repaint();
    }
       public void jmiArea(){
        this.viewMain.setContentPane(views[1]);
        this.viewMain.revalidate();
        this.viewMain.repaint();

    }
     public void initView(){
        this.viewMain.setTitle("Programa");
        this.viewMain.setLocationRelativeTo(null);
        this.viewMain.setVisible(true);
   }

}
