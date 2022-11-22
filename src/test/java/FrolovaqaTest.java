import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

import java.util.ArrayList;
import java.util.List;

public class FrolovaqaTest extends BaseTest {
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
        input(LANGUAGE_NAME, SEARCH_FOR_FIELD,getDriver());
        click(GO_BUTTON, getDriver());

        List<String> languageNames = getElementsText(LANGUAGES_NAMES_LIST, getDriver());

        Assert.assertTrue(languageNames.size() > 0);

        for (String languageName :languageNames) {
            Assert.assertTrue(languageName.contains(LANGUAGE_NAME));
        }
    }

    @Test
    public void testBrowseLanguagesByCategoryName_HappyPath() {
        final String BASE_URL = "https://www.99-bottles-of-beer.net/";
        final String CATEGORY_NAME = "y";

        getDriver().get(BASE_URL);

        WebElement browseLanguagesMenu = getDriver().findElement(
                By.xpath("//ul[@id = 'menu']//a[@href = '/abc.html']")
        );
        browseLanguagesMenu.click();

        WebElement searchForCategory = getDriver().findElement(By.xpath(
                "//ul[@id = 'submenu']//a[@href = 'y.html']"));
        searchForCategory.click();

        List<WebElement> languagesNamesList = getDriver().findElements(
                By.xpath("//table[@id='category']/tbody/tr/td[1]/a"));

        Assert.assertTrue(languagesNamesList.size() > 0);

        for (int i = 0; i < languagesNamesList.size(); i++) {
            Assert.assertTrue(languagesNamesList.get(i).getText().toLowerCase().startsWith(CATEGORY_NAME));
        }
    }
}