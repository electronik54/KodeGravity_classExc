package mar07;

import java.lang.reflect.Type;

public class Address {

    String street;
    String city;
    String state;
    String zip;
    String country;
    static String[] states = new String[]{"AB", "BC", "MB", "NB", "NL", "NS", "ON", "PE", "QC", "SK", "NT", "NU", "YT "};

    static {
    }

    {
        System.out.println("-INSTRUCTION FOR ADDRESS DETAILS-");
        var statesStb = new StringBuilder("- (1) STATE CODE AVAILABLE: ");
        for (String state : states) {
            statesStb.append(state + " | ");
        }
        System.out.println(statesStb + "-");
        System.out.println("- (2) ZIP CODE MUST BE IN FORMAT 'A1B2C3'-");
    }

    public Address() {
        this.country = "Canada";
    }

    public Address(String street, String city, String state, String zip, String country) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.country = country;
    }

    public String getAddress() {
        if (street.isEmpty() && city.isEmpty() && state.isEmpty() && zip.isEmpty() && country.isEmpty())
        return "";
        return (street + ", " + city + ", " + state + ", " + zip + ", " + country);
    }

    public boolean setStreet(String street) {
        if (street.isEmpty()) return false;
        this.street = street;
        return true;
    }

    public boolean setCity(String city) {
        if (city.isEmpty()) return false;
        this.city = city;
        return true;
    }

    public boolean setState(String state) {
        if (state.isEmpty()) return false;
        String normalizedState = state.toUpperCase().trim();
        for (String s : states) {
            if (s.equals(normalizedState)) {
                this.state = state;
                return true;
            }
        }
        return false;
    }

    public boolean setZip(String zip) {
        if (zip.isEmpty()) return false;
        if (zip.length() != 6) return false;
        String normalizedZip = zip.toUpperCase().trim();
        if (
                !((normalizedZip.charAt(0) >= 'A' && normalizedZip.charAt(0) <= 'Z') &&
                        (normalizedZip.charAt(2) >= 'A' && normalizedZip.charAt(2) <= 'Z') &&
                        (normalizedZip.charAt(4) >= 'A' && normalizedZip.charAt(4) <= 'Z') &&
                        Character.isDigit(normalizedZip.charAt(1)) && Character.isDigit(normalizedZip.charAt(3)) && Character.isDigit(normalizedZip.charAt(5)))
        ) return false;
        this.zip = normalizedZip;
        return true;
    }
}
