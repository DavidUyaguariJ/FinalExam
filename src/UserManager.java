import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

class UserManager {
    private Node start;
    private int size;

    public UserManager() {
        start = null;
        size = 0;
    }


    public void add(User user, DefaultTableModel tableModel) {
        Node newNode = new Node(user);
        if (start == null) {
            start = newNode;
        } else {
            Node current = start;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
        size++;
        updateList(tableModel);
    }


    public void bubbleSort(DefaultTableModel tableModel) {
        if (start == null || start.getNext() == null)
            return;

        boolean swapped;
        do {
            swapped = false;
            Node current = start;
            Node next = start.getNext();
            while (next != null) {
                if (current.getUser().getId() > next.getUser().getId()) {
                    User temp = current.getUser();
                    current.setUser(next.getUser());
                    next.setUser(temp);
                    swapped = true;
                }
                current = next;
                next = next.getNext();
            }
        } while (swapped);
        updateList(tableModel);
    }


    public boolean userExists(int id) {
        Node current = start;
        while (current != null) {
            if (current.getUser().getId() == id) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }


    public User findUser(int id) {
        Node current = start;
        while (current != null) {
            if (current.getUser().getId() == id) {
                return current.getUser();
            }
            current = current.getNext();
        }
        return null;
    }


    public void updateList(DefaultTableModel tableModel) {
        if (start == null) {
            JOptionPane.showMessageDialog(null, "No hay usuarios registrados.");
        } else {
            tableModel.setRowCount(0);
            tableModel.addRow(new Object[]{"ID", "Nombre", "Email", "Rol", "Género", "Preferencias"});
            Node current = start;
            while (current != null) {
                User user = current.getUser();
                tableModel.addRow(new Object[]{
                        user.getId(), user.getName(), user.getEmail(), user.getRole(), user.getGender(), user.getPreferences()
                });
                current = current.getNext();
            }
        }
    }


    public void findMatch(User loggedInUser, DefaultTableModel tableModel) {
        Node current = start;
        boolean foundMatch = false;

        while (current != null) {
            User otherUser = current.getUser();


            if (!otherUser.equals(loggedInUser) &&
                    loggedInUser.getPreferences().equals(otherUser.getGender()) &&
                    loggedInUser.getGender().equals(otherUser.getPreferences()) &&
                    loggedInUser.getRole().equals(otherUser.getRole())) {

                JOptionPane.showMessageDialog(null, "¡Coincidencia! " + loggedInUser.getName() + " y " + otherUser.getName() + " son un match.");
                foundMatch = true;
            }
            current = current.getNext();
        }

        if (!foundMatch) {
            JOptionPane.showMessageDialog(null, "No se encontraron coincidencias para " + loggedInUser.getName());
        }
    }

}

