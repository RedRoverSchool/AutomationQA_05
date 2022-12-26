package old_tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class EnmedvTest extends BaseTest {
    final String BASE_URL = "https://www.99-bottles-of-beer.net/";

    final static By SEARCH_LANGUAGES_MENU = By.xpath("//ul[@id = 'menu']/li/a[@href = '/search.html']");
    final static By SEARCH_FOR_FIELD = By.name("search");
    final static By GO_BUTTON = By.name("submitsearch");
    final static By LANGUAGES_NAMES_LIST = By.xpath("//table[@id = 'category']/tbody/tr/td[1]/a");
    final static By PRIVACY = By.xpath("//ul[@id = 'submenu']/li/a[@href = 'impressum.html']");
    final static By H_2_PRIVACY_HEADER = By.xpath("//div[@id = 'main']/h2");
    final static By H_3_OLIVER_SCHADE_IN_HEADER = By.xpath("//div[@id = 'main']/h3");
    final static By TEXT_EMAIL_ADRESS_ON_THE_PAGE = By.xpath("//div[@id = 'main']/p");

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

    private String getElementText(By by, WebDriver driver) {

        return getElement(by, driver).getText();
    }

    private List<String> getElementsText(By by, WebDriver driver) {
        List<WebElement> elementsList = getListOfElements(by, driver);
        List<String> textList = new ArrayList<>();

//       for (int i = 0; i < elementsList.size(); i ++) {
//           textList.add(elementsList.get(i).getText().toLowerCase());
//       }   тоже самое, что и цикл for ниже

        for (WebElement element : elementsList) {
            textList.add(element.getText().toLowerCase());
        }
        return textList;
    }

    @Test
    public void testSearchLanguageByName_HappyPath() {
        final String LANGUAGE_NAME = "python";

        openBaseURL(getDriver());
        click(SEARCH_LANGUAGES_MENU, getDriver());
        click(SEARCH_FOR_FIELD, getDriver());
        input(LANGUAGE_NAME, SEARCH_FOR_FIELD, getDriver());
        click(GO_BUTTON, getDriver());

        List<String> languageNames = getElementsText(LANGUAGES_NAMES_LIST, getDriver());

        Assert.assertTrue(languageNames.size() > 0);

        for (String languageName : languageNames) {
            Assert.assertTrue(languageName.contains(LANGUAGE_NAME));
        }
    }

    @Test
    public void testVerifyTextInHeaderH2() {
        String expectedResult = "Privacy";

        openBaseURL(getDriver());
        click(PRIVACY, getDriver());

        String actualResult = getElementText(H_2_PRIVACY_HEADER, getDriver());

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testVerifyTextInHeaderH3() {
        String expectedResult = "Oliver Schade";

        openBaseURL(getDriver());
        click(PRIVACY, getDriver());
        click(H_3_OLIVER_SCHADE_IN_HEADER, getDriver());

        String actualResult = getElementText(H_3_OLIVER_SCHADE_IN_HEADER, getDriver());

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testVerifyTextOnThePageImpressum() {
        String expectedResult = "os@ls-la.net";

        openBaseURL(getDriver());
        click(PRIVACY, getDriver());
        click(TEXT_EMAIL_ADRESS_ON_THE_PAGE, getDriver());

        String actualResult = getElementText(TEXT_EMAIL_ADRESS_ON_THE_PAGE, getDriver());

        Assert.assertEquals(actualResult, expectedResult);

    }
}
