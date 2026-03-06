package feb28;

public class StaticInClass {

    //Field Initializers
    static int count;
    String name;

    //Constructors is a type of Initializers too
    public StaticInClass() {
        System.out.println("#3. I WILL LOAD DURING INITIALIZATION");
    }
    public StaticInClass(String name) {
        this();
        System.out.println("#4. I WILL LOAD DURING (PARAMETERIZED) INITIALIZATION");
        this.name = name;
    }

    static public void incrementCount(){
        count++;
    }
    public void displayName(){
        System.out.println("name:"+this.name +" | count:"+count);
    }
    static void displayCount(){
        //System.out.println("count:"+count+"| name:"+this.name);   //THROWS ERR AS NON-STATIC REFERRED
        System.out.println("Count is:"+count);
    }

    //Static Initialization Block
    static {
        System.out.println("Static initialization block: #1. I WILL LOAD FIRST SINCE I AM STATIC()");
        count++;
    }

    //Instance Initialization Block (IIB)
    {
        System.out.println("Initialization block: #2. I WILL LOAD WHEN CREATING INSTANCE SINCE I AM NOT STATIC()");
    }
}
