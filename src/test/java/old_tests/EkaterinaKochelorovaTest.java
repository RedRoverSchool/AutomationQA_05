package old_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;

import java.util.List;

public class EkaterinaKochelorovaTest extends BaseTest {

    final String BASE_URL = "https://www.99-bottles-of-beer.net/";
    final static By SUBMENU_LYRICS_LINK = By.xpath("//ul[@id = 'submenu']/li/a[@href = 'lyrics.html']");
    final static By H2_TAG_TEXT = By.xpath("//div[@id = 'main']/h2");
    final static By P_TAG_TEXT = By.xpath("//div[@id = 'main']/p");

    private void openBaseUrl(WebDriver driver) {
        driver.get(BASE_URL);
    }

    private WebElement getElement(By by, WebDriver driver) {
        return driver.findElement(by);
    }

    private List<WebElement> getElements(By by, WebDriver driver) {
        return driver.findElements(by);
    }

    private void click(By by, WebDriver driver) {
        getElement(by, driver).click();
    }

    private String getElementText(By by, WebDriver driver) {
        return getElement(by, driver).getText();
    }

    @Test
    public void testH2TagText_WhenChooseSubmenuLyrics() {
        String expectedResult = "Lyrics of the song 99 Bottles of Beer";

        openBaseUrl(getDriver());
        click(SUBMENU_LYRICS_LINK, getDriver());

        String actualResult = getElementText(H2_TAG_TEXT, getDriver());

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testPTagText_WhenChooseSubmenuLyrics() {
        int expectedResult = 100;

        openBaseUrl(getDriver());
        click(SUBMENU_LYRICS_LINK, getDriver());

        int actualResult = getElements(P_TAG_TEXT, getDriver()).size();

        Assert.assertEquals(actualResult, expectedResult);
    }
}
