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
        Assert.assertEquals("Winterallee 3", json.getStreet() + " " + json.getHousenumber());
    }

    @Test
    public void secondTest() throws IOException {
        String jsonString = "{\"street\": \"Musterstrasse\", \"housenumber\": \"45\"}";
        AddressSolution2 json = LoganSquare.parse(jsonString, AddressSolution2.class);
        Assert.assertEquals("Musterstrasse 45", json.getStreet() + " " + json.getHousenumber());
    }

    @Test
    public void thirdTest() throws IOException {
        String jsonString = "{\"street\": \"Blaufeldweg\", \"housenumber\": \"123B\"}";
        AddressSolution2 json = LoganSquare.parse(jsonString, AddressSolution2.class);
        Assert.assertEquals("Blaufeldweg 123B", json.getStreet() + " " + json.getHousenumber());
    }

    // 2. Consider more complicated cases

    @Test
    public void fourthTest() throws IOException {
        String jsonString = "{\"street\": \"Am Bächle\", \"housenumber\": \"23\"}";
        AddressSolution2 json = LoganSquare.parse(jsonString, AddressSolution2.class);
        Assert.assertEquals("Am Bächle 23", json.getStreet() + " " + json.getHousenumber());
    }

    @Test
    public void fifthTest() throws IOException {
        String jsonString = "{\"street\": \"Auf der Vogelwiese\", \"housenumber\": \"23 b\"}";
        AddressSolution2 json = LoganSquare.parse(jsonString, AddressSolution2.class);
        Assert.assertEquals("Auf der Vogelwiese 23 b", json.getStreet() + " " + json.getHousenumber());
    }

    // 3. BONUS: Consider other countries (complex cases)

    //TODO


}
