import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import runner.BaseTest;

import java.util.List;

public class AnastassiaITest extends BaseTest {
    static final String BASE_URL = "https://www.99-bottles-of-beer.net";
@Ignore
    @Test
    public void testSearchForLanguage_HappyPath(){
        final String LANGUAGE_NAME = "python";

        getDriver().get(BASE_URL);

        WebElement searchLanguagesMenu = getDriver().findElement(By.xpath("//ul[@id='menu']/li/a[@href='/search.html']"));
        searchLanguagesMenu.click();

        WebElement searchForField = getDriver().findElement(By.name("search"));
        searchForField.click();
        searchForField.sendKeys(LANGUAGE_NAME);

        WebElement goButton = getDriver().findElement(By.name("submitsearch"));
        goButton.click();

        List<WebElement> languagesNamesList = getDriver().findElements(By.xpath("//table[@id='category']/tbody/tr/td[1]/a"));

        Assert.assertTrue(languagesNamesList.size() > 0);

        for (int i = 0; i < languagesNamesList.size(); i++) {
            Assert.assertTrue(languagesNamesList.get(i).getText().toLowerCase().contains(LANGUAGE_NAME));
        }
    }


    @Test
    public void testH2TagText_WhenTestSubmenuInfo(){
        String expectedResult = "History";

        getDriver().get(BASE_URL);

        WebElement submenuInfoLink = getDriver().findElement(By.xpath("//a[@href='info.html']"));
        submenuInfoLink.click();

        WebElement headerH2 = getDriver().findElement(By.xpath("//div[@id='main']/h2"));
        String actualResult = headerH2.getText();

        Assert.assertEquals(actualResult, expectedResult);
    }
}