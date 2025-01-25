package ProyectGUI.AuthenticationGUI;

import persistance.User;
import persistance.UserManager;

import javax.swing.*;
import java.awt.*;

public class InicioGUI {
    private JPanel pInicio;
    private JButton empezarButton;
    private JLabel imaU2;
    private JLabel imaInicio;
    private JFrame frame;

    public InicioGUI(JFrame frame) {
        User rootUser = new User(
                "Santiago",
                "Pilamunga",
                "spilamunga@udla.edu.ec",
                "admin123",
                "Mujer",
                "Hombre"
        );
        UserManager userManager = UserManager.getInstance();
        userManager.addUser(rootUser);

        this.frame = frame;
        ImageIcon icon = new ImageIcon("src/Images/logou-removebg-preview.png");
        ImageIcon icon2 = new ImageIcon("src/Images/fondoinicio-removebg-preview.png");
        Image img = icon.getImage();
        Image img2 = icon2.getImage();
        Image imgRedimensionada = img.getScaledInstance(230, 200, Image.SCALE_SMOOTH);
        Image imgRedimensionada2 = img2.getScaledInstance(240, 200, Image.SCALE_SMOOTH);
        imaU2.setIcon(new ImageIcon(imgRedimensionada));
        imaInicio.setIcon(new ImageIcon(imgRedimensionada2));
        empezarButton.addActionListener(e -> {
            frame.dispose();
            LoginGUI loginGUI = new LoginGUI();
            loginGUI.mostrarVentanaLogin();
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Inicio");
        PanelConFondo panelConFondo = new PanelConFondo("src/Images/fondo u.jpg");
        panelConFondo.setLayout(new BorderLayout());
        InicioGUI inicioGUI = new InicioGUI(frame);
        panelConFondo.add(inicioGUI.pInicio, BorderLayout.CENTER);
        frame.setContentPane(panelConFondo);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 700);
        frame.setVisible(true);
    }
}
