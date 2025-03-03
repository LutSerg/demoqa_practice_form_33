package com.asteroster.registrationForm.pages;

import com.asteroster.registrationForm.pages.components.CalendarComponent;
import com.asteroster.registrationForm.pages.components.CheckResultTableComponent;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;

import java.util.Locale;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

    CalendarComponent calendarComponent = new CalendarComponent();
    CheckResultTableComponent checkResultTableComponent = new CheckResultTableComponent();

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        Selenide.executeJavaScript("$('#fixedban').remove()");
        Selenide.executeJavaScript("$('footer').remove()");

        return this;
    }
    private SelenideElement firstNameLocator = $("#firstName"),
                            lastNameLocator = $("#lastName"),
                            userEmailLocator = $("#userEmail"),
                            genterWrapperLocator = $("#genterWrapper"),
                            setUserNumber = $("#userNumber"),
                            setDateLocator = $("#dateOfBirthInput"),
                            setSubjectLocator = $("#subjectsInput"),
                            setHobbyLocator = $("#hobbiesWrapper"),
                            setPictureLocator = $("#uploadPicture"),
                            setCurrentAddressLocator = $("#currentAddress"),
                            setStateLocator = $("#state"),
                            setCityLocator = $("#city"),
                            setStateCityLocator = $("#stateCity-wrapper"),
                            submitButtonLocator = $("#submit"),
                            resultTableLocator = $(".modal-content"),
                            closeTableLocator = $("#closeLargeModal");



    public RegistrationPage setFirstName(String value) {
        firstNameLocator.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameLocator.setValue(value);

        return this;
    }

    public RegistrationPage setUserEmail(String value) {
        userEmailLocator.setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value) {
        genterWrapperLocator.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setUserNumber(String value) {
        setUserNumber.setValue(value);

        return this;
    }

    public RegistrationPage setDateOfBirth (String day, String month, String year) {
        setDateLocator.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationPage setSubject(String value) {
        setSubjectLocator.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage setHobby(String value) {
        setHobbyLocator.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setPicture(String value) {
        setPictureLocator.uploadFromClasspath(value);

        return this;
    }

    public RegistrationPage setCurrentAddress(String value) {
        setCurrentAddressLocator.setValue(value);

        return this;
    }

    public RegistrationPage setState(String value) {
        setStateLocator.click();
        setStateCityLocator.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setCity(String value) {
        setCityLocator.click();
        setStateCityLocator.$(byText(value)).click();

        return this;
    }

    public RegistrationPage submit() {
        submitButtonLocator.click();

        return this;
    }

    public RegistrationPage submitTable(String value) {
        resultTableLocator.shouldBe(appear);
        resultTableLocator.shouldHave(text(value));

        return this;
    }

    public RegistrationPage submitTableNegative() {
        resultTableLocator.shouldNotBe(appear);

        return this;
    }

    public RegistrationPage checkResult(String key, String value) {
        checkResultTableComponent.checkResultTable(key,value);

        return this;
    }


    public RegistrationPage closeTable() {
        closeTableLocator.click();

        return this;
    }
}
