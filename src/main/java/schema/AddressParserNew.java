package schema;

public class AddressParserNew {

    private final String streetName;
    private final String houseNumber;

    public AddressParserNew(String streetName, String houseNumber) {
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
