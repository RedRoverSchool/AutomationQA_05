import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

import java.util.List;

public class VerafesTest extends BaseTest {

    final String BASE_URL = "https://www.99-bottles-of-beer.net/";

    // Global string to be used in multiple tests
    String SUB_MENU_OPTION = "";

    @Test
    public void testSearchForLanguageByName_HappyPath() {
        final String BASE_URL = "https://www.99-bottles-of-beer.net/";
        final String LANGUAGE_NAME = "python";

        getDriver().get(BASE_URL);

        WebElement searchLanguagesMenu = getDriver().findElement(
                By.xpath("//ul[@id = 'menu']/li/a[@href = '/search.html']")
        );
        searchLanguagesMenu.click();

        WebElement searchForField = getDriver().findElement(By.name("search"));
        searchForField.click();
        searchForField.sendKeys(LANGUAGE_NAME);

        WebElement goButton = getDriver().findElement(By.name("submitsearch"));
        goButton.click();

        List<WebElement> languagesNamesList = getDriver().findElements(By.xpath("//table[@id='category']/tbody/tr/td[1]/a"));

        Assert.assertTrue(languagesNamesList.size() > 0);

        for (int i = 0; i < languagesNamesList.size(); i++) {
            Assert.assertTrue(languagesNamesList.get(i).getText().toLowerCase().contains(LANGUAGE_NAME));
        }
    }

    @Test
    public void testSubmenuInfoLabelText_HappyPath(){
        SUB_MENU_OPTION = "info.html";
        String expectedResult = "History";

        getDriver().get(BASE_URL);

        WebElement subMenuInfo = getDriver().findElement(
                By.xpath("//ul[@id='submenu']/li/a[@href='" +SUB_MENU_OPTION+ "']")
        );
        Assert.assertEquals(subMenuInfo.getText(), expectedResult);
    }

    @Test
    public void testSubmenuInfo_VerufylinkText_HappyPath(){
        SUB_MENU_OPTION = "info.html";

        getDriver().get(BASE_URL);

        WebElement subMenuInfo = getDriver().findElement(
                By.xpath("//ul[@id='submenu']/li/a[@href='" +SUB_MENU_OPTION+ "']")
        );

        String actualResul = subMenuInfo.getAttribute("href");

        Assert.assertTrue(subMenuInfo.getAttribute("href").contains(SUB_MENU_OPTION));
    }
}
