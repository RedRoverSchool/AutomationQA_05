package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class KTest extends BaseTest {

    @Test
    public void testAllLanguagesNamesOnKPageStartWithLetterK() {
        final String FIRST_LETTER = "K";

        List<String> languagesNamesInUpperCase = openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickKSubmenu()
                .getNamesInUpperCase();

        Assert.assertTrue(languagesNamesInUpperCase.size() > 0);

        for (String languageName : languagesNamesInUpperCase) {
            Assert.assertEquals(languageName.toUpperCase().substring(0, 1), FIRST_LETTER);
        }
    }
}
