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
public class ModelVolumen {
private Double lado=0.0;
private Double resultquadra=0.0;

private Double ladoRombo=0.0;
private Double alturaRombo=0.0;
private Double resultRombo=0.0;

private Double alto=0.0;
private Double largo=0.0;
private Double ancho=0.0;
private Double resultRect=0.0;

    /**
     * @return the lado
     */
    public Double getLado() {
        return lado;
    }

    /**
     * @param lado the lado to set
     */
    public void setLado(Double lado) {
        this.lado = lado;
    }

    /**
     * @return the resultquadra
     */
    public Double getResultquadra() {
        return resultquadra;
    }

    /**
     * @param resultquadra the resultquadra to set
     */
    public void setResultquadra(Double resultquadra) {
        this.resultquadra = resultquadra;
    }

    /**
     * @return the ladoRombo
     */
    public Double getLadoRombo() {
        return ladoRombo;
    }

    /**
     * @param ladoRombo the ladoRombo to set
     */
    public void setLadoRombo(Double ladoRombo) {
        this.ladoRombo = ladoRombo;
    }

    /**
     * @return the alturaRombo
     */
    public Double getAlturaRombo() {
        return alturaRombo;
    }

    /**
     * @param alturaRombo the alturaRombo to set
     */
    public void setAlturaRombo(Double alturaRombo) {
        this.alturaRombo = alturaRombo;
    }

    /**
     * @return the resultRombo
     */
    public Double getResultRombo() {
        return resultRombo;
    }

    /**
     * @param resultRombo the resultRombo to set
     */
    public void setResultRombo(Double resultRombo) {
        this.resultRombo = resultRombo;
    }

    /**
     * @return the largo
     */
    public Double getLargo() {
        return largo;
    }

    /**
     * @param largo the largo to set
     */
    public void setLargo(Double largo) {
        this.largo = largo;
    }

    /**
     * @return the ancho
     */
    public Double getAncho() {
        return ancho;
    }

    /**
     * @param ancho the ancho to set
     */
    public void setAncho(Double ancho) {
        this.ancho = ancho;
    }

    /**
     * @return the resultRect
     */
    public Double getResultRect() {
        return resultRect;
    }

    /**
     * @param resultRect the resultRect to set
     */
    public void setResultRect(Double resultRect) {
        this.resultRect = resultRect;
    }
    
    /**
     * @return the alto
     */
    public Double getAlto() {
        return alto;
    }

    /**
     * @param alto the alto to set
     */
    public void setAlto(Double alto) {
        this.alto = alto;
    }
    
          public double quadrado(){
         resultquadra= lado*lado*lado; 
    return resultquadra;
    }
    public double rombo(){
   resultRombo= 0.33*ladoRombo*ladoRombo/alturaRombo;
    return resultRombo;
    }
    
    public double rectangulo(){
        resultRect=alto* largo*ancho;
    return resultRect;
    }
}

