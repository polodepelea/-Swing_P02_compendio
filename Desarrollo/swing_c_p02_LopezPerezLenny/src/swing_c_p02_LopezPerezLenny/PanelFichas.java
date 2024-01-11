package swing_c_p02_LopezPerezLenny;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.BevelBorder;

// TODO: Auto-generated Javadoc
/**
 * The Class PanelFichas.
 * 22 nov 2023 12:13:46
 * @author Lenny López Pérez
 */
public class PanelFichas extends JTabbedPane {
	
	/** The panel arrendador. */
	static JPanel panelArrendador = new JPanel();
	
	/** The panel inmueble. */
	static JPanel panelInmueble = new JPanel();

	/**
	 * Instantiates a new panel fichas.
	 */
	public PanelFichas() {
		addTab("Panel Arrendador", null, panelArrendador, "Muestra los datos del Arrendador");
		addTab("Panel Inmueble", null, panelInmueble, "Muestra los datos del Inmueble");
		this.setBackground(Color.WHITE);
		panelArrendador.setBackground(Color.BLACK);
		panelInmueble.setBackground(Color.BLACK);
		
		

	}

}
