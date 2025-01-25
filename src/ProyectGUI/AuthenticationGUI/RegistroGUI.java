package ProyectGUI.AuthenticationGUI;

import persistance.User;
import persistance.UserManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistroGUI {
    private JTextField txtNombre;
    private JTextField txtCorreo;
    private JComboBox comboGenero;
    private JButton registrarseButton;
    private JPasswordField password1;
    private JPasswordField passwordConf;
    private JPanel pRegistro;
    private JLabel imaU;
    private JButton regresarButton;
    private JComboBox comboPreferencia;
    private JTextField txtApellido;

    private JFrame registroFrame;

    public RegistroGUI() {
        ImageIcon icon = new ImageIcon("src/Images/logou-removebg-preview.png");
        Image img = icon.getImage();
        Image imgRedimensionada = img.getScaledInstance(180, 150, Image.SCALE_SMOOTH);
        imaU.setIcon(new ImageIcon(imgRedimensionada));
        regresarButton.addActionListener(e -> {
            registroFrame.dispose();

            LoginGUI loginGUI = new LoginGUI();
            loginGUI.mostrarVentanaLogin();
        });
        registrarseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String firstName = txtNombre.getText();
                String lastName = txtApellido.getText();
                String email = txtCorreo.getText();
                String password = new String(password1.getPassword());
                String confirmPassword = new String(passwordConf.getPassword());
                String preference = (String) comboPreferencia.getSelectedItem();
                String gender = (String) comboGenero.getSelectedItem();

                if (!password.equals(confirmPassword)) {
                    JOptionPane.showMessageDialog(registroFrame, "Las contraseñas no coinciden", "Error de Registro", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                User newUser = new User(firstName, lastName, email, password, preference, gender);
                UserManager.getInstance().addUser(newUser);
                JOptionPane.showMessageDialog(registroFrame, "Usuario registrado con éxito", "Registro Exitoso", JOptionPane.INFORMATION_MESSAGE);
                registroFrame.dispose();
                LoginGUI loginGUI = new LoginGUI();
                loginGUI.mostrarVentanaLogin();
            }
        });
    }

    public void mostrarVentanaRegistro() {
        registroFrame = new JFrame("Registro");

        PanelConFondo panelConFondo = new PanelConFondo("src/Images/fondo u.jpg");
        panelConFondo.setLayout(new BorderLayout());

        panelConFondo.add(pRegistro, BorderLayout.CENTER);

        registroFrame.setContentPane(panelConFondo);
        registroFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        registroFrame.setSize(400, 700);
        registroFrame.setVisible(true);
    }
}
