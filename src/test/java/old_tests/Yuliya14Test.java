package old_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;

import java.util.ArrayList;
import java.util.List;


public class Yuliya14Test extends BaseTest {
    final String BASE_URL = "https://www.99-bottles-of-beer.net/";

    final static By SEARCH_LANGUAGES_MENU = By.xpath("//ul[@id='menu']/li/a[@href = '/search.html']");
    final static By SEARCH_FOR_FIELD = By.name("search");
    final static By GO_BUTTON = By.name("submitsearch");
    final static By LANGUAGES_NAMES_LIST = By.xpath("//table[@id='category']/tbody/tr/td[1]/a");

    final static By BUTTON_GUESTBOOK_MENU = By.xpath("//ul[@id='menu']/li/a[@href= '/guestbookv2.html']");
    final static By BUTTON_SUBMIT_NEW_LANGUAGE_MENU = By.xpath("//ul[@id='menu']/li/a[@href= '/submitnewlanguage.html']");

    private void openBaseURL(WebDriver driver) {
        driver.get(BASE_URL);
    }

    private WebElement getElement(By by, WebDriver driver) {

        return  driver.findElement(by);
    }

    private List<WebElement> getListofElements(By by, WebDriver driver) {

        return  driver.findElements(by);
    }

    public void click(By by, WebDriver driver){
        getElement(by, driver).click();
    }

    private void input(String text, By by, WebDriver driver) {
        getElement(by, driver).sendKeys(text);
    }

    private int getListSize(By by, WebDriver driver) {

        return getListofElements(by, driver).size();
    }

    private List<String> getElementsText(By by, WebDriver driver) {
        List <WebElement> elementsList = getListofElements(by, driver);
        List<String> textList = new ArrayList<>();

        for (WebElement element : elementsList) {
            textList.add(element.getText().toLowerCase());
        }

        return textList;
    }

    @Test
    public void testSearchForLanguageByName_HappyPath() {
        final String LANGUAGE_NAME = "python";

        openBaseURL(getDriver());
        click(SEARCH_LANGUAGES_MENU , getDriver());
        click(SEARCH_FOR_FIELD, getDriver());
        input(LANGUAGE_NAME, SEARCH_FOR_FIELD, getDriver());
        click(GO_BUTTON, getDriver());

        List<String> languageNames = getElementsText(LANGUAGES_NAMES_LIST, getDriver());

        Assert.assertTrue(languageNames.size() > 0);

        for (String languageName : languageNames) {
            Assert.assertTrue(languageName.contains(LANGUAGE_NAME));
        }
    }

    @Test
    public void testMainNavigationButtonGuestbook_HappyPath() {
        String expectedResultGuestbookUrl = "https://www.99-bottles-of-beer.net/guestbookv2.html";

        openBaseURL(getDriver());
        click(BUTTON_GUESTBOOK_MENU, getDriver());

        String actualResultGuestbookUrl = getDriver().getCurrentUrl();
        Assert.assertEquals(actualResultGuestbookUrl, expectedResultGuestbookUrl);
    }

    @Test
    public void testMainNavigationButtonSubmitNewLanguage_HappyPath() throws InterruptedException {
        String expectedResultSubmitNewLanguageUrl = "https://www.99-bottles-of-beer.net/submitnewlanguage.html";

        getDriver().get(BASE_URL);
        click(BUTTON_SUBMIT_NEW_LANGUAGE_MENU, getDriver());
        Thread.sleep(3000);

        String actualResultSubmitNewLanguageUrl = getDriver().getCurrentUrl();
        Assert.assertEquals(actualResultSubmitNewLanguageUrl, expectedResultSubmitNewLanguageUrl);
    }
}
