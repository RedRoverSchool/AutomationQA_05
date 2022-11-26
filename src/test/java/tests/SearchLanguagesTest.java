package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SearchLanguagesPage;
import pages.StartPage;

import java.util.List;

public class SearchLanguagesTest extends BaseTest {

    @Test
    public void testSearchForLanguageByNamePOM1() {
        final String LANGUAGE_NAME = "python";

        openBaseURL();
        StartPage startPage = new StartPage(getDriver());

        startPage.clickSearchLanguagesMenu();

        SearchLanguagesPage searchLanguagesPage = new SearchLanguagesPage(getDriver());

        searchLanguagesPage.clickSearchForField();
        searchLanguagesPage.inputSearchCriteria(LANGUAGE_NAME);
        searchLanguagesPage.clickGoButton();

        List<String> languagesNames = searchLanguagesPage.getNamesInLowerCase();

        Assert.assertTrue(languagesNames.size() > 0);

        for (String languageName : languagesNames) {
            Assert.assertTrue(languageName.contains(LANGUAGE_NAME));
        }
    }

    @Test
    public void testSearchForLanguageByNamePOM2() {
        final String LANGUAGE_NAME = "python";

        List<String> languagesNames =
                openBaseURLPOM2()
                        .clickSearchLanguagesMenuPOM2()
                        .clickSearchForFieldPOM2()
                        .inputSearchCriteriaPOM2(LANGUAGE_NAME)
                        .clickGoButtonPOM2()
                        .getNamesInLowerCase();

        Assert.assertTrue(languagesNames.size() > 0);

        for (String languageName : languagesNames) {
            Assert.assertTrue(languageName.contains(LANGUAGE_NAME));
        }
    }

    @Test
    public void testSearchForLanguageByNamePOM3() {
        final String LANGUAGE_NAME = "python";

        List<String> languagesNames =
                openBaseURLPOM2()
                        .clickSearchLanguagesMenuPOM3()
                        .clickSearchForFieldPOM3()
                        .inputSearchCriteriaPOM3(LANGUAGE_NAME)
                        .clickGoButtonPOM3()
                        .getNamesInLowerCasePOM3();

        Assert.assertTrue(languagesNames.size() > 0);

        for (String languageName : languagesNames) {
            Assert.assertTrue(languageName.contains(LANGUAGE_NAME));
        }
    }
}
