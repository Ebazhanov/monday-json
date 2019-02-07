package schema;

public class AddressParser {

    private final String streetName;
    private final String houseNumber;

    public AddressParser(String streetName, String houseNumber) {
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
