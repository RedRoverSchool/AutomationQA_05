package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ZTest extends BaseTest {

    @Test
    public void testNamesOfLanguagesOnPageZStartWithZ() {
        String expectedFirstLetter = "z";

        List<String> listZLanguages = openBaseURL().clickBrowseLanguagesMenu().clickZSubmenuButton().getZLanguagesNames();

        Assert.assertTrue(listZLanguages.size() > 0);

        String actualFirstLetter = null;
        for (int i = 0; i < listZLanguages.size(); i++) {
            actualFirstLetter = String.valueOf(listZLanguages.get(i).charAt(0));
        }

        Assert.assertEquals(actualFirstLetter, expectedFirstLetter);
        Assert.assertTrue(listZLanguages.size() > 0);
    }

    @Test
    public void testVerifyNavigationSymbolZ() {
        final String symbol = "Z";
        final String expectedResultTitle = "99 Bottles of Beer | Browse category Z";
        final String expectedResultCurrentUrl = "https://www.99-bottles-of-beer.net/z.html";

        openBaseURL().clickBrowseLanguagesMenu().clickOnSymdolOnSubmenu(symbol);

        Assert.assertEquals(getExternalPageTitle(), expectedResultTitle);
        Assert.assertEquals(getExternalPageURL(), expectedResultCurrentUrl);
    }
}
