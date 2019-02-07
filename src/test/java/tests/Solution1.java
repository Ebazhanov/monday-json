package tests;

public class Solution1 {

    /*private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public static void main(String[] args) {
        //TO JSON
        Address address = new Address( "Winterallee", 3);
        String json = GSON.toJson(address);
        System.out.println(json);

        //FROM JSON
        Address address1 = GSON.fromJson(json, Address.class);
        System.out.println(address1.getStreet());
        System.out.println(address1.getHouseNumber());
    }*/

    static class Address {
        private String street;
        private Integer houseNumber;

        Address(String street, Integer houseNumber) {
            this.street = street;
            this.houseNumber = houseNumber;
        }

        String getStreet() {
            return street;
        }

        Integer getHouseNumber() {
            return houseNumber;
        }
    }

}
