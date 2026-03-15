package mar14;

public class Employee {
    private double basicPay;
    private double bonus;
    private double overtime;
    private final User user;
    private static final double payRate = 17.5;

    public Employee(User user) {
        this.user = user;
    }

    String getEmpName() {
        return user.getUserName();
    }

    void getSalary(double basicPay) {
        this.basicPay = basicPay;
        System.out.println(user.getUserName() + " has salary:$" + this.basicPay);
    }

    void getSalary(double basicPay, double bonus) {
        this.basicPay = basicPay;
        this.bonus = bonus;
        System.out.println(user.getUserName() + " has salary:$" + this.basicPay + " bonus:$" + this.bonus);
    }

    void getSalary(double basicPay, double bonus, double overtime) {
        this.basicPay = basicPay;
        this.bonus = bonus;
        this.overtime = overtime;
        System.out.println(user.getUserName() + " has salary:$" + this.basicPay + " bonus:$" + this.bonus + " overtime:$" + this.overtime);
    }

    public double getPay(double hours) {
        return Utils.roundNumber(payRate * hours, 1);
    }
}
