/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpe_final;

import java.awt.image.BufferedImage;

/**
 *
 * @author nicob
 */
public class Panoramica {
        private BufferedImage armar_panoramica(BufferedImage A, BufferedImage B, BufferedImage C, int l1, int l2){
        
        int width = A.getWidth()-l1+B.getWidth()-l2+C.getWidth();
        int height =  A.getHeight();
        BufferedImage IMG = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        
        for (int f= 0; f < A.getHeight(); f++){
            int m = 0;
            for (int c = 0; c < A.getWidth()-l1; c++){
                IMG.setRGB(m, f, A.getRGB(c,f));
                m++;
            }
            for (int c = 0; c < B.getWidth()-l2; c++){
                IMG.setRGB(m, f, B.getRGB(c,f));
                m++;
            }
            for (int c = 0; c < C.getWidth(); c++){
                IMG.setRGB(m, f, C.getRGB(c,f));
                m++;
            }
        }
        return IMG;        
    }
    
    private int obtener_ptocorte(BufferedImage A, BufferedImage B, Double base, int cols){
        int  lim = -1;
        Double corr, corr_best = -1.0;
        for (int i = 0; i < cols; i++){
            corr = new Indicador().correlacion(A,B, A.getWidth()-i, A.getWidth());
            
            if (corr == 1.0)
                lim = i;
            else 
                if ((corr < 1.0) && (corr > base) && (corr > corr_best)){
                    lim = i;
                    corr_best = corr;
                    System.out.println(corr);
                }
        }
        return lim;
    }
    
    public BufferedImage obtener_panoramica(BufferedImage A, BufferedImage B, BufferedImage C, Double base, int cols){
        
        BufferedImage res = null;
        int lim1 = obtener_ptocorte(A,B,base,cols), lim2 = obtener_ptocorte(B, C, base,cols);
        System.out.println(lim1+" - "+lim2);
        if (base > -1.0 && base <= 1.0){
            if (lim1 == -1 && lim2 == -1){
                System.out.println("A");
                res = obtener_panoramica(A, C, B, base-0.01, cols);
            }
            else if (lim1 == -1 && lim2 != -1){
                System.out.println("B");
                res = obtener_panoramica(B, C, A, base-0.01, cols);
            }
            else if (lim1 != -1 && lim2 == -1){
                System.out.println("C");
                res = obtener_panoramica(C, A, B, base-0.01, cols);
            }
            else{
                System.out.println("fcorrf"+base);
                res = armar_panoramica(A, B, C, lim1, lim2);
            }
        }
        return res;
    }
    
}