import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

import java.util.List;

public class IgorUlianovTest extends BaseTest {
    @Test
    public void testBrowseLanguagesByCategoryName_HappyPath() {
        final String BASE_URL = "https://www.99-bottles-of-beer.net/";
        final String CATEGORY_NAME = "x";

        getDriver().get(BASE_URL);

        WebElement browseLanguagesMenu = getDriver().findElement(
                By.xpath("//ul[@id = 'menu']//a[@href='/abc.html']")
        );
        browseLanguagesMenu.click();

        WebElement searchForCategory = getDriver().findElement(
                By.xpath("//ul[@id = 'submenu']//a[@href='x.html']")
        );
        searchForCategory.click();

        List<WebElement> languagesNamesList = getDriver().findElements(
                By.xpath("//table[@id = 'category']/tbody//td[1]/a"));

        Assert.assertTrue(languagesNamesList.size() > 0);

        for (int i = 0; i < languagesNamesList.size(); i++) {
            Assert.assertTrue(languagesNamesList.get(i).getText().toLowerCase().startsWith(CATEGORY_NAME));
        }
    }
}
