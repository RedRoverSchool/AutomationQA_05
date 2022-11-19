import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

import java.util.List;

public class Yuliya14Test extends BaseTest {

    @Test
    public void testSearchForLanguageByName_HappyPath() {
        final String BASE_URL = "https://www.99-bottles-of-beer.net/";
        final String LANGUAGE_NAME = "python";

        getDriver().get(BASE_URL);

        WebElement searchLanguagesMenu = getDriver().findElement(
                By.xpath("//ul[@id='menu']/li/a[@href = '/search.html']")
        );
        searchLanguagesMenu.click();

        WebElement searchForField = getDriver().findElement(By.name("search"));
        searchForField.click();
        searchForField.sendKeys(LANGUAGE_NAME);

        WebElement goButton = getDriver().findElement(By.name("submitsearch"));
        goButton.click();

        List<WebElement> languagesNamesList = getDriver().findElements(
                By.xpath("//table[@id='category']/tbody/tr/td[1]/a")
        );

        Assert.assertTrue(languagesNamesList.size() > 0);

        for (int i = 0; i < languagesNamesList.size(); i ++) {
            Assert.assertTrue(languagesNamesList.get(i).getText().toLowerCase().contains(LANGUAGE_NAME));
        }
    }

    @Test
    public void testMainNavigationButtonGuestbook_HappyPath() {
        final String BASE_URL = "https://www.99-bottles-of-beer.net/";
        String expectedResultGuestbookUrl = "https://www.99-bottles-of-beer.net/guestbookv2.html";

        getDriver().get(BASE_URL);

        WebElement buttonGuestbookMenu = getDriver().findElement(
                By.xpath("//ul[@id='menu']/li/a[@href= '/guestbookv2.html']")
        );
        buttonGuestbookMenu.click();

        String actualResultGuestbookUrl = getDriver().getCurrentUrl();

        Assert.assertEquals(actualResultGuestbookUrl, expectedResultGuestbookUrl);
    }

    @Test
    public void testMainNavigationButtonSubmitNewLanguage_HappyPath() {
        final String BASE_URL = "https://www.99-bottles-of-beer.net/";
        String expectedResultSubmitNewLanguageUrl = "https://www.99-bottles-of-beer.net/submitnewlanguage.html";

        getDriver().get(BASE_URL);

        WebElement buttonSubmitNewLanguageMenu = getDriver().findElement(
                By.xpath("//ul[@id='menu']/li/a[@href= '/submitnewlanguage.html']")
        );
        buttonSubmitNewLanguageMenu.click();

        String actualResultSubmitNewLanguageUrl = getDriver().getCurrentUrl();

        Assert.assertEquals(actualResultSubmitNewLanguageUrl, expectedResultSubmitNewLanguageUrl);
    }
}
