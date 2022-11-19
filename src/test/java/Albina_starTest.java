import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

import java.util.List;

public class Albina_starTest extends BaseTest {

    @Test
    public void testSearchForLanguageByName_HappyPath() {
        final String BASE_URL = "https://99-bottles-of-beer.net/";
        final String LANGUAGE_PYTHON = "python";

        getDriver().get(BASE_URL);

        WebElement searchLanguagesMenu = getDriver().findElement(
                By.xpath("//ul[@id = 'menu']/li/a[@href = '/search.html']"));
        searchLanguagesMenu.click();

        WebElement searchForField = getDriver().findElement(By.name("search"));
        searchForField.click();
        searchForField.sendKeys(LANGUAGE_PYTHON);

        WebElement goButton = getDriver().findElement(By.name("submitsearch"));
        goButton.click();

        List<WebElement> languagesNamesList = getDriver().findElements(
                By.xpath("//table[@id='category']/tbody/tr/td[1]/a"));

        Assert.assertTrue(languagesNamesList.size() > 0);

        for (int i = 0; i < languagesNamesList.size(); i++) {
            Assert.assertTrue(languagesNamesList.get(i).getText().toLowerCase().contains(LANGUAGE_PYTHON));
        }
    }

    @Test
    public void testVerifyTextOfFooterMenuSearchLanguages_HappyPath() {
        final String BASE_URL = "https://99-bottles-of-beer.net/";
        final String SEARCH_LANGUAGES = "Search Languages";

        getDriver().get(BASE_URL);

        WebElement searchLanguagesFooterMenu = getDriver().findElement(
                By.xpath("//div[@id=\"footer\"]/p/a[3]"));
        searchLanguagesFooterMenu.click();

        WebElement searchLanguages = getDriver().findElement(
                By.xpath("//div[@id=\"main\"]/h2"));
        searchLanguages.getText();

        Assert.assertEquals(searchLanguages.getText(), SEARCH_LANGUAGES);

        WebElement searchFor = getDriver().findElement(
                By.xpath("//div/div[3]/form/p/input[1]"));
        searchFor.isDisplayed();

        Assert.assertTrue(searchFor.isDisplayed());


    }
}