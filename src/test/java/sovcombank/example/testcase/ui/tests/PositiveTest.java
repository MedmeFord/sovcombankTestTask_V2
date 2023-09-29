package sovcombank.example.testcase.ui.tests;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import sovcombank.example.testcase.ui.BaseTest;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;


public class PositiveTest extends BaseTest {

    private final static String BASE_URL = "https://mail.ru/";


    @Test
    public void dollarExchangeRate() {
        open(BASE_URL);

        System.out.println( "$" + getTextByXpath(".//*[@data-testid='rates-item-usd']/div[@class='rate__info ocfaabp__1oxy56a']/div"));
        click(cssSelectorSearch("[data-testid='news-tabs-tab-item-hitech']"));

        sleep(1000);

        List<String> newsElement = new ArrayList<>();
        ElementsCollection collection = getSelenideElementsByXpath("//*[@class='news-item-container']//span");
        for (SelenideElement element: collection) {
           System.out.println("News: " + getTextByElement(element));
        }

        click(cssSelectorSearch("[data-testid='news-tabs-tab-item-hitech']"));

        switchTo().window(1);

        System.out.println("\n\n8 task: " + getAttribute("img.pm-logo__link__pic", "alt"));
    }
}
