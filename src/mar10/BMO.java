package mar10;

public class BMO extends Bank {
    static private double interestRate = 0.3;

    public BMO(Account[] account) {
        super("BMO", account);
    }

    public double getInterestRate() {
        double prime = super.getInterestRate();
        double intRate = interestRate;
        return prime + intRate;
    }
}
