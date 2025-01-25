package ProyectGUI.AuthenticationGUI;

import persistance.User;
import persistance.UserManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGUI {
    private JTextField txtCorreoTlf;
    private JButton ingresarButton;
    private JButton crearCuentaButton;
    private JPanel pLogin;
    private JLabel imaU2;
    private JPasswordField passwordLogin;

    private JFrame loginFrame;

    public LoginGUI() {
        ImageIcon icon = new ImageIcon("src/Images/logou-removebg-preview.png");
        Image img = icon.getImage();
        Image imgRedimensionada = img.getScaledInstance(190, 150, Image.SCALE_SMOOTH);
        imaU2.setIcon(new ImageIcon(imgRedimensionada));

        crearCuentaButton.addActionListener(e -> {
            loginFrame.dispose();
            RegistroGUI registroGUI = new RegistroGUI();
            registroGUI.mostrarVentanaRegistro();
        });
        ingresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String correo = txtCorreoTlf.getText();
                String contrasena = new String(passwordLogin.getPassword());
                User user = UserManager.getInstance().findUserByUsername(correo);

                if (user != null && user.getPassword().equals(contrasena)) {
                    JOptionPane.showMessageDialog(loginFrame, "Se logro", "Error de login", JOptionPane.ERROR_MESSAGE);
                    //loginFrame.dispose();

                    //PrincipalGUI principalGUI = new PrincipalGUI();
                    //principalGUI.mostrarVentanaPrincipal();
                } else {
                    JOptionPane.showMessageDialog(loginFrame, "Correo o contraseña incorrectos", "Error de login", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public void mostrarVentanaLogin() {
        loginFrame = new JFrame("Login");

        PanelConFondo panelConFondo = new PanelConFondo("src/Images/fondo u.jpg");
        panelConFondo.setLayout(new BorderLayout());

        panelConFondo.add(pLogin, BorderLayout.CENTER);

        loginFrame.setContentPane(panelConFondo);
        loginFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        loginFrame.setSize(400, 700);
        loginFrame.setVisible(true);
    }
}
