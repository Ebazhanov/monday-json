package schema;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class AddressParser {
    private final static Gson GSON = new Gson();

    public String parse(String input) {
        final int firstNumberIndex = findFirstNumberInString(input);
        final String streetName = input.substring(0, firstNumberIndex - 1);
        final String houseNumber = input.substring(firstNumberIndex);
        final JsonObject jsonAddress = new JsonObject();
        jsonAddress.addProperty("street", streetName);
        jsonAddress.addProperty("housenumber", houseNumber);
        return GSON.toJson(jsonAddress);
    }

    private int findFirstNumberInString(String input) {
        for (int index = 0; index < input.length(); index++) {
            final char charAt = input.charAt(index);
            if (Character.isDigit(charAt)) {
                return index;
            }
        }
        return -1;
    }

}
