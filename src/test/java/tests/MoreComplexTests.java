package tests;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MoreComplexTests {

    private final static Gson GSON = new Gson();

    public static int findFirstNumberInStringNew(String input) {
        //int inputNo = input.indexOf("No");
        //int inputСomma = input.indexOf(",");

        if (input.contains("No")) {
            return input.indexOf("No");
        } else if (input.contains(",")) {
            return input.indexOf(",");
        } /*else if (!(input.indexOf(",") | input.indexOzf("No")) {
            System.out.println("НЕТУ номера и запятой");
        }*/

        return -1;
    }

    public String parse(String input) {
        final int firstNumberIndex = findFirstNumberInStringNew(input);
        final String streetName = input.substring(0, firstNumberIndex-1);
        final String houseNumber = input.substring(firstNumberIndex);
        final JsonObject jsonAddress = new JsonObject();
        jsonAddress.addProperty("street", streetName);
        jsonAddress.addProperty("housenumber", houseNumber);
        return GSON.toJson(jsonAddress);
    }

    @Test
    public void shouldParseOtherCountriesAddress1() {
        final String input = "4, rue de la revolution";
        final String expectedJson = "{\"street\":\"rue de la revolution\",\"housenumber\":\"4\"}";
        final String actualJson = parse(input);
        assertEquals(actualJson, expectedJson);
    }

    @Test
    public void shouldParseOtherCountriesAddress2() {
        final String input = "200 Broadway Av";
        final String expectedJson = "{\"street\":\"Broadway Av\",\"housenumber\":\"200\"}";
        final String actualJson = parse(input);
        assertEquals(actualJson, expectedJson);
    }

    @Test
    public void shouldParseOtherCountriesAddress3() {
        final String input = "Calle Aduana, 29";
        final String expectedJson = "{\"street\":\"Calle Aduana\",\"housenumber\":\"29\"}";
        final String actualJson = parse(input);
        assertEquals(actualJson, expectedJson);
    }

    @Test
    public void shouldParseOtherCountriesAddress4() {
        final String input = "Calle 39 No 1540";
        final String expectedJson = "{\"street\":\"Calle 39\",\"housenumber\":\"No 1540\"}";
        final String actualJson = parse(input);
        assertEquals(actualJson, expectedJson);
    }

}
