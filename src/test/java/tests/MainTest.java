package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MainTest extends BaseTest {

    @Test
    public void testH1Header() {
        final String EXPECTED_H1_HEADER = "99 Bottles of Beer";

        String actualResultH1Header = openBaseURL().getH1HeaderText();

        Assert.assertEquals(actualResultH1Header,EXPECTED_H1_HEADER);
    }

    @Test
    public void testH2Header() {
        final String EXPECTED_H2_HEADER = "one program in 1500 variations";

        String actualResultH2Header = openBaseURL().getH2HeaderText();

        Assert.assertEquals(actualResultH2Header,EXPECTED_H2_HEADER);
    }
}
