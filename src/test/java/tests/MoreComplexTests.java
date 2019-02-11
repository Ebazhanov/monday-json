package tests;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MoreComplexTests {

    private final static Gson GSON = new Gson();

    public static int findFirstNumberInString(String input) {
        for (int index = 0; index < input.length(); index++) {
            final char charAt = input.charAt(index);
            if (Character.isDigit(charAt)) {
                return index;
            }
        }
        return -1;
    }

    public String parse(String input) {
        //final int firstNumberIndex = findFirstNumberInString(input);


        int inputNo = input.indexOf("No");
        int inputСomma = input.indexOf(",");

        System.out.println(inputNo);
        if (inputNo > 0) {
            return String.valueOf(inputNo);
        } else if (inputСomma > 0) {
            return String.valueOf(inputСomma);
        } else if (inputNo < 0 | inputСomma < 0) {
            System.out.println("НЕТУ номера и запятой");
        }

        final String streetName = input.substring(0, inputNo - 1);
        final String houseNumber = input.substring(inputNo);


/*        if (input.indexOf(",") != 0) {
            System.out.println("ЗАПЯТАЯ");
        }*/

        final JsonObject jsonAddress = new JsonObject();

        jsonAddress.addProperty("street", streetName);
        jsonAddress.addProperty("housenumber", houseNumber);
        return GSON.toJson(jsonAddress);
    }

    @Test
    public void shouldParseComplicatedAddress1() {
        final String input = "Calle 39 No 1540";
        //int inputString = input.indexOf(",");

/*        if (inputString) {
            System.out.println(input.indexOf(","));
        }*/

        final String expectedJson = "{\"street\":\"Calle 39\",\"housenumber\":\"No 1540\"}";
        final String actualJson = parse(input);

        assertEquals(actualJson, expectedJson);
    }

}
