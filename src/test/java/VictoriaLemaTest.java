import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

import java.util.List;

public class VictoriaLemaTest extends BaseTest {

    static final String BASE_URL = "https://www.99-bottles-of-beer.net/";

    @Test
    public void testSearchForLanguageByName_HappyPath() {
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

        List<WebElement> languagesNameList = getDriver().findElements(
                By.xpath("//table[@id='category']/tbody/tr/td[1]/a")
        );

        Assert.assertTrue(languagesNameList.size() > 0);

        for (int i = 0; i < languagesNameList.size(); i++) {
            Assert.assertTrue(languagesNameList.get(i).getText().toLowerCase().contains(LANGUAGE_NAME));
        }
    }

    @Test
    public void testIfTopListsReferenceOnTheFooterMenuRedirectsToTheTopListPage_WhenClickingOnIt() {
        String expectedResult = "https://www.99-bottles-of-beer.net/toplist.html";

        getDriver().get(BASE_URL);
        WebElement topListsOnTheFooter = getDriver().findElement(
                By.xpath("//div[@id='footer']/p/a[@href='/toplist.html']")
        );
        topListsOnTheFooter.click();

        String actualResult = getDriver().getCurrentUrl();

        Assert.assertEquals(actualResult,expectedResult);
    }

    @Test
    public void testIfToplistsFooterMenRedirectsToPageWithInformation_WhenClickingOnIt() {
        final int TOP_LANGUAGES_MINIMAL_QUANTITY = 2;
        getDriver().get(BASE_URL);
        WebElement topListsOnTheFooter = getDriver().findElement(
                By.xpath("//div[@id='footer']/p/a[@href='/toplist.html']")
        );
        topListsOnTheFooter.click();

        List <WebElement> topRatedLanguagesNames = getDriver().findElements(
                By.xpath("//table[@id='category']/tbody/tr/td[2]")
        );

        Assert.assertTrue(topRatedLanguagesNames.size()>0);

        Assert.assertTrue(topRatedLanguagesNames.size()>=TOP_LANGUAGES_MINIMAL_QUANTITY);

    }
}
