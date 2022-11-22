import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

import java.util.List;


public class IrinaDud_Test extends BaseTest {
    //final String BASE_URL = "https://www.99-bottles-of-beer.net/";
//
    //private void openBaseURL(WebDriver driver) {
    //    driver.get(BASE_URL);
    //}
//
    //private WebElement getElement(By by,WebDriver driver) {
//
    //    return driver.findElement(by);
    //}
//


    @Test
    public void testSearchForLanguagesByName_HappyPath() {
        final String BASE_URL = "https://www.99-bottles-of-beer.net/";
        final String LANGUAGE_NAME = "python";


       getDriver().get(BASE_URL);

        WebElement searchLanguageMenu = getDriver().findElement(By.xpath("//ul[@id='menu']/li/a[@href='/search.html']"));
        searchLanguageMenu.click();

        WebElement searchForField = getDriver().findElement(By.name("search"));
        searchForField.click();
        searchForField.sendKeys(LANGUAGE_NAME);

        WebElement goButton = getDriver().findElement(By.name("submitsearch"));
        goButton.click();

        List<WebElement> languageNameList = getDriver().findElements(By.xpath("//table[@id='category']/tbody/tr/td[1]/a"));

        Assert.assertTrue(languageNameList.size() > 0);

        for(int i =0;i < languageNameList.size();i ++) {
            Assert.assertTrue(languageNameList.get(i).getText().toLowerCase().contains(LANGUAGE_NAME));
        }
    }
    @Test
    public void testVerifyTextHeader1_HappyPath() {
        final String BASE_URL = "https://www.99-bottles-of-beer.net/";
        final String expectedResult = "99 Bottles of Beer";

        getDriver().get(BASE_URL);

        WebElement titleHeader1 = getDriver().findElement(By.xpath("//div[@id='header']/h1"));

        String actualResult = titleHeader1.getText();

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testFooterBrowseLanguages_HappyPath() {
        final String BASE_URL = "https://www.99-bottles-of-beer.net/";
        final String expectedResult = "https://www.99-bottles-of-beer.net/abc.html";

        getDriver().get(BASE_URL);

        WebElement browseLanguage = getDriver().findElement(By.xpath
                ("//div[@id='navigation']//a[@href='/abc.html']")
        );
        browseLanguage.click();

        String actualResult = getDriver().getCurrentUrl();

        Assert.assertEquals(actualResult, expectedResult);
    }
}
