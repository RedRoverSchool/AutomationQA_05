package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.browse_languages.languages.KotlinLanguagePage;

public class API_KotlinLanguageTest extends BaseTest {


    final static String ACTION = "vote.html";
    final static String METHOD = "post";
    final static String NAME_INPUT_1 = "exampleid";
    final static String VALUE_INPUT1 = "2901";

    final static String NAME_INPUT_2 = "http_referer";
    final static String VALUE_INPUT2 = "language-kotlin-2901.html";

    final static String NAME_SELECT = "rate";
    final static String VALUE_ISELECT = "0";

    final static String NAME_INPUT_4 = "submitcomment";
        final static String VALUE_INPUT4 = "Vote";

//exampleid=2901&http_referer=%2Flanguage-kotlin-2901.html&rate=0&submitcomment=Vote
    final static String PAYLOAD = NAME_INPUT_1 + "=" + VALUE_INPUT1 + "&" + NAME_INPUT_2 + "=" + "%2F" + VALUE_INPUT2
            + "&" + NAME_SELECT + "=" + VALUE_ISELECT + "&" +  NAME_INPUT_4 + "=" +  VALUE_INPUT4;
    final static String PAGE_CONTEXT_BEFORE_REQUEST = "Search Languages\n" + "Search for:";

    @Test
    public void testAttributes_DefaultVAlues() {

        KotlinLanguagePage kotlinLanguagePage =
                openBaseURL()
                        .clickBrowseLanguagesMenu()
                        .clickKSubmenu()
                        .clickKotlinLink();

        Assert.assertTrue(kotlinLanguagePage.);
        Assert.assertTrue(kotlinLanguagePage);
        Assert.assertTrue(kotlinLanguagePage);
        Assert.assertTrue(kotlinLanguagePage);
        Assert.assertTrue(kotlinLanguagePage);
        Assert.assertTrue(kotlinLanguagePage);

    }


}
