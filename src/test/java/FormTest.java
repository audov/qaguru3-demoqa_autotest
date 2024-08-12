import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FormTest {
    @BeforeAll
    public static void setUpAll() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void formCompleteSuccessTest() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("#firstName").setValue("Elena");
        $("#lastName").setValue("Voronina");
        $("#userEmail").setValue("elvor@mail.ru");
        $("label[for=gender-radio-2]").click();
        $("#userNumber").setValue("8791096432");
        $("#dateOfBirthInput").doubleClick();
        $(".react-datepicker__year-select").selectOption("1981");
        $(".react-datepicker__month-select").selectOption("January");
        $(".react-datepicker__day--013:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("Physics").pressEnter();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("label[for=hobbies-checkbox-1]").click();
        $("label[for=hobbies-checkbox-2]").click();
        $("#currentAddress").setValue("Rosamund street, 10-34A");
        $("#uploadPicture").uploadFromClasspath("pics/Screenshot 2024-07-28 114026.png");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Haryana")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Panipat")).click();
        $("#submit").click();

        $(".modal-content").shouldBe(Condition.visible);
        $(".modal-body").shouldHave(text("Elena"), text("Voronina"), text("elvor@mail.ru"), text("Female"), text("8791096432"));
        $(".modal-body").shouldHave(text("13 January,1981"));
        $(".modal-body").shouldHave(text("Physics"), text("Sports"));
        $(".modal-body").shouldHave(text("Screenshot 2024-07-28 114026.png"));
        $(".modal-body").shouldHave(text("Rosamund street, 10-34A"));
        $(".modal-body").shouldHave(text("Haryana"), text("Panipat"));
    }
}

//        $(byText("Female")).click();
//        $("#gender-radio-2").parent().click();