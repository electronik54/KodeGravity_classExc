package feb28;

public class Account {
    String accHolderName;
    double accBal;
    String accNum;
    static double interestRate;
    static String bankName;
    static int totalAcc;

    static {
        System.out.println("---STATIC INITIALIZATION BLOCK{}-----------------------");
        System.out.println("-WELCOME TO BANK-");
        System.out.println("-SETTING INTEREST RATE TO 1.5% FOR ALL ACCOUNT HOLDERS-");
        interestRate = 1.5;
        System.out.println("-SETTING BANK NAME TO: KG-");
        bankName = "KG";
        System.out.println("-------------------------------------------------------");
    }

    {
        System.out.println("---INSTANCE INITIALIZATION BLOCK{}---");
        System.out.println("-INCREMENTING ACCOUNTS-");
        ++totalAcc;
        System.out.println("-------------------------------------");
    }

    public Account(String accHolderName) {
        this.accHolderName = accHolderName;
    }

    public Account(String accHolderName, double bal) {
        this(accHolderName);
        this.accBal = bal;
        this.accNum = generateAccountNum();

        if(this.accBal == 0){
            System.out.println("-INITIAL BALANCE SET TO $0-");
        }
    }

    static public String generateAccountNum(){
        String accNum = "dep-"+totalAcc+"-"+totalAcc;
        return accNum;
    }

    public void getAccInfo(){
        System.out.println();
        System.out.println("-INFO-");
        System.out.println("------");
        System.out.println("NAME: "+accHolderName);
        System.out.println(bankName +" bank AC/#: "+accNum);
        System.out.println("BALANCE:$ "+ accBal);
        System.out.println("------");
    }

    public Boolean withdraw(double amount){
        if(amount > accBal)  return false;

        System.out.println("(INSTANCE METHOD) -Withdrawing:$"+amount+"-");
        accBal -= amount;
        return true;
    }
    public void deposit(double amount){
        System.out.println("(INSTANCE METHOD) -Depositing:$"+amount+"-");
        accBal += amount;
    }

    public void addInterest(){
        double interestAmt=0;
        if(accBal > 0) interestAmt = (this.accBal * interestRate) / 100;
        System.out.println("(INSTANCE METHOD) -ADDING INTEREST of:$"+interestAmt+"-");
        accBal += interestAmt;
    }

    public static void getTotalAccounts(){
        System.out.println("(STATIC METHOD)--"+bankName+" bank has:"+totalAcc+" accounts--");
    }


}
