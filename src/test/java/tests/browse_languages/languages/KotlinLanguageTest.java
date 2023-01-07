package tests.browse_languages.languages;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.browse_languages.languages.KotlinLanguagePage;

import java.util.List;

public class KotlinLanguageTest extends BaseTest {

    @Test
    public void testKotlinPageContent() {

        final String expectedH2HeaderLanguageKotlin = "Language Kotlin";
        final String expectedH2HeaderAlternativeVersions = "Alternative Versions";
        final String expectedH2HeaderComments = "Comments";

        final List<String> expectedNamesInTextTable = List.of("Date:", "Author:", "URL:", "Comments:", "Info:", "Score:");
        final List<String> expectedLinksDownload = List.of("Download Source", "Download Source");
        final List<String> expectedLinksAddComment = List.of("Write Comment", "Write Comment");
        final List<String> expectedH2HeaderTextVoting = List.of("Voting", "Category", "Bookmarking");

        KotlinLanguagePage kotlinLanguagePage = new KotlinLanguagePage(getDriver());

        openBaseURL().
                clickBrowseLanguagesMenu().
                clickKSubmenu().
                clickKotlinLanguage();

        String actualH2HeaderLanguageKotlin = kotlinLanguagePage.getH2HeaderText();
        String actualH2HeaderAlternativeVersions = kotlinLanguagePage.getAlternativeVersionsHeader();
        String actualH2HeaderComments = kotlinLanguagePage.getCommentsHeader();

        List<String> actualNamesInTextTable = kotlinLanguagePage.getLanguageInfoFields();
        List<String> actualLinksDownload = kotlinLanguagePage.getDownloadSourceLinks();
        List<String> actualLinksAddComment = kotlinLanguagePage.getWriteCommentLinksTexts();
        List<String> actualH2HeaderTextVoting = kotlinLanguagePage.getVotingHeader();

        Assert.assertEquals(actualH2HeaderLanguageKotlin, expectedH2HeaderLanguageKotlin);
        Assert.assertEquals(actualNamesInTextTable, expectedNamesInTextTable);
        Assert.assertEquals(actualLinksDownload, expectedLinksDownload);
        Assert.assertEquals(actualLinksAddComment, expectedLinksAddComment);
        Assert.assertEquals(actualH2HeaderAlternativeVersions, expectedH2HeaderAlternativeVersions);
        Assert.assertEquals(actualH2HeaderComments, expectedH2HeaderComments);
        Assert.assertEquals(actualH2HeaderTextVoting, expectedH2HeaderTextVoting);
    }
}
