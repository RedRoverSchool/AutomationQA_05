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

    final static By HISTORIC_INFO_URL = By.xpath("//div[@id='main']/p/a[@href='./info.html']");
    final static By HERE_URL = By.xpath("//div[@id='main']/p/a[@href='./lyrics.html']");
    final static By SUBMIT_YOUR_OWN_CODE_URL = By.xpath("//div[@id='main']/p/a[@href='./submitnewlanguage.html']");
    final static By GUESTBOOK_URL = By.xpath("//div[@id='main']/p/a[@href='./guestbookv2.html']");
    final static By TEAM_MEMBERS_URL = By.xpath("//div[@id='main']/p/a[@href='./team.html']");

    final static By MAIN = By.xpath("//div[@id='main']");

    final static By BROWSE_LANGUAGES_MENU = By.xpath("//div[@id='navigation']/ul/li/a[@href='/abc.html']");
    final static By B_SUBMENU = By.xpath("//ul[@id='submenu']/li/a[@href='b.html']");
    final static By HEADER_H2_ON_PAGE_B_SUBMENU = By.xpath("//div[@id='main']/h2[contains(text(), 'Category B')]");


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

    private String getCurrentUrl(WebDriver driver) {

        return driver.getCurrentUrl();
    }

    private void isDisplayed(By by, WebDriver driver) {
        getElement(by, driver).isDisplayed();
    }

    private String getTextOfWebElement(By by, WebDriver driver) {

        return getElement(by, driver).getText();
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
    public void testAllLinksInsideMain_WhenClickingOnLinks_HappyPath() {

        String expectedResult1 = "https://www.99-bottles-of-beer.net/info.html";
        String expectedResult2 = "https://www.99-bottles-of-beer.net/lyrics.html";
        String expectedResult3 = "https://www.99-bottles-of-beer.net/submitnewlanguage.html";
        String expectedResult4 = "https://www.99-bottles-of-beer.net/guestbookv2.html";
        String expectedResult5 = "https://www.99-bottles-of-beer.net/team.html";

        openBaseURL(getDriver());
        isDisplayed(MAIN, getDriver());

        click(HISTORIC_INFO_URL,getDriver());
        String actualResult1 = getCurrentUrl(getDriver());
        Assert.assertEquals(actualResult1, expectedResult1);
        getDriver().navigate().back();

        click(HERE_URL, getDriver());
        String actualResult2 = getCurrentUrl(getDriver());
        Assert.assertEquals(actualResult2, expectedResult2);
        getDriver().navigate().back();

        click(SUBMIT_YOUR_OWN_CODE_URL, getDriver());
        String actualResult3 = getCurrentUrl(getDriver());
        Assert.assertEquals(actualResult3, expectedResult3);
        getDriver().navigate().back();

        click(GUESTBOOK_URL, getDriver());
        String actualResult4 = getCurrentUrl(getDriver());
        Assert.assertEquals(actualResult4, expectedResult4);
        getDriver().navigate().back();

        click(TEAM_MEMBERS_URL, getDriver());
        String actualResult5 = getCurrentUrl(getDriver());
        Assert.assertEquals(actualResult5, expectedResult5);
    }
    
    @Test
    public void testHeaderH2Text_WhenOpenBrowseLanguageMenu_PageBSubmenu_HappyPath() {

        String expectedResult = "Category B";

        openBaseURL(getDriver());
        click(BROWSE_LANGUAGES_MENU, getDriver());
        click(B_SUBMENU, getDriver());

        String actualResult = getTextOfWebElement(HEADER_H2_ON_PAGE_B_SUBMENU, getDriver());

        Assert.assertEquals(actualResult, expectedResult);
    }
}
