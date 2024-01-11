/**
 * VentanaDialogo.java
 * 15 nov 2023 13:28:56
 * @author Lenny López Pérez

 */
package swing_c_p02_LopezPerezLenny;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

// TODO: Auto-generated Javadoc
/**
 * The Class VentanaDialogo.
 */
public class VentanaDialogo extends JDialog {

	/** The icono. */
	private ImageIcon icono;

	/**
	 * Instantiates a new ventana dialogo.
	 *
	 * @param ventanaPrincipal the ventana principal
	 */
	public VentanaDialogo(JFrame ventanaPrincipal) {
		super(ventanaPrincipal, "Alta pisos", true);
		icono = new ImageIcon(getClass().getResource("/recursos/foto.png"));
		Toolkit miPantalla = Toolkit.getDefaultToolkit();
		establecerPaneles();

		this.setSize(miPantalla.getScreenSize());
		this.setIconImage(icono.getImage());
		this.setVisible(true);
	}

	/**
	 * Establecer paneles.
	 */
	private void establecerPaneles() {
		PanelTitulo panelTitulo;
		panelTitulo = new PanelTitulo();
		PanelArrendador panelArrendador;
		panelArrendador = new PanelArrendador();
		PanelInmueble panelInmueble;
		panelInmueble = new PanelInmueble();
		PanelImagenes panelImagenes;
		panelImagenes = new PanelImagenes();
		PanelFichas panelFichas;
		panelFichas = new PanelFichas();
		PanelBotones panelBotones;
		panelBotones = new PanelBotones();

		JPanel contenedor = new JPanel(new GridLayout(3, 1));
		contenedor.add(panelArrendador);
		JPanel contenedorInmueble = new JPanel(new GridLayout(1, 2));
		contenedorInmueble.add(panelInmueble);
		contenedorInmueble.add(panelImagenes);
		contenedor.add(contenedorInmueble);
		contenedor.add(panelFichas);

		this.setLayout(new BorderLayout());
		this.add(panelTitulo, BorderLayout.PAGE_END);
		this.add(contenedor);
		this.add(panelTitulo, BorderLayout.PAGE_START);
		this.add(panelBotones, BorderLayout.PAGE_END);
	}
}
