package old_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;

import java.util.ArrayList;
import java.util.List;

public class VictoriaLemaTest extends BaseTest {

    final String BASE_URL = "https://www.99-bottles-of-beer.net/";

    final static By SEARCH_LANGUAGES_MENU =  By.xpath("//ul[@id = 'menu']/li/a[@href = '/search.html']");
    final static By SEARCH_FOR_FIELD = By.name("search");
    final static By GO_BUTTON = By.name("submitsearch");
    final static By LANGUAGES_NAMES_LIST = By.xpath("//table[@id='category']/tbody/tr/td[1]/a");
    final static By TOP_LISTS_ON_THE_FOOTER_MENU = By.xpath("//div[@id='footer']/p/a[@href='/toplist.html']");
    final static By TOP_RATED_LANGUAGES_NAMES = By.xpath("//table[@id='category']/tbody/tr/td[2]");
    final static By SUBMIT_NEW_LANGUAGE_REFERENCE = By.xpath(
            "//div[@id='footer']/p/a[@href='/submitnewlanguage.html']");
    final static By CATEGORY_FIELD = By.xpath("//form[@id='addlanguage']/p/select[@name='category']");
    final static By CATEGORY_NAMES = By.xpath("//select[@name='category']");
    final static By LANGUAGES_CATEGORIES_OPTIONS = By.xpath("//form[@id='addlanguage']/p/select[@name='category']/option");
    final static By ESOTERIC_LANGUAGE_OPTION = By.xpath("//form[@id='addlanguage']/p/select[@name='category']/"
            + "option[text()='esoteric language']");
    final static By SUBMIT_LANGUAGE_BUTTON = By.xpath("//input[@type='submit'][@name='submitlanguage']");
    final static By LANGUAGES_CATEGORIES_SELECTED = By.xpath("//select[@name='category']/option[@selected]");
    final static By LANGUAGE_FIELD = By.xpath("//form[@id='addlanguage']/p/input[@name='language']");
    final static By AUTHOR_FIELD = By.name("author");
    final static By EMAIL_FIELD = By.name("email");
    final static By REAL_LANGUAGE_OPTION = By.xpath("//form[@id='addlanguage']/p/select[@name='category']/"
            + "option[text()='real language']");
    final static By CODE_FIELD = By.name("code");
    final static By FULL_ERROR_MESSAGE = By.xpath("//div[@id='main']/p");

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

    private String getCurrentURL(By by, WebDriver driver) {
        getElement(by,driver).click();

        return driver.getCurrentUrl();
    }

    private List<String> getElementsText(By by, WebDriver driver) {
        List<WebElement> elementsList = getListOfElements(by, driver);
        List<String> textList = new ArrayList<>();

        for (WebElement element : elementsList) {
            textList.add(element.getText().toLowerCase());
        }

        return textList;
    }

    private String getText (By by, WebDriver driver) {

        return getElement(by,driver).getText();
    }

    private String getTextInLowerCase (By by, WebDriver driver) {

        return getElement(by,driver).getText().toLowerCase();
    }

    @Test
    public void testSearchForLanguageByName_HappyPath() {
        final String LANGUAGE_NAME = "python";

        openBaseURL(getDriver());
        click(SEARCH_LANGUAGES_MENU,getDriver());
        click(SEARCH_FOR_FIELD,getDriver());
        input(LANGUAGE_NAME,SEARCH_FOR_FIELD,getDriver());
        click(GO_BUTTON,getDriver());

        List<String> languageNames = getElementsText(LANGUAGES_NAMES_LIST, getDriver());

        Assert.assertTrue(languageNames.size() > 0);

        for (String languageName : languageNames) {
            Assert.assertTrue(languageName.contains(LANGUAGE_NAME));
        }
    }

    @Test
    public void testIfTopListsReferenceOnTheFooterMenuRedirectsToTheTopListPage_WhenClickingOnIt() {
        String expectedResult = "https://www.99-bottles-of-beer.net/toplist.html";

        openBaseURL(getDriver());

        String actualResult=getCurrentURL(TOP_LISTS_ON_THE_FOOTER_MENU,getDriver());

        Assert.assertEquals(actualResult,expectedResult);
    }

    @Test
    public void testIfToplistsFooterMenRedirectsToPageWithInformation_WhenClickingOnIt() {
        final int TOP_LANGUAGES_MINIMAL_QUANTITY = 2;

        openBaseURL(getDriver());
        click(TOP_LISTS_ON_THE_FOOTER_MENU,getDriver());

        List<String> topRatedLanguages = getElementsText(TOP_RATED_LANGUAGES_NAMES,getDriver());

        Assert.assertTrue(topRatedLanguages.size()>0);

        Assert.assertTrue(topRatedLanguages.size()>=TOP_LANGUAGES_MINIMAL_QUANTITY);
    }


    @Test
    public void testLanguageCategories_WhenSubmittingANewLanguage() {
        int expectedResultNumber = 3;
        final String CATEGORY_1 = "real";
        final String CATEGORY_2 = "esoteric";
        final String CATEGORY_3 = "assembly";
        String expectedResultCategory = "esoteric language";

        openBaseURL(getDriver());
        click(SUBMIT_NEW_LANGUAGE_REFERENCE,getDriver());
        click(CATEGORY_FIELD,getDriver());
        String categoryNames = getText(CATEGORY_NAMES,getDriver());
        List<String> languagesCategories = getElementsText(LANGUAGES_CATEGORIES_OPTIONS,getDriver());
        Assert.assertTrue(languagesCategories.size()>0);
        click(ESOTERIC_LANGUAGE_OPTION,getDriver());
        click(SUBMIT_LANGUAGE_BUTTON,getDriver());

        String actualResultCategory = getText(LANGUAGES_CATEGORIES_SELECTED,getDriver());

        Assert.assertEquals(languagesCategories.size(),expectedResultNumber);
        Assert.assertTrue(categoryNames.contains(CATEGORY_1)&& categoryNames.contains(CATEGORY_2)
                &&categoryNames.contains(CATEGORY_3));
        Assert.assertEquals(actualResultCategory,expectedResultCategory);
    }

    @Test
    public void testErrorMessageTextAfterIncompleteInput() {
        final String language = "java";
        final String author = "tester";
        final String email = "jka59433@xcoxc.com";
        final String code = "String";
        final String error = "error";
        final String errorReason = "incomplete input";

        openBaseURL(getDriver());
        click(SUBMIT_NEW_LANGUAGE_REFERENCE,getDriver());
        input(language,LANGUAGE_FIELD,getDriver());
        input(author,AUTHOR_FIELD,getDriver());
        input(email,EMAIL_FIELD,getDriver());
        click(CATEGORY_FIELD,getDriver());
        click(REAL_LANGUAGE_OPTION,getDriver());
        input(code, CODE_FIELD,getDriver());
        click(SUBMIT_LANGUAGE_BUTTON,getDriver());
        String errorMessage = getTextInLowerCase(FULL_ERROR_MESSAGE,getDriver());

        Assert.assertNotNull(errorMessage);

        Assert.assertTrue(errorMessage.contains(error));
        Assert.assertTrue(errorMessage.contains(errorReason));
    }
}

