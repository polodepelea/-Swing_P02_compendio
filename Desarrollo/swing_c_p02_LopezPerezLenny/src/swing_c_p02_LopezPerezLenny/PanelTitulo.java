/**
 * PanelTitulo.java
 * 22 nov 2023 11:09:05
 * @author Lenny López Pérez

 */
package swing_c_p02_LopezPerezLenny;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.HexFormat;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

// TODO: Auto-generated Javadoc
/**
 * The Class PanelTitulo.
 */
public class PanelTitulo extends JPanel {
    
    /** The etiqueta titulo. */
    private JLabel etiquetaTitulo;

    /**
     * Instantiates a new panel titulo.
     */
    public PanelTitulo() {
        establecerTitulo();

        this.setBackground(Color.BLUE);
        this.setBorder(BorderFactory.createLineBorder(Color.decode("#7d2181"), 3)); 

        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.add(etiquetaTitulo);
        this.setBackground(Color.BLACK);
    }

    /**
     * Establecer titulo.
     */
    private void establecerTitulo() {
        etiquetaTitulo = new JLabel("Lenny Sofas");
        etiquetaTitulo.setFont(new Font("Arial", Font.BOLD, 24)); 
        etiquetaTitulo.setForeground(Color.WHITE); 
    }
}
