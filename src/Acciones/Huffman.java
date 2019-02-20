/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acciones;

import gestionDatos.HuffmanCod;
import java.util.ArrayList;
import utilidades.comparadores.ComparadorId;
import utilidades.comparadores.ComparadorSuma;

/**
 *
 * @author nicob
 */
public class Huffman {
    
    public ArrayList<HuffmanCod> obtener(Double[] distribucion, int COLORES){
        
        ArrayList<HuffmanCod> huffman = new ArrayList();
        
        for (int i = 0; i < COLORES; i ++){
            if (distribucion[i] != 0.0)                                         // Preguntar si esta ok
                huffman.add(new HuffmanCod(i, distribucion[i]));                 
        }
        huffman.sort(new ComparadorSuma());
        
        // Algoritmo Huffman
        for (int i = 0; i < huffman.size() - 1; i ++){
            huffman.get(i+1).sumar(huffman.get(i));
            huffman.sort(new ComparadorSuma());
        }

        huffman.sort(new ComparadorId());
        
        return huffman;
    }
    
}
