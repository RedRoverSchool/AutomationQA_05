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
    final static String BASE_URL = "http://www.99-bottles-of-beer.net/";
    final static By SEARCH_LANGUAGES_MENU = By.xpath("//ul[@id = 'menu']/li/a[@href ='/search.html']");
    final static By SEARCH_FOR_FIELD = By.name("search");
    final static By GO_BUTTON = By.name("submitsearch");
    final static By LANGUAGES_NAMES_LIST = By.xpath("//table [@id = 'category']/tbody/tr/td[1]/a");
    final static By BROWSE_LANGUAGES = By.xpath("//div[@id = 'navigation']//a[@href = '/abc.html']");
    final static By LETTER_C = By.xpath("//ul[@id = 'submenu']//a[@href='c.html']");
    final static By DEFAULT_CATEGORY = By.xpath("//div[@id = 'main']/h2");
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
        List<String> textList = new ArrayList<>();

        for(WebElement element : elementsList){
            textList.add(element.getText().toLowerCase());
        }

        return textList;
    }
    public void waitTextToBeChanged(By by, String text, WebDriver driver, WebDriverWait wait) {
        wait.until(ExpectedConditions
                .not(ExpectedConditions.textToBePresentInElement(driver.findElement(by), text)));
    }
    private String getText(By by, WebDriver driver){
        return driver.findElement(by).getText();
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
}
