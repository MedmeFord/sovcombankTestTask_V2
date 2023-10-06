package sovcombank.example.testcase.ui;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;


public class BaseTest {

    private final Long WAIT_ELEMENT_TIME = 10L;
    @BeforeAll
    public static void init() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 60;
    }

    public SelenideElement xpathSearchElement(String xpath) {
        return $(By.xpath(xpath));
    }

    public SelenideElement idSearchElement(String id) {
        return $(By.id(id)).shouldBe(Condition.visible, Duration.ofSeconds(WAIT_ELEMENT_TIME));
    }

    public void fillPlaceByElement(SelenideElement element, String value) {
        element.setValue(value).shouldBe(Condition.visible, Duration.ofSeconds(WAIT_ELEMENT_TIME));
    }

    public static void click(SelenideElement element) {
        element.shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
    }

    public static void doubleClick(SelenideElement element) {
        element.shouldBe(Condition.visible, Duration.ofSeconds(10)).doubleClick();
    }

    public String getTextByElement(SelenideElement element) {
        return element.shouldBe(Condition.visible, Duration.ofSeconds(WAIT_ELEMENT_TIME)).getText();
    }


}
