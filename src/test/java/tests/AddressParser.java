package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AddressParser {

    private String parse(String input) {
        return input;
    }

    @Test
    public void shouldParseSimpleAddress() {
        // given
        final String expectedJson = "{\"street\": \"Winterallee\", \"housenumber\": \"3\"}";
        final String input = "Winterallee 3";
        // when
        final String parsedJson = new AddressParser().parse(input);
        // then
        assertEquals(expectedJson, parsedJson);
    }

}
