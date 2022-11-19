import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

import java.util.List;

public class mbatozTest extends BaseTest {
    static final String BASE_URL = "https://www.99-bottles-of-beer.net";

    @Test
    public void testSearchForLanguageByName_HappyPath() {

        final String LANGUAGE_PYTHON = "python";

        getDriver().get(BASE_URL);
        WebElement searchLanguagesMenu = getDriver().findElement(
                By.xpath("//ul[@id='menu']/li//a[@href='/search.html']")
        );
        searchLanguagesMenu.click();

        WebElement searchforField = getDriver().findElement(By.name("search"));
        searchforField.click();
        searchforField.sendKeys(LANGUAGE_PYTHON);
        //searchforField.clear();

        WebElement goButton = getDriver().findElement(By.name("submitsearch"));
        goButton.click();

        List<WebElement> languageNamesList = getDriver().findElements(
                By.xpath("//table[@id='category']/tbody/tr/td[1]/a"));

        Assert.assertTrue(languageNamesList.size() > 0);

        for (int i = 0; i < languageNamesList.size(); i ++) {
            Assert.assertTrue(languageNamesList.get(i).getText().toLowerCase().contains(LANGUAGE_PYTHON));
        }
    }


    @Test
    public void testStartForVerifyWishesFromTheTeam_HappyPath() {
        getDriver().get(BASE_URL);

        String ExpectedResult = "This Website holds a collection of the Song 99 Bottles of Beer programmed in different programming languages. " +
                "Actually the song is represented in 1500 different programming languages and variations. " +
                "For more detailed information refer to historic information.";
        String ActualResult = getDriver().findElement(
                By.xpath("//p[contains(text(),'This Website holds a collection of the Song')]")
        ).getText();

        Assert.assertEquals(ActualResult, ExpectedResult);

    }
}
