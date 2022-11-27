package old_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;

import java.util.ArrayList;
import java.util.List;

public class ElenaKudTest extends BaseTest {
    final String BASE_URL = "http://www.99-bottles-of-beer.net/";

    final static By SEARCH_LANGUAGES_MENU = By.xpath("//ul[@id = 'menu']/li/a[@href = '/search.html']");
    final static By SEARCH_FOR_FIELD = By.name("search");
    final static By GO_BUTTON = By.name("submitsearch");
    final static By LANGUAGES_NAMES_LIST = By.xpath("//table[@id = 'category']/tbody/tr/td[1]/a");
    final static By SUBMIT_NEW_LANGUAGE_MENU =
            By.xpath("//ul[@id='menu']/li//a[@href='/submitnewlanguage.html']");
    final static By H2_Header_SUBMIT_NEW_LANGUAGE = By.xpath("//div[@id='main']/h2");
    private void openBaseURL(WebDriver driver) {
        driver.get(BASE_URL);
    }

    private  WebElement getElement(By by, WebDriver driver) {

        return driver.findElement(by);
    }
    private  List<WebElement> getListOfElements(By by, WebDriver driver) {

        return driver.findElements(by);
    }
    private void click(By by, WebDriver driver) {
        getElement(by, driver).click();
    }
    private void input(String text, By by, WebDriver driver) {
        getElement(by, driver).sendKeys(text);
    }
    private int getListSize(By by, WebDriver driver) {

        return getListOfElements(by,driver).size();
    }
    private List<String> getElementsText(By by, WebDriver driver) {
        List<WebElement> elementsList = getListOfElements(by, driver);
        List<String> textList = new ArrayList<>();

        for(WebElement element : elementsList) {
           textList.add(element.getText().toLowerCase());
        }

        return textList;
    }
    private String getText(By by,WebDriver driver) {

        return driver.findElement(by).getText();
    }

    @Test
    public void testSearchForLanguageByName_HappyPath() {
        final String LANGUAGE_NAME = "python";

        openBaseURL(getDriver());
        click(SEARCH_LANGUAGES_MENU, getDriver());
        click(SEARCH_FOR_FIELD,getDriver());
        input(LANGUAGE_NAME,SEARCH_FOR_FIELD,getDriver());
        click(GO_BUTTON,getDriver());

        List<String> languageNames = getElementsText(LANGUAGES_NAMES_LIST, getDriver());

        Assert.assertTrue( languageNames.size() > 0);

        for (String languageName : languageNames) {
            Assert.assertTrue(languageName.contains(LANGUAGE_NAME));
        }
    }

    @Test
    public void testVerifyH2HeaderTest_SubmitNewLanguage_HappyPath() {
        final String expectedResult = "Submit New Language";

        openBaseURL(getDriver());

        click(SUBMIT_NEW_LANGUAGE_MENU,getDriver());
        String actualResult = getText(H2_Header_SUBMIT_NEW_LANGUAGE, getDriver());

        Assert.assertEquals(actualResult, expectedResult);
    }
}
