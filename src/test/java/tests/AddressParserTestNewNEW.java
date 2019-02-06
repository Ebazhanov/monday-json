package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AddressParserTestNewNEW {


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

    public static void main(String... args) {
        String st = "Auf der Vogelwiese 23 b";
        st.split("([0-9])\\w+");
        String addr1 = "";
        String addr2 = "";
        boolean founddigit = false;
        for (char ch : st.toCharArray()) {
            if (!founddigit && Character.isDigit(ch))
                founddigit = true;

            if (!founddigit)
                addr1 += ch;
            else
                addr2 += ch;

        }

        System.out.println(addr1);
        System.out.println(addr2);
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
    public void tadfasdf() {


/*         charAt = null;

        for (int index = 0; index < input.length(); index++) {
            final char charAt = input.charAt(index);
        }

        Character.isDigit(charAt)*/

        final String input = "Auf der Vogelwiese 23 b";
        final String[] split = input.split(" ");
        //final String = RegexpExpectedExceptionsHolder
        final Address addressJson = new Address(split[0], split[1]);
        assertEquals("Auf der Vogelwiese", addressJson.getStreetName());
    }

    @Test
    public void asdfasdfaa() {
        String input = "Auf der Vogelwiese 23 b";

        //String[] arrSplit_3 = input.split(" ");

        //char charAt = 0;

        for (int index = 0; index < input.length(); index++) {
            char charAt = input.charAt(index);
            System.out.print(charAt);
            if (Character.isDigit(charAt)) {
                System.out.print(charAt);
            }
        }


/*        final Address addressJson = new Address(charAt, charAt);
        assertEquals(addressJson.getStreetName(), "Auf der Vogelwiese");*/
    }

    @Test
    public void shouldHave() {
        final String input = "Auf der Vogelwiese 23 b";
        int index;
        int charAt;
        for (index = 0; index < input.length(); index++) {
            charAt = input.charAt(index);
            if (Character.isDigit(charAt)) {
                break;
            }
        }
        final Address addressJson = new Address(input.substring(0, 18), input.substring(index, 23));
        assertEquals(addressJson.getStreetName(), "Auf der Vogelwiese");
        assertEquals(addressJson.getHouseNumber(), "23 b");
    }



}
