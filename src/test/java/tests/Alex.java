package tests;

import org.testng.annotations.Test;
import schema.Address;

import static org.testng.Assert.assertEquals;

public class Alex {

    @Test
    public void shouldHaveWinterallee() {
        final String input = "Winterallee 3";
        //int numberStarted = -1;
        int returnedNumbers = findFirstNumberInString(input);
        final String streetName = input.substring(0, returnedNumbers - 1);
        final String houseNumber = input.substring(returnedNumbers);
        final Address json = new Address(streetName, houseNumber);
        assertEquals(json.getStreetName(), "Winterallee");
        assertEquals(json.getHouseNumber(), "3");
    }

    private int findFirstNumberInString(String input) {
        for (int index = 0; index < input.length(); index++) {
            final char charAt = input.charAt(index);
            if (Character.isDigit(charAt)) {
                //int numberStarted = index;
                //break;
                return index;
            }
        }
        return -1;
    }

}
