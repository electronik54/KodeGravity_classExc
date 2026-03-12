package mar10;

public class Account {
    private User accHolder;
    private double balance;
    private String accNumber;
    private String acctype;
    static private int accCount;


    static {
    }

    {
        accCount++;
    }

    public Account(User accHolder, double balance, String acctype) {
        this.accHolder = accHolder;
        this.balance = balance;
        this.accNumber = "AC/"+accCount+"00"+accCount;
        this.acctype = acctype;
    }

    public String accHolderName() {
        return accHolder.getName();
    }

    public double getBalance() {
        return Utils.roundNumber(balance, 2);
    }

    public boolean withdraw(double amount) {
        if(this.balance <= amount) {
            System.out.println("Insufficient balance to proceed with this transaction");
            return false;
        }
        this.balance -= amount;
        return true;
    }
    public boolean deposit(double amount) {
        if(amount < 0){
            System.out.println("-AMOUNT CANNOT BE LESS THAN 0-");
            return false;
        }
        this.balance += amount;
        return true;
    }

    public String getAccNumber() {
        return accNumber;
    }

    public void earnInterestOnBalance(double interestRate) {
        this.balance += (getBalance() * interestRate) / 100;
    }

    public boolean authUser(String username, String password) {
        if(accHolder.login(username, password)) return true;
        return false;
    }
}
