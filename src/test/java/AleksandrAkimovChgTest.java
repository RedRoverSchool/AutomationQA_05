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
                By.xpath("//ul[@id = 'menu']/li/a[@href = '/search.html']")
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

    @Test
    public void testH2TagText_WhenClickZOnSubmenuNavigationBarABCMenu() {
        final String BASE_URL = "https://www.99-bottles-of-beer.net/";

        String expectedResultH2Text = "Category Z";

        getDriver().get(BASE_URL);

        WebElement searchBrowseLanguageMenu = getDriver().findElement(
                By.xpath("//div[@id = 'navigation']/ul[@id = 'menu']/li/a[@href = '/abc.html']")
        );
        searchBrowseLanguageMenu.click();

        WebElement searchZOnSubmenuNavigationBarABCMenu = getDriver().findElement(
                By.xpath("//div[@id = 'navigation']/ul[@id = 'submenu']/li/a[@href = 'z.html']")
        );
        searchZOnSubmenuNavigationBarABCMenu.click();


        WebElement textPageCategoryZ = getDriver().findElement(
                By.xpath("//div[@id = 'main']/h2")
        );
        String actualResultH2Text = textPageCategoryZ.getText();

        Assert.assertEquals(actualResultH2Text, expectedResultH2Text);
    }
}
