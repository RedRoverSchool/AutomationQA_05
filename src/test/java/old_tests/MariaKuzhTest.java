package old_tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import base.BaseTest;

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
    private String getCurrentUrl(WebDriver driver){
        return driver.getCurrentUrl();
    }
    private Boolean wordContains(String a, String b){
        boolean wordContains;
        if (a.contains(b)) {
            wordContains = true;
        } else {
            wordContains = false;
        }

        return wordContains;
    }
    private Boolean urlContains(String a, String b) {
        Boolean urlContains;
        if (a != b) {
            urlContains = true;
        } else {
            urlContains = false;
        }

        return urlContains;
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
        String TopLists = "toplist";

        openBaseUrl(getDriver());
        click(BUTTON_TOP_LISTS, getDriver());

        String newUrl = getCurrentUrl(getDriver());

        Boolean actualResultWord = wordContains(newUrl,TopLists);
        Boolean expectedResultWord = true;
        Assert.assertEquals(actualResultWord,expectedResultWord);

        Boolean actualResultNewUrl = urlContains(newUrl,BASE_URL);
        Boolean expectedResultNewUrl = true;
        Assert.assertEquals(actualResultNewUrl,expectedResultNewUrl);
    }

    @Test
    public void testSortinglanguagesByNumber_AfterSelectingNumberInSubmenu() {
        final String NUMBER = "0";
        final String NUMBER_FOR_CATEGORY = "0-9";

        getDriver().get(BASE_URL);

        WebElement browseLanguageMenu = getDriver().findElement(
                By.xpath("//div[@id='navigation']/ul//a[@href='/abc.html']")
        );
        browseLanguageMenu.click();

        WebElement submenuElementLettersNumbers = getDriver().findElement(
                By.xpath(String.format("//ul[@id='submenu']//a[@href='%s.html']", NUMBER))
        );
        submenuElementLettersNumbers.click();

        WebElement categoryByLetterOrNumber = getDriver().findElement(
                By.xpath(String.format("//h2[normalize-space()='Category %s']", NUMBER_FOR_CATEGORY.toUpperCase()))
        );
        Assert.assertTrue(categoryByLetterOrNumber.getText().toLowerCase().endsWith(NUMBER_FOR_CATEGORY));

        WebElement textWithSelectedLetterOrNumber = getDriver().findElement(
                By.xpath(String.format("//strong[normalize-space()='%s']", NUMBER_FOR_CATEGORY.toUpperCase()))
        );
        Assert.assertTrue(textWithSelectedLetterOrNumber.getText().toLowerCase().contains(NUMBER_FOR_CATEGORY));

        List<WebElement> languageListByLetterOrNumber = getDriver().findElements(
                By.xpath("//table[@id='category']/tbody/tr/td[1]/a")
        );

        Assert.assertFalse(languageListByLetterOrNumber.isEmpty());
    }
}
