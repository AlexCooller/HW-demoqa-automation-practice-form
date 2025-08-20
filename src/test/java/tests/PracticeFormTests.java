package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests {

    @BeforeAll
    static void onSettings() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Alex");
        $("#lastName").setValue("Cooller");
        $("#userEmail").setValue("alex@cooller.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("9991112233");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(4);
        $(".react-datepicker__year-select").selectOption(99);
        $(".react-datepicker__day--029").click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("image_1.jpg");
        $("#currentAddress").setValue("Moscow");
        $("#state").click();
        $(byText("NCR")).click();
        $("#city").click();
        $(byText("Delhi")).click();
        $("#submit").click();


        $(".modal-body").shouldHave(text("Alex"));
        $(".modal-body").shouldHave(text("Cooller"));
        $(".modal-body").shouldHave(text("alex@cooller.com"));
        $(".modal-body").shouldHave(text("Male"));
        $(".modal-body").shouldHave(text("9991112233"));
        $(".modal-body").shouldHave(text("29 April,1999"));
        $(".modal-body").shouldHave(text("Maths"));
        $(".modal-body").shouldHave(text("Sports, Reading, Music"));
        $(".modal-body").shouldHave(text("image_1.jpg"));
        $(".modal-body").shouldHave(text("Moscow"));
        $(".modal-body").shouldHave(text("NCR Delhi"));











    }


}


