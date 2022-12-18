package tests.browse_languages.letters;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.browse_languages.languages.BashLanguagePage;
import pages.browse_languages.letters.BPage;

import java.util.List;

public class BTest extends BaseTest {

    @Test
    public void testLanguagesNamesStartWithLetterB() {
        final String letterB = "b";

        List<String> listBLanguages =
                openBaseURL()
                        .clickBrowseLanguagesMenu()
                        .clickBSubmenu()
                        .getNamesInLowerCase();

        Assert.assertTrue(listBLanguages.size() > 0);

        for (String languageName : listBLanguages) {
            Assert.assertTrue(languageName.startsWith(letterB));
        }
    }

    @Test
    public void testLanguagesDescription() {
        final String expectedDescription = "All languages starting with the letter B " +
                "are shown, sorted by Language.";

        String actualDescription =
                openBaseURL()
                        .clickBrowseLanguagesMenu()
                        .clickBSubmenu()
                        .getPageDescription();

        Assert.assertEquals(actualDescription, expectedDescription);
    }

    @Test
    public void testH2Header() {

        final String expectedH2Header = "Category B";

        String actualH2Header = openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickBSubmenu()
                .getH2HeaderText();

        Assert.assertEquals(actualH2Header, expectedH2Header);
    }

    @Test
    public void testLanguageAndAuthorName_ForMostCommentedLanguage() {
        final String expectedLanguage = "BASIC";
        final String expectedAuthor = "M. Eric Carr";

        BPage bPage = new BPage(getDriver());

        List<String> comments = openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickBSubmenu()
                .getComments();

        int maxCount = bPage.getMaxCount(comments);
        int maxCountIndex = bPage.getIndexForMaxCount(comments, maxCount);
        String actualLanguageName = bPage.getNames().get(maxCountIndex);
        String actualAuthor = bPage.getAuthors().get(maxCountIndex);

        Assert.assertEquals(actualLanguageName, expectedLanguage);
        Assert.assertEquals(actualAuthor, expectedAuthor);
    }

    @Test
    public void testNavigatesWithFooterMenuChoosingLanguageBASH() {
        final String expectedLanguageURL = "https://www.99-bottles-of-beer.net/language-bash-1815.html";
        final String expectedLanguageTitle = "99 Bottles of Beer | Language BASH";

        BashLanguagePage bashLanguagePage = openBaseURL()
                .clickBrowseLanguagesFooterMenu()
                .clickBSubmenu()
                .clickBashLanguage();

        Assert.assertEquals(bashLanguagePage.getURL(), expectedLanguageURL);
        Assert.assertEquals(bashLanguagePage.getTitle(), expectedLanguageTitle);
    }
}
