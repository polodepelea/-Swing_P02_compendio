/**
 * PanelImagenes.java
 * 23 nov 2023 11:10:02
 * @author Lenny López Pérez

 */
package swing_c_p02_LopezPerezLenny;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

/**
 * 
 */
import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class PanelImagenes.
 */
public class PanelImagenes extends JPanel implements ActionListener {
    
    /** The imagenes. */
    private List<JLabel> imagenes = new ArrayList<>();
    
    /** The imagen actual. */
    private int imagenActual = 0;

    /** The boton cambiar imagen. */
    private JButton botonCambiarImagen = new JButton("Cambiar de imagen");
    
    /** The etiqueta imagen. */
    private JLabel etiquetaImagen = new JLabel(
            new ImageIcon(new ImageIcon(getClass().getResource("/recursos/piso1.jpg")).getImage().getScaledInstance(400,
            		300, Image.SCALE_DEFAULT)));

    /**
     * Instantiates a new panel imagenes.
     */
    public PanelImagenes() {
        this.setBackground(Color.decode("#7d2181"));
        this.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK, 3), getBorder()));
        this.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        this.add(etiquetaImagen, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1; 
        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.BOTH;
        botonCambiarImagen.setBackground(Color.WHITE);
        botonCambiarImagen.addActionListener(this);
        this.add(botonCambiarImagen, gbc);

        imagenes.add(new JLabel(new ImageIcon(new ImageIcon(getClass().getResource("/recursos/piso1.jpg")).getImage()
                .getScaledInstance(400,
                		300, Image.SCALE_DEFAULT))));
        imagenes.add(new JLabel(new ImageIcon(new ImageIcon(getClass().getResource("/recursos/piso2.jpg")).getImage()
                .getScaledInstance(400,
                		300, Image.SCALE_DEFAULT))));
        imagenes.add(new JLabel(new ImageIcon(new ImageIcon(getClass().getResource("/recursos/piso3.jpg")).getImage()
                .getScaledInstance(400,
                		300, Image.SCALE_DEFAULT))));
    }

    /**
     * Action performed.
     *
     * @param e the e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonCambiarImagen) {
            imagenActual = (imagenActual + 1) % imagenes.size();
            cambiarImagen();
        }
    }

    /**
     * Cambiar imagen.
     */
    private void cambiarImagen() {
        etiquetaImagen.setIcon(new ImageIcon(((ImageIcon) imagenes.get(imagenActual).getIcon()).getImage()
                .getScaledInstance(400,
                		300, Image.SCALE_DEFAULT)));
    }
}
