package old_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import base.BaseTest;

import java.util.ArrayList;
import java.util.List;

public class AnzhelikaBaaTest extends BaseTest {

    final String BASE_URL = "https://www.99-bottles-of-beer.net/";
    final static By SEARCH_LANGUAGES_MENU = By.xpath("//ul[@id='menu']/li/a[@href='/search.html']");
    final static By SEARCH_FOR_FIELD = By.name("search");
    final static By GO_BUTTON = By.name("submitsearch");
    final static By LANGUAGES_NAMES_LIST = By.xpath("//table [@id = 'category']/tbody/tr/td[1]/a");
    final static By SEARCH_SONG_LYRICS_SUBMENU = By.xpath("//ul[@id='submenu']/li/a[@href='lyrics.html']");
    final static By PAGE_WITH_LYRICS = By.xpath("//div[@id='main']");
    final static By SEARCH_TEAM_SUBMENU_BUTTON = By.xpath("//ul[@id='submenu']/li/a[@href='team.html']");
    final static By IMAGE_1 = By.xpath("//div[@id='main']//img[@alt='Picture of Gregor Scheithauer']");
    final static By IMAGE_2 = By.xpath("//div[@id='main']//img[@alt='Picture of Stefan Scheler']");
    final static By IMAGES_LIST = By.xpath("//img");
    final static By BROWSE_LANGUAGES_MENU = By.xpath("//ul[@id='menu']/li//a[@href='/abc.html']");
    final static By LETTER_A_SUBMENU = By.xpath("//ul[@id='submenu']/li//a[contains(text(), 'A')]");
    final static By H_2_TAG = By.xpath("//div[@id='main']/h2[contains(text(), 'Category A')]");
    final static By LETTER_Z_SUBMENU = By.xpath("//ul[@id='submenu']/li//a[contains(text(), 'Z')]");
    final static By LANGUAGES_Z_NAMES_LIST = By.xpath("//table[@id='category']/tbody/tr/td[@bgcolor='#efefef']/a");

    final static By TOP_LISTS_MENU = By.xpath("//ul[@id='menu']/li//a[@href='/toplist.html']");

    final static By TOP_RATED_REAL = By.xpath("//ul[@id='submenu']/li/a[@href='./toplist_real.html']");

    final static By H_2_TOP_RATED_REAL_LANGUAGES = By.xpath("//div[@id='main']/h2['Top Rated Real Languages']");

    private void openBaseURL(WebDriver driver) {
        driver.get(BASE_URL);
    }

    private void click(By by, WebDriver driver) {
        getElement(by, driver).click();
    }

    private String text(By by, WebDriver driver) {
        return getElement(by, driver).getText();
    }

    private void isDisplayed(By by, WebDriver driver) {
        getElement(by, driver).isDisplayed();
    }

    private WebElement getElement(By by, WebDriver driver) {
        return driver.findElement(by);
    }

    private void input(String text, By by, WebDriver driver) {
        getElement(by, driver).sendKeys(text);
    }

    private List<WebElement> getListOfElements(By by, WebDriver driver) {
        return driver.findElements(by);
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
       private String getAttribute(By by, String attribute) {

        return getDriver().findElement(by).getAttribute(attribute);
    }

    @Test
    public void testSearchForLanguageByName() {
        final String LANGUAGE_NAME = "python";

        List<String> languagesNames =
                openBaseURL()
                        .clickSearchLanguagesMenu()
                        .clickSearchForField()
                        .inputSearchCriteria(LANGUAGE_NAME)
                        .clickGoButton()
                        .getNamesInLowerCase();

        Assert.assertTrue(languagesNames.size() > 0);

        for (String languageName : languagesNames) {
            Assert.assertTrue(languageName.contains(LANGUAGE_NAME));
        }
    }
       @Test
    public void testImages_WhenChooseTeamSubmenu_HappyPath() {
    String attribute1 = "Picture of Gregor Scheithauer";
    String attribute2 = "Picture of Stefan Scheler";
    int expectedResult = 2;

    openBaseURL(getDriver());

    click(SEARCH_TEAM_SUBMENU_BUTTON, getDriver());
    getAttribute(IMAGE_1, attribute1);
    getAttribute(IMAGE_2, attribute2);

    int actualResult = getListSize(IMAGES_LIST, getDriver());

    Assert.assertEquals(actualResult, expectedResult);
    }

    @Ignore
    @Test
    public void testH2TagText_WhenSearchingLanguagesStartWithLetterA_HappyPath() {
        final String expectedResult = "Category A";

        openBaseURL(getDriver());

        click(BROWSE_LANGUAGES_MENU, getDriver());
        getElement(LETTER_A_SUBMENU, getDriver());
        isDisplayed(H_2_TAG, getDriver());

        String actualResult = text(H_2_TAG, getDriver());

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testVerifyIfNamesOfLanguagesStartWithZ_WhenChoosingZSubmenu_HappyPath() {
        String expectedFirstLetter = "z";

        openBaseURL(getDriver());
        click(BROWSE_LANGUAGES_MENU, getDriver());
        click(LETTER_Z_SUBMENU, getDriver());

        List<WebElement> elements = getDriver().findElements(LANGUAGES_Z_NAMES_LIST);
        Assert.assertTrue(elements.size() > 0);

        List<String> languageZNamesList = getElementsText(LANGUAGES_Z_NAMES_LIST, getDriver());

        for (int i = 0; i < languageZNamesList.size(); i++) {
            Assert.assertEquals(String.valueOf(languageZNamesList.get(i).toLowerCase().charAt(0)), expectedFirstLetter);
        }
        Assert.assertTrue(languageZNamesList.size() > 0);
    }

    @Test
    public void testH2PresenceAndColor_WhenChoosingTopRatedRealSubmenu_HappyPath() {
        String expectedHeaderName = "Top Rated Real Languages";
        String expectedHexColor = "#1b651c";

        openBaseURL(getDriver());

        click(TOP_LISTS_MENU, getDriver());
        click(TOP_RATED_REAL, getDriver());
        isDisplayed(H_2_TOP_RATED_REAL_LANGUAGES, getDriver());
        String headerColor = getElement(H_2_TOP_RATED_REAL_LANGUAGES, getDriver()).getCssValue("color");
        String hexColor = Color.fromString(headerColor).asHex();

        Assert.assertEquals(text(H_2_TOP_RATED_REAL_LANGUAGES, getDriver()), expectedHeaderName);
        Assert.assertEquals(hexColor, expectedHexColor);
    }
}
