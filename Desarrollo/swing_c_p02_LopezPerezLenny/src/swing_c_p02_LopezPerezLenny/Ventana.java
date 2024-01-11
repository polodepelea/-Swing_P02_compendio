/**
 * Ventana.java
 * 5 oct 2023 12:01:17
 * @author Lenny López Pérez

 */
package swing_c_p02_LopezPerezLenny;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

// TODO: Auto-generated Javadoc
/**
 * The Class Ventana.
 */
public class Ventana extends JFrame implements ActionListener {
	
	/** The menu item salir. */
	private JMenuItem menuItemSalir;
	
	/** The menu item alta. */
	private JMenuItem menuItemAlta;
	
	/** The menu item baja. */
	private JMenuItem menuItemBaja;
	
	/** The menu item acerca. */
	private JMenuItem menuItemAcerca;
	
	/** The icono. */
	private ImageIcon icono;
	
	/** The tamano pantalla. */
	private Dimension tamanoPantalla;
	
	/** The panel contenedor. */
	private JPanel panelContenedor;
	
	/** The etiqueta alta. */
	private JLabel etiquetaAlta = new JLabel(
			new ImageIcon(getClass().getResource("/recursos/boton-agregar (1).png")));
	
	/** The etiqueta baja. */
	private JLabel etiquetaBaja = new JLabel(
			new ImageIcon(getClass().getResource("/recursos/contenedor-de-basura (1).png")));

	/** The boton alta. */
	private JButton botonAlta = new JButton();
	
	/** The boton baja. */
	private JButton botonBaja = new JButton();

	/**
	 * Instantiates a new ventana.
	 */
	public Ventana() {
		super("Gestión Apartamentos Turísticos Lenny Sofas");
		icono = new ImageIcon(getClass().getResource("/recursos/foto.png"));
		Toolkit miPantalla = Toolkit.getDefaultToolkit();
		tamanoPantalla = miPantalla.getScreenSize();

		ponerMenu();
		ponerBotones();

		this.add(panelContenedor);
		this.setIconImage(icono.getImage());
		this.setLocation(tamanoPantalla.width / 4, tamanoPantalla.height / 4);
		this.setSize(tamanoPantalla.width / 2, tamanoPantalla.height / 2);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	/**
	 * Poner botones.
	 */
	private void ponerBotones() {
		panelContenedor = new JPanel(new GridLayout(1, 2));

		botonAlta.addActionListener(this);
		botonAlta.setLayout(new BorderLayout());
		botonAlta.add(etiquetaAlta, BorderLayout.CENTER);
		botonAlta.setBackground(Color.BLACK);
		panelContenedor.add(botonAlta);

		botonBaja.addActionListener(this);
		botonBaja.setLayout(new BorderLayout());
		botonBaja.add(etiquetaBaja, BorderLayout.CENTER);
		botonBaja.setBackground(Color.BLACK);
		panelContenedor.add(botonBaja);
	}

	/**
	 * Poner menu.
	 */
	private void ponerMenu() {
		JMenuBar barraMenu;
		JMenu menuAyuda;
		JMenu menuRegistro;
		JMenu menuArchivo;

		menuArchivo = new JMenu("Archivo");
		menuArchivo.setForeground(Color.black);
		menuItemSalir = new JMenuItem("Salir");
		menuItemSalir.addActionListener(this);
		menuArchivo.add(menuItemSalir);

		menuRegistro = new JMenu("Registro");
		menuRegistro.setForeground(Color.black);
		menuRegistro.setMnemonic(KeyEvent.VK_S);
		menuItemAlta = new JMenuItem("Alta Pisos");
		menuItemAlta.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.VK_CONTROL));
		menuItemAlta.addActionListener(this);

		menuItemBaja = new JMenuItem("Baja Pisos");
		menuItemBaja.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, KeyEvent.VK_CONTROL));
		menuItemBaja.addActionListener(this);
		menuRegistro.add(menuItemAlta);
		menuRegistro.add(menuItemBaja);

		menuAyuda = new JMenu("Ayuda");
		menuAyuda.setForeground(Color.black);
		menuItemAcerca = new JMenuItem("Acerca de...");
		menuItemAcerca.addActionListener(this);
		menuAyuda.add(menuItemAcerca);

		barraMenu = new JMenuBar();
		barraMenu.add(menuArchivo);
		barraMenu.add(menuRegistro);
		barraMenu.add(menuAyuda);
		barraMenu.setBackground(Color.decode("#7d2181"));

		setJMenuBar(barraMenu);
	}

	/**
	 * Action performed.
	 *
	 * @param e the e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == menuItemSalir) {
			System.exit(0);
		}
		if (e.getSource() == menuItemAlta || e.getSource() == botonAlta) {
			new VentanaDialogo(this);
		}
		if (e.getSource() == menuItemBaja || e.getSource() == botonBaja) {
			JOptionPane.showMessageDialog(null, "Esta opción no está desarrollada", "Información",
					JOptionPane.DEFAULT_OPTION);
		}
		if (e.getSource() == menuItemAcerca) {
			String mensaje = "<html><div style='text-align: center;'>"
					+ "<h1 style='color: #007BFF;'>Acerca de Lenny Sofas</h1>"
					+ "<p>Bienvenido a la aplicación de Gestión de Apartamentos Turísticos de Lenny Sofas. "
					+ "Esta herramienta ha sido <p>desarrollada para facilitar la administración eficiente "
					+ "de la información relacionada con los apartamentos turísticos ofrecidos por nuestra empresa.</p>"
					+ "<br><p style='font-weight: bold; text-decoration: underline;'>Características Principales:</p>"
					+ "<ul>" + "<li>Registro y gestión de datos de arrendadores.</li>"
					+ "<li>Detalles completos de los inmuebles, incluyendo características, imágenes y tarifas.</li>"
					+ "<li>Cálculo automático del precio mínimo basado en diversas opciones de alojamiento.</li>"
					+ "</ul>"
					+ "<p style='font-weight: bold; text-decoration: underline;'>Desarrollado por Lenny Sofas:</p>"
					+ "<p>Esta aplicación ha sido diseñada y desarrollada por el equipo de Lenny Sofas para "
					+ "brindar una experiencia de usuario intuitiva y eficaz. "
					+ "</p><p>Estamos comprometidos a proporcionar soluciones innovadoras y de alta calidad para "
					+ "la gestión de apartamentos turísticos.</p>"
					+ "<p style='color: #28a745; font-weight: bold;'>¡Gracias por elegir Lenny Sofas!</p><br>"
					+ "</div></html>";

			JOptionPane.showMessageDialog(null, mensaje, "Información", JOptionPane.DEFAULT_OPTION);
		}
	}
}
