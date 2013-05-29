/*
 * Classname Metodos
 * 
 * Version 1.0    
 *
 * Date 5/18/2013
 * 
 * Copyright notice
 */
package ar.lefunes.cargarimagenes;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

/**
 *
 * @author fr0609
 */
public class Metodos {

    /*    
    Almacena la ruta de la imagen*/
    public String ruta;
   Semaphore sem = new Semaphore(1, true);
    /** Construir: Llama a una de las 15 opciones de filtrado que el usuario elija.
    
    @param jPanelConfond1 panel para construir la imagen de entrada
    @param jPanelCondo2 panel para construir la imagen modificada
    @param fc filechooser de archivos
    @param opt Tipo de funcion que el usuario desea elegir
     */
    public void Contruir(ar.lefunes.jpanelconfondo.JPanelConFondo jPanelConFondo1,
            ar.lefunes.jpanelconfondo.JPanelConFondo jPanelConFondo2, JFileChooser fc,
            int opt, int nivel) throws IOException {
        try {
            File imagen = fc.getSelectedFile();

            ruta = imagen.getPath();
            Imagen imagenOriginal = null;
            imagenOriginal = new Imagen(ruta);
            System.out.println(opt+" contruir");
            switch (opt) {
                case 0:
                    System.out.println(opt+" contruir1");
                    Imagen imagen_EscalaGrises = new Imagen(ruta);   
                    jPanelConFondo2.setImagen(escalaGrisesControlador(imagen_EscalaGrises).dibujarImagen().getImage());
                    jPanelConFondo1.setImagen(imagenOriginal.dibujarImagen().getImage());
                    break;
                case 1:
                    System.out.println(opt+" contruir2");
                    Imagen imagen_Sepia = new Imagen(ruta);
                    jPanelConFondo2.setImagen(Sepia(imagen_Sepia,nivel).dibujarImagen().getImage());
                    jPanelConFondo1.setImagen(imagenOriginal.dibujarImagen().getImage());
                    break;
                case 2:
                    Imagen imagen_Opacidad = new Imagen(ruta);
                    jPanelConFondo2.setImagen(Opacidad(imagen_Opacidad,64).dibujarImagen().getImage());
                    jPanelConFondo1.setImagen(imagenOriginal.dibujarImagen().getImage());
                    break;
                case 3:
                    Imagen imagen_Invertir = new Imagen(ruta);
                    jPanelConFondo2.setImagen(InvertirColor(imagen_Invertir));
                    jPanelConFondo1.setImagen(imagenOriginal.dibujarImagen().getImage());
                    break;
                case 4:
                    Imagen imagen_Gaus = new Imagen(ruta);
                    jPanelConFondo2.setImagen(desenfoqueGausiano(imagen_Gaus, nivel).dibujarImagen().getImage());
                    jPanelConFondo1.setImagen(imagenOriginal.dibujarImagen().getImage());
                    break;
                case 5:
                    Imagen imagen_Brillo = new Imagen(ruta);
                    jPanelConFondo2.setImagen(ajustarBrillo(imagen_Brillo, nivel));
                    jPanelConFondo1.setImagen(imagenOriginal.dibujarImagen().getImage());
                    break;
                case 6:
                    Imagen imagen_Pixelada = new Imagen(ruta);
                    jPanelConFondo2.setImagen(pixelarImagen(imagen_Pixelada).dibujarImagen().getImage());
                    jPanelConFondo1.setImagen(imagenOriginal.dibujarImagen().getImage());
                    break;
                case 7:
                    Imagen imagen_Segmentada = new Imagen(ruta);
                    jPanelConFondo2.setImagen(Segmentacion(imagen_Segmentada, nivel).dibujarImagen().getImage());
                    jPanelConFondo1.setImagen(imagenOriginal.dibujarImagen().getImage());
            }
        } catch (IOException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
        } 
    

    /** 
     * Llama a una de las 15 opciones de filtrado que el usuario elija. 
     * @param imagenOriginal: imagen a la que se  aplica el escalado de grises
     */
    public Imagen escalaGrises(Imagen imagenOriginal) {

 
            for (int i = 0; i < imagenOriginal.ancho; i++) {
                for (int j = 0; j < imagenOriginal.alto; j++) {
                    int escalagris = (imagenOriginal.matriz[ i][ j].getGreen()
                            + imagenOriginal.matriz[ i][ j].getBlue() + imagenOriginal.matriz[ i][ j].getRed()) / 3;
                    imagenOriginal.matriz[ i][ j] = new Color(escalagris, escalagris, escalagris);
                }
            }
            return imagenOriginal;
}
    

 /*   public Imagen escalaGrisesControlador(Imagen imagen) throws IOException, InterruptedException {
        int iMitad = imagen.ancho / divisorImagen(imagen.ancho);
        int iInicial = 0;
        int jInicial = 0;
        final Imagen imagen_EscalaGrisesTemp = imagen;
        Thread thrdA = new Thread(new escalaGrisesPar(imagen, imagen_EscalaGrisesTemp,iMitad,jInicial,imagen.ancho,imagen.alto)); //mitad
        Thread thrdB = new Thread(new escalaGrisesPar(imagen, imagen_EscalaGrisesTemp,iInicial,jInicial,iMitad,imagen.alto));
        thrdA.start();
        thrdB.start();
     //   thrdA.join();
     //   thrdB.join();
        return imagen;
    }*/

    public Imagen escalaGrisesControlador(Imagen imagen) throws IOException, InterruptedException {
        int iMitad = imagen.ancho / divisorImagen(imagen.ancho);
        int jMitad =imagen.alto / divisorImagen(imagen.alto);
        int iInicial = 0;
        int jInicial = 0;
        final Imagen imagen_EscalaGrisesTemp = imagen;
        Thread thrdAizqA = new Thread(new escalaGrisesPar(imagen, imagen_EscalaGrisesTemp,iMitad,0,imagen.ancho,jMitad)); //arriba izquierda
        Thread thrdAizqAb = new Thread(new escalaGrisesPar(imagen, imagen_EscalaGrisesTemp,iMitad,jMitad,imagen.ancho,imagen.alto)); //abajoizquierda
        Thread thrdAderA = new Thread(new escalaGrisesPar(imagen, imagen_EscalaGrisesTemp,0,0,iMitad,jMitad)); 
        Thread thrdAderAb = new Thread(new escalaGrisesPar(imagen, imagen_EscalaGrisesTemp,0,jMitad,iMitad,imagen.alto)); 
       // Thread thrdB = new Thread(new escalaGrisesPar(imagen, imagen_EscalaGrisesTemp,iInicial,jInicial,iMitad,imagen.alto));
        thrdAizqA.start();
        thrdAizqAb.start();
        thrdAderA.start();
        thrdAderAb.start();
     //   thrdA.join();
     //   thrdB.join();
        return imagen;
    }
    
    
     /**
     * Calcula el menor divisor del número dado que sea mayor a 1.
     * @param numero al que se le buscará el divisor.
     * @return menor divisor mayor a uno del número
     */
    private int  divisorImagen(int numero) {
        boolean encontrado = false;
        int divisor = 2;

// Si el número es par el divisor menor es 2
        if (numero % divisor == 0) {
            return divisor;
        } else {
// Si el número es impar le busca un divisor impar
            divisor = 3;
            while (divisor < numero && !encontrado) {
                if (numero % divisor == 0) {
                    encontrado = true;
                } else {
                    divisor += 2;
                }
            }
            return divisor;
        }
    }
    
    
    /**
     * Aplicar filtro de Sepia
     * @param imagenOriginal
     * @param sepiaIntencidad
     * @return 
     */
    public Imagen Sepia(Imagen imagenOriginal, int sepiaIntencidad) {
// Play around with this. 20 works well and was recommended
// by another developer. 0 produces black/white image


        try {
            for (int i = 0; i < imagenOriginal.ancho; i++) {
                for (int j = 0; j < imagenOriginal.alto; j++) {

                    int g = imagenOriginal.matriz[ i][ j].getGreen();
                    int b = imagenOriginal.matriz[ i][ j].getBlue();
                    int r = imagenOriginal.matriz[ i][ j].getRed();
                    int nuevo_Rojo = (int) (r * .393 + g * .769 + b * .189);
                    int nuevo_Verde = (int) (r * .349 + g * .686 + b * .168);
                    int nuevo_Azul = (int) (r * .272 + g * .534 + b * .131);
                    if (nuevo_Rojo > 255) {
                        nuevo_Rojo = 255;
                    }
                    if (nuevo_Verde > 255) {
                        nuevo_Verde = 255;
                    }
                    if (nuevo_Azul > 255) {
                        nuevo_Azul = 255;
                    }
                    if (nuevo_Rojo < 0) {
                        nuevo_Rojo = 0;
                    }
                    if (nuevo_Verde < 0) {
                        nuevo_Verde = 0;
                    }
                    if (nuevo_Azul < 0) {
                        nuevo_Azul = 0;
                    }
                    imagenOriginal.matriz[ i][ j] = new Color(nuevo_Rojo, nuevo_Verde, nuevo_Azul);
                }
            }
            return imagenOriginal;
        } catch (Exception ex) {
            return null;   //System.out.print(ex);
        }
    }

    /**
     * Método que pixela el bitMap El pixelamiento consiste en dividir la imagen en pequeñas regiones de píxeles
     * y para cada una de esas regiones cambiar el color de los píxeles al color promedio
     * de dicha región
     * En este caso, la región se dimensiona con los divisores más pequeños del ancho y el alto de la imagen
     * @param imagen: imagen a pixelar
     */
    public Imagen pixelarImagen(Imagen imagen) {
// Los píxeles son divisores de las dimensiones de la imagen

        int anchoPixel = menorDivisorMayorAUno(imagen.ancho);
        int altoPixel = menorDivisorMayorAUno(imagen.alto);

// Recorre la matriz por regiones para modificarla
        for (int x = 0; x < imagen.ancho; x += anchoPixel) {
            for (int y = 0; y < imagen.alto; y += altoPixel) {
// Obtiene el color medio de la región
                Color colorPromedio = calcularColorPromedio(imagen, x, y,
                        x + anchoPixel - 1, y + altoPixel - 1);
// Cambia el color de la región al promedio
                cambiarColorRegion(imagen, colorPromedio, x, y,
                        x + anchoPixel - 1, y + altoPixel - 1);
            }
        }
        return imagen; //retorna imagen modificada
    }

    /**
     * Metodo cambiar el color de una region
     * @param imagen: imagen a modificar
     * @param color: color a aplicar 
     * @param xInicial: posicion x inicial
     * @param yInicial: posicision y inicial
     * @param xFinal: posicion x final
     * @param yFinal  posicion y final
     */
    private void cambiarColorRegion(Imagen imagen, Color color, int xInicial, int yInicial, int xFinal, int yFinal) {
        for (int i = yInicial; i <= yFinal && i < imagen.alto; i++) {
            for (int j = xInicial; j <= xFinal && j < imagen.ancho; j++) {
                imagen.matriz[ j][ i] = color;
            }
        }
    }

    /**
     * Metodo calcular el color promedio de una region determinada
     * @param imagen
     * @param imagen: imagen a modificar
     * @param color: color a aplicar 
     * @param xInicial: posicion x inicial
     * @param yInicial: posicision y inicial
     * @param xFinal: posicion x final
     * @param yFinal  posicion y final
     * @return: Retorna un color calculado
     */
    private Color calcularColorPromedio(Imagen imagen, int xInicial, int yInicial, int xFinal, int yFinal) {
        int valorMedioRojo = 0, valorMedioVerde = 0, valorMedioAzul = 0;
        int totalPixeles = (xFinal - xInicial + 1) * (yFinal - yInicial + 1);

// Recorre la región para promediar los componentes de los colores
        for (int i = xInicial; i <= xFinal; i++) {
            for (int j = yInicial; j <= yFinal; j++) {
                valorMedioRojo += imagen.matriz[ i][ j].getRed();
                valorMedioVerde += imagen.matriz[ i][ j].getGreen();
                valorMedioAzul += imagen.matriz[ i][ j].getBlue();
            }
        }

        valorMedioRojo /= totalPixeles;
        valorMedioVerde /= totalPixeles;
        valorMedioAzul /= totalPixeles;
        return new Color(valorMedioRojo, valorMedioVerde, valorMedioAzul);
    }

    /**
     * Calcula el menor divisor del número dado que sea mayor a 1.
     * @param numero al que se le buscará el divisor.
     * @return menor divisor mayor a uno del número
     */
    private int menorDivisorMayorAUno(int numero) {
        boolean encontrado = false;
        int divisor = 20;

// Si el número es par el divisor menor es 2
        if (numero % divisor == 0) {
            return divisor;
        } else {
// Si el número es impar le busca un divisor impar
            divisor = 6;
            while (divisor < numero && !encontrado) {
                if (numero % divisor == 0) {
                    encontrado = true;
                } else {
                    divisor += 13;
                }
            }
            return divisor;
        }
    }

    /**
     * Método que pixela el bitMap El pixelamiento consiste en dividir la imagen en pequeñas regiones de píxeles
     * y para cada una de esas regiones cambiar el color de los píxeles al color promedio
     * de dicha región
     * En este caso, la región se dimensiona con los divisores más pequeños del ancho y el alto de la imagen
     * @param imagen: imagen a pixelar
     */
    public Imagen desenfoqueGausiano(Imagen imagenes, int nivel) {
        try {
            for (int i = 0; i < imagenes.ancho; i++) {
                for (int j = 0; j < imagenes.alto; j++) {
                    int cont = 0;
                    int promedior = 0;
                    int promediog = 0;
                    int promediob = 0;
                    for (int x = 0 - nivel; x < nivel; x++) {
                        for (int y = 0 - nivel; y < nivel; y++) {
                            try {
                                promedior += (int) (imagenes.matriz[ i + x][ j + y].getRed());
                                promediog += (int) (imagenes.matriz[ i + x][ j + y].getGreen());
                                promediob += (int) (imagenes.matriz[ i + x][ j + y].getBlue());
                                cont++;
                            } catch (Exception e) {
                            }
                        }
                    }
                    try {
                        promedior /= cont;
                        promediog /= cont;
                        promediob /= cont;
                    } catch (Exception e) {
                    }
                    Color c = new Color(promedior, promediog, promediob);
                    imagenes.matriz[ i][ j] = c;

                }
            }
        } catch (Exception ex) {
            System.out.print(ex);
        }
        return imagenes;
    }

    public Image ajustarBrillo(Imagen inImage, int increasingFactor) {

        //size of input image
        int w = inImage.ancho;
        int h = inImage.alto;

        BufferedImage outImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);

        //Pixel by pixel navigation loop
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {


                //get the RGB component of input imge pixel
                Color color = new Color(inImage.matriz[ i][ j].getRGB());

                int r, g, b;

                //change the value of each component
                r = color.getRed() + increasingFactor;
                g = color.getGreen() + increasingFactor;
                b = color.getBlue() + increasingFactor;


                //r,g,b values which are out of the range 0 to 255 should set to 0 or 255
                if (r >= 256) {
                    r = 255;
                } else if (r < 0) {
                    r = 0;
                }

                if (g >= 256) {
                    g = 255;
                } else if (g < 0) {
                    g = 0;
                }

                if (b >= 256) {
                    b = 255;
                } else if (b < 0) {
                    b = 0;
                }

                //set output image pixel component
                outImage.setRGB(i, j, new Color(r, g, b).getRGB());

            }
        }
        ImageIcon imagen = new ImageIcon(outImage.getScaledInstance(400, -1, Image.SCALE_DEFAULT));
        return imagen.getImage();
    }

    //private BufferedImage foto;
//    private int r,g,b;
    //   private Color color;
    //   public invertir(){}
    /* Invierte los bytes de una imagen */
    public Image InvertirColor(Imagen imagen) {
        //size of input image
        int w = imagen.ancho;
        int h = imagen.alto;
        int r, g, b;
        BufferedImage outImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);

        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                //se obtiene el color del pixel
                Color color = new Color(imagen.matriz[ i][ j].getRGB());
                //se extraen los valores RGB
                r = color.getRed();
                g = color.getGreen();
                b = color.getBlue();
                //se coloca en la nueva imagen con los valores invertidos
                outImage.setRGB(i, j, new Color(255 - r, 255 - g, 255 - b).getRGB());
            }

        }
        ImageIcon imagenIcon = new ImageIcon(outImage.getScaledInstance(400, -1, Image.SCALE_DEFAULT));
        return imagenIcon.getImage();
    }

    public Imagen Opacidad(Imagen imagenes, int val) {

        try {
            for (int i = 0; i < imagenes.ancho; i++) {
                for (int j = 0; j < imagenes.alto; j++) {
                    Color c = new Color(imagenes.matriz[ i][ j].getRed(),
                            imagenes.matriz[ i][ j].getGreen(), imagenes.matriz[ i][ j].getBlue(), 255 - val);
                    imagenes.matriz[ i][ j] = c;
                }

            }

        } catch (Exception ex) {
            System.out.print(ex);
        }
        return imagenes;
    }

    public Imagen Segmentacion(Imagen imagenes, int val) {

        try {
            for (int i = 0; i < imagenes.ancho; i++) {
                for (int j = 0; j < imagenes.alto; j++) {

                    Color color = new Color(imagenes.matriz[ i][ j].getRGB());
                    int promedioRGB = (color.getRed() + color.getGreen() + color.getBlue() / 3);

                    if (promedioRGB < val) {
                        imagenes.matriz[ i][ j] = Color.BLACK;
                    } else {
                        imagenes.matriz[ i][ j] = Color.WHITE;
                    }
                }
            }

        } catch (Exception ex) {
            System.out.print(ex);
        }
        return imagenes;
    }
}
