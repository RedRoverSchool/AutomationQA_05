package tests.browse_languages.letters;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class MTest extends BaseTest {

    @Test
    public void testLanguagesNamesStartWithLetterM() {
        final String letterM = "m";

        List<String> listMLanguages =
                openBaseURL()
                        .clickBrowseLanguagesMenu()
                        .clickMSubmenu()
                        .getNamesInLowerCase();

        Assert.assertTrue(listMLanguages.size() > 0);

        for (String languageName : listMLanguages) {
            Assert.assertTrue(languageName.contains(letterM));
        }
    }
}
