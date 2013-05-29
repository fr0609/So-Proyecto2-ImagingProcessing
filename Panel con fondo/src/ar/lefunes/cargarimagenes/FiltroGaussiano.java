/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.lefunes.cargarimagenes;

/**
 *
 * @author fr0609
 */
import java.awt.image.BufferedImage;
//http://code.google.com/p/jtrasign/source/browse/trunk/JTraffic/src/jtraffic/lib/filtros/FiltroGaussiano.java?r=40
/**
 *
 * @author JuanmaSP
 * @author DavidSAC
 * @date 2008-12-11
 */
public class FiltroGaussiano {
    /**
     * Aplica un filtro Gaussiano
     *
     * @param imagen a la que se le va a aplicar el filtro de Gauss
     * @param theta
     * @param tamaño de la matriz.
     * @return la imagen resultante de aplicar el filtro de Gauss
     *      a la imagen original.
     */
    public  BufferedImage aplicar(BufferedImage imagen, int theta, int size){
        BufferedImage res = null;
        float kernel[][]= generateKernel(theta, size);

        res = Convolucion.aplicar(kernel, imagen, Convolucion.BORDES_0);

        return res;
    }

    /**
     *  Genera la matriz de convolución para un filtro Gaussiano a partir de
     * theta y el tamaño de la matriz (n x n).
     *
     * @param theta
     * @param size
     * @return
     */
    private static float[][] generateKernel(float theta, int size){
        float [][] kernel = new float [size][size];
        for(int j=0;j<size;++j){
            for(int i=0;i<size;++i){
                kernel[i][j]=gaussianDiscrete2D(theta,i-(size/2),j-(size/2));
            }
        }

        double sum = 0;
        for(int j=0;j<size;++j){
          for(int i=0;i<size;++i){
        sum = sum + kernel[i][j];

          }
        }

        return kernel;
    }

    private static float gaussianDiscrete2D(double theta, int x, int y){
    float g = 0;
    for(double ySubPixel = y - 0.5; ySubPixel < y + 0.55; ySubPixel += 0.1){
      for(double xSubPixel = x - 0.5; xSubPixel < x + 0.55; xSubPixel += 0.1){
            g = g + (float)((1/(2*Math.PI*theta*theta)) *
            Math.pow(Math.E,-(xSubPixel*xSubPixel+ySubPixel*ySubPixel)/
                          (2*theta*theta)));
      }
    }
    g = g/121;
    //System.out.println(g);
    return g;
  }

}

