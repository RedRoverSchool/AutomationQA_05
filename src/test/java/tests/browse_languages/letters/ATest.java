package tests.browse_languages.letters;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.browse_languages.letters.APage;

import java.util.List;

public class ATest extends BaseTest {

    @Test
    public void testAPageMostCommentedLanguage() {
        final int expectedMaxComment = 12;
        final String expectedLanguage = "Assembler (6510)";

        APage aPage = openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickASubmenu();

        int maxComment = aPage.getCommentWithMaxCount();

        Assert.assertEquals(maxComment, expectedMaxComment);

        int maxCommentIndex = aPage
                .clickASubmenu()
                .getComments()
                .indexOf(aPage.getCommentWithMaxCount());

        String languageName = aPage
                .clickASubmenu()
                .getNames()
                .get(maxCommentIndex);

        Assert.assertEquals(languageName, expectedLanguage);
    }
}
