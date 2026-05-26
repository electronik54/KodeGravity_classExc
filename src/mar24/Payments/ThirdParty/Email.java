package mar24.Payments.ThirdParty;

import mar24.Payments.Bank.Email.Auth;

public class Email /**/extends Auth{
    private String email;
    private String password;

    public Email(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public boolean loginUser() {
        System.out.println("-LOGGING IN WITH USER NAME & PASSWORD-");

        if (autoAuth(email)) return true;
        if (fullAuth(email, password)) return true;

        /*Auth au = new Auth();
        if (au.autoAuth(email)) return true;
        if (au.fullAuth(email, password)) return true;*/

        return false;
    }
}


