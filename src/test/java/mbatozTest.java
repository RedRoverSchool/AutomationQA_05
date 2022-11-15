import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

import java.io.ByteArrayOutputStream;
import java.util.List;

public class mbatozTest extends BaseTest {

    @Test
    public void testSearchForLanguageByName_HappyPath() {
        final String BASE_URL = "https://www.99-bottles-of-beer.net";
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
}
