package sovcombank.example.testcase.ui.tests.sovcombank.uitest;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import sovcombank.example.testcase.ui.BaseTest;
import sovcombank.example.testcase.ui.tests.sovcombank.pages.SovcomBankVacanciesPage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Selenide.$$x;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PositiveTest extends BaseTest {

    @Test
    public void checkVacanciesFiltersTest() {
        SovcomBankVacanciesPage sovcomBankPage = new SovcomBankVacanciesPage();

        Selenide.open(sovcomBankPage.getURL());

        click(sovcomBankPage.getSelectCityButton());
        click(sovcomBankPage.getSelectCityField());
        fillPlaceByElement(sovcomBankPage.getSelectCityField(), "Москва");
        click(sovcomBankPage.getSelectOneElementFromListButton());

        doubleClick(sovcomBankPage.getSelectCompanyField());
        click(sovcomBankPage.getSelectCovcomBankCompanyCheckBox());
        Selenide.sleep(4000);

        ElementsCollection vacanciesCollection = $$x(".//div[@class='block-vacancy']//span");
        for (SelenideElement vacancy: vacanciesCollection) {
           String str = getTextByElement(vacancy);
            System.out.println(str);
            boolean containsMoscow = str.contains("Москва");
            boolean containsSovkombank = str.contains("Совкомбанк Технологии");

            System.out.println(containsMoscow);
            assertTrue(containsMoscow);
            assertTrue(containsSovkombank);
        }


    }
}
