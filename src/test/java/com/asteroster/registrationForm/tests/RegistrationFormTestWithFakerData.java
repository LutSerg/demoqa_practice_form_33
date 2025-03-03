package com.asteroster.registrationForm.tests;

import com.asteroster.registrationForm.pages.RegistrationPage;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import java.util.Locale;


public class RegistrationFormTestWithFakerData extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    TestData testData = new TestData();



    @Test
    void registrationFormTest() {

        registrationPage.openPage()

                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setUserEmail(testData.email)
                .setGender(testData.gender)
                .setUserNumber(testData.phone)
                .setDateOfBirth(testData.dayOfBirth, testData.month, testData.yearOfBirth)
                .setSubject(testData.subject)
                .setHobby(testData.hobbies)
                .setPicture(testData.photo)
                .setCurrentAddress(testData.userAdress)
                .setState(testData.state)
                .setCity(testData.city)
                .submit()

                .submitTable(testData.submitTableText)

                .checkResult("Student Name", testData.firstName + " " + testData.lastName)
                .checkResult("Student Email", testData.email)
                .checkResult("Gender", testData.gender)
                .checkResult("Mobile", testData.phone)
                .checkResult("Date of Birth", testData.dayOfBirth + " " + testData.month + "," + testData.yearOfBirth)
                .checkResult("Subjects", testData.subject)
                .checkResult("Hobbies", testData.hobbies)
                .checkResult("Picture", testData.photo)
                .checkResult("Address", testData.userAdress)
                .checkResult("State and City", testData.state + " " + testData.city)

                .closeTable();
    }

    @Test
    public void minimalLinesTest() {

        registrationPage.openPage()

                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setGender(testData.gender)
                .setUserNumber(testData.phone)
                .submit()
                .submitTable(testData.submitTableText)

                .checkResult("Student Name", testData.firstName + " " + testData.lastName)
                .checkResult("Gender", testData.gender)
                .checkResult("Mobile", testData.phone)
                .closeTable();
    }

    @Test
    public void registrationPageNegativeTest() {
        registrationPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setUserEmail(testData.email)
                .setUserNumber(testData.phone)
                .setSubject(testData.subject)
                .setPicture(testData.photo)
                .setCurrentAddress(testData.submitTableText)
                .submit()
                .submitTableNegative();
    }
}
