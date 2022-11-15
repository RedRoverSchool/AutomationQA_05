import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

import java.util.List;

public class ElenaStratTest extends BaseTest {
    static final String BASE_URL = "https://www.99-bottles-of-beer.net/";

    @Test
    public void testSearchForLanguageByName_HappyPath() {
        final String LANGUAGE_PYTHON = "python";

        getDriver().get(BASE_URL);

        WebElement searchLanguagesMenu = getDriver().findElement(By.xpath("//ul[@id = 'menu']/li/a[@href = '/search.html']")
        );
        searchLanguagesMenu.click();

        WebElement searchForField = getDriver().findElement(By.name("search"));
        searchForField.click();
        searchForField.sendKeys(LANGUAGE_PYTHON);

        WebElement goButton = getDriver().findElement(By.name("submitsearch"));
        goButton.click();

        List<WebElement> languagesNamesList = getDriver().findElements(By.xpath("//table[@id='category']/tbody/tr/td[1]/a"));

        Assert.assertTrue(languagesNamesList.size() > 0);
        for (int i = 0; i < languagesNamesList.size(); i++) {
            Assert.assertTrue(languagesNamesList.get(i).getText().toLowerCase().contains(LANGUAGE_PYTHON));
        }
    }




    @Test
    public void testStartForVerifyWishesFromTheTeamFirstParagraph_HappyPath() {
        String expectedResult = "This Website holds a collection of the Song 99 Bottles of Beer programmed in different programming languages. " +
                "Actually the song is represented in 1500 different programming languages and variations. " +
                "For more detailed information refer to historic information.";

        getDriver().get(BASE_URL);

        WebElement verifyText = getDriver().findElement(By.xpath("//div[@id = 'main']/descendant-or-self::p"));
        String actualResult = verifyText.getText();

        Assert.assertEquals(actualResult,expectedResult);

    }
}
