import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

import java.util.ArrayList;
import java.util.List;

public class NstzyaTest extends BaseTest {
    final String BASE_URL = "https://www.99-bottles-of-beer.net/";
    final static By SEARCH_LANGUAGES_MENU = By.xpath("//ul[@id='menu']/li/a[@href='/search.html']");
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
    public void testSearchForLanguageByNameField_HappyPath() {

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
    public void testHistoricInfoLink_WhenClickingOnLink_HappyPath() {

        String expectedResult = "https://www.99-bottles-of-beer.net/info.html";

        getDriver().get(BASE_URL);

        WebElement historicInfoLink = getDriver().findElement(
                By.xpath("//div[@id='main']/p/a[@href='./info.html']")
        );

        historicInfoLink.click();

        String actualResult = getDriver().getCurrentUrl();

        Assert.assertEquals(actualResult, expectedResult);
    }


    @Test
    public void testHereLink_WhenClickingOnLink_HappyPath() {

        String expectedResult = "https://www.99-bottles-of-beer.net/lyrics.html";

        getDriver().get(BASE_URL);

        WebElement hereLink = getDriver().findElement(
                By.xpath("//div[@id='main']/p/a[@href='./lyrics.html']")
        );

        hereLink.click();

        String actualResult = getDriver().getCurrentUrl();

        Assert.assertEquals(actualResult, expectedResult);

    }


    @Test
    public void testSubmitYourOwnCodeLink_WhenClickingOnLink_HappyPath() {

        String expectedResult = "https://www.99-bottles-of-beer.net/submitnewlanguage.html";

        getDriver().get(BASE_URL);

        WebElement submitYourCodeLink = getDriver().findElement(
                By.xpath("//div[@id='main']/p/a[@href='./submitnewlanguage.html']")
        );
        submitYourCodeLink.click();

        String actualResult = getDriver().getCurrentUrl();

        Assert.assertEquals(actualResult, expectedResult);
    }


    @Test
    public void testGuestbookLink_WhenClickingOnLink_HappyPath() {

        String expectedResult = "https://www.99-bottles-of-beer.net/guestbookv2.html";

        getDriver().get(BASE_URL);

        WebElement guestbookLink = getDriver().findElement(
                By.xpath("//div[@id='main']/p/a[@href='./guestbookv2.html']")
        );
        guestbookLink.click();

        String actualResult = getDriver().getCurrentUrl();

        Assert.assertEquals(actualResult, expectedResult);
    }


    @Test
    public void testTeamMembersLink_WhenClickingOnLink_HappyPath() {

        String expectedResult = "https://www.99-bottles-of-beer.net/team.html";

        getDriver().get(BASE_URL);

        WebElement guestbookLink = getDriver().findElement(
                By.xpath("//div[@id='main']/p/a[@href='./team.html']")
        );
        guestbookLink.click();

        String actualResult = getDriver().getCurrentUrl();

        Assert.assertEquals(actualResult, expectedResult);
    }
}
