package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class YTest extends BaseTest {

    @Test
    public void testAllLanguagesOnYPageStartWithLetterY()  {
        final String letterY = "y";

        List<String> listYLanguages =
                openBaseURL()
                        .clickBrowseLanguagesMenu()
                        .clickYSubmenu()
                        .getYLanguagesNames();

        Assert.assertTrue(listYLanguages.size() > 0);

        for (String languageName: listYLanguages) {
            Assert.assertTrue(languageName.contains(letterY));
        }
    }

    @Test
    public void testVerifyNumberOfLanguagesOnPageY()  {
        final int expectedResult = 9;
        int count = 0;

        List<String> listYLanguages =
                openBaseURL()
                        .clickBrowseLanguagesMenu()
                        .clickYSubmenu()
                        .getYLanguagesNames();

        for (String languageName : listYLanguages) {
           if ((listYLanguages.size() > 0 && languageName.charAt(0) == 'y')) {
               count++;
           }
        }

        int actualResult = count;

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testVerifyNavigationSymbolY() {
        final String symbol = "Y";
        final String expectedResultTitle = "99 Bottles of Beer | Browse category Y";
        final String expectedResultCurrentUrl = "https://www.99-bottles-of-beer.net/y.html";

        openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickOnSymdolOnSubmenu(symbol);

        Assert.assertEquals(getExternalPageTitle(), expectedResultTitle);
        Assert.assertEquals(getExternalPageURL(), expectedResultCurrentUrl);
    }
}
