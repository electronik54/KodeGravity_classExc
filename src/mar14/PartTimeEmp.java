package mar14;

public class PartTimeEmp extends Employee {
    private static final double payRate = 25;

    public PartTimeEmp(User user) {
        super(user);
    }

    public double getPay(double hours) {
        return Utils.roundNumber(payRate *hours, 1);
    }
}
