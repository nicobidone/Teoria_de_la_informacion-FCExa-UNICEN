
package utilidades.comparadores;
import java.util.Comparator;
import gestionDatos.HuffmanCod;

public class ComparadorProb implements Comparator<HuffmanCod>{
   
    public int compare(HuffmanCod h0, HuffmanCod h1){
        return -h0.getValor().compareTo(h1.getValor());
    }
}
