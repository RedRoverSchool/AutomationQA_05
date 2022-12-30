package tests.browse_languages;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.browse_languages.letters.ABCPage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ABCTest extends BaseTest {

    @Test
    public void test_LanguagesNamesStartWithCorrespondingLetter() {

        ABCPage abcPage = new ABCPage(getDriver());

        List<WebElement> lettersSubmenus =
                openBaseURL()
                        .clickBrowseLanguagesMenu()
                        .getSubmenus();

        List<String> submenusNames = abcPage.getSubmenusNames();

        for (int i = 0; i < lettersSubmenus.size(); i++) {
            lettersSubmenus.get(i).click();
            List<String> firstLetters = abcPage.getFirstLettersFromLanguagesNames();
            if (i == 0) {
                for (String letter : firstLetters) {
                    char symbol = letter.charAt(0);
                    Assert.assertTrue(symbol >= 48 && symbol <= 57);
                }
            } else {
                for (String letter : firstLetters) {
                    Assert.assertEquals(letter, submenusNames.get(i));
                }
            }
        }
    }

    @Test
    public void testABCPageURL() {
        final String expectedURL = "https://www.99-bottles-of-beer.net/abc.html";

        String actualPageURL =
                openBaseURL()
                        .clickBrowseLanguagesMenu()
                        .getURL();

        Assert.assertEquals(actualPageURL, expectedURL);
    }

    @Test
    public void testDefaultHeaderForABCPage() {
        final String expectedH2Header = "Category A";

        String actualH2Header = openBaseURL()
                .clickBrowseLanguagesMenu()
                .getH2HeaderText();

        Assert.assertEquals(actualH2Header, expectedH2Header);
    }

    @Test
    public void testTableHeaderNames() {
        final List<String> expectedHeaderNames = new ArrayList<>(
                Arrays.asList("Language", "Author", "Date", "Comments", "Rate"));

        List<String> actualHeaderNames =
                openBaseURL()
                        .clickBrowseLanguagesMenu()
                        .clickYSubmenu()
                        .getTableHeaders();

        Assert.assertEquals(actualHeaderNames, expectedHeaderNames);
    }

}
