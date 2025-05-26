package utilities;

import com.github.javafaker.Faker;

public class FakerUtility {

    private static final Faker faker = new Faker();

    public static String generateName() {
        return faker.name().fullName();
    }

    public static String generateAddress() {
        return faker.address().fullAddress();
    }

    public static String generateEmail() {
        return faker.internet().emailAddress();
    }

    public static String generatePhoneNumber() {
        return faker.phoneNumber().cellPhone();
    }

    public static String generateDeliveryTime() {
        return faker.number().digit();
    }

    public static String generateDeliveryLimit() {
    	 return faker.number().digit();
    }
}
