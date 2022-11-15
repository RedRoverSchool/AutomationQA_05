import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

import java.util.List;

public class GalinaKuklevaTest extends BaseTest {
    static final String BASE_URL = "https://99-bottles-of-beer.net/";

    @Test
    public void testSearchForLanguageFeild_HappyPath() {

        final String LANGUAGE_NAME = "python";

        getDriver().get(BASE_URL);
        WebElement searchLanguagesMenu = getDriver().findElement(
                By.xpath("//ul[@id='menu']//a[@href='/search.html']")
        );
        searchLanguagesMenu.click();
        WebElement searchForFeild = getDriver().findElement(
                By.name("search")
        );
        searchForFeild.click();
        searchForFeild.sendKeys(LANGUAGE_NAME);
        WebElement goButton = getDriver().findElement(
                By.name("submitsearch")
        );
        goButton.click();
        List<WebElement> languagesNamesList = getDriver().findElements(
                By.xpath("//table[@id='category']/tbody/tr/td[1]/a")
        );

        Assert.assertTrue(languagesNamesList.size() > 0);

        for (int i = 0; i < languagesNamesList.size(); i++) {
            Assert.assertTrue(languagesNamesList.get(i).getText().toLowerCase().contains(LANGUAGE_NAME));
        }
    }
}
