/**
 * PanelArrendador.java
 * 22 nov 2023 12:13:46
 * @author Lenny López Pérez

 */
package swing_c_p02_LopezPerezLenny;

import java.awt.Color;	
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.text.ParseException;
import javax.swing.BorderFactory;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

// TODO: Auto-generated Javadoc
/**
 * The Class PanelArrendador.
 */
public class PanelArrendador extends JPanel {
    
    /** The etiqueta nombre. */
    private JLabel etiquetaNombre = new JLabel();
    
    /** The campo nombre. */
    private static JFormattedTextField campoNombre = new JFormattedTextField();

    /** The etiqueta apellidos. */
    private JLabel etiquetaApellidos = new JLabel();
    
    /** The campo apellidos. */
    private static JFormattedTextField campoApellidos = new JFormattedTextField();

    /** The etiqueta DNI. */
    private JLabel etiquetaDNI = new JLabel();
    
    /** The campo DNI. */
    private static JFormattedTextField campoDNI = new JFormattedTextField();

    /** The etiqueta telefono. */
    private JLabel etiquetaTelefono = new JLabel();
    
    /** The campo telefono. */
    private static JFormattedTextField campoTelefono = new JFormattedTextField();

    /**
     * Instantiates a new panel arrendador.
     */
    public PanelArrendador() {
        inicializarFormulario();

        this.setBackground(Color.BLACK);

    }

    /**
     * Inicializar formulario.
     */
    private void inicializarFormulario() {
		setLayout(new GridLayout(0, 2, 10, 10));

        etiquetaNombre.setText("Nombre: ");
        etiquetaNombre.setForeground(Color.WHITE);
        etiquetaNombre.setFont(new Font("Arial", Font.BOLD, 24));
        campoNombre.setFont(new Font("Arial", Font.BOLD, 24)); 
        add(etiquetaNombre);
        add(campoNombre);

        etiquetaApellidos.setText("Apellidos: ");
        etiquetaApellidos.setForeground(Color.WHITE);
        etiquetaApellidos.setFont(new Font("Arial", Font.BOLD, 24));
        campoApellidos.setFont(new Font("Arial", Font.BOLD, 24));
        add(etiquetaApellidos);
        add(campoApellidos);

        etiquetaDNI.setText("DNI: ");
        etiquetaDNI.setForeground(Color.WHITE);

        etiquetaDNI.setFont(new Font("Arial", Font.BOLD, 24));
        campoDNI.setFont(new Font("Arial", Font.BOLD, 24));
        add(etiquetaDNI);
        add(campoDNI);

        etiquetaTelefono.setText("Teléfono");
        etiquetaTelefono.setForeground(Color.WHITE);
        etiquetaTelefono.setFont(new Font("Arial", Font.BOLD, 24));
        campoTelefono.setFont(new Font("Arial", Font.BOLD, 24));
        add(etiquetaTelefono);
        add(campoTelefono);

        try {
            MaskFormatter dniFormatter = new MaskFormatter("########?");
            dniFormatter.setPlaceholderCharacter('*');
            campoDNI.setFormatterFactory(new DefaultFormatterFactory(dniFormatter));

            MaskFormatter telefonoFormatter = new MaskFormatter("#########");
            telefonoFormatter.setPlaceholderCharacter('*');
            campoTelefono.setFormatterFactory(new DefaultFormatterFactory(telefonoFormatter));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Validar arrendador.
     *
     * @return the string
     */
    public static String validarArrendador() {
        String mensajeError = "";
        String mensaje = "";

        if (campoNombre.getText().trim().isEmpty()) {
            mensajeError += "El campo Nombre no puede estar vacío.\n";
        }
        if (campoApellidos.getText().trim().isEmpty()) {
            mensajeError += "El campo Apellidos no puede estar vacío.\n";
        }
        if (!validarDNI(campoDNI.getText())) {
            mensajeError += "El campo DNI debe tener 8 números seguidos de una letra.\n";
        }
        if (!validarTelefono(campoTelefono.getText())) {
            mensajeError += "El campo Teléfono debe tener 9 dígitos.\n";
        }
        if (mensajeError.isEmpty()) {
            mensaje = "Nombre: " + campoNombre.getText() + "\n" +
                      "Apellidos: " + campoApellidos.getText() + "\n" +
                      "DNI: " + campoDNI.getText() + "\n" +
                      "Teléfono: " + campoTelefono.getText();
        } else {
            JOptionPane.showMessageDialog(null, mensajeError, "Error de validación", JOptionPane.ERROR_MESSAGE);
        }

        return mensaje;
    }
    
    /**
     * Limpiar campos.
     */
    public static void limpiarCampos() {
        campoNombre.setText("");
        campoApellidos.setText("");
        campoDNI.setValue(null);
        campoTelefono.setValue(null);
    }

    /**
     * Validar DNI.
     *
     * @param dni the dni
     * @return true, if successful
     */
    private static boolean validarDNI(String dni) {
        return dni.matches("\\d{8}[a-zA-Z]");
    }

    /**
     * Validar telefono.
     *
     * @param telefono the telefono
     * @return true, if successful
     */
    private static boolean validarTelefono(String telefono) {
        return telefono.matches("\\d{9}");
    }
}

