package mar24.Payments.Bank.Email;

public final class Auth {
    private final String email = "nik@mail";
    private final String password = "pass123";

    protected boolean autoAuth(String userEmail){
        System.out.println("LOGGING IN USING THE PROTECTED METHOD <autoAuth> in <mar24.Payments.Bank.Email>");
        if(this.email.equals(userEmail)) return true;
        return false;
    }

    public boolean auth(String userEmail, String userPassword) {
        System.out.println("LOGGING IN USING THE PUBLIC METHOD <auth> in <mar24.Payments.Bank.Email>");
        if(this.email.equals(userEmail) && this.password.equals(userPassword)) return true;
        return false;
    }
}
