package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TopListEsotericTest extends BaseTest {

    @Test
    public void testVerifyThe1stTopRatedRealLanguageIsDifferFromTopEsotericLanguage(){
        openBaseURL().clickTopListMenu().clickTopRatedRealSubmenuMenu().getFirstTextFromTopRatedRealListToLowerCase()

        click(TOP_RATED_REAL_SUBMENU, getDriver());

      //  Assert.assertNotEquals(BASE_URL, getDriver().getCurrentUrl());

      //  String oldUrl = getDriver().getCurrentUrl();
        String languageTopRatedReal = "";
        List<String> textListTopRatedReal = getElementsText(TOP_RATED_REAL_LANGUAGE_LIST, getDriver());

        if(textListTopRatedReal.size() > 0) {
            for (String text : textListTopRatedReal) {
                languageTopRatedReal = textListTopRatedReal.get(0).toLowerCase();
            }
        }

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
