package tests.browse_languages.letters;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.browse_languages.languages.ZimLanguagePage;
import pages.browse_languages.letters.ZPage;

import java.util.List;

public class ZTest extends BaseTest {

    @Test
    public void testNamesOfLanguagesOnPageZStartWithZ() {
        String expectedFirstLetter = "z";

        List<String> listZLanguages = openBaseURL().clickBrowseLanguagesMenu().clickZSubmenuButton().getNames();

        Assert.assertTrue(listZLanguages.size() > 0);

        String actualFirstLetter = null;
        for (int i = 0; i < listZLanguages.size(); i++) {
            actualFirstLetter = String.valueOf(listZLanguages.get(i).charAt(0));
        }

        Assert.assertEquals(actualFirstLetter, expectedFirstLetter);
        Assert.assertTrue(listZLanguages.size() > 0);
    }

    @Test
    public void testZimLink_NavigatesTo_ZimLanguagePage() {
        final String expectedURL = "https://www.99-bottles-of-beer.net/language-zim-718.html";
        final String expectedTitle = "99 Bottles of Beer | Language Zim";

        ZimLanguagePage ZimLanguagePage = new ZimLanguagePage(getDriver());

        String oldURL = openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickZSubmenuButton()
                .getURL();

        new ZPage(getDriver()).clickZimLink();

        Assert.assertNotEquals(oldURL, getDriver().getCurrentUrl());

        String actualUrl = ZimLanguagePage.getURL();
        String actualTitle = ZimLanguagePage.getTitle();

        Assert.assertEquals(actualUrl, expectedURL);
        Assert.assertEquals(actualTitle, expectedTitle);
    }
}
