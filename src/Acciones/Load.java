/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acciones;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import gestionDatos.GestorImagen;
import gestionDatos.GestorTexto;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nicob
 */
public class Load {
    File archivo;
    JFileChooser seleccionado = new JFileChooser();
    
    public BufferedImage Image(JLabel jL_img, JFrame jF_TheFrame){
            // TODO add your handling code here:
        BufferedImage bytes = null;
        
        if (seleccionado.showDialog(jF_TheFrame,"Abrir") == JFileChooser.APPROVE_OPTION){
            archivo = seleccionado.getSelectedFile();
            if (archivo.canRead()){
                if ((archivo.getName().endsWith("bmp"))||(archivo.getName().endsWith("jpg"))){
                    bytes = GestorImagen.AbrirImagen(archivo);
                    jL_img.setIcon(new ImageIcon(bytes));
                }
                else{
                    JOptionPane.showMessageDialog(null, "Archivo invalido");
                }
            }
        }
        
        return bytes;
    }
    public BufferedReader Text(JFrame jF_TheFrame){                             
        BufferedReader archivoTexto = null;
        
        if (seleccionado.showDialog(jF_TheFrame,"Abrir") == JFileChooser.APPROVE_OPTION){    
            archivo = seleccionado.getSelectedFile();
            if (archivo.canRead()){
                if (archivo.getName().endsWith("txt")){
                    archivoTexto = GestorTexto.abrirTexto(archivo);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Archivo invalido");
                }
            } 
        }
        
        return archivoTexto;
    }
    
    public String TextCont(JFrame jF_TheFrame){
        String linea = "";
        if (seleccionado.showDialog(jF_TheFrame,"Abrir archivo con la codificación") == JFileChooser.APPROVE_OPTION){    
            archivo = seleccionado.getSelectedFile();
            if (archivo.canRead()){
                if (archivo.getName().endsWith("txt")){
                    
                    try {
                        linea = GestorTexto.getContenido(archivo.getAbsolutePath());
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(Load.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Archivo invalido");
                }
            } 
        }
        return linea;
    }
}
