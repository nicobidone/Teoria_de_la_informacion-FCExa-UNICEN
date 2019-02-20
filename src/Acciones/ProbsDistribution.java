/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acciones;

import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 *
 * @author nicob
 */
public class ProbsDistribution {
    public Double[] generar(BufferedImage bytesImageP, int COLORES){
        Double[] distribucion = new Double[COLORES];         
        for (int i = 0; i < 256; i++) distribucion[i] = 0.0;
        
        int iteraciones = 0;      
        for(int c = 0; c < bytesImageP.getWidth(); c++) { 
            for(int f = 0; f < bytesImageP.getHeight(); f++) {
                int color = new Color(bytesImageP.getRGB(c,f),true).getBlue();
                distribucion[color]++;
                iteraciones++;
            }
        }        
        for (int i = 0; i < COLORES; i++) {
            distribucion[i] = distribucion[i]/iteraciones;   
        }
        
        return distribucion;
    }   
    
}
