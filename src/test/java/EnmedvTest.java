import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

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
    private void openBaseURL(WebDriver driver) {

        driver.get(BASE_URL);
    }
    private WebElement getElement(By by, WebDriver driver) {

       return driver.findElement(by);
    }
    private List<WebElement> getListOfElements(By by, WebDriver driver) {

        return driver.findElements(by);
    }

    private void click(By by , WebDriver driver) {

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
        click(SEARCH_LANGUAGES_MENU ,getDriver());
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

        getDriver().get(BASE_URL);

        WebElement privacy = getDriver().findElement(
                By.xpath("//ul[@id = 'submenu']/li/a[@href = 'impressum.html']")
        );
        privacy.click();

        WebElement h3OliverSchadeInHeader = getDriver().findElement(
                By.xpath("//div[@id = 'main']/h3")
        );

        String actualResult = h3OliverSchadeInHeader.getText();

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testVerifyTextOnThePageImpressum() {
        String expectedResult = "os@ls-la.net";
        String textOnThePage = "os@ls-la.net";

        getDriver().get(BASE_URL);

        WebElement privacy = getDriver().findElement(
                By.xpath("//ul[@id = 'submenu']/li/a[@href = 'impressum.html']")
        );
        privacy.click();

        WebElement textEmailAdressOnThePage = getDriver().findElement(
                By.xpath("//div[@id = 'main']/p")
        );
        textEmailAdressOnThePage.click();

        String actualResult = textEmailAdressOnThePage.getText();

        Assert.assertTrue(textEmailAdressOnThePage.getText().contains(textOnThePage));

        Assert.assertEquals(actualResult, expectedResult);

    }
}
