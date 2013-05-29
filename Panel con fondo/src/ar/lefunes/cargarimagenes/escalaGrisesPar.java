/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.lefunes.cargarimagenes;

import java.awt.Color;

/**
 *
 * @author fr0609
 */
public class escalaGrisesPar implements Runnable {
    Imagen imagenOriginal; 
    Imagen imagenTemporal; 
    int iInicial; 
    int jInicial;
    int iFinal; 
    int jFinal;
  public escalaGrisesPar(Imagen _imagenOriginal, Imagen _imagenTemporal, int _iInicial, int _jInicial, int _iFinal, int _jFinal) {
  imagenOriginal=_imagenOriginal;
  imagenTemporal=_imagenTemporal;
  iInicial=_iInicial;
  jInicial=_jInicial;
  iFinal = _iFinal;
  jFinal = _jFinal;
         
  }  
    
    
 Metodos ins= new Metodos();
    public void run() {
    try {
        
      //sem.acquire();
     
            for (int i = iInicial; i <= iFinal && i < iFinal; i++) {
                for (int j = jInicial; j <= jFinal && j < jFinal; j++) {
                    int escalagris = (imagenTemporal.matriz[ i][ j].getGreen()
                            + imagenTemporal.matriz[ i][ j].getBlue() + imagenTemporal.matriz[ i][ j].getRed()) / 3;
                    ins.sem.acquire();
                    imagenOriginal.matriz[ i][ j] = new Color(escalagris, escalagris, escalagris);
                  //  Thread.sleep(10);
                    ins.sem.release();
                }
            }
            
            //sem.release();
        }
            catch (Exception ex) {
            //return null;   //System.out.print(ex);
        }
    }
}
