package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class DTest extends BaseTest {
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
