import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

import java.util.ArrayList;
import java.util.List;

public class Albina_starTest extends BaseTest {
    final String BASE_URL = "https://www.99-bottles-of-beer.net/";
    final static By TOP_LIST_MENU = By.xpath("//ul[@id= 'menu']//li/a[@href='/toplist.html']");
    final static By TOP_LIST_MENU_LIST = By.xpath("//ul[@id=\"submenu\"]/li/a");

    private void openBaseURL(WebDriver driver) {
        driver.get(BASE_URL);
    }

    private WebElement getElement(By by, WebDriver driver) {
        return driver.findElement(by);
    }

    private void click(By by, WebDriver driver) {
        getElement(by, driver).click();
    }

    private List<WebElement> getListOfElements(By by, WebDriver driver) {

        return driver.findElements(by);
    }

    private List<String> getElementsText(By by, WebDriver driver) {
        List<WebElement> elementsList = getListOfElements(by, driver);
        List<String> textList = new ArrayList<>();

        for (WebElement element : elementsList) {
            textList.add(element.getText());
        }

        return textList;
    }

    @Test
    public void testSearchForLanguageByName_HappyPath() {
        final String BASE_URL = "https://99-bottles-of-beer.net/";
        final String LANGUAGE_PYTHON = "python";

        getDriver().get(BASE_URL);

        WebElement searchLanguagesMenu = getDriver().findElement(
                By.xpath("//ul[@id = 'menu']/li/a[@href = '/search.html']"));
        searchLanguagesMenu.click();

        WebElement searchForField = getDriver().findElement(By.name("search"));
        searchForField.click();
        searchForField.sendKeys(LANGUAGE_PYTHON);

        WebElement goButton = getDriver().findElement(By.name("submitsearch"));
        goButton.click();

        List<WebElement> languagesNamesList = getDriver().findElements(
                By.xpath("//table[@id='category']/tbody/tr/td[1]/a"));

        Assert.assertTrue(languagesNamesList.size() > 0);

        for (int i = 0; i < languagesNamesList.size(); i++) {
            Assert.assertTrue(languagesNamesList.get(i).getText().toLowerCase().contains(LANGUAGE_PYTHON));
        }
    }

    @Test
    public void testVerifyTextOfFooterMenuSearchLanguages_HappyPath() {
        final String BASE_URL = "https://99-bottles-of-beer.net/";
        final String SEARCH_LANGUAGES = "Search Languages";

        getDriver().get(BASE_URL);

        WebElement searchLanguagesFooterMenu = getDriver().findElement(
                By.xpath("//div[@id=\"footer\"]/p/a[3]"));
        searchLanguagesFooterMenu.click();

        WebElement searchLanguages = getDriver().findElement(
                By.xpath("//div[@id=\"main\"]/h2"));
        searchLanguages.getText();

        Assert.assertEquals(searchLanguages.getText(), SEARCH_LANGUAGES);

        WebElement searchFor = getDriver().findElement(
                By.xpath("//div/div[3]/form/p/input[1]"));
        searchFor.isDisplayed();

        Assert.assertTrue(searchFor.isDisplayed());
    }

    @Test
    public void testVerifyListOfElementsOfMainTopListSubmenu_HappyPath() {
        List<String> expectedElementsOfTopListSubmenu = new ArrayList<>();
        expectedElementsOfTopListSubmenu.add("Top Rated");
        expectedElementsOfTopListSubmenu.add("Top Rated Real");
        expectedElementsOfTopListSubmenu.add("Top Rated Esoteric");
        expectedElementsOfTopListSubmenu.add("Top Rated Assembly");
        expectedElementsOfTopListSubmenu.add("Top Hits");
        expectedElementsOfTopListSubmenu.add("New Languages this month");
        expectedElementsOfTopListSubmenu.add("New Comments");

        openBaseURL(getDriver());
        click(TOP_LIST_MENU, getDriver());

        List<String> elementsOfTopListSubmenu = getElementsText(TOP_LIST_MENU_LIST, getDriver());

        Assert.assertTrue(elementsOfTopListSubmenu.size() > 0);

        Assert.assertEquals(elementsOfTopListSubmenu, expectedElementsOfTopListSubmenu);
    }
}