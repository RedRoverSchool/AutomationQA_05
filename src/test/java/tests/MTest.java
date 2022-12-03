package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class MTest extends BaseTest {

    @Test
    public void testSortLanguagesByLetterM() {
        final String letterM = "m";

        List<String> listMLanguages =
                openBaseURL()
                        .clickBrowseLanguagesMenu()
                        .clickMSubmenu()
                        .getMLanguagesNames();

        Assert.assertTrue(listMLanguages.size() > 0);

        for (String languageName : listMLanguages) {
            Assert.assertTrue(languageName.contains(letterM));
        }
    }
}
