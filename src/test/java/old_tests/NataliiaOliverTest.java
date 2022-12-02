package old_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NataliiaOliverTest extends BaseTest {

    final static By START_MENU = By.xpath("//div[@id='navigation']//a[@href='/']");
    final static By SUBMENU_TEAM = By.xpath("//div[@id='navigation']//a[@href='team.html']");

    private WebElement getStartMenu() {

        return getDriver().findElement(START_MENU);
    }

    private void clickStartMenu() {

        getStartMenu().click();
    }

    private WebElement getSubmenuTeam() {

        return getDriver().findElement(SUBMENU_TEAM);
    }

    private void clickSubmenuTeam() {

        getSubmenuTeam().click();
    }

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
    public void testTeamNames() {
        List<String> expectedTeamNames = new ArrayList<>(
                Arrays.asList("Oliver Schade", "Gregor Scheithauer", "Stefan Scheler"));

        openBaseURL();
        clickStartMenu();
        clickSubmenuTeam();

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

        openBaseURL();
        clickStartMenu();
        clickSubmenuTeam();

        List<String> actualCreatorsAllLinks = getAllCreatorsLinks();

        Assert.assertEquals(actualCreatorsAllLinks, expectedCreatorsAllLinks);
    }
}
