package gitgub;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SelenideRepositorySearch {

    @BeforeAll
    static void setUp() {
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void shouldFindSelenideRepositoryAtTheTop() {
        open("https://github.com/");
        $(".search-input").click();
        //$(".search-input").setValue("selenide").pressEnter();
        $("[name = query-builder-test]").setValue("selenide").pressEnter();
        $$("div [data-testid = results-list]").first().$("a").click();


        //проверка
        $("#repository-container-header").shouldHave(text("selenide / selenide"));
    }
}
