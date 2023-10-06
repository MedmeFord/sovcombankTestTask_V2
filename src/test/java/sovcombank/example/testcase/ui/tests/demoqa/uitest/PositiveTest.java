package sovcombank.example.testcase.ui.tests.demoqa.uitest;

//import com.codeborne.selenide.Selenide;
//import org.junit.jupiter.api.Test;
//
//import com.codeborne.selenide.Condition;
//import sovcombank.example.testcase.ui.BaseTest;
//import sovcombank.example.testcase.ui.tests.demoqa.pages.DemoQAPage;
//
//import java.time.Duration;
//
//import static com.codeborne.selenide.Selectors.byText;
//import static com.codeborne.selenide.Selenide.executeJavaScript;

// проблема с полноценной прогрузкой страницы
//public class PositiveTest extends BaseTest {
//
//
//    @Test
//    public void test() {
//

//        Selenide.open("https://demoqa.com/automation-practice-form");
//        Selenide.Wait().until(webDriver -> {
//            return executeJavaScript("return document.readyState").equals("complete");
//        });
//        Selenide.$(byText("Some element")).should(Condition.exist);
//
//        Selenide.Wait().withTimeout(Duration.ofSeconds(45));
//        DemoQAPage demoQAPage = new DemoQAPage();
//
//        demoQAPage.initElements();
//
//        System.out.println(demoQAPage.getNum());
//
//        fillPlaceByElement(demoQAPage.getFirstNameField(), "asgfaf");
//    }
//}
