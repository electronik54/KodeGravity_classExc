package feb24;

public class Person {
    String name = "John Doe";   //DEFAULT value
    int age;
    private double money;

    Person(){
        System.out.println("Person with no name and age created!");
    }
    Person(String name){
        this.name = name;
        System.out.println("Person is named:" + name);
    }
    Person(String name, int age){
        this (name);
        this.age = age;
        System.out.println(name+" age set to:"+age);
    }
    Person(String name, int age, double money){
        this (name, age);
        this.money = money;
        System.out.println(name+" is born with:$"+money);
    }

    public void sayHi() {
        System.out.println(name+" says hello!");
    }
    public void say(String says) {
        System.out.println(name+" says " +says);
    }

    public void addAge(int years) {
        age += years;
        System.out.println(name+" is now " +age+ " year(s) old");
    }
    public void haveBirthday() {
        this.addAge(1);
        System.out.println(name+" is having a birthday");
    }

    public void earnMoney(double amount){
        this.money += amount;
    }
    public void earnInterestOnBalance(){
        double interestRate = 1.2;
        double interest = (this.money * interestRate) / 100;
        money += interest;
        System.out.println(name+" earned interest!!");
    }
    public void getBalance(){
        System.out.println(name+" has balance of:$"+money);
    }

    public void getInfo(){
        System.out.println("--INFO--");
        System.out.println("name:"+name);
        System.out.println("age:"+age);
        if(this.money > 0) System.out.println("Has Balance: YES"); else System.out.println("Has Balance: NO");
        System.out.println("--------");
    }
}
