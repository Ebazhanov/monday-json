package tests;

import com.google.gson.Gson;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AddressParserTestNew {

    public static class Address {

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

    public class AddressParser {

        public Address parse(String input) {
            final String[] split = input.split(" ");
            final Address addressJson = new Address(split[0], split[1]);
            return addressJson;
        }
    }

    @Test
    public void shouldParseAddress() {
        // given
        final AddressParser parser = new AddressParser();
        final String input = "Winterallee 3";

        // when
        final Address address = parser.parse(input);

        // then
        assertEquals("Winterallee", address.getStreetName());
        assertEquals("3", address.getHouseNumber());
    }

    @Test
    public void shouldParseMoreComplicatedAddress() {
        // given
        final AddressParser parser = new AddressParser();
        final String input = "Auf der Vogelwiese 23 b";

        // when
        final Address address = parser.parse(input);

        // then
        assertEquals("Auf der Vogelwiese", address.getStreetName());
        assertEquals("23 b", address.getHouseNumber());
    }


    @Test
    public void tadfasdf(){
        final String input = "Auf der Vogelwiese 23 b";
        final String[] split = input.split("0-9");
        final Address addressJson = new Address(split[0], split[1]);
        assertEquals("Auf der Vogelwiese", addressJson.getStreetName());
    }
}
