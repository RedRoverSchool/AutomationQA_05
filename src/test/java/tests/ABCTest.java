package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import pages.browse_languages.letters.ABCPage;

import java.util.List;


public class ABCTest extends BaseTest {

    @Test
    public void test_ABCLetterCategoryLanguagesColumInformation() throws InterruptedException {

        List<WebElement> submenuLetters =
                 openBaseURL()
                        .clickBrowseLanguagesMenu()
                        .getSubmenuLettersElement();

        ABCPage abcPage = new ABCPage(getDriver());

        List<String> availableLetters =
                abcPage.getSubmenuNamesInLowerCase();

        for(int i = 0; i < availableLetters.size(); i++) {
            submenuLetters.get(i).click();
            List<String> firstLetters = abcPage.getFirstsLetterFromLanguagesNames();
            if (i == 0) {
                for (String letter : firstLetters) {
                    char symbol = letter.charAt(0);
                    Assert.assertTrue(symbol >= 48 && symbol <= 57);
                }
            }
            else {
                for (String letter : firstLetters) {
                    Assert.assertEquals(letter, availableLetters.get(i));
                }
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
