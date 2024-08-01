import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


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
    void formCompleteSuccess() {
        open("/automation-practice-form");
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
        $(".modal-body").shouldHave(Condition.text("Elena"));
        $(".modal-body").shouldHave(Condition.text("Voronina"));
    }
}

//        $(byText("Female")).click();
//        $("#gender-radio-2").parent().click();