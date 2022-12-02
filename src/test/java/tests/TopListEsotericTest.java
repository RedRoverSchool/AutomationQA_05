package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TopListEsotericPage;

import java.util.List;

public class TopListEsotericTest extends BaseTest {

    @Test
    public void testTheMostRatedRealLanguageIsDifferFromMostRatedEsotericLanguage() {
        String topRatedRealLanguagesFirstLanguage = openBaseURL()
                .clickTopListMenu()
                .clickTopRatedRealSubmenu()
                .getMostRatedRealLanguage();
        TopListEsotericPage topListEsotericPage = new TopListEsotericPage(getDriver());

        String theMostRatedEsotericLanguage = topListEsotericPage
                .clickTopRatedEsotericSubmenu()
                .getMostRatedEsotericLanguage();

        Assert.assertNotEquals(topRatedRealLanguagesFirstLanguage, theMostRatedEsotericLanguage );
    }
}
