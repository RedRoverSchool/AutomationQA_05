package tests.browse_languages.letters;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.browse_languages.letters.APage;

import java.util.List;

public class ATest extends BaseTest {

    @Test
    public void testMostCommentedLanguageOnAPage() {
        final int expectedMaxCount = 12;
        final String expectedLanguage = "Assembler (6510)";

        APage aPage = new APage(getDriver());

        List<WebElement> comments = openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickASubmenu()
                .getComments();

        int maxCount = aPage.getCommentWithMaxCount();

        Assert.assertEquals(maxCount, expectedMaxCount);

        int maxCountIndex = comments.indexOf(maxCount);

        String languageName = aPage
                .clickASubmenu()
                .getNames()
                .get(maxCommentIndex);

        Assert.assertEquals(languageName, expectedLanguage);
    }
}
