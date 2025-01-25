package ProyectGUI.AuthenticationGUI;

import javax.swing.*;

public class MatchGUI {
    private JButton rechazarButton;
    private JButton aceptarButton;
    private JTextArea txtCarreraFacu;
    private JTextArea txtEdadNom;
    private JTextArea txtGustos;
    private JTextArea txtDescripcion;
    private JPanel pMatch;

    public static void main(String[] args) {
        JFrame frame = new JFrame("MatchGUI");
        frame.setContentPane(new MatchGUI().pMatch);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
