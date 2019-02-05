package tests;


import com.bluelinelabs.logansquare.LoganSquare;
import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

@JsonObject
public class AddressSolution2 {
    @JsonField(name = "street")
    public String street;
    @JsonField(name = "housenumber")
    public String housenumber;

    public String getStreet() {
        return street;
    }

    public String getHousenumber() {
        return housenumber;
    }

    // 1. Write a simple program that does the task for the most simple cases, e.g.

    @Test
    public void firstTest() throws IOException {
        String jsonString = "{\"street\": \"Winterallee\", \"housenumber\": \"3\"}";
        AddressSolution2 json = LoganSquare.parse(jsonString, AddressSolution2.class);
        Assert.assertEquals(json.getStreet() + " " + json.getHousenumber(), "Winterallee 3");
    }

    @Test
    public void secondTest() throws IOException {
        String jsonString = "{\"street\": \"Musterstrasse\", \"housenumber\": \"45\"}";
        AddressSolution2 json = LoganSquare.parse(jsonString, AddressSolution2.class);
        Assert.assertEquals(json.getStreet() + " " + json.getHousenumber(), "Musterstrasse 45");
    }

    @Test
    public void thirdTest() throws IOException {
        String jsonString = "{\"street\": \"Blaufeldweg\", \"housenumber\": \"123B\"}";
        AddressSolution2 json = LoganSquare.parse(jsonString, AddressSolution2.class);
        Assert.assertEquals(json.getStreet() + " " + json.getHousenumber(), "Blaufeldweg 123B");
    }

    // 2. Consider more complicated cases

    @Test
    public void fourthTest() throws IOException {
        String jsonString = "{\"street\": \"Am Bächle\", \"housenumber\": \"23\"}";
        AddressSolution2 json = LoganSquare.parse(jsonString, AddressSolution2.class);
        Assert.assertEquals(json.getStreet() + " " + json.getHousenumber(), "Am Bächle 23");
    }

    @Test
    public void fifthTest() throws IOException {
        String jsonString = "{\"street\": \"Auf der Vogelwiese\", \"housenumber\": \"23 b\"}";
        AddressSolution2 json = LoganSquare.parse(jsonString, AddressSolution2.class);
        Assert.assertEquals(json.getStreet() + " " + json.getHousenumber(), "Auf der Vogelwiese 23 b");
    }

    // 3. BONUS: Consider other countries (complex cases)

    @Test
    public void seventhTest() throws IOException {
        String jsonString = "{\"street\": \"rue de la revolution\", \"housenumber\": \"4\"}";
        AddressSolution2 json = LoganSquare.parse(jsonString, AddressSolution2.class);
        Assert.assertEquals(json.getHousenumber() + ", " + json.getStreet(), "4, rue de la revolution");
    }

    @Test
    public void eighthTest() throws IOException {
        String jsonString = "{\"street\": \"Broadway Av\", \"housenumber\": \"200\"}";
        AddressSolution2 json = LoganSquare.parse(jsonString, AddressSolution2.class);
        Assert.assertEquals(json.getHousenumber() + " " + json.getStreet(), "200 Broadway Av");
    }

    @Test
    public void ninthTest() throws IOException {
        String jsonString = "{\"street\": \"Calle Aduana\", \"housenumber\": \"29\"}";
        AddressSolution2 json = LoganSquare.parse(jsonString, AddressSolution2.class);
        Assert.assertEquals(json.getStreet() + ", " + json.getHousenumber(), "Calle Aduana, 29");
    }

    @Test
    public void tenthTest() throws IOException {
        String jsonString = "{\"street\": \"Calle 39\", \"housenumber\": \"No 1540\"}";
        AddressSolution2 json = LoganSquare.parse(jsonString, AddressSolution2.class);
        Assert.assertEquals(json.getStreet() + " " + json.getHousenumber(), "Calle 39 No 1540");
    }


}
