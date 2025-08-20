package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.ModalComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationWithPageObjects extends TestBase {

RegistrationPage registrationPage = new RegistrationPage();
ModalComponent modalComponent= new ModalComponent();

    @Test
    void fillFormTest() {

        registrationPage.openPage()
                .setFirstName("Alex")
                .setLastName("Cooller")
                .setEmail("alex@cooller.com")
                .setGender("Male")
                .setPhoneNumber("9991112233")
                .setDateOfBirth("29", "April", "1999")
                .setSubject("Maths")
                .setHobby("Sports")
                .setHobby("Reading")
                .setHobby("Music")
                .setPicture("image_1.jpg")
                .setAddress("Moscow")
                .setState("NCR")
                .setCity("Delhi")
                .submitForm();
        modalComponent.checkModalIsOpen()
                .checkResult("Student Name", "Alex Cooller")
                .checkResult("Student Email", "alex@cooller.com")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "9991112233")
                .checkResult("Date of Birth", "29 April,1999")
                .checkResult("Subjects", "Maths")
                .checkResult("Hobbies", "Sports, Reading, Music")
                .checkResult("Picture", "image_1.jpg")
                .checkResult("Address", "Moscow")
                .checkResult("State and City", "NCR Delhi")
                .closeModal();
    }

    @Test
    void fillMinimalFormTest() {
        registrationPage.openPage()
                .setFirstName("Alex")
                .setLastName("Cooller")
                .setGender("Male")
                .setPhoneNumber("9991112233")
                .submitForm();
        modalComponent.checkModalIsOpen()
                .checkResult("Student Name", "Alex Cooller")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "9991112233")
                .closeModal();
    }

    @Test
    void fillNegativeFormTest() {
        registrationPage.openPage()
                .submitForm()
                .checkValidation();
        modalComponent.checkModalIsNotOpen();
    }














}


