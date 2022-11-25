
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class EkaterinaLizinaTest extends BaseTest {
    private final String BASE_URL = "http://www.99-bottles-of-beer.net/";
    private final By SEARCH_LANGUAGES_MENU = By.xpath("//ul[@id = 'menu']/li/a[@href ='/search.html']");
    private final By SEARCH_FOR_FIELD = By.name("search");
    private final By GO_BUTTON = By.name("submitsearch");
    private final By LANGUAGES_NAMES_LIST = By.xpath("//table [@id = 'category']/tbody/tr/td[1]/a");
    private final By BROWSE_LANGUAGES = By.xpath("//div[@id = 'navigation']//a[@href = '/abc.html']");
    private final By LETTER_C = By.xpath("//ul[@id = 'submenu']//a[@href='c.html']");
    private final By DEFAULT_CATEGORY = By.xpath("//div[@id = 'main']/h2");
    private final By GUEST_BOOK_MENU = By.xpath("//div[@id = 'navigation']//a[@href = '/guestbookv2.html']");
    private final By ERROR_MESSAGE = By.xpath("//div[@id = 'main']/p/b/u");
    private final By SIGN_GUESTBOOK_SUBMENU = By.xpath("//ul[@id = 'submenu']/li/a[@href = './signv2.html']");
    private final By NAME= By.name("name");
    private final By LOCATION = By.name("location");
    private final By EMAIL = By.name("email");
    private final By MESSAGE = By.name("comment");
    private final By SUBMIT_BUTTON = By.name("submit");
    //
    private final By TOP_LISTS_MENU = By.xpath("//ul[@id = 'menu']//a[@href = '/toplist.html']");
    private final By TOP_RATED_REAL_SUBMENU = By.xpath("//ul[@id = 'submenu']//a[@href = './toplist_real.html']");
    private final By TOP_ESOTERIC_SUBMENU = By.xpath("//ul[@id = 'submenu']//a[@href ='./toplist_esoteric.html']");
    private final By TOP_RATED_REAL_LANGUAGE_LIST = By.xpath("//table [@id = 'category']/tbody/tr/td[2]/a");
    private final By TOP_RATED_ESOTERIC_LANGUAGE = By.xpath("//table [@id = 'category']/tbody/tr/td[2]/a");
    private void openBaseURL(WebDriver driver){
       driver.get(BASE_URL);
    }
    private void click(By by, WebDriver driver){
        getElement(by, driver).click();
    }
    public void input(String text, By by, WebDriver driver){
        getElement(by, driver).sendKeys(text);
    }
    private WebElement getElement (By by, WebDriver driver){

        return driver.findElement(by);
    }
    private List<WebElement> getListOfElements (By by, WebDriver driver){

        return driver.findElements(by);
    }
    private int getListSize(By by, WebDriver driver){

        return getListOfElements(by, driver).size();
    }
    private int getListSize(List<String> list){

        return list.size();
    }
    private List<String> getElementsText(By by, WebDriver driver){
        List <WebElement> elementsList = getListOfElements(by, driver);
        if(elementsList.size() > 0) {
            List<String> textList = new ArrayList<>();

            for (WebElement element : elementsList) {
                textList.add(element.getText().toLowerCase());
            }

            return textList;
        }
        return null;
    }
    public void waitTextToBeChanged(By by, String text, WebDriver driver, WebDriverWait wait) {
        wait.until(ExpectedConditions
                .not(ExpectedConditions.textToBePresentInElement(driver.findElement(by), text)));
    }
    private String getText(By by, WebDriver driver){
        return driver.findElement(by).getText();
    }
    private void sendKeys(By by, String text, WebDriver driver) {
        driver.findElement(by).sendKeys(text);
    }
    @Test
    public void testSearchForLanguageByName_HappyPath(){
        final String LANGUAGE_NAME = "python";

        openBaseURL(getDriver());
        click(SEARCH_LANGUAGES_MENU, getDriver());
        click(SEARCH_FOR_FIELD, getDriver());
        input(LANGUAGE_NAME,SEARCH_FOR_FIELD, getDriver());
        click(GO_BUTTON, getDriver());

        List<String> languageNames = getElementsText(LANGUAGES_NAMES_LIST,getDriver());

        int sizeOfLanguagesNamesList = getListSize(languageNames);

        Assert.assertTrue(languageNames.size() > 0);

        for (String languageName : languageNames) {
            Assert.assertTrue(languageName.contains(LANGUAGE_NAME));
        }
    }
    @Test
    public void testABCNavigationSubmenuClickLetterC() {
        openBaseURL(getDriver());
        click(BROWSE_LANGUAGES, getDriver());
        String expectedResult = "C";

        String old_default_category = getText(DEFAULT_CATEGORY, getDriver());

        click(LETTER_C, getDriver());
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        waitTextToBeChanged(DEFAULT_CATEGORY, old_default_category, getDriver(), wait);

        List<WebElement> languagesNamesList = getDriver().findElements(LANGUAGES_NAMES_LIST);

        Assert.assertTrue(languagesNamesList.size() > 0);
        String actualResult;
        for (int i = 0; i < languagesNamesList.size(); i++) {
            actualResult = String.valueOf(languagesNamesList.get(i).getText().toUpperCase().charAt(0));
            Assert.assertEquals(actualResult, expectedResult);
        }
    }
    @Test
    public void testVerifyErrorMessageIfSubmitWithoutCode_ekaterinalizina(){
        String name = "guest";
        String email = "guest@gmail.com";
        String location = "Fairfax";
        String message = "it is a message";
        String expectedResult = "Error:";

        openBaseURL(getDriver());
        click(GUEST_BOOK_MENU, getDriver());
        click(SIGN_GUESTBOOK_SUBMENU, getDriver());
        click(NAME, getDriver());
        sendKeys(NAME,name,getDriver());
        click(LOCATION, getDriver());
        sendKeys(LOCATION, location, getDriver());
        click(EMAIL, getDriver());
        sendKeys(EMAIL, email, getDriver());
        click(MESSAGE, getDriver());
        sendKeys(MESSAGE, message, getDriver());
        click(SUBMIT_BUTTON, getDriver());

        Assert.assertEquals(getText(ERROR_MESSAGE, getDriver()), expectedResult);
    }
    @Test
    public void testVerifyThe1stTopRatedRealLanguageIsDifferFromTopEsotericLanguage(){
        openBaseURL(getDriver());
        click(TOP_LISTS_MENU, getDriver());
        click(TOP_RATED_REAL_SUBMENU, getDriver());

        Assert.assertNotEquals(BASE_URL, getDriver().getCurrentUrl());

        String oldUrl = getDriver().getCurrentUrl();
        String languageTopRatedReal = "";
        List<String> textListTopRatedReal = getElementsText(TOP_RATED_REAL_LANGUAGE_LIST, getDriver());

        if(textListTopRatedReal.size() > 0) {
            for (String text : textListTopRatedReal) {
                languageTopRatedReal = textListTopRatedReal.get(0).toLowerCase();
            }
        }

        click(TOP_ESOTERIC_SUBMENU, getDriver());

        Assert.assertNotEquals(oldUrl, getDriver().getCurrentUrl());

        String languageTopEsotoric = "";
        List <String > texListTopEsoteric = getElementsText(TOP_RATED_ESOTERIC_LANGUAGE, getDriver());
        if(texListTopEsoteric.size() > 0){
            for (String text : texListTopEsoteric) {
               languageTopEsotoric = texListTopEsoteric.get(0).toLowerCase();
            }
        }

        Assert.assertNotEquals(languageTopRatedReal, languageTopEsotoric);
    }
}
