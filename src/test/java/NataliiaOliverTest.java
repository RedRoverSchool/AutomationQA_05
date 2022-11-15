import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NataliiaOliverTest extends BaseTest {

    static final String BASE_URL = "https://www.99-bottles-of-beer.net/";

    public static List<String> WebElementToString(List<WebElement> elementList) {
        List<String> stringList = new ArrayList<>();
        for (WebElement element : elementList) {
            stringList.add(element.getText());
        }

        return stringList;
    }

    @Test
    public void testSearchForLanguageByName_HappyPath() {
        final String LANGUAGE_NAME = "python";

        getDriver().get(BASE_URL);

        WebElement searchLanguagesMenu = getDriver().findElement(
                By.xpath("//ul[@id='menu']/li/a[@href='/search.html']"));
        searchLanguagesMenu.click();

        WebElement searchForField = getDriver().findElement(By.name("search"));
        searchForField.click();
        searchForField.sendKeys(LANGUAGE_NAME);

        WebElement goButton = getDriver().findElement(By.name("submitsearch"));
        goButton.click();

        List<WebElement> languageNamesList = getDriver().findElements(
                By.xpath("//table[@id='category']/tbody/tr/td[1]/a"));

        Assert.assertTrue(languageNamesList.size() > 0);

        for (int i = 0; i < languageNamesList.size(); i++) {
            Assert.assertTrue(languageNamesList.get(i).getText().toLowerCase().contains(LANGUAGE_NAME));
        }
    }

    @Test
    public void testTeamNames() {
        List<String> expectedTeamNames = new ArrayList<>(
                Arrays.asList("Oliver Schade", "Gregor Scheithauer", "Stefan Scheler"));

        getDriver().get(BASE_URL);

        WebElement startMenu = getDriver().findElement(By.xpath("//div[@id='navigation']//a[@href='/']"));
        startMenu.click();

        WebElement teamSubmenu = getDriver().findElement(By.xpath("//div[@id='navigation']//a[@href='team.html']"));
        teamSubmenu.click();

        List<WebElement> creatorsNames = getDriver().findElements(
                By.xpath("//div[@id='main']/h3"));
        List<String> actualTeamNames = WebElementToString(creatorsNames);

        Assert.assertEquals(actualTeamNames, expectedTeamNames);
    }
}
