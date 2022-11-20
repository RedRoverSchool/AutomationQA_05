import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import runner.BaseTest;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class VerafesTest extends BaseTest {

    final String BASE_URL = "https://www.99-bottles-of-beer.net/";
    final String INFO_URL = "https://www.99-bottles-of-beer.net/info.html";

    final static By SEARCH_LANGUAGES_MENU = By.xpath("//ul[@id = 'menu']/li/a[@href = '/search.html']");
    final static By SEARCH_FOR_FIELD = By.name("search");
    final static By GO_BUTTON = By.name("submitsearch");
    final static By LANGUAGES_NAMES_LIST = By.xpath("//table[@id='category']/tbody/tr/td[1]/a");
    final static By INFO_SUB_MENU = By.xpath("//ul[@id='submenu']/li/a[@href='info.html']");


    private void openBaseURL(WebDriver driver)  {
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

    private String getText(By by, WebDriver driver) {

        return driver.findElement(by).getText();
    }

    private String getAttribute(By by, String attribute, WebDriver driver) {

        return driver.findElement(by).getAttribute(attribute);
    }

    private String getCurrentUrl(WebDriver driver) {

        return driver.getCurrentUrl();
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
    public void testSubmenuInfo_VerifyLabelText_HappyPath(){
        String expectedResult = "History";

        openBaseURL(getDriver());

        String actualResult = getText(INFO_SUB_MENU, getDriver());

        Assert.assertEquals(getText(INFO_SUB_MENU, getDriver()), expectedResult);
    }

    @Test
    public void testSubmenuInfo_VerifyLinkText_HappyPath(){
        String attribute = "href";
        String expectedResult = "info.html";

        openBaseURL(getDriver());

        String actualResult = getAttribute(INFO_SUB_MENU, attribute, getDriver());

        Assert.assertTrue(actualResult.contains(expectedResult));
    }

    @Test
    public void testSubmenuInfo_VerifyNavigation(){
        By infoTitle = By.xpath("//*[@id='main']/h2");
        String expectedResultURL = INFO_URL;
        String expectedResultTitle = "History";

        openBaseURL(getDriver());
        click(INFO_SUB_MENU, getDriver());

        Assert.assertEquals(getCurrentUrl(getDriver()), expectedResultURL);

        String actualResultTitle = getText(infoTitle, getDriver());

        Assert.assertEquals(actualResultTitle, expectedResultTitle);
    }

}
