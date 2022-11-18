import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

import java.util.List;

public class NikolayMarkov3Test extends BaseTest {

    @Test
    public void testSearchForLanguagesEmpty_HappyPath() {
        final String BASE_URL = "https://www.99-bottles-of-beer.net/";

        getDriver().get(BASE_URL);
        WebElement searchLanguagesMenu = getDriver().findElement(
                By.xpath("//ul[@id = 'menu']/li/a[@href = '/search.html']")
        );
        searchLanguagesMenu.click();

        WebElement searchForFiend = getDriver().findElement(By.name("search"));
        searchForFiend.click();

        WebElement goButton = getDriver().findElement(By.name("submitsearch"));
        goButton.click();

        List<WebElement> languagesNamesList = getDriver().findElements(
                By.xpath("//table[@id = 'category']")
        );
        Assert.assertTrue(languagesNamesList.size() == 0);


    }
}
