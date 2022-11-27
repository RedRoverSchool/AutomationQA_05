package old_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;

import java.util.ArrayList;
import java.util.List;

public class AleksandrAkimovChgTest extends BaseTest {
    final String BASE_URL = "https://www.99-bottles-of-beer.net/";
    final static By SEARCH_LANGUAGES_MENU = By.xpath("//ul[@id = 'menu']/li/a[@href = '/search.html']");
    final static By SEARCH_FOR_FIELD = By.name("search");
    final static By GO_BUTTON = By.name("submitsearch");
    final static By LANGUAGES_NAMES_LIST = By.xpath("//table[@id = 'category']/tbody/tr/td[1]/a");

    final static By SEARCH_BROWSE_LANGUAGE_MENU =
            By.xpath("//div[@id = 'navigation']/ul[@id = 'menu']/li/a[@href = '/abc.html']");

    final static By TEXT_PAGE_CATEGORY_SIMBOL = By.xpath("//div[@id = 'main']/h2");

    final static String XPATH_SEARCH_SIMBOL_OR_LETTER_ON_SUBMENU_NAVIGATION_BAR_ABC_MENU =
            "//div[@id = 'navigation']/ul[@id = 'submenu']/li/a";

    final static By SEARCH_SIMBOL_OR_LETTER_ON_SUBMENU_NAVIGATION_BAR_ABC_MENU =
            By.xpath(XPATH_SEARCH_SIMBOL_OR_LETTER_ON_SUBMENU_NAVIGATION_BAR_ABC_MENU);

    private void openBaseUrl(WebDriver driver) {
        driver.get(BASE_URL);
    }

    private WebElement getElement(By by, WebDriver driver) {

        return driver.findElement(by);
    }

    private void click(By by, WebDriver driver) {
        getElement(by, driver).click();
    }

    private void input(String text, By by, WebDriver driver) {
        getElement(by, driver).sendKeys(text);
    }

    private void clear(By by, WebDriver driver) {
        getElement(by, driver).clear();
    }

    private List<WebElement> getListOfElements(By by, WebDriver driver) {

        return driver.findElements(by);
    }

    private int getListSize(By by, WebDriver driver) {

        return getListOfElements(by, driver).size();
    }

    private String getText(By by, WebDriver driver) {

        return driver.findElement(by).getText();
    }

    private List<String> getElementsText(By by, WebDriver driver) {
        List<WebElement> elementsList = getListOfElements(by, driver);
        List<String> textList = new ArrayList<>();

        for (WebElement element : elementsList) {
            textList.add(element.getText());
        }

        return textList;
    }

    private String getSimbol(By by, WebDriver driver, String simbol) {
        List<String> listOfElements = getElementsText(by, driver);
        int indexOfElementSimbol = listOfElements.indexOf(simbol);
        String simbolFromIndexOfElementSimbol = listOfElements.get(indexOfElementSimbol);

        return simbolFromIndexOfElementSimbol;
    }

    private List<String> getElementsTextHref(By by, WebDriver driver) {
        List<WebElement> elementsList = getListOfElements(by, driver);
        List<String> textList = new ArrayList<>();

        for (WebElement element : elementsList) {
            textList.add(element.getAttribute("href"));
        }

        return textList;
    }

    private int getIndexOfSimbol(By by, WebDriver driver, String simbol) {
        List<String> listOfElements = getElementsText(by, driver);
        int indexOfElementSimbol = listOfElements.indexOf(simbol);

        return indexOfElementSimbol;
    }

    private String getElementFromListByIndexFromSimbol(By by, WebDriver driver, String simbol) {
        int indexOftheSimbol = getIndexOfSimbol(by, driver, simbol);
        List<String> urlsByIndexWithLetter = getElementsTextHref(by, driver);
        String hreftUrl = urlsByIndexWithLetter.get(indexOftheSimbol);

        return hreftUrl;
    }

    private String getUrlByLetterOnSuvmenuABS(String simbol) {

        return String.format("https://www.99-bottles-of-beer.net/%s.html", simbol.toLowerCase());
    }

    private String getCategorySimbol(String simbol) {

        return String.format("Category %s", simbol);
    }

    private By getXpathByLetterInHferonSubmenuABS(String simbol) {

        return By.xpath(String.format("//div[@id = 'navigation']/ul[@id = 'submenu']/li/a[@href = '%s.html']",
                simbol.toLowerCase()));
    }

    @Test
    public void testSearchForLanguageEmptyField_HappyPath() {
        final String LANGUAGE_NAME = "Python";

        openBaseUrl(getDriver());
        click(SEARCH_LANGUAGES_MENU, getDriver());
        click(SEARCH_FOR_FIELD, getDriver());
        input(LANGUAGE_NAME, SEARCH_FOR_FIELD, getDriver());
        click(GO_BUTTON, getDriver());
        clear(SEARCH_FOR_FIELD, getDriver());
        click(GO_BUTTON, getDriver());

        Assert.assertTrue(getListSize(LANGUAGES_NAMES_LIST, getDriver()) == 0);
    }

    @Test
    public void testLetterZ_WhenFindAndClickZOnSubmenuNavigationBarABCMenu() {
        final String SIMBOl_OR_LETTER = "Z";
        String expectedResultHrefURL = getUrlByLetterOnSuvmenuABS(SIMBOl_OR_LETTER);
        String expectedResultH2Text = getCategorySimbol(SIMBOl_OR_LETTER);

        openBaseUrl(getDriver());
        click(SEARCH_BROWSE_LANGUAGE_MENU, getDriver());

        Assert.assertTrue(
                    getListSize(SEARCH_SIMBOL_OR_LETTER_ON_SUBMENU_NAVIGATION_BAR_ABC_MENU, getDriver()) > 0);

        String actualResultSimbol = getSimbol(
                    SEARCH_SIMBOL_OR_LETTER_ON_SUBMENU_NAVIGATION_BAR_ABC_MENU, getDriver(), SIMBOl_OR_LETTER);

        String actualResulHreftUrl = getElementFromListByIndexFromSimbol(
                    SEARCH_SIMBOL_OR_LETTER_ON_SUBMENU_NAVIGATION_BAR_ABC_MENU, getDriver(), SIMBOl_OR_LETTER);

        click(getXpathByLetterInHferonSubmenuABS(SIMBOl_OR_LETTER), getDriver());

        String actualResultH2Text = getText(TEXT_PAGE_CATEGORY_SIMBOL, getDriver());

        Assert.assertEquals(actualResultSimbol, SIMBOl_OR_LETTER);
        Assert.assertEquals(actualResulHreftUrl, expectedResultHrefURL);
        Assert.assertEquals(actualResultH2Text, expectedResultH2Text);
    }
}
