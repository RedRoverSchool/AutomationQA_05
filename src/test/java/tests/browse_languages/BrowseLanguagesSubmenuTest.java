package tests.browse_languages;

import TestData.TestData;
import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.browse_languages.BrowseLanguagesSubmenuPage;

import java.util.List;

public class BrowseLanguagesSubmenuTest extends BaseTest {

    @Test(priority = -4)
    public void testTextAndLinksSubmenu() {
        final List<String> expectedlettersSubmenu = List.of("0-9", "A", "B", "C", "D", "E", "F", "G", "H", "I"
                , "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z");

        BrowseLanguagesSubmenuPage browseLanguagesSubmenuPage = openBaseURL()
                .clickBrowseLanguagesMenu();

        List<String> actualSubmenusNames = browseLanguagesSubmenuPage.getSubmenusNames();

        Assert.assertEquals(actualSubmenusNames, expectedlettersSubmenu);
    }

    @Test(priority = -4, dependsOnMethods = "testTextAndLinksSubmenu",
            dataProvider = "lettersSubmenu", dataProviderClass = TestData.class)
    public void testLetterSubmenuNavigate(
            int index, String symbol, String url, String title) {

        BrowseLanguagesSubmenuPage browseLanguagesSubmenuPage = openBaseURL()
                .clickBrowseLanguagesMenu();

        List<WebElement> lettersList = browseLanguagesSubmenuPage.getSubmenus();

        String oldURL = browseLanguagesSubmenuPage.getURL();
        String oldTitle = browseLanguagesSubmenuPage.getTitle();
        String actualSymbol =  browseLanguagesSubmenuPage.getTextSymbol(index);
        String actualURLHref = browseLanguagesSubmenuPage.getHref(index);

        String actualURL = browseLanguagesSubmenuPage.clickMenu(index, lettersList).getURL();
        String actualTitle = browseLanguagesSubmenuPage.clickMenu(index, lettersList).getTitle();

        if (index != 1) {
            Assert.assertNotEquals(actualURL, oldURL);
            Assert.assertNotEquals(actualTitle, oldTitle);
        }

        Assert.assertEquals(actualSymbol, symbol);
        Assert.assertEquals(actualURLHref, url);
        Assert.assertEquals(actualURL, url);
        Assert.assertEquals(actualTitle, title);
    }
}
