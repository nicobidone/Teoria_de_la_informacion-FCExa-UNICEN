
package gestionDatos;

public class Dupla {
    
    int simbolo, cantidad;
    
    public Dupla(int simbolo, int cantidad){
        this.simbolo = simbolo;
        this.cantidad = cantidad;
    }
    
    public void add(){
        cantidad++;
    }
    
    public Integer getSimbolo(){
        return simbolo;
    }
    
    public Integer getCantidad(){
        return cantidad;
    }
}
