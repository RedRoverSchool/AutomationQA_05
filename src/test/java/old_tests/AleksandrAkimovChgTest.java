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

    final static By SEARCH_BROWSE_LANGUAGE_MENU =
            By.xpath("//div[@id = 'navigation']/ul[@id = 'menu']/li/a[@href = '/abc.html']");

    final static By TEXT_PAGE_CATEGORY_SIMBOL = By.xpath("//div[@id = 'main']/h2");

    final static String XPATH_SEARCH_SIMBOL_OR_LETTER_ON_SUBMENU_NAVIGATION_BAR_ABC_MENU =
            "//div[@id = 'navigation']/ul[@id = 'submenu']/li/a[@href]";

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

    private List<WebElement> getListOfElements(By by, WebDriver driver) {

        return driver.findElements(by);
    }

    private int getListSize(By by, WebDriver driver) {

        return getListOfElements(by, driver).size();
    }

    private String getText(By by, WebDriver driver) {

        return driver.findElement(by).getText();
    }

    private String getCategorySimbol(String simbol) {

        return String.format("Category %s", simbol);
    }

    private By getXpathByLetterInHferonSubmenuABS(String simbol) {

        return By.xpath(String.format("//div[@id = 'navigation']/ul[@id = 'submenu']/li/a[@href = '%s.html']",
                simbol.toLowerCase()));
    }

    @Test
    public void testLetterZ_WhenFindAndClickZOnSubmenuNavigationBarABCMenu() {
        final String SIMBOl_OR_LETTER = "Z";
        String expectedResultH2Text = getCategorySimbol(SIMBOl_OR_LETTER);

        openBaseUrl(getDriver());
        click(SEARCH_BROWSE_LANGUAGE_MENU, getDriver());

        Assert.assertTrue(
                    getListSize(SEARCH_SIMBOL_OR_LETTER_ON_SUBMENU_NAVIGATION_BAR_ABC_MENU, getDriver()) > 0);

        click(getXpathByLetterInHferonSubmenuABS(SIMBOl_OR_LETTER), getDriver());

        String actualResultH2Text = getText(TEXT_PAGE_CATEGORY_SIMBOL, getDriver());

        Assert.assertEquals(actualResultH2Text, expectedResultH2Text);
    }
}
