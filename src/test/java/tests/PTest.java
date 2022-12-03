package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PTest extends BaseTest {

    @Test
    public void testVerifyNavigationSymbolP() {
        final String symbol = "P";
        final String expectedResultTitle = "99 Bottles of Beer | Browse category P";
        final String expectedResultCurrentUrl = "https://www.99-bottles-of-beer.net/p.html";

        openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickOnSymdolOnSubmenu(symbol);

        Assert.assertEquals(getExternalPageTitle(), expectedResultTitle);
        Assert.assertEquals(getExternalPageURL(), expectedResultCurrentUrl);
    }
    
    @Test
    public void testPLanguagesSortedAssending() {

        List<String> pLanguagesNames = openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickPSubmenu()
                .getPLanguagesNames();

        List<String> displayedLanguages = new ArrayList<String>();
        List<String> sortedLanguages = new ArrayList<String>();

        Assert.assertTrue(pLanguagesNames.size() > 0);
        List<String> textList = new ArrayList<>();
        List<String> textList1 = new ArrayList<>();

        for (String pLanguage : pLanguagesNames) {
            textList.add(pLanguage.toLowerCase());
            textList1.add(pLanguage.toLowerCase());
        }
        Collections.sort(textList1);

        Assert.assertEquals(displayedLanguages, sortedLanguages);
    }
}
