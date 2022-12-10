package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.browse_languages.languages.KotlinLanguagePage;

import java.util.List;

public class KotlinLanguageTest extends BTest {

    @Test
    public void testKotlinPageContent() {
        final String expectedH2HeaderLanguageKotlin = "Language Kotlin";
        List<String> expectedNamesInTextTable = List.of("Date:", "Author:", "URL:", "Comments:", "Info:", "Score:");
        List<String> expectedlinksDownload = List.of("Download Source", "Download Source");
        List<String> expectedlinksAddComment = List.of("Write Comment", "Write Comment");
        final String expectedH2HeaderAlternativeVersions = "Alternative Versions";
        final String expectedH2HeaderComments = "Comments";
        List<String> expectedH2HeaderTextVoting = List.of("Voting", "Category", "Bookmarking");

        KotlinLanguagePage kotlinLanguagePage = new KotlinLanguagePage(getDriver());

        openBaseURL().
                clickBrowseLanguagesMenu().
                clickKSubmenu().
                clickKotlinLink();

        String actualH2HeaderLanguageKotlin = kotlinLanguagePage.getH2HeaderTextLanguageKotlin();
        List<String> actualNamesInTextTable = kotlinLanguagePage.getNamesInTextTable();
        List<String> actuallinksDownload = kotlinLanguagePage.getTextlinksDownload();
        List<String> actuallinksAddComment = kotlinLanguagePage.getTextlinksAddComment();
        String actualH2HeaderAlternativeVersions = kotlinLanguagePage.getH2HeaderTextAlternativeVersions();
        String actualH2HeaderComments = kotlinLanguagePage.getH2HeaderTextComments();
        List<String> actualH2HeaderTextVoting = kotlinLanguagePage.getH2HeaderTextVoting();

        Assert.assertEquals(actualH2HeaderLanguageKotlin, expectedH2HeaderLanguageKotlin);
        Assert.assertEquals(actualNamesInTextTable, expectedNamesInTextTable);
        Assert.assertEquals(actuallinksDownload, expectedlinksDownload);
        Assert.assertEquals(actuallinksAddComment, expectedlinksAddComment);
        Assert.assertEquals(actualH2HeaderAlternativeVersions, expectedH2HeaderAlternativeVersions);
        Assert.assertEquals(actualH2HeaderComments, expectedH2HeaderComments);
        Assert.assertEquals(actualH2HeaderTextVoting, expectedH2HeaderTextVoting);
    }
}
