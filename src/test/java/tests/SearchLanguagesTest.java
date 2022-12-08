package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SearchLanguagesTest extends BaseTest {

    @Test
    public void testSearchForLanguageByName() {
        final String LANGUAGE_NAME = "python";

        List<String> languagesNames =
                openBaseURL()
                        .clickSearchLanguagesMenu()
                        .clickSearchForField()
                        .inputSearchCriteria(LANGUAGE_NAME)
                        .clickGoButton()
                        .getNamesInLowerCase();

        Assert.assertTrue(languagesNames.size() > 0);

        for (String languageName : languagesNames) {
            Assert.assertTrue(languageName.contains(LANGUAGE_NAME));
        }
    }

    @Test
    public void testSearchForLanguageEmptyField() {
        final String LANGUAGE_NAME = "Python";

        int languagesNamesSize =
                openBaseURL()
                        .clickSearchLanguagesMenu()
                        .clickSearchForField()
                        .inputSearchCriteria(LANGUAGE_NAME)
                        .clickGoButton()
                        .clearSearchForField()
                        .clickGoButton()
                        .getNamesListSize();

        Assert.assertTrue(languagesNamesSize == 0);
    }

    @Test
    public void testSearchForLanguagesByNameJava() {

        final String LANGUAGE_NAME = "java";

        List<String> languagesNames =
                openBaseURL()
                        .clickSearchLanguagesMenu()
                        .clickSearchForField()
                        .inputSearchCriteria(LANGUAGE_NAME)
                        .clickGoButton()
                        .getNamesInLowerCase();

        Assert.assertTrue(languagesNames.size() > 0);

        for (String languagesName : languagesNames){
            Assert.assertTrue(languagesName.contains(LANGUAGE_NAME));
        }
    }

    @Test
    public void testSearchForLanguagesNameEmpty() {

        int languagesNames =
                openBaseURL()
                        .clickSearchLanguagesMenu()
                        .clickGoButton()
                        .getNamesListSize();

        Assert.assertTrue(languagesNames == 0);
    }

    @Test
    public void testSearchForLanguageNameSubmenuNewSearch() {
        final String LANGUAGE_NAME = "Java";

        int languagesNamesSize =
                openBaseURL()
                        .clickSearchLanguagesMenu()
                        .clickSearchForField()
                        .inputSearchCriteria(LANGUAGE_NAME)
                        .clickGoButton()
                        .clickSearchSubmenu()
                        .getNamesListSize();

        Assert.assertTrue(languagesNamesSize == 0);
    }
}
