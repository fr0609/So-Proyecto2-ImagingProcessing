/*
 * Classname CargarImagenes
 *  
 * Version information 1.0
 *
 * Date 5/18/2013
 * http://www.kodejava.org/browse/75.html
 * http://stackoverflow.com/questions/4208208/java-util-concurrent-examples-tutorial-and-code
 * http://www.ibm.com/developerworks/ssa/java/library/j-5things4/
 * technicalmumbojumbo.wordpress.com/2011/05/16/java-util-concurrent-executors-thread-pools-cache-fixed-scheduled-executorcompletionservice-tutorial/
 * Copyright notice
 */
package ar.lefunes.cargarimagenes;

import java.awt.Image;

import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * @author fr0609
 */
public class CargaImagenes extends javax.swing.JFrame {
    //instanciamos la clase metodos
    Metodos ins= new Metodos();


    /**
     * Incializa la ventana
     */
    public CargaImagenes() {
        initComponents();
          //  jSpliterSeleccionarNivel.show(false);
     
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        final javax.swing.JLabel lbInterna = new javax.swing.JLabel();
        final javax.swing.JLabel lbExterna = new javax.swing.JLabel();
        botonIniciarProceso = new javax.swing.JButton();
        jComboBoxSeleccionarOpcion = new javax.swing.JComboBox();
        jSpliterSeleccionarNivel = new javax.swing.JSlider();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Carga de Imagenes");

        jPanelConFondo1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lbInterna.setFont(new java.awt.Font("Tahoma", 1, 18));
        lbInterna.setForeground(new java.awt.Color(255, 204, 102));
        lbInterna.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbInterna.setText("Entrada");

        javax.swing.GroupLayout jPanelConFondo1Layout = new javax.swing.GroupLayout(jPanelConFondo1);
        jPanelConFondo1.setLayout(jPanelConFondo1Layout);
        jPanelConFondo1Layout.setHorizontalGroup(
            jPanelConFondo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelConFondo1Layout.createSequentialGroup()
                .addGap(163, 163, 163)
                .addComponent(lbInterna, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(261, Short.MAX_VALUE))
        );
        jPanelConFondo1Layout.setVerticalGroup(
            jPanelConFondo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelConFondo1Layout.createSequentialGroup()
                .addGap(242, 242, 242)
                .addComponent(lbInterna, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                .addGap(291, 291, 291))
        );

        jPanelConFondo2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lbExterna.setFont(new java.awt.Font("Tahoma", 1, 18));
        lbExterna.setForeground(new java.awt.Color(255, 204, 102));
        lbExterna.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbExterna.setText("Salida");

        javax.swing.GroupLayout jPanelConFondo2Layout = new javax.swing.GroupLayout(jPanelConFondo2);
        jPanelConFondo2.setLayout(jPanelConFondo2Layout);
        jPanelConFondo2Layout.setHorizontalGroup(
            jPanelConFondo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelConFondo2Layout.createSequentialGroup()
                .addContainerGap(170, Short.MAX_VALUE)
                .addComponent(lbExterna, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(150, 150, 150))
        );
        jPanelConFondo2Layout.setVerticalGroup(
            jPanelConFondo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelConFondo2Layout.createSequentialGroup()
                .addGap(210, 210, 210)
                .addComponent(lbExterna, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                .addGap(246, 246, 246))
        );

        botonIniciarProceso.setText("Aplicar");
        botonIniciarProceso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonIniciarProcesoActionPerformed(evt);
            }
        });

        jComboBoxSeleccionarOpcion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Escala Grises", "Sepia", "Opacidad", "Invertir Colores", "Desenfoque Gausiano", "Ajuste Brillo", "Compresion", "Segmentacion", "Textura" }));
        jComboBoxSeleccionarOpcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxSeleccionarOpcionActionPerformed(evt);
            }
        });

        jSpliterSeleccionarNivel.setMajorTickSpacing(1);
        jSpliterSeleccionarNivel.setMaximum(10);
        jSpliterSeleccionarNivel.setPaintLabels(true);
        jSpliterSeleccionarNivel.setPaintTicks(true);
        jSpliterSeleccionarNivel.setEnabled(false);
        jSpliterSeleccionarNivel.setFocusCycleRoot(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelConFondo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94)
                .addComponent(jPanelConFondo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jComboBoxSeleccionarOpcion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonIniciarProceso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSpliterSeleccionarNivel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelConFondo2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelConFondo1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(68, 68, 68))
            .addGroup(layout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addComponent(jComboBoxSeleccionarOpcion, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jSpliterSeleccionarNivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(botonIniciarProceso, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(258, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void botonIniciarProcesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonIniciarProcesoActionPerformed
    //almacena el jfilechooser
    JPanel panel = new JPanel();
    //seleccionar archivo
    final JFileChooser fc = new JFileChooser();
    //directorio predeterminado
    File directorio_Abrir = new File("C:/Users/fr0609/Pictures");
    fc.setCurrentDirectory(directorio_Abrir);
    //filtrar a solo imagenes
    FileFilter imageFilter = new FileNameExtensionFilter(
            "Image files", ImageIO.getReaderFileSuffixes());
    //activa filtro
    fc.setFileFilter(imageFilter);
    fc.setAcceptAllFileFilterUsed(false);
    int Correcto = fc.showOpenDialog(panel);
    //tipo de filtro a ejecutar Ejp: sepia,escala grises
    int opt = jComboBoxSeleccionarOpcion.getSelectedIndex();
   // String tipoFiltro = jComboBoxSeleccionarOpcion.getSelectedItem().toString();
    int nivel = jSpliterSeleccionarNivel.getValue();
    // float nivel=jSpliterSeleccionarNivel.getValue();
   System.out.println(opt);
   System.out.println(nivel);

    if (Correcto == JFileChooser.APPROVE_OPTION) {  //correcto
        ins.Contruir(jPanelConFondo1, jPanelConFondo2, fc, opt, nivel); //ejecuta funcion principal
    }
    System.out.print(("Procesos Terminado"));
//fc.show();
// TODO add your handling code here:
}//GEN-LAST:event_botonIniciarProcesoActionPerformed

private void jComboBoxSeleccionarOpcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxSeleccionarOpcionActionPerformed
String tipoFiltro=jComboBoxSeleccionarOpcion.getSelectedItem().toString();
jSpliterSeleccionarNivel.enable(false);
        if ((tipoFiltro.equals("Opacidad")) || (tipoFiltro.equals("Sepia"))
            || (tipoFiltro.equals("Desenfoque Gausiano"))
            || (tipoFiltro.equals("Ajuste Brillo"))
            || (tipoFiltro.equals("Segmetacion"))) {
        jSpliterSeleccionarNivel.enable(true);

    }
}//GEN-LAST:event_jComboBoxSeleccionarOpcionActionPerformed

/**
 * 
 * @param args
 */
public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                CargaImagenes ci = new CargaImagenes();
                ci.setLocationRelativeTo(null);
                ci.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonIniciarProceso;
    public javax.swing.JComboBox jComboBoxSeleccionarOpcion;
    private final ar.lefunes.jpanelconfondo.JPanelConFondo jPanelConFondo1 = new ar.lefunes.jpanelconfondo.JPanelConFondo();
    private final ar.lefunes.jpanelconfondo.JPanelConFondo jPanelConFondo2 = new ar.lefunes.jpanelconfondo.JPanelConFondo();
    public javax.swing.JSlider jSpliterSeleccionarNivel;
    // End of variables declaration//GEN-END:variables
}
