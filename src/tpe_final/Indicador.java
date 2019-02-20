
package tpe_final;

import java.awt.Color;
import java.awt.image.BufferedImage;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Indicador{
    public double media_mat(BufferedImage A, int limIzq, int limDer){
        int suma = 0, n = 0;
        for (int c = limIzq; c < limDer; c++)
            for (int f = 0; f < A.getHeight(); f++){
                suma = suma + new Color(A.getRGB(c, f)).getBlue();
                n++;
            }
        return (double)suma/n;
    }
    
    public Double media_vect(Double[] A){
        Double suma = 0.0, n = 0.0;
        for (Double A1 : A) {
            suma = suma + A1;
            n++;
        }
        return suma/n;
    }
    
    public double desvio_mat(BufferedImage A, int limIzq, int limDer){
        int suma = 0, n = 0;
        double sumaQuad = 0.0;
        for (int c = limIzq; c < limDer; c++)
            for (int f = 0; f < A.getHeight(); f++){
                suma = suma + new Color(A.getRGB(c, f)).getBlue();
                sumaQuad = sumaQuad + pow(new Color(A.getRGB(c, f)).getBlue(),2);
                n++;
            }
        return sqrt((sumaQuad/n)-pow((double)suma/n,2));
    }
    
    public double desvio_vect(Double[] A){
        double suma = 0.0, n = 0.0, sumaQuad = 0.0;
        for (double A1 : A) {
            suma = suma + A1;
            sumaQuad = sumaQuad + pow(A1, 2);
            n++;
        }
        return sqrt((sumaQuad/n)-pow(suma/n,2));
    }
    
    public double correlacion (BufferedImage A, BufferedImage B, int limIzq, int limDer){
        
        Double[] suma = {0.0,0.0,0.0,0.0,0.0};
        Double n = 0.0, res, medA, medB, covAB, varA, varB;
        for (int c = 0; limIzq+c < limDer; c++)
            for (int f = 0; f < A.getHeight(); f++){
                suma[0] = suma[0] + (new Color(A.getRGB(limIzq+c, f)).getBlue() * new Color(B.getRGB(c, f)).getBlue()); //<AB>
                suma[1] = suma[1] + (new Color(A.getRGB(limIzq+c, f)).getBlue());   //<A>
                suma[2] = suma[2] + (new Color(B.getRGB(c, f)).getBlue());          //<B>
                suma[3] = suma[3] + pow(new Color(A.getRGB(limIzq+c, f)).getBlue(),2);  //<A²>
                suma[4] = suma[4] + pow(new Color(B.getRGB(c, f)).getBlue(),2);         //<B²>
                n++;
            }
        
        medA = (suma[1]/n); 
        medB = (suma[2]/n);
        varA = ((suma[3]/n)-pow(suma[1]/n,2));
        varB = ((suma[4]/n)-pow(suma[2]/n,2));
        covAB = (suma[0]/n)-(medA*medB);
        
        //System.out.println("<AB>: "+covAB+" <A>: "+medA+" <B>: "+medB);
        //System.out.println("σA: "+sqrt(varA)+" σB: "+sqrt(varB));
        res = (covAB)/(sqrt(varA)*sqrt(varB));
        
        return res;
    }

}
