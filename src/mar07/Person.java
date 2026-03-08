package mar07;

public class Person {
    String name;
    int age;
    Address address;
    Order order;

    static{}
    {}

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(String n, Address a, Order o) {
        this.name = n;
        this.age = 0;
        this.address = a;
        this.order = o;
    }

    public void sayHi(){
        System.out.println(name+" says hi");
    }
    public int getAge(){
        return age;
    }
    public void haveBirthday(){
        age++;
        System.out.println(name + " is having a birthday!!");
    }

    public String getAddress() {
        String s = address.getAddress();
        if(s.isEmpty()) return "-INCORRECT ADDRESS-";
        return s;
    }
    public String getOrderDetails(){
        return order.getOrder();
    }
}
