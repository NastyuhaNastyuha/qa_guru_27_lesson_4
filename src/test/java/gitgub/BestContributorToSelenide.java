package gitgub;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;

public class BestContributorToSelenide {

    @BeforeAll
    static void setUp() {
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void andreiSolntsevShouldBeTheFirstContributor() {
        open("https://github.com/selenide/selenide");
        $(".Layout-sidebar").$(byText("Contributors"))
                .closest(".BorderGrid-cell").$$("ul li").first().hover();
        $(".Popover-message").shouldHave(text("Andrei Solntsev"));
    }
}
