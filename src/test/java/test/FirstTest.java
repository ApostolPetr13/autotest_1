package test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class FirstTest {


   // @BeforeAll
   //static void browserConfig() {
    //    Configuration.browserSize = "1920x900";
   // }

    @Test
    void fillFormTest() {

        open("https://demoqa.com/text-box");
        $("#userName").setValue("Oleg");
        $("[id=userEmail]").setValue("oleg@pacan.com");
        $("[id=currentAddress]").setValue("kiev");
        $("[id=permanentAddress]").setValue("lviv");
        $("#submit").scrollTo().click();

        $("#output").shouldBe(visible);

        $("#name").shouldHave(text("Oleg"));
        $("#email").shouldHave(text("oleg@pacan.com"));
        $("#currentAddress").shouldHave(attribute("value","kiev"));
        $("#permanentAddress").shouldHave(attribute("value", "lviv"));

    }
}
