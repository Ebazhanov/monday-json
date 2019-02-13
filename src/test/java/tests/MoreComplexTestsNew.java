package tests;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MoreComplexTestsNew {

    private final static Gson GSON = new Gson();

    public static int findElementInString(String input) {
        if (input.contains("No")) {
            System.out.println("В СТРОКЕ ЕСТЬ 'No'");
            return input.indexOf("No");
        } else if (input.contains(",")) {
            System.out.println("В СТРОКЕ ЕСТЬ ЗАПЯТАЯ");
            return input.indexOf(",") + 1;
        } else if (Character.isDigit(input.charAt(0))) {
            System.out.println("СТРОКА НАЧИНАЕТСЯ С НОМЕРА");
            return input.indexOf(" ") + 1;
        }
        return -1;
    }

    public String selectParseMethod(String input){
        if (Character.isDigit(input.charAt(0))){
            return parseNumbersFirst(input);
        } else {
            return parseNumbersLast(input);
        }
    }

    public String parseNumbersLast(String input) {
        final int firstNumberIndex = findElementInString(input);
        final String streetName = input.substring(0, firstNumberIndex - 1);
        final String houseNumber = input.substring(firstNumberIndex).trim();
        final JsonObject jsonAddress = new JsonObject();
        jsonAddress.addProperty("street", streetName);
        jsonAddress.addProperty("housenumber", houseNumber);
        return GSON.toJson(jsonAddress);
    }

    public String parseNumbersFirst(String input) {
        final int firstNumberIndex = findElementInString(input);
        final String streetName = input.substring(firstNumberIndex).trim();
        final String houseNumber = input.substring(0, firstNumberIndex - 1);
        final JsonObject jsonAddress = new JsonObject();
        jsonAddress.addProperty("street", streetName);
        jsonAddress.addProperty("housenumber", houseNumber);
        return GSON.toJson(jsonAddress);
    }

    @Test
    public void shouldParseOtherCountriesAddress1() {
        final String input = "4, rue de la revolution";
        final String expectedJson = "{\"street\":\"rue de la revolution\",\"housenumber\":\"4\"}";
        final String actualJson = selectParseMethod(input);
        assertEquals(actualJson, expectedJson);
    }

    @Test
    public void shouldParseOtherCountriesAddress2() {
        final String input = "200 Broadway Av";
        final String expectedJson = "{\"street\":\"Broadway Av\",\"housenumber\":\"200\"}";
        final String actualJson = selectParseMethod(input);
        assertEquals(actualJson, expectedJson);
    }

    @Test
    public void shouldParseOtherCountriesAddress3() {
        final String input = "Calle Aduana, 29";
        final String expectedJson = "{\"street\":\"Calle Aduana\",\"housenumber\":\"29\"}";
        final String actualJson = selectParseMethod(input);
        assertEquals(actualJson, expectedJson);
    }

    @Test
    public void shouldParseOtherCountriesAddress4() {
        final String input = "Calle 39 No 1540";
        final String expectedJson = "{\"street\":\"Calle 39\",\"housenumber\":\"No 1540\"}";
        final String actualJson = selectParseMethod(input);
        assertEquals(actualJson, expectedJson);
    }

}
