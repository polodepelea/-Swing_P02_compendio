package swing_c_p02_LopezPerezLenny;

import java.awt.Color;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;
import javax.swing.JTextArea;

// TODO: Auto-generated Javadoc
/**
 * The Class PanelBotones.
 * 22 nov 2023 12:13:46
 * @author Lenny López Pérez
 */
public class PanelBotones extends JPanel implements ActionListener {
	
	/** The boton imprimir. */
	private JButton botonImprimir = new JButton("Imprimir a Documento");
	
	/** The boton nuevo. */
	private JButton botonNuevo = new JButton("Nuevo");
	
	/** The boton guardar. */
	private JButton botonGuardar = new JButton("Guardar");
	
	/** The boton color. */
	private JButton botonColor = new JButton("Cambiar Color");
	
	/** The mensaje area. */
	private JTextArea mensajeArea = new JTextArea();
	
	/** The mensaje in. */
	private JTextArea mensajeIn = new JTextArea();
	


	/** The ventana. */
	Ventana ventana;

	/**
	 * Instantiates a new panel botones.
	 */
	public PanelBotones() {
		botonImprimir.addActionListener(this);
		botonNuevo.addActionListener(this);
		botonGuardar.addActionListener(this);
		botonColor.addActionListener(this);

		this.add(botonImprimir);
		this.add(botonNuevo);
		this.add(botonGuardar);
		this.add(botonColor);
		
		
	}

	/**
	 * Action performed.
	 *
	 * @param e the e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == botonImprimir) {
			mostrarMensajeArrendador();
			mostrarMensajeInmueble();
		}
		if (e.getSource() == botonNuevo) {
			PanelArrendador.limpiarCampos();
			PanelInmueble.limpiarCampos();
			mensajeArea.setText("");
			mensajeIn.setText("");
			Window ventanaPadre = SwingUtilities.getWindowAncestor(this);
			ventanaPadre.dispose();
			new VentanaDialogo(null);
		}
		if (e.getSource() == botonGuardar) {
			mostrarMensajeGuardar();
		}
		if (e.getSource() == botonColor) {
			elegirColor();
		}

	}

	/**
	 * Elegir color.
	 */
	private void elegirColor() {
		Color color = JColorChooser.showDialog(this, "Seleccione un Color", getBackground());
		if (color != null) {
			this.setBackground(color);
		}
	}

	/**
	 * Mostrar mensaje guardar.
	 */
	private void mostrarMensajeGuardar() {
		if (!PanelArrendador.validarArrendador().isEmpty() && !PanelInmueble.validarInmueble().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Registro Guardado", "Informacion", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	/**
	 * Mostrar mensaje inmueble.
	 */
	private void mostrarMensajeInmueble() {
		PanelFichas.panelInmueble.removeAll();

		String mensaje = PanelInmueble.validarInmueble();

		if (mensaje.isEmpty()) {
			return;
		}

		mensajeIn = new JTextArea(mensaje);
		mensajeIn.setForeground(Color.WHITE);
		mensajeIn.setBackground(Color.BLACK);


		mensajeIn.setColumns(40);
		mensajeIn.setRows(10);

		Font font = new Font("Arial", Font.PLAIN, 19);
		mensajeIn.setFont(font);

		mensajeIn.setEditable(false);
		mensajeIn.setLineWrap(true);
		mensajeIn.setWrapStyleWord(true);

		PanelFichas.panelInmueble.add(new JScrollPane(mensajeIn));

		PanelFichas.panelInmueble.revalidate();
		PanelFichas.panelInmueble.repaint();
	}

	/**
	 * Mostrar mensaje arrendador.
	 */
	private void mostrarMensajeArrendador() {
		PanelFichas.panelArrendador.removeAll();

		String mensaje = PanelArrendador.validarArrendador();

		if (mensaje.isEmpty()) {
			return;
		}

		mensajeArea = new JTextArea(mensaje);
		mensajeArea.setForeground(Color.WHITE);
		mensajeArea.setBackground(Color.BLACK);


		mensajeArea.setColumns(40);
		mensajeArea.setRows(10);

		Font font = new Font("Arial", Font.PLAIN, 19);
		mensajeArea.setFont(font);

		mensajeArea.setEditable(false);
		mensajeArea.setLineWrap(true);
		mensajeArea.setWrapStyleWord(true);

		PanelFichas.panelArrendador.add(new JScrollPane(mensajeArea));

		PanelFichas.panelArrendador.revalidate();
		PanelFichas.panelArrendador.repaint();
	}
}
