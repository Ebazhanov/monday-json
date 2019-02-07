package tests;

import org.testng.annotations.Test;
import schema.Address;

import static org.testng.Assert.assertEquals;

public class Alex {

    @Test
    public void shouldHaveWinterallee() {
        final String input = "Winterallee 3";
        int numberStarted = -1;
        int returnedNumbers = findFirstNumberInString(input, numberStarted);
        final String streetName = input.substring(0, returnedNumbers - 1);
        final String houseNumber = input.substring(returnedNumbers);
        final Address json = new Address(streetName, houseNumber);
        assertEquals(json.getStreetName(), "Winterallee");
        assertEquals(json.getHouseNumber(), "3");
    }

    @Test
    public void shouldHaveVogelwiese() {
        final String input = "Auf der Vogelwiese 23 b";
        int numberStarted = -1;
        int returnedNumbers = findFirstNumberInString(input, numberStarted);
        final String streetName = input.substring(0, returnedNumbers - 1);
        final String houseNumber = input.substring(returnedNumbers);
        final Address json = new Address(streetName, houseNumber);
        assertEquals(json.getStreetName(), "Auf der Vogelwiese");
        assertEquals(json.getHouseNumber(), "23 b");
    }


    private int findFirstNumberInString(String input, int numberStarted) {
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
