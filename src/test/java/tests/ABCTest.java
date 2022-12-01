package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ABCTest extends BaseTest {

    @Test
    public void testDefaultHeaderForABCPage() {
        final String EXPECTED_H2_HEADER = "Category A";

        String actualH2Header = openBaseURL()
                .clickBrowseLanguagesMenu()
                .getH2Header();

        Assert.assertEquals(actualH2Header, EXPECTED_H2_HEADER);
    }
}
