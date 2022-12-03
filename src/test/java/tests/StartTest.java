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



    @Test
    public void testWishesFromTheTeamFirstParagraph () {
        final String WISHES_FROM_THE_TEAM = "This Website holds a collection of the Song 99 Bottles of Beer programmed in different programming languages. " +
                "Actually the song is represented in 1500 different programming languages and variations. " +
                "For more detailed information refer to historic information.";

        String TeamWishes = openBaseURL()
                .getTeamWishes();

        Assert.assertEquals(TeamWishes, WISHES_FROM_THE_TEAM);
    }

}
