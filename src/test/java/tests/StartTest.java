package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.TestUtils;

import static utils.TestUtils.getBaseUrl;

public class StartTest extends BaseTest {

    @Test
    public void testClickStartFromHomepage(){

        String urlAfterClickingStartFromHomepage =
                openBaseURL()
                        .clickStartMenu()
                        .getURL();

        Assert.assertEquals(urlAfterClickingStartFromHomepage, getBaseUrl());
    }

    @Test
    public void testBaseURLShown_WhenLandingToStartPage(){
        final String expectedUrl = getBaseUrl();

        String actualUrl =
                openBaseURL()
                        .clickSearchLanguagesMenu()
                        .clickStartMenu()
                        .getURL();

        Assert.assertEquals(actualUrl, expectedUrl);
    }
}
