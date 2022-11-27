package old_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;

import java.util.ArrayList;
import java.util.List;

public class Albina_starTest extends BaseTest {
    final String BASE_URL = "https://www.99-bottles-of-beer.net/";
    final static By TOP_LIST_MENU = By.xpath("//ul[@id= 'menu']//li/a[@href='/toplist.html']");
    final static By TOP_LIST_MENU_LIST = By.xpath("//ul[@id=\"submenu\"]/li/a");
    final static By FOOTER_SEARCH_LANGUAGE = By.xpath("//div[@id=\"footer\"]/p/a[3]");
    final static By SEARCH_LANGUAGES_HEADER = By.xpath("//div[@id=\"main\"]/h2");
    final static By SEARCH_FOR = By.xpath("//div/div[3]/form/p/input[1]");
    final static By MAIN_SUBMIT_NEW_LANGUAGE = By.xpath("//ul[@id= 'menu']//li/a[@href='/submitnewlanguage.html']");
    final static By PLEASE_NOTE = By.xpath("//div[@id=\"main\"]/h3");
    final static By PLEASE_NOTE_LIST = By.xpath("//div[@id='main']/ul/li");
    final static By SUBMIT_LANGUAGE_BUTTON = By.xpath("//p/input[@name='submitlanguage']");
    final static By ERROR_MESSAGE = By.xpath("//div[@id='main']/p[@style]");

    private void openBaseURL(WebDriver driver) {
        driver.get(BASE_URL);
    }

    private WebElement getElement(By by, WebDriver driver) {

        return driver.findElement(by);
    }

    private void click(By by, WebDriver driver) {
        getElement(by, driver).click();
    }

    private List<WebElement> getListOfElements(By by, WebDriver driver) {

        return driver.findElements(by);
    }

    private List<String> getElementsText(By by, WebDriver driver) {
        List<WebElement> elementsList = getListOfElements(by, driver);
        List<String> textList = new ArrayList<>();

        for (WebElement element : elementsList) {
            textList.add(element.getText());
        }

        return textList;
    }

    public String getText(By by) {

        return getDriver().findElement(by).getText();
    }

    public boolean isDisplayed(By by) {

        return getDriver().findElement(by).isDisplayed();
    }

    private int getListSize(By by, WebDriver driver) {

        return getListOfElements(by, driver).size();
    }

    public String getErrorMessageText(By by) {

        return getDriver().findElement(by).getText();
    }

    @Test
    public void testSearchForLanguageByName_HappyPath() {
        final String BASE_URL = "https://99-bottles-of-beer.net/";
        final String LANGUAGE_PYTHON = "python";

        getDriver().get(BASE_URL);

        WebElement searchLanguagesMenu = getDriver().findElement(
                By.xpath("//ul[@id = 'menu']/li/a[@href = '/search.html']"));
        searchLanguagesMenu.click();

        WebElement searchForField = getDriver().findElement(By.name("search"));
        searchForField.click();
        searchForField.sendKeys(LANGUAGE_PYTHON);

        WebElement goButton = getDriver().findElement(By.name("submitsearch"));
        goButton.click();

        List<WebElement> languagesNamesList = getDriver().findElements(
                By.xpath("//table[@id='category']/tbody/tr/td[1]/a"));

        Assert.assertTrue(languagesNamesList.size() > 0);

        for (int i = 0; i < languagesNamesList.size(); i++) {
            Assert.assertTrue(languagesNamesList.get(i).getText().toLowerCase().contains(LANGUAGE_PYTHON));
        }
    }

    @Test
    public void testVerifyTextOfFooterMenuSearchLanguages_HappyPath() {
        final String SEARCH_LANGUAGES = "Search Languages";

        openBaseURL(getDriver());
        click(FOOTER_SEARCH_LANGUAGE, getDriver());
        getText(SEARCH_LANGUAGES_HEADER);

        String actualResultHeaderText = getText(SEARCH_LANGUAGES_HEADER);

        Assert.assertEquals(actualResultHeaderText, SEARCH_LANGUAGES);

        getElement(SEARCH_FOR, getDriver());

        Assert.assertTrue(isDisplayed(SEARCH_FOR));
    }

    @Test
    public void testVerifyListOfElementsOfMainTopListSubmenu_HappyPath() {
        List<String> expectedElementsOfTopListSubmenu = new ArrayList<>();
        expectedElementsOfTopListSubmenu.add("Top Rated");
        expectedElementsOfTopListSubmenu.add("Top Rated Real");
        expectedElementsOfTopListSubmenu.add("Top Rated Esoteric");
        expectedElementsOfTopListSubmenu.add("Top Rated Assembly");
        expectedElementsOfTopListSubmenu.add("Top Hits");
        expectedElementsOfTopListSubmenu.add("New Languages this month");
        expectedElementsOfTopListSubmenu.add("New Comments");

        openBaseURL(getDriver());
        click(TOP_LIST_MENU, getDriver());

        List<String> elementsOfTopListSubmenu = getElementsText(TOP_LIST_MENU_LIST, getDriver());

        Assert.assertTrue(elementsOfTopListSubmenu.size() > 0);

        Assert.assertEquals(elementsOfTopListSubmenu, expectedElementsOfTopListSubmenu);
    }

    @Test
    public void testVerifyQuantityOfMainSubmitNewLanguagePleaseNoteList_HappyPath() {
        int expectedQuantityOfPleaseNote = 10;

        openBaseURL(getDriver());
        click(MAIN_SUBMIT_NEW_LANGUAGE, getDriver());

        Assert.assertTrue(isDisplayed(PLEASE_NOTE));

        List<WebElement> elements = getDriver().findElements(PLEASE_NOTE_LIST);

        Assert.assertTrue(elements.size() >0);

        int actualQuantityOfPleaseNote = getListSize(PLEASE_NOTE_LIST, getDriver());
        Assert.assertEquals(actualQuantityOfPleaseNote, expectedQuantityOfPleaseNote);
    }

    @Test
    public void testErrorMessageSubmitLanguageButton_HappyPath() {
        final String expectedResultErrorMessageSubmitLanguageButton = "Error: " +
                "Precondition failed - Incomplete Input.";

        openBaseURL(getDriver());
        click(MAIN_SUBMIT_NEW_LANGUAGE, getDriver());
        click(SUBMIT_LANGUAGE_BUTTON, getDriver());
        getErrorMessageText(ERROR_MESSAGE);

        Assert.assertEquals(getText(ERROR_MESSAGE), expectedResultErrorMessageSubmitLanguageButton);
    }
}