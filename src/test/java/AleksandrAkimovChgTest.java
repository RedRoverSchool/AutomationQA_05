import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import runner.BaseTest;

import java.util.List;

public class AleksandrAkimovChgTest extends BaseTest   {
    final String BASE_URL = "https://www.99-bottles-of-beer.net/";
    final static By SEARCH_LANGUAGES_MENU = By.xpath("//ul[@id = 'menu']/li/a[@href = '/search.html']");
    final static By SEARCH_FOR_FIELD = By.name("search");
    final static By GO_BUTTON = By.name("submitsearch");
    final static By LANGUAGES_NAMES_LIST = By.xpath("//table[@id = 'category']/tbody/tr/td[1]/a");

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

    @Ignore
    @Test
    public void testH2TagText_WhenClickZOnSubmenuNavigationBarABCMenu() {
        final String BASE_URL = "https://www.99-bottles-of-beer.net/";

        String expectedResultH2Text = "Category Z";

        getDriver().get(BASE_URL);

        WebElement searchBrowseLanguageMenu = getDriver().findElement(
                By.xpath("//div[@id = 'navigation']/ul[@id = 'menu']/li/a[@href = '/abc.html']")
        );
        searchBrowseLanguageMenu.click();

        WebElement searchZOnSubmenuNavigationBarABCMenu = getDriver().findElement(
                By.xpath("//div[@id = 'navigation']/ul[@id = 'submenu']/li/a[@href = 'z.html']")
        );
        searchZOnSubmenuNavigationBarABCMenu.click();


        WebElement textPageCategoryZ = getDriver().findElement(
                By.xpath("//div[@id = 'main']/h2")
        );
        String actualResultH2Text = textPageCategoryZ.getText();

        Assert.assertEquals(actualResultH2Text, expectedResultH2Text);
    }
}
