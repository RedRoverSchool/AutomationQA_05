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

        Assert.assertNotEquals(BASE_URL, getDriver().getCurrentUrl());

        click(TOP_ESOTERIC_SUBMENU, getDriver());

        Assert.assertNotEquals(oldUrl, getDriver().getCurrentUrl());

        String languageTopEsotoric = "";
        List <String > texListTopEsoteric = getElementsText(TOP_RATED_ESOTERIC_LANGUAGE, getDriver());
        if(texListTopEsoteric.size() > 0){
            for (String text : texListTopEsoteric) {
                languageTopEsotoric = texListTopEsoteric.get(0).toLowerCase();
            }
        }

        Assert.assertNotEquals(languageTopRatedReal, languageTopEsotoric);
    }

}
