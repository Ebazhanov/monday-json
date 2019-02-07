package tests;

import org.testng.annotations.Test;
import schema.AddressParser;

import static helpers.IndexCount.findFirstNumberInString;
import static org.testng.Assert.assertEquals;

public class Alex {

    @Test
    public void shouldHaveWinterallee() {
        final String input = "Winterallee 3";
        int returnedNumbers = findFirstNumberInString(input);
        final String streetName = input.substring(0, returnedNumbers - 1);
        final String houseNumber = input.substring(returnedNumbers);
        final AddressParser json = new AddressParser(streetName, houseNumber);
        assertEquals(json.getStreetName(), "Winterallee");
        assertEquals(json.getHouseNumber(), "3");
    }

}
