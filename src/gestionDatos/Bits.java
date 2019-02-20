
package gestionDatos;

import java.util.ArrayList;

public class Bits {
        
    public ArrayList<Integer> generarDecodificacion(String codigo, String[] codificacion){
        
        ArrayList<Integer> resultado = new ArrayList();
        String temp = "";
        for (char num: codigo.toCharArray()){
            char mascara = 1 << 15;//desplaza el 1, 15 lugares a la izq (32768)
            for(int i = 0; i<16; i++){
                if((num & mascara)==32768) //si el 1º bit de num es 1
                    temp += '1';
                else
                    temp += '0';
                
                int cod = -1;                
                for (int x = 0; x < codificacion.length; x++){
                    if (temp.equals(codificacion[x]))
                        cod = x;
                }
                    
                if (cod != -1){
                    resultado.add(cod);                    
                    temp = "";
                }
                
                num = (char) (num << 1);
            }
        }
        return resultado;
    }
       
    public static String generarCodificacion(ArrayList<Integer> mensaje, String[] codificacion){//
        String resultado = "";
        char buffer = 0;
        int cant_digitos = 0;
        for (int simbolo : mensaje){
            char[] codigo = codificacion[simbolo].toCharArray();
            for(char bit : codigo){
                buffer = (char) (buffer << 1);
                if (bit == '1')
                    buffer = (char)(buffer|1);
                cant_digitos++;
                if (cant_digitos == 16){
                    resultado += buffer;
                    buffer = 0;
                    cant_digitos = 0;
                }
            }
        }
        if ((cant_digitos < 16) && (cant_digitos != 0)){
            buffer = (char)(buffer << (16-cant_digitos));
            resultado += buffer;
        }
        return resultado;
    }
}
