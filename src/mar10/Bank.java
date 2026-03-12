package mar10;

import java.util.Scanner;

public class Bank {
    private String name;
    private Account[] accounts;
    private static double primeInterestRate = 0.5;

    public Bank(String name, Account[] account) {
        this.name = name;
        this.accounts = account;
    }

    public String getName() {
        return name;
    }

    public Account getAccFromLoginPrompt(Scanner s) {
        System.out.print("USERNAME:");
        String username = s.nextLine();

        System.out.print("PASSWORD:");
        String password = s.nextLine();

        Account foundAcc = this.getAccountOfUser(username, password);
        if(foundAcc != null) return foundAcc;

        return null;
    }

    public double getInterestRate() {
        return this.primeInterestRate;
    }

    private Account getAccountOfUser(String username, String password) {
        Account foundAcc = null;
        for(Account a : this.accounts) {
            if(a.authUser(username, password)) foundAcc = a;
        }
        return foundAcc;
    }
}
