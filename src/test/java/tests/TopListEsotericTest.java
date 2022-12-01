package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TopListEsotericTest extends BaseTest {

    @Test
    public void testVerifyThe1stTopRatedRealLanguageIsDifferFromTopEsotericLanguage(){
        String topRatedRealLanguagesFirstLanguage = openBaseURL()
                .clickTopListMenu()
                .clickTopRatedRealSubmenuMenu()
                .getFirstTextFromTopRatedRealListToLowerCase();

        String topRatedEsotericLanguagesFirstLanguage = openBaseURL()
                .clickTopListMenu()
                .clickTopRatedEsotericSubmenuMenu()
                .getFirstTextFromTopRatedEsotericListToLowerCase();

        Assert.assertNotEquals(topRatedRealLanguagesFirstLanguage, topRatedEsotericLanguagesFirstLanguage);
    }

}
