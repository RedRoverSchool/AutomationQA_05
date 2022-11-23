import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

import java.util.ArrayList;
import java.util.List;

public class YulyaNyuTest extends BaseTest {
    final String BASE_URL = "https://www.99-bottles-of-beer.net/";

    final static By SEARCH_LANGUAGES_MENU = By.xpath("//ul[@id='menu']/li/a[@href ='/search.html']");
    final static By SEARCH_FOR_FIELD = By.name("search");
    final static By GO_BUTTON = By.name("submitsearch");
    final static By LANGUAGES_NAMES_LIST = By.xpath("//table[@id = 'category']/tbody/tr/td[1]/a");
    final static By SUB_MENU_TEAM = By.xpath("//a[@href = 'team.html']");
    final static By H2_TEAM_PAGE_HEADER = By.xpath("//div[@id ='main']/h2");
    final static By NAVIGATION_MENU_GUESTBOOK = By.xpath("//li//a[@href ='/guestbookv2.html']");
    final static By SUBMENU_SIGN_GUESTBOOK = By.xpath("//li//a[@href = './signv2.html']");
    private void openBaseURL(WebDriver driver) {
        driver.get(BASE_URL);
    }
    private WebElement getElement (By by, WebDriver driver) {

       return driver.findElement(by);
    }
    private List<WebElement> getListOfElements(By by, WebDriver driver) {

        return driver.findElements(by);
    }
    private void click (By by, WebDriver driver ) {
        getElement(by, driver).click();
    }
    private String getText(By by, WebDriver driver) {

        return driver.findElement(by).getText();
    }
    private String getCurrentURL(By by, WebDriver driver) {
        getElement(by,driver).click();

        return driver.getCurrentUrl();
    }
    private void input (String text, By by, WebDriver driver) {
        getElement(by, driver).sendKeys(text);
    }
    private int getListSize(By by, WebDriver driver) {

        return getListOfElements(by,driver).size();
    }
    private List<String> getElementsText(By by, WebDriver driver){
        List<WebElement> elementsList = getListOfElements(by, driver);
        List<String> textList = new ArrayList<>();

        for (WebElement element : elementsList){
            textList.add(element.getText().toLowerCase());
        }

        return textList;
    }

    @Test
    public void testSearchForLanguageByName_HappyPath() {
        final String LANGUAGE_NAME = "python";

        openBaseURL(getDriver());
        click(SEARCH_LANGUAGES_MENU, getDriver());
        click(SEARCH_FOR_FIELD,getDriver());
        input(LANGUAGE_NAME, SEARCH_FOR_FIELD,getDriver());
        click(GO_BUTTON,getDriver());

        List<String> languageNames = getElementsText(LANGUAGES_NAMES_LIST,getDriver());

        Assert.assertTrue(languageNames.size()> 0);

        for (String languageName : languageNames ){
            Assert.assertTrue(languageName.contains(LANGUAGE_NAME));
        }
    }

    @Test
    public void testVerifyH2TagText_WhenClickingSubmenuTeam_HappyPath()  {
        String expectedResult = "The Team";

        openBaseURL(getDriver());
        click(SUB_MENU_TEAM,getDriver());

        String actualResult = getText(H2_TEAM_PAGE_HEADER,getDriver());

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testVerifyPageURLAndPageTitle(){
        final String EXPECTED_HEADER= "Sign Guestbook";
        final String EXPECTED_URL = "https://www.99-bottles-of-beer.net/signv2.html";

        openBaseURL(getDriver());
        click(NAVIGATION_MENU_GUESTBOOK,getDriver());
        click(SUBMENU_SIGN_GUESTBOOK,getDriver());

        String actualExpectedHeader = getText(NAVIGATION_MENU_GUESTBOOK,getDriver());
        String actualExpectedURL = getCurrentURL(SUBMENU_SIGN_GUESTBOOK,getDriver());
    }
}
