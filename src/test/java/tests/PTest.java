package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PTest extends BaseTest {

    @Test
    public void testBrowseLanguagesLanguagesSortedAscending_HappyPath() {

        List<String> pLanguagesNames = openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickPSubmenu()
                .getPLanguagesNames();

        List<String> displayed = new ArrayList<String>();
        List<String> sorted = new ArrayList<String>();

        Assert.assertTrue(pLanguagesNames.size() > 0);
        List<String> textList = new ArrayList<>();
        List<String> textList1 = new ArrayList<>();

        for (String pLanguage : pLanguagesNames) {
            textList.add(pLanguage.toLowerCase());
            textList1.add(pLanguage.toLowerCase());
        }
        Collections.sort(textList1);

        Assert.assertEquals(displayed, sorted);
    }
}
