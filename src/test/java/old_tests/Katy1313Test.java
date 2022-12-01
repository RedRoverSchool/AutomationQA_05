package old_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Katy1313Test extends BaseTest {
    final String BASE_URL = "https://www.99-bottles-of-beer.net/";
    static final String LETTER = "j";
    static final String LANGUAGE_NAME = "Java";

    final static By SEARCH_LANGUAGES_MENU = By.xpath("//ul[@id = 'menu']/li/a[@href = '/search.html']");
    final static By SEARCH_FOR_FIELD = By.name("search");
    final static By GO_BUTTON = By.name("submitsearch");
    final static By LANGUAGES_NAMES_LIST = By.xpath("//table[@id='category']/tbody/tr/td[1]/a");
    final static By BROWSE_LANGUAGES_MENU = By.xpath("//ul[@id = 'menu']//a[@href = '/abc.html']");
    final static By H_2_CATEGORY = By.xpath("//div[@id ='main']/h2[contains(text(), 'A')]");
    final static By CATEGORY_LETTER = By.xpath("//ul[@id='submenu']//a[@href='p.html']");
    final static By LANGUAGES_NAMES_LIST_DISPLAYED = By.xpath("//table[@id='category']/tbody//a");
    final static By CATEGORY_LETTER_2 = By.xpath("//ul[@id='submenu']//a[@href='" + LETTER + ".html']");
    final static By LANGUAGE_NAME_2 = By.xpath("//table[@id='category']//td/a[text() = '" + LANGUAGE_NAME + "']");
    final static By H_2_HEADER_TITLE = By.xpath("//h2[text() = 'Language " + LANGUAGE_NAME + "']");

    private void openBaseURL(WebDriver driver) {
        driver.get(BASE_URL);
    }

    private WebElement getElement(By by, WebDriver driver) {

        return driver.findElement(by);
    }

    private List<WebElement> getListOfElements(By by, WebDriver driver) {

        return driver.findElements(by);
    }

    private void click(By by, WebDriver driver) {
        getElement(by, driver).click();
    }

    private void input(String text, By by, WebDriver driver) {
        getElement(by, driver).sendKeys(text);
    }

    private int getListSize(By by, WebDriver driver) {

        return getListOfElements(by, driver).size();
    }

    private int getListSize(List<String> list) {

        return list.size();
    }

    private List<String> getElementsText(By by, WebDriver driver) {
        List<WebElement> elementsList = getListOfElements(by, driver);
        List<String> textList = new ArrayList<>();

        for (WebElement element : elementsList) {
            textList.add(element.getText().toLowerCase());
        }

        return textList;
    }

    private void sortElementsText(By by, WebDriver driver) {
        List<WebElement> elementsList = getListOfElements(by, driver);
        List<String> textList = new ArrayList<>();
        List<String> textList1 = new ArrayList<>();

        for (WebElement element : elementsList) {
            textList.add(element.getText().toLowerCase());
            textList1.add(element.getText().toLowerCase());
        }
        Collections.sort(textList1);
    }

    private String getElementText(By by, WebDriver driver) {

        return getElement(by, driver).getText();
    }

    @Test
    public void testSearchLanguageByName_HappyPath() {
        final String LANGUAGE_NAME = "python";

        openBaseURL(getDriver());
        click(SEARCH_LANGUAGES_MENU, getDriver());
        click(SEARCH_FOR_FIELD, getDriver());
        input(LANGUAGE_NAME, SEARCH_FOR_FIELD, getDriver());
        click(GO_BUTTON, getDriver());

        List<String> languageNames = getElementsText(LANGUAGES_NAMES_LIST, getDriver());
        int sizeOfLangNamesList = getListSize(getElementsText(LANGUAGES_NAMES_LIST, getDriver()));

        Assert.assertTrue(languageNames.size() > 0);

        for (String languageName : languageNames) {
            Assert.assertTrue(languageName.contains(LANGUAGE_NAME));
        }
    }

    @Test
    public void testBrowseLanguagesDefaultHeader_HappyPath() {
        final String BROWSE_LANGUAGES_DEFAULT_HEADER = "Category A";

        openBaseURL(getDriver());
        click(BROWSE_LANGUAGES_MENU, getDriver());

        Assert.assertEquals(getElementText(H_2_CATEGORY, getDriver()), BROWSE_LANGUAGES_DEFAULT_HEADER);
    }

    @Test
    public void testBrowseLanguagesLanguagesSortedAscending_HappyPath() {

        openBaseURL(getDriver());
        click(BROWSE_LANGUAGES_MENU, getDriver());
        click(CATEGORY_LETTER, getDriver());

        List<String> displayed = new ArrayList<String>();
        List<String> sorted = new ArrayList<String>();

        Assert.assertTrue(getListSize(LANGUAGES_NAMES_LIST_DISPLAYED, getDriver()) > 0);

        sortElementsText(LANGUAGES_NAMES_LIST_DISPLAYED, getDriver());
        Assert.assertEquals(displayed, sorted);
    }

    @Test
    public void testBrowseLanguagesLanguageSelectionH2HeaderTitle_HappyPath() {
        final String EXPECTED_RESULT_H2_TITLE = "Language Java";

        openBaseURL(getDriver());
        click(BROWSE_LANGUAGES_MENU, getDriver());
        click(CATEGORY_LETTER_2, getDriver());
        click(LANGUAGE_NAME_2, getDriver());
        getElement(H_2_HEADER_TITLE, getDriver());

        Assert.assertEquals(getElementText(H_2_HEADER_TITLE, getDriver()), EXPECTED_RESULT_H2_TITLE);
    }
}
