package old_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;

import java.util.ArrayList;
import java.util.List;

public class IrynaDanilevskaTest extends BaseTest {

    final String BASE_URL = "https://www.99-bottles-of-beer.net/";
    final static By BROWSE_LANGUAGE_MENU = By.xpath("//div[@id='navigation']/ul//a[@href='/abc.html']");
    final static By SEARCH_LANGUAGE_MENU = By.xpath("//ul[@id='menu']/li/a[@href='/search.html']");
    final static By SEARCH_FIELD = By.name("search");
    final static By GO_BUTTON = By.name("submitsearch");
    final static By LIST_OF_LANGUAGES = By.xpath("//table[@id='category']/tbody/tr/td[1]/a");

    private void openBaseURL(WebDriver driver) {
        driver.get(BASE_URL);
    }

    private WebElement getElement(By by, WebDriver driver) {

        return driver.findElement(by);
    }

    private void clickOnElement(By by, WebDriver driver) {
        driver.findElement(by).click();
    }
    private void clickOnElement(WebElement webElement) {
        webElement.click();
    }
    private WebElement getSubmenuElementLettersNumbers(String letter, WebDriver driver) {
        return driver.findElement(
                By.xpath(String.format("//ul[@id='submenu']//a[@href='%s.html']", letter)));
    }
    private void clickAndEnterInputIntoField(By by, WebDriver driver, String text) {
        WebElement searchInput = driver.findElement(by);
        searchInput.click();
        searchInput.sendKeys(text);
    }
    private WebElement getCategoryByLetter(String letter, WebDriver driver) {
        return driver.findElement(
                By.xpath(String.format("//h2[normalize-space()='Category %s']", letter.toUpperCase())));
    }
    private WebElement getTextWithSelectedLetter(String letter, WebDriver driver) {
        return driver.findElement(
                By.xpath(String.format("//strong[normalize-space()='%s']", letter.toUpperCase())));
    }
    private List<WebElement> getListOfElements(By by, WebDriver driver) {

        return driver.findElements(by);
    }

    private int getListSize(By by, WebDriver driver) {

        return getListOfElements(by, driver).size();
    }


    private List<String> getElementsText(By by, WebDriver driver) {
        List<WebElement> elementsList = getListOfElements(by, driver);
        List<String> textList = new ArrayList<>();
        for (WebElement element : elementsList) {
            textList.add(element.getText().toLowerCase());
        }

        return textList;
    }


    @Test
    public void testSearchLanguageField_HappyPath() {
        String selectedLanguageName = "python";

        openBaseURL(getDriver());
        clickOnElement(SEARCH_LANGUAGE_MENU, getDriver());
        clickAndEnterInputIntoField(SEARCH_FIELD ,getDriver(), selectedLanguageName);
        clickOnElement(GO_BUTTON, getDriver());

        List<String> languageNames = getElementsText(LIST_OF_LANGUAGES, getDriver());

        Assert.assertTrue(languageNames.size() > 0);

        for (String languageName : languageNames) {
            Assert.assertTrue(languageName.contains(selectedLanguageName));
        }
    }

    @Test
    public void testSortingLanguagesByLetter_AfterSelectingLetterInSubmenu_HappyPath() {
        final String LETTER = "b";

        openBaseURL(getDriver());
        clickOnElement(BROWSE_LANGUAGE_MENU, getDriver());
        clickOnElement(getSubmenuElementLettersNumbers(LETTER, getDriver()));

        WebElement categoryByLetter = getCategoryByLetter(LETTER, getDriver());
        Assert.assertTrue(categoryByLetter.getText().toLowerCase().endsWith(LETTER));

        WebElement textWithSelectedLetter = getTextWithSelectedLetter(LETTER, getDriver());
        Assert.assertTrue(textWithSelectedLetter.getText().toLowerCase().contains(LETTER));

        List<WebElement> languageListByLetter = getListOfElements(LIST_OF_LANGUAGES, getDriver());

        Assert.assertFalse(languageListByLetter.isEmpty());

        for (WebElement webElement : languageListByLetter) {
            Assert.assertTrue(webElement.getText().toLowerCase().startsWith(LETTER));
        }
    }

    @Test
    public void testDefaultStateOfABCPage_AfterNavigatingOnPage_HappyPath() {
        final String DEFAULT_LETTER = "a";

        openBaseURL(getDriver());
        clickOnElement(BROWSE_LANGUAGE_MENU, getDriver());

        WebElement categoryByLetter = getCategoryByLetter(DEFAULT_LETTER, getDriver());
        Assert.assertTrue(categoryByLetter.getText().toLowerCase().endsWith(DEFAULT_LETTER));

        WebElement textWithSelectedLetter = getTextWithSelectedLetter(DEFAULT_LETTER, getDriver());
        Assert.assertTrue(textWithSelectedLetter.getText().toLowerCase().contains(DEFAULT_LETTER));

        List<WebElement> languageListByLetter = getListOfElements(LIST_OF_LANGUAGES, getDriver());
        Assert.assertFalse(languageListByLetter.isEmpty());

        for (WebElement webElement : languageListByLetter) {
            Assert.assertTrue(webElement.getText().toLowerCase().startsWith(DEFAULT_LETTER));
        }
    }

    @Test
    public void testContainsClickableAlphabetLettersAndRangeOfNumbers_HappyPath() {
        final List <String> listOfLetters = List.of("0","A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L",
                "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z");
        final int quantityOfElementsExpectedResult = 27;
        int quantityOfElementsActualResult = 0;

        openBaseURL(getDriver());
        clickOnElement(BROWSE_LANGUAGE_MENU, getDriver());

        for (String letter: listOfLetters) {
            WebElement submenuElement = getSubmenuElementLettersNumbers(letter.toLowerCase(), getDriver());
            Assert.assertTrue(submenuElement.isDisplayed());
            Assert.assertTrue(submenuElement.isEnabled());
            clickOnElement(submenuElement);
            quantityOfElementsActualResult++;
        }
        Assert.assertEquals(quantityOfElementsExpectedResult, quantityOfElementsActualResult);
    }
}
