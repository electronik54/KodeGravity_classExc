package mar24.Payments.Bank.Email;

public class Email {
    private String email;
    private String password;

    public Email(String userEmail) {
        this.email = userEmail;
    }

    public boolean loginUser()
    {
        System.out.println("-LOGGING IN WITH JUST USER NAME-");
        Auth authenticator = new Auth();
        if(authenticator.autoAuth(email)) return true;

        return false;
    }

    public boolean loginUser(String userPassword)
    {
        System.out.println("-LOGGING IN WITH USER NAME & PASSWORD-");
        this.password = userPassword;

        Auth authenticator = new Auth();
        if(authenticator.auth(email, password)) return true;

        return false;
    }
}
