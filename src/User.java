class User {
    private int id;
    private String name;
    private String email;
    private String gender;
    private String preferences;
    private String role;

    public User(int id, String name, String email, String gender, String preferences, String role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.preferences = preferences;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public String getPreferences() {
        return preferences;
    }

    public String getRole() {
        return role;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRole(String role) {
        this.role = role;
    }
}


