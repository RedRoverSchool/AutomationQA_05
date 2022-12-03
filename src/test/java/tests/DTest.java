package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class DTest extends BaseTest {

    @Test
    public void testVerifyNavigationSymbolD() {
        final String symbol = "D";
        final String expectedResultTitle = "99 Bottles of Beer | Browse category D";
        final String expectedResultCurrentUrl = "https://www.99-bottles-of-beer.net/d.html";

        openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickOnSymdolOnSubmenu(symbol);

        Assert.assertEquals(getExternalPageTitle(), expectedResultTitle);
        Assert.assertEquals(getExternalPageURL(), expectedResultCurrentUrl);
}

    @Test
    public void testABCNavigationSubmenuLetterD_languagesNamesStartFromLetterD(){
        String expectedLetter = "D";
        List<String> languagesNamesList = openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickDSubmenu()
                .getDLanguagesNames();
        Assert.assertTrue(languagesNamesList.size() > 0);
        for(String languageName:languagesNamesList){
            Assert.assertEquals(languageName.substring(0, 1),expectedLetter);
        }
    }
}
