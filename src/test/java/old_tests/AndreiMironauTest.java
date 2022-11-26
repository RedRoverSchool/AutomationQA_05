package old_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;

import java.util.List;

public class AndreiMironauTest extends BaseTest {
    final String BASE_URL = "https://www.99-bottles-of-beer.net/";
    final static By SUBLITLE_HEADER = By.xpath("//div[@id='header']/h2");

    private void openBaseURL(WebDriver driver) {
        driver.get(BASE_URL);
    }

    private WebElement getElement (By by, WebDriver driver) {

        return driver.findElement(by);
    }

    private String getText(By by, WebDriver driver) {

        return driver.findElement(by).getText();
    }

    @Test
    public void testSearchForLanguageFieldByName_HappyPath() {
        //A1
        final String BASE_URL = "https://www.99-bottles-of-beer.net/";
        final String LANGUAGE_PYTHON = "python";

        //A2
        getDriver().get(BASE_URL);

        WebElement searchLanguagesMenu = getDriver().findElement(
                By.xpath("//ul[@id = 'menu']/li/a[@href = '/search.html']")
        );
        searchLanguagesMenu.click();

        WebElement searchForField = getDriver().findElement(By.name("search"));
        searchForField.click();
        searchForField.sendKeys(LANGUAGE_PYTHON);

        WebElement goButton = getDriver().findElement(By.name("submitsearch"));
        goButton.click();

        List<WebElement> languagesNamesList = getDriver().findElements(
                By.xpath("//table[@id='category']/tbody/tr/td[1]/a")
        );

        //A3
        Assert.assertTrue(languagesNamesList.size() > 0);

        for (int i = 0; i < languagesNamesList.size(); i++) {
            Assert.assertTrue(languagesNamesList.get(i).getText().toLowerCase().contains(LANGUAGE_PYTHON));
        }
    }

    @Test
    public void testH2TagTextHeaderMain_HappyPath() {
        final String expectedResult = "one program in 1500 variations";

        openBaseURL(getDriver());

        WebElement sublitleHeader = getElement(SUBLITLE_HEADER, getDriver());

        String actualResult = getText(SUBLITLE_HEADER, getDriver());

        Assert.assertEquals(actualResult, expectedResult);
    }
}