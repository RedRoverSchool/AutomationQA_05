package old_tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ElenaStratTest extends BaseTest {
    final String BASE_URL = "https://www.99-bottles-of-beer.net/";

    final static By SEARCH_LANGUAGES_MENU = By.xpath("//ul[@id = 'menu']/li/a[@href = '/search.html']");
    final static By SEARCH_FOR_FIELD = By.name("search");
    final static By GO_BUTTON = By.name("submitsearch");
    final static By LANGUAGES_NAMES_LIST = By.xpath("//table[@id='category']/tbody/tr/td[1]/a");

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
        final String LANGUAGE_NAME = "python";

        openBaseURL(getDriver());
        click(SEARCH_LANGUAGES_MENU, getDriver());
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
    public void testStartForVerifyWishesFromTheTeamFirstParagraph_HappyPath() {
        String expectedResult = "This Website holds a collection of the Song 99 Bottles of Beer programmed in different programming languages. " +
                "Actually the song is represented in 1500 different programming languages and variations. " +
                "For more detailed information refer to historic information.";

        getDriver().get(BASE_URL);

        WebElement verifyText = getDriver().findElement(By.xpath("//div[@id = 'main']/descendant-or-self::p"));
        String actualResult = verifyText.getText();

        Assert.assertEquals(actualResult, expectedResult);

    }


    @Test
    public void testMainForVerifyTheHeaderOnTheStartPage_HappyPath() {
        String expectedResult = "99 Bottles of Beer";

        openBaseURL(getDriver());

        WebElement verifyHeaderH1 = getDriver().findElement(By.xpath("//div[@id = 'header']/h1"));

        String actualResult = verifyHeaderH1.getText();

        Assert.assertEquals(actualResult, expectedResult);
    }


}
