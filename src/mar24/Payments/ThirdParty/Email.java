package mar24.Payments.ThirdParty;

import mar24.Payments.Bank.Email.Auth;

public class Email {
    private String email;
    private String password;

    public Email(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public boolean loginUser()
    {
        System.out.println("-LOGGING IN WITH USER NAME & PASSWORD-");
        Auth authenticator = new Auth();
        if(authenticator.auth(email, password)) return true;

        return false;
    }

}