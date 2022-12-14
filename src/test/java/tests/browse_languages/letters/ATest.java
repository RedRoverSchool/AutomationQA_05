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

        List<String> comments = openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickASubmenu()
                .getCommentsTexts();

        int maxCount = aPage.getMaxCount(comments);
        int maxCountIndex = aPage.getIndexForMaxCount(comments, maxCount);
        String languageName = aPage.getNames().get(maxCountIndex);

        Assert.assertEquals(maxCount, expectedMaxCount);
        Assert.assertEquals(languageName, expectedLanguage);
    }
}
