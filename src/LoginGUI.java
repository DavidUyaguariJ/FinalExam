import javax.swing.*;
import java.awt.*;

public class LoginGUI {
    private JTextField txtCorreoTlf;
    private JPasswordField txtContraseña;
    private JButton ingresarButton;
    private JButton crearCuentaButton;
    private JPanel pLogin; // Este es el contenido del formulario
    private JLabel imaU2;
    private JPasswordField passwordLogin;

    public LoginGUI() {
        // Cargar y redimensionar la imagen del JLabel
        ImageIcon icon = new ImageIcon("src/logou-removebg-preview.png");
        Image img = icon.getImage();
        Image imgRedimensionada = img.getScaledInstance(190, 150, Image.SCALE_SMOOTH);
        imaU2.setIcon(new ImageIcon(imgRedimensionada));
        crearCuentaButton.addActionListener(e -> {
            RegistroGUI registroGUI = new RegistroGUI();
            registroGUI.mostrarVentanaRegistro();
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Login");

        PanelConFondo panelConFondo = new PanelConFondo("src/fondo u.jpg");
        panelConFondo.setLayout(new BorderLayout());

        LoginGUI loginGUI = new LoginGUI();
        panelConFondo.add(loginGUI.pLogin, BorderLayout.CENTER);

        frame.setContentPane(panelConFondo);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 700); // Ajusta el tamaño según sea necesario
        frame.setVisible(true);
    }
}

