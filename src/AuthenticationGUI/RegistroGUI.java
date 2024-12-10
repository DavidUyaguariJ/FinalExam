package ProyectGUI.AuthenticationGUI;

import javax.swing.*;
import java.awt.*;

public class RegistroGUI {
    private JTextField txtNombre;
    private JTextField txtCorreo;
    private JComboBox comboGenero;
    private JTextField txtTelefono;
    private JTextField txtCarrera;
    private JButton registrarseButton;
    private JPasswordField password1;
    private JPasswordField passwordConf;
    private JPanel pRegistro; // Este es el contenido del formulario
    private JLabel imaU;

    public RegistroGUI() {
        ImageIcon icon = new ImageIcon("src/Images/logou-removebg-preview.png");
        Image img = icon.getImage();
        Image imgRedimensionada = img.getScaledInstance(180, 150, Image.SCALE_SMOOTH);
        imaU.setIcon(new ImageIcon(imgRedimensionada));
    }

    public void mostrarVentanaRegistro() {
        JFrame frame = new JFrame("Registro");

        PanelConFondo panelConFondo = new PanelConFondo("src/Images/fondo u.jpg");
        panelConFondo.setLayout(new BorderLayout());

        panelConFondo.add(pRegistro, BorderLayout.CENTER);

        frame.setContentPane(panelConFondo);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 700); // Ajusta el tamaño según sea necesario
        frame.setVisible(true);
    }
}
