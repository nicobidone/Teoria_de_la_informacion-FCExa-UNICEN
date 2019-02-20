
package tpe_final;

import gestionDatos.Grafico;
import java.awt.BorderLayout;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;


public class Histograma extends javax.swing.JFrame {
    
    Float[] probsFloat = new Float[256];
    
    public Histograma(Double[] probs) {
        initComponents();
        
        for (int i = 0; i < 256; i++) probsFloat[i] = (probs[i]).floatValue();
                
        Map<Integer, Float> mapHistory = new HashMap();
        for (int i = 0; i < probsFloat.length; i++) {
            mapHistory.put(i, probsFloat[i]);
        }
        
        JFrame frame = new JFrame("Histograma");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        JScrollPane sp = new JScrollPane(new Grafico(mapHistory), ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        frame.add(sp);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 503, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
