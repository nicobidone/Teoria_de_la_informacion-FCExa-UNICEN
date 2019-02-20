/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acciones;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author nicob
 */
public class Reconstruir {
    public BufferedImage Imagen(ArrayList<Integer> resultado, int width, int height){
                
        BufferedImage newImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        
        int y = 0, x = 0;
        for (Integer pixel : resultado){
            if(x < width && y < height){
                newImage.setRGB(x, y, new Color(pixel,pixel,pixel).getRGB());
                y++;
            }
            if (y == height) {
                y = 0; 
                x++;
            } 
        } 
        
        return newImage;
    }
    
}
