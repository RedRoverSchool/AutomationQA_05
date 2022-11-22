import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import runner.BaseTest;

import java.util.ArrayList;
import java.util.List;

public class MariaKuzhTest extends BaseTest {

    final String BASE_URL = "https://www.99-bottles-of-beer.net/";
    final static By SEARCH_LANGUAGES_MENU = By.xpath("//ul[@id = 'menu']/li/a[@href = '/search.html']");
    final static By SEARCH_FOR_FIELD = By.name("search");
    final static By GO_BUTTON = By.name("submitsearch");
    final static By LANGUAGES_NAMES_LIST = By.xpath("//table[@id='category']/tbody/tr/td[1]/a");
    final static By BUTTON_TOP_LISTS = By.xpath("//div[@id = 'navigation']//a[@href = '/toplist.html']");
    private void openBaseUrl(WebDriver driver) {
        driver.get(BASE_URL);
    }
    private WebElement getElement(By by, WebDriver driver) {

        return driver.findElement(by);
    }

    private String getElementText(By by, WebDriver driver) {

        return getElement(by, driver).getText();
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

    private int getListSize(By by, WebDriver driver){

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

        openBaseUrl(getDriver());
        click(SEARCH_LANGUAGES_MENU, getDriver());
        click(SEARCH_FOR_FIELD, getDriver());
        input(LANGUAGE_NAME, SEARCH_FOR_FIELD,getDriver());
        click(GO_BUTTON, getDriver());

        List<String> languageNames = getElementsText(LANGUAGES_NAMES_LIST, getDriver());

        Assert.assertTrue(languageNames.size() > 0);

        for (String languageName : languageNames) {
            Assert.assertTrue(languageName.contains(LANGUAGE_NAME));
        }

    }

    @Test
    public void testVerifyTextTopListsToTheStartPage() {
        final String expectedResult = "TOP LISTS";

        openBaseUrl(getDriver());
        String actualResult = getElementText(BUTTON_TOP_LISTS, getDriver());

        Assert.assertEquals(actualResult,expectedResult);
    }

    @Test
    public void testVerifyLinkTextWhenClickTopLists() {
        final String BASE_URL = "https://www.99-bottles-of-beer.net/";
        String TopLists = "toplist";

        getDriver().get(BASE_URL);

        WebElement buttonTopLists = getDriver().findElement(
                By.xpath("//div[@id = 'navigation']//a[@href = '/toplist.html']")
        );
        buttonTopLists.click();
        String newUrl = getDriver().getCurrentUrl();

        Boolean actualResultWord;
        if (newUrl.contains(TopLists)) {
            actualResultWord = true;
        } else {
            actualResultWord = false;
        }
        Boolean expectedResultWord = true;
        Assert.assertEquals(actualResultWord,expectedResultWord);

        Boolean actualResultNewUrl;
        if (newUrl != BASE_URL) {
            actualResultNewUrl = true;
        } else {
            actualResultNewUrl = false;
        }
        Boolean expectedResultNewUrl = true;
        Assert.assertEquals(actualResultNewUrl,expectedResultNewUrl);
    }
}
