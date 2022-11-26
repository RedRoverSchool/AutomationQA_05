package old_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;

public class MariyaSvetlovaTest extends BaseTest {

    final static String BASE_URL = "https://www.99-bottles-of-beer.net/";

    final static By HEADER_H_1 = By.xpath("//div[@id='header']/h1");
    final static By HEADER_H_2 = By.xpath("//div[@id='header']/h2");

    private void openBaseURL (WebDriver driver) {
        driver.get(BASE_URL);
    }

    private WebElement getElement (By by, WebDriver driver) {

        return driver.findElement(by);
    }

    @Test
    public void testVerifyHeaderH1OnStartPage() {
        final String HEADER_H1_TEXT = "99 Bottles of Beer";

        openBaseURL(getDriver());

        Assert.assertEquals(getElement(HEADER_H_1, getDriver()).getText(),HEADER_H1_TEXT);
    }

    @Test
    public void testVerifyHeaderH2OnStartPage() {
        final String HEADER_H2_TEXT = "one program in 1500 variations";

        openBaseURL(getDriver());

        Assert.assertEquals(getElement(HEADER_H_2, getDriver()).getText(),HEADER_H2_TEXT);
    }
}
