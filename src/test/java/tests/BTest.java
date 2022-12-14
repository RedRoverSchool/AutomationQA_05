package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import pages.browse_languages.letters.BPage;

import java.util.List;

public class BTest extends BaseTest {

    private final String letter = "b";

    @Test
    public void testSortingLanguagesByLetterB() {
        List<String> listBLanguages =
                openBaseURL()
                        .clickBrowseLanguagesMenu()
                        .clickBSubmenu()
                        .getNamesInLowerCase();

        Assert.assertTrue(listBLanguages.size() > 0);

        for (String languageName : listBLanguages) {
            Assert.assertTrue(languageName.startsWith(letter));
        }
    }
    
    @Test
    public void testCatagoryWithLetterB() {

        String categoryBHeader =
                openBaseURL()
                        .clickBrowseLanguagesMenu()
                        .clickBSubmenu()
                        .getH2HeaderText();
        Assert.assertTrue(categoryBHeader.toLowerCase().endsWith(letter));
    }

    @Test
    public void testCategoryBDescription() {
        String expectedDescriptionText = "All languages starting with the letter B are shown, sorted by Language.";

        WebElement categoryDescriptionB =
                openBaseURL()
                        .clickBrowseLanguagesMenu()
                        .clickBSubmenu()
                        .getPageDescription();
        Assert.assertEquals(expectedDescriptionText, categoryDescriptionB.getText());
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
    public void testBPageAuthorMostCommentedLanguage() {
        final int expectedMaxComment = 12;
        final String expectedAuthor = "M. Eric Carr";

        BPage bPage = openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickBSubmenu();

        List<Integer> commentList = bPage
                .getColumnCommentList();

        int maxComment = bPage
                .getMaxList(commentList);

        Assert.assertEquals(maxComment, expectedMaxComment);

        int maxCommentIndex = bPage
                .clickBSubmenu()
                .getColumnCommentList()
                .indexOf(bPage
                        .getSortedList(commentList)
                        .get(commentList.size() - 1));

        String authorName = bPage
                .clickBSubmenu()
                .getColumnAuthorList()
                .get(maxCommentIndex);

        Assert.assertEquals(authorName, expectedAuthor);
    }
}
