package sovcombank.example.testcase.ui.tests.sovcombank.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SovcomBankVacanciesPage {

    private final String URL = "https://people.sovcombank.ru/vacancies";
    // можно создать класс обертку для UI элементов
    // Пример:
    // public class UIElement() {
    //      Selenide element;
    //      String nameButton;
    // }
    // и таким образом передавая его генерировать allure отчеты с наименованием кнопок через аннотацию @Step в методах
    private SelenideElement selectCityButton = $(By.xpath(".//div[@id='main-menu']//i[@class='icon icon_size_location icon_arrow-down ml-3']"));

    private SelenideElement selectCityField = $(By.id("input-110"));

    private SelenideElement selectOneElementFromListButton = $(By.id("list-110"));

    private SelenideElement selectCompanyField = $(By.xpath("(.//i[@class='v-icon notranslate mdi mdi-menu-down theme--light'])[2]"));

    private SelenideElement selectCovcomBankCompanyCheckBox = $(By.xpath("(.//div[@class='v-input--selection-controls__input'])[3]"));

    public String getURL() {
        return URL;
    }


    public SelenideElement getSelectCityButton() {
        return selectCityButton;
    }

    public void setSelectCityButton(SelenideElement selectCityButton) {
        this.selectCityButton = selectCityButton;
    }

    public SelenideElement getSelectCityField() {
        return selectCityField;
    }

    public void setSelectCityField(SelenideElement selectCityField) {
        this.selectCityField = selectCityField;
    }

    public SelenideElement getSelectOneElementFromListButton() {
        return selectOneElementFromListButton;
    }

    public void setSelectOneElementFromListButton(SelenideElement selectOneElementFromListButton) {
        this.selectOneElementFromListButton = selectOneElementFromListButton;
    }

    public SelenideElement getSelectCompanyField() {
        return selectCompanyField;
    }

    public void setSelectCompanyField(SelenideElement selectCompanyField) {
        this.selectCompanyField = selectCompanyField;
    }

    public SelenideElement getSelectCovcomBankCompanyCheckBox() {
        return selectCovcomBankCompanyCheckBox;
    }

    public void setSelectCovcomBankCompanyCheckBox(SelenideElement selectCovcomBankCompanyCheckBox) {
        this.selectCovcomBankCompanyCheckBox = selectCovcomBankCompanyCheckBox;
    }

}
