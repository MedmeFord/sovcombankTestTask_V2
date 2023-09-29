package sovcombank.example.testcase.ui;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;

import javax.lang.model.element.Element;
import java.time.Duration;
import java.util.LinkedList;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;


public class BaseTest {

    private final Long WAIT_ELEMENT_TIME = 10L;
    @BeforeAll
    public static void init() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
    }

    public void openWebSite() {

    }

    public SelenideElement xpathSearchElement(String xpath) {
        return $(By.xpath(xpath)).shouldBe(Condition.visible, Duration.ofSeconds(WAIT_ELEMENT_TIME));
    }

    public void click(SelenideElement element) {
        element.shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
    }


    public String getTextByXpath(String path) {
        return $(By.xpath(path)).shouldBe(Condition.visible, Duration.ofSeconds(WAIT_ELEMENT_TIME)).getText();
    }

    public String getTextByElement(SelenideElement element) {
        return element.shouldBe(Condition.visible, Duration.ofSeconds(WAIT_ELEMENT_TIME)).getText();
    }

    public String getAttribute(String cssSelector, String attribute) {
        return $(cssSelector).getAttribute("alt");
    }

    public ElementsCollection getSelenideElementsByXpath(String path) {
        return $$x(path);

    }

    public SelenideElement cssSelectorSearch(String cssSelector) {
        return $(By.cssSelector(cssSelector)).shouldBe(Condition.visible, Duration.ofSeconds(WAIT_ELEMENT_TIME));
    }

    public void waitElement(SelenideElement element) {
        element.shouldBe(Condition.exactText("111"), Duration.ofSeconds(WAIT_ELEMENT_TIME)).click();
    }

}
