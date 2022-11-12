import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

import java.util.List;

public class NadiaPawlowaTest extends BaseTest { //отсюда getdriver метод получаем
    @Test

    public void testSearchForLanguageByName_HappyPath() {
        final String BASE_URL = "https://www.99-bottles-of-beer.net/search.html"; //обязательно с большой буквы  и через подчеркивание
        final String LANGUAGE_NAME = "python";
//пробел между переменными с данными для тестирования и действием act

        // 1. Go to BASE URL.
        getDriver().get(BASE_URL);

        //2. Click on SEARCH LANGUAGES menu
        WebElement searchLanguagesMenu = getDriver().findElement(
                By.xpath("//ul[@id = 'menu']/li/a[@href = '/search.html']\n")
        );

        searchLanguagesMenu.click();
        //3. Click on Search for: field
        WebElement searchForField = getDriver().findElement(By.name("search"));
        searchForField.clear();
        //4. Input language name from test data.
        searchForField.sendKeys(LANGUAGE_NAME);
        //5. Click on button Go.
        WebElement goButton = getDriver().findElement(By.name("submitsearch"));
        goButton.click();

        List<WebElement> languagesNamesList = getDriver().findElements(By.xpath("//table[@id = 'category']/tbody/tr/td[1]/a"));

        Assert.assertTrue(languagesNamesList.size() > 0);
        for (int i = 0; i < languagesNamesList.size(); i++) {
            Assert.assertTrue(languagesNamesList.get(i).getText().toLowerCase().contains(LANGUAGE_NAME));
        }
    }
}
