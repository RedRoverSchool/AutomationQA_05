import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;
import java.util.ArrayList;
import java.util.List;

public class HenadzBuhlakouTest extends BaseTest {
    final String BASE_URL = "https://www.99-bottles-of-beer.net/";

    final static By SEARCH_LANGUAGES_MENU = By.xpath("//ul[@id = 'menu']/li/a[@href = '/search.html']");
    final static By SEARCH_FOR_FIELD = By.name("search");
    final static By GO_BUTTON = By.name("submitsearch");
    final static By LANGUAGES_NAMES_LIST = By.xpath("//table[@id='category']/tbody/tr/td[1]/a");
    final static By FOOTER_START = By.xpath("//div[@id='footer']//a[@href = '/']");
    final static By TOP_LISTS_MENU = By.xpath("//ul[@id='menu']/li/a[@href='/toplist.html']");
    final static By TOPLIST_REAL_SUBMENU = By.xpath("//ul[@id='submenu']/li/a[@href='./toplist_real.html']");
    final static By HEADER_2_TOPLIST_REAL = By.xpath("//div[@id='main']/h2");
    final static By TOPLIST_ESOTERIC_SUBMENU = By.xpath("//ul[@id='submenu']/li/a[@href='./toplist_esoteric.html']");
    final static By HEADER_2_TOPLIST_ESOTERIC = By.xpath("//div[@id='main']/h2");

    private void openBaseURL(WebDriver driver) {
        driver.get(BASE_URL);
    }

    private WebElement getElement(By by, WebDriver driver) {

        return  driver.findElement(by);
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

        return getListOfElements(by,driver).size();
    }

    private List<String> getElementsText(By by, WebDriver driver) {
        List<WebElement> elementsList =  getListOfElements(by, driver);
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
        click(GO_BUTTON,getDriver());

        List<String> languageNames = getElementsText(LANGUAGES_NAMES_LIST, getDriver());

        Assert.assertTrue(languageNames.size() > 0);

        for (String languageName : languageNames) {
            Assert.assertTrue(languageName.contains(LANGUAGE_NAME));
        }
    }

    @Test
    public void testVerifyLinkTextAfterClickOnFooterMenuStart_HappyPath() {
        final String expectedResult = "https://www.99-bottles-of-beer.net/";

        openBaseURL(getDriver());
        click(FOOTER_START, getDriver());

        String actualResult = getDriver().getCurrentUrl();

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testTextHeader2OnToplistReal_HappyPath() {
        final String expectedHeader2OnToplistReal = "Top Rated Real Languages";

        openBaseURL(getDriver());
        click(TOP_LISTS_MENU, getDriver());
        click(TOPLIST_REAL_SUBMENU, getDriver());

        String actualHeader2OnToplistReal = getDriver().findElement(HEADER_2_TOPLIST_REAL).getText();

        Assert.assertEquals(actualHeader2OnToplistReal, expectedHeader2OnToplistReal);
    }

    @Test
    public void testTextHeader2OnToplistEsoteric_HappyPath() {
        final String expectedHeader2OnToplistEsoteric = "Top Rated Esoteric Languages";

        openBaseURL(getDriver());
        click(TOP_LISTS_MENU, getDriver());
        click(TOPLIST_ESOTERIC_SUBMENU, getDriver());

        String actualHeader2OnToplistEsoteric = getDriver().findElement(HEADER_2_TOPLIST_ESOTERIC).getText();

        Assert.assertEquals(actualHeader2OnToplistEsoteric, expectedHeader2OnToplistEsoteric);
    }
}