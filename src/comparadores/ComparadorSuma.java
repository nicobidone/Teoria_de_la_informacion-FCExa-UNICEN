
package utilidades.comparadores;
import java.util.Comparator;
import gestionDatos.HuffmanCod;

public class ComparadorSuma implements Comparator<HuffmanCod>{
    
    public int compare(HuffmanCod h0, HuffmanCod h1){
        return h0.getSuma().compareTo(h1.getSuma());
    }
}