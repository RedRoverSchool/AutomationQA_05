import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;
import java.util.ArrayList;
import java.util.List;

public class TatyanaBelikovaTest extends BaseTest {

        final String BASE_URL = "https://www.99-bottles-of-beer.net/";
        final String LANGUAGE_NAME = "python";
        final static By SEARCH_LANGUAGES_MENU =  By.xpath("//ul[@id = 'menu']/li/a[@href = '/search.html']");
        final static By SEARCH_FOR_FIELD = By.name("search");
        final static By GO_BUTTON = By.name("submitsearch");
        final static By LANGUAGES_NAMES_LIST = By.xpath("//table[@id='category']/tbody/tr/td[1]/a");

        final static By SUB_MENU_IMPRESSUM = By.xpath("//div[@id='navigation']/ul//li/a[@href='impressum.html']");

        private void openBaseURL(WebDriver driver) {
            driver.get(BASE_URL);
        }

        private WebElement getElement(By by, WebDriver driver) {

            return driver.findElement(by);
        }
        private String getText(By by, WebDriver driver) {

            return driver.findElement(by).getText();
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
    public void testSearchForLanguageFieldByName_HappyPath() {

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
    public void testSubmenuImpressumLabelText_Privacy() {

        final String expectedResult = "Privacy";

      openBaseURL(getDriver());
        Assert.assertEquals(getText(SUB_MENU_IMPRESSUM, getDriver()), expectedResult);
         }
    }
