import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

import java.util.List;

public class AleksandrAkimovChgTest extends BaseTest {

    @Test
    public void testSearchForLanguageField_HappyPath() {
        final String BASE_URL = "https://www.99-bottles-of-beer.net/";
        final String LANGUAGE_PYTHON = "Python";

        getDriver().get(BASE_URL);

        WebElement searchLanguagesMenu = getDriver().findElement(
                By.xpath("//ul[@id = 'menu']/li/a[@ href = '/search.html']")
        );
        searchLanguagesMenu.click();

        WebElement searchForField = getDriver().findElement(By.name("search"));
        searchForField.click();
        searchForField.sendKeys(LANGUAGE_PYTHON);

        WebElement goButton = getDriver().findElement(By.name("submitsearch"));
        goButton.click();

        WebElement searchForFieldNoEmpty = getDriver().findElement(
                By.xpath("//input[@ name = 'search']")
        );
        searchForFieldNoEmpty.clear();

        WebElement goButton2 = getDriver().findElement(
                By.xpath("//input[@ name = 'submitsearch']")
        );
        goButton2.click();

        List<WebElement> languagesNamesList = getDriver().findElements(
                By.xpath("//table[@id = 'category']/tbody/tr/td[1]/a")
        );

        Assert.assertTrue(languagesNamesList.size() == 0);
    }
}
