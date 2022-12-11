package tests;

import base.BaseTest;
import network.CaptureNetworkTraffic;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.browse_languages.letters.JPage;

import java.util.List;

import static utils.TestUtils.getBaseUrl;

public class API_JTest  extends BaseTest  {

    final static String ACTION = "j.html";
    final static String PAGE_CONTEXT_BEFORE_REQUEST = "Category J";
    final static String attribute = "xref";

    @Test
    public void testAttributes_DefaultValues() {

        JPage jPage = openBaseURL().clickBrowseLanguagesMenu().clickJSubmenu();

        Assert.assertEquals(jPage.getHrefL(attribute), getBaseUrl() + ACTION);
        Assert.assertEquals(jPage.getPageContext(), PAGE_CONTEXT_BEFORE_REQUEST);
    }

    @Test
    public void test_API_HttpRequest_GET() {
        final String expectedMethod = "GET";
        final String expectedEndPoint = "j.html";

        List<String> httpRequest = new CaptureNetworkTraffic()
                .setUpDevTool(getDriver())
                .captureHttpRequests(expectedEndPoint, expectedMethod);

        openBaseURL().clickBrowseLanguagesMenu().clickJSubmenu();

        Assert.assertEquals(httpRequest.get(0), expectedMethod);
        Assert.assertEquals(httpRequest.get(1), getBaseUrl() + expectedEndPoint);
        Assert.assertEquals(httpRequest.get(2), "Optional.empty");
        Assert.assertEquals(httpRequest.get(3), "Optional.empty");
    }

    @Test(dependsOnMethods = "test_API_HttpRequest_GET")
    public void test_API_HttpResponse_GET() {
        final String expectedStatusCode = "200";
        final String expectedStatusText = "OK";
        final String expectedEndPoint = "j.html";
        final double expectedResponseTimeStandard = 3;

        List<String> httpResponse = new CaptureNetworkTraffic()
                .setUpDevTool(getDriver())
                .captureHttpResponses(expectedEndPoint);

        openBaseURL().clickBrowseLanguagesMenu().clickJSubmenu();

        Assert.assertEquals(httpResponse.get(0), expectedStatusCode);
        Assert.assertEquals(httpResponse.get(1), expectedStatusText);
        Assert.assertEquals(httpResponse.get(2), getBaseUrl() + expectedEndPoint);
        Assert.assertTrue(Double.parseDouble(httpResponse.get(3).substring(10, 14)) <= expectedResponseTimeStandard);
    }
}
