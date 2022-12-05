package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class KTest extends BaseTest {

    @Test
    public void testVerifyNavigationSymbolK() {
        final String symbol = "K";
        final String expectedResultTitle = "99 Bottles of Beer | Browse category K";
        final String expectedResultCurrentUrl = "https://www.99-bottles-of-beer.net/k.html";

        openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickOnSymdolOnSubmenu(symbol);

        Assert.assertEquals(getExternalPageTitle(), expectedResultTitle);
        Assert.assertEquals(getExternalPageURL(), expectedResultCurrentUrl);
    }

    @Test
    public void testAllLanguagesNamesOnKPageStartWithLetterK() {
        final String FIRST_LETTER = "K";

        List<String> languagesNamesInUpperCase = openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickKSubmenu()
                .getNamesInUpperCase();

        Assert.assertTrue(languagesNamesInUpperCase.size() > 0);

        for (String languageName : languagesNamesInUpperCase) {
            Assert.assertEquals(languageName.toUpperCase().substring(0, 1), FIRST_LETTER);
        }
    }
}
