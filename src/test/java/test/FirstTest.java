package test;

import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class FirstTest {


    File file = new File("src/test/resources/images/bear.jpeg");


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
        $("#currentAddress").shouldHave(attribute("value", "kiev"));
        $("#permanentAddress").shouldHave(attribute("value", "lviv"));

    }


    @Test
    void FillFormTest2() {


        open("https://demoqa.com/automation-practice-form");

        //Зміна параметрів розміру сторінки
        executeJavaScript(
                "document.body.style = 'transform: scale(0.90)'");
        executeJavaScript(
                "document.body.style = 'transform: scale(0.80)'");
        executeJavaScript(
                "document.body.style = 'transform: scale(0.75)'");



        $("#firstName").setValue("Dron");
        $("[id=lastName]").setValue("Flash");
        $("[id=userEmail]").setValue("DronFlash@mail.com");
        $(by("for", "gender-radio-1")).click();
        $("[id=userNumber]").setValue("0101010101");

        //вибір елементів з календаря
        $("[id=dateOfBirthInput]").click();
        $(".react-datepicker__year-select").selectOptionByValue("1991");
        $(".react-datepicker__month-select").selectOptionByValue("0");
        $(".react-datepicker__day--013").click();


        //ввод даних-> виборка зі списку
        $("[id=subjectsInput]").setValue("Engl").pressEnter();
        $("[id=subjectsInput]").setValue("Mat").pressEnter();
        $("[id=subjectsInput]").setValue("Chem").pressEnter();


//        $(by("for", "hobbies-checkbox-2")).click();
//        $(by("for","hobbies-checkbox-1")).click();


        //завантаження файлу
        $("#uploadPicture").uploadFile(file);

        $("#currentAddress").setValue("World- Earth");

        $("#state").click();
        $(byText("NCR")).click();
        $("#city").click();
        $(byText("Noida")).click();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldBe(visible);
        $(".modal-body").shouldHave(
                (text("Dron")),
                (text("Flash")),
                (text("DronFlash@mail.com")),
                (text("Male")),
                (text("0101010101")),
                (text("13 January,1991")),
                (text("English, Maths, Chemistry")),
                (text("bear.jpeg")),
                (text("World- Earth")),
                (text("NCR Noida")));

    }

}