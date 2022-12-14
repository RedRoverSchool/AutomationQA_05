package tests.browse_languages.letters;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.browse_languages.letters.BPage;
import pages.browse_languages.letters.FPage;

import java.util.List;

public class FTest extends BaseTest {

    @Test
    public void testLanguageAndAuthorName_ForMostCommentedLanguage() {
        final String expectedLanguage = "Falcon";
        final String expectedAuthor = "Jessie Finley";

        FPage fPage = new FPage(getDriver());

        List<String> comments = openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickBSubmenu()
                .getComments();

        int maxCount = fPage.getMaxCount(comments);
        int maxCountIndex = fPage.getIndexForMaxCount(comments, maxCount);
        String actualLanguageName = fPage.getNames().get(maxCountIndex);
        String actualAuthor = fPage.getAuthors().get(maxCountIndex);

        Assert.assertEquals(actualLanguageName, expectedLanguage);
        Assert.assertEquals(actualAuthor, expectedAuthor);
    }

}
