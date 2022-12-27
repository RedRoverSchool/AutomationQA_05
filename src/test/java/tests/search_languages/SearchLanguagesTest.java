package tests.search_languages;

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
                        .clearSearchForField()
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
        final String LANGUAGE_NAME = "";

        String actualPageContext =
                openBaseURL()
                        .clickSearchLanguagesMenu()
                        .clickSearchForField()
                        .inputSearchCriteria(LANGUAGE_NAME)
                        .clickGoButton()
                        .getPageContext();

        Assert.assertFalse(actualPageContext.contains("Language Author Date Comments Rate"));
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

        for (String languagesName : languagesNames) {
            Assert.assertTrue(languagesName.contains(LANGUAGE_NAME));
        }
    }

    @Test
    public void testSearchForLanguagesNameEmpty() {
        int languagesCount =
                openBaseURL()
                        .clickSearchLanguagesMenu()
                        .clickGoButton()
                        .getSize();

        Assert.assertEquals(languagesCount, 0);
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
                        .getSize();

        Assert.assertEquals(languagesNamesSize, 0);
    }

    @Test
    public void testTwoCharactersInputReturnsLanguageListWithThoseCharacters() {
        final String TWO_CHARACTERS = "py";

        List<String> pyLanguagesNames = openBaseURL()
                .clickSearchLanguagesMenu()
                .clickSearchForField()
                .inputSearchCriteria(TWO_CHARACTERS)
                .clickGoButton()
                .getNamesInLowerCase();

        Assert.assertTrue(pyLanguagesNames.contains(TWO_CHARACTERS));
    }
}
