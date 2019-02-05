package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AddressParserTest {

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

    public class AddressParser {

        public Address parse(String input) {
/*            final String[] split = input.split(" ");
            final Address address = new Address(split[0], split[1]);
            return objectMapper.writeValueAsString(address);*/
            return null;
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
}
