import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

import java.util.List;

public class NstzyaTest extends BaseTest {

    final String BASE_URL = "https://www.99-bottles-of-beer.net/";
    final String LANGUAGE_NAME = "python";

    @Test
    public void testSearchForLanguageByNameField_HappyPath() {

        getDriver().get(BASE_URL);

        WebElement searchLanguagesMenu = getDriver().findElement(
                By.xpath("//ul[@id='menu']/li/a[@href='/search.html']")
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
    public void testHistoricInfoLink_WhenClickingOnLink_HappyPath() {

        String expectedResult = "https://www.99-bottles-of-beer.net/info.html";

        getDriver().get(BASE_URL);

        WebElement historicInfoLink = getDriver().findElement(
                By.xpath("//div[@id='main']/p/a[@href='./info.html']")
        );

        historicInfoLink.click();

        String actualResult = getDriver().getCurrentUrl();

        Assert.assertEquals(actualResult, expectedResult);
    }


    @Test
    public void testHereLink_WhenClickingOnLink_HappyPath() {

        String expectedResult = "https://www.99-bottles-of-beer.net/lyrics.html";

        getDriver().get(BASE_URL);

        WebElement hereLink = getDriver().findElement(
                By.xpath("//div[@id='main']/p/a[@href='./lyrics.html']")
        );

        hereLink.click();

        String actualResult = getDriver().getCurrentUrl();

        Assert.assertEquals(actualResult, expectedResult);

    }


    @Test
    public void testSubmitYourOwnCodeLink_WhenClickingOnLink_HappyPath() {

        String expectedResult = "https://www.99-bottles-of-beer.net/submitnewlanguage.html";

        getDriver().get(BASE_URL);

        WebElement submitYourCodeLink = getDriver().findElement(
                By.xpath("//div[@id='main']/p/a[@href='./submitnewlanguage.html']")
        );
        submitYourCodeLink.click();

        String actualResult = getDriver().getCurrentUrl();

        Assert.assertEquals(actualResult, expectedResult);
    }


    @Test
    public void testGuestbookLink_WhenClickingOnLink_HappyPath() {

        String expectedResult = "https://www.99-bottles-of-beer.net/guestbookv2.html";

        getDriver().get(BASE_URL);

        WebElement guestbookLink = getDriver().findElement(
                By.xpath("//div[@id='main']/p/a[@href='./guestbookv2.html']")
        );
        guestbookLink.click();

        String actualResult = getDriver().getCurrentUrl();

        Assert.assertEquals(actualResult, expectedResult);
    }


    @Test
    public void testTeamMembersLink_WhenClickingOnLink_HappyPath() {

        String expectedResult = "https://www.99-bottles-of-beer.net/team.html";

        getDriver().get(BASE_URL);

        WebElement guestbookLink = getDriver().findElement(
                By.xpath("//div[@id='main']/p/a[@href='./team.html']")
        );
        guestbookLink.click();

        String actualResult = getDriver().getCurrentUrl();

        Assert.assertEquals(actualResult, expectedResult);
    }
}
