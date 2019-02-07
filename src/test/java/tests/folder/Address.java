package tests.folder;

public class Address {

    private final String streetName;
    private final String houseNumber;

    public Address(String streetName, String houseNumber) {
        this.streetName = streetName;
        this.houseNumber = houseNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getHouseNumber() {
        return houseNumber;
    }
}
