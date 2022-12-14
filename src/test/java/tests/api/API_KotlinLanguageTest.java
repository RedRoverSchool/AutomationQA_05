package tests.api;

import base.BaseTest;
import network.CaptureNetworkTraffic;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.browse_languages.languages.KotlinLanguagePage;
import utils.TestUtils;
import java.net.URLEncoder;

import java.util.List;

public class API_KotlinLanguageTest extends BaseTest {

    final static String ACTION = "vote.html";
    final static String METHOD = "post";
    final static String NAME_INPUT_1 = "exampleid";
    final static String VALUE_INPUT1 = "2901";
    final static String NAME_INPUT_2 = "http_referer";
    final static String VALUE_INPUT2 = "/language-kotlin-2901.html";
    final static String NAME_SELECT = "rate";
    final static String VALUE_SELECT = "0";
    final static String NAME_INPUT_4 = "submitcomment";
    final static String VALUE_INPUT4 = "Vote";

    final static String PAYLOAD = NAME_INPUT_1 + "=" + VALUE_INPUT1 + "&" + NAME_INPUT_2 + "="
            + URLEncoder.encode(VALUE_INPUT2) + "&" + NAME_SELECT + "=" + VALUE_SELECT + "&" +  NAME_INPUT_4
            + "=" +  VALUE_INPUT4;
    final static String PAGE_CONTEXT_BEFORE_REQUEST = "Voting\n" + "Error: Please select something.\n" + "Back";

    @Test
    public void testAttributes_DefaultVAlues() {

        KotlinLanguagePage kotlinLanguagePage =
                openBaseURL()
                        .clickBrowseLanguagesMenu()
                        .clickKSubmenu()
                        .clickKotlinLanguage();

        Assert.assertEquals(kotlinLanguagePage.getAction(), TestUtils.getBaseUrl() + ACTION);
        Assert.assertEquals(kotlinLanguagePage.getMethod(), METHOD);
        Assert.assertEquals(kotlinLanguagePage.getInput1Name(), NAME_INPUT_1);
        Assert.assertEquals(kotlinLanguagePage.getInput1Value(), VALUE_INPUT1);
        Assert.assertEquals(kotlinLanguagePage.getInput2Name(), NAME_INPUT_2);
        Assert.assertEquals(kotlinLanguagePage.getInput2Value(), VALUE_INPUT2);
        Assert.assertEquals(kotlinLanguagePage.getSelect3Name(), NAME_SELECT);
        Assert.assertEquals(kotlinLanguagePage.getSelect3Value(), VALUE_SELECT);
        Assert.assertEquals(kotlinLanguagePage.getInput4Name(), NAME_INPUT_4);
        Assert.assertEquals(kotlinLanguagePage.getInput4Value(), VALUE_INPUT4);
    }

    @Test
    public void test_API_HttpRequest_POST() {
        final String expectedMethod = "POST";
        final String expectedEndPoint = "vote.html";
        final String expectedPayLoad = PAYLOAD;

        List<String> httpRequest = new CaptureNetworkTraffic()
                .setUpDevTool(getDriver())
                .captureHttpRequests(ACTION, METHOD.toUpperCase());

        openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickKSubmenu()
                .clickKotlinLanguage()
                .clickVoteButton();

        Assert.assertEquals(httpRequest.get(0), expectedMethod);
        Assert.assertEquals(httpRequest.get(1), TestUtils.getBaseUrl() + expectedEndPoint);
        Assert.assertEquals(httpRequest.get(2).substring(9, 91), expectedPayLoad);
        Assert.assertEquals(httpRequest.get(3), "Optional.empty");
    }

    @Test(dependsOnMethods = "test_API_HttpRequest_POST")
    public void test_API_HttpResponse_POST() {
        final String expectedStatusCode = "200";
        final String expectedStatusText = "OK";
        final String expectedEndPoint = "vote.html";
        final double expectedResponseTimeStatndart = 3;

        List<String> httpResponse = new CaptureNetworkTraffic()
                .setUpDevTool(getDriver())
                .captureHttpResponses(TestUtils.getBaseUrl() + expectedEndPoint);

        KotlinLanguagePage kotlinLanguagePage = openBaseURL()
                    .clickBrowseLanguagesMenu()
                    .clickKSubmenu()
                    .clickKotlinLanguage()
                    .clickVoteButton();

        Assert.assertEquals(httpResponse.get(0), expectedStatusCode);
        Assert.assertEquals(httpResponse.get(1), expectedStatusText);
        Assert.assertEquals(httpResponse.get(2), TestUtils.getBaseUrl() + expectedEndPoint);
        Assert.assertTrue(Double.parseDouble(httpResponse.get(3).substring(10, 14)) <= expectedResponseTimeStatndart);
        Assert.assertEquals(kotlinLanguagePage.getPageContext(), PAGE_CONTEXT_BEFORE_REQUEST);
    }
}
