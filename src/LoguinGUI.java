import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoguinGUI {
    private JTable tbResultados;
    private JButton btnAddUser;
    private JButton btnFindUser;
    private JButton btnFindMatch;
    private JButton btnrefreshLists;
    private JButton btnexit;
    private JPanel pGeneral;

    private UserManager userManager;
    private DefaultTableModel tableModel;

    public LoguinGUI() {
        userManager = new UserManager();


        tableModel = new DefaultTableModel();
        tbResultados.setModel(tableModel);
        tableModel.addColumn("ID");
        tableModel.addColumn("Nombre");
        tableModel.addColumn("Email");
        tableModel.addColumn("Género");
        tableModel.addColumn("Preferencias Género");
        tableModel.addColumn("Preferencias Específicas");


        btnAddUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addUser();
            }
        });


        btnFindUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                findUser();
            }
        });


        btnFindMatch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                findMatch();
            }
        });


        btnrefreshLists.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userManager.updateList(tableModel);
            }
        });


        btnexit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

    }

    private void addUser() {
        try {
            int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del usuario:"));
            if (userManager.userExists(id)) {
                JOptionPane.showMessageDialog(null, "El ID ya está registrado. Intente con otro.");
                return;
            }

            String name = JOptionPane.showInputDialog("Ingrese el nombre del usuario:");
            String email = JOptionPane.showInputDialog("Ingrese el email del usuario:");
            String gender = JOptionPane.showInputDialog("Ingrese el género del usuario (Hombre/Mujer):");
            String preferences = JOptionPane.showInputDialog("Ingrese las preferencias del usuario (Hombre/Mujer):");

            String[] roles = {"Perros", "Gatos", "Música", "Festivales", "Arte", "Viajes", "Tecnología"};
            String role = (String) JOptionPane.showInputDialog(null, "Seleccione las preferencias específicas:",
                    "Preferencias", JOptionPane.QUESTION_MESSAGE, null, roles, roles[0]);

            User newUser = new User(id, name, email, gender, preferences, role);
            userManager.add(newUser, tableModel);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "ID inválido. Debe ser un número.");
        }
    }

    private void findUser() {
        try {
            int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del usuario a buscar:"));
            User user = userManager.findUser(id);
            if (user != null) {
                JOptionPane.showMessageDialog(null, "Usuario encontrado:\n" +
                        "Nombre: " + user.getName() + "\n" +
                        "Email: " + user.getEmail() + "\n" +
                        "Género: " + user.getGender() + "\n" +
                        "Preferencias: " + user.getPreferences() + "\n" +
                        "Preferencias específicas: " + user.getRole());
            } else {
                JOptionPane.showMessageDialog(null, "Usuario no encontrado.");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "ID inválido. Debe ser un número.");
        }
    }

    private void findMatch() {
        try {
            int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del usuario para buscar coincidencias:"));
            User user = userManager.findUser(id);
            if (user != null) {
                userManager.findMatch(user, tableModel);
            } else {
                JOptionPane.showMessageDialog(null, "Usuario no encontrado.");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "ID inválido. Debe ser un número.");
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Gestión de Usuarios");
        frame.setContentPane(new LoguinGUI().pGeneral);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

