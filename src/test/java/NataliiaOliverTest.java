import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NataliiaOliverTest extends BaseTest {

    final static String BASE_URL = "https://www.99-bottles-of-beer.net/";
    final static By START_MENU = By.xpath("//div[@id='navigation']//a[@href='/']");
    final static By SUBMENU_TEAM = By.xpath("//div[@id='navigation']//a[@href='team.html']");

    private List<String> WebElementToString(List<WebElement> elementList) {
        List<String> stringList = new ArrayList<>();
        for (WebElement element : elementList) {
            stringList.add(element.getText());
        }

        return stringList;
    }

    private List<WebElement> getTeamLinks() {

        return getDriver().findElements(By.xpath("//div[@id='main']/p/a"));
    }

    private List<String> getAllCreatorsLinks() {
        List<String> linksText = new ArrayList<>();
        for (WebElement element: getTeamLinks()) {
            linksText.add(element.getText());
        }

        return linksText;
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

        WebElement startMenu = getDriver().findElement(START_MENU);
        startMenu.click();

        WebElement teamSubmenu = getDriver().findElement(SUBMENU_TEAM);
        teamSubmenu.click();

        List<WebElement> creatorsNames = getDriver().findElements(
                By.xpath("//div[@id='main']/h3"));
        List<String> actualTeamNames = WebElementToString(creatorsNames);

        Assert.assertEquals(actualTeamNames, expectedTeamNames);
    }

    @Test
    public void testTeamLinks() {
        List<String> expectedCreatorsAllLinks = new ArrayList<>();
        expectedCreatorsAllLinks.add("ls-la.net");
        expectedCreatorsAllLinks.add("E-Taste.org");
        expectedCreatorsAllLinks.add("sts.synflood.de");

        getDriver().get(BASE_URL);

        WebElement startMenu = getDriver().findElement(START_MENU);
        startMenu.click();

        WebElement teamSubmenu = getDriver().findElement(SUBMENU_TEAM);
        teamSubmenu.click();

        List<String> actualCreatorsAllLinks = getAllCreatorsLinks();

        Assert.assertEquals(actualCreatorsAllLinks, expectedCreatorsAllLinks);
    }
}
