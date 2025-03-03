package com.asteroster.registrationForm.tests;

import com.asteroster.registrationForm.pages.RegistrationPage;
import org.junit.jupiter.api.Test;


public class RegistrationFormTestWithPageObjects extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void registrationFormTest() {

        registrationPage.openPage()

                .setFirstName("John")
                .setLastName("Derrick")
                .setUserEmail("JohnDerrick@mail.qw")
                .setGender("Male")
                .setUserNumber("1954756852")
                .setDateOfBirth("27", "May", "1985")
                .setSubject("Arts")
                .setHobby("Music")
                .setPicture("Rattus.jpg")
                .setCurrentAddress("Some text for Current Address")
                .setState("Haryana")
                .setCity("Panipat")
                .submit()

                .submitTable("Thanks for submitting the form")

                .checkResult("Student Name", "John Derrick")
                .checkResult("Student Email", "JohnDerrick@mail.qw")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "1954756852")
                .checkResult("Date of Birth", "27 May,1985")
                .checkResult("Subjects", "Arts")
                .checkResult("Hobbies", "Music")
                .checkResult("Picture", "Rattus.jpg")
                .checkResult("Address", "Some text for Current Address")
                .checkResult("State and City", "Haryana Panipat")

                .closeTable();
    }

    @Test
    public void minimalLinesTest() {

        registrationPage.openPage()

                .setFirstName("John")
                .setLastName("Derrick")
                .setGender("Male")
                .setUserNumber("1954756852")
                .submit()
                .submitTable("Thanks for submitting the form")

                .checkResult("Student Name", "John Derrick")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "1954756852")
                .closeTable();
    }

    @Test
    public void registrationPageNegativeTest() {
        registrationPage.openPage()
                .setFirstName("John")
                .setLastName("Derrick")
                .setUserEmail("JohnDerrick@mail.qw")
                .setUserNumber("1954756852")
                .setSubject("Arts")
                .setPicture("Rattus.jpg")
                .setCurrentAddress("Some text for Current Address")
                .submit()
                .submitTableNegative();
    }
}
