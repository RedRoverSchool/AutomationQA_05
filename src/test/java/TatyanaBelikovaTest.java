import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;
import java.util.List;

public class TatyanaBelikovaTest extends BaseTest {

    @Test
    public void testSearchForLanguageFieldByName_HappyPath() {
        final String BASE_URL = "https://www.99-bottles-of-beer.net/";
        final String LANGUAGE_NAME = "python";

        getDriver().get(BASE_URL);

        WebElement searchLanguagesMenu = getDriver().findElement(
                By.xpath("//ul[@id = 'menu']/li/a[@href = '/search.html']"));
        searchLanguagesMenu.click();

        WebElement searchForField = getDriver().findElement(
                By.name ("search"));
        searchForField.click();
        searchForField.sendKeys(LANGUAGE_NAME);

        WebElement goButton = getDriver().findElement(By.name("submitsearch"));
        goButton.click();

        List<WebElement> languageNameList = getDriver().findElements(By.xpath("//table[@id='category']/tbody/tr/td[1]/a"));

        Assert.assertTrue(languageNameList.size() > 0);
         for (int i = 0; i < languageNameList.size(); i++){
             Assert.assertTrue(languageNameList.get(i).getText().toLowerCase().contains(LANGUAGE_NAME));
         }
    }
}