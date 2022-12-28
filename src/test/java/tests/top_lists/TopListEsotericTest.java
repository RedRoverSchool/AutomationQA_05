package tests.top_lists;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.top_lists.TopRatedEsotericPage;


public class TopListEsotericTest extends BaseTest {

    @Test
    public void testTheMostRatedRealLanguageIsDifferFromMostRatedEsotericLanguage() {
        String topRatedRealLanguagesFirstLanguage = openBaseURL()
                .clickTopListsMenu()
                .clickTopRatedRealSubmenu()
                .getMostRatedRealLanguage();

        TopRatedEsotericPage topRatedEsotericPage = new TopRatedEsotericPage(getDriver());

        String theMostRatedEsotericLanguage = topRatedEsotericPage
                .clickTopRatedEsotericSubmenu()
                .getMostRatedEsotericLanguage();

        Assert.assertNotEquals(topRatedRealLanguagesFirstLanguage, theMostRatedEsotericLanguage);
    }
}
