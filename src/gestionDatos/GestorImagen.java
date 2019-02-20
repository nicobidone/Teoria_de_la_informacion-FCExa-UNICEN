
package gestionDatos;

import java.awt.Color;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GestorImagen {
    
    // Abrir imagen
    public static BufferedImage AbrirImagen(File archivo){
        BufferedImage img = null;
        try{
            img = ImageIO.read(archivo);
        } 
        catch (Exception e){
        }
        return img;
    }
    
    // Guardar imagen
    public static String GuardarImagen(BufferedImage img, String extension , File archivo){
        try{
            ImageIO.write(img , extension, archivo);
            return "Imagen guardada";
        }
        catch(Exception e){
            return "Error I/O";
        }  
    }
    
    // Parsea la imagen en una lista con el valor de tono de cada pixel
    public static ArrayList<Integer> fromImageToRGBList(BufferedImage img){   
        ArrayList<Integer> texto = new ArrayList();
                
        for (int x = 0; x < img.getWidth(); x++){ 
            for (int y = 0; y < img.getHeight(); y++){
                texto.add(new Color(img.getRGB(x, y), true).getBlue());
            }
        }
        return texto;
    }
    
}
