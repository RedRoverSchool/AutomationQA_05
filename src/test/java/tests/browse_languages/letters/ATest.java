package tests.browse_languages.letters;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.browse_languages.languages.AdaLanguagePage;
import pages.browse_languages.languages.LanguagePage;
import pages.browse_languages.letters.APage;

import java.util.Arrays;
import java.util.List;

public class ATest extends BaseTest {

    @Test
    public void testMostCommentedLanguageOnAPage() {
        final int expectedMaxCount = 12;
        final String expectedLanguage = "Assembler (6510)";

        APage aPage = new APage(getDriver());

        List<String> comments = openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickASubmenu()
                .getComments();

        int maxCount = aPage.getMaxCount(comments);
        int maxCountIndex = aPage.getIndexForMaxCount(comments, maxCount);
        String languageName = aPage.getNames().get(maxCountIndex);

        Assert.assertEquals(maxCount, expectedMaxCount);
        Assert.assertEquals(languageName, expectedLanguage);
    }

    @Test
    public void testAdaLanguageLink_NavigatesTo_AdaLanguagePage() {
        final String expectedURL = "https://www.99-bottles-of-beer.net/language-ada-19.html";
        final String expectedTitle = "99 Bottles of Beer | Language Ada";

        APage aPage = new APage(getDriver());
        AdaLanguagePage adaLanguagePage = new AdaLanguagePage(getDriver());

        String oldURL = openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickASubmenu()
                .getURL();

        String newURL = aPage.clickAdaLanguage().getURL();
        String actualTitle = adaLanguagePage.getTitle();

        Assert.assertNotEquals(oldURL, newURL);
        Assert.assertEquals(adaLanguagePage.getURL(), newURL);
        Assert.assertEquals(adaLanguagePage.getTitle(), actualTitle);
    }


    @Test
    public void testABCPagesLanguagesNameAndInformationColumn() {

        final List<String> expectedInfoColumn = Arrays.asList("Date:", "Author:", "URL:", "Comments:", "Info:", "Score:");
        APage apage = new APage(getDriver());

        List<WebElement> languagesSubmenus =
                openBaseURL()
                        .clickBrowseLanguagesMenu()
                        .clickASubmenu()
                        .getLanguagesLinks();
        List<String> submenusNames = apage.getNames();

        for (int i = 0; i < languagesSubmenus.size(); i++) {
            languagesSubmenus.get(i).click();
            String actualH2Header = apage.getH2HeaderText();
            String expectedH2Header = "Language " + submenusNames.get(i);
            List<String> actualInfoColumn = apage.languageInfoDates();
            apage.clickASubmenu();

            Assert.assertEquals(actualInfoColumn, expectedInfoColumn);
            Assert.assertEquals(actualH2Header, expectedH2Header);
        }
    }
}
