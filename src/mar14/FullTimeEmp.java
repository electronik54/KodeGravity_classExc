package mar14;

public class FullTimeEmp extends Employee {
    private static final double payRate = 30;

    public FullTimeEmp(User user) {
        super(user);
    }

    public double getPay(double hours) {
        return Utils.roundNumber(payRate *hours, 1);
    }
}
