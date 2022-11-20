import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

import java.util.ArrayList;
import java.util.List;

public class NikolayMarkov3Test extends BaseTest {

    final String BASE_URL = "https://www.99-bottles-of-beer.net/";

    final static By SEARCH_LANGUAGES_MENU = By.xpath("//ul[@id = 'menu']/li/a[@href = '/search.html']");

    final static By SEARCH_FOR_FIEND = By.name("search");

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

    private void input(String text, By by, WebDriver driver){
        getElement(by, driver).sendKeys(text);
    }
    private int getListSize(By by, WebDriver driver){
        return getListOfElements(by, driver).size();
    }

    private List<String> getElementsText(By by, WebDriver driver){
        List<WebElement> elementsList = getListOfElements(by, driver);
        List<String> textList = new ArrayList<>();

        for (WebElement element : elementsList) {
            textList.add(element.getText().toLowerCase());

            //        for (int i = 0; i < elementsList.size(); i++) {//
            //        textList.add(elementsList.get(i).getText().toLowerCase());//        }
        }

        return textList;
    }

    @Test
    public void testSearchForLanguagesByName_HappyPath() {

        final String LANGUAGE_NAME = "python";

        openBaseURL(getDriver());
        click(SEARCH_LANGUAGES_MENU, getDriver());
        click(SEARCH_FOR_FIEND, getDriver());
        input(LANGUAGE_NAME, SEARCH_FOR_FIEND, getDriver());
        click(GO_BUTTON, getDriver());

        List<String> languagesNames = getElementsText(LANGUAGES_NAMES_LIST, getDriver());

        Assert.assertTrue(languagesNames.size() > 0);

        for (String languagesName : languagesNames){
            Assert.assertTrue(languagesName.contains(LANGUAGE_NAME));
        }
    }

    @Test
    public void testSearchForLanguagesNameEmpty_HappyPath() {
        final String BASE_URL = "https://www.99-bottles-of-beer.net/";

        getDriver().get(BASE_URL);
        WebElement searchLanguagesMenu = getDriver().findElement(
                By.xpath("//ul[@id = 'menu']/li/a[@href = '/search.html']")
        );
        searchLanguagesMenu.click();

        WebElement searchForFiend = getDriver().findElement(By.name("search"));
        searchForFiend.click();

        WebElement goButton = getDriver().findElement(By.name("submitsearch"));
        goButton.click();

        List<WebElement> languagesNamesList = getDriver().findElements(
                By.xpath("//table[@id = 'category']/tbody/tr/td[1]/a")
        );

        Assert.assertTrue(languagesNamesList.size() == 0);
    }

    @Test
    public void testMenuSearchSearchForLanguagesByNameJava_HappyPath() {
        final String BASE_URL = "https://www.99-bottles-of-beer.net/";
        final String LANGUAGE_NAME = "java";

        getDriver().get(BASE_URL);
        WebElement searchLanguagesMenu = getDriver().findElement(
                By.xpath("//ul[@id = 'menu']/li/a[@href = '/search.html']")
        );
        searchLanguagesMenu.click();

        WebElement searchForFiend = getDriver().findElement(By.name("search"));
        searchForFiend.click();
        searchForFiend.sendKeys(LANGUAGE_NAME);

        WebElement goButton = getDriver().findElement(By.name("submitsearch"));
        goButton.click();

        List<WebElement> languagesNamesList = getDriver().findElements(
                By.xpath("//table[@id = 'category']/tbody/tr/td[1]/a")
        );

        Assert.assertTrue(languagesNamesList.size() > 0);

        for (int i = 0; i < languagesNamesList.size(); i ++){
            Assert.assertTrue(languagesNamesList.get(i).getText().toLowerCase().contains(LANGUAGE_NAME));
        }
    }
}
