package tests;


import com.bluelinelabs.logansquare.LoganSquare;
import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;

import java.io.IOException;

@JsonObject
public class AddressSolution2 {
    @JsonField(name = "street")
    public String street;
    @JsonField(name = "housenumber")
    public int housenumber;

    public void say() {
        System.out.println();
        System.out.println("I am leaving on the street name " + street + " and  my house number is " + housenumber + " in Berlin");
    }

    public static void main(String[] args) throws IOException {
        String jsonString = "{\"street\": \"Winterallee\", \"housenumber\": \"3\"}";
        AddressSolution2 addressSolution2 = LoganSquare.parse(jsonString, AddressSolution2.class);
        addressSolution2.say();
    }

}
