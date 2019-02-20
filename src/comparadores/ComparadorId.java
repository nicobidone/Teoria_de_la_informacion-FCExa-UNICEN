
package utilidades.comparadores;
import java.util.Comparator;
import gestionDatos.HuffmanCod;

public class ComparadorId implements Comparator<HuffmanCod>{
   
    public int compare(HuffmanCod h0, HuffmanCod h1){
        return h0.getId()-h1.getId();
    }
}
