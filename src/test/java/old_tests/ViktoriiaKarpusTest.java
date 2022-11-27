package old_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;

public class ViktoriiaKarpusTest extends BaseTest {

    final String BASE_URL = "https://www.99-bottles-of-beer.net/";
    final static By BROWSE_LANGUAGES = By.xpath("//ul[@id='menu']/li//a[@href='/abc.html']");

    final static By LETTER_V = By.xpath("//div/ul[@id='submenu']/li/a[@href='v.html']");

    private void openBaseURL(WebDriver driver) {
        driver.get(BASE_URL);
    }

    private void click(By by, WebDriver driver) {
        getElement(by, driver).click();
    }

    private WebElement getElement(By by, WebDriver driver) {

        return driver.findElement(by);
    }

    @Test
    public void testNavigationSubmenuClickLetterV() {
        String expectedResult = "V";

        openBaseURL(getDriver());

        click(BROWSE_LANGUAGES, getDriver());
        click(LETTER_V, getDriver());

        String actualResult = getElement(LETTER_V, getDriver()).getText();

        Assert.assertEquals(actualResult, expectedResult);

    }
}
