package tests.api;

import base.BaseTest;
import network.CaptureNetworkTraffic;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.browse_languages.letters.JPage;

import java.util.List;

import static utils.TestUtils.getBaseUrl;

public class API_JTest  extends BaseTest  {

    final static String ACTION = "j.html";
    final static String PAGE_CONTEXT_BEFORE_REQUEST = "";
    final static String attribute = "xref";

    @Test
    public void testAttributes_DefaultValues() {
        String PAGE_CONTEXT_BEFORE_REQUEST = "Category J\n" +
                "All languages starting with the letter J are shown, sorted by Language.\n" +
                "Language Author Date Comments Rate\n" +
                "J Roger Hui 04/20/05 6\n" +
                "jamal Feherke 10/11/05 0\n" +
                "Jamfile David Brandon 04/20/05 0\n" +
                "Java Anonymous 04/20/05 33\n" +
                "Java 2 Micro Edition Stefan Scheler 04/20/05 0\n" +
                "Java Servlet Gregor Scheithauer 05/08/05 0\n" +
                "JavaFX Filip Dreger 04/13/09 0\n" +
                "JavaScript JavaScribe 01/09/09 4\n" +
                "jBase PROC dbell 01/05/06 0\n" +
                "JBPM Easy 06/25/10 0\n" +
                "JCL Anonymous 04/20/05 3\n" +
                "JOSS Laurent Vogel 04/20/05 0\n" +
                "Joy inforichland 07/05/09 0\n" +
                "jQuery Vincent Battaglia 12/27/06 1\n" +
                "JR Aaron Keen 01/02/06 0\n" +
                "JScript Philipp Winterberg 04/20/05 2\n" +
                "JScript/NET Chris R. Timmons 04/20/05 0\n" +
                "JSP Davy Boy Hayes 01/24/06 0\n" +
                "JSTL Dave Johnston 03/07/06 0\n" +
                "Julie - Chapel (AKA Julie4Chapel) Fahad Khan 05/08/07 0\n" +
                "JustBasic John Fredrickson 02/21/06 1\n" +
                "Justif Marinus Oosters 07/30/10 0";

        JPage jPage = openBaseURL().clickBrowseLanguagesMenu().clickJSubmenu();

        Assert.assertEquals(jPage.getHrefJ(), getBaseUrl() + ACTION);
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
