/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acciones;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import gestionDatos.Dupla;

/**
 *
 * @author nicob
 */
public class RLC {
    public BufferedImage comprimir(int jS, BufferedImage bytesImageP) {                                           
        // TODO add your handling code here:  
        ArrayList<Integer> rlc = codPan(bytesImageP), resultado = new ArrayList<>();
        ArrayList<Dupla> temp = new ArrayList<>();
        temp.add(new Dupla(rlc.get(0),1));
        int pos = 0;        
        for (int i = 0; i < rlc.size()-1; i++){
            if (Math.abs(temp.get(pos).getSimbolo()- rlc.get(i+1)) < jS)
                temp.get(pos).add();
            else{
                temp.add(new Dupla(rlc.get(i+1),1));
                pos++;
            }
        }
        
        temp.forEach((d) -> {
            for (int i = 0; i < d.getCantidad(); i++)
                resultado.add(d.getSimbolo());
        });
        
        return new Reconstruir().Imagen(resultado, bytesImageP.getWidth(), bytesImageP.getHeight());
    }  
    
    private  ArrayList<Integer> codPan(BufferedImage bytesImageP){                                       
        ArrayList<Integer> texto = new ArrayList();
        for (int c = 0; c < bytesImageP.getWidth(); c++){  
            for (int f = 0; f < bytesImageP.getHeight(); f++){
                texto.add(new Color(bytesImageP.getRGB(c,f),true).getBlue());
            }
        }
        return texto;
    }
    
}
