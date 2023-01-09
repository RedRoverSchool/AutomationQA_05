package tests.browse_languages;

import testData.TestData;
import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.browse_languages.letters.ABCPage;

import java.util.List;

public class BrowseLanguagesSubmenuTest extends BaseTest {

    @Test(priority = -4)
    public void testTextAndLinksSubmenu() {
        final List<String> expectedLettersSubmenu = List.of("0-9", "A", "B", "C", "D", "E", "F", "G", "H", "I"
                , "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z");

        ABCPage abcPage = openBaseURL()
                .clickBrowseLanguagesMenu();

        List<String> actualSubmenusNames = abcPage.getSubmenusNames();

        Assert.assertEquals(actualSubmenusNames, expectedLettersSubmenu);
    }

    @Test(priority = -4, dependsOnMethods = "testTextAndLinksSubmenu",
            dataProvider = "lettersSubmenu", dataProviderClass = TestData.class)
    public void testLetterSubmenuNavigate(
            int index, String symbol, String url, String title) {

        ABCPage abcPage = openBaseURL()
                .clickBrowseLanguagesMenu();

        List<WebElement> lettersList = abcPage.getSubmenus();

        String oldURL = abcPage.getURL();
        String oldTitle = abcPage.getTitle();
        String actualSymbol = abcPage.getTextSymbol(index);
        String actualURLHref = abcPage.getHref(index);

        String actualURL = abcPage.clickMenu(index, lettersList).getURL();
        String actualTitle = abcPage.clickMenu(index, lettersList).getTitle();

        if (index != 1) {
            Assert.assertNotEquals(actualURL, oldURL);
            Assert.assertNotEquals(actualTitle, oldTitle);
        }

        Assert.assertEquals(actualSymbol, symbol);
        Assert.assertEquals(actualURLHref, url);
        Assert.assertEquals(actualURL, url);
        Assert.assertEquals(actualTitle, title);
    }

    @Test(dependsOnMethods = "testTextAndLinksSubmenu",
            dataProviderClass = TestData.class, dataProvider = "lettersSubmenu")
    public void testFooterLetterSubmenusNavigateToCorrespondingPages(
            int index, String symbol, String url, String title) {

        ABCPage abcPage = openBaseURL().clickBrowseLanguagesFooterMenu();

        List<WebElement> lettersList = abcPage.getSubmenus();

        String oldURL = abcPage.getURL();
        String oldTitle = abcPage.getTitle();
        String actualSymbol = abcPage.getTextSymbol(index);

        String actualUrl = abcPage.clickMenu(index, lettersList).getURL();
        String actualTitle = abcPage.clickMenu(index, lettersList).getTitle();

        if (index != 1) {
            Assert.assertNotEquals(actualUrl, oldURL);
            Assert.assertNotEquals(actualTitle, oldTitle);
        }
        Assert.assertEquals(actualUrl, url);
        Assert.assertEquals(actualTitle, title);
        Assert.assertEquals(actualSymbol, symbol);
    }
}
