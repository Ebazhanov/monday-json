package tests;

import org.testng.annotations.Test;
import tests.folder.AddressRequest;

import static org.testng.Assert.assertEquals;

public class AddressParser {

    AddressRequest addressRequest = new AddressRequest();

    private String parse(String input) {
        return input;
    }

    @Test
    public void shouldParseSimpleAddress() {
        // given
        final String expectedJson = "{\"street\": \"Winterallee\", \"housenumber\": \"3\"}";
        addressRequest.setAddress("WinterAllee 3");
        //final String input = "Winterallee 3";
        // when
        final String parsedJson = new AddressParser().parse(addressRequest.getAddress());
        // then
        System.out.println(expectedJson + parsedJson);
        assertEquals(expectedJson, parsedJson);
    }

}
