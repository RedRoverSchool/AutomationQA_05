package tests;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class BTest extends BaseTest {

    private final String letter = "b";

    @Test
    public void testSortingLanguagesByLetterB() {
        List<String> listBLanguages =
                openBaseURL()
                        .clickBrowseLanguagesMenu()
                        .clickBSubmenu()
                        .getBLanguagesNames();

        Assert.assertTrue(listBLanguages.size() > 0);

        for (String languageName : listBLanguages) {
            Assert.assertTrue(languageName.startsWith(letter));
        }
    }

    @Test
    public void testCatagoryWithLetterB() {

        WebElement categoryBTitle =
                openBaseURL()
                        .clickBrowseLanguagesMenu()
                        .clickBSubmenu()
                        .getbCatagoryTitle();
        Assert.assertTrue(categoryBTitle.getText().toLowerCase().endsWith(letter));
    }

    @Test
    public void testCatagoryBDescription() {
        String expectedDescriptionText = "All languages starting with the letter B are shown, sorted by Language.";

        WebElement categoryDescriptionB =
                openBaseURL()
                        .clickBrowseLanguagesMenu()
                        .clickBSubmenu()
                        .getbCatagoryDescription();
        Assert.assertEquals(expectedDescriptionText, categoryDescriptionB.getText());
    }
}
