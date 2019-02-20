
package gestionDatos;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.Map;
import javax.swing.JPanel;


public class Grafico extends JPanel {

    protected static final int MIN_BAR_WIDTH = 5;   // Baje el ancho de la barra de 40 a 5
    private final Map<Integer, Float> mapHistory;
    private float maxValue;

    public Grafico(Map<Integer, Float> mapHistory) {
        this.mapHistory = mapHistory;
        int width = (mapHistory.size() * MIN_BAR_WIDTH) + 11;
        Dimension minSize = new Dimension(width, 128);
        Dimension prefSize = new Dimension(width, 256);
        setMinimumSize(minSize);
        setPreferredSize(prefSize);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (mapHistory != null) {
            
            int xOffset = 40;
            int yOffset = 40;
            int width = getWidth() - (xOffset * 2) - 1;
            int height = getHeight() - (yOffset * 2) - 1;
            
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setColor(Color.DARK_GRAY);
            g2d.drawRect(xOffset, yOffset, width, height);
            
            int barWidth = Math.max(MIN_BAR_WIDTH, (int) Math.floor((float) width / (float) mapHistory.size()));
            
            maxValue = 0.0f;
            mapHistory.keySet().stream().forEach((key) -> {
                maxValue = Math.max(maxValue, mapHistory.get(key));
            });
            
            int xPos = xOffset;
            
            for (Integer key : mapHistory.keySet()) {
                Float value = mapHistory.get(key);  
                int barHeight = Math.round(( value / maxValue) * (float) (height) );
                g2d.setColor(new Color(key, key, key));
                int yPos = height + yOffset - barHeight;
                Rectangle2D bar = new Rectangle2D.Float(xPos, yPos, barWidth, barHeight);
                g2d.fill(bar);
                g2d.setColor(Color.DARK_GRAY);
                g2d.draw(bar);
                xPos += barWidth;
            }
            
            int step = Math.round( height /10 );
            float delta =  maxValue /10 ;
            for (int i = 0; i < 10; i++){
                int yPos = yOffset + (step*i);
                g2d.setColor(Color.LIGHT_GRAY);
                g2d.drawLine(xOffset, yPos, width + xOffset , yPos);
                g2d.setColor(Color.darkGray);
                g2d.drawString(String.valueOf((10-i) * delta), xOffset + 10, yPos);
            }
            g2d.dispose();
        }
    }
    
}
