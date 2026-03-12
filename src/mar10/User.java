package mar10;

import java.util.Scanner;

public class User {
    private String name;
    private String password;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public boolean login(String username, String password) {
        if(this.name.equalsIgnoreCase(username.trim()) && this.password.equals(password)) return true;
        return false;
    }
}
