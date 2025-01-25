package persistance;

import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private static UserManager instance;
    private List<User> users;

    private UserManager() {
        this.users = new ArrayList<>();
    }

    public static UserManager getInstance() {
        if (instance == null) {
            instance = new UserManager();
        }
        return instance;
    }

    // Métodos para manejar los usuarios
    public void addUser(User user) {
        users.add(user);
    }

    public List<User> getUsers() {
        return users;
    }

    public User findUserByUsername(String username) {
        for (User user : users) {
            if (user.getEmail().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public boolean removeUserByUsername(String username) {
        return users.removeIf(user -> user.getEmail().equals(username));
    }
}
