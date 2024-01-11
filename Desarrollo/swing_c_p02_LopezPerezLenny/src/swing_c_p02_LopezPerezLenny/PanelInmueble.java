/**
 * PanelInmueble.java
 * 22 nov 2023 12:33:59
 * @author Lenny López Pérez

 */
package swing_c_p02_LopezPerezLenny;

import javax.swing.JRadioButton;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.BevelBorder;

// TODO: Auto-generated Javadoc
/**
 * The Class PanelInmueble.
 * 22 nov 2023 12:13:46
 * @author Lenny López Pérez
 */
public class PanelInmueble extends JPanel {
	
	/** The etiqueta direccion. */
	private JLabel etiquetaDireccion = new JLabel();
	
	/** The campo direccion. */
	private static JFormattedTextField campoDireccion = new JFormattedTextField();

	/** The etiqueta provincia. */
	private JLabel etiquetaProvincia = new JLabel();
	
	/** The provincias. */
	private static String[] provincias = { "Alava", "Albacete", "Alicante", "Almeria", "Asturias", "Avila", "Badajoz",
		    "Barcelona", "Burgos", "Caceres", "Cadiz", "Cantabria", "Castellon", "Ciudad Real", "Cordoba", "Cuenca",
		    "Gerona", "Granada", "Guadalajara", "Guipuzcoa", "Huelva", "Huesca", "Islas Balears", "Jaen", "La Coruna",
		    "La Rioja", "Las Palmas", "Leon", "Lerida", "Lugo", "Madrid", "Malaga", "Murcia", "Navarra", "Orense",
		    "Palencia", "Pontevedra", "Salamanca", "Santa Cruz de Tenerife", "Segovia", "Sevilla", "Soria", "Tarragona",
		    "Teruel", "Toledo", "Valencia", "Valladolid", "Vizcaya", "Zamora", "Zaragoza" };

	
	/** The modelo provincias. */
	private static DefaultComboBoxModel<String> modeloProvincias = new DefaultComboBoxModel<>(provincias);
	
	/** The combo box provincias. */
	private static JComboBox<String> comboBoxProvincias = new JComboBox<>(modeloProvincias);

	/** The etiqueta fecha alta. */
	private JLabel etiquetaFechaAlta = new JLabel();
	
	/** The campo fecha alta. */
	private static JFormattedTextField campoFechaAlta = new JFormattedTextField();

	/** The etiqueta fecha disponibilidad. */
	private JLabel etiquetaFechaDisponibilidad = new JLabel();
	
	/** The campo fecha disponibilidad. */
	private static JFormattedTextField campoFechaDisponibilidad = new JFormattedTextField();

	/** The etiqueta num huespedes. */
	private JLabel etiquetaNumHuespedes = new JLabel();
	
	/** The spinner num huespedes. */
	private static JSpinner spinnerNumHuespedes = new JSpinner(new SpinnerNumberModel(0, 0, 8, 1));

	/** The etiqueta num dormitorios. */
	private JLabel etiquetaNumDormitorios = new JLabel();
	
	/** The spinner num dormitorios. */
	private static JSpinner spinnerNumDormitorios = new JSpinner(new SpinnerNumberModel(0, 0, 4, 1));

	/** The etiqueta num banios. */
	private JLabel etiquetaNumBanios = new JLabel();
	
	/** The spinner num banios. */
	private static JSpinner spinnerNumBanios = new JSpinner(new SpinnerNumberModel(0, 0, 2, 1));

	/** The etiqueta num camas. */
	private JLabel etiquetaNumCamas = new JLabel();
	
	/** The spinner num camas. */
	private static JSpinner spinnerNumCamas = new JSpinner(new SpinnerNumberModel(0, 0, 4, 1));

	/** The etiqueta tipos camas. */
	private JLabel etiquetaTiposCamas = new JLabel();
	
	/** The radio cama simple. */
	private static JRadioButton radioCamaSimple = new JRadioButton("Cama Simple");
	
	/** The radio cama doble. */
	private static JRadioButton radioCamaDoble = new JRadioButton("Cama Doble");
	
	/** The radio sofa cama. */
	private static JRadioButton radioSofaCama = new JRadioButton("Sofá Cama");
	
	/** The grupo camas. */
	static ButtonGroup grupoCamas = new ButtonGroup();

	/** The etiqueta ninos. */
	private JLabel etiquetaNinos = new JLabel();
	
	/** The check ninos. */
	private static JCheckBox checkNinos = new JCheckBox();

	/** The fecha actual. */
	private LocalDateTime fechaActual = LocalDateTime.now();
	
	/** The formato fecha. */
	private DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("yyyy/MM/dd");

	/** The etiqueta edad. */
	private JLabel etiquetaEdad = new JLabel();
	
	/** The spinner edad. */
	private static JSpinner spinnerEdad = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));

	/** The campo extras. */
	private static JTextField campoExtras = new JTextField();

	/** The precio minimo. */
	private static JLabel precioMinimo = new JLabel();

	/** The precio por cama doble. */
	private int precioPorCamaDoble = 20;
	
	/** The precio por sofa cama. */
	private int precioPorSofaCama = 15;
	
	/** The precio por cama simple. */
	private int precioPorCamaSimple = 15;
	
	/** The precio por banio. */
	private int precioPorBanio = 25;
	
	/** The precio por cuna O cama supletoria. */
	private int precioPorCunaOCamaSupletoria = 12;

	/**
	 * Instantiates a new panel inmueble.
	 */
	public PanelInmueble() {
		inicializarFormulario();
		this.setBackground(Color.decode("#7d2181"));
        this.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK, 3), getBorder()));
	}

	/**
	 * Inicializar formulario.
	 */
	private void inicializarFormulario() {
		setLayout(new GridLayout(0, 2, 10, 10));

		etiquetaDireccion.setText("Dirección: ");
		etiquetaDireccion.setForeground(Color.BLACK);
		this.add(etiquetaDireccion);
		this.add(campoDireccion);

		etiquetaProvincia.setText("Provincia: ");
		etiquetaProvincia.setForeground(Color.BLACK);
		this.add(etiquetaProvincia);
		this.add(comboBoxProvincias);

		etiquetaFechaAlta.setText("Fecha de alta: ");
		etiquetaFechaAlta.setForeground(Color.BLACK);
		campoFechaAlta.setText(formatoFecha.format(fechaActual));
		campoFechaAlta.setEditable(false);
		this.add(etiquetaFechaAlta);
		this.add(campoFechaAlta);

		etiquetaFechaDisponibilidad.setText("Fecha final de disponibilidad: ");
		etiquetaFechaDisponibilidad.setForeground(Color.BLACK);
		campoFechaDisponibilidad.setText(formatoFecha.format(fechaActual.plusYears(1)));
		campoFechaDisponibilidad.setEditable(false);
		this.add(etiquetaFechaDisponibilidad);
		this.add(campoFechaDisponibilidad);

		etiquetaNumHuespedes.setText("Nº de huéspedes: ");
		etiquetaNumHuespedes.setForeground(Color.BLACK);
		this.add(etiquetaNumHuespedes);
		this.add(spinnerNumHuespedes);

		etiquetaNumDormitorios.setText("Nº de dormitorios: ");
		etiquetaNumDormitorios.setForeground(Color.BLACK);
		this.add(etiquetaNumDormitorios);
		this.add(spinnerNumDormitorios);

		etiquetaNumBanios.setText("Nº de baños: ");
		etiquetaNumBanios.setForeground(Color.BLACK);

		this.add(etiquetaNumBanios);
		this.add(spinnerNumBanios);

		etiquetaNumCamas.setText("Nº de camas: ");
		etiquetaNumCamas.setForeground(Color.BLACK);

		this.add(etiquetaNumCamas);
		this.add(spinnerNumCamas);

		etiquetaTiposCamas.setText("Tipo de camas: ");
		etiquetaTiposCamas.setForeground(Color.BLACK);

		radioCamaSimple.setEnabled(false);
		radioCamaSimple.setBackground(Color.decode("#7d2181"));
		radioCamaSimple.setForeground(Color.BLACK);
		radioCamaDoble.setEnabled(false);
		radioCamaDoble.setBackground(Color.decode("#7d2181"));
		radioCamaDoble.setForeground(Color.BLACK);
		radioSofaCama.setEnabled(false);
		radioSofaCama.setBackground(Color.decode("#7d2181"));
		radioSofaCama.setForeground(Color.BLACK);

		grupoCamas.add(radioCamaSimple);
		grupoCamas.add(radioCamaDoble);
		grupoCamas.add(radioSofaCama);

		this.add(etiquetaTiposCamas);
		this.add(radioCamaSimple);
		this.add(radioCamaDoble);
		this.add(radioSofaCama);

		etiquetaNinos.setText("¿Niños?: ");
		etiquetaNinos.setForeground(Color.BLACK);
		checkNinos.setBackground(Color.decode("#7d2181"));

		this.add(etiquetaNinos);
		this.add(checkNinos);

		etiquetaEdad.setText("Edad niños: ");
		etiquetaEdad.setForeground(Color.BLACK);

		this.add(etiquetaEdad);

		spinnerEdad.setEnabled(false);
		this.add(spinnerEdad);

		campoExtras.setEnabled(false);
		this.add(campoExtras);

		precioMinimo.setText("Precio minimo:");
		precioMinimo.setEnabled(false);
		this.add(precioMinimo);

		agregarEventos();
	}

	/**
	 * Agregar eventos.
	 */
	private void agregarEventos() {
		spinnerNumCamas.addChangeListener(e -> actualizarCamasDisponibles());

		checkNinos.addActionListener(e -> {
			spinnerEdad.setEnabled(checkNinos.isSelected());
			campoExtras.setEnabled(checkNinos.isSelected());
			actualizarPrecioMinimo();
		});

		radioCamaDoble.addActionListener(e -> actualizarPrecioMinimo());

		radioSofaCama.addActionListener(e -> actualizarPrecioMinimo());

		radioCamaSimple.addActionListener(e -> actualizarPrecioMinimo());

		campoExtras.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				actualizarExtras();
				actualizarPrecioMinimo();
			}
		});

		spinnerNumBanios.addChangeListener(e -> actualizarPrecioMinimo());
	}

	/**
	 * Actualizar precio minimo.
	 */
	private void actualizarPrecioMinimo() {
		int precioTotal = 0;

		if (radioCamaDoble.isSelected()) {
			precioTotal += precioPorCamaDoble;
		}

		if (radioSofaCama.isSelected()) {
			precioTotal += precioPorSofaCama;
		}

		if (radioCamaSimple.isSelected()) {
			precioTotal += precioPorCamaSimple;
		}

		int numBanios = (int) spinnerNumBanios.getValue();
		precioTotal += numBanios * precioPorBanio;

		if (campoExtras.isEnabled()) {
			precioTotal += precioPorCunaOCamaSupletoria;
		}

		precioMinimo.setText("Precio mínimo: " + precioTotal + "$");
	}

	/**
	 * Actualizar camas disponibles.
	 */
	private void actualizarCamasDisponibles() {
		radioCamaSimple.setEnabled(false);
		radioCamaDoble.setEnabled(false);
		radioSofaCama.setEnabled(false);

		int numCamas = (int) spinnerNumCamas.getValue();

		if (numCamas >= 1) {
			radioCamaSimple.setEnabled(true);
		}
		if (numCamas >= 2) {
			radioCamaDoble.setEnabled(true);
		}
		if (numCamas >= 3) {
			radioSofaCama.setEnabled(true);
		}
	}

	/**
	 * Actualizar extras.
	 */
	private void actualizarExtras() {
		if ((int) spinnerEdad.getValue() >= 0 && (int) spinnerEdad.getValue() <= 3) {
			campoExtras.setText("Cuna");
		} else if ((int) spinnerEdad.getValue() >= 4 && (int) spinnerEdad.getValue() <= 10) {
			campoExtras.setText("Cama supletoria pequeña");
		}
	}

	/**
	 * Validar inmueble.
	 *
	 * @return the string
	 */
	public static String validarInmueble() {
		String mensajeError = "";
		String mensaje = "";

		if (campoDireccion.getText().trim().isEmpty()) {
			mensajeError += "El campo Dirección no puede estar vacío.\n";
		}
		if ((int) spinnerNumHuespedes.getValue() == 0) {
			mensajeError += "El campo Numero Huespedes no puede estar vacío.\n";
		}
		if ((int) spinnerNumDormitorios.getValue() == 0) {
			mensajeError += "El campo Numero Dormitorios no puede estar vacío.\n";
		}
		if ((int) spinnerNumBanios.getValue() == 0) {
			mensajeError += "El campo Numero Baños no puede estar vacío.\n";
		}
		if ((int) spinnerNumCamas.getValue() == 0) {
			mensajeError += "El campo Numero Camas no puede estar vacío.\n";
		}

		if (mensajeError.isEmpty()) {
			mensaje = "Dirección: " + campoDireccion.getText() + "\n" + "Provincia: "
					+ comboBoxProvincias.getSelectedItem() + "\n" + "Fecha de alta: " + campoFechaAlta.getText() + "\n"
					+ "Fecha final de disponibilidad: " + campoFechaDisponibilidad.getText() + "\n"
					+ "Nº de huéspedes: " + spinnerNumHuespedes.getValue() + "\n" + "Nº de dormitorios: "
					+ spinnerNumDormitorios.getValue() + "\n" + "Nº de baños: " + spinnerNumBanios.getValue() + "\n"
					+ "Nº de camas: " + spinnerNumCamas.getValue() + "\n" + precioMinimo.getText() + "\n";

			String tipoCama = obtenerTipoCamaSeleccionado();
			mensaje += "Tipo de camas: " + tipoCama + "\n";

			if (checkNinos.isSelected()) {
				mensaje += "¿Niños?: Sí\n" + "Edad niños: " + spinnerEdad.getValue() + "\n" + "Extras: "
						+ campoExtras.getText();
			} else {
				mensaje += "¿Niños?: No (No seleccionado)";
			}
		} else {
			JOptionPane.showMessageDialog(null, mensajeError, "Error de validación", JOptionPane.ERROR_MESSAGE);
		}

		return mensaje;
	}

	/**
	 * Limpiar campos.
	 */
	public static void limpiarCampos() {
		campoDireccion.setText("");
		comboBoxProvincias.setSelectedIndex(0);
		campoFechaAlta.setValue(null);
		campoFechaDisponibilidad.setValue(null);
		spinnerNumHuespedes.setValue(0);
		spinnerNumDormitorios.setValue(0);
		spinnerNumBanios.setValue(0);
		spinnerNumCamas.setValue(0);
		grupoCamas.clearSelection();
		radioCamaSimple.setSelected(false);
		radioCamaDoble.setSelected(false);
		radioSofaCama.setSelected(false);
		checkNinos.setSelected(false);
		spinnerEdad.setValue(0);
		campoExtras.setText("");
	}

	/**
	 * Obtener tipo cama seleccionado.
	 *
	 * @return the string
	 */
	private static String obtenerTipoCamaSeleccionado() {
		if (radioCamaSimple.isSelected()) {
			return "Cama Simple";
		} else if (radioCamaDoble.isSelected()) {
			return "Cama Doble";
		} else if (radioSofaCama.isSelected()) {
			return "Sofá Cama";
		} else {
			return "No especificado";
		}
	}
}
