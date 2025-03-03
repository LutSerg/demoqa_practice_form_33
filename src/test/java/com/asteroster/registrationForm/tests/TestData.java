package com.asteroster.registrationForm.tests;

import com.github.javafaker.Faker;

import java.util.Locale;

public class TestData {
    Faker faker = new Faker(new Locale("en"));

    String firstName = faker.name().firstName(), // Emory
            lastName = faker.name().lastName(), // Barton
            email = faker.internet().emailAddress(),
            phone = faker.phoneNumber().subscriberNumber(10),
            gender = faker.options().option("Male", "Female", "Other"),
            hobbies = faker.options().option("Sports", "Reading", "Music"),
            subject = faker.options().option(
                    "Maths",
                    "History",
                    "English",
                    "Arts",
                    "Computer Science",
                    "Physics"),
            dayOfBirth = String.valueOf(getDayOfBirth()),
            yearOfBirth = String.valueOf(getYearOfBirth()),
            month = faker.options().option("January",
                    "February",
                    "March",
                    "April",
                    "May",
                    "June",
                    "July",
                    "August",
                    "September",
                    "October",
                    "November",
                    "December"),
            state = getState(),
            city = getCity(state),
            photo = "Rattus.jpg",
            userAdress = faker.address().fullAddress(),
            submitTableText = "Thanks for submitting the form";

    private Integer getDayOfBirth(){
        return faker.number().numberBetween(1,28);
    }

    private Integer getYearOfBirth(){
        return faker.number().numberBetween(1970,2010);
    }

    public String getState() {
        return faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");

    }

    public String getCity(String state) {
        if (state.equals("NCR")) {
            return faker.options().option("Delhi", "Gurgaon", "Noida");
        }

        if (state.equals("Uttar Pradesh")) {
            return faker.options().option("Agra", "Lucknow", "Merrut");
        }

        if (state.equals("Haryana")) {
            return faker.options().option("Karnal", "Panipat");
        }

        if (state.equals("Rajasthan")) {
            return faker.options().option("Jaipur", "Jaiselmer");
        }

        return null;
    }

}
