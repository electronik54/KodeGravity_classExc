package mar10;

public class RBC extends Bank {
    static private double interestRate = 0.4;

    public RBC(Account[] account) {
        super("RBC", account);
    }

    public double getInterestRate() {
        double prime = super.getInterestRate();
        double intRate = interestRate;
        return prime + intRate;
    }
}