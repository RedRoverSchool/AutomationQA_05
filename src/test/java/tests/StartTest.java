package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.TestUtils;

public class StartTest extends BaseTest {

    @Test
    public void testClickStartFromHomepage(){
        String urlAfterClickingStartFromHomepage =
                openBaseURL()
                        .clickStartMenu()
                        .getExternalPageURL();

        Assert.assertEquals(urlAfterClickingStartFromHomepage, TestUtils.getBaseUrl());
    }

}
