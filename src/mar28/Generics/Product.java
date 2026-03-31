package mar28.Generics;

public class Product<A, B> {
    private A itemName;
    private B field2;

    public Product(A userFiled1, B userFiled2) {
        itemName = userFiled1;
        field2 = userFiled2;
    }

    public A getField1() {
        return itemName;
    }

    public void setField1(A field1) {
        this.itemName = field1;
    }

    public B getField2() {
        return field2;
    }

    public void setField2(B field2) {
        this.field2 = field2;
    }
}
