
package gestionDatos;

import java.util.ArrayList;

public class HuffmanCod {
    int id;
    Double val, suma;
    ArrayList<Integer> cod = new ArrayList();
    ArrayList<HuffmanCod> depend = new ArrayList();
    
    public HuffmanCod(int id, Double val){
        this.id = id;
        this.val = val;
        this.suma = val;
    }
    
    public int getId() {
        return id;
    }
    
    public Double getValor(){
        return val;
    }
    
    public ArrayList<Integer> getCod(){
        return cod;
    }
    
    public String getCodString(){
        String res = "";
        for (int i : cod)
            if (i == 0)
                res += '0';
            else
                res += '1';
        return res;
    }

    public Double getSuma() {
        return suma;
    }
    
    public void addBit(Boolean b){
        if (b) cod.add(0, 1); 
        else cod.add(0,0);
        for (int i = 0; i< depend.size(); i++)
            depend.get(i).addBit(b);
    }

    public void sumar(HuffmanCod get) {
        suma = suma + get.getSuma();
        this.addBit(true);
        get.addBit(false);
        depend.add(get);
    }    
}