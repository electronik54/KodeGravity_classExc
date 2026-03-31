package mar24;

public class Devices {

    private String name;

    public Devices(String name) {
        this.name = name;
        System.out.println("DEVICE NAME:" + getName() + " FOUND");
        System.out.println("CONNECTING....");
    }

    String getName() {
        //LOCAL INNER CLASS: Defined inside the method
        class SomeClass {
            String getName() {
                return "-" + name.toUpperCase() + "-";
            }
        }
        SomeClass innerClass = new SomeClass();
        return innerClass.getName();
    }

    //STATIC INNER CLASS
    static class ConnectionToInternet {

        static boolean isConnected = false;

        boolean checkConnection() {
            isConnected = !isConnected;
            return isConnected;
        }
    }

    //MEMBER INNER CLASS OR INNER CLASS
    class LocalConnection {
        boolean isLocalConnected = false;

        boolean checkConnection() {
            isLocalConnected = !isLocalConnected;
            return isLocalConnected;
        }
    }

}
