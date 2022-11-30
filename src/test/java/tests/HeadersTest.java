package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HeadersTest extends BaseTest {

    @Test
    public void testHeaderH1OnStartPage() {
        final String HEADER_H1_TEXT = "99 Bottles of Beer";

        Assert.assertEquals(openBaseURL().getTextHeaderH1(),HEADER_H1_TEXT);
    }

    @Test
    public void testHeaderH2OnStartPage() {
        final String HEADER_H2_TEXT = "one program in 1500 variations";

        Assert.assertEquals(openBaseURL().getTextHeaderH2(),HEADER_H2_TEXT);
    }
}
