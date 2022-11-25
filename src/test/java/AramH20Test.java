import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class AramH20Test extends BaseTest {
    final String BASE_URL = "https://www.99-bottles-of-beer.net/";
    final static By SEARCH_LANGUAGES_MENU = By.xpath("//ul[@id=\"menu\"]/li/a[@href='/search.html']");
    final static By SEARCH_FORE_FIELD = By.name("search");
    final static By GO_BUTTON = By.name("submitsearch");
    final static By LANGUAGES_NAMES_LIST = By.xpath("//table[@id=\"category\"]/tbody/tr/td[1]/a");

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

    private List<String> getElementsText(By by, WebDriver driver) {
        List<WebElement> elementsList = getListOfElements(by, driver);
        List<String> textList = new ArrayList<>();

        for (WebElement element : elementsList) {
            textList.add(element.getText().toLowerCase());
        }
        return textList;
    }

    @Test
    public void testSearchForLanguageByName_HappyPath() {
        final String LANGUAGE_PYTHON = "python";

        openBaseURL(getDriver());
        click(SEARCH_LANGUAGES_MENU, getDriver());
        click(SEARCH_FORE_FIELD, getDriver());
        input(LANGUAGE_PYTHON, SEARCH_FORE_FIELD, getDriver());
        click(GO_BUTTON, getDriver());
        List<String> languageNames = getElementsText(LANGUAGES_NAMES_LIST, getDriver());

        Assert.assertTrue(languageNames.size() > 0);
        for (String languageName : languageNames) {
            Assert.assertTrue(languageName.contains(LANGUAGE_PYTHON));
        }
    }


    final static String URL_KEY_VALUE = "guest";
    final static By MENU_GUESTBOOK = By.xpath("//ul[@id='menu']/li[5]/a");

    @Test
    public void test_MainFooterGuestBookv2() {
        openBaseURL(getDriver());
        getElement(MENU_GUESTBOOK, getDriver());
        click(MENU_GUESTBOOK, getDriver());
        Assert.assertTrue(getDriver().getCurrentUrl().toLowerCase().contains(URL_KEY_VALUE));
    }



    final static By BROWSE_LANGUAGES = By.xpath("//ul[@id='menu']/li[2]/a");
    final static By LETTERS = By.xpath("//ul[@id='submenu']/li");
    final static By LANGUAGE_COLUME = By.xpath("//table[@id='category']/tbody/tr/td[1]/a");

    private List<WebElement> getElements(By by, WebDriver driver) {
        List<WebElement> elementsList = getListOfElements(by, driver);
        return elementsList;
    }
    @Test
    public void test_ABCVerifyByLetterCategoryInformation() throws InterruptedException {
        openBaseURL(getDriver());
        click(BROWSE_LANGUAGES, getDriver());
        List<WebElement> submenuLetters = getElements(LETTERS,getDriver());
        submenuLetters.remove(0);
        List<String> submenuLettersText = getElementsText(LETTERS, getDriver());
        submenuLettersText.remove(0);
        Assert.assertTrue(submenuLetters.size() == 26);
        List<String> actualLetters = new ArrayList<>();
        submenuLetters.get(0).click();
        List<String> languages = getElementsText(LANGUAGE_COLUME, getDriver());
        String expectedLetter = submenuLettersText.get(0);gi

        for (String language : languages) {
             actualLetters.add(String.valueOf(language.charAt(0)));//
        }
        for (String letter : actualLetters) {
            Assert.assertEquals(letter, expectedLetter);
        }
    }
}