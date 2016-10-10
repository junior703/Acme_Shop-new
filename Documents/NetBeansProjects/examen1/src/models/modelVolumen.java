/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class modelVolumen {
  private double cubo1=0.0;
         private double resultadocubo=0.0;
         
           private double esfera1=0.0;
         private double resultadoesfera=0.0;
         
                 private double cylindro1=0.0;
                 private double cilyndro2=0.0;
                 private double resultadocylindro=0.0;

    /**
     * @return the cubo1
     */
    public double getCubo1() {
        return cubo1;
    }

    /**
     * @param cubo1 the cubo1 to set
     */
    public void setCubo1(double cubo1) {
        this.cubo1 = cubo1;
    }

    /**
     * @return the resultadocubo
     */
    public double getResultadocubo() {
        return resultadocubo;
    }

    /**
     * @param resultadocubo the resultadocubo to set
     */
    public void setResultadocubo(double resultadocubo) {
        this.resultadocubo = resultadocubo;
    }

    /**
     * @return the esfera1
     */
    public double getEsfera1() {
        return esfera1;
    }

    /**
     * @param esfera1 the esfera1 to set
     */
    public void setEsfera1(double esfera1) {
        this.esfera1 = esfera1;
    }

    /**
     * @return the resultadoesfera
     */
    public double getResultadoesfera() {
        return resultadoesfera;
    }

    /**
     * @param resultadoesfera the resultadoesfera to set
     */
    public void setResultadoesfera(double resultadoesfera) {
        this.resultadoesfera = resultadoesfera;
    }

    /**
     * @return the cylindro1
     */
    public double getCylindro1() {
        return cylindro1;
    }

    /**
     * @param cylindro1 the cylindro1 to set
     */
    public void setCylindro1(double cylindro1) {
        this.cylindro1 = cylindro1;
    }

    /**
     * @return the cilyndro2
     */
    public double getCilyndro2() {
        return cilyndro2;
    }

    /**
     * @param cilyndro2 the cilyndro2 to set
     */
    public void setCilyndro2(double cilyndro2) {
        this.cilyndro2 = cilyndro2;
    }

    /**
     * @return the resultadocylindro
     */
    public double getResultadocylindro() {
        return resultadocylindro;
    }

    /**
     * @param resultadocylindro the resultadocylindro to set
     */
    public void setResultadocylindro(double resultadocylindro) {
        this.resultadocylindro = resultadocylindro;
    }
   public double cubo(){
      resultadocubo=cubo1*cubo1*cubo1;
      return resultadocubo;
}
   public double esfrera(){
           resultadoesfera=4/3*3.14*esfera1*esfera1;
      return resultadoesfera;
   }
   public double cilindro(){
   resultadocylindro=3.14*cylindro1*cylindro1*cilyndro2;
      return resultadocylindro;
    }
   }
    

