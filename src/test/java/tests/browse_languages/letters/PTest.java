package tests.browse_languages.letters;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PTest extends BaseTest {

    @Test
    public void testPLanguagesNamesSortedAscending() {
        List<String> pLanguagesNames = openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickPSubmenu()
                .getNamesInLowerCase();

        Assert.assertTrue(pLanguagesNames.size() > 0);

        List<String> displayedLanguages = new ArrayList<>();
        displayedLanguages.addAll(pLanguagesNames);

        Collections.sort(pLanguagesNames);

        Assert.assertEquals(displayedLanguages, pLanguagesNames);
    }
}
