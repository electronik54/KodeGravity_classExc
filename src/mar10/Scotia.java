package mar10;

public class Scotia extends Bank {
    static private double interestRate = 0.3;

    public Scotia(Account[] account) {
        super("Scotia", account);
    }

    public double getInterestRate() {
        return super.getInterestRate() + this.interestRate;
    }
}