package tests;

import org.testng.annotations.Test;
import schema.AddressParser;

import static org.testng.Assert.assertEquals;

public class TestCases {

    private final AddressParser parser = new AddressParser();

    @Test
    public void shouldParseSimpleAddress() {
        // given
        final String input = "Winterallee 3";
        final String expectedJson = "{\"street\":\"Winterallee\",\"housenumber\":\"3\"}";
        // when
        final String actualJson = parser.parse(input);
        // then
        assertEquals(expectedJson, actualJson);
    }

}
