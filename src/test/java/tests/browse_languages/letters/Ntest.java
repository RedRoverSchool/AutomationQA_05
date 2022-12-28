package tests.browse_languages.letters;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.browse_languages.letters.ABCPage;
import pages.browse_languages.letters.NPage;

public class Ntest extends BaseTest {

    @Test
    public void testNSubmenu_NavigationTo_NPage() {
        final String expectedURL = "https://www.99-bottles-of-beer.net/n.html";
        final String expectedTitle = "99 Bottles of Beer | Browse category N";

        ABCPage abcPage = new ABCPage(getDriver());
        NPage nPage = new NPage(getDriver());

        String oldURL = openBaseURL()
                .clickBrowseLanguagesMenu()
                .getURL();

        String actualURL = abcPage.clickNSubmenu().getURL();
        String actualTitle = nPage.getTitle();

        Assert.assertNotEquals(oldURL, actualURL);
        Assert.assertEquals(actualURL, expectedURL);
        Assert.assertEquals(actualTitle, expectedTitle);
    }
}
