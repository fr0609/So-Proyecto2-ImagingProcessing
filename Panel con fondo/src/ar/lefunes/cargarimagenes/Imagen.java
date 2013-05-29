/*
 * Classname Imagen
 * 
 * Version information 1.0
 *
 * Date 5/18/2013
 * 
 * Copyright notice
 */
package ar.lefunes.cargarimagenes;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author fr0609
 */
public class Imagen {
    //Matriz para representar pixeles
    public Color matriz[][];
    // ancho de la imagen
    public int ancho;
    // alto de la imagen
    public int alto;
/**
     * Inicializado de los atributos
     */
    public Imagen() {
        matriz = null;
        ancho = 0;
        alto = 0;
    }
/**
     * Constructor de la imagen
     * @param ruta: imagen a leer 
     * @throws IOException 
     */
    public Imagen(String ruta) throws IOException {
        File archivo = new File(ruta);
        BufferedImage jpg;

        try {
            jpg = ImageIO.read(archivo);
        } catch (IOException e) {
            throw new IOException("No se encuentra la imagen");
        }

        ancho = jpg.getWidth();
        alto = jpg.getHeight();
        matriz = new Color[ancho][alto];

        for (int i = 0; i < ancho; i++) {
            for (int j = 0; j < alto; j++) {
                matriz[ i][ j] = new Color(jpg.getRGB(i, j));
            }
        }
    }
/**
     * Transformar la imagen para poder ser mostrada en pantalla 
     * @return imagen 
     */
    public ImageIcon dibujarImagen() {

        BufferedImage Filtroglobal = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_RGB);
        for (int i = 0; i < ancho; i++) {
            for (int j = 0; j < alto; j++) {
                Filtroglobal.setRGB(i, j, matriz[ i][ j].getRGB());
            }
        }
        ImageIcon imagen = new ImageIcon(Filtroglobal.getScaledInstance(400, -1, Image.SCALE_DEFAULT));
        return imagen;

    }

}
