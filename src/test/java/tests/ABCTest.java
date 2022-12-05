package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import pages.browse_languages.letters.ABCPage;

import java.util.List;


public class ABCTest extends BaseTest {

    @Test
    public void test_ABCVerifyByLetterCategoryInformation() throws InterruptedException {

        List<WebElement> submenuLetters =
                openBaseURL()
                        .clickBrowseLanguagesMenu()
                        .getSubmenuLettersElement();

        List<String> culumlanguagesNames =
                openBaseURL()
                        .clickBrowseLanguagesMenu()
                        .getSubmenuLettersLowerCase();

        for(int i = 1; i < submenuLetters.size(); i++) {
            List<String> languages =
                    openBaseURL()
                            .clickBrowseLanguagesMenu()
                            .getColumLanguageList(submenuLetters.get(i));

            for (String language : languages) {
                Assert.assertEquals(String.valueOf(language.charAt(0)), culumlanguagesNames.get(i));
            }
        }
    }

    @Test
    public void testABCPageURL() {
        String expectedURL = "https://www.99-bottles-of-beer.net/abc.html";

        String actualPageURL =
                openBaseURL()
                        .clickBrowseLanguagesMenu()
                        .getURL();
        Assert.assertEquals(actualPageURL, expectedURL);
    } 
    
    @Test
    public void testDefaultHeaderForABCPage() {
        String expectedH2Header = "Category A";

        String actualH2Header = openBaseURL()
                .clickBrowseLanguagesMenu()
                .getH2HeaderText();

        Assert.assertEquals(actualH2Header, expectedH2Header);
    }

    @Test
    public void testTextABC() {
        final String expectedResult = "Category A";

        openBaseURL().clickBrowseLanguagesMenu();
        ABCPage abcPage = new ABCPage(getDriver());
        String actualResult = abcPage.getH2HeaderText();

        Assert.assertEquals(actualResult, expectedResult);
    }
}
