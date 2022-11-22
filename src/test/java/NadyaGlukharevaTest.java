import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

import java.util.List;

public class NadyaGlukharevaTest extends BaseTest {

    @Test
    public void testSearchForEmptySearch_HappyPath() {

        final String BASE_URL = "https://www.99-bottles-of-beer.net/";
        int expectedResult = 0;

        getDriver().get(BASE_URL);

        WebElement searchLanguagesMenu = getDriver().findElement(
                By.xpath("//ul[@id='menu']/li/a[@href='/search.html']"));
        searchLanguagesMenu.click();

        WebElement searchForField = getDriver().findElement(
                By.name("search"));
        searchForField.click();

        WebElement goButton = getDriver().findElement(By.name("submitsearch"));
        goButton.click();

        List<WebElement> resultsTable = getDriver().findElements(By.tagName("table"));

        Assert.assertEquals(expectedResult, resultsTable.size());
    }
}
