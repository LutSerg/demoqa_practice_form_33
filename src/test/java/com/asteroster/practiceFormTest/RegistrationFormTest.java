package com.asteroster.practiceFormTest;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormTest {

    @BeforeAll
    static void BeforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void registrationFormTest() {
        open("/automation-practice-form");
        Selenide.executeJavaScript("$('#fixedban').remove()");
        Selenide.executeJavaScript("$('footer').remove()");
        $("#firstName").setValue("John");
        $("#lastName").setValue("Derrick");
        $("#userEmail").setValue("JohnDerrick@mail.qw");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("1954756852");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("May");
        $(".react-datepicker__year-select").selectOption("1985");
        $(".react-datepicker__day--027:not(react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("Arts").pressEnter();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("Rattus.jpg");
        $("#currentAddress").setValue("Some text for Current Address");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Haryana")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Panipat")).click();
        $("#submit").click();

        $(".modal-content").shouldBe(appear);
        $(".modal-content").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").$(byText("Student Name")).parent()
                .shouldHave(text("John Derrick"));
        $(".table-responsive").$(byText("Student Email")).parent()
                .shouldHave(text("JohnDerrick@mail.qw"));
        $(".table-responsive").$(byText("Gender")).parent()
                .shouldHave(text("Male"));
        $(".table-responsive").$(byText("Mobile")).parent()
                .shouldHave(text("1954756852"));
        $(".table-responsive").$(byText("Date of Birth")).parent()
                .shouldHave(text("27 May,1985"));
        $(".table-responsive").$(byText("Subjects")).parent()
                .shouldHave(text("Arts"));
        $(".table-responsive").$(byText("Hobbies")).parent()
                .shouldHave(text("Music"));
        $(".table-responsive").$(byText("Picture")).parent()
                .shouldHave(text("Rattus.jpg"));
        $(".table-responsive").$(byText("Address")).parent()
                .shouldHave(text("Some text for Current Address"));
        $(".table-responsive").$(byText("State and City")).parent()
                .shouldHave(text("Haryana Panipat"));

        $("#closeLargeModal").click();
    }
}
