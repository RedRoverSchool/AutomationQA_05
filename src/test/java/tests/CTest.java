package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

public class CTest extends BaseTest {
    @Test
    public void testABCNavigationSubmenuClickLetterC() {
        String expectedFirstLetter = "C";

        List<String> languagesNamesInUpperCase = openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickCSubmenu()
                .getNamesInUpperCase();

        Assert.assertTrue(languagesNamesInUpperCase.size() > 0);

        for (String languageName : languagesNamesInUpperCase) {
            Assert.assertEquals(
                    languageName.toUpperCase().substring(0, 1), expectedFirstLetter
            );
        }
    }

    @Test
    public void testVerifyNavigationSymbolC() {
        final String symbol = "C";
        final String expectedResultTitle = "99 Bottles of Beer | Browse category C";
        final String expectedResultCurrentUrl = "https://www.99-bottles-of-beer.net/c.html";

        openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickOnSymdolOnSubmenu(symbol);

        Assert.assertEquals(getExternalPageTitle(), expectedResultTitle);
        Assert.assertEquals(getExternalPageURL(), expectedResultCurrentUrl);
    }
}
