package mar28.Bank;

public class Account{
    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }
    public boolean withdraw(double amount) {
        try {
            if (amount > balance) {
                //CUSTOM EXCEPTION HANDLED WITHIN THE METHOD WITH <try...catch>
                throw new BalanceError("-INSUFFICIENT BALANCE TO PERFORM THIS WITHDRAWAL-");
            }
            balance -= amount;
            return  true;
        } catch (BalanceError e) {
            e.printStackTrace();
            return  false;
        }
    }

    //CUSTOM EXCEPTION THROWN FOR CALLER WITH <throws> KEYWORD IN METHOD SIGNATURE
    public boolean deposit(double amount) throws BalanceError {
            if (amount <= 0) {
                throw new BalanceError("-DEPOSIT AMOUNT CANNOT BE 0 OR LOWER-");
            }
            balance += amount;
            return  true;
    }
}
