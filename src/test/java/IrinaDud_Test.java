import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;




public class IrinaDud_Test extends BaseTest {
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
        final String expectedResult = "BROWSE LANGUAGES";

        getDriver().get(BASE_URL);

        WebElement browseLanguage = getDriver().findElement(By.xpath
                ("//div[@id='navigation']//a[@href='/abc.html']")
        );

        String actualResult = browseLanguage.getText();

        Assert.assertEquals(actualResult, expectedResult);
    }
}
