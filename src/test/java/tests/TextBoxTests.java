package tests;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

public class TextBoxTests extends TestBase {
    TextBoxPage textBoxPage = new TextBoxPage();
    @Test
    void fillFormTest() {
        textBoxPage.openPage()
                .setUserName("Alex")
                .setUserEmail("alex@cooller.ru")
                .setUserCurrentAddress("Moscow")
                .setUserPermanentAddress("Kurovskoe")
                .submitForm()
                .checkResult("name", "Alex")
                .checkResult("email", "alex@cooller.ru")
                .checkResult("currentAddress", "Moscow")
                .checkResult("permanentAddress", "Kurovskoe");
    }
}
