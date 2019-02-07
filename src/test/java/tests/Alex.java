package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Alex {

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

    @Test
    public void shouldHaveNewasdf() {
        final String input = "Winterallee 3";
        int numberStarted = -1;
        int returnedNumbers = findFirstNumberInString(input, numberStarted);
        final String streetName = input.substring(0, returnedNumbers - 1);
        final String houseNumber = input.substring(returnedNumbers);
        final Address json = new Address(streetName, houseNumber);
        assertEquals(json.getStreetName(), "Winterallee");
        assertEquals(json.getHouseNumber(), "3");
    }


    private int findFirstNumberInString(String input, int numberStarted){
        for (int index = 0; index < input.length(); index++) {
            final char charAt = input.charAt(index);
            if (Character.isDigit(charAt)) {
                numberStarted = index;
                break;
            }
        }
        return numberStarted;
    }

}
