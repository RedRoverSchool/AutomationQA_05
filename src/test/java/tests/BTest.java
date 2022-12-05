package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;

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
    public void testVerifyNavigationSymbolB() {
        final String symbol = "B";
        final String expectedResultTitle = "99 Bottles of Beer | Browse category B";
        final String expectedResultCurrentUrl = "https://www.99-bottles-of-beer.net/b.html";

        openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickOnSymdolOnSubmenu(symbol);

        Assert.assertEquals(getExternalPageTitle(), expectedResultTitle);
        Assert.assertEquals(getExternalPageURL(), expectedResultCurrentUrl);
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
    public void testCatagoryBDescription() {
        String expectedDescriptionText = "All languages starting with the letter B are shown, sorted by Language.";

        WebElement categoryDescriptionB =
                openBaseURL()
                        .clickBrowseLanguagesMenu()
                        .clickBSubmenu()
                        .getPageDescription();
        Assert.assertEquals(expectedDescriptionText, categoryDescriptionB.getText());
    }
}
