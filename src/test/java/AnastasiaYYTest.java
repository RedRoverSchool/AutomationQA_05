import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnastasiaYYTest extends BaseTest {

    final static String BASE_URL = "https://www.99-bottles-of-beer.net/";
    final static By START_MENU = By.xpath("//ul[@id = 'menu']//a[text() = 'Start']");
    final static By TOPLISTS_MENU = By.xpath("//ul[@id = 'menu']//a[text() = 'Top Lists']");
    final static By TEAM_SUBMENU = By.cssSelector("#submenu a[href = 'team.html']");

    private void openBaseURL() {
        getDriver().get(BASE_URL);
    }

    private List<String> WebElementToString(List<WebElement> elementList) {
        List<String> stringList = new ArrayList<>();
        for (WebElement element : elementList) {
            stringList.add(element.getText());
        }

        return stringList;
    }

    @Test
    public void testSearchForLanguageByName_HappyPath() {

        final String LANGUAGE_NAME = "python";

        openBaseURL();

        WebElement searchLanguagesMenu = getDriver().findElement(
                By.xpath("//ul[@id = 'menu']/li/a[@href = '/search.html']"));
        searchLanguagesMenu.click();

        WebElement searchForField = getDriver().findElement(By.name("search"));
        searchForField.click();
        searchForField.sendKeys(LANGUAGE_NAME);

        WebElement goButton = getDriver().findElement(By.name("submitsearch"));
        goButton.click();

        List<WebElement> languagesNamesList = getDriver().findElements(By.xpath("//table[@id = 'category']/tbody/tr/td[1]/a"));

        Assert.assertTrue(languagesNamesList.size() > 0);

        for (int i = 0; i < languagesNamesList.size(); i++) {
            Assert.assertTrue(languagesNamesList.get(i).getText().toLowerCase().contains(LANGUAGE_NAME));
        }
    }

    @Test
    public void testVerifyTextInHeaderH3() {
        List<String> expectedH3headerNames = new ArrayList<>(
                Arrays.asList("Oliver Schade", "Gregor Scheithauer", "Stefan Scheler"));

        openBaseURL();

        WebElement startMenu = getDriver().findElement(START_MENU);
        startMenu.click();

        WebElement teamSubMenu = getDriver().findElement(TEAM_SUBMENU);
        teamSubMenu.click();

        List<WebElement> h3HeaderNames = getDriver().findElements(By.xpath("//div[@id='main']/h3"));
        List<String> actualH3headerNames = WebElementToString(h3HeaderNames);

        Assert.assertEquals(actualH3headerNames, expectedH3headerNames);
    }

    @Test
    public void testVerifyH2HeaderText_TopListsMainPage()  {

        final String expectedResult = "Top Rated";

        openBaseURL();

        WebElement topListsMenu = getDriver().findElement(TOPLISTS_MENU);
        topListsMenu.click();

        WebElement h2HeaderTopLists = getDriver().findElement(By.xpath("//div[@id = 'main']/h2"));
        String actualResult = h2HeaderTopLists.getText();

        Assert.assertEquals(actualResult, expectedResult);
    }
}