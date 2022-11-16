import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;
import java.util.List;

public class EnmedvTest extends BaseTest {
    static final String BASE_URL = "https://www.99-bottles-of-beer.net/";

    @Test
    public void testSearchLanguageByName_HappyPath() {
        final String LANGUAGE_PYTHON = "python";

        getDriver().get(BASE_URL);
        WebElement SearchLanguagesMenu = getDriver().findElement(
                By.xpath("//ul[@id = 'menu']/li/a[@href = '/search.html']")
                );
        SearchLanguagesMenu.click();

        WebElement searchForField = getDriver().findElement(By.name("search"));
        searchForField.click();
        searchForField.sendKeys(LANGUAGE_PYTHON);

        WebElement goButton = getDriver().findElement(By.name("submitsearch"));
        goButton.click();

        List<WebElement> languagesNamesList = getDriver().findElements(
                By.xpath("//table[@id = 'category']/tbody/tr/td[1]/a")
        );
        Assert.assertTrue(languagesNamesList.size() > 0);

        for (int i = 0; i < languagesNamesList.size(); i ++) {
            Assert.assertTrue(languagesNamesList.get(i).getText().toLowerCase().contains(LANGUAGE_PYTHON));
        }
    }

    @Test
    public void testVerifyTextInHeaderH2() {
        String expectedResult = "Privacy";
        getDriver().get(BASE_URL);
        WebElement searchPrivacy = getDriver().findElement(
                By.xpath("//ul[@id = 'submenu']/li/a[@href = 'impressum.html']")
        );
        searchPrivacy.click();

        WebElement h2PrivacyHeader = getDriver().findElement(
                By.xpath("//div[@id = 'main']/h2")
        );
        String actualResult = h2PrivacyHeader.getText();

        Assert.assertEquals(actualResult, expectedResult);
    }
}
