package mar14;

public class ContractEmp extends Employee {
    private static final double payRate = 50;

    public ContractEmp(User user) {
        super(user);
    }

    public double getPay(double hours) {
        return Utils.roundNumber(payRate *hours, 1);
    }
}