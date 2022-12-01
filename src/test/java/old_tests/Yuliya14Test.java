package old_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;

public class Yuliya14Test extends BaseTest {
    final String BASE_URL = "https://www.99-bottles-of-beer.net/";

    final static By BUTTON_SUBMIT_NEW_LANGUAGE_MENU = By.xpath("//ul[@id='menu']/li/a[@href= '/submitnewlanguage.html']");

    private void openBaseURL(WebDriver driver) {
        driver.get(BASE_URL);
    }

    private WebElement getElement(By by, WebDriver driver) {

        return  driver.findElement(by);
    }

    public void click(By by, WebDriver driver) {
        getElement(by, driver).click();
    }

    private void input(String text, By by, WebDriver driver) {
        getElement(by, driver).sendKeys(text);
    }

    @Test
    public void testMainNavigationButtonSubmitNewLanguage_HappyPath() throws InterruptedException {
        String expectedResultSubmitNewLanguageUrl = "https://www.99-bottles-of-beer.net/submitnewlanguage.html";

        getDriver().get(BASE_URL);
        click(BUTTON_SUBMIT_NEW_LANGUAGE_MENU, getDriver());
        Thread.sleep(3000);

        String actualResultSubmitNewLanguageUrl = getDriver().getCurrentUrl();
        Assert.assertEquals(actualResultSubmitNewLanguageUrl, expectedResultSubmitNewLanguageUrl);
    }
}
