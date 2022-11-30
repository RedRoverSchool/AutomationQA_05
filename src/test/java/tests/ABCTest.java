package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ABCTest extends BaseTest {

    @Test
    public void testBrowseLanguagesDefaultValue_HappyPath() {
        final String BROWSE_LANGUAGES_DEFAULT_VALUE = "Category A";

       String H2Text =  openBaseURL()
                .clickBrowseLanguagesMenu()
                        .getH2Text();

        Assert.assertEquals(H2Text, BROWSE_LANGUAGES_DEFAULT_VALUE);
    }
}
